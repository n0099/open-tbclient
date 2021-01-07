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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.a.a {
    private x aGe;
    public String aJH;
    private TbPageContext bFa;
    private AlaAirDropView gSq;
    public boolean gSr;
    public boolean gSs;
    CountDownTimer gSu;
    private a.InterfaceC0163a gSv;
    private PendantParentView gqh;
    private PendantChildView gqi;
    private boolean isHost;
    private boolean gSt = false;
    private com.baidu.live.view.web.h bWS = new com.baidu.live.view.web.h() { // from class: com.baidu.tieba.ala.d.a.2
        @Override // com.baidu.live.view.web.h
        public void jk(String str) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                cVar.isFullScreen = a.this.aU(str, "fullscreen");
                cVar.url = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            }
        }
    };
    public CustomMessageListener gSw = new CustomMessageListener(2913274) { // from class: com.baidu.tieba.ala.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                a.this.gSt = ((Boolean) customResponsedMessage.getData()).booleanValue();
            } else {
                a.this.gSt = false;
            }
            if (a.this.gSt && a.this.gSq != null && a.this.gSq.isShowing() && a.this.aGe.url.contains("needReloadDangle=1")) {
                a.this.y(a.this.aGe);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_url", a.this.aGe.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, a.this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_REFRESH).setContentExt(null, null, jSONObject));
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.bFa = tbPageContext;
    }

    @Override // com.baidu.live.a.a
    public void a(ViewGroup viewGroup, x xVar) {
        if (viewGroup != null && (viewGroup instanceof PendantParentView)) {
            this.gqh = (PendantParentView) viewGroup;
            bRj();
        }
    }

    @Override // com.baidu.live.a.a
    public void a(x xVar) {
        if (xVar == null || xVar.mLiveInfo == null) {
            if (this.gqi != null) {
                this.gqi.setVisibility(8);
                return;
            }
            return;
        }
        if (this.aGe != null && this.aGe.aKZ != 0 && xVar.aKZ != 0 && this.aGe.aKZ != xVar.aKZ) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("airdrop_id", xVar.aKZ);
                jSONObject2.put("airdrop_url", xVar.url);
                jSONObject2.put("airdrop_id_current", this.aGe.aKZ);
                jSONObject.putOpt("airdrop", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_REFUSE).setContentExt(null, null, jSONObject));
        }
        this.aGe = xVar;
        if (this.aGe.aKY && this.gSq == null) {
            this.gSq = new AlaAirDropView(this.gqi.getContext());
            MessageManager.getInstance().registerListener(this.gSw);
            fd(this.aGe.countDown * 1000);
            y(this.aGe);
            if (this.gqi != null && this.gqi.indexOfChild(this.gSq) < 0) {
                if (this.gSr || this.gSs) {
                    this.gqi.addView(this.gSq.getView(), new ViewGroup.LayoutParams(this.bFa.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160), this.bFa.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160)));
                } else {
                    this.gqi.addView(this.gSq.getView(), new ViewGroup.LayoutParams((int) (this.bFa.getResources().getDisplayMetrics().heightPixels * 0.44f * 0.455f), (int) (this.bFa.getResources().getDisplayMetrics().heightPixels * 0.44f)));
                }
                this.gqi.bringChildToFront(this.gSq);
            }
        }
    }

    public void y(x xVar) {
        if (xVar != null && xVar.aKY && this.gSq != null) {
            if (xVar.url == null || xVar.url.length() == 0) {
                this.gSq.getView().setVisibility(8);
            } else if (this.aGe != null && this.aGe.aKQ != null && this.aGe.aKu != null && this.aGe.mLiveInfo != null && this.bFa != null) {
                this.aJH = com.baidu.live.utils.b.a(1, xVar.url, this.aGe.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aGe.aKQ.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aGe.aKu.userId)), String.valueOf(this.aGe.mLiveInfo.room_id), String.valueOf(this.aGe.mLiveInfo.live_id), "");
                com.baidu.live.view.web.g gVar = new com.baidu.live.view.web.g();
                gVar.w(this.bFa.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.d.a.1
                    @Override // com.baidu.live.view.web.f
                    public void fr(int i) {
                    }
                }).a(this.gSq.getWebView().getSchemeCallback()).b(this.bWS);
                com.baidu.live.view.web.a[] aaf = gVar.aaf();
                for (com.baidu.live.view.web.a aVar : aaf) {
                    this.gSq.getWebView().addJavascriptInterface(aVar, aVar.getName());
                }
                this.gSq.getWebView().loadUrl(this.aJH);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_id", this.aGe.aKZ);
                    jSONObject2.put("airdrop_countdown", this.aGe.countDown);
                    jSONObject2.put("airdrop_url", this.aGe.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_SHOW).setContentExt(null, null, jSONObject));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aU(String str, String str2) {
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
    public void ba(boolean z) {
        this.gSr = z;
    }

    @Override // com.baidu.live.a.a
    public void bb(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (this.gSq != null && this.gSq.getView() != null && (layoutParams = this.gSq.getView().getLayoutParams()) != null) {
            if (z) {
                layoutParams.width = this.bFa.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
                layoutParams.height = this.bFa.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
            } else {
                layoutParams.height = (int) (this.bFa.getResources().getDisplayMetrics().heightPixels * 0.44f);
                layoutParams.width = (int) (this.bFa.getResources().getDisplayMetrics().heightPixels * 0.44f * 0.455f);
            }
            this.gSq.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.a.a
    public void bc(boolean z) {
        this.gSs = z;
    }

    @Override // com.baidu.live.a.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.a.a
    public void setCanVisible(boolean z) {
        if (this.gqi != null) {
            if (z) {
                this.gqi.setVisibility(0);
            } else {
                this.gqi.setVisibility(8);
            }
            Log.e("pendent_check", "==>> airdrop mCharmParentView.setVisibility() canVisible : " + z);
        }
    }

    @Override // com.baidu.live.a.a
    public void Bf() {
        mv(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv(boolean z) {
        if (this.gSq != null && (this.gSq.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gSq.getParent()).removeView(this.gSq);
        }
        if (z) {
            if (this.gqi != null && (this.gqi.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gqi.getParent()).removeView(this.gqi);
            }
            this.gSq = null;
            this.gqi = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gSw);
    }

    @Override // com.baidu.live.a.a
    public void onDestroy() {
        mv(true);
    }

    @Override // com.baidu.live.a.a
    public void a(a.InterfaceC0163a interfaceC0163a) {
        this.gSv = interfaceC0163a;
    }

    private void bRj() {
        if (this.gqi == null) {
            this.gqi = new PendantChildView(this.bFa.getPageActivity()) { // from class: com.baidu.tieba.ala.d.a.3
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
                    return (this.byd == PendantParentView.Model.VERTICAL || this.byd == PendantParentView.Model.VERTICAL_BB_CHATING) ? 96 : 23;
                }
            };
            if (this.gqh != null) {
                this.gqh.a(this.gqi, new LinearLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void fd(long j) {
        if (this.gSu != null) {
            this.gSu.cancel();
        }
        this.gSu = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.d.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.mv(false);
                a.this.gSq = null;
                cancel();
                if (a.this.gSv != null) {
                    a.this.gSv.Bh();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("airdrop_id", a.this.aGe.aKZ);
                    jSONObject2.put("airdrop_url", a.this.aGe.url);
                    jSONObject.putOpt("airdrop", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AIR_DROP, UbcStatConstant.ContentType.UBC_TYPE_AIR_DROP, a.this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_AIRDROP_DISMISS).setContentExt(null, null, jSONObject));
            }
        };
        this.gSu.start();
        if (this.gSv != null) {
            this.gSv.Bg();
        }
    }
}
