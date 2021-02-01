package com.baidu.tieba.ala.liveroom.performancewatchtask;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b hME = null;
    private BdPageContext<?> bkx;
    private long buN;
    public c hMF;
    private AlaLiveInfoData mLiveInfo;
    private String mType;
    private long mUserId;
    private boolean hMG = false;
    HttpMessageListener hMB = new HttpMessageListener(1021220) { // from class: com.baidu.tieba.ala.liveroom.performancewatchtask.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021220 && (httpResponsedMessage instanceof WatchTaskInfoHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                b.this.hMF = ((WatchTaskInfoHttpResponseMessage) httpResponsedMessage).cjW();
                b.this.a(b.this.hMF);
            }
        }
    };

    public boolean cjX() {
        return this.hMG;
    }

    public void oI(boolean z) {
        this.hMG = z;
    }

    private b() {
    }

    public void a(BdPageContext<?> bdPageContext, long j, long j2, AlaLiveInfoData alaLiveInfoData, String str) {
        this.bkx = bdPageContext;
        this.buN = j;
        this.mUserId = j2;
        this.mLiveInfo = alaLiveInfoData;
        this.mType = str;
        bZm();
        cjZ();
        fJ(j2);
    }

    public static b cjY() {
        if (hME == null) {
            synchronized (b.class) {
                if (hME == null) {
                    hME = new b();
                }
            }
        }
        return hME;
    }

    private void cjZ() {
        MessageManager.getInstance().registerListener(this.hMB);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.hMB);
        MessageManager.getInstance().unRegisterTask(1021220);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar.hMK == 0 && cVar.hMP == 0 && !TextUtils.isEmpty(cVar.hMQ) && !TextUtils.isEmpty(cVar.hML)) {
            a("performance_5", this.buN, this.hMF.hMM, this.hMF.hML, this.hMF.hMM * 60 * 1000, this.hMF.hMO);
            a("performance_15", this.buN, this.hMF.hMR, this.hMF.hMQ, this.hMF.hMR * 60 * 1000, this.hMF.hMT);
        } else if (cVar.hMK != 0 && !TextUtils.isEmpty(cVar.hMQ) && cVar.hMP == 0) {
            a("performance_15", this.buN, this.hMF.hMR, this.hMF.hMQ, this.hMF.hMR * 60 * 1000, this.hMF.hMT);
        } else if (cVar.hMK == 0 && !TextUtils.isEmpty(cVar.hML) && cVar.hMP != 0) {
            a("performance_5", this.buN, this.hMF.hMM, this.hMF.hML, this.hMF.hMM * 60 * 1000, this.hMF.hMO);
        }
    }

    private void a(String str, long j, final int i, final String str2, long j2, final int i2) {
        LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.performancewatchtask.b.2
            @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
            public void onComplete(boolean z) {
                b.this.x(str2, i, i2);
            }

            @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
            public void onInterrupt() {
            }
        }, j2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, int i, int i2) {
        if (this.bkx.getPageActivity() != null && !this.bkx.getPageActivity().isFinishing()) {
            if (Build.VERSION.SDK_INT < 17 || !this.bkx.getPageActivity().isDestroyed()) {
                final a aVar = new a(this.bkx.getPageActivity());
                aVar.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.performancewatchtask.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        aVar.hide();
                        if (b.this.hMF != null && b.this.mType == null) {
                            b.this.cka();
                            b.this.HZ(b.this.hMF.hMN);
                        }
                    }
                });
                aVar.a(str, i, this.mUserId, "立即领取", this.mLiveInfo);
                aVar.wb(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cka() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913253, "ala/guess/cancelResult"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            cVar.url = str;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            a(UbcStatisticLiveKey.KEY_ID_1396, "click", "taskcomp_clk", (String) null, -1);
        }
    }

    private void fJ(long j) {
        HttpMessage httpMessage = new HttpMessage(1021220);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void bZm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021220, TbConfig.SERVER_QUANMIN_ADDRESS + "pubshow/task/Isjumplivequizticket");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(WatchTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void a(String str, String str2, String str3, String str4, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str4)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("task_id", str4);
                jSONObject2.put("ticket_num", i);
                jSONObject.put("ext", jSONObject2);
            }
            jSONObject.putOpt("live_id", Long.valueOf(this.mLiveInfo.live_id));
            jSONObject.putOpt("vid", this.mLiveInfo.feed_id);
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_SID, ExtraParamsManager.getBaiduSid());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.SDK_VERSION);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "liveroom", str3).setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
    }
}
