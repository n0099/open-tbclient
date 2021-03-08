package com.baidu.tieba.ala.d;

import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.a.a;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ab;
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
    private ab aED;
    public String aIQ;
    private TbPageContext bFu;
    private AlaAirDropView gSn;
    public boolean gSo;
    public boolean gSp;
    CountDownTimer gSr;
    private a.InterfaceC0160a gSs;
    private PendantParentView gqd;
    private PendantChildView gqe;
    private boolean isHost;
    private boolean gSq = false;
    private com.baidu.live.view.web.h bXA = new com.baidu.live.view.web.h() { // from class: com.baidu.tieba.ala.d.a.2
        @Override // com.baidu.live.view.web.h
        public boolean iF(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            cVar.isFullScreen = a.this.el(str, "fullscreen");
            cVar.url = str;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            return true;
        }
    };
    public CustomMessageListener gSt = new CustomMessageListener(2913274) { // from class: com.baidu.tieba.ala.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                a.this.gSq = ((Boolean) customResponsedMessage.getData()).booleanValue();
            } else {
                a.this.gSq = false;
            }
            if (a.this.gSq && a.this.gSn != null && a.this.gSn.isShowing() && a.this.aED.url.contains("needReloadDangle=1")) {
                a.this.y(a.this.aED);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_url", a.this.aED.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, a.this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_REFRESH).setContentExt(null, null, jSONObject));
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.bFu = tbPageContext;
    }

    @Override // com.baidu.live.a.a
    public void a(ViewGroup viewGroup, ab abVar) {
        if (viewGroup != null && (viewGroup instanceof PendantParentView)) {
            this.gqd = (PendantParentView) viewGroup;
            bOf();
        }
    }

    @Override // com.baidu.live.a.a
    public void a(ab abVar) {
        if (abVar == null || abVar.mLiveInfo == null) {
            if (this.gqe != null) {
                this.gqe.setVisibility(8);
                return;
            }
            return;
        }
        if (this.aED != null && this.aED.aKi != 0 && abVar.aKi != 0 && this.aED.aKi != abVar.aKi) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("airdrop_id", abVar.aKi);
                jSONObject2.put("airdrop_url", abVar.url);
                jSONObject2.put("airdrop_id_current", this.aED.aKi);
                jSONObject.putOpt("airdrop", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_REFUSE).setContentExt(null, null, jSONObject));
        }
        this.aED = abVar;
        if (this.aED.aKh && this.gSn == null) {
            this.gSn = new AlaAirDropView(this.gqe.getContext());
            MessageManager.getInstance().registerListener(this.gSt);
            fj(this.aED.countDown * 1000);
            y(this.aED);
            if (this.gqe != null && this.gqe.indexOfChild(this.gSn) < 0) {
                if (this.gSo || this.gSp) {
                    this.gqe.addView(this.gSn.getView(), new ViewGroup.LayoutParams(this.bFu.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160), this.bFu.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160)));
                } else {
                    this.gqe.addView(this.gSn.getView(), new ViewGroup.LayoutParams((int) (this.bFu.getResources().getDisplayMetrics().heightPixels * 0.3f * 0.455f), (int) (this.bFu.getResources().getDisplayMetrics().heightPixels * 0.3f)));
                }
                this.gqe.bringChildToFront(this.gSn);
            }
        }
    }

    public void y(ab abVar) {
        if (abVar != null && abVar.aKh && this.gSn != null) {
            if (abVar.url == null || abVar.url.length() == 0) {
                this.gSn.getView().setVisibility(8);
            } else if (this.aED != null && this.aED.aJZ != null && this.aED.aJD != null && this.aED.mLiveInfo != null && this.bFu != null) {
                this.aIQ = com.baidu.live.utils.b.a(1, abVar.url, this.aED.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aED.aJZ.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aED.aJD.userId)), String.valueOf(this.aED.mLiveInfo.room_id), String.valueOf(this.aED.mLiveInfo.live_id), "");
                com.baidu.live.view.web.g gVar = new com.baidu.live.view.web.g();
                gVar.t(this.bFu.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.d.a.1
                    @Override // com.baidu.live.view.web.f
                    public void fq(int i) {
                    }
                }).a(this.gSn.getWebView().getSchemeCallback()).b(this.bXA);
                com.baidu.live.view.web.a[] Yb = gVar.Yb();
                for (com.baidu.live.view.web.a aVar : Yb) {
                    this.gSn.getWebView().addJavascriptInterface(aVar, aVar.getName());
                }
                this.gSn.getWebView().loadUrl(this.aIQ);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_id", this.aED.aKi);
                    jSONObject2.put("airdrop_countdown", this.aED.countDown);
                    jSONObject2.put("airdrop_url", this.aED.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_SHOW).setContentExt(null, null, jSONObject));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean el(String str, String str2) {
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
        this.gSo = z;
    }

    @Override // com.baidu.live.a.a
    public void aX(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (this.gSn != null && this.gSn.getView() != null && (layoutParams = this.gSn.getView().getLayoutParams()) != null) {
            if (z) {
                layoutParams.width = this.bFu.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
                layoutParams.height = this.bFu.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
            } else {
                layoutParams.height = (int) (this.bFu.getResources().getDisplayMetrics().heightPixels * 0.3f);
                layoutParams.width = (int) (this.bFu.getResources().getDisplayMetrics().heightPixels * 0.3f * 0.455f);
            }
            this.gSn.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.a.a
    public void setIsHorizontal(boolean z) {
        this.gSp = z;
    }

    @Override // com.baidu.live.a.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.a.a
    public void setCanVisible(boolean z) {
        if (this.gqe != null) {
            if (z) {
                this.gqe.setVisibility(0);
            } else {
                this.gqe.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.a.a
    public void xk() {
        mv(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv(boolean z) {
        if (this.gSr != null) {
            this.gSr.cancel();
        }
        if (this.gSn != null && (this.gSn.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gSn.getParent()).removeView(this.gSn);
        }
        if (z) {
            if (this.gqe != null && (this.gqe.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gqe.getParent()).removeView(this.gqe);
            }
            this.gSn = null;
            this.gqe = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gSt);
    }

    @Override // com.baidu.live.a.a
    public void onDestroy() {
        mv(true);
    }

    @Override // com.baidu.live.a.a
    public void a(a.InterfaceC0160a interfaceC0160a) {
        this.gSs = interfaceC0160a;
    }

    private void bOf() {
        if (this.gqe == null) {
            this.gqe = new PendantChildView(this.bFu.getPageActivity()) { // from class: com.baidu.tieba.ala.d.a.3
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
                    return (this.byt == PendantParentView.Model.VERTICAL || this.byt == PendantParentView.Model.VERTICAL_BB_CHATING) ? 96 : 23;
                }
            };
            if (this.gqd != null) {
                this.gqd.a(this.gqe, new LinearLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void fj(long j) {
        if (this.gSr != null) {
            this.gSr.cancel();
        }
        this.gSr = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.d.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.mv(false);
                a.this.gSn = null;
                cancel();
                if (a.this.gSs != null) {
                    a.this.gSs.xm();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_id", a.this.aED.aKi);
                    jSONObject2.put("airdrop_url", a.this.aED.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, a.this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_DISMISS).setContentExt(null, null, jSONObject));
            }
        };
        this.gSr.start();
        if (this.gSs != null) {
            this.gSs.xl();
        }
    }
}
