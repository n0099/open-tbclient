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
import com.baidu.live.data.ae;
import com.baidu.live.data.x;
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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.t.a {
    private x bzc;
    private CustomMessageListener hmA;
    private CustomMessageListener hmB;
    private CustomMessageListener hmC;
    private ViewGroup hmr;
    private View hms;
    private AlaDragContainerView hmt;
    private AlaPkPanelWebView hmu;
    private com.baidu.tieba.ala.live.pkpanel.a.a hmv;
    private ae hmw;
    private HandlerC0668a hmx;
    private List<String> hmy;
    private CustomMessageListener hmz;
    private Context mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mOrientation = 1;
    private h bWS = new h() { // from class: com.baidu.tieba.ala.live.pkpanel.a.2
        @Override // com.baidu.live.view.web.h
        public void jk(String str) {
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

    private void cbt() {
        if (this.hmy != null) {
            this.hmy.clear();
        }
        if (this.hmx != null) {
            this.hmx.removeMessages(1000);
        }
        cbu();
    }

    private void cbu() {
        if (this.hmz != null) {
            MessageManager.getInstance().unRegisterListener(this.hmz);
            this.hmz = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbv() {
        if (Build.VERSION.SDK_INT >= 19) {
            cbx();
            if (this.hmx == null) {
                this.hmx = new HandlerC0668a(this);
            }
            if (!this.hmx.hasMessages(1000)) {
                this.hmx.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0668a extends Handler {
        private final WeakReference<a> hmE;

        HandlerC0668a(a aVar) {
            this.hmE = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hmE.get() != null && message.what == 1000) {
                this.hmE.get().cbw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cbw() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hmu != null) {
            if (this.hmy == null || (size = this.hmy.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hmy.get(i));
                }
                str = jSONArray.toString();
                this.hmy.clear();
            }
            if (this.hmu.cbD()) {
                z2 = true;
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.hmu.evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                        z = true;
                        if (!z) {
                            this.hmx.sendEmptyMessageDelayed(1000, 1000L);
                            return;
                        } else {
                            cbt();
                            return;
                        }
                    }
                    this.hmu.loadUrl("javascript:getClientInfo(" + str + ")");
                }
            }
            z = z2;
            if (!z) {
            }
        }
    }

    private void cbx() {
        if (this.hmy == null) {
            this.hmy = new ArrayList();
        }
        this.hmy.clear();
        this.hmz = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.live.pkpanel.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.hmy.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.hmz);
    }

    private void registerListener() {
        if (this.hmA == null) {
            this.hmA = new CustomMessageListener(2913259) { // from class: com.baidu.tieba.ala.live.pkpanel.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        if (a.this.hmv == null && a.this.mContext != null) {
                            a.this.hmv = new com.baidu.tieba.ala.live.pkpanel.a.a(a.this.mContext, a.this.mOrientation, jSONObject);
                        }
                        a.this.hmv.SY();
                        a.this.av("10603", "h5_live", "rulepop_show");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hmA);
        }
        if (this.hmB == null) {
            this.hmB = new CustomMessageListener(2913257) { // from class: com.baidu.tieba.ala.live.pkpanel.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ae)) {
                        a.this.hmw = (ae) customResponsedMessage.getData();
                        if (a.this.hmw != null) {
                            BdLog.e("AlaPkPanel:  pkPanelInfo.isOpenAction(): \t" + a.this.hmw.EJ());
                            if (a.this.hmw.EJ()) {
                                a.this.a(a.this.hmw);
                            } else {
                                a.this.cby();
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hmB);
            BdLog.e("AlaPkPanel:  registerListener ==> mLivePkPanelShowListener");
        }
        if (this.hmC == null) {
            this.hmC = new CustomMessageListener(2913258) { // from class: com.baidu.tieba.ala.live.pkpanel.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null && a.this.hmu != null && a.this.hmu.getSchemeCallback() != null) {
                        a.this.hmu.getSchemeCallback().doJsCallback(0, "", jSONObject, "followCallback ");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hmC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cby() {
        if (this.hms != null && this.hmr != null && this.hmr.indexOfChild(this.hms) >= 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hmr != null) {
                        a.this.hmr.removeView(a.this.hms);
                    }
                    if (a.this.hmu != null) {
                        a.this.hmu.release();
                    }
                    a.this.hmu = null;
                    a.this.hmt = null;
                    a.this.hms = null;
                    BdLog.e("AlaPkPanel:   closePkPanelView ==> mRootLiveView.removeView(contain)");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ae aeVar) {
        b(aeVar);
        if (this.hms != null && this.hmr != null && this.hmr.indexOfChild(this.hms) < 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hms.getParent() != null && (a.this.hms.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) a.this.hms.getParent()).removeView(a.this.hms);
                        BdLog.e("AlaPkPanel:  openPkPanelView ==> contain has  Parent ==> parent.removeView(contain)");
                    }
                    if (a.this.hmr != null) {
                        a.this.hmr.addView(a.this.hms, new RelativeLayout.LayoutParams(-1, -1));
                        BdLog.e("AlaPkPanel:   openPkPanelView ==> mRootLiveView.addView(contain, llp)");
                    }
                }
            });
        }
    }

    private void b(ae aeVar) {
        if (aeVar != null && this.hms == null) {
            this.hms = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_container, (ViewGroup) null);
            this.hmt = (AlaDragContainerView) this.hms.findViewById(a.f.ala_pkpanel_dragview);
            this.hmt.setLayoutParams(cbB());
            HU(c(aeVar));
            this.hmt.addView(this.hmu, d(aeVar));
        }
    }

    private Handler getSafeHandler() {
        if (this.hmx == null) {
            this.hmx = new HandlerC0668a(this);
        }
        return this.hmx;
    }

    @Override // com.baidu.live.t.a
    public void f(x xVar) {
        this.bzc = xVar;
    }

    @Override // com.baidu.live.t.a
    public void b(x xVar) {
        this.bzc = xVar;
    }

    @Override // com.baidu.live.t.a
    public void LE() {
        this.hmv = null;
        if (this.hmA != null) {
            MessageManager.getInstance().unRegisterListener(this.hmA);
            this.hmA = null;
        }
        if (this.hmC != null) {
            MessageManager.getInstance().unRegisterListener(this.hmC);
            this.hmC = null;
        }
        if (this.hmB != null) {
            MessageManager.getInstance().unRegisterListener(this.hmB);
            this.hmB = null;
            BdLog.e("AlaPkPanel : onQuitRoom ==> unRegisterListener ==> mLivePkPanelShowListener");
        }
        cbz();
    }

    @Override // com.baidu.live.t.a
    public void onDestory() {
        LE();
    }

    private void cbz() {
        cby();
        if (this.hmu != null) {
            this.hmu.release();
        }
        this.hmu = null;
        this.hmt = null;
        this.hms = null;
        this.hmw = null;
        this.hmr = null;
        BdLog.e("AlaPkPanel:  onQuitRoom() ==> quitRoomAndRelease ==>  clear webView Container");
    }

    @Override // com.baidu.live.t.a
    public void p(ViewGroup viewGroup) {
        this.hmr = viewGroup;
    }

    private String c(ae aeVar) {
        String str = "";
        if (aeVar.EI() != null) {
            str = URLEncoder.encode(aeVar.EI());
        }
        return aeVar.EH() + "?jsonData=" + str + "&room_id=" + getRoomId() + "&live_id=" + getLiveId() + "&subapp_type=" + TbConfig.getSubappType();
    }

    private String getLiveId() {
        return (this.bzc == null || this.bzc.mLiveInfo == null) ? "" : String.valueOf(this.bzc.mLiveInfo.getLiveID());
    }

    private String getRoomId() {
        return (this.bzc == null || this.bzc.mLiveInfo == null) ? "" : String.valueOf(this.bzc.mLiveInfo.room_id);
    }

    private void HU(String str) {
        com.baidu.live.view.web.a[] aae;
        this.hmu = new AlaPkPanelWebView(this.mContext);
        this.hmu.setCallback(new AlaPkPanelWebView.a() { // from class: com.baidu.tieba.ala.live.pkpanel.a.8
            @Override // com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.a
            public void nz(boolean z) {
                if (z) {
                    a.this.cbv();
                }
            }
        });
        g gVar = new g();
        gVar.w((Activity) this.mContext).a(new f() { // from class: com.baidu.tieba.ala.live.pkpanel.a.9
            @Override // com.baidu.live.view.web.f
            public void fr(int i) {
            }
        }).a(this.hmu.getSchemeCallback()).b(this.bWS);
        for (com.baidu.live.view.web.a aVar : gVar.aae()) {
            this.hmu.addJavascriptInterface(aVar, aVar.getName());
        }
        this.hmu.loadUrl(str);
    }

    @Override // com.baidu.live.t.a
    public void dU(int i) {
        this.mOrientation = i;
        if (this.hmw != null && this.hmt != null) {
            this.hmt.setLayoutParams(cbB());
            BdLog.e("AlaPkPanel:   onScreenOrientationChanged ==> mOrientation: " + this.mOrientation);
        }
        if (this.hmv != null) {
            this.hmv.wr(this.mOrientation);
        }
    }

    @Override // com.baidu.live.t.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hmt != null) {
            this.hmt.cbE();
            BdLog.e("AlaPkPanel:   onKeyboardVisibilityChanged ==> isVisibility: " + z);
        }
    }

    private String cbA() {
        return (this.bzc == null || this.bzc.mLiveInfo == null) ? "" : String.valueOf(this.bzc.mLiveInfo.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_id", getLiveId());
            jSONObject.putOpt("vid", cbA());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_SID, ExtraParamsManager.getBaiduSid());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.SDK_VERSION);
            jSONObject.put("inbox", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "pkpanel", str3).setContentExt(null, "", jSONObject));
    }

    private FrameLayout.LayoutParams d(ae aeVar) {
        return new FrameLayout.LayoutParams((int) ((aeVar.getWidth() / 375.0f) * this.mScreenWidth), (int) ((aeVar.getHeight() / 375.0f) * this.mScreenWidth));
    }

    private FrameLayout.LayoutParams cbB() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.mOrientation == 1) {
            layoutParams.bottomMargin = (int) (this.mScreenHeight * 0.2d);
            layoutParams.gravity = 81;
        } else {
            layoutParams.gravity = 17;
            layoutParams.bottomMargin = 0;
        }
        return layoutParams;
    }
}
