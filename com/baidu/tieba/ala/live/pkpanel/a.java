package com.baidu.tieba.ala.live.pkpanel;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.ad;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView;
import com.baidu.tieba.ala.live.pkpanel.widget.AlaDragContainerView;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.s.a {
    private w bur;
    private View haD;
    private ViewGroup haE;
    private CustomMessageListener haF;
    private AlaPkPanelWebView haG;
    private HandlerC0676a haH;
    private List<String> haI;
    private CustomMessageListener haJ;
    private CustomMessageListener haK;
    private com.baidu.tieba.ala.live.pkpanel.a.a haL;
    private ad haN;
    private AlaDragContainerView haO;
    private CustomMessageListener haP;
    private Context mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    private int haM = 1;
    private int mOrientation = 1;
    private h bRm = new h() { // from class: com.baidu.tieba.ala.live.pkpanel.a.2
        @Override // com.baidu.live.view.web.h
        public void jr(String str) {
            if (TextUtils.isEmpty(str)) {
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mScreenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.mScreenHeight = ScreenHelper.getScreenHeight(this.mContext);
        registerListener();
    }

    private void bYO() {
        if (this.haI != null) {
            this.haI.clear();
        }
        if (this.haH != null) {
            this.haH.removeMessages(1000);
        }
        bYP();
    }

    private void bYP() {
        if (this.haJ != null) {
            MessageManager.getInstance().unRegisterListener(this.haJ);
            this.haJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYQ() {
        if (Build.VERSION.SDK_INT >= 19) {
            bYS();
            if (this.haH == null) {
                this.haH = new HandlerC0676a(this);
            }
            if (!this.haH.hasMessages(1000)) {
                this.haH.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0676a extends Handler {
        private final WeakReference<a> haS;

        HandlerC0676a(a aVar) {
            this.haS = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.haS.get() != null && message.what == 1000) {
                this.haS.get().bYR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bYR() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.haG != null) {
            if (this.haI == null || (size = this.haI.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.haI.get(i));
                }
                str = jSONArray.toString();
                this.haI.clear();
            }
            if (this.haG.bYW()) {
                z2 = true;
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.haG.evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                        z = true;
                        if (!z) {
                            this.haH.sendEmptyMessageDelayed(1000, 1000L);
                            return;
                        } else {
                            bYO();
                            return;
                        }
                    }
                    this.haG.loadUrl("javascript:getClientInfo(" + str + ")");
                }
            }
            z = z2;
            if (!z) {
            }
        }
    }

    private void bYS() {
        if (this.haI == null) {
            this.haI = new ArrayList();
        }
        this.haI.clear();
        this.haJ = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.live.pkpanel.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.haI.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.haJ);
    }

    private void registerListener() {
        if (this.haK == null) {
            this.haK = new CustomMessageListener(2913259) { // from class: com.baidu.tieba.ala.live.pkpanel.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        if (a.this.haL == null && a.this.mContext != null) {
                            a.this.haL = new com.baidu.tieba.ala.live.pkpanel.a.a(a.this.mContext, a.this.haM, jSONObject);
                        }
                        a.this.haL.RU();
                        a.this.as("10603", "h5_live", "rulepop_show");
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.haK);
        if (this.haF == null) {
            this.haF = new CustomMessageListener(2913257) { // from class: com.baidu.tieba.ala.live.pkpanel.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ad)) {
                        a.this.haN = (ad) customResponsedMessage.getData();
                        if (a.this.haN != null) {
                            BdLog.e("AlaPkPanel:  pkPanelInfo.isOpenAction(): \t" + a.this.haN.Ft());
                            if (a.this.haN.Ft()) {
                                a.this.b(a.this.haN);
                            } else {
                                a.this.a(a.this.haN);
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.haF);
            BdLog.e("AlaPkPanel:  registerListener ==> mLivePkPanelShowListener");
        }
        if (this.haP == null) {
            this.haP = new CustomMessageListener(2913258) { // from class: com.baidu.tieba.ala.live.pkpanel.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null && a.this.haG != null && a.this.haG.getSchemeCallback() != null) {
                        a.this.haG.getSchemeCallback().doJsCallback(0, "", jSONObject, "followCallback ");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.haP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ad adVar) {
        if (this.haD != null && this.haE != null && this.haE.indexOfChild(this.haD) >= 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.haE != null) {
                        a.this.haE.removeView(a.this.haD);
                    }
                    a.this.haG = null;
                    a.this.haO = null;
                    a.this.haD = null;
                    BdLog.e("AlaPkPanel:   closePkPanelView ==> mRootLiveView.removeView(contain)");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ad adVar) {
        final View c = c(adVar);
        if (c != null && this.haE != null && this.haE.indexOfChild(c) < 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.getParent() != null && (c.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) c.getParent()).removeView(c);
                        BdLog.e("AlaPkPanel:  openPkPanelView ==> contain has  Parent ==> parent.removeView(contain)");
                    }
                    if (a.this.haE != null) {
                        a.this.haE.addView(c, new RelativeLayout.LayoutParams(-1, -1));
                        BdLog.e("AlaPkPanel:   openPkPanelView ==> mRootLiveView.addView(contain, llp)");
                    }
                }
            });
        }
    }

    private Handler getSafeHandler() {
        if (this.haH == null) {
            this.haH = new HandlerC0676a(this);
        }
        return this.haH;
    }

    @Override // com.baidu.live.s.a
    public void e(w wVar) {
        this.bur = wVar;
    }

    @Override // com.baidu.live.s.a
    public void b(w wVar) {
        this.bur = wVar;
    }

    @Override // com.baidu.live.s.a
    public void Mg() {
        this.haL = null;
        if (this.haK != null) {
            MessageManager.getInstance().unRegisterListener(this.haK);
            this.haK = null;
        }
        if (this.haP != null) {
            MessageManager.getInstance().unRegisterListener(this.haP);
            this.haP = null;
        }
        if (this.haF != null) {
            MessageManager.getInstance().unRegisterListener(this.haF);
            this.haF = null;
            BdLog.e("AlaPkPanel : onQuitRoom ==> unRegisterListener ==> mLivePkPanelShowListener");
        }
        bYT();
    }

    private void bYT() {
        a(this.haN);
        this.haG = null;
        this.haO = null;
        this.haD = null;
        this.haN = null;
        this.haE = null;
        BdLog.e("AlaPkPanel:  onQuitRoom() ==> quitRoomAndRelease ==>  clear webView Container");
    }

    @Override // com.baidu.live.s.a
    public void m(ViewGroup viewGroup) {
        this.haE = viewGroup;
    }

    public View c(ad adVar) {
        if (adVar != null && this.haD == null) {
            this.haD = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_container, (ViewGroup) null);
            this.haO = (AlaDragContainerView) this.haD.findViewById(a.f.ala_pkpanel_dragview);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.haO.getLayoutParams();
            if (layoutParams != null) {
                if (this.mOrientation == 1) {
                    layoutParams.bottomMargin = (int) (this.mScreenHeight * 0.2d);
                    layoutParams.gravity = 81;
                } else {
                    layoutParams.gravity = 17;
                    layoutParams.bottomMargin = 0;
                }
                this.haO.setLayoutParams(layoutParams);
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) ((adVar.getWidth() / 375.0f) * this.mScreenWidth), (int) ((adVar.getHeight() / 375.0f) * this.mScreenWidth));
            HU(d(adVar));
            this.haO.addView(this.haG, layoutParams2);
        }
        return this.haD;
    }

    private String d(ad adVar) {
        String str = "";
        if (adVar.Fs() != null) {
            str = URLEncoder.encode(adVar.Fs());
        }
        return adVar.Fr() + "?jsonData=" + str + "&room_id=" + getRoomId() + "&live_id=" + getLiveId() + "&subapp_type=" + TbConfig.getSubappType();
    }

    private String getLiveId() {
        return (this.bur == null || this.bur.mLiveInfo == null) ? "" : String.valueOf(this.bur.mLiveInfo.getLiveID());
    }

    private String getRoomId() {
        return (this.bur == null || this.bur.mLiveInfo == null) ? "" : String.valueOf(this.bur.mLiveInfo.room_id);
    }

    private void HU(String str) {
        com.baidu.live.view.web.a[] YO;
        this.haG = new AlaPkPanelWebView(this.mContext);
        this.haG.setCallback(new AlaPkPanelWebView.a() { // from class: com.baidu.tieba.ala.live.pkpanel.a.8
            @Override // com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.a
            public void na(boolean z) {
                if (z) {
                    a.this.bYQ();
                }
            }
        });
        g gVar = new g();
        gVar.x((Activity) this.mContext).a(new f() { // from class: com.baidu.tieba.ala.live.pkpanel.a.9
            @Override // com.baidu.live.view.web.f
            public void fr(int i) {
            }
        }).a(this.haG.getSchemeCallback()).b(this.bRm);
        for (com.baidu.live.view.web.a aVar : gVar.YO()) {
            this.haG.addJavascriptInterface(aVar, aVar.getName());
        }
        this.haG.loadUrl(str);
    }

    @Override // com.baidu.live.s.a
    public void onStop() {
    }

    @Override // com.baidu.live.s.a
    public void onStart() {
    }

    @Override // com.baidu.live.s.a
    public void dX(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.mOrientation = i;
        if (this.haN != null && this.haO != null && (layoutParams = (FrameLayout.LayoutParams) this.haO.getLayoutParams()) != null) {
            if (this.mOrientation == 1) {
                layoutParams.bottomMargin = (int) (this.mScreenHeight * 0.2d);
                layoutParams.gravity = 81;
            } else {
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = 0;
            }
            this.haO.setLayoutParams(layoutParams);
            BdLog.e("AlaPkPanel:   onScreenOrientationChanged ==> mOrientation: " + this.mOrientation);
        }
        if (this.haL != null) {
            this.haL.wg(i);
        } else {
            this.haM = i;
        }
    }

    @Override // com.baidu.live.s.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.haO != null) {
            BdLog.e("AlaPkPanel:   onKeyboardVisibilityChanged ==> isVisibility: " + z);
            this.haO.bYX();
        }
    }

    private String bYU() {
        return (this.bur == null || this.bur.mLiveInfo == null) ? "" : String.valueOf(this.bur.mLiveInfo.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_id", getLiveId());
            jSONObject.putOpt("vid", bYU());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_SID, ExtraParamsManager.getBaiduSid());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.SDK_VERSION);
            jSONObject.put("inbox", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "pkpanel", str3).setContentExt(null, "", jSONObject));
    }
}
