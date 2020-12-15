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
import com.baidu.live.data.ba;
import com.baidu.live.data.be;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.challenge.j, n {
    private final FrameLayout ajk;
    private String fnb;
    private m hkR;
    private l hkS;
    private c hkT;
    private h hkU;
    private b hkV;
    private j hkW;
    private e hkX;
    private a hkY;
    private g hkZ;
    private com.baidu.live.challenge.i hla;
    private com.baidu.live.challenge.k hlb;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean hlc = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ajk = new FrameLayout(this.mContext);
        this.ajk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hla == null || (f.this.hla.EC() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.hla.EC() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
        this.fnb = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.hla = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.ajk.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                Ey();
                return;
            }
            cdA();
            cdI();
        }
    }

    private void cdA() {
        if (this.ajk.getLayoutParams() == null) {
            this.mParentView.addView(this.ajk, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.ajk);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.hlc) {
            this.hlc = true;
            if (this.hkZ != null) {
                this.hkZ.cdK();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0205a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.cdB();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.hkZ.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdB() {
        this.hlc = false;
        if (this.hkZ != null) {
            this.hkZ.hide();
        }
        if (this.ajk.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ajk.getParent()).removeView(this.ajk);
        }
        this.mParentView = null;
        this.hkZ = null;
        if (this.hlb != null) {
            this.hlb.EM();
        }
    }

    public void Ey() {
        if (this.hla != null) {
            this.hla.Ey();
        }
    }

    public void gy(String str) {
        if (this.hla != null) {
            this.hla.gy(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fy(long j) {
        if (this.hla != null) {
            this.hla.aK(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdC() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
            return;
        }
        if (this.hkU == null) {
            this.hkU = new h(this.mContext, this);
        }
        a(this.hkU);
        if (this.hla != null) {
            this.hla.EA();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdD() {
        if (this.hla != null) {
            this.hla.EB();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.hkV == null) {
                this.hkV = new b(this.mContext, this);
            }
            this.hkV.b(dVar);
            a(this.hkV);
            if (this.hla != null) {
                this.hla.aI(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void aH(long j) {
        if (this.hla != null) {
            this.hla.aH(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fz(long j) {
        if (this.hla != null) {
            this.hla.aJ(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bU(int i, int i2) {
        if (this.hla != null) {
            this.hla.y(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void k(int i, int i2, String str) {
        if (this.hla != null) {
            this.hla.g(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void gz(String str) {
        if (this.hla != null) {
            this.hla.gz(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdE() {
        if (this.hkW == null) {
            this.hkW = new j(this.mContext, this);
        }
        bU(1, 30);
        a(this.hkW);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdF() {
        if (this.hkX == null) {
            this.hkX = new e(this.mPageContext, this);
        }
        this.hkX.Ik(this.mUserId);
        gz(this.mUserId);
        a(this.hkX);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdG() {
        if (this.hkT == null) {
            this.hkT = new c(this.mContext, this, this.fnb);
        }
        this.hla.Ez();
        a(this.hkT);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdH() {
        if (this.hlb != null) {
            this.hlb.EJ();
        }
    }

    private void cdI() {
        if (this.hkS == null) {
            this.hkS = new l(this.mContext, this);
        }
        a(this.hkS);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.ajk.removeAllViews();
            if (this.hkZ != null) {
                this.hkZ.hide();
            }
            gVar.b(this.ajk, this.hkZ == null ? 0 : this.hkZ.cds());
            this.hkZ = gVar;
        }
    }

    public void cdJ() {
        if (this.hkR == null) {
            this.hkR = new m(this.mContext, this);
        }
        a(this.hkR);
    }

    @Override // com.baidu.live.challenge.i.m
    public void EI() {
        gy(this.mUserId);
    }

    @Override // com.baidu.live.challenge.i.m
    public void p(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.hkU != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.hkU.f(aVar);
        }
        if (z && aVar != null && this.hlb != null) {
            this.hlb.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void n(int i, String str) {
        if (i == 1492002) {
            cdD();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.hkU != null) {
            this.hkU.f(aVar);
            if (this.hlb != null) {
                this.hlb.a(aVar);
            }
        } else if (i == 0) {
            cdG();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.hkV != null) {
                this.hkV.e(aVar);
            }
            if (this.hlb != null) {
                this.hlb.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void j(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.hkZ instanceof b) {
                ((b) this.hkZ).cdt();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.hkV != null) {
                this.hkV.e(aVar);
            }
            if (this.hlb != null) {
                this.hlb.a(aVar);
            }
        } else if (i == 100) {
            cdG();
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
            cdA();
            ee(this.count);
            cdJ();
            nv(this.canUseChallenge);
            if (this.hkR != null) {
                if (j >= 0) {
                    this.hkR.fA(j);
                    this.hkR.cdQ();
                    return;
                }
                this.hkR.uk();
            }
        } else if (this.canUseChallenge) {
            cdA();
            cdG();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_can_not_use_challenge));
        }
    }

    public void nv(boolean z) {
        if (this.hkR == null) {
            this.hkR = new m(this.mContext, this);
        }
        this.hkR.bw(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.hkY == null) {
                this.hkY = new a(this.mContext, this);
            }
            this.hkY.d(aVar);
            a(this.hkY);
            if (this.hlb != null) {
                this.hlb.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aHX)) {
            BdUtilHelper.showToast(this.mContext, aVar.aHX);
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
            if (dVar.aIh) {
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
            if (this.hkZ != null) {
                if (this.hkZ == this.hkW) {
                    this.hkW.j(dVar);
                } else if (this.hkZ == this.hkX) {
                    this.hkX.a(dVar, true);
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
        if (this.hkZ != null) {
            if (this.hkZ == this.hkW) {
                this.hkW.cdz();
            } else if (this.hkZ == this.hkX) {
                this.hkX.cdz();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.hkT == null) {
            this.hkT = new c(this.mContext, this, this.fnb);
        }
        this.hkT.cB(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void k(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0180i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.hkW != null) {
            this.hkW.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0180i
    public void m(int i, String str) {
        if (this.hkW != null) {
            this.hkW.bf(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void z(List<com.baidu.live.challenge.d> list) {
        if (this.hkX != null) {
            this.hkX.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void o(int i, String str) {
        if (this.hkX != null) {
            this.hkX.bf(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(ba baVar, be beVar, be beVar2) {
        if (this.ajk.getParent() != null) {
            removeView();
            if (this.hlb != null) {
                this.hlb.EK();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(ba baVar, be beVar, be beVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(ba baVar, be beVar, be beVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(ba baVar, be beVar, be beVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void EL() {
        if (this.hlb != null) {
            this.hlb.EL();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bw(boolean z) {
        this.canUseChallenge = z;
        nv(z);
    }

    @Override // com.baidu.live.challenge.j
    public void ee(int i) {
        if (this.hkS == null) {
            this.hkS = new l(this.mContext, this);
        }
        this.hkS.ee(i);
        this.count = i;
        if (this.hkR == null) {
            this.hkR = new m(this.mContext, this);
        }
        this.hkR.ee(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ec(int i) {
        this.hla.ec(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.hlb = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.hkZ == null) {
            return false;
        }
        return this.hkZ.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.ajk.getParent() != null;
    }
}
