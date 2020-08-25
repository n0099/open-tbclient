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
    private ad gZH;
    private ad gZI;
    private boolean gZG = true;
    private int gZJ = -1;
    private int gZK = 0;
    private int gZL = 0;
    private boolean gZM = true;
    private HttpMessageListener gZn = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.gZk);
                }
            }
        }
    };
    private HttpMessageListener gZN = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.gZM = false;
                    if (b.this.gZL < 3) {
                        b.b(b.this);
                        b.this.cak();
                        return;
                    }
                    return;
                }
                b.this.gZM = true;
                b.this.gZL = 0;
            }
        }
    };
    private CustomMessageListener gkC = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.gZK <= 0 && !b.this.gZM) {
                b.this.cak();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.gZK > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.cak();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.gZK)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.gZL;
        bVar.gZL = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.gZK;
        bVar.gZK = i - 1;
        return i;
    }

    public b() {
        caj();
        MessageManager.getInstance().registerListener(this.gZN);
        MessageManager.getInstance().registerListener(this.gZn);
        MessageManager.getInstance().registerListener(this.gkC);
    }

    private static void caj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.ayB);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.y.a
    public void j(r rVar) {
        if (rVar != null && rVar.aEn != null) {
            a(rVar.aEn);
        }
    }

    public void a(ae aeVar) {
        ad CQ;
        if (aeVar != null && aeVar.aHF >= 0 && aeVar.aHF != 0 && aeVar.aHF <= 3 && (CQ = aeVar.CQ()) != null) {
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
    public void co(boolean z) {
        this.gZG = z;
        if (z && this.gZH != null) {
            a(this.gZH);
        }
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.aHC != null) {
            if (this.gZG) {
                this.gZH = null;
                int i = adVar.aHC.aHI;
                if (i > c.AD().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.e.a aVar = new com.baidu.tieba.ala.e.a(BdActivityStack.getInst().currentActivity());
                    c.AD().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.x(String.valueOf(adVar.aHD), String.valueOf(adVar.aHC.aHI), adVar.aHC.CR());
                    aVar.show();
                    return;
                }
                return;
            }
            this.gZH = adVar;
        }
    }

    private void b(ad adVar) {
        if (adVar != null && adVar.CM() && adVar.status == 1) {
            c(adVar);
        }
    }

    private void c(ad adVar) {
        int i;
        if (adVar.aHC != null && (i = adVar.aHC.aHH) != this.gZJ) {
            this.gZI = adVar;
            this.gZJ = i;
            this.gZK = this.gZJ;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.gZK > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cak() {
        if (this.gZI != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.gZI.aHy);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.y.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.gZn);
        MessageManager.getInstance().unRegisterListener(this.gZN);
        MessageManager.getInstance().unRegisterListener(this.gkC);
    }
}
