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
import com.baidu.live.data.w;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.x.a {
    private w gfx;
    private w gfy;
    private boolean gfw = true;
    private int gfz = -1;
    private int gfA = 0;
    private int gfB = 0;
    private boolean gfC = true;
    private HttpMessageListener gff = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.b(alaTaskRewardHttpResponsedMessage.gfc);
                }
            }
        }
    };
    private HttpMessageListener gfD = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof AlaCommitTaskHttpResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.gfC = false;
                    if (b.this.gfB < 3) {
                        b.b(b.this);
                        b.this.bDr();
                        return;
                    }
                    return;
                }
                b.this.gfC = true;
                b.this.gfB = 0;
            }
        }
    };
    private CustomMessageListener ftV = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.gfA <= 0 && !b.this.gfC) {
                b.this.bDr();
            }
        }
    };
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.gfA > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.bDr();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.gfA)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.gfB;
        bVar.gfB = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.gfA;
        bVar.gfA = i - 1;
        return i;
    }

    public b() {
        bDq();
        MessageManager.getInstance().registerListener(this.gfD);
        MessageManager.getInstance().registerListener(this.gff);
        MessageManager.getInstance().registerListener(this.ftV);
    }

    private static void bDq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.anr);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCommitTaskHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.x.a
    public void a(x xVar) {
        if (xVar != null) {
            b(xVar);
        }
    }

    public void b(x xVar) {
        w uY;
        if (xVar != null && xVar.atO >= 0 && xVar.atO != 0 && xVar.atO <= 3 && (uY = xVar.uY()) != null) {
            b(uY);
        }
    }

    @Override // com.baidu.live.x.a
    public void B(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            w wVar = new w();
            if (optJSONObject != null) {
                wVar.parseJson(optJSONObject);
            }
            if (wVar.uV() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(wVar);
            }
            b(wVar);
        }
    }

    @Override // com.baidu.live.x.a
    public void bO(boolean z) {
        this.gfw = z;
        if (z && this.gfx != null) {
            a(this.gfx);
        }
    }

    public void a(w wVar) {
        if (wVar != null && wVar.atL != null) {
            if (this.gfw) {
                this.gfx = null;
                int i = wVar.atL.atR;
                if (i > c.tG().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.e.a aVar = new com.baidu.tieba.ala.e.a(BdActivityStack.getInst().currentActivity());
                    c.tG().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.w(String.valueOf(wVar.atM), String.valueOf(wVar.atL.atR), wVar.atL.uZ());
                    aVar.show();
                    return;
                }
                return;
            }
            this.gfx = wVar;
        }
    }

    private void b(w wVar) {
        if (wVar != null && wVar.uU() && wVar.status == 1) {
            c(wVar);
        }
    }

    private void c(w wVar) {
        int i;
        if (wVar.atL != null && (i = wVar.atL.atQ) != this.gfz) {
            this.gfy = wVar;
            this.gfz = i;
            this.gfA = this.gfz;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.gfA > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDr() {
        if (this.gfy != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.gfy.atH);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.x.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.gff);
        MessageManager.getInstance().unRegisterListener(this.gfD);
        MessageManager.getInstance().unRegisterListener(this.ftV);
    }
}
