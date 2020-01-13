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
import com.baidu.live.data.t;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.baidu.live.u.a {
    private t fxv;
    private t fxw;
    private boolean fxu = true;
    private int fxx = -1;
    private int fxy = 0;
    private int fxz = 0;
    private boolean fxA = true;
    private HttpMessageListener fxa = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.b(alaTaskRewardHttpResponsedMessage.fwX);
                }
            }
        }
    };
    private HttpMessageListener fxB = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof AlaCommitTaskHttpResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.fxA = false;
                    if (b.this.fxz < 3) {
                        b.b(b.this);
                        b.this.brV();
                        return;
                    }
                    return;
                }
                b.this.fxA = true;
                b.this.fxz = 0;
            }
        }
    };
    private CustomMessageListener eKK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.fxy <= 0 && !b.this.fxA) {
                b.this.brV();
            }
        }
    };
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.fxy > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.brV();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.fxy)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.fxz;
        bVar.fxz = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.fxy;
        bVar.fxy = i - 1;
        return i;
    }

    public b() {
        brU();
        MessageManager.getInstance().registerListener(this.fxB);
        MessageManager.getInstance().registerListener(this.fxa);
        MessageManager.getInstance().registerListener(this.eKK);
    }

    private static void brU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.TJ);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCommitTaskHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.u.a
    public void a(u uVar) {
        if (uVar != null) {
            b(uVar);
        }
    }

    public void b(u uVar) {
        t pS;
        if (uVar != null && uVar.Zl >= 0 && uVar.Zl != 0 && uVar.Zl <= 3 && (pS = uVar.pS()) != null) {
            b(pS);
        }
    }

    @Override // com.baidu.live.u.a
    public void v(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            t tVar = new t();
            if (optJSONObject != null) {
                tVar.parseJson(optJSONObject);
            }
            if (tVar.pP() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(tVar);
            }
            b(tVar);
        }
    }

    @Override // com.baidu.live.u.a
    public void bb(boolean z) {
        this.fxu = z;
        if (z && this.fxv != null) {
            a(this.fxv);
        }
    }

    public void a(t tVar) {
        if (tVar != null && tVar.Zi != null) {
            if (this.fxu) {
                this.fxv = null;
                int i = tVar.Zi.Zo;
                if (i > c.oJ().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.d.a aVar = new com.baidu.tieba.ala.d.a(BdActivityStack.getInst().currentActivity());
                    c.oJ().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.w(String.valueOf(tVar.Zj), String.valueOf(tVar.Zi.Zo), tVar.Zi.pT());
                    aVar.show();
                    return;
                }
                return;
            }
            this.fxv = tVar;
        }
    }

    private void b(t tVar) {
        if (tVar != null && tVar.pO()) {
            if (tVar.status == 1) {
                c(tVar);
            } else {
                if (tVar.status == 3) {
                }
            }
        }
    }

    private void c(t tVar) {
        int i;
        if (tVar.Zi != null && (i = tVar.Zi.Zn) != this.fxx) {
            this.fxw = tVar;
            this.fxx = i;
            this.fxy = this.fxx;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.fxy > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brV() {
        if (this.fxw != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.fxw.Ze);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.u.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.fxa);
        MessageManager.getInstance().unRegisterListener(this.fxB);
        MessageManager.getInstance().unRegisterListener(this.eKK);
    }
}
