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
import com.baidu.live.d;
import com.baidu.live.data.am;
import com.baidu.live.data.an;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.ad.a {
    private am hKE;
    private am hKF;
    private boolean hKD = true;
    private int hKG = -1;
    private int hKH = 0;
    private int hKI = 0;
    private boolean hKJ = true;
    private HttpMessageListener hKl = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.hKi);
                }
            }
        }
    };
    private HttpMessageListener hKK = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.hKJ = false;
                    if (b.this.hKI < 3) {
                        b.b(b.this);
                        b.this.clu();
                        return;
                    }
                    return;
                }
                b.this.hKJ = true;
                b.this.hKI = 0;
            }
        }
    };
    private CustomMessageListener gUt = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.hKH <= 0 && !b.this.hKJ) {
                b.this.clu();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.hKH > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.clu();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.hKH)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.hKI;
        bVar.hKI = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.hKH;
        bVar.hKH = i - 1;
        return i;
    }

    public b() {
        clt();
        MessageManager.getInstance().registerListener(this.hKK);
        MessageManager.getInstance().registerListener(this.hKl);
        MessageManager.getInstance().registerListener(this.gUt);
    }

    private static void clt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.b.azT);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ad.a
    public void i(w wVar) {
        if (wVar != null && wVar.aJE != null) {
            a(wVar.aJE);
        }
    }

    public void a(an anVar) {
        am EI;
        if (anVar != null && anVar.aNN >= 0 && anVar.aNN != 0 && anVar.aNN <= 3 && (EI = anVar.EI()) != null) {
            b(EI);
        }
    }

    @Override // com.baidu.live.ad.a
    public void V(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            am amVar = new am();
            if (optJSONObject != null) {
                amVar.parseJson(optJSONObject);
            }
            if (amVar.EF() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(amVar);
            }
            b(amVar);
        }
    }

    @Override // com.baidu.live.ad.a
    public void cF(boolean z) {
        this.hKD = z;
        if (z && this.hKE != null) {
            a(this.hKE);
        }
    }

    public void a(am amVar) {
        if (amVar != null && amVar.aNK != null) {
            if (this.hKD) {
                this.hKE = null;
                int i = amVar.aNK.aNQ;
                if (i > d.AZ().getInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.f.a aVar = new com.baidu.tieba.ala.f.a(BdActivityStack.getInst().currentActivity());
                    d.AZ().putInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.y(String.valueOf(amVar.aNL), String.valueOf(amVar.aNK.aNQ), amVar.aNK.EJ());
                    aVar.show();
                    return;
                }
                return;
            }
            this.hKE = amVar;
        }
    }

    private void b(am amVar) {
        if (amVar != null && amVar.EE() && amVar.status == 1) {
            c(amVar);
        }
    }

    private void c(am amVar) {
        int i;
        if (amVar.aNK != null && (i = amVar.aNK.aNP) != this.hKG) {
            this.hKF = amVar;
            this.hKG = i;
            this.hKH = this.hKG;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.hKH > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clu() {
        if (this.hKF != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.hKF.aNG);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.ad.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.hKl);
        MessageManager.getInstance().unRegisterListener(this.hKK);
        MessageManager.getInstance().unRegisterListener(this.gUt);
    }
}
