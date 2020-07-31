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
import com.baidu.live.data.ab;
import com.baidu.live.data.ac;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.x.a {
    private ab gMQ;
    private ab gMR;
    private boolean gMP = true;
    private int gMS = -1;
    private int gMT = 0;
    private int gMU = 0;
    private boolean gMV = true;
    private HttpMessageListener gMw = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.gMt);
                }
            }
        }
    };
    private HttpMessageListener gMW = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.gMV = false;
                    if (b.this.gMU < 3) {
                        b.b(b.this);
                        b.this.bPZ();
                        return;
                    }
                    return;
                }
                b.this.gMV = true;
                b.this.gMU = 0;
            }
        }
    };
    private CustomMessageListener fYE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.gMT <= 0 && !b.this.gMV) {
                b.this.bPZ();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.gMT > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.bPZ();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.gMT)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.gMU;
        bVar.gMU = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.gMT;
        bVar.gMT = i - 1;
        return i;
    }

    public b() {
        bPY();
        MessageManager.getInstance().registerListener(this.gMW);
        MessageManager.getInstance().registerListener(this.gMw);
        MessageManager.getInstance().registerListener(this.fYE);
    }

    private static void bPY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.atz);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.x.a
    public void j(q qVar) {
        if (qVar != null && qVar.azf != null) {
            a(qVar.azf);
        }
    }

    public void a(ac acVar) {
        ab xn;
        if (acVar != null && acVar.aCv >= 0 && acVar.aCv != 0 && acVar.aCv <= 3 && (xn = acVar.xn()) != null) {
            b(xn);
        }
    }

    @Override // com.baidu.live.x.a
    public void L(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            ab abVar = new ab();
            if (optJSONObject != null) {
                abVar.parseJson(optJSONObject);
            }
            if (abVar.xk() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(abVar);
            }
            b(abVar);
        }
    }

    @Override // com.baidu.live.x.a
    public void cf(boolean z) {
        this.gMP = z;
        if (z && this.gMQ != null) {
            a(this.gMQ);
        }
    }

    public void a(ab abVar) {
        if (abVar != null && abVar.aCs != null) {
            if (this.gMP) {
                this.gMQ = null;
                int i = abVar.aCs.aCy;
                if (i > c.vf().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.e.a aVar = new com.baidu.tieba.ala.e.a(BdActivityStack.getInst().currentActivity());
                    c.vf().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.y(String.valueOf(abVar.aCt), String.valueOf(abVar.aCs.aCy), abVar.aCs.xo());
                    aVar.show();
                    return;
                }
                return;
            }
            this.gMQ = abVar;
        }
    }

    private void b(ab abVar) {
        if (abVar != null && abVar.xj() && abVar.status == 1) {
            c(abVar);
        }
    }

    private void c(ab abVar) {
        int i;
        if (abVar.aCs != null && (i = abVar.aCs.aCx) != this.gMS) {
            this.gMR = abVar;
            this.gMS = i;
            this.gMT = this.gMS;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.gMT > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPZ() {
        if (this.gMR != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.gMR.aCo);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.x.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.gMw);
        MessageManager.getInstance().unRegisterListener(this.gMW);
        MessageManager.getInstance().unRegisterListener(this.fYE);
    }
}
