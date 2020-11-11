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
import com.baidu.live.data.az;
import com.baidu.live.data.bd;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.challenge.j, n {
    private final FrameLayout aii;
    private String fgt;
    private l hbA;
    private c hbB;
    private h hbC;
    private b hbD;
    private j hbE;
    private e hbF;
    private a hbG;
    private g hbH;
    private com.baidu.live.challenge.i hbI;
    private com.baidu.live.challenge.k hbJ;
    private m hbz;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean hbK = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aii = new FrameLayout(this.mContext);
        this.aii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hbI == null || (f.this.hbI.DB() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.hbI.DB() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    f.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.j
    public void setUserId(String str) {
        this.mUserId = str;
    }

    @Override // com.baidu.live.challenge.j
    public void setUserPortrait(String str) {
        this.fgt = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.hbI = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.aii.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                Dx();
                return;
            }
            cal();
            cat();
        }
    }

    private void cal() {
        if (this.aii.getLayoutParams() == null) {
            this.mParentView.addView(this.aii, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.aii);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.hbK) {
            this.hbK = true;
            if (this.hbH != null) {
                this.hbH.cav();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0197a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.cam();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.hbH.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cam() {
        this.hbK = false;
        if (this.hbH != null) {
            this.hbH.hide();
        }
        if (this.aii.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.aii.getParent()).removeView(this.aii);
        }
        this.mParentView = null;
        this.hbH = null;
        if (this.hbJ != null) {
            this.hbJ.DL();
        }
    }

    public void Dx() {
        if (this.hbI != null) {
            this.hbI.Dx();
        }
    }

    public void gi(String str) {
        if (this.hbI != null) {
            this.hbI.gi(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void eU(long j) {
        if (this.hbI != null) {
            this.hbI.am(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void can() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
            return;
        }
        if (this.hbC == null) {
            this.hbC = new h(this.mContext, this);
        }
        a(this.hbC);
        if (this.hbI != null) {
            this.hbI.Dz();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cao() {
        if (this.hbI != null) {
            this.hbI.DA();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.hbD == null) {
                this.hbD = new b(this.mContext, this);
            }
            this.hbD.b(dVar);
            a(this.hbD);
            if (this.hbI != null) {
                this.hbI.ak(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void aj(long j) {
        if (this.hbI != null) {
            this.hbI.aj(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void eV(long j) {
        if (this.hbI != null) {
            this.hbI.al(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bQ(int i, int i2) {
        if (this.hbI != null) {
            this.hbI.w(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void k(int i, int i2, String str) {
        if (this.hbI != null) {
            this.hbI.g(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void gj(String str) {
        if (this.hbI != null) {
            this.hbI.gj(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cap() {
        if (this.hbE == null) {
            this.hbE = new j(this.mContext, this);
        }
        bQ(1, 30);
        a(this.hbE);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void caq() {
        if (this.hbF == null) {
            this.hbF = new e(this.mPageContext, this);
        }
        this.hbF.HU(this.mUserId);
        gj(this.mUserId);
        a(this.hbF);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void car() {
        if (this.hbB == null) {
            this.hbB = new c(this.mContext, this, this.fgt);
        }
        this.hbI.Dy();
        a(this.hbB);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cas() {
        if (this.hbJ != null) {
            this.hbJ.DI();
        }
    }

    private void cat() {
        if (this.hbA == null) {
            this.hbA = new l(this.mContext, this);
        }
        a(this.hbA);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.aii.removeAllViews();
            if (this.hbH != null) {
                this.hbH.hide();
            }
            gVar.b(this.aii, this.hbH == null ? 0 : this.hbH.cad());
            this.hbH = gVar;
        }
    }

    public void cau() {
        if (this.hbz == null) {
            this.hbz = new m(this.mContext, this);
        }
        a(this.hbz);
    }

    @Override // com.baidu.live.challenge.i.m
    public void DH() {
        gi(this.mUserId);
    }

    @Override // com.baidu.live.challenge.i.m
    public void p(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.hbC != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.hbC.f(aVar);
        }
        if (z && aVar != null && this.hbJ != null) {
            this.hbJ.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void n(int i, String str) {
        if (i == 1492002) {
            cao();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.hbC != null) {
            this.hbC.f(aVar);
            if (this.hbJ != null) {
                this.hbJ.a(aVar);
            }
        } else if (i == 0) {
            car();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.hbD != null) {
                this.hbD.e(aVar);
            }
            if (this.hbJ != null) {
                this.hbJ.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void j(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.hbH instanceof b) {
                ((b) this.hbH).cae();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.hbD != null) {
                this.hbD.e(aVar);
            }
            if (this.hbJ != null) {
                this.hbJ.a(aVar);
            }
        } else if (i == 100) {
            car();
        } else if (i == 102) {
            if (!StringUtils.isNull(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
            }
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void d(boolean z, long j) {
        if (z) {
            cal();
            dP(this.count);
            cau();
            mZ(this.canUseChallenge);
            if (this.hbz != null) {
                if (j >= 0) {
                    this.hbz.eW(j);
                    this.hbz.caB();
                    return;
                }
                this.hbz.uh();
            }
        } else if (this.canUseChallenge) {
            cal();
            car();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_can_not_use_challenge));
        }
    }

    public void mZ(boolean z) {
        if (this.hbz == null) {
            this.hbz = new m(this.mContext, this);
        }
        this.hbz.bm(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.hbG == null) {
                this.hbG = new a(this.mContext, this);
            }
            this.hbG.d(aVar);
            a(this.hbG);
            if (this.hbJ != null) {
                this.hbJ.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aHa)) {
            BdUtilHelper.showToast(this.mContext, aVar.aHa);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.a
    public void i(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.aHk) {
                h(dVar);
                return;
            }
            if (dVar.liveStatus == 2) {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_host_challenging));
            } else if (dVar.liveStatus == 1) {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_host_pking));
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_host_offline));
            }
            if (this.hbH != null) {
                if (this.hbH == this.hbE) {
                    this.hbE.j(dVar);
                } else if (this.hbH == this.hbF) {
                    this.hbF.a(dVar, true);
                }
            }
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void l(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_request_fail));
        }
        if (this.hbH != null) {
            if (this.hbH == this.hbE) {
                this.hbE.cak();
            } else if (this.hbH == this.hbF) {
                this.hbF.cak();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void x(List<com.baidu.live.challenge.d> list) {
        if (this.hbB == null) {
            this.hbB = new c(this.mContext, this, this.fgt);
        }
        this.hbB.cx(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void k(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0177i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.hbE != null) {
            this.hbE.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0177i
    public void m(int i, String str) {
        if (this.hbE != null) {
            this.hbE.bh(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.hbF != null) {
            this.hbF.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void o(int i, String str) {
        if (this.hbF != null) {
            this.hbF.bh(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(az azVar, bd bdVar, bd bdVar2) {
        if (this.aii.getParent() != null) {
            removeView();
            if (this.hbJ != null) {
                this.hbJ.DJ();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(az azVar, bd bdVar, bd bdVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(az azVar, bd bdVar, bd bdVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(az azVar, bd bdVar, bd bdVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void DK() {
        if (this.hbJ != null) {
            this.hbJ.DK();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bm(boolean z) {
        this.canUseChallenge = z;
        mZ(z);
    }

    @Override // com.baidu.live.challenge.j
    public void dP(int i) {
        if (this.hbA == null) {
            this.hbA = new l(this.mContext, this);
        }
        this.hbA.dP(i);
        this.count = i;
        if (this.hbz == null) {
            this.hbz = new m(this.mContext, this);
        }
        this.hbz.dP(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void dN(int i) {
        this.hbI.dN(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.hbJ = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.hbH == null) {
            return false;
        }
        return this.hbH.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.aii.getParent() != null;
    }
}
