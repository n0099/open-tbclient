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
import com.baidu.live.data.an;
import com.baidu.live.data.ao;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.ah.a {
    private an hVf;
    private an hVg;
    private boolean hVe = true;
    private int hVh = -1;
    private int hVi = 0;
    private int hVj = 0;
    private boolean hVk = true;
    private HttpMessageListener hUM = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.hUJ);
                }
            }
        }
    };
    private HttpMessageListener hVl = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.hVk = false;
                    if (b.this.hVj < 3) {
                        b.b(b.this);
                        b.this.cpc();
                        return;
                    }
                    return;
                }
                b.this.hVk = true;
                b.this.hVj = 0;
            }
        }
    };
    private CustomMessageListener hdn = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.hVi <= 0 && !b.this.hVk) {
                b.this.cpc();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.hVi > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.cpc();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.hVi)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.hVj;
        bVar.hVj = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.hVi;
        bVar.hVi = i - 1;
        return i;
    }

    public b() {
        cpb();
        MessageManager.getInstance().registerListener(this.hVl);
        MessageManager.getInstance().registerListener(this.hUM);
        MessageManager.getInstance().registerListener(this.hdn);
    }

    private static void cpb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.b.aAD);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ah.a
    public void i(w wVar) {
        if (wVar != null && wVar.aKF != null) {
            a(wVar.aKF);
        }
    }

    public void a(ao aoVar) {
        an FK;
        if (aoVar != null && aoVar.aOZ >= 0 && aoVar.aOZ != 0 && aoVar.aOZ <= 3 && (FK = aoVar.FK()) != null) {
            b(FK);
        }
    }

    @Override // com.baidu.live.ah.a
    public void R(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            an anVar = new an();
            if (optJSONObject != null) {
                anVar.parseJson(optJSONObject);
            }
            if (anVar.FH() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(anVar);
            }
            b(anVar);
        }
    }

    @Override // com.baidu.live.ah.a
    public void cV(boolean z) {
        this.hVe = z;
        if (z && this.hVf != null) {
            a(this.hVf);
        }
    }

    public void a(an anVar) {
        if (anVar != null && anVar.aOW != null) {
            if (this.hVe) {
                this.hVf = null;
                int i = anVar.aOW.aPc;
                if (i > d.BM().getInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.f.a aVar = new com.baidu.tieba.ala.f.a(BdActivityStack.getInst().currentActivity());
                    d.BM().putInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.z(String.valueOf(anVar.aOX), String.valueOf(anVar.aOW.aPc), anVar.aOW.FL());
                    aVar.show();
                    return;
                }
                return;
            }
            this.hVf = anVar;
        }
    }

    private void b(an anVar) {
        if (anVar != null && anVar.FG() && anVar.status == 1) {
            c(anVar);
        }
    }

    private void c(an anVar) {
        int i;
        if (anVar.aOW != null && (i = anVar.aOW.aPb) != this.hVh) {
            this.hVg = anVar;
            this.hVh = i;
            this.hVi = this.hVh;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.hVi > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpc() {
        if (this.hVg != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.hVg.aOS);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.ah.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.hUM);
        MessageManager.getInstance().unRegisterListener(this.hVl);
        MessageManager.getInstance().unRegisterListener(this.hdn);
    }
}
