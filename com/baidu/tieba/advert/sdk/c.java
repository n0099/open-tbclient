package com.baidu.tieba.advert.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.h.a;
import com.baidu.tieba.view.BesAdViewContainer;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class c implements com.baidu.tieba.advert.sdk.b.b {
    private WeakReference<ViewGroup> gma;
    private ViewGroup gmh;
    private AdLoadState gmb = AdLoadState.INIT;
    private com.baidu.tbadk.g.a gmi = null;
    private final a.c gmj = new a.d() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.tieba.h.a.d, com.baidu.tieba.h.a.c
        public void onAdClose(String str) {
            TiebaStatic.log(new ar("c12946").aq("obj_source", 6).aq("obj_type", 1));
            if (c.this.gmi != null) {
                c.this.gmi.onAdDismiss();
            }
        }

        @Override // com.baidu.tieba.h.a.d, com.baidu.tieba.h.a.c
        public void onAdShow(String str) {
            c.this.gmi.e(false, false, 6);
            TiebaStatic.log(new ar("c14006").aq("obj_source", 6).dR("obj_type", "a064").aq("obj_locate", 0));
        }

        @Override // com.baidu.tieba.h.a.d, com.baidu.tieba.h.a.c
        public void onAdError(String str) {
            TiebaStatic.log(new ar("c14006").aq("obj_source", 6).dR("obj_type", "a064").aq("obj_locate", 1));
            if (c.this.gmi != null) {
                c.this.gmi.onAdDismiss();
            }
        }

        @Override // com.baidu.tieba.h.a.d, com.baidu.tieba.h.a.c
        public void onAdClicked(String str) {
            if (c.this.gmi != null) {
                c.this.gmi.f(false, false, 6);
            }
        }
    };

    @Override // com.baidu.tieba.advert.sdk.b.b
    public AdLoadState bMz() {
        return this.gmb;
    }

    @Override // com.baidu.tieba.advert.sdk.b.b
    public String bMA() {
        return "bear";
    }

    @Override // com.baidu.tieba.advert.sdk.b.b
    public void a(com.baidu.tbadk.g.c cVar) {
        Context context = cVar.bks().getContext();
        if ((context instanceof Activity) && cVar.bks() != null) {
            this.gma = new WeakReference<>(cVar.bks());
            this.gmh = com.baidu.tieba.h.a.cNx().g((Activity) context, "6021001000-1366583569");
            if (this.gmh != null) {
                this.gmi = cVar.bkt();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(context), (int) (l.getEquipmentHeight(this.gma.get().getContext()) * 0.8125d));
                layoutParams.addRule(14, -1);
                this.gma.get().addView(this.gmh, layoutParams);
                com.baidu.tieba.h.a.cNx().a((Activity) context, "6021001000-1366583569", new a.b() { // from class: com.baidu.tieba.advert.sdk.c.2
                    @Override // com.baidu.tieba.h.a.b
                    public void aE(String str, int i) {
                        ar.Bk("c14005").aq("obj_source", 6).dR("obj_type", "a064").aq("obj_locate", 0).bsR();
                        if (com.baidu.tieba.h.a.cNx().isAdReady(str)) {
                            c.this.gmb = AdLoadState.SUCCEED;
                        } else {
                            c.this.gmb = AdLoadState.FAILED;
                            ((ViewGroup) c.this.gma.get()).removeView(c.this.gmh);
                        }
                        com.baidu.tieba.advert.sdk.b.a.bMI().b(c.this.gmi);
                    }

                    @Override // com.baidu.tieba.h.a.b
                    public void onError(String str) {
                        ar.Bk("c14005").aq("obj_source", 6).dR("obj_type", "a064").aq("obj_locate", 1).bsR();
                        c.this.gmb = AdLoadState.FAILED;
                        ((ViewGroup) c.this.gma.get()).removeView(c.this.gmh);
                        com.baidu.tieba.advert.sdk.b.a.bMI().b(c.this.gmi);
                    }
                });
                this.gmb = AdLoadState.LOADING;
            }
        }
    }

    public boolean bMC() {
        if (this.gmh == null || this.gma.get() == null) {
            return false;
        }
        Context context = this.gma.get().getContext();
        if (context instanceof Activity) {
            if (this.gma.get() instanceof BesAdViewContainer) {
                ((BesAdViewContainer) this.gma.get()).setEnableClick(false);
            }
            com.baidu.tbadk.core.d.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
            com.baidu.tieba.h.a.cNx().a((Activity) context, "6021001000-1366583569", this.gmh, this.gmj);
            ap.setBackgroundColor(this.gmh, R.color.CAM_X0101, 0);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.advert.sdk.b.b
    public void show() {
        if (this.gma != null && this.gmb == AdLoadState.SUCCEED) {
            bMB();
            this.gmb = AdLoadState.SHOWED;
            bMC();
        }
    }

    private void bMB() {
        if (this.gma != null && this.gma.get().getParent() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gma.get().getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(this.gma.get().getContext());
            layoutParams.height = (int) (l.getEquipmentHeight(this.gma.get().getContext()) * 0.8125d);
            this.gma.get().setLayoutParams(layoutParams);
        }
    }
}
