package com.baidu.tieba.ala.taskview;

import android.os.Handler;
import com.baidu.live.adp.base.BdActivityStack;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.c;
import com.baidu.live.data.aa;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.x.a {
    private aa guB;
    private aa guC;
    private boolean guA = true;
    private int guD = -1;
    private int guE = 0;
    private int guF = 0;
    private boolean guG = true;
    private HttpMessageListener gui = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.b(alaTaskRewardHttpResponsedMessage.guf);
                }
            }
        }
    };
    private HttpMessageListener guH = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof AlaCommitTaskHttpResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.guG = false;
                    if (b.this.guF < 3) {
                        b.b(b.this);
                        b.this.bJK();
                        return;
                    }
                    return;
                }
                b.this.guG = true;
                b.this.guF = 0;
            }
        }
    };
    private CustomMessageListener fIc = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.guE <= 0 && !b.this.guG) {
                b.this.bJK();
            }
        }
    };
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.guE > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.bJK();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.guE)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.guF;
        bVar.guF = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.guE;
        bVar.guE = i - 1;
        return i;
    }

    public b() {
        bJJ();
        MessageManager.getInstance().registerListener(this.guH);
        MessageManager.getInstance().registerListener(this.gui);
        MessageManager.getInstance().registerListener(this.fIc);
    }

    private static void bJJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.ask);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCommitTaskHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.x.a
    public void a(ab abVar) {
        if (abVar != null) {
            b(abVar);
        }
    }

    public void b(ab abVar) {
        aa wn;
        if (abVar != null && abVar.ayR >= 0 && abVar.ayR != 0 && abVar.ayR <= 3 && (wn = abVar.wn()) != null) {
            b(wn);
        }
    }

    @Override // com.baidu.live.x.a
    public void G(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            aa aaVar = new aa();
            if (optJSONObject != null) {
                aaVar.parseJson(optJSONObject);
            }
            if (aaVar.wk() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(aaVar);
            }
            b(aaVar);
        }
    }

    @Override // com.baidu.live.x.a
    public void bY(boolean z) {
        this.guA = z;
        if (z && this.guB != null) {
            a(this.guB);
        }
    }

    public void a(aa aaVar) {
        if (aaVar != null && aaVar.ayO != null) {
            if (this.guA) {
                this.guB = null;
                int i = aaVar.ayO.ayU;
                if (i > c.uN().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.e.a aVar = new com.baidu.tieba.ala.e.a(BdActivityStack.getInst().currentActivity());
                    c.uN().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.y(String.valueOf(aaVar.ayP), String.valueOf(aaVar.ayO.ayU), aaVar.ayO.wo());
                    aVar.show();
                    return;
                }
                return;
            }
            this.guB = aaVar;
        }
    }

    private void b(aa aaVar) {
        if (aaVar != null && aaVar.wj() && aaVar.status == 1) {
            c(aaVar);
        }
    }

    private void c(aa aaVar) {
        int i;
        if (aaVar.ayO != null && (i = aaVar.ayO.ayT) != this.guD) {
            this.guC = aaVar;
            this.guD = i;
            this.guE = this.guD;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.guE > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJK() {
        if (this.guC != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.guC.ayK);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.x.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.gui);
        MessageManager.getInstance().unRegisterListener(this.guH);
        MessageManager.getInstance().unRegisterListener(this.fIc);
    }
}
