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
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.baidu.live.m.a {
    private p eDw;
    private p eDx;
    private boolean eDv = true;
    private int eDy = -1;
    private int eDz = 0;
    private int eDA = 0;
    private boolean eDB = true;
    private HttpMessageListener eDb = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.b(alaTaskRewardHttpResponsedMessage.eCY);
                }
            }
        }
    };
    private HttpMessageListener eDC = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof AlaCommitTaskHttpResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.eDB = false;
                    if (b.this.eDA < 3) {
                        b.b(b.this);
                        b.this.aYU();
                        return;
                    }
                    return;
                }
                b.this.eDB = true;
                b.this.eDA = 0;
            }
        }
    };
    private CustomMessageListener dUL = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.eDz <= 0 && !b.this.eDB) {
                b.this.aYU();
            }
        }
    };
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.eDz > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.aYU();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.eDz)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.eDA;
        bVar.eDA = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.eDz;
        bVar.eDz = i - 1;
        return i;
    }

    public b() {
        aYT();
        MessageManager.getInstance().registerListener(this.eDC);
        MessageManager.getInstance().registerListener(this.eDb);
        MessageManager.getInstance().registerListener(this.dUL);
    }

    private static void aYT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.Nl);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCommitTaskHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.m.a
    public void a(q qVar) {
        if (qVar != null) {
            b(qVar);
        }
    }

    public void b(q qVar) {
        p ot;
        if (qVar != null && qVar.SB >= 0 && qVar.SB != 0 && qVar.SB <= 3 && (ot = qVar.ot()) != null) {
            b(ot);
        }
    }

    @Override // com.baidu.live.m.a
    public void y(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            p pVar = new p();
            if (optJSONObject != null) {
                pVar.parseJson(optJSONObject);
            }
            if (pVar.oq() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(pVar);
            }
            b(pVar);
        }
    }

    @Override // com.baidu.live.m.a
    public void aG(boolean z) {
        this.eDv = z;
        if (z && this.eDw != null) {
            a(this.eDw);
        }
    }

    public void a(p pVar) {
        if (pVar != null && pVar.Sy != null) {
            if (this.eDv) {
                this.eDw = null;
                int i = pVar.Sy.SF;
                if (i > c.np().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1)) {
                    com.baidu.tieba.ala.b.a aVar = new com.baidu.tieba.ala.b.a(BdActivityStack.getInst().currentActivity());
                    c.np().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.w(String.valueOf(pVar.Sz), String.valueOf(pVar.Sy.SF), pVar.Sy.ou());
                    aVar.show();
                    return;
                }
                return;
            }
            this.eDw = pVar;
        }
    }

    private void b(p pVar) {
        if (pVar != null && pVar.op()) {
            if (pVar.status == 1) {
                c(pVar);
            } else {
                if (pVar.status == 3) {
                }
            }
        }
    }

    private void c(p pVar) {
        int i;
        if (pVar.Sy != null && (i = pVar.Sy.SD) != this.eDy) {
            this.eDx = pVar;
            this.eDy = i;
            this.eDz = this.eDy;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.eDz > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYU() {
        if (this.eDx != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.eDx.Su);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.m.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.eDb);
        MessageManager.getInstance().unRegisterListener(this.eDC);
        MessageManager.getInstance().unRegisterListener(this.dUL);
    }
}
