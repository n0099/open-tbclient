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
/* loaded from: classes4.dex */
public class b {
    private static volatile b hrz = null;
    private long bnV;
    public c hrA;
    private boolean hrB = false;
    HttpMessageListener hrw = new HttpMessageListener(1021220) { // from class: com.baidu.tieba.ala.liveroom.performancewatchtask.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021220 && (httpResponsedMessage instanceof WatchTaskInfoHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                b.this.hrA = ((WatchTaskInfoHttpResponseMessage) httpResponsedMessage).cgL();
                b.this.a(b.this.hrA);
            }
        }
    };
    private AlaLiveInfoData mLiveInfo;
    private BdPageContext<?> mPageContext;
    private String mType;
    private long mUserId;

    static {
        bWu();
    }

    public boolean cgM() {
        return this.hrB;
    }

    public void nH(boolean z) {
        this.hrB = z;
    }

    private b() {
    }

    public void a(BdPageContext<?> bdPageContext, long j, long j2, AlaLiveInfoData alaLiveInfoData, String str) {
        this.mPageContext = bdPageContext;
        this.bnV = j;
        this.mUserId = j2;
        this.mLiveInfo = alaLiveInfoData;
        this.mType = str;
        cgO();
        fa(j2);
    }

    public static b cgN() {
        if (hrz == null) {
            synchronized (b.class) {
                if (hrz == null) {
                    hrz = new b();
                }
            }
        }
        return hrz;
    }

    private void cgO() {
        MessageManager.getInstance().registerListener(this.hrw);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.hrw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar.hrF == 0 && cVar.hrK == 0 && !TextUtils.isEmpty(cVar.hrL) && !TextUtils.isEmpty(cVar.hrG)) {
            a("performance_5", this.bnV, this.hrA.hrH, this.hrA.hrG, this.hrA.hrH * 60 * 1000, this.hrA.hrJ);
            a("performance_15", this.bnV, this.hrA.hrM, this.hrA.hrL, this.hrA.hrM * 60 * 1000, this.hrA.hrO);
        } else if (cVar.hrF != 0 && !TextUtils.isEmpty(cVar.hrL) && cVar.hrK == 0) {
            a("performance_15", this.bnV, this.hrA.hrM, this.hrA.hrL, this.hrA.hrM * 60 * 1000, this.hrA.hrO);
        } else if (cVar.hrF == 0 && !TextUtils.isEmpty(cVar.hrG) && cVar.hrK != 0) {
            a("performance_5", this.bnV, this.hrA.hrH, this.hrA.hrG, this.hrA.hrH * 60 * 1000, this.hrA.hrJ);
        }
    }

    private void a(String str, long j, final int i, final String str2, long j2, final int i2) {
        LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.performancewatchtask.b.2
            @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
            public void onComplete(boolean z) {
                b.this.w(str2, i, i2);
            }

            @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
            public void onInterrupt() {
            }
        }, j2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, int i, int i2) {
        if (this.mPageContext.getPageActivity() != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (Build.VERSION.SDK_INT < 17 || !this.mPageContext.getPageActivity().isDestroyed()) {
                final a aVar = new a(this.mPageContext.getPageActivity());
                aVar.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.performancewatchtask.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        aVar.hide();
                        if (b.this.hrA != null && b.this.mType == null) {
                            b.this.cgP();
                            b.this.Ip(b.this.hrA.hrI);
                        }
                    }
                });
                aVar.a(str, i, this.mUserId, "立即领取", this.mLiveInfo);
                aVar.wi(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgP() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913253, "ala/guess/cancelResult"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ip(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
            cVar.url = str;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            a(UbcStatisticLiveKey.KEY_ID_1396, "click", "taskcomp_clk", (String) null, -1);
        }
    }

    private void fa(long j) {
        HttpMessage httpMessage = new HttpMessage(1021220);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private static void bWu() {
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
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "liveroom", str3).setContentExt(null, "popup", jSONObject));
    }
}
