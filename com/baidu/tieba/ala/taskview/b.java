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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.x.a {
    private ab gHp;
    private ab gHq;
    private boolean gHo = true;
    private int gHr = -1;
    private int gHs = 0;
    private int gHt = 0;
    private boolean gHu = true;
    private HttpMessageListener gGV = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.b(alaTaskRewardHttpResponsedMessage.gGS);
                }
            }
        }
    };
    private HttpMessageListener gHv = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof AlaCommitTaskHttpResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.gHu = false;
                    if (b.this.gHt < 3) {
                        b.b(b.this);
                        b.this.bMP();
                        return;
                    }
                    return;
                }
                b.this.gHu = true;
                b.this.gHt = 0;
            }
        }
    };
    private CustomMessageListener fTl = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.gHs <= 0 && !b.this.gHu) {
                b.this.bMP();
            }
        }
    };
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.gHs > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.bMP();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.gHs)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.gHt;
        bVar.gHt = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.gHs;
        bVar.gHs = i - 1;
        return i;
    }

    public b() {
        bMO();
        MessageManager.getInstance().registerListener(this.gHv);
        MessageManager.getInstance().registerListener(this.gGV);
        MessageManager.getInstance().registerListener(this.fTl);
    }

    private static void bMO() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.atD);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCommitTaskHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.x.a
    public void a(ac acVar) {
        if (acVar != null) {
            b(acVar);
        }
    }

    public void b(ac acVar) {
        ab wL;
        if (acVar != null && acVar.aBi >= 0 && acVar.aBi != 0 && acVar.aBi <= 3 && (wL = acVar.wL()) != null) {
            b(wL);
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
            if (abVar.wI() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(abVar);
            }
            b(abVar);
        }
    }

    @Override // com.baidu.live.x.a
    public void cd(boolean z) {
        this.gHo = z;
        if (z && this.gHp != null) {
            a(this.gHp);
        }
    }

    public void a(ab abVar) {
        if (abVar != null && abVar.aBf != null) {
            if (this.gHo) {
                this.gHp = null;
                int i = abVar.aBf.aBl;
                if (i > c.vf().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.e.a aVar = new com.baidu.tieba.ala.e.a(BdActivityStack.getInst().currentActivity());
                    c.vf().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.y(String.valueOf(abVar.aBg), String.valueOf(abVar.aBf.aBl), abVar.aBf.wM());
                    aVar.show();
                    return;
                }
                return;
            }
            this.gHp = abVar;
        }
    }

    private void b(ab abVar) {
        if (abVar != null && abVar.wH() && abVar.status == 1) {
            c(abVar);
        }
    }

    private void c(ab abVar) {
        int i;
        if (abVar.aBf != null && (i = abVar.aBf.aBk) != this.gHr) {
            this.gHq = abVar;
            this.gHr = i;
            this.gHs = this.gHr;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.gHs > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMP() {
        if (this.gHq != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.gHq.aBb);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.x.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.gGV);
        MessageManager.getInstance().unRegisterListener(this.gHv);
        MessageManager.getInstance().unRegisterListener(this.fTl);
    }
}
