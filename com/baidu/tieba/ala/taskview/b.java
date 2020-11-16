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
import com.baidu.live.d;
import com.baidu.live.data.am;
import com.baidu.live.data.an;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.ad.a {
    private am hKl;
    private am hKm;
    private boolean hKk = true;
    private int hKn = -1;
    private int hKo = 0;
    private int hKp = 0;
    private boolean hKq = true;
    private HttpMessageListener hJS = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.hJP);
                }
            }
        }
    };
    private HttpMessageListener hKr = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.hKq = false;
                    if (b.this.hKp < 3) {
                        b.b(b.this);
                        b.this.ckN();
                        return;
                    }
                    return;
                }
                b.this.hKq = true;
                b.this.hKp = 0;
            }
        }
    };
    private CustomMessageListener gUa = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.hKo <= 0 && !b.this.hKq) {
                b.this.ckN();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.hKo > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.ckN();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.hKo)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.hKp;
        bVar.hKp = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.hKo;
        bVar.hKo = i - 1;
        return i;
    }

    public b() {
        ckM();
        MessageManager.getInstance().registerListener(this.hKr);
        MessageManager.getInstance().registerListener(this.hJS);
        MessageManager.getInstance().registerListener(this.gUa);
    }

    private static void ckM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.b.ayi);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ad.a
    public void i(w wVar) {
        if (wVar != null && wVar.aHT != null) {
            a(wVar.aHT);
        }
    }

    public void a(an anVar) {
        am DZ;
        if (anVar != null && anVar.aMc >= 0 && anVar.aMc != 0 && anVar.aMc <= 3 && (DZ = anVar.DZ()) != null) {
            b(DZ);
        }
    }

    @Override // com.baidu.live.ad.a
    public void P(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            am amVar = new am();
            if (optJSONObject != null) {
                amVar.parseJson(optJSONObject);
            }
            if (amVar.DW() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(amVar);
            }
            b(amVar);
        }
    }

    @Override // com.baidu.live.ad.a
    public void cH(boolean z) {
        this.hKk = z;
        if (z && this.hKl != null) {
            a(this.hKl);
        }
    }

    public void a(am amVar) {
        if (amVar != null && amVar.aLZ != null) {
            if (this.hKk) {
                this.hKl = null;
                int i = amVar.aLZ.aMf;
                if (i > d.Aq().getInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.f.a aVar = new com.baidu.tieba.ala.f.a(BdActivityStack.getInst().currentActivity());
                    d.Aq().putInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.y(String.valueOf(amVar.aMa), String.valueOf(amVar.aLZ.aMf), amVar.aLZ.Ea());
                    aVar.show();
                    return;
                }
                return;
            }
            this.hKl = amVar;
        }
    }

    private void b(am amVar) {
        if (amVar != null && amVar.DV() && amVar.status == 1) {
            c(amVar);
        }
    }

    private void c(am amVar) {
        int i;
        if (amVar.aLZ != null && (i = amVar.aLZ.aMe) != this.hKn) {
            this.hKm = amVar;
            this.hKn = i;
            this.hKo = this.hKn;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.hKo > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckN() {
        if (this.hKm != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.hKm.aLV);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.ad.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.hJS);
        MessageManager.getInstance().unRegisterListener(this.hKr);
        MessageManager.getInstance().unRegisterListener(this.gUa);
    }
}
