package com.baidu.tieba.ala.liveroom.performancewatchtask;

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
import com.baidu.platform.comapi.map.MapController;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private static volatile b hlB = null;
    private long bmB;
    public c hlC;
    private boolean hlD = false;
    HttpMessageListener hly = new HttpMessageListener(1021220) { // from class: com.baidu.tieba.ala.liveroom.performancewatchtask.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021220 && (httpResponsedMessage instanceof WatchTaskInfoHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                b.this.hlC = ((WatchTaskInfoHttpResponseMessage) httpResponsedMessage).cei();
                b.this.a(b.this.hlC);
            }
        }
    };
    private AlaLiveInfoData mLiveInfo;
    private BdPageContext<?> mPageContext;
    private String mType;
    private long mUserId;

    static {
        bTN();
    }

    public boolean cej() {
        return this.hlD;
    }

    public void ny(boolean z) {
        this.hlD = z;
    }

    private b() {
    }

    public void a(BdPageContext<?> bdPageContext, long j, long j2, AlaLiveInfoData alaLiveInfoData, String str) {
        this.mPageContext = bdPageContext;
        this.bmB = j;
        this.mUserId = j2;
        this.mLiveInfo = alaLiveInfoData;
        this.mType = str;
        cel();
        eE(j2);
    }

    public static b cek() {
        if (hlB == null) {
            synchronized (b.class) {
                if (hlB == null) {
                    hlB = new b();
                }
            }
        }
        return hlB;
    }

    private void cel() {
        MessageManager.getInstance().registerListener(this.hly);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.hly);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar.hlH == 0 && cVar.hlM == 0 && !TextUtils.isEmpty(cVar.hlN) && !TextUtils.isEmpty(cVar.hlI)) {
            a("performance_5", this.bmB, this.hlC.hlJ, this.hlC.hlI, this.hlC.hlJ * 60 * 1000, this.hlC.hlL);
            a("performance_15", this.bmB, this.hlC.hlO, this.hlC.hlN, this.hlC.hlO * 60 * 1000, this.hlC.hlQ);
        } else if (cVar.hlH != 0 && !TextUtils.isEmpty(cVar.hlN) && cVar.hlM == 0) {
            a("performance_15", this.bmB, this.hlC.hlO, this.hlC.hlN, this.hlC.hlO * 60 * 1000, this.hlC.hlQ);
        } else if (cVar.hlH == 0 && !TextUtils.isEmpty(cVar.hlI) && cVar.hlM != 0) {
            a("performance_5", this.bmB, this.hlC.hlJ, this.hlC.hlI, this.hlC.hlJ * 60 * 1000, this.hlC.hlL);
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
        final a aVar = new a(this.mPageContext.getPageActivity());
        aVar.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.performancewatchtask.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.hide();
                if (b.this.hlC != null && b.this.mType == null) {
                    b.this.cem();
                    b.this.HY(b.this.hlC.hlK);
                }
            }
        });
        aVar.a(str, i, this.mUserId, "立即领取", this.mLiveInfo);
        aVar.vV(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cem() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913253, "ala/guess/cancelResult"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HY(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.ai.c cVar = new com.baidu.live.ai.c();
            cVar.url = str;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            a(UbcStatisticLiveKey.KEY_ID_1396, "click", "taskcomp_clk", (String) null, -1);
        }
    }

    private void eE(long j) {
        HttpMessage httpMessage = new HttpMessage(1021220);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private static void bTN() {
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
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "liveroom", str3).setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
    }
}
