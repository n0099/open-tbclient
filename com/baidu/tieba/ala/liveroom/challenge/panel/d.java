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
    private j fOA;
    private c fOB;
    private f fOC;
    private b fOD;
    private h fOE;
    private a fOF;
    private e fOG;
    private com.baidu.live.challenge.j fOH;
    private l fOI;
    private Context mContext;
    private ViewGroup mParentView;
    private final Handler mHandler = new Handler();
    private boolean fOJ = false;

    public d(Context context) {
        this.mContext = context;
        this.ddl = new FrameLayout(context);
        this.ddl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fOH == null || (d.this.fOH.vC() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.fOH.vC() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
        this.fOH = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.ddl.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                vy();
                return;
            }
            bAh();
            bAo();
        }
    }

    private void bAh() {
        if (this.ddl.getLayoutParams() == null) {
            this.mParentView.addView(this.ddl, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.ddl);
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.fOJ) {
            this.fOJ = true;
            if (this.fOG != null) {
                this.fOG.bAp();
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
                                d.this.bAi();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.fOG.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAi() {
        this.fOJ = false;
        if (this.fOG != null) {
            this.fOG.hide();
        }
        if (this.ddl.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ddl.getParent()).removeView(this.ddl);
        }
        this.mParentView = null;
        this.fOG = null;
        if (this.fOI != null) {
            this.fOI.vL();
        }
    }

    public void vy() {
        if (this.fOH != null) {
            this.fOH.vy();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void dC(long j) {
        if (this.fOH != null) {
            this.fOH.Y(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bAj() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.fOC == null) {
            this.fOC = new f(this.mContext, this);
        }
        a(this.fOC);
        if (this.fOH != null) {
            this.fOH.vA();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bAk() {
        if (this.fOH != null) {
            this.fOH.vB();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.fOD == null) {
                this.fOD = new b(this.mContext, this);
            }
            this.fOD.b(dVar);
            a(this.fOD);
            if (this.fOH != null) {
                this.fOH.W(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void V(long j) {
        if (this.fOH != null) {
            this.fOH.V(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void dD(long j) {
        if (this.fOH != null) {
            this.fOH.X(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bx(int i, int i2) {
        if (this.fOH != null) {
            this.fOH.r(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void i(int i, int i2, String str) {
        if (this.fOH != null) {
            this.fOH.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bAl() {
        if (this.fOE == null) {
            this.fOE = new h(this.mContext, this);
        }
        bx(1, 30);
        a(this.fOE);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bAm() {
        if (this.fOB == null) {
            this.fOB = new c(this.mContext, this, this.eev);
        }
        this.fOH.vz();
        a(this.fOB);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bAn() {
        if (this.fOI != null) {
            this.fOI.vI();
        }
    }

    private void bAo() {
        if (this.fOA == null) {
            this.fOA = new j(this.mContext, this);
        }
        a(this.fOA);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.ddl.removeAllViews();
            if (this.fOG != null) {
                this.fOG.hide();
            }
            eVar.b(this.ddl, this.fOG == null ? 0 : this.fOG.bAd());
            this.fOG = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0157j
    public void vH() {
        bAh();
        bAm();
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0157j
    public void l(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.fOC != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.fOC.f(aVar);
        }
        if (z && aVar != null && this.fOI != null) {
            this.fOI.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void k(int i, String str) {
        if (i == 1492002) {
            bAk();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.fOC != null) {
            this.fOC.f(aVar);
            if (this.fOI != null) {
                this.fOI.a(aVar);
            }
        } else if (i == 0) {
            bAm();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.fOD != null) {
                this.fOD.e(aVar);
            }
            if (this.fOI != null) {
                this.fOI.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void g(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.fOG instanceof b) {
                ((b) this.fOG).bAe();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.fOD != null) {
                this.fOD.e(aVar);
            }
            if (this.fOI != null) {
                this.fOI.a(aVar);
            }
        } else if (i == 100) {
            bAm();
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
            if (this.fOF == null) {
                this.fOF = new a(this.mContext, this);
            }
            this.fOF.d(aVar);
            a(this.fOF);
            if (this.fOI != null) {
                this.fOI.a(aVar);
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
            if (this.fOE != null) {
                this.fOE.f(dVar);
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
        if (this.fOE != null) {
            this.fOE.bAt();
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void p(List<com.baidu.live.challenge.d> list) {
        if (this.fOB == null) {
            this.fOB = new c(this.mContext, this, this.eev);
        }
        this.fOB.bI(list);
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
        if (this.fOE != null) {
            this.fOE.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void j(int i, String str) {
        if (this.fOE != null) {
            this.fOE.aO(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ak akVar, al alVar, al alVar2) {
        if (this.ddl.getParent() != null) {
            removeView();
            if (this.fOI != null) {
                this.fOI.vJ();
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
        if (this.fOI != null) {
            this.fOI.vK();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void bF(int i) {
        if (this.fOA == null) {
            this.fOA = new j(this.mContext, this);
        }
        this.fOA.bF(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bH(int i) {
        this.fOH.bH(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.fOI = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.fOG == null) {
            return false;
        }
        return this.fOG.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.ddl.getParent() != null;
    }
}
