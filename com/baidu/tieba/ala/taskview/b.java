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
import com.baidu.live.data.ap;
import com.baidu.live.data.aq;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements com.baidu.live.ai.a {
    private ap icW;
    private ap icX;
    private boolean icV = true;
    private int icY = -1;
    private int icZ = 0;
    private int ida = 0;
    private boolean idb = true;
    private HttpMessageListener icD = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.icA);
                }
            }
        }
    };
    private HttpMessageListener idc = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.idb = false;
                    if (b.this.ida < 3) {
                        b.b(b.this);
                        b.this.cof();
                        return;
                    }
                    return;
                }
                b.this.idb = true;
                b.this.ida = 0;
            }
        }
    };
    private CustomMessageListener hkv = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.icZ <= 0 && !b.this.idb) {
                b.this.cof();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.ida;
        bVar.ida = i + 1;
        return i;
    }

    public b() {
        coe();
        MessageManager.getInstance().registerListener(this.idc);
        MessageManager.getInstance().registerListener(this.icD);
        MessageManager.getInstance().registerListener(this.hkv);
    }

    private static void coe() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.b.awh);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ai.a
    public void j(x xVar) {
        if (xVar != null && xVar.aGs != null) {
            a(xVar.aGs);
        }
    }

    public void a(aq aqVar) {
        ap Bf;
        if (aqVar != null && aqVar.aKT >= 0 && aqVar.aKT != 0 && aqVar.aKT <= 3 && (Bf = aqVar.Bf()) != null) {
            c(Bf);
        }
    }

    @Override // com.baidu.live.ai.a
    public void Z(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            ap apVar = new ap();
            if (optJSONObject != null) {
                apVar.parseJson(optJSONObject);
            }
            if (apVar.Bc() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                b(apVar);
            }
            c(apVar);
        }
    }

    @Override // com.baidu.live.ai.a
    public void cU(boolean z) {
        this.icV = z;
        if (z && this.icW != null) {
            b(this.icW);
        }
    }

    public void b(ap apVar) {
        if (apVar != null && apVar.aKQ != null) {
            if (this.icV) {
                this.icW = null;
                int i = apVar.aKQ.aLe;
                if (i > d.xf().getInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.f.a aVar = new com.baidu.tieba.ala.f.a(BdActivityStack.getInst().currentActivity());
                    d.xf().putInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.B(String.valueOf(apVar.aKR), String.valueOf(apVar.aKQ.aLe), apVar.aKQ.Bg());
                    aVar.show();
                    return;
                }
                return;
            }
            this.icW = apVar;
        }
    }

    private void c(ap apVar) {
        if (apVar != null && apVar.Bb() && apVar.status == 1) {
            d(apVar);
        }
    }

    private void d(ap apVar) {
        int i;
        if (apVar.aKQ != null && (i = apVar.aKQ.aLd) != this.icY) {
            this.icX = apVar;
            this.icY = i;
            this.icZ = this.icY;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.icZ > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cof() {
        if (this.icX != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.icX.aKM);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.ai.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.icD);
        MessageManager.getInstance().unRegisterListener(this.idc);
        MessageManager.getInstance().unRegisterListener(this.hkv);
    }
}
