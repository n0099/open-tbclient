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
import com.baidu.live.data.ab;
import com.baidu.live.data.ai;
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
public class a implements com.baidu.live.s.a {
    private CustomMessageListener bkK;
    private ab bxN;
    private View gRV;
    private ViewGroup hmo;
    private AlaDragContainerView hmp;
    private AlaPkPanelWebView hmq;
    private com.baidu.tieba.ala.live.pkpanel.a.a hmr;
    private ai hms;
    private HandlerC0652a hmt;
    private List<String> hmu;
    private CustomMessageListener hmv;
    private CustomMessageListener hmw;
    private CustomMessageListener hmx;
    private Context mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mOrientation = 1;
    private h bWa = new h() { // from class: com.baidu.tieba.ala.live.pkpanel.a.2
        @Override // com.baidu.live.view.web.h
        public boolean iz(String str) {
            if (TextUtils.isEmpty(str)) {
            }
            return false;
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mScreenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.mScreenHeight = ScreenHelper.getScreenHeight(this.mContext);
        registerListener();
    }

    private void bYJ() {
        if (this.hmu != null) {
            this.hmu.clear();
        }
        if (this.hmt != null) {
            this.hmt.removeMessages(1000);
        }
        Jw();
    }

    private void Jw() {
        if (this.bkK != null) {
            MessageManager.getInstance().unRegisterListener(this.bkK);
            this.bkK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYK() {
        if (Build.VERSION.SDK_INT >= 19) {
            Jv();
            if (this.hmt == null) {
                this.hmt = new HandlerC0652a(this);
            }
            if (!this.hmt.hasMessages(1000)) {
                this.hmt.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0652a extends Handler {
        private final WeakReference<a> hmz;

        HandlerC0652a(a aVar) {
            this.hmz = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hmz.get() != null && message.what == 1000) {
                this.hmz.get().bYL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bYL() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hmq != null) {
            if (this.hmu == null || (size = this.hmu.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hmu.get(i));
                }
                str = jSONArray.toString();
                this.hmu.clear();
            }
            if (this.hmq.bYR()) {
                z2 = true;
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.hmq.evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                        z = true;
                        if (!z) {
                            this.hmt.sendEmptyMessageDelayed(1000, 1000L);
                            return;
                        } else {
                            bYJ();
                            return;
                        }
                    }
                    this.hmq.loadUrl("javascript:getClientInfo(" + str + ")");
                }
            }
            z = z2;
            if (!z) {
            }
        }
    }

    private void Jv() {
        if (this.hmu == null) {
            this.hmu = new ArrayList();
        }
        this.hmu.clear();
        this.bkK = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.live.pkpanel.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.hmu.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bkK);
    }

    private void registerListener() {
        if (this.hmv == null) {
            this.hmv = new CustomMessageListener(2913259) { // from class: com.baidu.tieba.ala.live.pkpanel.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        if (a.this.hmr == null && a.this.mContext != null) {
                            a.this.hmr = new com.baidu.tieba.ala.live.pkpanel.a.a(a.this.mContext, a.this.mOrientation, jSONObject);
                        }
                        a.this.hmr.QE();
                        a.this.av("10603", "h5_live", "rulepop_show");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hmv);
        }
        if (this.hmw == null) {
            this.hmw = new CustomMessageListener(2913257) { // from class: com.baidu.tieba.ala.live.pkpanel.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ai)) {
                        a.this.hms = (ai) customResponsedMessage.getData();
                        if (a.this.hms != null) {
                            BdLog.e("AlaPkPanel:  pkPanelInfo.isOpenAction(): \t" + a.this.hms.Cb());
                            if (a.this.hms.Cb()) {
                                a.this.a(a.this.hms);
                            } else {
                                a.this.bYM();
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hmw);
            BdLog.e("AlaPkPanel:  registerListener ==> mLivePkPanelShowListener");
        }
        if (this.hmx == null) {
            this.hmx = new CustomMessageListener(2913258) { // from class: com.baidu.tieba.ala.live.pkpanel.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null && a.this.hmq != null && a.this.hmq.getSchemeCallback() != null) {
                        a.this.hmq.getSchemeCallback().doJsCallback(0, "", jSONObject, "followCallback ");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hmx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYM() {
        if (this.gRV != null && this.hmo != null && this.hmo.indexOfChild(this.gRV) >= 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hmo != null) {
                        a.this.hmo.removeView(a.this.gRV);
                    }
                    if (a.this.hmq != null) {
                        a.this.hmq.release();
                    }
                    a.this.hmq = null;
                    a.this.hmp = null;
                    a.this.gRV = null;
                    BdLog.e("AlaPkPanel:   closePkPanelView ==> mRootLiveView.removeView(contain)");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ai aiVar) {
        b(aiVar);
        if (this.gRV != null && this.hmo != null && this.hmo.indexOfChild(this.gRV) < 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gRV.getParent() != null && (a.this.gRV.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) a.this.gRV.getParent()).removeView(a.this.gRV);
                        BdLog.e("AlaPkPanel:  openPkPanelView ==> contain has  Parent ==> parent.removeView(contain)");
                    }
                    if (a.this.hmo != null) {
                        a.this.hmo.addView(a.this.gRV, new RelativeLayout.LayoutParams(-1, -1));
                        BdLog.e("AlaPkPanel:   openPkPanelView ==> mRootLiveView.addView(contain, llp)");
                    }
                }
            });
        }
    }

    private void b(ai aiVar) {
        if (aiVar != null && this.gRV == null) {
            this.gRV = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_container, (ViewGroup) null);
            this.hmp = (AlaDragContainerView) this.gRV.findViewById(a.f.ala_pkpanel_dragview);
            this.hmp.setLayoutParams(bYP());
            Ho(c(aiVar));
            this.hmp.addView(this.hmq, d(aiVar));
        }
    }

    private Handler getSafeHandler() {
        if (this.hmt == null) {
            this.hmt = new HandlerC0652a(this);
        }
        return this.hmt;
    }

    @Override // com.baidu.live.s.a
    public void h(ab abVar) {
        this.bxN = abVar;
    }

    @Override // com.baidu.live.s.a
    public void b(ab abVar) {
        this.bxN = abVar;
    }

    @Override // com.baidu.live.s.a
    public void IZ() {
        this.hmr = null;
        if (this.hmv != null) {
            MessageManager.getInstance().unRegisterListener(this.hmv);
            this.hmv = null;
        }
        if (this.hmx != null) {
            MessageManager.getInstance().unRegisterListener(this.hmx);
            this.hmx = null;
        }
        if (this.hmw != null) {
            MessageManager.getInstance().unRegisterListener(this.hmw);
            this.hmw = null;
            BdLog.e("AlaPkPanel : onQuitRoom ==> unRegisterListener ==> mLivePkPanelShowListener");
        }
        bYN();
    }

    @Override // com.baidu.live.s.a
    public void onDestory() {
        IZ();
    }

    private void bYN() {
        bYM();
        if (this.hmq != null) {
            this.hmq.release();
        }
        this.hmq = null;
        this.hmp = null;
        this.gRV = null;
        this.hms = null;
        this.hmo = null;
        BdLog.e("AlaPkPanel:  onQuitRoom() ==> quitRoomAndRelease ==>  clear webView Container");
    }

    @Override // com.baidu.live.s.a
    public void p(ViewGroup viewGroup) {
        this.hmo = viewGroup;
    }

    private String c(ai aiVar) {
        String str = "";
        if (aiVar.Ca() != null) {
            str = URLEncoder.encode(aiVar.Ca());
        }
        return aiVar.BZ() + "?jsonData=" + str + "&room_id=" + getRoomId() + "&live_id=" + getLiveId() + "&subapp_type=" + TbConfig.getSubappType();
    }

    private String getLiveId() {
        return (this.bxN == null || this.bxN.mLiveInfo == null) ? "" : String.valueOf(this.bxN.mLiveInfo.getLiveID());
    }

    private String getRoomId() {
        return (this.bxN == null || this.bxN.mLiveInfo == null) ? "" : String.valueOf(this.bxN.mLiveInfo.room_id);
    }

    private void Ho(String str) {
        com.baidu.live.view.web.a[] XY;
        this.hmq = new AlaPkPanelWebView(this.mContext);
        this.hmq.setCallback(new AlaPkPanelWebView.a() { // from class: com.baidu.tieba.ala.live.pkpanel.a.8
            @Override // com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.a
            public void nG(boolean z) {
                if (z) {
                    a.this.bYK();
                }
            }
        });
        g gVar = new g();
        gVar.t((Activity) this.mContext).a(new f() { // from class: com.baidu.tieba.ala.live.pkpanel.a.9
            @Override // com.baidu.live.view.web.f
            public void fp(int i) {
            }
        }).a(this.hmq.getSchemeCallback()).b(this.bWa);
        for (com.baidu.live.view.web.a aVar : gVar.XY()) {
            this.hmq.addJavascriptInterface(aVar, aVar.getName());
        }
        this.hmq.loadUrl(str);
    }

    @Override // com.baidu.live.s.a
    public void cr(int i) {
        this.mOrientation = i;
        if (this.hms != null && this.hmp != null) {
            this.hmp.setLayoutParams(bYP());
            BdLog.e("AlaPkPanel:   onScreenOrientationChanged ==> mOrientation: " + this.mOrientation);
        }
        if (this.hmr != null) {
            this.hmr.uV(this.mOrientation);
        }
    }

    @Override // com.baidu.live.s.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hmp != null) {
            this.hmp.bYS();
            BdLog.e("AlaPkPanel:   onKeyboardVisibilityChanged ==> isVisibility: " + z);
        }
    }

    private String bYO() {
        return (this.bxN == null || this.bxN.mLiveInfo == null) ? "" : String.valueOf(this.bxN.mLiveInfo.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_id", getLiveId());
            jSONObject.putOpt("vid", bYO());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_SID, ExtraParamsManager.getBaiduSid());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.SDK_VERSION);
            jSONObject.put("inbox", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "pkpanel", str3).setContentExt(null, "", jSONObject));
    }

    private FrameLayout.LayoutParams d(ai aiVar) {
        return new FrameLayout.LayoutParams((int) ((aiVar.getWidth() / 375.0f) * this.mScreenWidth), (int) ((aiVar.getHeight() / 375.0f) * this.mScreenWidth));
    }

    private FrameLayout.LayoutParams bYP() {
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
