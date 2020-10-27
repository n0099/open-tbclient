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
import com.baidu.live.data.ax;
import com.baidu.live.data.bb;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.challenge.j, n {
    private final FrameLayout aii;
    private String faC;
    private j gVA;
    private e gVB;
    private a gVC;
    private g gVD;
    private com.baidu.live.challenge.i gVE;
    private com.baidu.live.challenge.k gVF;
    private m gVv;
    private l gVw;
    private c gVx;
    private h gVy;
    private b gVz;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean gVG = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aii = new FrameLayout(this.mContext);
        this.aii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gVE == null || (f.this.gVE.Di() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.gVE.Di() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
    public void gf(String str) {
        this.faC = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.gVE = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.aii.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                De();
                return;
            }
            bXJ();
            bXR();
        }
    }

    private void bXJ() {
        if (this.aii.getLayoutParams() == null) {
            this.mParentView.addView(this.aii, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.aii);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.gVG) {
            this.gVG = true;
            if (this.gVD != null) {
                this.gVD.bXT();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0195a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.bXK();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.gVD.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXK() {
        this.gVG = false;
        if (this.gVD != null) {
            this.gVD.hide();
        }
        if (this.aii.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.aii.getParent()).removeView(this.aii);
        }
        this.mParentView = null;
        this.gVD = null;
        if (this.gVF != null) {
            this.gVF.Ds();
        }
    }

    public void De() {
        if (this.gVE != null) {
            this.gVE.De();
        }
    }

    public void gd(String str) {
        if (this.gVE != null) {
            this.gVE.gd(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ey(long j) {
        if (this.gVE != null) {
            this.gVE.aa(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bXL() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.gVy == null) {
            this.gVy = new h(this.mContext, this);
        }
        a(this.gVy);
        if (this.gVE != null) {
            this.gVE.Dg();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bXM() {
        if (this.gVE != null) {
            this.gVE.Dh();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.gVz == null) {
                this.gVz = new b(this.mContext, this);
            }
            this.gVz.b(dVar);
            a(this.gVz);
            if (this.gVE != null) {
                this.gVE.Y(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void X(long j) {
        if (this.gVE != null) {
            this.gVE.X(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ez(long j) {
        if (this.gVE != null) {
            this.gVE.Z(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bO(int i, int i2) {
        if (this.gVE != null) {
            this.gVE.w(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void k(int i, int i2, String str) {
        if (this.gVE != null) {
            this.gVE.g(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ge(String str) {
        if (this.gVE != null) {
            this.gVE.ge(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bXN() {
        if (this.gVA == null) {
            this.gVA = new j(this.mContext, this);
        }
        bO(1, 30);
        a(this.gVA);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bXO() {
        if (this.gVB == null) {
            this.gVB = new e(this.mPageContext, this);
        }
        this.gVB.HC(this.mUserId);
        ge(this.mUserId);
        a(this.gVB);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bXP() {
        if (this.gVx == null) {
            this.gVx = new c(this.mContext, this, this.faC);
        }
        this.gVE.Df();
        a(this.gVx);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bXQ() {
        if (this.gVF != null) {
            this.gVF.Dp();
        }
    }

    private void bXR() {
        if (this.gVw == null) {
            this.gVw = new l(this.mContext, this);
        }
        a(this.gVw);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.aii.removeAllViews();
            if (this.gVD != null) {
                this.gVD.hide();
            }
            gVar.b(this.aii, this.gVD == null ? 0 : this.gVD.bXB());
            this.gVD = gVar;
        }
    }

    public void bXS() {
        if (this.gVv == null) {
            this.gVv = new m(this.mContext, this);
        }
        a(this.gVv);
    }

    @Override // com.baidu.live.challenge.i.m
    public void Do() {
        gd(this.mUserId);
    }

    @Override // com.baidu.live.challenge.i.m
    public void p(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.gVy != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.gVy.f(aVar);
        }
        if (z && aVar != null && this.gVF != null) {
            this.gVF.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void n(int i, String str) {
        if (i == 1492002) {
            bXM();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.gVy != null) {
            this.gVy.f(aVar);
            if (this.gVF != null) {
                this.gVF.a(aVar);
            }
        } else if (i == 0) {
            bXP();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.gVz != null) {
                this.gVz.e(aVar);
            }
            if (this.gVF != null) {
                this.gVF.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void j(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.gVD instanceof b) {
                ((b) this.gVD).bXC();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.gVz != null) {
                this.gVz.e(aVar);
            }
            if (this.gVF != null) {
                this.gVF.a(aVar);
            }
        } else if (i == 100) {
            bXP();
        } else if (i == 102) {
            if (!StringUtils.isNull(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
            }
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void d(boolean z, long j) {
        if (z) {
            bXJ();
            dP(this.count);
            bXS();
            mQ(this.canUseChallenge);
            if (this.gVv != null) {
                if (j >= 0) {
                    this.gVv.eA(j);
                    this.gVv.bXZ();
                    return;
                }
                this.gVv.uh();
            }
        } else if (this.canUseChallenge) {
            bXJ();
            bXP();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.sdk_can_not_use_challenge));
        }
    }

    public void mQ(boolean z) {
        if (this.gVv == null) {
            this.gVv = new m(this.mContext, this);
        }
        this.gVv.bl(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.gVC == null) {
                this.gVC = new a(this.mContext, this);
            }
            this.gVC.d(aVar);
            a(this.gVC);
            if (this.gVF != null) {
                this.gVF.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aGk)) {
            BdUtilHelper.showToast(this.mContext, aVar.aGk);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.a
    public void i(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.aGu) {
                h(dVar);
                return;
            }
            if (dVar.liveStatus == 2) {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_challenging));
            } else if (dVar.liveStatus == 1) {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_pking));
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_offline));
            }
            if (this.gVD != null) {
                if (this.gVD == this.gVA) {
                    this.gVA.j(dVar);
                } else if (this.gVD == this.gVB) {
                    this.gVB.a(dVar, true);
                }
            }
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void l(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
        if (this.gVD != null) {
            if (this.gVD == this.gVA) {
                this.gVA.bXI();
            } else if (this.gVD == this.gVB) {
                this.gVB.bXI();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void x(List<com.baidu.live.challenge.d> list) {
        if (this.gVx == null) {
            this.gVx = new c(this.mContext, this, this.faC);
        }
        this.gVx.cp(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void k(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0175i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.gVA != null) {
            this.gVA.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0175i
    public void m(int i, String str) {
        if (this.gVA != null) {
            this.gVA.bd(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.gVB != null) {
            this.gVB.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void o(int i, String str) {
        if (this.gVB != null) {
            this.gVB.bd(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(ax axVar, bb bbVar, bb bbVar2) {
        if (this.aii.getParent() != null) {
            removeView();
            if (this.gVF != null) {
                this.gVF.Dq();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(ax axVar, bb bbVar, bb bbVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(ax axVar, bb bbVar, bb bbVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(ax axVar, bb bbVar, bb bbVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void Dr() {
        if (this.gVF != null) {
            this.gVF.Dr();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bl(boolean z) {
        this.canUseChallenge = z;
        mQ(z);
    }

    @Override // com.baidu.live.challenge.j
    public void dP(int i) {
        if (this.gVw == null) {
            this.gVw = new l(this.mContext, this);
        }
        this.gVw.dP(i);
        this.count = i;
        if (this.gVv == null) {
            this.gVv = new m(this.mContext, this);
        }
        this.gVv.dP(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void dN(int i) {
        this.gVE.dN(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.gVF = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.gVD == null) {
            return false;
        }
        return this.gVD.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.aii.getParent() != null;
    }
}
