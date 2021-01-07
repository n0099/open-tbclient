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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.h.a {
    x aMh;
    private PendantParentView gqh;
    private PendantChildView gqi;
    protected AlaDailyTaskView gqj;
    private CustomMessageListener gqk;
    private CustomMessageListener gql;
    private CustomMessageListener gqm;
    private CustomMessageListener gqn;
    private CustomMessageListener gqo;
    com.baidu.live.view.web.a[] gqp;
    com.baidu.live.p.d gqq;
    private boolean gqt;
    private Context mContext;
    public long watchTime = 0;
    public long NT = 0;
    private long gqr = 0;
    public Handler mHandler = new Handler();
    private int gqs = 0;
    private boolean gqu = false;
    private int aPM = 0;
    private Runnable gqv = new Runnable() { // from class: com.baidu.tieba.ala.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.watchTime++;
            if (a.this.mHandler != null) {
                a.this.mHandler.postDelayed(this, 1000L);
            }
        }
    };
    private Runnable gqw = new Runnable() { // from class: com.baidu.tieba.ala.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.NT++;
            if (a.this.NT >= a.this.gqr) {
                if (a.this.gqt) {
                    a.this.gqq.fk(1);
                    a.this.gqt = false;
                }
            } else if (a.this.mHandler != null) {
                a.this.mHandler.postDelayed(this, 1000L);
                a.this.gqt = true;
            }
        }
    };
    private com.baidu.live.view.web.h bWS = new com.baidu.live.view.web.h() { // from class: com.baidu.tieba.ala.a.6
        @Override // com.baidu.live.view.web.h
        public void jk(String str) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                cVar.isFullScreen = a.this.aU(str, "fullscreen");
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
        this.aMh = xVar;
        bRn();
        this.gqr = xVar.aLf.aPO;
        this.aPM = xVar.aLf.aPM;
        if (xVar.aLf.aPP == 1) {
            bRo();
            this.gqt = true;
        } else {
            this.NT = this.gqr;
            this.gqt = false;
        }
        if (this.gqq == null) {
            this.gqq = new com.baidu.live.p.d();
            this.gqq.Ra();
        }
        if (viewGroup != null && xVar.aLf.aPK && xVar.aLf.aPN != 3 && (viewGroup instanceof PendantParentView)) {
            this.gqh = (PendantParentView) viewGroup;
            bRj();
            bRk();
        }
    }

    @Override // com.baidu.live.h.a
    public void a(x xVar) {
        try {
            int parseInt = Integer.parseInt(StringHelper.long2String(xVar.serverTime, Config.DEVICE_ID_SEC));
            if (this.gqs < parseInt && this.gqu) {
                this.gqr = xVar.aLf.aPO;
                I(true, true);
            }
            this.gqs = parseInt;
            this.gqu = true;
        } catch (Exception e) {
        }
    }

    private void bRj() {
        if (this.gqi == null) {
            this.gqi = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.a.1
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
                    return (this.byd == PendantParentView.Model.VERTICAL || this.byd == PendantParentView.Model.VERTICAL_BB_CHATING) ? 97 : 40;
                }
            };
            this.gqi.setBackgroundColor(0);
        }
        if (this.gqh != null && this.gqh.indexOfChild(this.gqi) < 0) {
            this.gqh.a(this.gqi, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void bRk() {
        com.baidu.live.view.web.a[] aVarArr;
        if (this.gqj == null) {
            this.gqj = new AlaDailyTaskView(this.gqi);
            if (this.gqp == null) {
                com.baidu.live.view.web.g gVar = new com.baidu.live.view.web.g();
                gVar.w((Activity) this.mContext).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.a.7
                    @Override // com.baidu.live.view.web.f
                    public void fr(int i) {
                    }
                }).a(this.gqj.getWebView().getSchemeCallback()).b(this.bWS);
                this.gqp = gVar.aaf();
            }
            for (com.baidu.live.view.web.a aVar : this.gqp) {
                this.gqj.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gqj.getWebView().loadUrl(this.aMh.aLf.aPL);
        } else {
            this.gqj.getWebView().reload();
        }
        if (this.gqi != null && this.gqi.indexOfChild(this.gqj) < 0) {
            this.gqi.addView(this.gqj, new ViewGroup.LayoutParams(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds140), this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds140)));
        }
    }

    private void registerListener() {
        if (this.gqk == null) {
            this.gqk = new CustomMessageListener(2913279) { // from class: com.baidu.tieba.ala.a.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        String optString = jSONObject.optString("command");
                        if (optString.equals("hiddenRedPacketPendant")) {
                            a.this.bRm();
                        } else if (optString.equals("openTaskListPage")) {
                            com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                            cVar.url = a.this.aMh.aLf.aPJ;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                            a.this.OC();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913289, ""));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gqk);
        }
        if (this.gql == null) {
            this.gql = new CustomMessageListener(2913280) { // from class: com.baidu.tieba.ala.a.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SchemeCallbackWithName schemeCallbackWithName;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (schemeCallbackWithName = (SchemeCallbackWithName) customResponsedMessage.getData()) != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("watchTime", a.this.watchTime);
                            jSONObject.put("taskStatus", a.this.aMh.aLf.aPN);
                            jSONObject.put("needWatchTime", a.this.aPM);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        schemeCallbackWithName.schemeCallback.doJsCallback(1, "", jSONObject, schemeCallbackWithName.callBackName);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gql);
        }
        if (this.gqm == null) {
            this.gqm = new CustomMessageListener(2913282) { // from class: com.baidu.tieba.ala.a.10
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
                                a.this.uL(apVar.aPD.aPQ);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gqm);
        }
        if (this.gqn == null) {
            this.gqn = new CustomMessageListener(2913285) { // from class: com.baidu.tieba.ala.a.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SchemeCallbackWithName schemeCallbackWithName;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (schemeCallbackWithName = (SchemeCallbackWithName) customResponsedMessage.getData()) != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("countDownTime", a.this.gqr - a.this.NT);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        schemeCallbackWithName.schemeCallback.doJsCallback(1, "", jSONObject, schemeCallbackWithName.callBackName);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gqn);
        }
        if (this.gqo == null) {
            this.gqo = new CustomMessageListener(2913286) { // from class: com.baidu.tieba.ala.a.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SchemeCallbackWithName schemeCallbackWithName;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (schemeCallbackWithName = (SchemeCallbackWithName) customResponsedMessage.getData()) != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (a.this.aMh.aKQ.userId == 0) {
                                jSONObject.put("user_id", "");
                            } else {
                                jSONObject.put("user_id", EncryptionHelper.getEncryptionUserId(a.this.aMh.aKQ.userId + ""));
                            }
                            jSONObject.put("charm_user_id", EncryptionHelper.getEncryptionUserId(a.this.aMh.aKu.userId + ""));
                            jSONObject.put("room_id", a.this.aMh.mLiveInfo.room_id);
                            jSONObject.put("live_id", a.this.aMh.mLiveInfo.live_id);
                            jSONObject.put("is_host", a.this.aMh.isHost);
                            jSONObject.put("scene_from", q.Ia());
                            jSONObject.put("live_enter_type", TbConfig.getLiveEnterFrom());
                            jSONObject.put("subapp_type", TbConfig.getSubappType());
                            jSONObject.put("_client_type", "2");
                            jSONObject.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
                            jSONObject.put("net_type", BdNetTypeUtil.netType());
                            jSONObject.put("_os_version", Build.VERSION.RELEASE);
                            jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
                            jSONObject.put("brand_type", Build.MODEL);
                            jSONObject.put("vid", a.this.aMh.mLiveInfo.feed_id);
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
            MessageManager.getInstance().registerListener(this.gqo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uL(int i) {
        this.gqr = i;
        this.NT = 0L;
        I(true, true);
    }

    @Override // com.baidu.live.h.a
    public void setCanVisible(boolean z) {
        if (this.gqi != null) {
            if (z) {
                this.gqi.setVisibility(0);
            } else {
                this.gqi.setVisibility(8);
            }
            Log.e("pendent_check", "==>> dailytask  mCharmParentView.setVisibility() canVisible : " + z);
        }
    }

    @Override // com.baidu.live.h.a
    public void Bf() {
        H(true, false);
        bRl();
    }

    @Override // com.baidu.live.h.a
    public void onPause() {
        H(false, false);
        I(false, false);
        if (this.gqj != null) {
            this.gqj.getWebView().onPause();
        }
    }

    @Override // com.baidu.live.h.a
    public void onResume() {
        bRn();
        bRo();
        if (this.gqj != null) {
            this.gqj.getWebView().onResume();
        }
    }

    @Override // com.baidu.live.h.a
    public void onDestroy() {
        bRl();
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        if (this.gqq != null) {
            this.gqq.Rc();
        }
    }

    private void bRl() {
        if (this.gqk != null) {
            MessageManager.getInstance().unRegisterListener(this.gqk);
            this.gqk = null;
        }
        if (this.gql != null) {
            MessageManager.getInstance().unRegisterListener(this.gql);
            this.gql = null;
        }
        if (this.gqm != null) {
            MessageManager.getInstance().unRegisterListener(this.gqm);
            this.gqm = null;
        }
        if (this.gqn != null) {
            MessageManager.getInstance().unRegisterListener(this.gqn);
            this.gqn = null;
        }
        if (this.gqo != null) {
            MessageManager.getInstance().unRegisterListener(this.gqo);
            this.gqo = null;
        }
        if (this.gqj != null) {
            this.gqj.getWebView().release();
            this.gqj = null;
            this.gqp = null;
        }
        bRm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRm() {
        if (this.gqj != null && (this.gqj.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqj.getParent()).removeView(this.gqj);
        }
        if (this.gqi != null && (this.gqi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqi.getParent()).removeView(this.gqi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRn() {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.gqv);
                        a.this.mHandler.post(a.this.gqv);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRo() {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.14
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.gqw);
                        a.this.mHandler.post(a.this.gqw);
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
                        a.this.mHandler.removeCallbacks(a.this.gqv);
                        if (z) {
                            a.this.watchTime = 0L;
                        }
                        if (z2) {
                            a.this.bRn();
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
                        a.this.mHandler.removeCallbacks(a.this.gqw);
                        if (z) {
                            a.this.NT = 0L;
                        }
                        if (z2) {
                            a.this.bRo();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aU(String str, String str2) {
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
    public void OC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("task_from", LogConfig.VALUE_LIVE_PENDANT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_CLICK).setContentExt(jSONObject));
    }
}
