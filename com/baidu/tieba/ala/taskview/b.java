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
    private ai hsO;
    private ai hsP;
    private boolean hsN = true;
    private int hsQ = -1;
    private int hsR = 0;
    private int hsS = 0;
    private boolean hsT = true;
    private HttpMessageListener hsu = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.hsr);
                }
            }
        }
    };
    private HttpMessageListener hsU = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.hsT = false;
                    if (b.this.hsS < 3) {
                        b.b(b.this);
                        b.this.cfR();
                        return;
                    }
                    return;
                }
                b.this.hsT = true;
                b.this.hsS = 0;
            }
        }
    };
    private CustomMessageListener gCg = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.hsR <= 0 && !b.this.hsT) {
                b.this.cfR();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.hsR > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.cfR();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.hsR)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.hsS;
        bVar.hsS = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.hsR;
        bVar.hsR = i - 1;
        return i;
    }

    public b() {
        cfQ();
        MessageManager.getInstance().registerListener(this.hsU);
        MessageManager.getInstance().registerListener(this.hsu);
        MessageManager.getInstance().registerListener(this.gCg);
    }

    private static void cfQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.azO);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.z.a
    public void k(u uVar) {
        if (uVar != null && uVar.aIq != null) {
            a(uVar.aIq);
        }
    }

    public void a(aj ajVar) {
        ai Ed;
        if (ajVar != null && ajVar.aMg >= 0 && ajVar.aMg != 0 && ajVar.aMg <= 3 && (Ed = ajVar.Ed()) != null) {
            b(Ed);
        }
    }

    @Override // com.baidu.live.z.a
    public void P(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            ai aiVar = new ai();
            if (optJSONObject != null) {
                aiVar.parseJson(optJSONObject);
            }
            if (aiVar.Ea() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(aiVar);
            }
            b(aiVar);
        }
    }

    @Override // com.baidu.live.z.a
    public void ct(boolean z) {
        this.hsN = z;
        if (z && this.hsO != null) {
            a(this.hsO);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && aiVar.aMd != null) {
            if (this.hsN) {
                this.hsO = null;
                int i = aiVar.aMd.aMj;
                if (i > c.AZ().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.f.a aVar = new com.baidu.tieba.ala.f.a(BdActivityStack.getInst().currentActivity());
                    c.AZ().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.x(String.valueOf(aiVar.aMe), String.valueOf(aiVar.aMd.aMj), aiVar.aMd.Ee());
                    aVar.show();
                    return;
                }
                return;
            }
            this.hsO = aiVar;
        }
    }

    private void b(ai aiVar) {
        if (aiVar != null && aiVar.DZ() && aiVar.status == 1) {
            c(aiVar);
        }
    }

    private void c(ai aiVar) {
        int i;
        if (aiVar.aMd != null && (i = aiVar.aMd.aMi) != this.hsQ) {
            this.hsP = aiVar;
            this.hsQ = i;
            this.hsR = this.hsQ;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.hsR > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfR() {
        if (this.hsP != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.hsP.aLZ);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.z.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.hsu);
        MessageManager.getInstance().unRegisterListener(this.hsU);
        MessageManager.getInstance().unRegisterListener(this.gCg);
    }
}
