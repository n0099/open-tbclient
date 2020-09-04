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
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.data.r;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.baidu.live.y.a {
    private ad gZL;
    private ad gZM;
    private boolean gZK = true;
    private int gZN = -1;
    private int gZO = 0;
    private int gZP = 0;
    private boolean gZQ = true;
    private HttpMessageListener gZr = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.gZo);
                }
            }
        }
    };
    private HttpMessageListener gZR = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.gZQ = false;
                    if (b.this.gZP < 3) {
                        b.b(b.this);
                        b.this.cal();
                        return;
                    }
                    return;
                }
                b.this.gZQ = true;
                b.this.gZP = 0;
            }
        }
    };
    private CustomMessageListener gkG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.gZO <= 0 && !b.this.gZQ) {
                b.this.cal();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.gZO > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.cal();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.gZO)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.gZP;
        bVar.gZP = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.gZO;
        bVar.gZO = i - 1;
        return i;
    }

    public b() {
        cak();
        MessageManager.getInstance().registerListener(this.gZR);
        MessageManager.getInstance().registerListener(this.gZr);
        MessageManager.getInstance().registerListener(this.gkG);
    }

    private static void cak() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.ayD);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.y.a
    public void j(r rVar) {
        if (rVar != null && rVar.aEp != null) {
            a(rVar.aEp);
        }
    }

    public void a(ae aeVar) {
        ad CQ;
        if (aeVar != null && aeVar.aHH >= 0 && aeVar.aHH != 0 && aeVar.aHH <= 3 && (CQ = aeVar.CQ()) != null) {
            b(CQ);
        }
    }

    @Override // com.baidu.live.y.a
    public void N(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            ad adVar = new ad();
            if (optJSONObject != null) {
                adVar.parseJson(optJSONObject);
            }
            if (adVar.CN() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(adVar);
            }
            b(adVar);
        }
    }

    @Override // com.baidu.live.y.a
    public void cp(boolean z) {
        this.gZK = z;
        if (z && this.gZL != null) {
            a(this.gZL);
        }
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.aHE != null) {
            if (this.gZK) {
                this.gZL = null;
                int i = adVar.aHE.aHK;
                if (i > c.AD().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.e.a aVar = new com.baidu.tieba.ala.e.a(BdActivityStack.getInst().currentActivity());
                    c.AD().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.x(String.valueOf(adVar.aHF), String.valueOf(adVar.aHE.aHK), adVar.aHE.CR());
                    aVar.show();
                    return;
                }
                return;
            }
            this.gZL = adVar;
        }
    }

    private void b(ad adVar) {
        if (adVar != null && adVar.CM() && adVar.status == 1) {
            c(adVar);
        }
    }

    private void c(ad adVar) {
        int i;
        if (adVar.aHE != null && (i = adVar.aHE.aHJ) != this.gZN) {
            this.gZM = adVar;
            this.gZN = i;
            this.gZO = this.gZN;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.gZO > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cal() {
        if (this.gZM != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.gZM.aHA);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.y.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.gZr);
        MessageManager.getInstance().unRegisterListener(this.gZR);
        MessageManager.getInstance().unRegisterListener(this.gkG);
    }
}
