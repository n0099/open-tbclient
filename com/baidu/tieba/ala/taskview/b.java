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
    private u fzT;
    private u fzU;
    private boolean fzS = true;
    private int fzV = -1;
    private int fzW = 0;
    private int fzX = 0;
    private boolean fzY = true;
    private HttpMessageListener fzB = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.b(alaTaskRewardHttpResponsedMessage.fzy);
                }
            }
        }
    };
    private HttpMessageListener fzZ = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof AlaCommitTaskHttpResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.fzY = false;
                    if (b.this.fzX < 3) {
                        b.b(b.this);
                        b.this.btz();
                        return;
                    }
                    return;
                }
                b.this.fzY = true;
                b.this.fzX = 0;
            }
        }
    };
    private CustomMessageListener eOJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.fzW <= 0 && !b.this.fzY) {
                b.this.btz();
            }
        }
    };
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.fzW > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.btz();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.fzW)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.fzX;
        bVar.fzX = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.fzW;
        bVar.fzW = i - 1;
        return i;
    }

    public b() {
        bty();
        MessageManager.getInstance().registerListener(this.fzZ);
        MessageManager.getInstance().registerListener(this.fzB);
        MessageManager.getInstance().registerListener(this.eOJ);
    }

    private static void bty() {
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
        this.fzS = z;
        if (z && this.fzT != null) {
            a(this.fzT);
        }
    }

    public void a(u uVar) {
        if (uVar != null && uVar.aba != null) {
            if (this.fzS) {
                this.fzT = null;
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
            this.fzT = uVar;
        }
    }

    private void b(u uVar) {
        if (uVar != null && uVar.qz() && uVar.status == 1) {
            c(uVar);
        }
    }

    private void c(u uVar) {
        int i;
        if (uVar.aba != null && (i = uVar.aba.abg) != this.fzV) {
            this.fzU = uVar;
            this.fzV = i;
            this.fzW = this.fzV;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.fzW > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btz() {
        if (this.fzU != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.fzU.aaW);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.x.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.fzB);
        MessageManager.getInstance().unRegisterListener(this.fzZ);
        MessageManager.getInstance().unRegisterListener(this.eOJ);
    }
}
