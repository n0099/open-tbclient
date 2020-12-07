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
    private View haB;
    private ViewGroup haC;
    private CustomMessageListener haD;
    private AlaPkPanelWebView haE;
    private HandlerC0676a haF;
    private List<String> haG;
    private CustomMessageListener haH;
    private CustomMessageListener haI;
    private com.baidu.tieba.ala.live.pkpanel.a.a haJ;
    private ad haL;
    private AlaDragContainerView haM;
    private CustomMessageListener haN;
    private Context mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    private int haK = 1;
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

    private void bYN() {
        if (this.haG != null) {
            this.haG.clear();
        }
        if (this.haF != null) {
            this.haF.removeMessages(1000);
        }
        bYO();
    }

    private void bYO() {
        if (this.haH != null) {
            MessageManager.getInstance().unRegisterListener(this.haH);
            this.haH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYP() {
        if (Build.VERSION.SDK_INT >= 19) {
            bYR();
            if (this.haF == null) {
                this.haF = new HandlerC0676a(this);
            }
            if (!this.haF.hasMessages(1000)) {
                this.haF.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0676a extends Handler {
        private final WeakReference<a> haQ;

        HandlerC0676a(a aVar) {
            this.haQ = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.haQ.get() != null && message.what == 1000) {
                this.haQ.get().bYQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bYQ() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.haE != null) {
            if (this.haG == null || (size = this.haG.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.haG.get(i));
                }
                str = jSONArray.toString();
                this.haG.clear();
            }
            if (this.haE.bYV()) {
                z2 = true;
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.haE.evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                        z = true;
                        if (!z) {
                            this.haF.sendEmptyMessageDelayed(1000, 1000L);
                            return;
                        } else {
                            bYN();
                            return;
                        }
                    }
                    this.haE.loadUrl("javascript:getClientInfo(" + str + ")");
                }
            }
            z = z2;
            if (!z) {
            }
        }
    }

    private void bYR() {
        if (this.haG == null) {
            this.haG = new ArrayList();
        }
        this.haG.clear();
        this.haH = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.live.pkpanel.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.haG.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.haH);
    }

    private void registerListener() {
        if (this.haI == null) {
            this.haI = new CustomMessageListener(2913259) { // from class: com.baidu.tieba.ala.live.pkpanel.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        if (a.this.haJ == null && a.this.mContext != null) {
                            a.this.haJ = new com.baidu.tieba.ala.live.pkpanel.a.a(a.this.mContext, a.this.haK, jSONObject);
                        }
                        a.this.haJ.RU();
                        a.this.as("10603", "h5_live", "rulepop_show");
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.haI);
        if (this.haD == null) {
            this.haD = new CustomMessageListener(2913257) { // from class: com.baidu.tieba.ala.live.pkpanel.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ad)) {
                        a.this.haL = (ad) customResponsedMessage.getData();
                        if (a.this.haL != null) {
                            BdLog.e("AlaPkPanel:  pkPanelInfo.isOpenAction(): \t" + a.this.haL.Ft());
                            if (a.this.haL.Ft()) {
                                a.this.b(a.this.haL);
                            } else {
                                a.this.a(a.this.haL);
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.haD);
            BdLog.e("AlaPkPanel:  registerListener ==> mLivePkPanelShowListener");
        }
        if (this.haN == null) {
            this.haN = new CustomMessageListener(2913258) { // from class: com.baidu.tieba.ala.live.pkpanel.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null && a.this.haE != null && a.this.haE.getSchemeCallback() != null) {
                        a.this.haE.getSchemeCallback().doJsCallback(0, "", jSONObject, "followCallback ");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.haN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ad adVar) {
        if (this.haB != null && this.haC != null && this.haC.indexOfChild(this.haB) >= 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.haC != null) {
                        a.this.haC.removeView(a.this.haB);
                    }
                    a.this.haE = null;
                    a.this.haM = null;
                    a.this.haB = null;
                    BdLog.e("AlaPkPanel:   closePkPanelView ==> mRootLiveView.removeView(contain)");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ad adVar) {
        final View c = c(adVar);
        if (c != null && this.haC != null && this.haC.indexOfChild(c) < 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.getParent() != null && (c.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) c.getParent()).removeView(c);
                        BdLog.e("AlaPkPanel:  openPkPanelView ==> contain has  Parent ==> parent.removeView(contain)");
                    }
                    if (a.this.haC != null) {
                        a.this.haC.addView(c, new RelativeLayout.LayoutParams(-1, -1));
                        BdLog.e("AlaPkPanel:   openPkPanelView ==> mRootLiveView.addView(contain, llp)");
                    }
                }
            });
        }
    }

    private Handler getSafeHandler() {
        if (this.haF == null) {
            this.haF = new HandlerC0676a(this);
        }
        return this.haF;
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
        this.haJ = null;
        if (this.haI != null) {
            MessageManager.getInstance().unRegisterListener(this.haI);
            this.haI = null;
        }
        if (this.haN != null) {
            MessageManager.getInstance().unRegisterListener(this.haN);
            this.haN = null;
        }
        if (this.haD != null) {
            MessageManager.getInstance().unRegisterListener(this.haD);
            this.haD = null;
            BdLog.e("AlaPkPanel : onQuitRoom ==> unRegisterListener ==> mLivePkPanelShowListener");
        }
        bYS();
    }

    private void bYS() {
        a(this.haL);
        this.haE = null;
        this.haM = null;
        this.haB = null;
        this.haL = null;
        this.haC = null;
        BdLog.e("AlaPkPanel:  onQuitRoom() ==> quitRoomAndRelease ==>  clear webView Container");
    }

    @Override // com.baidu.live.s.a
    public void m(ViewGroup viewGroup) {
        this.haC = viewGroup;
    }

    public View c(ad adVar) {
        if (adVar != null && this.haB == null) {
            this.haB = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_container, (ViewGroup) null);
            this.haM = (AlaDragContainerView) this.haB.findViewById(a.f.ala_pkpanel_dragview);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.haM.getLayoutParams();
            if (layoutParams != null) {
                if (this.mOrientation == 1) {
                    layoutParams.bottomMargin = (int) (this.mScreenHeight * 0.2d);
                    layoutParams.gravity = 81;
                } else {
                    layoutParams.gravity = 17;
                    layoutParams.bottomMargin = 0;
                }
                this.haM.setLayoutParams(layoutParams);
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) ((adVar.getWidth() / 375.0f) * this.mScreenWidth), (int) ((adVar.getHeight() / 375.0f) * this.mScreenWidth));
            HU(d(adVar));
            this.haM.addView(this.haE, layoutParams2);
        }
        return this.haB;
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
        this.haE = new AlaPkPanelWebView(this.mContext);
        this.haE.setCallback(new AlaPkPanelWebView.a() { // from class: com.baidu.tieba.ala.live.pkpanel.a.8
            @Override // com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.a
            public void na(boolean z) {
                if (z) {
                    a.this.bYP();
                }
            }
        });
        g gVar = new g();
        gVar.x((Activity) this.mContext).a(new f() { // from class: com.baidu.tieba.ala.live.pkpanel.a.9
            @Override // com.baidu.live.view.web.f
            public void fr(int i) {
            }
        }).a(this.haE.getSchemeCallback()).b(this.bRm);
        for (com.baidu.live.view.web.a aVar : gVar.YO()) {
            this.haE.addJavascriptInterface(aVar, aVar.getName());
        }
        this.haE.loadUrl(str);
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
        if (this.haL != null && this.haM != null && (layoutParams = (FrameLayout.LayoutParams) this.haM.getLayoutParams()) != null) {
            if (this.mOrientation == 1) {
                layoutParams.bottomMargin = (int) (this.mScreenHeight * 0.2d);
                layoutParams.gravity = 81;
            } else {
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = 0;
            }
            this.haM.setLayoutParams(layoutParams);
            BdLog.e("AlaPkPanel:   onScreenOrientationChanged ==> mOrientation: " + this.mOrientation);
        }
        if (this.haJ != null) {
            this.haJ.wg(i);
        } else {
            this.haK = i;
        }
    }

    @Override // com.baidu.live.s.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.haM != null) {
            BdLog.e("AlaPkPanel:   onKeyboardVisibilityChanged ==> isVisibility: " + z);
            this.haM.bYW();
        }
    }

    private String bYT() {
        return (this.bur == null || this.bur.mLiveInfo == null) ? "" : String.valueOf(this.bur.mLiveInfo.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_id", getLiveId());
            jSONObject.putOpt("vid", bYT());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_SID, ExtraParamsManager.getBaiduSid());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.SDK_VERSION);
            jSONObject.put("inbox", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "pkpanel", str3).setContentExt(null, "", jSONObject));
    }
}
