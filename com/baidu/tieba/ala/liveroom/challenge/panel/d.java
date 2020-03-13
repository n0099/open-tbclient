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
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements com.baidu.live.challenge.k, k {
    private final FrameLayout csZ;
    private String dpQ;
    private a eVA;
    private e eVB;
    private com.baidu.live.challenge.j eVC;
    private l eVD;
    private j eVv;
    private c eVw;
    private f eVx;
    private b eVy;
    private h eVz;
    private Context mContext;
    private ViewGroup mParentView;
    private final Handler mHandler = new Handler();
    private boolean eVE = false;

    public d(Context context) {
        this.mContext = context;
        this.csZ = new FrameLayout(context);
        this.csZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eVC == null || (d.this.eVC.qa() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.eVC.qa() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void cV(String str) {
        this.dpQ = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.eVC = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.csZ.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                pW();
                return;
            }
            bkK();
            bkR();
        }
    }

    private void bkK() {
        if (this.csZ.getLayoutParams() == null) {
            this.mParentView.addView(this.csZ, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.csZ);
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.eVE) {
            this.eVE = true;
            if (this.eVB != null) {
                this.eVB.bkS();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0102a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        d.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.bkL();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.eVB.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkL() {
        this.eVE = false;
        if (this.eVB != null) {
            this.eVB.hide();
        }
        if (this.csZ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.csZ.getParent()).removeView(this.csZ);
        }
        this.mParentView = null;
        this.eVB = null;
        if (this.eVD != null) {
            this.eVD.qj();
        }
    }

    public void pW() {
        if (this.eVC != null) {
            this.eVC.pW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cT(long j) {
        if (this.eVC != null) {
            this.eVC.w(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkM() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.eVx == null) {
            this.eVx = new f(this.mContext, this);
        }
        a(this.eVx);
        if (this.eVC != null) {
            this.eVC.pY();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkN() {
        if (this.eVC != null) {
            this.eVC.pZ();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.eVy == null) {
                this.eVy = new b(this.mContext, this);
            }
            this.eVy.b(dVar);
            a(this.eVy);
            if (this.eVC != null) {
                this.eVC.u(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void t(long j) {
        if (this.eVC != null) {
            this.eVC.t(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cU(long j) {
        if (this.eVC != null) {
            this.eVC.v(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bn(int i, int i2) {
        if (this.eVC != null) {
            this.eVC.s(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void i(int i, int i2, String str) {
        if (this.eVC != null) {
            this.eVC.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkO() {
        if (this.eVz == null) {
            this.eVz = new h(this.mContext, this);
        }
        bn(1, 30);
        a(this.eVz);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkP() {
        if (this.eVw == null) {
            this.eVw = new c(this.mContext, this, this.dpQ);
        }
        this.eVC.pX();
        a(this.eVw);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkQ() {
        if (this.eVD != null) {
            this.eVD.qg();
        }
    }

    private void bkR() {
        if (this.eVv == null) {
            this.eVv = new j(this.mContext, this);
        }
        a(this.eVv);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.csZ.removeAllViews();
            if (this.eVB != null) {
                this.eVB.hide();
            }
            eVar.b(this.csZ, this.eVB == null ? 0 : this.eVB.bkG());
            this.eVB = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0081j
    public void qf() {
        bkK();
        bkP();
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0081j
    public void m(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.eVx != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.eVx.f(aVar);
        }
        if (z && aVar != null && this.eVD != null) {
            this.eVD.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void l(int i, String str) {
        if (i == 1492002) {
            bkN();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.eVx != null) {
            this.eVx.f(aVar);
            if (this.eVD != null) {
                this.eVD.a(aVar);
            }
        } else if (i == 0) {
            bkP();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.eVy != null) {
                this.eVy.e(aVar);
            }
            if (this.eVD != null) {
                this.eVD.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void h(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.eVB instanceof b) {
                ((b) this.eVB).bkH();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.eVy != null) {
                this.eVy.e(aVar);
            }
            if (this.eVD != null) {
                this.eVD.a(aVar);
            }
        } else if (i == 100) {
            bkP();
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
            if (this.eVA == null) {
                this.eVA = new a(this.mContext, this);
            }
            this.eVA.d(aVar);
            a(this.eVA);
            if (this.eVD != null) {
                this.eVD.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.WR)) {
            BdUtilHelper.showToast(this.mContext, aVar.WR);
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
            if (dVar.Xa) {
                d(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_challenging));
            if (this.eVz != null) {
                this.eVz.f(dVar);
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
        if (this.eVz != null) {
            this.eVz.bkW();
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void m(List<com.baidu.live.challenge.d> list) {
        if (this.eVw == null) {
            this.eVw = new c(this.mContext, this, this.dpQ);
        }
        this.eVw.bC(list);
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
        if (this.eVz != null) {
            this.eVz.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void k(int i, String str) {
        if (this.eVz != null) {
            this.eVz.au(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ad adVar, ae aeVar, ae aeVar2) {
        if (this.csZ.getParent() != null) {
            removeView();
            if (this.eVD != null) {
                this.eVD.qh();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ad adVar, ae aeVar, ae aeVar2) {
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ad adVar, ae aeVar, ae aeVar2) {
    }

    @Override // com.baidu.live.challenge.j.c
    public void e(ad adVar, ae aeVar, ae aeVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void qi() {
        if (this.eVD != null) {
            this.eVD.qi();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void bj(int i) {
        if (this.eVv == null) {
            this.eVv = new j(this.mContext, this);
        }
        this.eVv.bj(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bl(int i) {
        this.eVC.bl(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.eVD = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.eVB == null) {
            return false;
        }
        return this.eVB.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.csZ.getParent() != null;
    }
}
