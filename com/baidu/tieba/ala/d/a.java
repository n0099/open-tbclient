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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.a.a {
    private ab aDd;
    public String aHq;
    private TbPageContext bDU;
    private AlaAirDropView gQE;
    public boolean gQF;
    public boolean gQG;
    CountDownTimer gQI;
    private a.InterfaceC0154a gQJ;
    private PendantParentView gou;
    private PendantChildView gov;
    private boolean isHost;
    private boolean gQH = false;
    private com.baidu.live.view.web.h bWa = new com.baidu.live.view.web.h() { // from class: com.baidu.tieba.ala.d.a.2
        @Override // com.baidu.live.view.web.h
        public boolean iz(String str) {
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
    public CustomMessageListener gQK = new CustomMessageListener(2913274) { // from class: com.baidu.tieba.ala.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                a.this.gQH = ((Boolean) customResponsedMessage.getData()).booleanValue();
            } else {
                a.this.gQH = false;
            }
            if (a.this.gQH && a.this.gQE != null && a.this.gQE.isShowing() && a.this.aDd.url.contains("needReloadDangle=1")) {
                a.this.y(a.this.aDd);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_url", a.this.aDd.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, a.this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_REFRESH).setContentExt(null, null, jSONObject));
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.bDU = tbPageContext;
    }

    @Override // com.baidu.live.a.a
    public void a(ViewGroup viewGroup, ab abVar) {
        if (viewGroup != null && (viewGroup instanceof PendantParentView)) {
            this.gou = (PendantParentView) viewGroup;
            bNZ();
        }
    }

    @Override // com.baidu.live.a.a
    public void a(ab abVar) {
        if (abVar == null || abVar.mLiveInfo == null) {
            if (this.gov != null) {
                this.gov.setVisibility(8);
                return;
            }
            return;
        }
        if (this.aDd != null && this.aDd.aII != 0 && abVar.aII != 0 && this.aDd.aII != abVar.aII) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("airdrop_id", abVar.aII);
                jSONObject2.put("airdrop_url", abVar.url);
                jSONObject2.put("airdrop_id_current", this.aDd.aII);
                jSONObject.putOpt("airdrop", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_REFUSE).setContentExt(null, null, jSONObject));
        }
        this.aDd = abVar;
        if (this.aDd.aIH && this.gQE == null) {
            this.gQE = new AlaAirDropView(this.gov.getContext());
            MessageManager.getInstance().registerListener(this.gQK);
            fj(this.aDd.countDown * 1000);
            y(this.aDd);
            if (this.gov != null && this.gov.indexOfChild(this.gQE) < 0) {
                if (this.gQF || this.gQG) {
                    this.gov.addView(this.gQE.getView(), new ViewGroup.LayoutParams(this.bDU.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160), this.bDU.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160)));
                } else {
                    this.gov.addView(this.gQE.getView(), new ViewGroup.LayoutParams((int) (this.bDU.getResources().getDisplayMetrics().heightPixels * 0.3f * 0.455f), (int) (this.bDU.getResources().getDisplayMetrics().heightPixels * 0.3f)));
                }
                this.gov.bringChildToFront(this.gQE);
            }
        }
    }

    public void y(ab abVar) {
        if (abVar != null && abVar.aIH && this.gQE != null) {
            if (abVar.url == null || abVar.url.length() == 0) {
                this.gQE.getView().setVisibility(8);
            } else if (this.aDd != null && this.aDd.aIz != null && this.aDd.aId != null && this.aDd.mLiveInfo != null && this.bDU != null) {
                this.aHq = com.baidu.live.utils.b.a(1, abVar.url, this.aDd.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aDd.aIz.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aDd.aId.userId)), String.valueOf(this.aDd.mLiveInfo.room_id), String.valueOf(this.aDd.mLiveInfo.live_id), "");
                com.baidu.live.view.web.g gVar = new com.baidu.live.view.web.g();
                gVar.t(this.bDU.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.d.a.1
                    @Override // com.baidu.live.view.web.f
                    public void fp(int i) {
                    }
                }).a(this.gQE.getWebView().getSchemeCallback()).b(this.bWa);
                com.baidu.live.view.web.a[] XY = gVar.XY();
                for (com.baidu.live.view.web.a aVar : XY) {
                    this.gQE.getWebView().addJavascriptInterface(aVar, aVar.getName());
                }
                this.gQE.getWebView().loadUrl(this.aHq);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_id", this.aDd.aII);
                    jSONObject2.put("airdrop_countdown", this.aDd.countDown);
                    jSONObject2.put("airdrop_url", this.aDd.url);
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
        this.gQF = z;
    }

    @Override // com.baidu.live.a.a
    public void aX(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (this.gQE != null && this.gQE.getView() != null && (layoutParams = this.gQE.getView().getLayoutParams()) != null) {
            if (z) {
                layoutParams.width = this.bDU.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
                layoutParams.height = this.bDU.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
            } else {
                layoutParams.height = (int) (this.bDU.getResources().getDisplayMetrics().heightPixels * 0.3f);
                layoutParams.width = (int) (this.bDU.getResources().getDisplayMetrics().heightPixels * 0.3f * 0.455f);
            }
            this.gQE.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.a.a
    public void setIsHorizontal(boolean z) {
        this.gQG = z;
    }

    @Override // com.baidu.live.a.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.a.a
    public void setCanVisible(boolean z) {
        if (this.gov != null) {
            if (z) {
                this.gov.setVisibility(0);
            } else {
                this.gov.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.a.a
    public void xh() {
        mv(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv(boolean z) {
        if (this.gQI != null) {
            this.gQI.cancel();
        }
        if (this.gQE != null && (this.gQE.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gQE.getParent()).removeView(this.gQE);
        }
        if (z) {
            if (this.gov != null && (this.gov.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gov.getParent()).removeView(this.gov);
            }
            this.gQE = null;
            this.gov = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gQK);
    }

    @Override // com.baidu.live.a.a
    public void onDestroy() {
        mv(true);
    }

    @Override // com.baidu.live.a.a
    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.gQJ = interfaceC0154a;
    }

    private void bNZ() {
        if (this.gov == null) {
            this.gov = new PendantChildView(this.bDU.getPageActivity()) { // from class: com.baidu.tieba.ala.d.a.3
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
                    return (this.bwT == PendantParentView.Model.VERTICAL || this.bwT == PendantParentView.Model.VERTICAL_BB_CHATING) ? 96 : 23;
                }
            };
            if (this.gou != null) {
                this.gou.a(this.gov, new LinearLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void fj(long j) {
        if (this.gQI != null) {
            this.gQI.cancel();
        }
        this.gQI = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.d.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.mv(false);
                a.this.gQE = null;
                cancel();
                if (a.this.gQJ != null) {
                    a.this.gQJ.xj();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_id", a.this.aDd.aII);
                    jSONObject2.put("airdrop_url", a.this.aDd.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, a.this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_DISMISS).setContentExt(null, null, jSONObject));
            }
        };
        this.gQI.start();
        if (this.gQJ != null) {
            this.gQJ.xi();
        }
    }
}
