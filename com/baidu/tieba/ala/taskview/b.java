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
import com.baidu.live.data.r;
import com.baidu.live.data.s;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.baidu.live.s.a {
    private r fuk;
    private r ful;
    private boolean fuj = true;
    private int fum = -1;
    private int fun = 0;
    private int fuo = 0;
    private boolean fup = true;
    private HttpMessageListener ftP = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.b(alaTaskRewardHttpResponsedMessage.ftM);
                }
            }
        }
    };
    private HttpMessageListener fuq = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof AlaCommitTaskHttpResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.fup = false;
                    if (b.this.fuo < 3) {
                        b.b(b.this);
                        b.this.bqT();
                        return;
                    }
                    return;
                }
                b.this.fup = true;
                b.this.fuo = 0;
            }
        }
    };
    private CustomMessageListener eJz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.fun <= 0 && !b.this.fup) {
                b.this.bqT();
            }
        }
    };
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.fun > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.bqT();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.fun)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.fuo;
        bVar.fuo = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.fun;
        bVar.fun = i - 1;
        return i;
    }

    public b() {
        bqS();
        MessageManager.getInstance().registerListener(this.fuq);
        MessageManager.getInstance().registerListener(this.ftP);
        MessageManager.getInstance().registerListener(this.eJz);
    }

    private static void bqS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.TG);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCommitTaskHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.s.a
    public void a(s sVar) {
        if (sVar != null) {
            b(sVar);
        }
    }

    public void b(s sVar) {
        r pO;
        if (sVar != null && sVar.YX >= 0 && sVar.YX != 0 && sVar.YX <= 3 && (pO = sVar.pO()) != null) {
            b(pO);
        }
    }

    @Override // com.baidu.live.s.a
    public void v(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            r rVar = new r();
            if (optJSONObject != null) {
                rVar.parseJson(optJSONObject);
            }
            if (rVar.pL() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(rVar);
            }
            b(rVar);
        }
    }

    @Override // com.baidu.live.s.a
    public void aX(boolean z) {
        this.fuj = z;
        if (z && this.fuk != null) {
            a(this.fuk);
        }
    }

    public void a(r rVar) {
        if (rVar != null && rVar.YU != null) {
            if (this.fuj) {
                this.fuk = null;
                int i = rVar.YU.Za;
                if (i > c.oI().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.d.a aVar = new com.baidu.tieba.ala.d.a(BdActivityStack.getInst().currentActivity());
                    c.oI().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.w(String.valueOf(rVar.YV), String.valueOf(rVar.YU.Za), rVar.YU.pP());
                    aVar.show();
                    return;
                }
                return;
            }
            this.fuk = rVar;
        }
    }

    private void b(r rVar) {
        if (rVar != null && rVar.pK()) {
            if (rVar.status == 1) {
                c(rVar);
            } else {
                if (rVar.status == 3) {
                }
            }
        }
    }

    private void c(r rVar) {
        int i;
        if (rVar.YU != null && (i = rVar.YU.YZ) != this.fum) {
            this.ful = rVar;
            this.fum = i;
            this.fun = this.fum;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.fun > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqT() {
        if (this.ful != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.ful.YQ);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.s.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.ftP);
        MessageManager.getInstance().unRegisterListener(this.fuq);
        MessageManager.getInstance().unRegisterListener(this.eJz);
    }
}
