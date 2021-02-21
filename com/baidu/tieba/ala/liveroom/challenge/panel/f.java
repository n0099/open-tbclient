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
import com.baidu.live.data.bg;
import com.baidu.live.data.bk;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes11.dex */
public class f implements com.baidu.live.challenge.j, n {
    private final FrameLayout aiT;
    private String fuu;
    private m hwE;
    private l hwF;
    private c hwG;
    private h hwH;
    private b hwI;
    private j hwJ;
    private e hwK;
    private a hwL;
    private g hwM;
    private com.baidu.live.challenge.i hwN;
    private com.baidu.live.challenge.k hwO;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean hwP = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aiT = new FrameLayout(this.mContext);
        this.aiT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hwN == null || (f.this.hwN.AG() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.hwN.AG() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
        this.fuu = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.hwN = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.aiT.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                AC();
                return;
            }
            cdB();
            cdJ();
        }
    }

    private void cdB() {
        if (this.aiT.getLayoutParams() == null) {
            this.mParentView.addView(this.aiT, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.aiT);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.hwP) {
            this.hwP = true;
            if (this.hwM != null) {
                this.hwM.cdL();
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
                                f.this.cdC();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.hwM.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdC() {
        this.hwP = false;
        if (this.hwM != null) {
            this.hwM.hide();
        }
        if (this.aiT.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.aiT.getParent()).removeView(this.aiT);
        }
        this.mParentView = null;
        this.hwM = null;
        if (this.hwO != null) {
            this.hwO.AQ();
        }
    }

    public void AC() {
        if (this.hwN != null) {
            this.hwN.AC();
        }
    }

    public void fp(String str) {
        if (this.hwN != null) {
            this.hwN.fp(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fD(long j) {
        if (this.hwN != null) {
            this.hwN.aL(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdD() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
            return;
        }
        if (this.hwH == null) {
            this.hwH = new h(this.mContext, this);
        }
        a(this.hwH);
        if (this.hwN != null) {
            this.hwN.AE();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdE() {
        if (this.hwN != null) {
            this.hwN.AF();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.hwI == null) {
                this.hwI = new b(this.mContext, this);
            }
            this.hwI.b(dVar);
            a(this.hwI);
            if (this.hwN != null) {
                this.hwN.aJ(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void aI(long j) {
        if (this.hwN != null) {
            this.hwN.aI(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fE(long j) {
        if (this.hwN != null) {
            this.hwN.aK(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bR(int i, int i2) {
        if (this.hwN != null) {
            this.hwN.y(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void j(int i, int i2, String str) {
        if (this.hwN != null) {
            this.hwN.g(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fq(String str) {
        if (this.hwN != null) {
            this.hwN.fq(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdF() {
        if (this.hwJ == null) {
            this.hwJ = new j(this.mContext, this);
        }
        bR(1, 30);
        a(this.hwJ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdG() {
        if (this.hwK == null) {
            this.hwK = new e(this.mPageContext, this);
        }
        this.hwK.HF(this.mUserId);
        fq(this.mUserId);
        a(this.hwK);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdH() {
        if (this.hwG == null) {
            this.hwG = new c(this.mContext, this, this.fuu);
        }
        this.hwN.AD();
        a(this.hwG);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdI() {
        if (this.hwO != null) {
            this.hwO.AN();
        }
    }

    private void cdJ() {
        if (this.hwF == null) {
            this.hwF = new l(this.mContext, this);
        }
        a(this.hwF);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.aiT.removeAllViews();
            if (this.hwM != null) {
                this.hwM.hide();
            }
            gVar.b(this.aiT, this.hwM == null ? 0 : this.hwM.cdt());
            this.hwM = gVar;
        }
    }

    public void cdK() {
        if (this.hwE == null) {
            this.hwE = new m(this.mContext, this);
        }
        a(this.hwE);
    }

    @Override // com.baidu.live.challenge.i.m
    public void AM() {
        fp(this.mUserId);
    }

    @Override // com.baidu.live.challenge.i.m
    public void t(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.hwH != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.hwH.f(aVar);
        }
        if (z && aVar != null && this.hwO != null) {
            this.hwO.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void r(int i, String str) {
        if (i == 1492002) {
            cdE();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.hwH != null) {
            this.hwH.f(aVar);
            if (this.hwO != null) {
                this.hwO.a(aVar);
            }
        } else if (i == 0) {
            cdH();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.hwI != null) {
                this.hwI.e(aVar);
            }
            if (this.hwO != null) {
                this.hwO.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void n(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.hwM instanceof b) {
                ((b) this.hwM).cdu();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.hwI != null) {
                this.hwI.e(aVar);
            }
            if (this.hwO != null) {
                this.hwO.a(aVar);
            }
        } else if (i == 100) {
            cdH();
        } else if (i == 102) {
            if (!StringUtils.isNull(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
            }
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void k(boolean z, long j) {
        if (z) {
            cdB();
            cy(this.count);
            cdK();
            oc(this.canUseChallenge);
            if (this.hwE != null) {
                if (j >= 0) {
                    this.hwE.fF(j);
                    this.hwE.cdR();
                    return;
                }
                this.hwE.tv();
            }
        } else if (this.canUseChallenge) {
            cdB();
            cdH();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_can_not_use_challenge));
        }
    }

    public void oc(boolean z) {
        if (this.hwE == null) {
            this.hwE = new m(this.mContext, this);
        }
        this.hwE.br(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.hwL == null) {
                this.hwL = new a(this.mContext, this);
            }
            this.hwL.d(aVar);
            a(this.hwL);
            if (this.hwO != null) {
                this.hwO.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aFt)) {
            BdUtilHelper.showToast(this.mContext, aVar.aFt);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.a
    public void m(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.aFD) {
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
            if (this.hwM != null) {
                if (this.hwM == this.hwJ) {
                    this.hwJ.j(dVar);
                } else if (this.hwM == this.hwK) {
                    this.hwK.a(dVar, true);
                }
            }
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void p(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_request_fail));
        }
        if (this.hwM != null) {
            if (this.hwM == this.hwJ) {
                this.hwJ.cdA();
            } else if (this.hwM == this.hwK) {
                this.hwK.cdA();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.hwG == null) {
            this.hwG = new c(this.mContext, this, this.fuu);
        }
        this.hwG.cD(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void o(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0166i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.hwJ != null) {
            this.hwJ.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0166i
    public void q(int i, String str) {
        if (this.hwJ != null) {
            this.hwJ.bn(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void z(List<com.baidu.live.challenge.d> list) {
        if (this.hwK != null) {
            this.hwK.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void s(int i, String str) {
        if (this.hwK != null) {
            this.hwK.bn(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(bg bgVar, bk bkVar, bk bkVar2) {
        if (this.aiT.getParent() != null) {
            removeView();
            if (this.hwO != null) {
                this.hwO.AO();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(bg bgVar, bk bkVar, bk bkVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(bg bgVar, bk bkVar, bk bkVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(bg bgVar, bk bkVar, bk bkVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void AP() {
        if (this.hwO != null) {
            this.hwO.AP();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void br(boolean z) {
        this.canUseChallenge = z;
        oc(z);
    }

    @Override // com.baidu.live.challenge.j
    public void cy(int i) {
        if (this.hwF == null) {
            this.hwF = new l(this.mContext, this);
        }
        this.hwF.cy(i);
        this.count = i;
        if (this.hwE == null) {
            this.hwE = new m(this.mContext, this);
        }
        this.hwE.cy(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cw(int i) {
        this.hwN.cw(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.hwO = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.hwM == null) {
            return false;
        }
        return this.hwM.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.aiT.getParent() != null;
    }
}
