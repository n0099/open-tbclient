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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.t.a {
    private x buq;
    private ViewGroup hhK;
    private View hhL;
    private AlaDragContainerView hhM;
    private AlaPkPanelWebView hhN;
    private com.baidu.tieba.ala.live.pkpanel.a.a hhO;
    private ae hhP;
    private HandlerC0651a hhQ;
    private List<String> hhR;
    private CustomMessageListener hhS;
    private CustomMessageListener hhT;
    private CustomMessageListener hhU;
    private CustomMessageListener hhV;
    private Context mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mOrientation = 1;
    private h bSg = new h() { // from class: com.baidu.tieba.ala.live.pkpanel.a.2
        @Override // com.baidu.live.view.web.h
        public void hZ(String str) {
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

    private void bXC() {
        if (this.hhR != null) {
            this.hhR.clear();
        }
        if (this.hhQ != null) {
            this.hhQ.removeMessages(1000);
        }
        bXD();
    }

    private void bXD() {
        if (this.hhS != null) {
            MessageManager.getInstance().unRegisterListener(this.hhS);
            this.hhS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXE() {
        if (Build.VERSION.SDK_INT >= 19) {
            bXG();
            if (this.hhQ == null) {
                this.hhQ = new HandlerC0651a(this);
            }
            if (!this.hhQ.hasMessages(1000)) {
                this.hhQ.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0651a extends Handler {
        private final WeakReference<a> hhX;

        HandlerC0651a(a aVar) {
            this.hhX = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hhX.get() != null && message.what == 1000) {
                this.hhX.get().bXF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bXF() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hhN != null) {
            if (this.hhR == null || (size = this.hhR.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hhR.get(i));
                }
                str = jSONArray.toString();
                this.hhR.clear();
            }
            if (this.hhN.bXM()) {
                z2 = true;
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.hhN.evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                        z = true;
                        if (!z) {
                            this.hhQ.sendEmptyMessageDelayed(1000, 1000L);
                            return;
                        } else {
                            bXC();
                            return;
                        }
                    }
                    this.hhN.loadUrl("javascript:getClientInfo(" + str + ")");
                }
            }
            z = z2;
            if (!z) {
            }
        }
    }

    private void bXG() {
        if (this.hhR == null) {
            this.hhR = new ArrayList();
        }
        this.hhR.clear();
        this.hhS = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.live.pkpanel.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.hhR.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.hhS);
    }

    private void registerListener() {
        if (this.hhT == null) {
            this.hhT = new CustomMessageListener(2913259) { // from class: com.baidu.tieba.ala.live.pkpanel.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        if (a.this.hhO == null && a.this.mContext != null) {
                            a.this.hhO = new com.baidu.tieba.ala.live.pkpanel.a.a(a.this.mContext, a.this.mOrientation, jSONObject);
                        }
                        a.this.hhO.Pd();
                        a.this.au("10603", "h5_live", "rulepop_show");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hhT);
        }
        if (this.hhU == null) {
            this.hhU = new CustomMessageListener(2913257) { // from class: com.baidu.tieba.ala.live.pkpanel.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ae)) {
                        a.this.hhP = (ae) customResponsedMessage.getData();
                        if (a.this.hhP != null) {
                            BdLog.e("AlaPkPanel:  pkPanelInfo.isOpenAction(): \t" + a.this.hhP.AO());
                            if (a.this.hhP.AO()) {
                                a.this.a(a.this.hhP);
                            } else {
                                a.this.bXH();
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hhU);
            BdLog.e("AlaPkPanel:  registerListener ==> mLivePkPanelShowListener");
        }
        if (this.hhV == null) {
            this.hhV = new CustomMessageListener(2913258) { // from class: com.baidu.tieba.ala.live.pkpanel.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null && a.this.hhN != null && a.this.hhN.getSchemeCallback() != null) {
                        a.this.hhN.getSchemeCallback().doJsCallback(0, "", jSONObject, "followCallback ");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hhV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXH() {
        if (this.hhL != null && this.hhK != null && this.hhK.indexOfChild(this.hhL) >= 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hhK != null) {
                        a.this.hhK.removeView(a.this.hhL);
                    }
                    if (a.this.hhN != null) {
                        a.this.hhN.release();
                    }
                    a.this.hhN = null;
                    a.this.hhM = null;
                    a.this.hhL = null;
                    BdLog.e("AlaPkPanel:   closePkPanelView ==> mRootLiveView.removeView(contain)");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ae aeVar) {
        b(aeVar);
        if (this.hhL != null && this.hhK != null && this.hhK.indexOfChild(this.hhL) < 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hhL.getParent() != null && (a.this.hhL.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) a.this.hhL.getParent()).removeView(a.this.hhL);
                        BdLog.e("AlaPkPanel:  openPkPanelView ==> contain has  Parent ==> parent.removeView(contain)");
                    }
                    if (a.this.hhK != null) {
                        a.this.hhK.addView(a.this.hhL, new RelativeLayout.LayoutParams(-1, -1));
                        BdLog.e("AlaPkPanel:   openPkPanelView ==> mRootLiveView.addView(contain, llp)");
                    }
                }
            });
        }
    }

    private void b(ae aeVar) {
        if (aeVar != null && this.hhL == null) {
            this.hhL = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_container, (ViewGroup) null);
            this.hhM = (AlaDragContainerView) this.hhL.findViewById(a.f.ala_pkpanel_dragview);
            this.hhM.setLayoutParams(bXK());
            GI(c(aeVar));
            this.hhM.addView(this.hhN, d(aeVar));
        }
    }

    private Handler getSafeHandler() {
        if (this.hhQ == null) {
            this.hhQ = new HandlerC0651a(this);
        }
        return this.hhQ;
    }

    @Override // com.baidu.live.t.a
    public void f(x xVar) {
        this.buq = xVar;
    }

    @Override // com.baidu.live.t.a
    public void b(x xVar) {
        this.buq = xVar;
    }

    @Override // com.baidu.live.t.a
    public void HJ() {
        this.hhO = null;
        if (this.hhT != null) {
            MessageManager.getInstance().unRegisterListener(this.hhT);
            this.hhT = null;
        }
        if (this.hhV != null) {
            MessageManager.getInstance().unRegisterListener(this.hhV);
            this.hhV = null;
        }
        if (this.hhU != null) {
            MessageManager.getInstance().unRegisterListener(this.hhU);
            this.hhU = null;
            BdLog.e("AlaPkPanel : onQuitRoom ==> unRegisterListener ==> mLivePkPanelShowListener");
        }
        bXI();
    }

    @Override // com.baidu.live.t.a
    public void onDestory() {
        HJ();
    }

    private void bXI() {
        bXH();
        if (this.hhN != null) {
            this.hhN.release();
        }
        this.hhN = null;
        this.hhM = null;
        this.hhL = null;
        this.hhP = null;
        this.hhK = null;
        BdLog.e("AlaPkPanel:  onQuitRoom() ==> quitRoomAndRelease ==>  clear webView Container");
    }

    @Override // com.baidu.live.t.a
    public void p(ViewGroup viewGroup) {
        this.hhK = viewGroup;
    }

    private String c(ae aeVar) {
        String str = "";
        if (aeVar.AN() != null) {
            str = URLEncoder.encode(aeVar.AN());
        }
        return aeVar.AM() + "?jsonData=" + str + "&room_id=" + getRoomId() + "&live_id=" + getLiveId() + "&subapp_type=" + TbConfig.getSubappType();
    }

    private String getLiveId() {
        return (this.buq == null || this.buq.mLiveInfo == null) ? "" : String.valueOf(this.buq.mLiveInfo.getLiveID());
    }

    private String getRoomId() {
        return (this.buq == null || this.buq.mLiveInfo == null) ? "" : String.valueOf(this.buq.mLiveInfo.room_id);
    }

    private void GI(String str) {
        com.baidu.live.view.web.a[] Wm;
        this.hhN = new AlaPkPanelWebView(this.mContext);
        this.hhN.setCallback(new AlaPkPanelWebView.a() { // from class: com.baidu.tieba.ala.live.pkpanel.a.8
            @Override // com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.a
            public void nv(boolean z) {
                if (z) {
                    a.this.bXE();
                }
            }
        });
        g gVar = new g();
        gVar.w((Activity) this.mContext).a(new f() { // from class: com.baidu.tieba.ala.live.pkpanel.a.9
            @Override // com.baidu.live.view.web.f
            public void dL(int i) {
            }
        }).a(this.hhN.getSchemeCallback()).b(this.bSg);
        for (com.baidu.live.view.web.a aVar : gVar.Wm()) {
            this.hhN.addJavascriptInterface(aVar, aVar.getName());
        }
        this.hhN.loadUrl(str);
    }

    @Override // com.baidu.live.t.a
    public void co(int i) {
        this.mOrientation = i;
        if (this.hhP != null && this.hhM != null) {
            this.hhM.setLayoutParams(bXK());
            BdLog.e("AlaPkPanel:   onScreenOrientationChanged ==> mOrientation: " + this.mOrientation);
        }
        if (this.hhO != null) {
            this.hhO.uL(this.mOrientation);
        }
    }

    @Override // com.baidu.live.t.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hhM != null) {
            this.hhM.bXN();
            BdLog.e("AlaPkPanel:   onKeyboardVisibilityChanged ==> isVisibility: " + z);
        }
    }

    private String bXJ() {
        return (this.buq == null || this.buq.mLiveInfo == null) ? "" : String.valueOf(this.buq.mLiveInfo.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_id", getLiveId());
            jSONObject.putOpt("vid", bXJ());
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

    private FrameLayout.LayoutParams bXK() {
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
