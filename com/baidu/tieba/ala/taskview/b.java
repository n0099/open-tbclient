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
import com.baidu.live.data.al;
import com.baidu.live.data.am;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.ac.a {
    private al hEH;
    private al hEI;
    private boolean hEG = true;
    private int hEJ = -1;
    private int hEK = 0;
    private int hEL = 0;
    private boolean hEM = true;
    private HttpMessageListener hEo = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    b.this.a(liveFlowerTaskRewardResponsedMessage.hEl);
                }
            }
        }
    };
    private HttpMessageListener hEN = new HttpMessageListener(1021067) { // from class: com.baidu.tieba.ala.taskview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof LiveFlowerTaskCommitResponseMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.hEM = false;
                    if (b.this.hEL < 3) {
                        b.b(b.this);
                        b.this.ciS();
                        return;
                    }
                    return;
                }
                b.this.hEM = true;
                b.this.hEL = 0;
            }
        }
    };
    private CustomMessageListener gNU = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.taskview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && b.this.hEK <= 0 && !b.this.hEM) {
                b.this.ciS();
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.taskview.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.f(b.this);
            if (b.this.hEK > 0) {
                b.this.mHandler.postDelayed(this, 1000L);
            } else {
                b.this.ciS();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, Integer.valueOf(b.this.hEK)));
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int b(b bVar) {
        int i = bVar.hEL;
        bVar.hEL = i + 1;
        return i;
    }

    static /* synthetic */ int f(b bVar) {
        int i = bVar.hEK;
        bVar.hEK = i - 1;
        return i;
    }

    public b() {
        ciR();
        MessageManager.getInstance().registerListener(this.hEN);
        MessageManager.getInstance().registerListener(this.hEo);
        MessageManager.getInstance().registerListener(this.gNU);
    }

    private static void ciR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.b.azT);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskCommitResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ac.a
    public void j(w wVar) {
        if (wVar != null && wVar.aIN != null) {
            a(wVar.aIN);
        }
    }

    public void a(am amVar) {
        al Em;
        if (amVar != null && amVar.aML >= 0 && amVar.aML != 0 && amVar.aML <= 3 && (Em = amVar.Em()) != null) {
            b(Em);
        }
    }

    @Override // com.baidu.live.ac.a
    public void R(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("user_id");
            jSONObject.optString("user_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            al alVar = new al();
            if (optJSONObject != null) {
                alVar.parseJson(optJSONObject);
            }
            if (alVar.Ej() && TbadkCoreApplication.getCurrentAccountId() == optInt) {
                a(alVar);
            }
            b(alVar);
        }
    }

    @Override // com.baidu.live.ac.a
    public void cy(boolean z) {
        this.hEG = z;
        if (z && this.hEH != null) {
            a(this.hEH);
        }
    }

    public void a(al alVar) {
        if (alVar != null && alVar.aMI != null) {
            if (this.hEG) {
                this.hEH = null;
                int i = alVar.aMI.aMO;
                if (i > d.AZ().getInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), -1) && BdActivityStack.getInst().currentActivity() != null) {
                    com.baidu.tieba.ala.f.a aVar = new com.baidu.tieba.ala.f.a(BdActivityStack.getInst().currentActivity());
                    d.AZ().putInt(d.getSharedPrefKeyWithAccount("ala_free_gift_task_level_up_dialog_tip"), i);
                    aVar.x(String.valueOf(alVar.aMJ), String.valueOf(alVar.aMI.aMO), alVar.aMI.En());
                    aVar.show();
                    return;
                }
                return;
            }
            this.hEH = alVar;
        }
    }

    private void b(al alVar) {
        if (alVar != null && alVar.Ei() && alVar.status == 1) {
            c(alVar);
        }
    }

    private void c(al alVar) {
        int i;
        if (alVar.aMI != null && (i = alVar.aMI.aMN) != this.hEJ) {
            this.hEI = alVar;
            this.hEJ = i;
            this.hEK = this.hEJ;
            startCountDown();
        }
    }

    private void startCountDown() {
        if (this.hEK > 0) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciS() {
        if (this.hEI != null) {
            HttpMessage httpMessage = new HttpMessage(1021067);
            httpMessage.addParam("task_id", this.hEI.aME);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.ac.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterListener(this.hEo);
        MessageManager.getInstance().unRegisterListener(this.hEN);
        MessageManager.getInstance().unRegisterListener(this.gNU);
    }
}
