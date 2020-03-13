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
import com.baidu.live.data.u;
import com.baidu.live.data.v;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.x.a {
    private u fAi;
    private u fAj;
    private boolean fAh = true;
    private int fAk = -1;
    private int fAl = 0;
    private int fAm = 0;
    private boolean fAn = true;
    private HttpMessageListener fzQ = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.b(alaTaskRewardHttpResponsedMessage.fzN);
                }
            }
        }
    };
    private HttpMessageListener fAo = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof AlaCommitTaskHttpResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.fAn = false;
                    if (b.this.fAm < 3) {
                        b.b(b.this);
                        b.this.btC();
                        return;
                    }
                    return;
                }
                b.this.fAn = true;
                b.this.fAm = 0;
            }
        }
    };
    private CustomMessageListener eOX = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.fAl <= 0 && !b.this.fAn) {
                b.this.btC();
            }
        }
    };
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.fAl > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.btC();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.fAl)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.fAm;
        bVar.fAm = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.fAl;
        bVar.fAl = i - 1;
        return i;
    }

    public b() {
        btB();
        MessageManager.getInstance().registerListener(this.fAo);
        MessageManager.getInstance().registerListener(this.fzQ);
        MessageManager.getInstance().registerListener(this.eOX);
    }

    private static void btB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.Vp);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCommitTaskHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.x.a
    public void a(v vVar) {
        if (vVar != null) {
            b(vVar);
        }
    }

    public void b(v vVar) {
        u qD;
        if (vVar != null && vVar.abe >= 0 && vVar.abe != 0 && vVar.abe <= 3 && (qD = vVar.qD()) != null) {
            b(qD);
        }
    }

    @Override // com.baidu.live.x.a
    public void v(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            u uVar = new u();
            if (optJSONObject != null) {
                uVar.parseJson(optJSONObject);
            }
            if (uVar.qA() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(uVar);
            }
            b(uVar);
        }
    }

    @Override // com.baidu.live.x.a
    public void bj(boolean z) {
        this.fAh = z;
        if (z && this.fAi != null) {
            a(this.fAi);
        }
    }

    public void a(u uVar) {
        if (uVar != null && uVar.aba != null) {
            if (this.fAh) {
                this.fAi = null;
                int i = uVar.aba.abh;
                if (i > c.pr().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.d.a aVar = new com.baidu.tieba.ala.d.a(BdActivityStack.getInst().currentActivity());
                    c.pr().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.x(String.valueOf(uVar.abb), String.valueOf(uVar.aba.abh), uVar.aba.qE());
                    aVar.show();
                    return;
                }
                return;
            }
            this.fAi = uVar;
        }
    }

    private void b(u uVar) {
        if (uVar != null && uVar.qz() && uVar.status == 1) {
            c(uVar);
        }
    }

    private void c(u uVar) {
        int i;
        if (uVar.aba != null && (i = uVar.aba.abg) != this.fAk) {
            this.fAj = uVar;
            this.fAk = i;
            this.fAl = this.fAk;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.fAl > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btC() {
        if (this.fAj != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.fAj.aaW);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.x.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.fzQ);
        MessageManager.getInstance().unRegisterListener(this.fAo);
        MessageManager.getInstance().unRegisterListener(this.eOX);
    }
}
