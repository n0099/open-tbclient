package com.baidu.tieba.ala;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.ap;
import com.baidu.live.data.x;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.scheme.SchemeCallbackWithName;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.q;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.h.a {
    x aHu;
    private PendantParentView glA;
    private PendantChildView glB;
    protected AlaDailyTaskView glC;
    private CustomMessageListener glD;
    private CustomMessageListener glE;
    private CustomMessageListener glF;
    private CustomMessageListener glG;
    private CustomMessageListener glH;
    com.baidu.live.view.web.a[] glI;
    com.baidu.live.p.d glJ;
    private boolean glM;
    private Context mContext;
    public long watchTime = 0;
    public long NQ = 0;
    private long glK = 0;
    public Handler mHandler = new Handler();
    private int glL = 0;
    private boolean glN = false;
    private int aKZ = 0;
    private Runnable glO = new Runnable() { // from class: com.baidu.tieba.ala.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.watchTime++;
            if (a.this.mHandler != null) {
                a.this.mHandler.postDelayed(this, 1000L);
            }
        }
    };
    private Runnable glP = new Runnable() { // from class: com.baidu.tieba.ala.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.NQ++;
            if (a.this.NQ >= a.this.glK) {
                if (a.this.glM) {
                    a.this.glJ.dE(1);
                    a.this.glM = false;
                }
            } else if (a.this.mHandler != null) {
                a.this.mHandler.postDelayed(this, 1000L);
                a.this.glM = true;
            }
        }
    };
    private com.baidu.live.view.web.h bSg = new com.baidu.live.view.web.h() { // from class: com.baidu.tieba.ala.a.6
        @Override // com.baidu.live.view.web.h
        public void hZ(String str) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                cVar.isFullScreen = a.this.aT(str, "fullscreen");
                cVar.url = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.h.a
    public void a(ViewGroup viewGroup, x xVar) {
        registerListener();
        this.aHu = xVar;
        bNv();
        this.glK = xVar.aGs.aLb;
        this.aKZ = xVar.aGs.aKZ;
        if (xVar.aGs.aLc == 1) {
            bNw();
            this.glM = true;
        } else {
            this.NQ = this.glK;
            this.glM = false;
        }
        if (this.glJ == null) {
            this.glJ = new com.baidu.live.p.d();
            this.glJ.Nf();
        }
        if (viewGroup != null && xVar.aGs.aKX && xVar.aGs.aLa != 3 && (viewGroup instanceof PendantParentView)) {
            this.glA = (PendantParentView) viewGroup;
            bNr();
            bNs();
        }
    }

    @Override // com.baidu.live.h.a
    public void a(x xVar) {
        try {
            int parseInt = Integer.parseInt(StringHelper.long2String(xVar.serverTime, Config.DEVICE_ID_SEC));
            if (this.glL < parseInt && this.glN) {
                this.glK = xVar.aGs.aLb;
                I(true, true);
            }
            this.glL = parseInt;
            this.glN = true;
        } catch (Exception e) {
        }
    }

    private void bNr() {
        if (this.glB == null) {
            this.glB = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.a.1
                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalPkPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalBBChattingPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getHorizontalPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getHorizontalFullPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public int getPriority() {
                    return (this.btq == PendantParentView.Model.VERTICAL || this.btq == PendantParentView.Model.VERTICAL_BB_CHATING) ? 97 : 40;
                }
            };
            this.glB.setBackgroundColor(0);
        }
        if (this.glA != null && this.glA.indexOfChild(this.glB) < 0) {
            this.glA.a(this.glB, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void bNs() {
        com.baidu.live.view.web.a[] aVarArr;
        if (this.glC == null) {
            this.glC = new AlaDailyTaskView(this.glB);
            if (this.glI == null) {
                com.baidu.live.view.web.g gVar = new com.baidu.live.view.web.g();
                gVar.w((Activity) this.mContext).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.a.7
                    @Override // com.baidu.live.view.web.f
                    public void dL(int i) {
                    }
                }).a(this.glC.getWebView().getSchemeCallback()).b(this.bSg);
                this.glI = gVar.Wm();
            }
            for (com.baidu.live.view.web.a aVar : this.glI) {
                this.glC.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.glC.getWebView().loadUrl(this.aHu.aGs.aKY);
        } else {
            this.glC.getWebView().reload();
        }
        if (this.glB != null && this.glB.indexOfChild(this.glC) < 0) {
            this.glB.addView(this.glC, new ViewGroup.LayoutParams(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds140), this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds140)));
        }
    }

    private void registerListener() {
        if (this.glD == null) {
            this.glD = new CustomMessageListener(2913279) { // from class: com.baidu.tieba.ala.a.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        String optString = jSONObject.optString("command");
                        if (optString.equals("hiddenRedPacketPendant")) {
                            a.this.bNu();
                        } else if (optString.equals("openTaskListPage")) {
                            com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                            cVar.url = a.this.aHu.aGs.aKW;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                            a.this.KH();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913289, ""));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.glD);
        }
        if (this.glE == null) {
            this.glE = new CustomMessageListener(2913280) { // from class: com.baidu.tieba.ala.a.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SchemeCallbackWithName schemeCallbackWithName;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (schemeCallbackWithName = (SchemeCallbackWithName) customResponsedMessage.getData()) != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("watchTime", a.this.watchTime);
                            jSONObject.put("taskStatus", a.this.aHu.aGs.aLa);
                            jSONObject.put("needWatchTime", a.this.aKZ);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        schemeCallbackWithName.schemeCallback.doJsCallback(1, "", jSONObject, schemeCallbackWithName.callBackName);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.glE);
        }
        if (this.glF == null) {
            this.glF = new CustomMessageListener(2913282) { // from class: com.baidu.tieba.ala.a.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    String str;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (str = (String) customResponsedMessage.getData()) != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            ap apVar = new ap();
                            apVar.parseJson(jSONObject);
                            if (jSONObject.optInt("taskid") == 1) {
                                a.this.tf(apVar.aKQ.aLd);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.glF);
        }
        if (this.glG == null) {
            this.glG = new CustomMessageListener(2913285) { // from class: com.baidu.tieba.ala.a.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SchemeCallbackWithName schemeCallbackWithName;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (schemeCallbackWithName = (SchemeCallbackWithName) customResponsedMessage.getData()) != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("countDownTime", a.this.glK - a.this.NQ);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        schemeCallbackWithName.schemeCallback.doJsCallback(1, "", jSONObject, schemeCallbackWithName.callBackName);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.glG);
        }
        if (this.glH == null) {
            this.glH = new CustomMessageListener(2913286) { // from class: com.baidu.tieba.ala.a.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SchemeCallbackWithName schemeCallbackWithName;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (schemeCallbackWithName = (SchemeCallbackWithName) customResponsedMessage.getData()) != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (a.this.aHu.aGd.userId == 0) {
                                jSONObject.put("user_id", "");
                            } else {
                                jSONObject.put("user_id", EncryptionHelper.getEncryptionUserId(a.this.aHu.aGd.userId + ""));
                            }
                            jSONObject.put("charm_user_id", EncryptionHelper.getEncryptionUserId(a.this.aHu.aFH.userId + ""));
                            jSONObject.put("room_id", a.this.aHu.mLiveInfo.room_id);
                            jSONObject.put("live_id", a.this.aHu.mLiveInfo.live_id);
                            jSONObject.put("is_host", a.this.aHu.isHost);
                            jSONObject.put("scene_from", q.Ef());
                            jSONObject.put("live_enter_type", TbConfig.getLiveEnterFrom());
                            jSONObject.put("subapp_type", TbConfig.getSubappType());
                            jSONObject.put("_client_type", "2");
                            jSONObject.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
                            jSONObject.put("net_type", BdNetTypeUtil.netType());
                            jSONObject.put("_os_version", Build.VERSION.RELEASE);
                            jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
                            jSONObject.put("brand_type", Build.MODEL);
                            jSONObject.put("vid", a.this.aHu.mLiveInfo.feed_id);
                            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SID, ExtraParamsManager.getBaiduSid());
                            jSONObject.put("entry", "");
                            jSONObject.put("sdkbuildpath", "");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        schemeCallbackWithName.schemeCallback.doJsCallback(1, "", jSONObject, schemeCallbackWithName.callBackName);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.glH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf(int i) {
        this.glK = i;
        this.NQ = 0L;
        I(true, true);
    }

    @Override // com.baidu.live.h.a
    public void setCanVisible(boolean z) {
        if (this.glB != null) {
            if (z) {
                this.glB.setVisibility(0);
            } else {
                this.glB.setVisibility(8);
            }
            Log.e("pendent_check", "==>> dailytask  mCharmParentView.setVisibility() canVisible : " + z);
        }
    }

    @Override // com.baidu.live.h.a
    public void xk() {
        H(true, false);
        bNt();
    }

    @Override // com.baidu.live.h.a
    public void onPause() {
        H(false, false);
        I(false, false);
        if (this.glC != null) {
            this.glC.getWebView().onPause();
        }
    }

    @Override // com.baidu.live.h.a
    public void onResume() {
        bNv();
        bNw();
        if (this.glC != null) {
            this.glC.getWebView().onResume();
        }
    }

    @Override // com.baidu.live.h.a
    public void onDestroy() {
        bNt();
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        if (this.glJ != null) {
            this.glJ.Nh();
        }
    }

    private void bNt() {
        if (this.glD != null) {
            MessageManager.getInstance().unRegisterListener(this.glD);
            this.glD = null;
        }
        if (this.glE != null) {
            MessageManager.getInstance().unRegisterListener(this.glE);
            this.glE = null;
        }
        if (this.glF != null) {
            MessageManager.getInstance().unRegisterListener(this.glF);
            this.glF = null;
        }
        if (this.glG != null) {
            MessageManager.getInstance().unRegisterListener(this.glG);
            this.glG = null;
        }
        if (this.glH != null) {
            MessageManager.getInstance().unRegisterListener(this.glH);
            this.glH = null;
        }
        if (this.glC != null) {
            this.glC.getWebView().release();
            this.glC = null;
            this.glI = null;
        }
        bNu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNu() {
        if (this.glC != null && (this.glC.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.glC.getParent()).removeView(this.glC);
        }
        if (this.glB != null && (this.glB.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.glB.getParent()).removeView(this.glB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNv() {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.glO);
                        a.this.mHandler.post(a.this.glO);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNw() {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.14
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.glP);
                        a.this.mHandler.post(a.this.glP);
                    }
                }
            });
        }
    }

    private void H(final boolean z, final boolean z2) {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.glO);
                        if (z) {
                            a.this.watchTime = 0L;
                        }
                        if (z2) {
                            a.this.bNv();
                        }
                    }
                }
            });
        }
    }

    private void I(final boolean z, final boolean z2) {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.glP);
                        if (z) {
                            a.this.NQ = 0L;
                        }
                        if (z2) {
                            a.this.bNw();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aT(String str, String str2) {
        String queryParameter = Uri.parse(str).getQueryParameter(str2);
        if (TextUtils.isEmpty(queryParameter)) {
            int indexOf = str.indexOf(str2 + "=");
            int length = str2.length() + 1;
            if (indexOf >= 0 && indexOf + length + 1 <= str.length()) {
                queryParameter = str.substring(indexOf + length, indexOf + length + 1);
            }
        }
        if (TextUtils.isEmpty(queryParameter)) {
            return false;
        }
        try {
            return Integer.parseInt(queryParameter) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("task_from", LogConfig.VALUE_LIVE_PENDANT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_CLICK).setContentExt(jSONObject));
    }
}
