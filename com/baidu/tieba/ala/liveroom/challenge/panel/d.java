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
    private final FrameLayout ctk;
    private String dqd;
    private j eVT;
    private c eVU;
    private f eVV;
    private b eVW;
    private h eVX;
    private a eVY;
    private e eVZ;
    private com.baidu.live.challenge.j eWa;
    private l eWb;
    private Context mContext;
    private ViewGroup mParentView;
    private final Handler mHandler = new Handler();
    private boolean eWc = false;

    public d(Context context) {
        this.mContext = context;
        this.ctk = new FrameLayout(context);
        this.ctk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eWa == null || (d.this.eWa.qf() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.eWa.qf() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void cU(String str) {
        this.dqd = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.eWa = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.ctk.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                qb();
                return;
            }
            bkP();
            bkW();
        }
    }

    private void bkP() {
        if (this.ctk.getLayoutParams() == null) {
            this.mParentView.addView(this.ctk, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.ctk);
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.eWc) {
            this.eWc = true;
            if (this.eVZ != null) {
                this.eVZ.bkX();
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
                                d.this.bkQ();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.eVZ.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkQ() {
        this.eWc = false;
        if (this.eVZ != null) {
            this.eVZ.hide();
        }
        if (this.ctk.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ctk.getParent()).removeView(this.ctk);
        }
        this.mParentView = null;
        this.eVZ = null;
        if (this.eWb != null) {
            this.eWb.qo();
        }
    }

    public void qb() {
        if (this.eWa != null) {
            this.eWa.qb();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cT(long j) {
        if (this.eWa != null) {
            this.eWa.w(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkR() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.eVV == null) {
            this.eVV = new f(this.mContext, this);
        }
        a(this.eVV);
        if (this.eWa != null) {
            this.eWa.qd();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkS() {
        if (this.eWa != null) {
            this.eWa.qe();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.eVW == null) {
                this.eVW = new b(this.mContext, this);
            }
            this.eVW.b(dVar);
            a(this.eVW);
            if (this.eWa != null) {
                this.eWa.u(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void t(long j) {
        if (this.eWa != null) {
            this.eWa.t(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cU(long j) {
        if (this.eWa != null) {
            this.eWa.v(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bo(int i, int i2) {
        if (this.eWa != null) {
            this.eWa.s(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void i(int i, int i2, String str) {
        if (this.eWa != null) {
            this.eWa.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkT() {
        if (this.eVX == null) {
            this.eVX = new h(this.mContext, this);
        }
        bo(1, 30);
        a(this.eVX);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkU() {
        if (this.eVU == null) {
            this.eVU = new c(this.mContext, this, this.dqd);
        }
        this.eWa.qc();
        a(this.eVU);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bkV() {
        if (this.eWb != null) {
            this.eWb.ql();
        }
    }

    private void bkW() {
        if (this.eVT == null) {
            this.eVT = new j(this.mContext, this);
        }
        a(this.eVT);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.ctk.removeAllViews();
            if (this.eVZ != null) {
                this.eVZ.hide();
            }
            eVar.b(this.ctk, this.eVZ == null ? 0 : this.eVZ.bkL());
            this.eVZ = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0081j
    public void qk() {
        bkP();
        bkU();
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0081j
    public void m(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.eVV != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.eVV.f(aVar);
        }
        if (z && aVar != null && this.eWb != null) {
            this.eWb.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void l(int i, String str) {
        if (i == 1492002) {
            bkS();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.eVV != null) {
            this.eVV.f(aVar);
            if (this.eWb != null) {
                this.eWb.a(aVar);
            }
        } else if (i == 0) {
            bkU();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.eVW != null) {
                this.eVW.e(aVar);
            }
            if (this.eWb != null) {
                this.eWb.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void h(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.eVZ instanceof b) {
                ((b) this.eVZ).bkM();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.eVW != null) {
                this.eVW.e(aVar);
            }
            if (this.eWb != null) {
                this.eWb.a(aVar);
            }
        } else if (i == 100) {
            bkU();
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
            if (this.eVY == null) {
                this.eVY = new a(this.mContext, this);
            }
            this.eVY.d(aVar);
            a(this.eVY);
            if (this.eWb != null) {
                this.eWb.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.Xb)) {
            BdUtilHelper.showToast(this.mContext, aVar.Xb);
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
            if (dVar.Xk) {
                d(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_challenging));
            if (this.eVX != null) {
                this.eVX.f(dVar);
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
        if (this.eVX != null) {
            this.eVX.blb();
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void m(List<com.baidu.live.challenge.d> list) {
        if (this.eVU == null) {
            this.eVU = new c(this.mContext, this, this.dqd);
        }
        this.eVU.bC(list);
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
        if (this.eVX != null) {
            this.eVX.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void k(int i, String str) {
        if (this.eVX != null) {
            this.eVX.au(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ad adVar, ae aeVar, ae aeVar2) {
        if (this.ctk.getParent() != null) {
            removeView();
            if (this.eWb != null) {
                this.eWb.qm();
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
    public void qn() {
        if (this.eWb != null) {
            this.eWb.qn();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void bj(int i) {
        if (this.eVT == null) {
            this.eVT = new j(this.mContext, this);
        }
        this.eVT.bj(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bl(int i) {
        this.eWa.bl(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.eWb = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.eVZ == null) {
            return false;
        }
        return this.eVZ.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.ctk.getParent() != null;
    }
}
