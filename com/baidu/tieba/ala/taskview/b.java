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
    private w gfr;
    private w gfs;
    private boolean gfq = true;
    private int gft = -1;
    private int gfu = 0;
    private int gfv = 0;
    private boolean gfw = true;
    private HttpMessageListener geZ = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.b(alaTaskRewardHttpResponsedMessage.geW);
                }
            }
        }
    };
    private HttpMessageListener gfx = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof AlaCommitTaskHttpResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.gfw = false;
                    if (b.this.gfv < 3) {
                        b.b(b.this);
                        b.this.bDs();
                        return;
                    }
                    return;
                }
                b.this.gfw = true;
                b.this.gfv = 0;
            }
        }
    };
    private CustomMessageListener ftQ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.gfu <= 0 && !b.this.gfw) {
                b.this.bDs();
            }
        }
    };
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.gfu > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.bDs();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.gfu)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.gfv;
        bVar.gfv = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.gfu;
        bVar.gfu = i - 1;
        return i;
    }

    public b() {
        bDr();
        MessageManager.getInstance().registerListener(this.gfx);
        MessageManager.getInstance().registerListener(this.geZ);
        MessageManager.getInstance().registerListener(this.ftQ);
    }

    private static void bDr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.a.anl);
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
        w uZ;
        if (xVar != null && xVar.atI >= 0 && xVar.atI != 0 && xVar.atI <= 3 && (uZ = xVar.uZ()) != null) {
            b(uZ);
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
            if (wVar.uW() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(wVar);
            }
            b(wVar);
        }
    }

    @Override // com.baidu.live.x.a
    public void bO(boolean z) {
        this.gfq = z;
        if (z && this.gfr != null) {
            a(this.gfr);
        }
    }

    public void a(w wVar) {
        if (wVar != null && wVar.atF != null) {
            if (this.gfq) {
                this.gfr = null;
                int i = wVar.atF.atL;
                if (i > c.tH().getInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.e.a aVar = new com.baidu.tieba.ala.e.a(BdActivityStack.getInst().currentActivity());
                    c.tH().putInt(c.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.w(String.valueOf(wVar.atG), String.valueOf(wVar.atF.atL), wVar.atF.va());
                    aVar.show();
                    return;
                }
                return;
            }
            this.gfr = wVar;
        }
    }

    private void b(w wVar) {
        if (wVar != null && wVar.uV() && wVar.status == 1) {
            c(wVar);
        }
    }

    private void c(w wVar) {
        int i;
        if (wVar.atF != null && (i = wVar.atF.atK) != this.gft) {
            this.gfs = wVar;
            this.gft = i;
            this.gfu = this.gft;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.gfu > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDs() {
        if (this.gfs != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.gfs.atB);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.x.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.geZ);
        MessageManager.getInstance().unRegisterListener(this.gfx);
        MessageManager.getInstance().unRegisterListener(this.ftQ);
    }
}
