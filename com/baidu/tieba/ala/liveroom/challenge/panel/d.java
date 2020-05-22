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
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements com.baidu.live.challenge.k, k {
    private final FrameLayout ddl;
    private String eev;
    private j fOp;
    private c fOq;
    private f fOr;
    private b fOs;
    private h fOt;
    private a fOu;
    private e fOv;
    private com.baidu.live.challenge.j fOw;
    private l fOx;
    private Context mContext;
    private ViewGroup mParentView;
    private final Handler mHandler = new Handler();
    private boolean fOy = false;

    public d(Context context) {
        this.mContext = context;
        this.ddl = new FrameLayout(context);
        this.ddl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fOw == null || (d.this.fOw.vC() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.fOw.vC() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void eo(String str) {
        this.eev = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.fOw = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.ddl.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                vy();
                return;
            }
            bAf();
            bAm();
        }
    }

    private void bAf() {
        if (this.ddl.getLayoutParams() == null) {
            this.mParentView.addView(this.ddl, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.ddl);
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.fOy) {
            this.fOy = true;
            if (this.fOv != null) {
                this.fOv.bAn();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0182a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        d.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.bAg();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.fOv.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAg() {
        this.fOy = false;
        if (this.fOv != null) {
            this.fOv.hide();
        }
        if (this.ddl.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ddl.getParent()).removeView(this.ddl);
        }
        this.mParentView = null;
        this.fOv = null;
        if (this.fOx != null) {
            this.fOx.vL();
        }
    }

    public void vy() {
        if (this.fOw != null) {
            this.fOw.vy();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void dC(long j) {
        if (this.fOw != null) {
            this.fOw.Y(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bAh() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.fOr == null) {
            this.fOr = new f(this.mContext, this);
        }
        a(this.fOr);
        if (this.fOw != null) {
            this.fOw.vA();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bAi() {
        if (this.fOw != null) {
            this.fOw.vB();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.fOs == null) {
                this.fOs = new b(this.mContext, this);
            }
            this.fOs.b(dVar);
            a(this.fOs);
            if (this.fOw != null) {
                this.fOw.W(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void V(long j) {
        if (this.fOw != null) {
            this.fOw.V(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void dD(long j) {
        if (this.fOw != null) {
            this.fOw.X(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bx(int i, int i2) {
        if (this.fOw != null) {
            this.fOw.r(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void i(int i, int i2, String str) {
        if (this.fOw != null) {
            this.fOw.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bAj() {
        if (this.fOt == null) {
            this.fOt = new h(this.mContext, this);
        }
        bx(1, 30);
        a(this.fOt);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bAk() {
        if (this.fOq == null) {
            this.fOq = new c(this.mContext, this, this.eev);
        }
        this.fOw.vz();
        a(this.fOq);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bAl() {
        if (this.fOx != null) {
            this.fOx.vI();
        }
    }

    private void bAm() {
        if (this.fOp == null) {
            this.fOp = new j(this.mContext, this);
        }
        a(this.fOp);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.ddl.removeAllViews();
            if (this.fOv != null) {
                this.fOv.hide();
            }
            eVar.b(this.ddl, this.fOv == null ? 0 : this.fOv.bAb());
            this.fOv = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0157j
    public void vH() {
        bAf();
        bAk();
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0157j
    public void l(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.fOr != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.fOr.f(aVar);
        }
        if (z && aVar != null && this.fOx != null) {
            this.fOx.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void k(int i, String str) {
        if (i == 1492002) {
            bAi();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.fOr != null) {
            this.fOr.f(aVar);
            if (this.fOx != null) {
                this.fOx.a(aVar);
            }
        } else if (i == 0) {
            bAk();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.fOs != null) {
                this.fOs.e(aVar);
            }
            if (this.fOx != null) {
                this.fOx.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void g(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.fOv instanceof b) {
                ((b) this.fOv).bAc();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.fOs != null) {
                this.fOs.e(aVar);
            }
            if (this.fOx != null) {
                this.fOx.a(aVar);
            }
        } else if (i == 100) {
            bAk();
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
            if (this.fOu == null) {
                this.fOu = new a(this.mContext, this);
            }
            this.fOu.d(aVar);
            a(this.fOu);
            if (this.fOx != null) {
                this.fOx.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aud)) {
            BdUtilHelper.showToast(this.mContext, aVar.aud);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.j.a
    public void f(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.j.g
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.aum) {
                d(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_challenging));
            if (this.fOt != null) {
                this.fOt.f(dVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.g
    public void i(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
        if (this.fOt != null) {
            this.fOt.bAr();
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void p(List<com.baidu.live.challenge.d> list) {
        if (this.fOq == null) {
            this.fOq = new c(this.mContext, this, this.eev);
        }
        this.fOq.bI(list);
    }

    @Override // com.baidu.live.challenge.j.f
    public void h(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.fOt != null) {
            this.fOt.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void j(int i, String str) {
        if (this.fOt != null) {
            this.fOt.aO(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ak akVar, al alVar, al alVar2) {
        if (this.ddl.getParent() != null) {
            removeView();
            if (this.fOx != null) {
                this.fOx.vJ();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ak akVar, al alVar, al alVar2) {
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ak akVar, al alVar, al alVar2) {
    }

    @Override // com.baidu.live.challenge.j.c
    public void e(ak akVar, al alVar, al alVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void vK() {
        if (this.fOx != null) {
            this.fOx.vK();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void bD(int i) {
        if (this.fOp == null) {
            this.fOp = new j(this.mContext, this);
        }
        this.fOp.bD(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bF(int i) {
        this.fOw.bF(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.fOx = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.fOv == null) {
            return false;
        }
        return this.fOv.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.ddl.getParent() != null;
    }
}
