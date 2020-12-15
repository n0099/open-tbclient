package com.baidu.tieba.ala.d;

import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.AlaAirDropView;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.a.a {
    private w aFN;
    public String aJj;
    private TbPageContext bAn;
    private PendantParentView gEk;
    private PendantChildView gEl;
    private AlaAirDropView gGF;
    public boolean gGG;
    public boolean gGH;
    CountDownTimer gGJ;
    private boolean gGI = false;
    private com.baidu.live.view.web.h bRm = new com.baidu.live.view.web.h() { // from class: com.baidu.tieba.ala.d.a.2
        @Override // com.baidu.live.view.web.h
        public void jr(String str) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
                cVar.isFullScreen = a.this.aZ(str, "fullscreen");
                cVar.url = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            }
        }
    };
    public CustomMessageListener gGK = new CustomMessageListener(2913274) { // from class: com.baidu.tieba.ala.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null) {
                a.this.gGI = false;
            } else {
                a.this.gGI = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
            if (a.this.gGI && a.this.gGF != null && a.this.gGF.isShowing() && a.this.aFN.url.contains("needReloadDangle=1")) {
                a.this.x(a.this.aFN);
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.bAn = tbPageContext;
    }

    @Override // com.baidu.live.a.a
    public void a(ViewGroup viewGroup, w wVar) {
        if (viewGroup != null && (viewGroup instanceof PendantParentView)) {
            this.gEk = (PendantParentView) viewGroup;
            bUk();
        }
    }

    @Override // com.baidu.live.a.a
    public void a(w wVar) {
        if (wVar == null || wVar.mLiveInfo == null) {
            if (this.gEl != null) {
                this.gEl.setVisibility(8);
                return;
            }
            return;
        }
        this.aFN = wVar;
        if (this.aFN.aKz && this.gGF == null) {
            this.gGF = new AlaAirDropView(this.gEl.getContext());
            MessageManager.getInstance().registerListener(this.gGK);
            fd(this.aFN.countDown * 1000);
            x(this.aFN);
            if (this.gEl != null && this.gEl.indexOfChild(this.gGF) < 0) {
                if (this.gGG || this.gGH) {
                    this.gEl.addView(this.gGF.getView(), new ViewGroup.LayoutParams(this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds122), this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds136)));
                } else {
                    this.gEl.addView(this.gGF.getView(), new ViewGroup.LayoutParams(this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds360), this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds740)));
                }
                this.gEl.bringChildToFront(this.gGF);
            }
        }
    }

    public void x(w wVar) {
        if (wVar.aKz) {
            if (wVar.url == null) {
                this.gGF.getView().setVisibility(8);
                return;
            }
            this.aJj = com.baidu.live.utils.b.a(1, wVar.url, this.aFN.isHost, String.valueOf(this.aFN.aKr.userId), String.valueOf(this.aFN.aJV.userId), String.valueOf(this.aFN.mLiveInfo.room_id), String.valueOf(this.aFN.mLiveInfo.live_id), "debug=1");
            com.baidu.live.view.web.g gVar = new com.baidu.live.view.web.g();
            gVar.x(this.bAn.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.d.a.1
                @Override // com.baidu.live.view.web.f
                public void fr(int i) {
                }
            }).a(this.gGF.getWebView().getSchemeCallback()).b(this.bRm);
            com.baidu.live.view.web.a[] YO = gVar.YO();
            for (com.baidu.live.view.web.a aVar : YO) {
                this.gGF.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gGF.getWebView().loadUrl(this.aJj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZ(String str, String str2) {
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
    public void bd(boolean z) {
        this.gGG = z;
    }

    @Override // com.baidu.live.a.a
    public void be(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (this.gGF != null && this.gGF.getView() != null && (layoutParams = this.gGF.getView().getLayoutParams()) != null) {
            if (z) {
                layoutParams.width = this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds122);
                layoutParams.height = this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds136);
            } else {
                layoutParams.width = this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds360);
                layoutParams.height = this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds740);
            }
            this.gGF.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.a.a
    public void bf(boolean z) {
        this.gGH = z;
    }

    @Override // com.baidu.live.a.a
    public void setCanVisible(boolean z) {
        if (this.gEl != null) {
            if (z) {
                this.gEl.setVisibility(0);
            } else {
                this.gEl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(boolean z) {
        if (this.gGF != null && (this.gGF.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gGF.getParent()).removeView(this.gGF);
        }
        if (z && this.gEl != null && (this.gEl.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gEl.getParent()).removeView(this.gEl);
        }
        MessageManager.getInstance().unRegisterListener(this.gGK);
    }

    private void bUk() {
        if (this.gEl == null) {
            this.gEl = new PendantChildView(this.bAn.getPageActivity()) { // from class: com.baidu.tieba.ala.d.a.3
                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalPkPosition() {
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
                    return this.btr == PendantParentView.Model.VERTICAL ? 94 : 23;
                }
            };
            if (this.gEk != null) {
                this.gEk.a(this.gEl, new LinearLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void fd(long j) {
        this.gGJ = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.d.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.lY(false);
                a.this.gGF = null;
                cancel();
            }
        };
        this.gGJ.start();
    }
}
