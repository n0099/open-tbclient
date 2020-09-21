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
import com.baidu.live.data.ai;
import com.baidu.live.data.aj;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.z.a {
    private ai hdL;
    private ai hdM;
    private boolean hdK = true;
    private int hdN = -1;
    private int hdO = 0;
    private int hdP = 0;
    private boolean hdQ = true;
    private HttpMessageListener hdr = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.hdo);
                }
            }
        }
    };
    private HttpMessageListener hdR = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.hdQ = false;
                    if (b.this.hdP < 3) {
                        b.b(b.this);
                        b.this.ccv();
                        return;
                    }
                    return;
                }
                b.this.hdQ = true;
                b.this.hdP = 0;
            }
        }
    };
    private CustomMessageListener gnN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.hdO <= 0 && !b.this.hdQ) {
                b.this.ccv();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.hdO > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.ccv();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.hdO)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.hdP;
        bVar.hdP = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.hdO;
        bVar.hdO = i - 1;
        return i;
    }

    public b() {
        ccu();
        MessageManager.getInstance().registerListener(this.hdR);
        MessageManager.getInstance().registerListener(this.hdr);
        MessageManager.getInstance().registerListener(this.gnN);
    }

    private static void ccu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.azf);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.z.a
    public void k(u uVar) {
        if (uVar != null && uVar.aFm != null) {
            a(uVar.aFm);
        }
    }

    public void a(aj ajVar) {
        ai Dg;
        if (ajVar != null && ajVar.aJb >= 0 && ajVar.aJb != 0 && ajVar.aJb <= 3 && (Dg = ajVar.Dg()) != null) {
            b(Dg);
        }
    }

    @Override // com.baidu.live.z.a
    public void Q(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            ai aiVar = new ai();
            if (optJSONObject != null) {
                aiVar.parseJson(optJSONObject);
            }
            if (aiVar.Dd() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(aiVar);
            }
            b(aiVar);
        }
    }

    @Override // com.baidu.live.z.a
    public void cq(boolean z) {
        this.hdK = z;
        if (z && this.hdL != null) {
            a(this.hdL);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && aiVar.aIY != null) {
            if (this.hdK) {
                this.hdL = null;
                int i = aiVar.aIY.aJe;
                if (i > c.AR().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.f.a aVar = new com.baidu.tieba.ala.f.a(BdActivityStack.getInst().currentActivity());
                    c.AR().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.x(String.valueOf(aiVar.aIZ), String.valueOf(aiVar.aIY.aJe), aiVar.aIY.Dh());
                    aVar.show();
                    return;
                }
                return;
            }
            this.hdL = aiVar;
        }
    }

    private void b(ai aiVar) {
        if (aiVar != null && aiVar.Dc() && aiVar.status == 1) {
            c(aiVar);
        }
    }

    private void c(ai aiVar) {
        int i;
        if (aiVar.aIY != null && (i = aiVar.aIY.aJd) != this.hdN) {
            this.hdM = aiVar;
            this.hdN = i;
            this.hdO = this.hdN;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.hdO > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccv() {
        if (this.hdM != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.hdM.aIU);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.z.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.hdr);
        MessageManager.getInstance().unRegisterListener(this.hdR);
        MessageManager.getInstance().unRegisterListener(this.gnN);
    }
}
