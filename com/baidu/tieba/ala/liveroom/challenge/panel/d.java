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
    private final FrameLayout csX;
    private String dpC;
    private j eVh;
    private c eVi;
    private f eVj;
    private b eVk;
    private h eVl;
    private a eVm;
    private e eVn;
    private com.baidu.live.challenge.j eVo;
    private l eVp;
    private Context mContext;
    private ViewGroup mParentView;
    private final Handler mHandler = new Handler();
    private boolean eVq = false;

    public d(Context context) {
        this.mContext = context;
        this.csX = new FrameLayout(context);
        this.csX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eVo == null || (d.this.eVo.qa() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.eVo.qa() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void cV(String str) {
        this.dpC = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.eVo = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.csX.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                pW();
                return;
            }
            bkH();
            bkO();
        }
    }

    private void bkH() {
        if (this.csX.getLayoutParams() == null) {
            this.mParentView.addView(this.csX, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.csX);
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.eVq) {
            this.eVq = true;
            if (this.eVn != null) {
                this.eVn.bkP();
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
                                d.this.bkI();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.eVn.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkI() {
        this.eVq = false;
        if (this.eVn != null) {
            this.eVn.hide();
        }
        if (this.csX.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.csX.getParent()).removeView(this.csX);
        }
        this.mParentView = null;
        this.eVn = null;
        if (this.eVp != null) {
            this.eVp.qj();
        }
    }

    public void pW() {
        if (this.eVo != null) {
            this.eVo.pW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cT(long j) {
        if (this.eVo != null) {
            this.eVo.w(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkJ() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.eVj == null) {
            this.eVj = new f(this.mContext, this);
        }
        a(this.eVj);
        if (this.eVo != null) {
            this.eVo.pY();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkK() {
        if (this.eVo != null) {
            this.eVo.pZ();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.eVk == null) {
                this.eVk = new b(this.mContext, this);
            }
            this.eVk.b(dVar);
            a(this.eVk);
            if (this.eVo != null) {
                this.eVo.u(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void t(long j) {
        if (this.eVo != null) {
            this.eVo.t(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cU(long j) {
        if (this.eVo != null) {
            this.eVo.v(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bn(int i, int i2) {
        if (this.eVo != null) {
            this.eVo.s(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void i(int i, int i2, String str) {
        if (this.eVo != null) {
            this.eVo.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkL() {
        if (this.eVl == null) {
            this.eVl = new h(this.mContext, this);
        }
        bn(1, 30);
        a(this.eVl);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkM() {
        if (this.eVi == null) {
            this.eVi = new c(this.mContext, this, this.dpC);
        }
        this.eVo.pX();
        a(this.eVi);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkN() {
        if (this.eVp != null) {
            this.eVp.qg();
        }
    }

    private void bkO() {
        if (this.eVh == null) {
            this.eVh = new j(this.mContext, this);
        }
        a(this.eVh);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.csX.removeAllViews();
            if (this.eVn != null) {
                this.eVn.hide();
            }
            eVar.b(this.csX, this.eVn == null ? 0 : this.eVn.bkD());
            this.eVn = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0081j
    public void qf() {
        bkH();
        bkM();
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0081j
    public void m(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.eVj != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.eVj.f(aVar);
        }
        if (z && aVar != null && this.eVp != null) {
            this.eVp.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void l(int i, String str) {
        if (i == 1492002) {
            bkK();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.eVj != null) {
            this.eVj.f(aVar);
            if (this.eVp != null) {
                this.eVp.a(aVar);
            }
        } else if (i == 0) {
            bkM();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.eVk != null) {
                this.eVk.e(aVar);
            }
            if (this.eVp != null) {
                this.eVp.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void h(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.eVn instanceof b) {
                ((b) this.eVn).bkE();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.eVk != null) {
                this.eVk.e(aVar);
            }
            if (this.eVp != null) {
                this.eVp.a(aVar);
            }
        } else if (i == 100) {
            bkM();
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
            if (this.eVm == null) {
                this.eVm = new a(this.mContext, this);
            }
            this.eVm.d(aVar);
            a(this.eVm);
            if (this.eVp != null) {
                this.eVp.a(aVar);
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
            if (this.eVl != null) {
                this.eVl.f(dVar);
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
        if (this.eVl != null) {
            this.eVl.bkT();
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void m(List<com.baidu.live.challenge.d> list) {
        if (this.eVi == null) {
            this.eVi = new c(this.mContext, this, this.dpC);
        }
        this.eVi.bC(list);
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
        if (this.eVl != null) {
            this.eVl.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void k(int i, String str) {
        if (this.eVl != null) {
            this.eVl.au(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ad adVar, ae aeVar, ae aeVar2) {
        if (this.csX.getParent() != null) {
            removeView();
            if (this.eVp != null) {
                this.eVp.qh();
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
        if (this.eVp != null) {
            this.eVp.qi();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void bj(int i) {
        if (this.eVh == null) {
            this.eVh = new j(this.mContext, this);
        }
        this.eVh.bj(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bl(int i) {
        this.eVo.bl(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.eVp = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.eVn == null) {
            return false;
        }
        return this.eVn.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.csX.getParent() != null;
    }
}
