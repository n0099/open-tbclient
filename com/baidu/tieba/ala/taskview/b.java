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
import com.baidu.live.data.ap;
import com.baidu.live.data.aq;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.ai.a {
    private ap ihH;
    private ap ihI;
    private boolean ihG = true;
    private int ihJ = -1;
    private int ihK = 0;
    private int ihL = 0;
    private boolean ihM = true;
    private HttpMessageListener iho = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.ihl);
                }
            }
        }
    };
    private HttpMessageListener ihN = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.ihM = false;
                    if (b.this.ihL < 3) {
                        b.b(b.this);
                        b.this.crW();
                        return;
                    }
                    return;
                }
                b.this.ihM = true;
                b.this.ihL = 0;
            }
        }
    };
    private CustomMessageListener hpc = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.ihK <= 0 && !b.this.ihM) {
                b.this.crW();
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
        int i = bVar.ihL;
        bVar.ihL = i + 1;
        return i;
    }

    public b() {
        crV();
        MessageManager.getInstance().registerListener(this.ihN);
        MessageManager.getInstance().registerListener(this.iho);
        MessageManager.getInstance().registerListener(this.hpc);
    }

    private static void crV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.b.aAU);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ai.a
    public void j(x xVar) {
        if (xVar != null && xVar.aLf != null) {
            a(xVar.aLf);
        }
    }

    public void a(aq aqVar) {
        ap Fa;
        if (aqVar != null && aqVar.aPG >= 0 && aqVar.aPG != 0 && aqVar.aPG <= 3 && (Fa = aqVar.Fa()) != null) {
            c(Fa);
        }
    }

    @Override // com.baidu.live.ai.a
    public void Z(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            ap apVar = new ap();
            if (optJSONObject != null) {
                apVar.parseJson(optJSONObject);
            }
            if (apVar.EX() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                b(apVar);
            }
            c(apVar);
        }
    }

    @Override // com.baidu.live.ai.a
    public void cY(boolean z) {
        this.ihG = z;
        if (z && this.ihH != null) {
            b(this.ihH);
        }
    }

    public void b(ap apVar) {
        if (apVar != null && apVar.aPD != null) {
            if (this.ihG) {
                this.ihH = null;
                int i = apVar.aPD.aPR;
                if (i > d.Ba().getInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.f.a aVar = new com.baidu.tieba.ala.f.a(BdActivityStack.getInst().currentActivity());
                    d.Ba().putInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.B(String.valueOf(apVar.aPE), String.valueOf(apVar.aPD.aPR), apVar.aPD.Fb());
                    aVar.show();
                    return;
                }
                return;
            }
            this.ihH = apVar;
        }
    }

    private void c(ap apVar) {
        if (apVar != null && apVar.EW() && apVar.status == 1) {
            d(apVar);
        }
    }

    private void d(ap apVar) {
        int i;
        if (apVar.aPD != null && (i = apVar.aPD.aPQ) != this.ihJ) {
            this.ihI = apVar;
            this.ihJ = i;
            this.ihK = this.ihJ;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.ihK > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crW() {
        if (this.ihI != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.ihI.aPz);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.ai.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.iho);
        MessageManager.getInstance().unRegisterListener(this.ihN);
        MessageManager.getInstance().unRegisterListener(this.hpc);
    }
}
