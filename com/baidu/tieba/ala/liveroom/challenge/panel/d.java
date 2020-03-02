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
    private final FrameLayout csY;
    private String dpD;
    private j eVi;
    private c eVj;
    private f eVk;
    private b eVl;
    private h eVm;
    private a eVn;
    private e eVo;
    private com.baidu.live.challenge.j eVp;
    private l eVq;
    private Context mContext;
    private ViewGroup mParentView;
    private final Handler mHandler = new Handler();
    private boolean eVr = false;

    public d(Context context) {
        this.mContext = context;
        this.csY = new FrameLayout(context);
        this.csY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eVp == null || (d.this.eVp.qa() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.eVp.qa() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void cV(String str) {
        this.dpD = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.eVp = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.csY.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                pW();
                return;
            }
            bkJ();
            bkQ();
        }
    }

    private void bkJ() {
        if (this.csY.getLayoutParams() == null) {
            this.mParentView.addView(this.csY, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.csY);
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.eVr) {
            this.eVr = true;
            if (this.eVo != null) {
                this.eVo.bkR();
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
                                d.this.bkK();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.eVo.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkK() {
        this.eVr = false;
        if (this.eVo != null) {
            this.eVo.hide();
        }
        if (this.csY.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.csY.getParent()).removeView(this.csY);
        }
        this.mParentView = null;
        this.eVo = null;
        if (this.eVq != null) {
            this.eVq.qj();
        }
    }

    public void pW() {
        if (this.eVp != null) {
            this.eVp.pW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cT(long j) {
        if (this.eVp != null) {
            this.eVp.w(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkL() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.eVk == null) {
            this.eVk = new f(this.mContext, this);
        }
        a(this.eVk);
        if (this.eVp != null) {
            this.eVp.pY();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkM() {
        if (this.eVp != null) {
            this.eVp.pZ();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.eVl == null) {
                this.eVl = new b(this.mContext, this);
            }
            this.eVl.b(dVar);
            a(this.eVl);
            if (this.eVp != null) {
                this.eVp.u(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void t(long j) {
        if (this.eVp != null) {
            this.eVp.t(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cU(long j) {
        if (this.eVp != null) {
            this.eVp.v(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bn(int i, int i2) {
        if (this.eVp != null) {
            this.eVp.s(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void i(int i, int i2, String str) {
        if (this.eVp != null) {
            this.eVp.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkN() {
        if (this.eVm == null) {
            this.eVm = new h(this.mContext, this);
        }
        bn(1, 30);
        a(this.eVm);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkO() {
        if (this.eVj == null) {
            this.eVj = new c(this.mContext, this, this.dpD);
        }
        this.eVp.pX();
        a(this.eVj);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkP() {
        if (this.eVq != null) {
            this.eVq.qg();
        }
    }

    private void bkQ() {
        if (this.eVi == null) {
            this.eVi = new j(this.mContext, this);
        }
        a(this.eVi);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.csY.removeAllViews();
            if (this.eVo != null) {
                this.eVo.hide();
            }
            eVar.b(this.csY, this.eVo == null ? 0 : this.eVo.bkF());
            this.eVo = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0081j
    public void qf() {
        bkJ();
        bkO();
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0081j
    public void m(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.eVk != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.eVk.f(aVar);
        }
        if (z && aVar != null && this.eVq != null) {
            this.eVq.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void l(int i, String str) {
        if (i == 1492002) {
            bkM();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.eVk != null) {
            this.eVk.f(aVar);
            if (this.eVq != null) {
                this.eVq.a(aVar);
            }
        } else if (i == 0) {
            bkO();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.eVl != null) {
                this.eVl.e(aVar);
            }
            if (this.eVq != null) {
                this.eVq.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void h(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.eVo instanceof b) {
                ((b) this.eVo).bkG();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.eVl != null) {
                this.eVl.e(aVar);
            }
            if (this.eVq != null) {
                this.eVq.a(aVar);
            }
        } else if (i == 100) {
            bkO();
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
            if (this.eVn == null) {
                this.eVn = new a(this.mContext, this);
            }
            this.eVn.d(aVar);
            a(this.eVn);
            if (this.eVq != null) {
                this.eVq.a(aVar);
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
            if (this.eVm != null) {
                this.eVm.f(dVar);
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
        if (this.eVm != null) {
            this.eVm.bkV();
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void m(List<com.baidu.live.challenge.d> list) {
        if (this.eVj == null) {
            this.eVj = new c(this.mContext, this, this.dpD);
        }
        this.eVj.bC(list);
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
        if (this.eVm != null) {
            this.eVm.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void k(int i, String str) {
        if (this.eVm != null) {
            this.eVm.au(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ad adVar, ae aeVar, ae aeVar2) {
        if (this.csY.getParent() != null) {
            removeView();
            if (this.eVq != null) {
                this.eVq.qh();
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
        if (this.eVq != null) {
            this.eVq.qi();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void bj(int i) {
        if (this.eVi == null) {
            this.eVi = new j(this.mContext, this);
        }
        this.eVi.bj(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bl(int i) {
        this.eVp.bl(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.eVq = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.eVo == null) {
            return false;
        }
        return this.eVo.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.csY.getParent() != null;
    }
}
