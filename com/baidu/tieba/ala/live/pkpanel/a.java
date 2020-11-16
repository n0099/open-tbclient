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
    private w bph;
    private CustomMessageListener gRA;
    private View gRo;
    private ViewGroup gRp;
    private CustomMessageListener gRq;
    private AlaPkPanelWebView gRr;
    private HandlerC0663a gRs;
    private List<String> gRt;
    private CustomMessageListener gRu;
    private CustomMessageListener gRv;
    private com.baidu.tieba.ala.live.pkpanel.a.a gRw;
    private ac gRy;
    private AlaDragContainerView gRz;
    private Context mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    private int gRx = 1;
    private int mOrientation = 1;
    private h bMh = new h() { // from class: com.baidu.tieba.ala.live.pkpanel.a.2
        @Override // com.baidu.live.view.web.h
        public void iN(String str) {
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

    private void bVe() {
        if (this.gRt != null) {
            this.gRt.clear();
        }
        if (this.gRs != null) {
            this.gRs.removeMessages(1000);
        }
        bVf();
    }

    private void bVf() {
        if (this.gRu != null) {
            MessageManager.getInstance().unRegisterListener(this.gRu);
            this.gRu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVg() {
        if (Build.VERSION.SDK_INT >= 19) {
            bVi();
            if (this.gRs == null) {
                this.gRs = new HandlerC0663a(this);
            }
            if (!this.gRs.hasMessages(1000)) {
                this.gRs.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0663a extends Handler {
        private final WeakReference<a> gRD;

        HandlerC0663a(a aVar) {
            this.gRD = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.gRD.get() != null && message.what == 1000) {
                this.gRD.get().bVh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bVh() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.gRr != null) {
            if (this.gRt == null || (size = this.gRt.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gRt.get(i));
                }
                str = jSONArray.toString();
                this.gRt.clear();
            }
            if (this.gRr.bVl()) {
                z2 = true;
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.gRr.evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                        z = true;
                        if (!z) {
                            this.gRs.sendEmptyMessageDelayed(1000, 1000L);
                            return;
                        } else {
                            bVe();
                            return;
                        }
                    }
                    this.gRr.loadUrl("javascript:getClientInfo(" + str + ")");
                }
            }
            z = z2;
            if (!z) {
            }
        }
    }

    private void bVi() {
        if (this.gRt == null) {
            this.gRt = new ArrayList();
        }
        this.gRt.clear();
        this.gRu = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.live.pkpanel.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.gRt.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.gRu);
    }

    private void registerListener() {
        if (this.gRv == null) {
            this.gRv = new CustomMessageListener(2913259) { // from class: com.baidu.tieba.ala.live.pkpanel.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        if (a.this.gRw == null && a.this.mContext != null) {
                            a.this.gRw = new com.baidu.tieba.ala.live.pkpanel.a.a(a.this.mContext, a.this.gRx, jSONObject);
                        }
                        a.this.gRw.PA();
                        a.this.aq("10603", "h5_live", "rulepop_show");
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gRv);
        if (this.gRq == null) {
            this.gRq = new CustomMessageListener(2913257) { // from class: com.baidu.tieba.ala.live.pkpanel.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ac)) {
                        a.this.gRy = (ac) customResponsedMessage.getData();
                        if (a.this.gRy != null) {
                            BdLog.e("AlaPkPanel:  pkPanelInfo.isOpenAction(): \t" + a.this.gRy.DI());
                            if (a.this.gRy.DI()) {
                                a.this.b(a.this.gRy);
                            } else {
                                a.this.a(a.this.gRy);
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gRq);
            BdLog.e("AlaPkPanel:  registerListener ==> mLivePkPanelShowListener");
        }
        if (this.gRA == null) {
            this.gRA = new CustomMessageListener(2913258) { // from class: com.baidu.tieba.ala.live.pkpanel.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null && a.this.gRr != null && a.this.gRr.getSchemeCallback() != null) {
                        a.this.gRr.getSchemeCallback().doJsCallback(0, "", jSONObject, "followCallback ");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gRA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ac acVar) {
        final View c = c(acVar);
        if (c != null && this.gRp != null && this.gRp.indexOfChild(c) >= 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gRp != null) {
                        a.this.gRp.removeView(c);
                    }
                    a.this.gRr = null;
                    a.this.gRo = null;
                    BdLog.e("AlaPkPanel:   closePkPanelView ==> mRootLiveView.removeView(contain)");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ac acVar) {
        final View c = c(acVar);
        if (c != null && this.gRp != null && this.gRp.indexOfChild(c) < 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.7
                @Override // java.lang.Runnable
                public void run() {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    if (a.this.gRp != null) {
                        a.this.gRp.addView(c, layoutParams);
                    }
                    BdLog.e("AlaPkPanel:   openPkPanelView ==> mRootLiveView.addView(contain, llp)");
                }
            });
        }
    }

    private Handler getSafeHandler() {
        if (this.gRs == null) {
            this.gRs = new HandlerC0663a(this);
        }
        return this.gRs;
    }

    @Override // com.baidu.live.q.a
    public void e(w wVar) {
        this.bph = wVar;
    }

    @Override // com.baidu.live.q.a
    public void b(w wVar) {
        this.bph = wVar;
    }

    @Override // com.baidu.live.q.a
    public void Ke() {
        this.gRw = null;
        if (this.gRv != null) {
            MessageManager.getInstance().unRegisterListener(this.gRv);
            this.gRv = null;
        }
        if (this.gRq != null) {
            MessageManager.getInstance().unRegisterListener(this.gRq);
            this.gRq = null;
            BdLog.e("AlaPkPanel : onQuitRoom ==> unRegisterListener ==> mLivePkPanelShowListener");
        }
        a(this.gRy);
        this.gRy = null;
        this.gRp = null;
    }

    @Override // com.baidu.live.q.a
    public void m(ViewGroup viewGroup) {
        this.gRp = viewGroup;
    }

    public View c(ac acVar) {
        if (acVar != null && this.gRo == null) {
            this.gRo = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_container, (ViewGroup) null);
            this.gRz = (AlaDragContainerView) this.gRo.findViewById(a.f.ala_pkpanel_dragview);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gRz.getLayoutParams();
            if (layoutParams != null) {
                if (this.mOrientation == 1) {
                    layoutParams.bottomMargin = (int) (this.mScreenHeight * 0.2d);
                    layoutParams.gravity = 81;
                } else {
                    layoutParams.gravity = 17;
                    layoutParams.bottomMargin = 0;
                }
                this.gRz.setLayoutParams(layoutParams);
            }
            if (acVar != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) ((acVar.getWidth() / 375.0f) * this.mScreenWidth), (int) ((acVar.getHeight() / 375.0f) * this.mScreenWidth));
                Hg(d(acVar));
                this.gRz.addView(this.gRr, layoutParams2);
            }
        }
        return this.gRo;
    }

    private String d(ac acVar) {
        String str = "";
        if (acVar.DH() != null) {
            str = URLEncoder.encode(acVar.DH());
        }
        return acVar.DG() + "?jsonData=" + str + "&room_id=" + getRoomId() + "&live_id=" + getLiveId() + "&subapp_type=" + TbConfig.getSubappType();
    }

    private String getLiveId() {
        return (this.bph == null || this.bph.mLiveInfo == null) ? "" : String.valueOf(this.bph.mLiveInfo.getLiveID());
    }

    private String getRoomId() {
        return (this.bph == null || this.bph.mLiveInfo == null) ? "" : String.valueOf(this.bph.mLiveInfo.room_id);
    }

    private void Hg(String str) {
        com.baidu.live.view.web.a[] Wo;
        this.gRr = new AlaPkPanelWebView(this.mContext);
        this.gRr.setCallback(new AlaPkPanelWebView.a() { // from class: com.baidu.tieba.ala.live.pkpanel.a.8
            @Override // com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.a
            public void mF(boolean z) {
                if (z) {
                    a.this.bVg();
                }
            }
        });
        g gVar = new g();
        gVar.x((Activity) this.mContext).a(new f() { // from class: com.baidu.tieba.ala.live.pkpanel.a.9
            @Override // com.baidu.live.view.web.f
            public void eT(int i) {
            }
        }).a(this.gRr.getSchemeCallback()).b(this.bMh);
        for (com.baidu.live.view.web.a aVar : gVar.Wo()) {
            this.gRr.addJavascriptInterface(aVar, aVar.getName());
        }
        this.gRr.loadUrl(str);
    }

    @Override // com.baidu.live.q.a
    public void onStop() {
    }

    @Override // com.baidu.live.q.a
    public void onStart() {
    }

    @Override // com.baidu.live.q.a
    public void dE(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.mOrientation = i;
        if (this.gRy != null && this.gRz != null && (layoutParams = (FrameLayout.LayoutParams) this.gRz.getLayoutParams()) != null) {
            if (this.mOrientation == 1) {
                layoutParams.bottomMargin = (int) (this.mScreenHeight * 0.2d);
                layoutParams.gravity = 81;
            } else {
                layoutParams.gravity = 17;
                layoutParams.bottomMargin = 0;
            }
            this.gRz.setLayoutParams(layoutParams);
            BdLog.e("AlaPkPanel:   onScreenOrientationChanged ==> mOrientation: " + this.mOrientation);
        }
        if (this.gRw != null) {
            this.gRw.vz(i);
        } else {
            this.gRx = i;
        }
    }

    @Override // com.baidu.live.q.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gRz != null) {
            BdLog.e("AlaPkPanel:   onKeyboardVisibilityChanged ==> isVisibility: " + z);
            this.gRz.bVm();
        }
    }

    private String bVj() {
        return (this.bph == null || this.bph.mLiveInfo == null) ? "" : String.valueOf(this.bph.mLiveInfo.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_id", getLiveId());
            jSONObject.putOpt("vid", bVj());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_SID, ExtraParamsManager.getBaiduSid());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.SDK_VERSION);
            jSONObject.put("inbox", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "pkpanel", str3).setContentExt(null, "", jSONObject));
    }
}
