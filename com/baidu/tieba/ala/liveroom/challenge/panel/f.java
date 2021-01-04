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
import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes11.dex */
public class f implements com.baidu.live.challenge.j, n {
    private final FrameLayout ajW;
    private String fwL;
    private m hwM;
    private l hwN;
    private c hwO;
    private h hwP;
    private b hwQ;
    private j hwR;
    private e hwS;
    private a hwT;
    private g hwU;
    private com.baidu.live.challenge.i hwV;
    private com.baidu.live.challenge.k hwW;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean hwX = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ajW = new FrameLayout(this.mContext);
        this.ajW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hwV == null || (f.this.hwV.DR() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.hwV.DR() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
        this.fwL = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.hwV = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.ajW.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                DN();
                return;
            }
            cgq();
            cgy();
        }
    }

    private void cgq() {
        if (this.ajW.getLayoutParams() == null) {
            this.mParentView.addView(this.ajW, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.ajW);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.hwX) {
            this.hwX = true;
            if (this.hwU != null) {
                this.hwU.cgA();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0203a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.cgr();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.hwU.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgr() {
        this.hwX = false;
        if (this.hwU != null) {
            this.hwU.hide();
        }
        if (this.ajW.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ajW.getParent()).removeView(this.ajW);
        }
        this.mParentView = null;
        this.hwU = null;
        if (this.hwW != null) {
            this.hwW.Eb();
        }
    }

    public void DN() {
        if (this.hwV != null) {
            this.hwV.DN();
        }
    }

    public void gh(String str) {
        if (this.hwV != null) {
            this.hwV.gh(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fy(long j) {
        if (this.hwV != null) {
            this.hwV.aJ(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cgs() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
            return;
        }
        if (this.hwP == null) {
            this.hwP = new h(this.mContext, this);
        }
        a(this.hwP);
        if (this.hwV != null) {
            this.hwV.DP();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cgt() {
        if (this.hwV != null) {
            this.hwV.DQ();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.hwQ == null) {
                this.hwQ = new b(this.mContext, this);
            }
            this.hwQ.b(dVar);
            a(this.hwQ);
            if (this.hwV != null) {
                this.hwV.aH(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void aG(long j) {
        if (this.hwV != null) {
            this.hwV.aG(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fz(long j) {
        if (this.hwV != null) {
            this.hwV.aI(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bT(int i, int i2) {
        if (this.hwV != null) {
            this.hwV.y(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void k(int i, int i2, String str) {
        if (this.hwV != null) {
            this.hwV.g(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void gi(String str) {
        if (this.hwV != null) {
            this.hwV.gi(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cgu() {
        if (this.hwR == null) {
            this.hwR = new j(this.mContext, this);
        }
        bT(1, 30);
        a(this.hwR);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cgv() {
        if (this.hwS == null) {
            this.hwS = new e(this.mPageContext, this);
        }
        this.hwS.Im(this.mUserId);
        gi(this.mUserId);
        a(this.hwS);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cgw() {
        if (this.hwO == null) {
            this.hwO = new c(this.mContext, this, this.fwL);
        }
        this.hwV.DO();
        a(this.hwO);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cgx() {
        if (this.hwW != null) {
            this.hwW.DY();
        }
    }

    private void cgy() {
        if (this.hwN == null) {
            this.hwN = new l(this.mContext, this);
        }
        a(this.hwN);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.ajW.removeAllViews();
            if (this.hwU != null) {
                this.hwU.hide();
            }
            gVar.b(this.ajW, this.hwU == null ? 0 : this.hwU.cgi());
            this.hwU = gVar;
        }
    }

    public void cgz() {
        if (this.hwM == null) {
            this.hwM = new m(this.mContext, this);
        }
        a(this.hwM);
    }

    @Override // com.baidu.live.challenge.i.m
    public void DX() {
        gh(this.mUserId);
    }

    @Override // com.baidu.live.challenge.i.m
    public void p(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.hwP != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.hwP.f(aVar);
        }
        if (z && aVar != null && this.hwW != null) {
            this.hwW.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void n(int i, String str) {
        if (i == 1492002) {
            cgt();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.hwP != null) {
            this.hwP.f(aVar);
            if (this.hwW != null) {
                this.hwW.a(aVar);
            }
        } else if (i == 0) {
            cgw();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.hwQ != null) {
                this.hwQ.e(aVar);
            }
            if (this.hwW != null) {
                this.hwW.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void j(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.hwU instanceof b) {
                ((b) this.hwU).cgj();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.hwQ != null) {
                this.hwQ.e(aVar);
            }
            if (this.hwW != null) {
                this.hwW.a(aVar);
            }
        } else if (i == 100) {
            cgw();
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
            cgq();
            eb(this.count);
            cgz();
            nV(this.canUseChallenge);
            if (this.hwM != null) {
                if (j >= 0) {
                    this.hwM.fA(j);
                    this.hwM.cgG();
                    return;
                }
                this.hwM.tJ();
            }
        } else if (this.canUseChallenge) {
            cgq();
            cgw();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_can_not_use_challenge));
        }
    }

    public void nV(boolean z) {
        if (this.hwM == null) {
            this.hwM = new m(this.mContext, this);
        }
        this.hwM.bt(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.hwT == null) {
                this.hwT = new a(this.mContext, this);
            }
            this.hwT.d(aVar);
            a(this.hwT);
            if (this.hwW != null) {
                this.hwW.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aIt)) {
            BdUtilHelper.showToast(this.mContext, aVar.aIt);
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
            if (dVar.aID) {
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
            if (this.hwU != null) {
                if (this.hwU == this.hwR) {
                    this.hwR.j(dVar);
                } else if (this.hwU == this.hwS) {
                    this.hwS.a(dVar, true);
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
        if (this.hwU != null) {
            if (this.hwU == this.hwR) {
                this.hwR.cgp();
            } else if (this.hwU == this.hwS) {
                this.hwS.cgp();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.hwO == null) {
            this.hwO = new c(this.mContext, this, this.fwL);
        }
        this.hwO.cI(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void k(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0174i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.hwR != null) {
            this.hwR.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0174i
    public void m(int i, String str) {
        if (this.hwR != null) {
            this.hwR.bh(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void z(List<com.baidu.live.challenge.d> list) {
        if (this.hwS != null) {
            this.hwS.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void o(int i, String str) {
        if (this.hwS != null) {
            this.hwS.bh(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(bc bcVar, bg bgVar, bg bgVar2) {
        if (this.ajW.getParent() != null) {
            removeView();
            if (this.hwW != null) {
                this.hwW.DZ();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(bc bcVar, bg bgVar, bg bgVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(bc bcVar, bg bgVar, bg bgVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(bc bcVar, bg bgVar, bg bgVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void Ea() {
        if (this.hwW != null) {
            this.hwW.Ea();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bt(boolean z) {
        this.canUseChallenge = z;
        nV(z);
    }

    @Override // com.baidu.live.challenge.j
    public void eb(int i) {
        if (this.hwN == null) {
            this.hwN = new l(this.mContext, this);
        }
        this.hwN.eb(i);
        this.count = i;
        if (this.hwM == null) {
            this.hwM = new m(this.mContext, this);
        }
        this.hwM.eb(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void dZ(int i) {
        this.hwV.dZ(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.hwW = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.hwU == null) {
            return false;
        }
        return this.hwU.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.ajW.getParent() != null;
    }
}
