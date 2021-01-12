package com.baidu.tieba.ala.d;

import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.a.a;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.x;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.view.AlaAirDropView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.a.a {
    private x aBr;
    public String aEU;
    private TbPageContext bAo;
    private AlaAirDropView gNK;
    public boolean gNL;
    public boolean gNM;
    CountDownTimer gNO;
    private a.InterfaceC0154a gNP;
    private PendantParentView glA;
    private PendantChildView glB;
    private boolean isHost;
    private boolean gNN = false;
    private com.baidu.live.view.web.h bSg = new com.baidu.live.view.web.h() { // from class: com.baidu.tieba.ala.d.a.2
        @Override // com.baidu.live.view.web.h
        public void hZ(String str) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                cVar.isFullScreen = a.this.aT(str, "fullscreen");
                cVar.url = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            }
        }
    };
    public CustomMessageListener gNQ = new CustomMessageListener(2913274) { // from class: com.baidu.tieba.ala.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                a.this.gNN = ((Boolean) customResponsedMessage.getData()).booleanValue();
            } else {
                a.this.gNN = false;
            }
            if (a.this.gNN && a.this.gNK != null && a.this.gNK.isShowing() && a.this.aBr.url.contains("needReloadDangle=1")) {
                a.this.y(a.this.aBr);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_url", a.this.aBr.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, a.this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_REFRESH).setContentExt(null, null, jSONObject));
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.bAo = tbPageContext;
    }

    @Override // com.baidu.live.a.a
    public void a(ViewGroup viewGroup, x xVar) {
        if (viewGroup != null && (viewGroup instanceof PendantParentView)) {
            this.glA = (PendantParentView) viewGroup;
            bNr();
        }
    }

    @Override // com.baidu.live.a.a
    public void a(x xVar) {
        if (xVar == null || xVar.mLiveInfo == null) {
            if (this.glB != null) {
                this.glB.setVisibility(8);
                return;
            }
            return;
        }
        if (this.aBr != null && this.aBr.aGm != 0 && xVar.aGm != 0 && this.aBr.aGm != xVar.aGm) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("airdrop_id", xVar.aGm);
                jSONObject2.put("airdrop_url", xVar.url);
                jSONObject2.put("airdrop_id_current", this.aBr.aGm);
                jSONObject.putOpt("airdrop", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_REFUSE).setContentExt(null, null, jSONObject));
        }
        this.aBr = xVar;
        if (this.aBr.aGl && this.gNK == null) {
            this.gNK = new AlaAirDropView(this.glB.getContext());
            MessageManager.getInstance().registerListener(this.gNQ);
            fd(this.aBr.countDown * 1000);
            y(this.aBr);
            if (this.glB != null && this.glB.indexOfChild(this.gNK) < 0) {
                if (this.gNL || this.gNM) {
                    this.glB.addView(this.gNK.getView(), new ViewGroup.LayoutParams(this.bAo.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160), this.bAo.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160)));
                } else {
                    this.glB.addView(this.gNK.getView(), new ViewGroup.LayoutParams((int) (this.bAo.getResources().getDisplayMetrics().heightPixels * 0.44f * 0.455f), (int) (this.bAo.getResources().getDisplayMetrics().heightPixels * 0.44f)));
                }
                this.glB.bringChildToFront(this.gNK);
            }
        }
    }

    public void y(x xVar) {
        if (xVar != null && xVar.aGl && this.gNK != null) {
            if (xVar.url == null || xVar.url.length() == 0) {
                this.gNK.getView().setVisibility(8);
            } else if (this.aBr != null && this.aBr.aGd != null && this.aBr.aFH != null && this.aBr.mLiveInfo != null && this.bAo != null) {
                this.aEU = com.baidu.live.utils.b.a(1, xVar.url, this.aBr.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aBr.aGd.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aBr.aFH.userId)), String.valueOf(this.aBr.mLiveInfo.room_id), String.valueOf(this.aBr.mLiveInfo.live_id), "");
                com.baidu.live.view.web.g gVar = new com.baidu.live.view.web.g();
                gVar.w(this.bAo.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.d.a.1
                    @Override // com.baidu.live.view.web.f
                    public void dL(int i) {
                    }
                }).a(this.gNK.getWebView().getSchemeCallback()).b(this.bSg);
                com.baidu.live.view.web.a[] Wm = gVar.Wm();
                for (com.baidu.live.view.web.a aVar : Wm) {
                    this.gNK.getWebView().addJavascriptInterface(aVar, aVar.getName());
                }
                this.gNK.getWebView().loadUrl(this.aEU);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_id", this.aBr.aGm);
                    jSONObject2.put("airdrop_countdown", this.aBr.countDown);
                    jSONObject2.put("airdrop_url", this.aBr.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_SHOW).setContentExt(null, null, jSONObject));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aT(String str, String str2) {
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

    @Override // com.baidu.live.a.a
    public void aW(boolean z) {
        this.gNL = z;
    }

    @Override // com.baidu.live.a.a
    public void aX(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (this.gNK != null && this.gNK.getView() != null && (layoutParams = this.gNK.getView().getLayoutParams()) != null) {
            if (z) {
                layoutParams.width = this.bAo.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
                layoutParams.height = this.bAo.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
            } else {
                layoutParams.height = (int) (this.bAo.getResources().getDisplayMetrics().heightPixels * 0.44f);
                layoutParams.width = (int) (this.bAo.getResources().getDisplayMetrics().heightPixels * 0.44f * 0.455f);
            }
            this.gNK.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.a.a
    public void aY(boolean z) {
        this.gNM = z;
    }

    @Override // com.baidu.live.a.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.a.a
    public void setCanVisible(boolean z) {
        if (this.glB != null) {
            if (z) {
                this.glB.setVisibility(0);
            } else {
                this.glB.setVisibility(8);
            }
            Log.e("pendent_check", "==>> airdrop mCharmParentView.setVisibility() canVisible : " + z);
        }
    }

    @Override // com.baidu.live.a.a
    public void xk() {
        mr(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(boolean z) {
        if (this.gNK != null && (this.gNK.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gNK.getParent()).removeView(this.gNK);
        }
        if (z) {
            if (this.glB != null && (this.glB.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.glB.getParent()).removeView(this.glB);
            }
            this.gNK = null;
            this.glB = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gNQ);
    }

    @Override // com.baidu.live.a.a
    public void onDestroy() {
        mr(true);
    }

    @Override // com.baidu.live.a.a
    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.gNP = interfaceC0154a;
    }

    private void bNr() {
        if (this.glB == null) {
            this.glB = new PendantChildView(this.bAo.getPageActivity()) { // from class: com.baidu.tieba.ala.d.a.3
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
                    return (this.btq == PendantParentView.Model.VERTICAL || this.btq == PendantParentView.Model.VERTICAL_BB_CHATING) ? 96 : 23;
                }
            };
            if (this.glA != null) {
                this.glA.a(this.glB, new LinearLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void fd(long j) {
        if (this.gNO != null) {
            this.gNO.cancel();
        }
        this.gNO = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.d.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.mr(false);
                a.this.gNK = null;
                cancel();
                if (a.this.gNP != null) {
                    a.this.gNP.xm();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_id", a.this.aBr.aGm);
                    jSONObject2.put("airdrop_url", a.this.aBr.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, a.this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_DISMISS).setContentExt(null, null, jSONObject));
            }
        };
        this.gNO.start();
        if (this.gNP != null) {
            this.gNP.xl();
        }
    }
}
