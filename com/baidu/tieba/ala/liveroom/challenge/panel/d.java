package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.l;
import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
import com.baidu.live.r.a;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements com.baidu.live.challenge.k, k {
    private final FrameLayout coW;
    private String dlu;
    private j eRq;
    private c eRr;
    private f eRs;
    private b eRt;
    private h eRu;
    private a eRv;
    private e eRw;
    private com.baidu.live.challenge.j eRx;
    private l eRy;
    private Context mContext;
    private ViewGroup mParentView;
    private final Handler mHandler = new Handler();
    private boolean eRz = false;

    public d(Context context) {
        this.mContext = context;
        this.coW = new FrameLayout(context);
        this.coW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eRx == null || (d.this.eRx.pp() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.eRx.pp() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void cM(String str) {
        this.dlu = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.eRx = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.coW.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                pl();
                return;
            }
            biS();
            biZ();
        }
    }

    private void biS() {
        if (this.coW.getLayoutParams() == null) {
            this.mParentView.addView(this.coW, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.coW);
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.eRz) {
            this.eRz = true;
            if (this.eRw != null) {
                this.eRw.bja();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0086a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        d.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.biT();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.eRw.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biT() {
        this.eRz = false;
        if (this.eRw != null) {
            this.eRw.hide();
        }
        if (this.coW.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.coW.getParent()).removeView(this.coW);
        }
        this.mParentView = null;
        this.eRw = null;
        if (this.eRy != null) {
            this.eRy.py();
        }
    }

    public void pl() {
        if (this.eRx != null) {
            this.eRx.pl();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cR(long j) {
        if (this.eRx != null) {
            this.eRx.v(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void biU() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.eRs == null) {
            this.eRs = new f(this.mContext, this);
        }
        a(this.eRs);
        if (this.eRx != null) {
            this.eRx.pn();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void biV() {
        if (this.eRx != null) {
            this.eRx.po();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.eRt == null) {
                this.eRt = new b(this.mContext, this);
            }
            this.eRt.b(dVar);
            a(this.eRt);
            if (this.eRx != null) {
                this.eRx.t(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void s(long j) {
        if (this.eRx != null) {
            this.eRx.s(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cS(long j) {
        if (this.eRx != null) {
            this.eRx.u(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bm(int i, int i2) {
        if (this.eRx != null) {
            this.eRx.r(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void i(int i, int i2, String str) {
        if (this.eRx != null) {
            this.eRx.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void biW() {
        if (this.eRu == null) {
            this.eRu = new h(this.mContext, this);
        }
        bm(1, 30);
        a(this.eRu);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void biX() {
        if (this.eRr == null) {
            this.eRr = new c(this.mContext, this, this.dlu);
        }
        this.eRx.pm();
        a(this.eRr);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void biY() {
        if (this.eRy != null) {
            this.eRy.pv();
        }
    }

    private void biZ() {
        if (this.eRq == null) {
            this.eRq = new j(this.mContext, this);
        }
        a(this.eRq);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.coW.removeAllViews();
            if (this.eRw != null) {
                this.eRw.hide();
            }
            eVar.b(this.coW, this.eRw == null ? 0 : this.eRw.biN());
            this.eRw = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0074j
    public void pu() {
        biS();
        biX();
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0074j
    public void m(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.eRs != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.eRs.f(aVar);
        }
        if (z && aVar != null && this.eRy != null) {
            this.eRy.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void l(int i, String str) {
        if (i == 1492002) {
            biV();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.eRs != null) {
            this.eRs.f(aVar);
            if (this.eRy != null) {
                this.eRy.a(aVar);
            }
        } else if (i == 0) {
            biX();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.eRt != null) {
                this.eRt.e(aVar);
            }
            if (this.eRy != null) {
                this.eRy.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void h(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.eRw instanceof b) {
                ((b) this.eRw).biP();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.eRt != null) {
                this.eRt.e(aVar);
            }
            if (this.eRy != null) {
                this.eRy.a(aVar);
            }
        } else if (i == 100) {
            biX();
        } else if (i == 102) {
            if (!StringUtils.isNull(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
            }
        }
    }

    @Override // com.baidu.live.challenge.j.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.eRv == null) {
                this.eRv = new a(this.mContext, this);
            }
            this.eRv.d(aVar);
            a(this.eRv);
            if (this.eRy != null) {
                this.eRy.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.Vl)) {
            BdUtilHelper.showToast(this.mContext, aVar.Vl);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.j.a
    public void g(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.j.g
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.Vu) {
                d(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_challenging));
            if (this.eRu != null) {
                this.eRu.f(dVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.g
    public void j(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
        if (this.eRu != null) {
            this.eRu.bje();
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void m(List<com.baidu.live.challenge.d> list) {
        if (this.eRr == null) {
            this.eRr = new c(this.mContext, this, this.dlu);
        }
        this.eRr.bC(list);
    }

    @Override // com.baidu.live.challenge.j.f
    public void i(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.eRu != null) {
            this.eRu.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void k(int i, String str) {
        if (this.eRu != null) {
            this.eRu.as(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ac acVar, ad adVar, ad adVar2) {
        if (this.coW.getParent() != null) {
            removeView();
            if (this.eRy != null) {
                this.eRy.pw();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ac acVar, ad adVar, ad adVar2) {
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ac acVar, ad adVar, ad adVar2) {
    }

    @Override // com.baidu.live.challenge.j.c
    public void e(ac acVar, ad adVar, ad adVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void px() {
        if (this.eRy != null) {
            this.eRy.px();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void bc(int i) {
        if (this.eRq == null) {
            this.eRq = new j(this.mContext, this);
        }
        this.eRq.bc(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void be(int i) {
        this.eRx.be(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.eRy = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.eRw == null) {
            return false;
        }
        return this.eRw.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.coW.getParent() != null;
    }
}
