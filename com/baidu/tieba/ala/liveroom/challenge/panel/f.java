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
    private m hkP;
    private l hkQ;
    private c hkR;
    private h hkS;
    private b hkT;
    private j hkU;
    private e hkV;
    private a hkW;
    private g hkX;
    private com.baidu.live.challenge.i hkY;
    private com.baidu.live.challenge.k hkZ;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean hla = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ajk = new FrameLayout(this.mContext);
        this.ajk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hkY == null || (f.this.hkY.EC() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.hkY.EC() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
        this.hkY = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.ajk.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                Ey();
                return;
            }
            cdz();
            cdH();
        }
    }

    private void cdz() {
        if (this.ajk.getLayoutParams() == null) {
            this.mParentView.addView(this.ajk, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.ajk);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.hla) {
            this.hla = true;
            if (this.hkX != null) {
                this.hkX.cdJ();
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
                                f.this.cdA();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.hkX.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdA() {
        this.hla = false;
        if (this.hkX != null) {
            this.hkX.hide();
        }
        if (this.ajk.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ajk.getParent()).removeView(this.ajk);
        }
        this.mParentView = null;
        this.hkX = null;
        if (this.hkZ != null) {
            this.hkZ.EM();
        }
    }

    public void Ey() {
        if (this.hkY != null) {
            this.hkY.Ey();
        }
    }

    public void gy(String str) {
        if (this.hkY != null) {
            this.hkY.gy(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fy(long j) {
        if (this.hkY != null) {
            this.hkY.aK(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdB() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
            return;
        }
        if (this.hkS == null) {
            this.hkS = new h(this.mContext, this);
        }
        a(this.hkS);
        if (this.hkY != null) {
            this.hkY.EA();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdC() {
        if (this.hkY != null) {
            this.hkY.EB();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.hkT == null) {
                this.hkT = new b(this.mContext, this);
            }
            this.hkT.b(dVar);
            a(this.hkT);
            if (this.hkY != null) {
                this.hkY.aI(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void aH(long j) {
        if (this.hkY != null) {
            this.hkY.aH(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fz(long j) {
        if (this.hkY != null) {
            this.hkY.aJ(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bU(int i, int i2) {
        if (this.hkY != null) {
            this.hkY.y(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void k(int i, int i2, String str) {
        if (this.hkY != null) {
            this.hkY.g(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void gz(String str) {
        if (this.hkY != null) {
            this.hkY.gz(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdD() {
        if (this.hkU == null) {
            this.hkU = new j(this.mContext, this);
        }
        bU(1, 30);
        a(this.hkU);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdE() {
        if (this.hkV == null) {
            this.hkV = new e(this.mPageContext, this);
        }
        this.hkV.Ik(this.mUserId);
        gz(this.mUserId);
        a(this.hkV);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdF() {
        if (this.hkR == null) {
            this.hkR = new c(this.mContext, this, this.fnb);
        }
        this.hkY.Ez();
        a(this.hkR);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdG() {
        if (this.hkZ != null) {
            this.hkZ.EJ();
        }
    }

    private void cdH() {
        if (this.hkQ == null) {
            this.hkQ = new l(this.mContext, this);
        }
        a(this.hkQ);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.ajk.removeAllViews();
            if (this.hkX != null) {
                this.hkX.hide();
            }
            gVar.b(this.ajk, this.hkX == null ? 0 : this.hkX.cdr());
            this.hkX = gVar;
        }
    }

    public void cdI() {
        if (this.hkP == null) {
            this.hkP = new m(this.mContext, this);
        }
        a(this.hkP);
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
        if (this.hkS != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.hkS.f(aVar);
        }
        if (z && aVar != null && this.hkZ != null) {
            this.hkZ.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void n(int i, String str) {
        if (i == 1492002) {
            cdC();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.hkS != null) {
            this.hkS.f(aVar);
            if (this.hkZ != null) {
                this.hkZ.a(aVar);
            }
        } else if (i == 0) {
            cdF();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.hkT != null) {
                this.hkT.e(aVar);
            }
            if (this.hkZ != null) {
                this.hkZ.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void j(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.hkX instanceof b) {
                ((b) this.hkX).cds();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.hkT != null) {
                this.hkT.e(aVar);
            }
            if (this.hkZ != null) {
                this.hkZ.a(aVar);
            }
        } else if (i == 100) {
            cdF();
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
            cdz();
            ee(this.count);
            cdI();
            nv(this.canUseChallenge);
            if (this.hkP != null) {
                if (j >= 0) {
                    this.hkP.fA(j);
                    this.hkP.cdP();
                    return;
                }
                this.hkP.uk();
            }
        } else if (this.canUseChallenge) {
            cdz();
            cdF();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_can_not_use_challenge));
        }
    }

    public void nv(boolean z) {
        if (this.hkP == null) {
            this.hkP = new m(this.mContext, this);
        }
        this.hkP.bw(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.hkW == null) {
                this.hkW = new a(this.mContext, this);
            }
            this.hkW.d(aVar);
            a(this.hkW);
            if (this.hkZ != null) {
                this.hkZ.a(aVar);
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
            if (this.hkX != null) {
                if (this.hkX == this.hkU) {
                    this.hkU.j(dVar);
                } else if (this.hkX == this.hkV) {
                    this.hkV.a(dVar, true);
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
        if (this.hkX != null) {
            if (this.hkX == this.hkU) {
                this.hkU.cdy();
            } else if (this.hkX == this.hkV) {
                this.hkV.cdy();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.hkR == null) {
            this.hkR = new c(this.mContext, this, this.fnb);
        }
        this.hkR.cB(list);
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
        if (this.hkU != null) {
            this.hkU.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0180i
    public void m(int i, String str) {
        if (this.hkU != null) {
            this.hkU.bf(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void z(List<com.baidu.live.challenge.d> list) {
        if (this.hkV != null) {
            this.hkV.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void o(int i, String str) {
        if (this.hkV != null) {
            this.hkV.bf(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(ba baVar, be beVar, be beVar2) {
        if (this.ajk.getParent() != null) {
            removeView();
            if (this.hkZ != null) {
                this.hkZ.EK();
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
        if (this.hkZ != null) {
            this.hkZ.EL();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bw(boolean z) {
        this.canUseChallenge = z;
        nv(z);
    }

    @Override // com.baidu.live.challenge.j
    public void ee(int i) {
        if (this.hkQ == null) {
            this.hkQ = new l(this.mContext, this);
        }
        this.hkQ.ee(i);
        this.count = i;
        if (this.hkP == null) {
            this.hkP = new m(this.mContext, this);
        }
        this.hkP.ee(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ec(int i) {
        this.hkY.ec(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.hkZ = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.hkX == null) {
            return false;
        }
        return this.hkX.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.ajk.getParent() != null;
    }
}
