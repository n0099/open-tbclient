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
import com.baidu.live.data.ab;
import com.baidu.live.data.at;
import com.baidu.live.data.au;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.ag.a {
    private at ihP;
    private at ihQ;
    private boolean ihO = true;
    private int ihR = -1;
    private int ihS = 0;
    private int ihT = 0;
    private boolean ihU = true;
    private HttpMessageListener ihw = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.iht);
                }
            }
        }
    };
    private HttpMessageListener ihV = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.ihU = false;
                    if (b.this.ihT < 3) {
                        b.b(b.this);
                        b.this.cpk();
                        return;
                    }
                    return;
                }
                b.this.ihU = true;
                b.this.ihT = 0;
            }
        }
    };
    private CustomMessageListener hoN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.ihS <= 0 && !b.this.ihU) {
                b.this.cpk();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.ihT;
        bVar.ihT = i + 1;
        return i;
    }

    public b() {
        cpj();
        MessageManager.getInstance().registerListener(this.ihV);
        MessageManager.getInstance().registerListener(this.ihw);
        MessageManager.getInstance().registerListener(this.hoN);
    }

    private static void cpj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.b.avW);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ag.a
    public void j(ab abVar) {
        if (abVar != null && abVar.aIO != null) {
            a(abVar.aIO);
        }
    }

    public void a(au auVar) {
        at Cs;
        if (auVar != null && auVar.aNP >= 0 && auVar.aNP != 0 && auVar.aNP <= 3 && (Cs = auVar.Cs()) != null) {
            c(Cs);
        }
    }

    @Override // com.baidu.live.ag.a
    public void ab(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            at atVar = new at();
            if (optJSONObject != null) {
                atVar.parseJson(optJSONObject);
            }
            if (atVar.Cp() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                b(atVar);
            }
            c(atVar);
        }
    }

    @Override // com.baidu.live.ag.a
    public void dc(boolean z) {
        this.ihO = z;
        if (z && this.ihP != null) {
            b(this.ihP);
        }
    }

    public void b(at atVar) {
        if (atVar != null && atVar.aNM != null) {
            if (this.ihO) {
                this.ihP = null;
                int i = atVar.aNM.aOa;
                if (i > d.xc().getInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.f.a aVar = new com.baidu.tieba.ala.f.a(BdActivityStack.getInst().currentActivity());
                    d.xc().putInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.B(String.valueOf(atVar.aNN), String.valueOf(atVar.aNM.aOa), atVar.aNM.Ct());
                    aVar.show();
                    return;
                }
                return;
            }
            this.ihP = atVar;
        }
    }

    private void c(at atVar) {
        if (atVar != null && atVar.Co() && atVar.status == 1) {
            d(atVar);
        }
    }

    private void d(at atVar) {
        int i;
        if (atVar.aNM != null && (i = atVar.aNM.aNZ) != this.ihR) {
            this.ihQ = atVar;
            this.ihR = i;
            this.ihS = this.ihR;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.ihS > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpk() {
        if (this.ihQ != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.ihQ.aNI);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.ag.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.ihw);
        MessageManager.getInstance().unRegisterListener(this.ihV);
        MessageManager.getInstance().unRegisterListener(this.hoN);
    }
}
