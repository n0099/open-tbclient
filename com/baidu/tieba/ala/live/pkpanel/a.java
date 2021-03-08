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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.s.a {
    private CustomMessageListener bmk;
    private ab bzn;
    private View gTE;
    private ViewGroup hnX;
    private AlaDragContainerView hnY;
    private AlaPkPanelWebView hnZ;
    private com.baidu.tieba.ala.live.pkpanel.a.a hoa;
    private ai hob;
    private HandlerC0658a hoc;
    private List<String> hod;
    private CustomMessageListener hoe;
    private CustomMessageListener hof;
    private CustomMessageListener hog;
    private Context mContext;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mOrientation = 1;
    private h bXA = new h() { // from class: com.baidu.tieba.ala.live.pkpanel.a.2
        @Override // com.baidu.live.view.web.h
        public boolean iF(String str) {
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

    private void bYP() {
        if (this.hod != null) {
            this.hod.clear();
        }
        if (this.hoc != null) {
            this.hoc.removeMessages(1000);
        }
        Jz();
    }

    private void Jz() {
        if (this.bmk != null) {
            MessageManager.getInstance().unRegisterListener(this.bmk);
            this.bmk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYQ() {
        if (Build.VERSION.SDK_INT >= 19) {
            Jy();
            if (this.hoc == null) {
                this.hoc = new HandlerC0658a(this);
            }
            if (!this.hoc.hasMessages(1000)) {
                this.hoc.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0658a extends Handler {
        private final WeakReference<a> hoi;

        HandlerC0658a(a aVar) {
            this.hoi = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hoi.get() != null && message.what == 1000) {
                this.hoi.get().bYR();
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
        if (this.hnZ != null) {
            if (this.hod == null || (size = this.hod.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hod.get(i));
                }
                str = jSONArray.toString();
                this.hod.clear();
            }
            if (this.hnZ.bYX()) {
                z2 = true;
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.hnZ.evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                        z = true;
                        if (!z) {
                            this.hoc.sendEmptyMessageDelayed(1000, 1000L);
                            return;
                        } else {
                            bYP();
                            return;
                        }
                    }
                    this.hnZ.loadUrl("javascript:getClientInfo(" + str + ")");
                }
            }
            z = z2;
            if (!z) {
            }
        }
    }

    private void Jy() {
        if (this.hod == null) {
            this.hod = new ArrayList();
        }
        this.hod.clear();
        this.bmk = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.live.pkpanel.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.hod.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bmk);
    }

    private void registerListener() {
        if (this.hoe == null) {
            this.hoe = new CustomMessageListener(2913259) { // from class: com.baidu.tieba.ala.live.pkpanel.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null) {
                        if (a.this.hoa == null && a.this.mContext != null) {
                            a.this.hoa = new com.baidu.tieba.ala.live.pkpanel.a.a(a.this.mContext, a.this.mOrientation, jSONObject);
                        }
                        a.this.hoa.QH();
                        a.this.av("10603", "h5_live", "rulepop_show");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hoe);
        }
        if (this.hof == null) {
            this.hof = new CustomMessageListener(2913257) { // from class: com.baidu.tieba.ala.live.pkpanel.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ai)) {
                        a.this.hob = (ai) customResponsedMessage.getData();
                        if (a.this.hob != null) {
                            BdLog.e("AlaPkPanel:  pkPanelInfo.isOpenAction(): \t" + a.this.hob.Ce());
                            if (a.this.hob.Ce()) {
                                a.this.a(a.this.hob);
                            } else {
                                a.this.bYS();
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hof);
            BdLog.e("AlaPkPanel:  registerListener ==> mLivePkPanelShowListener");
        }
        if (this.hog == null) {
            this.hog = new CustomMessageListener(2913258) { // from class: com.baidu.tieba.ala.live.pkpanel.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (jSONObject = (JSONObject) customResponsedMessage.getData()) != null && a.this.hnZ != null && a.this.hnZ.getSchemeCallback() != null) {
                        a.this.hnZ.getSchemeCallback().doJsCallback(0, "", jSONObject, "followCallback ");
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYS() {
        if (this.gTE != null && this.hnX != null && this.hnX.indexOfChild(this.gTE) >= 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hnX != null) {
                        a.this.hnX.removeView(a.this.gTE);
                    }
                    if (a.this.hnZ != null) {
                        a.this.hnZ.release();
                    }
                    a.this.hnZ = null;
                    a.this.hnY = null;
                    a.this.gTE = null;
                    BdLog.e("AlaPkPanel:   closePkPanelView ==> mRootLiveView.removeView(contain)");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ai aiVar) {
        b(aiVar);
        if (this.gTE != null && this.hnX != null && this.hnX.indexOfChild(this.gTE) < 0) {
            getSafeHandler().post(new Runnable() { // from class: com.baidu.tieba.ala.live.pkpanel.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gTE.getParent() != null && (a.this.gTE.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) a.this.gTE.getParent()).removeView(a.this.gTE);
                        BdLog.e("AlaPkPanel:  openPkPanelView ==> contain has  Parent ==> parent.removeView(contain)");
                    }
                    if (a.this.hnX != null) {
                        a.this.hnX.addView(a.this.gTE, new RelativeLayout.LayoutParams(-1, -1));
                        BdLog.e("AlaPkPanel:   openPkPanelView ==> mRootLiveView.addView(contain, llp)");
                    }
                }
            });
        }
    }

    private void b(ai aiVar) {
        if (aiVar != null && this.gTE == null) {
            this.gTE = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_container, (ViewGroup) null);
            this.hnY = (AlaDragContainerView) this.gTE.findViewById(a.f.ala_pkpanel_dragview);
            this.hnY.setLayoutParams(bYV());
            Hx(c(aiVar));
            this.hnY.addView(this.hnZ, d(aiVar));
        }
    }

    private Handler getSafeHandler() {
        if (this.hoc == null) {
            this.hoc = new HandlerC0658a(this);
        }
        return this.hoc;
    }

    @Override // com.baidu.live.s.a
    public void h(ab abVar) {
        this.bzn = abVar;
    }

    @Override // com.baidu.live.s.a
    public void b(ab abVar) {
        this.bzn = abVar;
    }

    @Override // com.baidu.live.s.a
    public void Jc() {
        this.hoa = null;
        if (this.hoe != null) {
            MessageManager.getInstance().unRegisterListener(this.hoe);
            this.hoe = null;
        }
        if (this.hog != null) {
            MessageManager.getInstance().unRegisterListener(this.hog);
            this.hog = null;
        }
        if (this.hof != null) {
            MessageManager.getInstance().unRegisterListener(this.hof);
            this.hof = null;
            BdLog.e("AlaPkPanel : onQuitRoom ==> unRegisterListener ==> mLivePkPanelShowListener");
        }
        bYT();
    }

    @Override // com.baidu.live.s.a
    public void onDestory() {
        Jc();
    }

    private void bYT() {
        bYS();
        if (this.hnZ != null) {
            this.hnZ.release();
        }
        this.hnZ = null;
        this.hnY = null;
        this.gTE = null;
        this.hob = null;
        this.hnX = null;
        BdLog.e("AlaPkPanel:  onQuitRoom() ==> quitRoomAndRelease ==>  clear webView Container");
    }

    @Override // com.baidu.live.s.a
    public void p(ViewGroup viewGroup) {
        this.hnX = viewGroup;
    }

    private String c(ai aiVar) {
        String str = "";
        if (aiVar.Cd() != null) {
            str = URLEncoder.encode(aiVar.Cd());
        }
        return aiVar.Cc() + "?jsonData=" + str + "&room_id=" + getRoomId() + "&live_id=" + getLiveId() + "&subapp_type=" + TbConfig.getSubappType();
    }

    private String getLiveId() {
        return (this.bzn == null || this.bzn.mLiveInfo == null) ? "" : String.valueOf(this.bzn.mLiveInfo.getLiveID());
    }

    private String getRoomId() {
        return (this.bzn == null || this.bzn.mLiveInfo == null) ? "" : String.valueOf(this.bzn.mLiveInfo.room_id);
    }

    private void Hx(String str) {
        com.baidu.live.view.web.a[] Yb;
        this.hnZ = new AlaPkPanelWebView(this.mContext);
        this.hnZ.setCallback(new AlaPkPanelWebView.a() { // from class: com.baidu.tieba.ala.live.pkpanel.a.8
            @Override // com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.a
            public void nG(boolean z) {
                if (z) {
                    a.this.bYQ();
                }
            }
        });
        g gVar = new g();
        gVar.t((Activity) this.mContext).a(new f() { // from class: com.baidu.tieba.ala.live.pkpanel.a.9
            @Override // com.baidu.live.view.web.f
            public void fq(int i) {
            }
        }).a(this.hnZ.getSchemeCallback()).b(this.bXA);
        for (com.baidu.live.view.web.a aVar : gVar.Yb()) {
            this.hnZ.addJavascriptInterface(aVar, aVar.getName());
        }
        this.hnZ.loadUrl(str);
    }

    @Override // com.baidu.live.s.a
    public void cs(int i) {
        this.mOrientation = i;
        if (this.hob != null && this.hnY != null) {
            this.hnY.setLayoutParams(bYV());
            BdLog.e("AlaPkPanel:   onScreenOrientationChanged ==> mOrientation: " + this.mOrientation);
        }
        if (this.hoa != null) {
            this.hoa.uX(this.mOrientation);
        }
    }

    @Override // com.baidu.live.s.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hnY != null) {
            this.hnY.bYY();
            BdLog.e("AlaPkPanel:   onKeyboardVisibilityChanged ==> isVisibility: " + z);
        }
    }

    private String bYU() {
        return (this.bzn == null || this.bzn.mLiveInfo == null) ? "" : String.valueOf(this.bzn.mLiveInfo.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(String str, String str2, String str3) {
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

    private FrameLayout.LayoutParams d(ai aiVar) {
        return new FrameLayout.LayoutParams((int) ((aiVar.getWidth() / 375.0f) * this.mScreenWidth), (int) ((aiVar.getHeight() / 375.0f) * this.mScreenWidth));
    }

    private FrameLayout.LayoutParams bYV() {
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
