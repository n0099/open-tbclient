package com.baidu.tieba.ala;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.data.at;
import com.baidu.live.gift.ac;
import com.baidu.live.o.d;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
import com.baidu.live.utils.k;
import com.baidu.live.utils.q;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.g.a {
    ab aJZ;
    private CustomMessageListener goA;
    private CustomMessageListener goB;
    private CustomMessageListener goC;
    com.baidu.live.view.web.a[] goD;
    com.baidu.live.o.d goE;
    private boolean goI;
    private PendantParentView gou;
    private PendantChildView gov;
    private e gow;
    protected AlaDailyTaskView gox;
    private CustomMessageListener goy;
    private CustomMessageListener goz;
    private Context mContext;
    public long watchTime = 0;
    public long goF = 0;
    public long NN = 0;
    private long goG = 0;
    public Handler mHandler = new Handler();
    private int goH = 0;
    private boolean goJ = false;
    private int aNV = 0;
    private Runnable goK = new Runnable() { // from class: com.baidu.tieba.ala.a.6
        @Override // java.lang.Runnable
        public void run() {
            a.this.watchTime++;
            if (a.this.mHandler != null) {
                a.this.mHandler.postDelayed(this, 1000L);
            }
        }
    };
    private Runnable goL = new Runnable() { // from class: com.baidu.tieba.ala.a.7
        @Override // java.lang.Runnable
        public void run() {
            a.this.goF++;
            if (a.this.mHandler != null) {
                a.this.mHandler.postDelayed(this, 1000L);
                if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aMJ && a.this.goF == com.baidu.live.ae.a.Qj().buX.aMK) {
                    a.this.Mk();
                }
            }
        }
    };
    private Runnable goM = new Runnable() { // from class: com.baidu.tieba.ala.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.NN++;
            if (a.this.NN >= a.this.goG) {
                if (a.this.goI) {
                    a.this.goE.dK(1);
                    a.this.goI = false;
                }
            } else if (a.this.mHandler != null) {
                a.this.mHandler.postDelayed(this, 1000L);
                a.this.goI = true;
            }
        }
    };
    private com.baidu.live.view.web.h bWa = new com.baidu.live.view.web.h() { // from class: com.baidu.tieba.ala.a.9
        @Override // com.baidu.live.view.web.h
        public boolean iz(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            cVar.isFullScreen = a.this.el(str, "fullscreen");
            cVar.url = str;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            return true;
        }
    };

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.g.a
    public void a(ViewGroup viewGroup, ab abVar) {
        registerListener();
        this.aJZ = abVar;
        Mi();
        bOc();
        bOd();
        this.goG = abVar.aIO.aNX;
        this.aNV = abVar.aIO.aNV;
        if (abVar.aIO.aNY == 1) {
            bOe();
            this.goI = true;
        } else {
            this.NN = this.goG;
            this.goI = false;
        }
        if (this.goE == null) {
            this.goE = new com.baidu.live.o.d();
            this.goE.OD();
        }
        if (viewGroup != null && abVar.aIO.aNT && abVar.aIO.aNW != 3 && (viewGroup instanceof PendantParentView)) {
            this.gou = (PendantParentView) viewGroup;
            bNZ();
            bOa();
        }
    }

    @Override // com.baidu.live.g.a
    public void a(ab abVar) {
        try {
            int parseInt = Integer.parseInt(StringHelper.long2String(abVar.serverTime, Config.DEVICE_ID_SEC));
            if (this.goH < parseInt && this.goJ) {
                this.goG = abVar.aIO.aNX;
                I(true, true);
            }
            this.goH = parseInt;
            this.goJ = true;
        } catch (Exception e) {
        }
    }

    private void bNZ() {
        if (this.gov == null) {
            this.gov = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.a.1
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
                    return (this.bwT == PendantParentView.Model.VERTICAL || this.bwT == PendantParentView.Model.VERTICAL_BB_CHATING) ? 97 : 40;
                }
            };
            this.gov.setBackgroundColor(0);
        }
        if (this.gou != null && this.gou.indexOfChild(this.gov) < 0) {
            this.gou.a(this.gov, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void bOa() {
        com.baidu.live.view.web.a[] aVarArr;
        if (this.gox == null) {
            this.gox = new AlaDailyTaskView(this.gov);
            if (this.goD == null) {
                com.baidu.live.view.web.g gVar = new com.baidu.live.view.web.g();
                gVar.t((Activity) this.mContext).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.a.11
                    @Override // com.baidu.live.view.web.f
                    public void fp(int i) {
                    }
                }).a(this.gox.getWebView().getSchemeCallback()).b(this.bWa);
                this.goD = gVar.XY();
            }
            for (com.baidu.live.view.web.a aVar : this.goD) {
                this.gox.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gox.getWebView().loadUrl(this.aJZ.aIO.aNU);
        } else {
            this.gox.getWebView().reload();
        }
        if (this.gov != null && this.gov.indexOfChild(this.gox) < 0) {
            this.gov.addView(this.gox, new ViewGroup.LayoutParams(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds140), this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds140)));
        }
    }

    private void registerListener() {
        if (this.goy == null) {
            this.goy = new CustomMessageListener(2913279) { // from class: com.baidu.tieba.ala.a.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        String optString = jSONObject.optString("command");
                        if (optString.equals("hiddenRedPacketPendant")) {
                            a.this.bOb();
                        } else if (optString.equals("openTaskListPage")) {
                            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                            cVar.url = a.this.aJZ.aIO.aNS;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                            a.this.Mf();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913289, ""));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.goy);
        }
        if (this.goz == null) {
            this.goz = new CustomMessageListener(2913280) { // from class: com.baidu.tieba.ala.a.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SchemeCallbackWithName schemeCallbackWithName;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (schemeCallbackWithName = (SchemeCallbackWithName) customResponsedMessage.getData()) != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("watchTime", a.this.watchTime);
                            jSONObject.put("taskStatus", a.this.aJZ.aIO.aNW);
                            jSONObject.put("needWatchTime", a.this.aNV);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        schemeCallbackWithName.schemeCallback.doJsCallback(1, "", jSONObject, schemeCallbackWithName.callBackName);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.goz);
        }
        if (this.goA == null) {
            this.goA = new CustomMessageListener(2913282) { // from class: com.baidu.tieba.ala.a.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    String str;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (str = (String) customResponsedMessage.getData()) != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            at atVar = new at();
                            atVar.parseJson(jSONObject);
                            if (jSONObject.optInt("taskid") == 1) {
                                a.this.tl(atVar.aNM.aNZ);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.goA);
        }
        if (this.goB == null) {
            this.goB = new CustomMessageListener(2913285) { // from class: com.baidu.tieba.ala.a.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SchemeCallbackWithName schemeCallbackWithName;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (schemeCallbackWithName = (SchemeCallbackWithName) customResponsedMessage.getData()) != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("countDownTime", a.this.goG - a.this.NN);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        schemeCallbackWithName.schemeCallback.doJsCallback(1, "", jSONObject, schemeCallbackWithName.callBackName);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.goB);
        }
        if (this.goC == null) {
            this.goC = new CustomMessageListener(2913286) { // from class: com.baidu.tieba.ala.a.16
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    SchemeCallbackWithName schemeCallbackWithName;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (schemeCallbackWithName = (SchemeCallbackWithName) customResponsedMessage.getData()) != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (a.this.aJZ.aIz.userId == 0) {
                                jSONObject.put("user_id", "");
                            } else {
                                jSONObject.put("user_id", EncryptionHelper.getEncryptionUserId(a.this.aJZ.aIz.userId + ""));
                            }
                            jSONObject.put("charm_user_id", EncryptionHelper.getEncryptionUserId(a.this.aJZ.aId.userId + ""));
                            jSONObject.put("room_id", a.this.aJZ.mLiveInfo.room_id);
                            jSONObject.put("live_id", a.this.aJZ.mLiveInfo.live_id);
                            jSONObject.put("is_host", a.this.aJZ.isHost);
                            jSONObject.put("scene_from", q.Fv());
                            jSONObject.put("live_enter_type", TbConfig.getLiveEnterFrom());
                            jSONObject.put("subapp_type", TbConfig.getSubappType());
                            jSONObject.put("_client_type", "2");
                            jSONObject.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
                            jSONObject.put("net_type", BdNetTypeUtil.netType());
                            jSONObject.put("_os_version", Build.VERSION.RELEASE);
                            jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
                            jSONObject.put("brand_type", Build.MODEL);
                            jSONObject.put("vid", a.this.aJZ.mLiveInfo.feed_id);
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
            MessageManager.getInstance().registerListener(this.goC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(int i) {
        this.goG = i;
        this.NN = 0L;
        I(true, true);
    }

    @Override // com.baidu.live.g.a
    public void setCanVisible(boolean z) {
        if (this.gov != null) {
            if (z) {
                this.gov.setVisibility(0);
            } else {
                this.gov.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.g.a
    public void xh() {
        G(true, false);
        H(true, false);
        quitRoom();
    }

    @Override // com.baidu.live.g.a
    public void onPause() {
        G(false, false);
        I(false, false);
        if (this.gox != null) {
            this.gox.getWebView().onPause();
        }
    }

    @Override // com.baidu.live.g.a
    public void onResume() {
        bOc();
        bOe();
        bOd();
        if (this.gox != null) {
            this.gox.getWebView().onResume();
        }
    }

    @Override // com.baidu.live.g.a
    public void onStop() {
        H(false, false);
    }

    @Override // com.baidu.live.g.a
    public void onDestroy() {
        quitRoom();
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        if (this.goE != null) {
            this.goE.OG();
        }
    }

    private void quitRoom() {
        if (this.goy != null) {
            MessageManager.getInstance().unRegisterListener(this.goy);
            this.goy = null;
        }
        if (this.goz != null) {
            MessageManager.getInstance().unRegisterListener(this.goz);
            this.goz = null;
        }
        if (this.goA != null) {
            MessageManager.getInstance().unRegisterListener(this.goA);
            this.goA = null;
        }
        if (this.goB != null) {
            MessageManager.getInstance().unRegisterListener(this.goB);
            this.goB = null;
        }
        if (this.goC != null) {
            MessageManager.getInstance().unRegisterListener(this.goC);
            this.goC = null;
        }
        if (this.gox != null) {
            this.gox.getWebView().release();
            this.gox = null;
            this.goD = null;
        }
        bOb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOb() {
        if (this.gox != null && (this.gox.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gox.getParent()).removeView(this.gox);
        }
        if (this.gov != null && (this.gov.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gov.getParent()).removeView(this.gov);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOc() {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.17
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.goK);
                        a.this.mHandler.post(a.this.goK);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOd() {
        if (this.mHandler != null && TbadkCoreApplication.isLogin() && !this.gow.gre) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.18
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.goL);
                        a.this.mHandler.post(a.this.goL);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOe() {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.goM);
                        a.this.mHandler.post(a.this.goM);
                    }
                }
            });
        }
    }

    private void G(final boolean z, final boolean z2) {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.goK);
                        if (z) {
                            a.this.watchTime = 0L;
                        }
                        if (z2) {
                            a.this.bOc();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(final boolean z, final boolean z2) {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.goL);
                        if (z) {
                            a.this.goF = 0L;
                        }
                        if (z2) {
                            a.this.bOd();
                        }
                    }
                }
            });
        }
    }

    private void I(final boolean z, final boolean z2) {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mHandler != null) {
                        a.this.mHandler.removeCallbacks(a.this.goM);
                        if (z) {
                            a.this.NN = 0L;
                        }
                        if (z2) {
                            a.this.bOe();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean el(String str, String str2) {
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

    private void Mi() {
        Mj();
        String str = this.gow.date;
        if (!this.gow.gre && !TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.gow.gre = false;
            this.gow.brp = 0;
        }
    }

    private void Mj() {
        if (this.gow == null) {
            this.gow = new e();
        }
        String string = com.baidu.live.d.xc().getString("barrage_card_toast_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.gow.gre = jSONObject.optBoolean("hasToast");
                    if (!this.gow.gre) {
                        this.gow.date = b2;
                        this.gow.brp = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mk() {
        if (!this.gow.gre && this.gow.brp <= 1) {
            String b2 = k.b(new Date());
            if (b2.equals(this.gow.date)) {
                this.gow.brp++;
            } else {
                this.gow.date = b2;
                this.gow.brp = 1;
            }
            if (this.gow.brp == 1) {
                this.goE.h(this.aJZ.mLiveInfo.live_id, String.valueOf(this.aJZ.aIz.userId));
                this.goE.a(new d.a() { // from class: com.baidu.tieba.ala.a.10
                    @Override // com.baidu.live.o.d.a
                    public void hq(String str) {
                        BdUtilHelper.showToast(a.this.mContext, str, SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
                        a.this.gow.gre = true;
                        com.baidu.live.d.xc().putString("barrage_card_toast_show_times_date", a.this.gow.toJsonString());
                        ac.gl("barrage_card");
                        a.this.H(true, false);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("bullechat_give", 2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BARRAGE_CARD_RECEIVE).setContentExt(jSONObject));
                    }

                    @Override // com.baidu.live.o.d.a
                    public void y(int i, String str) {
                        a.this.gow.brp = 0;
                        a.this.gow.gre = false;
                        com.baidu.live.d.xc().putString("barrage_card_toast_show_times_date", a.this.gow.toJsonString());
                        a.this.H(true, false);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("task_from", LogConfig.VALUE_LIVE_PENDANT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_CLICK).setContentExt(jSONObject));
    }
}
