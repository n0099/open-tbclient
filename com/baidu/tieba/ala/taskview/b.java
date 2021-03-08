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
/* loaded from: classes10.dex */
public class b implements com.baidu.live.ag.a {
    private at ijM;
    private at ijN;
    private boolean ijL = true;
    private int ijO = -1;
    private int ijP = 0;
    private int ijQ = 0;
    private boolean ijR = true;
    private HttpMessageListener ijt = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.ijq);
                }
            }
        }
    };
    private HttpMessageListener ijS = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.ijR = false;
                    if (b.this.ijQ < 3) {
                        b.b(b.this);
                        b.this.cpx();
                        return;
                    }
                    return;
                }
                b.this.ijR = true;
                b.this.ijQ = 0;
            }
        }
    };
    private CustomMessageListener hqK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.ijP <= 0 && !b.this.ijR) {
                b.this.cpx();
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
        int i = bVar.ijQ;
        bVar.ijQ = i + 1;
        return i;
    }

    public b() {
        cpw();
        MessageManager.getInstance().registerListener(this.ijS);
        MessageManager.getInstance().registerListener(this.ijt);
        MessageManager.getInstance().registerListener(this.hqK);
    }

    private static void cpw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.b.axw);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ag.a
    public void j(ab abVar) {
        if (abVar != null && abVar.aKo != null) {
            a(abVar.aKo);
        }
    }

    public void a(au auVar) {
        at Cv;
        if (auVar != null && auVar.aPp >= 0 && auVar.aPp != 0 && auVar.aPp <= 3 && (Cv = auVar.Cv()) != null) {
            c(Cv);
        }
    }

    @Override // com.baidu.live.ag.a
    public void ad(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            at atVar = new at();
            if (optJSONObject != null) {
                atVar.parseJson(optJSONObject);
            }
            if (atVar.Cs() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                b(atVar);
            }
            c(atVar);
        }
    }

    @Override // com.baidu.live.ag.a
    public void dc(boolean z) {
        this.ijL = z;
        if (z && this.ijM != null) {
            b(this.ijM);
        }
    }

    public void b(at atVar) {
        if (atVar != null && atVar.aPm != null) {
            if (this.ijL) {
                this.ijM = null;
                int i = atVar.aPm.aPA;
                if (i > d.xf().getInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.f.a aVar = new com.baidu.tieba.ala.f.a(BdActivityStack.getInst().currentActivity());
                    d.xf().putInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.B(String.valueOf(atVar.aPn), String.valueOf(atVar.aPm.aPA), atVar.aPm.Cw());
                    aVar.show();
                    return;
                }
                return;
            }
            this.ijM = atVar;
        }
    }

    private void c(at atVar) {
        if (atVar != null && atVar.Cr() && atVar.status == 1) {
            d(atVar);
        }
    }

    private void d(at atVar) {
        int i;
        if (atVar.aPm != null && (i = atVar.aPm.aPz) != this.ijO) {
            this.ijN = atVar;
            this.ijO = i;
            this.ijP = this.ijO;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.ijP > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpx() {
        if (this.ijN != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.ijN.aPi);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.ag.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.ijt);
        MessageManager.getInstance().unRegisterListener(this.ijS);
        MessageManager.getInstance().unRegisterListener(this.hqK);
    }
}
