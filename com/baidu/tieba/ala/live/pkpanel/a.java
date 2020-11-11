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
import com.baidu.live.data.ac;
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
public class a implements com.baidu.live.q.a {
    private w bqS;
    private View gRH;
    private ViewGroup gRI;
    private CustomMessageListener gRJ;
    private AlaPkPanelWebView gRK;
    private HandlerC0663a gRL;
    private List<String> gRM;
    private CustomMessageListener gRN;
    private CustomMessageListener gRO;
    private com.baidu.tieba.ala.live.pkpanel.a.a gRP;
    private ac gRR;
    private AlaDragContainerView gRS;
    private CustomMessageListener gRT;
    private Context mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    private int gRQ = 1;
    private int mOrientation = 1;
    private h bNR = new h() { // from class: com.baidu.tieba.ala.live.pkpanel.a.2
        @Override // com.baidu.live.view.web.h
        public void iT(String str) {
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

    private void bVL() {
        if (this.gRM != null) {
            this.gRM.clear();
        }
        if (this.gRL != null) {
            this.gRL.removeMessages(1000);
        }
        bVM();
    }

    private void bVM() {
        if (this.gRN != null) {
            MessageManager.getInstance().unRegisterListener(this.gRN);
            this.gRN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVN() {
        if (Build.VERSION.SDK_INT >= 19) {
            bVP();
            if (this.gRL == null) {
                this.gRL = new HandlerC0663a(this);
            }
            if (!this.gRL.hasMessages(1000)) {
                this.gRL.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0663a extends Handler {
        private final WeakReference<a> gRW;

        HandlerC0663a(a aVar) {
            this.gRW = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.gRW.get() != null && message.what == 1000) {
                this.gRW.get().bVO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bVO() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.gRK != null) {
            if (this.gRM == null || (size = this.gRM.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gRM.get(i));
                }
                str = jSONArray.toString();
                this.gRM.clear();
            }
            if (this.gRK.bVS()) {
                z2 = true;
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.gRK.evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                        z = true;
                        if (!z) {
                            this.gRL.sendEmptyMessageDelayed(1000, 1000L);
                            return;
                        } else {
                            bVL();
                            return;
                        }
                    }
                    this.gRK.loadUrl("javascript:getClientInfo(" + str + ")");
                }
            }
            z = z2;
            if (!z) {
            }
        }
    }

    private void bVP() {
        if (this.gRM == null) {
            this.gRM = new ArrayList();
        }
        this.gRM.clear();
        this.gRN = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.live.pkpanel.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.gRM.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.gRN);
    }

    private void registerListener() {
        if (this.gRO == null) {
            this.gRO = new CustomMessageListener(2913259) { // from class: com.baidu.tieba.ala.live.pkpanel.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        if (a.this.gRP == null && a.this.mContext != null) {
                            a.this.gRP = new com.baidu.tieba.ala.live.pkpanel.a.a(a.this.mContext, a.this.gRQ, jSONObject);
                        }
                        a.this.gRP.Qj();
                        a.this.aq("10603", "h5_live", "rulepop_show");
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gRO);
        if (this.gRJ == null) {
            this.gRJ = new CustomMessageListener(2913257) { // from class: com.baidu.tieba.ala.live.pkpanel.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ac)) {
                        a.this.gRR = (ac) customResponsedMessage.getData();
                        if (a.this.gRR != null) {
                            BdLog.e("AlaPkPanel:  pkPanelInfo.isOpenAction(): \t" + a.this.gRR.Er());
                            if (a.this.gRR.Er()) {
                                a.this.b(a.this.gRR);
                            } else {
                                a.this.a(a.this.gRR);
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gRJ);
            BdLog.e("AlaPkPanel:  registerListener ==> mLivePkPanelShowListener");
        }
        if (this.gRT == null) {
            this.gRT = new CustomMessageListener(2913258) { // from class: com.baidu.tieba.ala.live.pkpanel.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null && a.this.gRK != null && a.this.gRK.getSchemeCallback() != null) {
                        a.this.gRK.getSchemeCallback().doJsCallback(0, "", jSONObject, "followCallback ");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gRT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ac acVar) {
        final View c = c(acVar);
        if (c != null && this.gRI != null && this.gRI.indexOfChild(c) >= 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gRI != null) {
                        a.this.gRI.removeView(c);
                    }
                    a.this.gRK = null;
                    a.this.gRH = null;
                    BdLog.e("AlaPkPanel:   closePkPanelView ==> mRootLiveView.removeView(contain)");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ac acVar) {
        final View c = c(acVar);
        if (c != null && this.gRI != null && this.gRI.indexOfChild(c) < 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.7
                @Override // java.lang.Runnable
                public void run() {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    if (a.this.gRI != null) {
                        a.this.gRI.addView(c, layoutParams);
                    }
                    BdLog.e("AlaPkPanel:   openPkPanelView ==> mRootLiveView.addView(contain, llp)");
                }
            });
        }
    }

    private Handler getSafeHandler() {
        if (this.gRL == null) {
            this.gRL = new HandlerC0663a(this);
        }
        return this.gRL;
    }

    @Override // com.baidu.live.q.a
    public void e(w wVar) {
        this.bqS = wVar;
    }

    @Override // com.baidu.live.q.a
    public void b(w wVar) {
        this.bqS = wVar;
    }

    @Override // com.baidu.live.q.a
    public void KN() {
        this.gRP = null;
        if (this.gRO != null) {
            MessageManager.getInstance().unRegisterListener(this.gRO);
            this.gRO = null;
        }
        if (this.gRJ != null) {
            MessageManager.getInstance().unRegisterListener(this.gRJ);
            this.gRJ = null;
            BdLog.e("AlaPkPanel : onQuitRoom ==> unRegisterListener ==> mLivePkPanelShowListener");
        }
        a(this.gRR);
        this.gRR = null;
        this.gRI = null;
    }

    @Override // com.baidu.live.q.a
    public void q(ViewGroup viewGroup) {
        this.gRI = viewGroup;
    }

    public View c(ac acVar) {
        if (acVar != null && this.gRH == null) {
            this.gRH = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_container, (ViewGroup) null);
            this.gRS = (AlaDragContainerView) this.gRH.findViewById(a.f.ala_pkpanel_dragview);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gRS.getLayoutParams();
            if (layoutParams != null) {
                if (this.mOrientation == 1) {
                    layoutParams.bottomMargin = (int) (this.mScreenHeight * 0.2d);
                    layoutParams.gravity = 81;
                } else {
                    layoutParams.gravity = 17;
                    layoutParams.bottomMargin = 0;
                }
                this.gRS.setLayoutParams(layoutParams);
            }
            if (acVar != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) ((acVar.getWidth() / 375.0f) * this.mScreenWidth), (int) ((acVar.getHeight() / 375.0f) * this.mScreenWidth));
                HF(d(acVar));
                this.gRS.addView(this.gRK, layoutParams2);
            }
        }
        return this.gRH;
    }

    private String d(ac acVar) {
        String str = "";
        if (acVar.Eq() != null) {
            str = URLEncoder.encode(acVar.Eq());
        }
        return acVar.Ep() + "?jsonData=" + str + "&room_id=" + getRoomId() + "&live_id=" + getLiveId() + "&subapp_type=" + TbConfig.getSubappType();
    }

    private String getLiveId() {
        return (this.bqS == null || this.bqS.mLiveInfo == null) ? "" : String.valueOf(this.bqS.mLiveInfo.getLiveID());
    }

    private String getRoomId() {
        return (this.bqS == null || this.bqS.mLiveInfo == null) ? "" : String.valueOf(this.bqS.mLiveInfo.room_id);
    }

    private void HF(String str) {
        com.baidu.live.view.web.a[] WX;
        this.gRK = new AlaPkPanelWebView(this.mContext);
        this.gRK.setCallback(new AlaPkPanelWebView.a() { // from class: com.baidu.tieba.ala.live.pkpanel.a.8
            @Override // com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.a
            public void mE(boolean z) {
                if (z) {
                    a.this.bVN();
                }
            }
        });
        g gVar = new g();
        gVar.y((Activity) this.mContext).a(new f() { // from class: com.baidu.tieba.ala.live.pkpanel.a.9
            @Override // com.baidu.live.view.web.f
            public void eX(int i) {
            }
        }).a(this.gRK.getSchemeCallback()).b(this.bNR);
        for (com.baidu.live.view.web.a aVar : gVar.WX()) {
            this.gRK.addJavascriptInterface(aVar, aVar.getName());
        }
        this.gRK.loadUrl(str);
    }

    @Override // com.baidu.live.q.a
    public void onStop() {
    }

    @Override // com.baidu.live.q.a
    public void onStart() {
    }

    @Override // com.baidu.live.q.a
    public void dI(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.mOrientation = i;
        if (this.gRR != null && this.gRS != null && (layoutParams = (FrameLayout.LayoutParams) this.gRS.getLayoutParams()) != null) {
            if (this.mOrientation == 1) {
                layoutParams.bottomMargin = (int) (this.mScreenHeight * 0.2d);
                layoutParams.gravity = 81;
            } else {
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = 0;
            }
            this.gRS.setLayoutParams(layoutParams);
            BdLog.e("AlaPkPanel:   onScreenOrientationChanged ==> mOrientation: " + this.mOrientation);
        }
        if (this.gRP != null) {
            this.gRP.vb(i);
        } else {
            this.gRQ = i;
        }
    }

    @Override // com.baidu.live.q.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gRS != null) {
            BdLog.e("AlaPkPanel:   onKeyboardVisibilityChanged ==> isVisibility: " + z);
            this.gRS.bVT();
        }
    }

    private String bVQ() {
        return (this.bqS == null || this.bqS.mLiveInfo == null) ? "" : String.valueOf(this.bqS.mLiveInfo.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_id", getLiveId());
            jSONObject.putOpt("vid", bVQ());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_SID, ExtraParamsManager.getBaiduSid());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.SDK_VERSION);
            jSONObject.put("inbox", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "pkpanel", str3).setContentExt(null, "", jSONObject));
    }
}
