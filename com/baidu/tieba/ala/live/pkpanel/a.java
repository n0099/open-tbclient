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
    private View gRH;
    private ViewGroup hma;
    private AlaDragContainerView hmb;
    private AlaPkPanelWebView hmc;
    private com.baidu.tieba.ala.live.pkpanel.a.a hmd;
    private ai hme;
    private HandlerC0651a hmf;
    private List<String> hmg;
    private CustomMessageListener hmh;
    private CustomMessageListener hmi;
    private CustomMessageListener hmj;
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

    private void bYC() {
        if (this.hmg != null) {
            this.hmg.clear();
        }
        if (this.hmf != null) {
            this.hmf.removeMessages(1000);
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
    public void bYD() {
        if (Build.VERSION.SDK_INT >= 19) {
            Jv();
            if (this.hmf == null) {
                this.hmf = new HandlerC0651a(this);
            }
            if (!this.hmf.hasMessages(1000)) {
                this.hmf.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0651a extends Handler {
        private final WeakReference<a> hml;

        HandlerC0651a(a aVar) {
            this.hml = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hml.get() != null && message.what == 1000) {
                this.hml.get().bYE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bYE() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hmc != null) {
            if (this.hmg == null || (size = this.hmg.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hmg.get(i));
                }
                str = jSONArray.toString();
                this.hmg.clear();
            }
            if (this.hmc.bYK()) {
                z2 = true;
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.hmc.evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                        z = true;
                        if (!z) {
                            this.hmf.sendEmptyMessageDelayed(1000, 1000L);
                            return;
                        } else {
                            bYC();
                            return;
                        }
                    }
                    this.hmc.loadUrl("javascript:getClientInfo(" + str + ")");
                }
            }
            z = z2;
            if (!z) {
            }
        }
    }

    private void Jv() {
        if (this.hmg == null) {
            this.hmg = new ArrayList();
        }
        this.hmg.clear();
        this.bkK = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.live.pkpanel.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.hmg.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bkK);
    }

    private void registerListener() {
        if (this.hmh == null) {
            this.hmh = new CustomMessageListener(2913259) { // from class: com.baidu.tieba.ala.live.pkpanel.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        if (a.this.hmd == null && a.this.mContext != null) {
                            a.this.hmd = new com.baidu.tieba.ala.live.pkpanel.a.a(a.this.mContext, a.this.mOrientation, jSONObject);
                        }
                        a.this.hmd.QE();
                        a.this.av("10603", "h5_live", "rulepop_show");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hmh);
        }
        if (this.hmi == null) {
            this.hmi = new CustomMessageListener(2913257) { // from class: com.baidu.tieba.ala.live.pkpanel.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ai)) {
                        a.this.hme = (ai) customResponsedMessage.getData();
                        if (a.this.hme != null) {
                            BdLog.e("AlaPkPanel:  pkPanelInfo.isOpenAction(): \t" + a.this.hme.Cb());
                            if (a.this.hme.Cb()) {
                                a.this.a(a.this.hme);
                            } else {
                                a.this.bYF();
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hmi);
            BdLog.e("AlaPkPanel:  registerListener ==> mLivePkPanelShowListener");
        }
        if (this.hmj == null) {
            this.hmj = new CustomMessageListener(2913258) { // from class: com.baidu.tieba.ala.live.pkpanel.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null && a.this.hmc != null && a.this.hmc.getSchemeCallback() != null) {
                        a.this.hmc.getSchemeCallback().doJsCallback(0, "", jSONObject, "followCallback ");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hmj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYF() {
        if (this.gRH != null && this.hma != null && this.hma.indexOfChild(this.gRH) >= 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hma != null) {
                        a.this.hma.removeView(a.this.gRH);
                    }
                    if (a.this.hmc != null) {
                        a.this.hmc.release();
                    }
                    a.this.hmc = null;
                    a.this.hmb = null;
                    a.this.gRH = null;
                    BdLog.e("AlaPkPanel:   closePkPanelView ==> mRootLiveView.removeView(contain)");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ai aiVar) {
        b(aiVar);
        if (this.gRH != null && this.hma != null && this.hma.indexOfChild(this.gRH) < 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gRH.getParent() != null && (a.this.gRH.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) a.this.gRH.getParent()).removeView(a.this.gRH);
                        BdLog.e("AlaPkPanel:  openPkPanelView ==> contain has  Parent ==> parent.removeView(contain)");
                    }
                    if (a.this.hma != null) {
                        a.this.hma.addView(a.this.gRH, new RelativeLayout.LayoutParams(-1, -1));
                        BdLog.e("AlaPkPanel:   openPkPanelView ==> mRootLiveView.addView(contain, llp)");
                    }
                }
            });
        }
    }

    private void b(ai aiVar) {
        if (aiVar != null && this.gRH == null) {
            this.gRH = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_container, (ViewGroup) null);
            this.hmb = (AlaDragContainerView) this.gRH.findViewById(a.f.ala_pkpanel_dragview);
            this.hmb.setLayoutParams(bYI());
            Hn(c(aiVar));
            this.hmb.addView(this.hmc, d(aiVar));
        }
    }

    private Handler getSafeHandler() {
        if (this.hmf == null) {
            this.hmf = new HandlerC0651a(this);
        }
        return this.hmf;
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
        this.hmd = null;
        if (this.hmh != null) {
            MessageManager.getInstance().unRegisterListener(this.hmh);
            this.hmh = null;
        }
        if (this.hmj != null) {
            MessageManager.getInstance().unRegisterListener(this.hmj);
            this.hmj = null;
        }
        if (this.hmi != null) {
            MessageManager.getInstance().unRegisterListener(this.hmi);
            this.hmi = null;
            BdLog.e("AlaPkPanel : onQuitRoom ==> unRegisterListener ==> mLivePkPanelShowListener");
        }
        bYG();
    }

    @Override // com.baidu.live.s.a
    public void onDestory() {
        IZ();
    }

    private void bYG() {
        bYF();
        if (this.hmc != null) {
            this.hmc.release();
        }
        this.hmc = null;
        this.hmb = null;
        this.gRH = null;
        this.hme = null;
        this.hma = null;
        BdLog.e("AlaPkPanel:  onQuitRoom() ==> quitRoomAndRelease ==>  clear webView Container");
    }

    @Override // com.baidu.live.s.a
    public void p(ViewGroup viewGroup) {
        this.hma = viewGroup;
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

    private void Hn(String str) {
        com.baidu.live.view.web.a[] XY;
        this.hmc = new AlaPkPanelWebView(this.mContext);
        this.hmc.setCallback(new AlaPkPanelWebView.a() { // from class: com.baidu.tieba.ala.live.pkpanel.a.8
            @Override // com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.a
            public void nG(boolean z) {
                if (z) {
                    a.this.bYD();
                }
            }
        });
        g gVar = new g();
        gVar.t((Activity) this.mContext).a(new f() { // from class: com.baidu.tieba.ala.live.pkpanel.a.9
            @Override // com.baidu.live.view.web.f
            public void fp(int i) {
            }
        }).a(this.hmc.getSchemeCallback()).b(this.bWa);
        for (com.baidu.live.view.web.a aVar : gVar.XY()) {
            this.hmc.addJavascriptInterface(aVar, aVar.getName());
        }
        this.hmc.loadUrl(str);
    }

    @Override // com.baidu.live.s.a
    public void cr(int i) {
        this.mOrientation = i;
        if (this.hme != null && this.hmb != null) {
            this.hmb.setLayoutParams(bYI());
            BdLog.e("AlaPkPanel:   onScreenOrientationChanged ==> mOrientation: " + this.mOrientation);
        }
        if (this.hmd != null) {
            this.hmd.uV(this.mOrientation);
        }
    }

    @Override // com.baidu.live.s.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hmb != null) {
            this.hmb.bYL();
            BdLog.e("AlaPkPanel:   onKeyboardVisibilityChanged ==> isVisibility: " + z);
        }
    }

    private String bYH() {
        return (this.bxN == null || this.bxN.mLiveInfo == null) ? "" : String.valueOf(this.bxN.mLiveInfo.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_id", getLiveId());
            jSONObject.putOpt("vid", bYH());
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

    private FrameLayout.LayoutParams bYI() {
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
