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
import com.baidu.live.data.u;
import com.baidu.live.data.v;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.x.a {
    private u fAQ;
    private u fAR;
    private boolean fAP = true;
    private int fAS = -1;
    private int fAT = 0;
    private int fAU = 0;
    private boolean fAV = true;
    private HttpMessageListener fAy = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.b(alaTaskRewardHttpResponsedMessage.fAv);
                }
            }
        }
    };
    private HttpMessageListener fAW = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof AlaCommitTaskHttpResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.fAV = false;
                    if (b.this.fAU < 3) {
                        b.b(b.this);
                        b.this.btH();
                        return;
                    }
                    return;
                }
                b.this.fAV = true;
                b.this.fAU = 0;
            }
        }
    };
    private CustomMessageListener ePv = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.fAT <= 0 && !b.this.fAV) {
                b.this.btH();
            }
        }
    };
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.fAT > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.btH();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.fAT)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.fAU;
        bVar.fAU = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.fAT;
        bVar.fAT = i - 1;
        return i;
    }

    public b() {
        btG();
        MessageManager.getInstance().registerListener(this.fAW);
        MessageManager.getInstance().registerListener(this.fAy);
        MessageManager.getInstance().registerListener(this.ePv);
    }

    private static void btG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.Vz);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCommitTaskHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.x.a
    public void a(v vVar) {
        if (vVar != null) {
            b(vVar);
        }
    }

    public void b(v vVar) {
        u qI;
        if (vVar != null && vVar.abo >= 0 && vVar.abo != 0 && vVar.abo <= 3 && (qI = vVar.qI()) != null) {
            b(qI);
        }
    }

    @Override // com.baidu.live.x.a
    public void v(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            u uVar = new u();
            if (optJSONObject != null) {
                uVar.parseJson(optJSONObject);
            }
            if (uVar.qF() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(uVar);
            }
            b(uVar);
        }
    }

    @Override // com.baidu.live.x.a
    public void bk(boolean z) {
        this.fAP = z;
        if (z && this.fAQ != null) {
            a(this.fAQ);
        }
    }

    public void a(u uVar) {
        if (uVar != null && uVar.abl != null) {
            if (this.fAP) {
                this.fAQ = null;
                int i = uVar.abl.abr;
                if (i > c.pw().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.d.a aVar = new com.baidu.tieba.ala.d.a(BdActivityStack.getInst().currentActivity());
                    c.pw().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.x(String.valueOf(uVar.abm), String.valueOf(uVar.abl.abr), uVar.abl.qJ());
                    aVar.show();
                    return;
                }
                return;
            }
            this.fAQ = uVar;
        }
    }

    private void b(u uVar) {
        if (uVar != null && uVar.qE() && uVar.status == 1) {
            c(uVar);
        }
    }

    private void c(u uVar) {
        int i;
        if (uVar.abl != null && (i = uVar.abl.abq) != this.fAS) {
            this.fAR = uVar;
            this.fAS = i;
            this.fAT = this.fAS;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.fAT > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btH() {
        if (this.fAR != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.fAR.abh);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.x.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.fAy);
        MessageManager.getInstance().unRegisterListener(this.fAW);
        MessageManager.getInstance().unRegisterListener(this.ePv);
    }
}
