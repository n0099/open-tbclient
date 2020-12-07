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
    private PendantParentView gEi;
    private PendantChildView gEj;
    private AlaAirDropView gGD;
    public boolean gGE;
    public boolean gGF;
    CountDownTimer gGH;
    private boolean gGG = false;
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
    public CustomMessageListener gGI = new CustomMessageListener(2913274) { // from class: com.baidu.tieba.ala.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null) {
                a.this.gGG = false;
            } else {
                a.this.gGG = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
            if (a.this.gGG && a.this.gGD != null && a.this.gGD.isShowing() && a.this.aFN.url.contains("needReloadDangle=1")) {
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
            this.gEi = (PendantParentView) viewGroup;
            bUj();
        }
    }

    @Override // com.baidu.live.a.a
    public void a(w wVar) {
        if (wVar == null || wVar.mLiveInfo == null) {
            if (this.gEj != null) {
                this.gEj.setVisibility(8);
                return;
            }
            return;
        }
        this.aFN = wVar;
        if (this.aFN.aKz && this.gGD == null) {
            this.gGD = new AlaAirDropView(this.gEj.getContext());
            MessageManager.getInstance().registerListener(this.gGI);
            fd(this.aFN.countDown * 1000);
            x(this.aFN);
            if (this.gEj != null && this.gEj.indexOfChild(this.gGD) < 0) {
                if (this.gGE || this.gGF) {
                    this.gEj.addView(this.gGD.getView(), new ViewGroup.LayoutParams(this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds122), this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds136)));
                } else {
                    this.gEj.addView(this.gGD.getView(), new ViewGroup.LayoutParams(this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds360), this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds740)));
                }
                this.gEj.bringChildToFront(this.gGD);
            }
        }
    }

    public void x(w wVar) {
        if (wVar.aKz) {
            if (wVar.url == null) {
                this.gGD.getView().setVisibility(8);
                return;
            }
            this.aJj = com.baidu.live.utils.b.a(1, wVar.url, this.aFN.isHost, String.valueOf(this.aFN.aKr.userId), String.valueOf(this.aFN.aJV.userId), String.valueOf(this.aFN.mLiveInfo.room_id), String.valueOf(this.aFN.mLiveInfo.live_id), "debug=1");
            com.baidu.live.view.web.g gVar = new com.baidu.live.view.web.g();
            gVar.x(this.bAn.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.ala.d.a.1
                @Override // com.baidu.live.view.web.f
                public void fr(int i) {
                }
            }).a(this.gGD.getWebView().getSchemeCallback()).b(this.bRm);
            com.baidu.live.view.web.a[] YO = gVar.YO();
            for (com.baidu.live.view.web.a aVar : YO) {
                this.gGD.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.gGD.getWebView().loadUrl(this.aJj);
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
        this.gGE = z;
    }

    @Override // com.baidu.live.a.a
    public void be(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (this.gGD != null && this.gGD.getView() != null && (layoutParams = this.gGD.getView().getLayoutParams()) != null) {
            if (z) {
                layoutParams.width = this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds122);
                layoutParams.height = this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds136);
            } else {
                layoutParams.width = this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds360);
                layoutParams.height = this.bAn.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds740);
            }
            this.gGD.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.a.a
    public void bf(boolean z) {
        this.gGF = z;
    }

    @Override // com.baidu.live.a.a
    public void setCanVisible(boolean z) {
        if (this.gEj != null) {
            if (z) {
                this.gEj.setVisibility(0);
            } else {
                this.gEj.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(boolean z) {
        if (this.gGD != null && (this.gGD.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gGD.getParent()).removeView(this.gGD);
        }
        if (z && this.gEj != null && (this.gEj.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gEj.getParent()).removeView(this.gEj);
        }
        MessageManager.getInstance().unRegisterListener(this.gGI);
    }

    private void bUj() {
        if (this.gEj == null) {
            this.gEj = new PendantChildView(this.bAn.getPageActivity()) { // from class: com.baidu.tieba.ala.d.a.3
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
            if (this.gEi != null) {
                this.gEi.a(this.gEj, new LinearLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void fd(long j) {
        this.gGH = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.d.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.lY(false);
                a.this.gGD = null;
                cancel();
            }
        };
        this.gGH.start();
    }
}
