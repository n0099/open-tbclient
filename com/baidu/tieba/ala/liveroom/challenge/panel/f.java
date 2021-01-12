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
/* loaded from: classes10.dex */
public class f implements com.baidu.live.challenge.j, n {
    private final FrameLayout ajf;
    private String fsc;
    private m hsg;
    private l hsh;
    private c hsi;
    private h hsj;
    private b hsk;
    private j hsl;
    private e hsm;
    private a hsn;
    private g hso;
    private com.baidu.live.challenge.i hsp;
    private com.baidu.live.challenge.k hsq;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean hsr = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ajf = new FrameLayout(this.mContext);
        this.ajf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hsp == null || (f.this.hsp.zW() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.hsp.zW() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
        this.fsc = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.hsp = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.ajf.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                zS();
                return;
            }
            ccz();
            ccH();
        }
    }

    private void ccz() {
        if (this.ajf.getLayoutParams() == null) {
            this.mParentView.addView(this.ajf, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.ajf);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.hsr) {
            this.hsr = true;
            if (this.hso != null) {
                this.hso.ccJ();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0194a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.ccA();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.hso.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccA() {
        this.hsr = false;
        if (this.hso != null) {
            this.hso.hide();
        }
        if (this.ajf.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ajf.getParent()).removeView(this.ajf);
        }
        this.mParentView = null;
        this.hso = null;
        if (this.hsq != null) {
            this.hsq.Ag();
        }
    }

    public void zS() {
        if (this.hsp != null) {
            this.hsp.zS();
        }
    }

    public void eW(String str) {
        if (this.hsp != null) {
            this.hsp.eW(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fy(long j) {
        if (this.hsp != null) {
            this.hsp.aJ(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ccB() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
            return;
        }
        if (this.hsj == null) {
            this.hsj = new h(this.mContext, this);
        }
        a(this.hsj);
        if (this.hsp != null) {
            this.hsp.zU();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ccC() {
        if (this.hsp != null) {
            this.hsp.zV();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.hsk == null) {
                this.hsk = new b(this.mContext, this);
            }
            this.hsk.b(dVar);
            a(this.hsk);
            if (this.hsp != null) {
                this.hsp.aH(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void aG(long j) {
        if (this.hsp != null) {
            this.hsp.aG(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fz(long j) {
        if (this.hsp != null) {
            this.hsp.aI(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bT(int i, int i2) {
        if (this.hsp != null) {
            this.hsp.y(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void k(int i, int i2, String str) {
        if (this.hsp != null) {
            this.hsp.g(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void eX(String str) {
        if (this.hsp != null) {
            this.hsp.eX(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ccD() {
        if (this.hsl == null) {
            this.hsl = new j(this.mContext, this);
        }
        bT(1, 30);
        a(this.hsl);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ccE() {
        if (this.hsm == null) {
            this.hsm = new e(this.mPageContext, this);
        }
        this.hsm.Ha(this.mUserId);
        eX(this.mUserId);
        a(this.hsm);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ccF() {
        if (this.hsi == null) {
            this.hsi = new c(this.mContext, this, this.fsc);
        }
        this.hsp.zT();
        a(this.hsi);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ccG() {
        if (this.hsq != null) {
            this.hsq.Ad();
        }
    }

    private void ccH() {
        if (this.hsh == null) {
            this.hsh = new l(this.mContext, this);
        }
        a(this.hsh);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.ajf.removeAllViews();
            if (this.hso != null) {
                this.hso.hide();
            }
            gVar.b(this.ajf, this.hso == null ? 0 : this.hso.ccr());
            this.hso = gVar;
        }
    }

    public void ccI() {
        if (this.hsg == null) {
            this.hsg = new m(this.mContext, this);
        }
        a(this.hsg);
    }

    @Override // com.baidu.live.challenge.i.m
    public void Ac() {
        eW(this.mUserId);
    }

    @Override // com.baidu.live.challenge.i.m
    public void q(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.hsj != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.hsj.f(aVar);
        }
        if (z && aVar != null && this.hsq != null) {
            this.hsq.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void o(int i, String str) {
        if (i == 1492002) {
            ccC();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.hsj != null) {
            this.hsj.f(aVar);
            if (this.hsq != null) {
                this.hsq.a(aVar);
            }
        } else if (i == 0) {
            ccF();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.hsk != null) {
                this.hsk.e(aVar);
            }
            if (this.hsq != null) {
                this.hsq.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void k(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.hso instanceof b) {
                ((b) this.hso).ccs();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.hsk != null) {
                this.hsk.e(aVar);
            }
            if (this.hsq != null) {
                this.hsq.a(aVar);
            }
        } else if (i == 100) {
            ccF();
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
            ccz();
            cv(this.count);
            ccI();
            nR(this.canUseChallenge);
            if (this.hsg != null) {
                if (j >= 0) {
                    this.hsg.fA(j);
                    this.hsg.ccP();
                    return;
                }
                this.hsg.ty();
            }
        } else if (this.canUseChallenge) {
            ccz();
            ccF();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_can_not_use_challenge));
        }
    }

    public void nR(boolean z) {
        if (this.hsg == null) {
            this.hsg = new m(this.mContext, this);
        }
        this.hsg.bp(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.hsn == null) {
                this.hsn = new a(this.mContext, this);
            }
            this.hsn.d(aVar);
            a(this.hsn);
            if (this.hsq != null) {
                this.hsq.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aDG)) {
            BdUtilHelper.showToast(this.mContext, aVar.aDG);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.a
    public void j(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.aDQ) {
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
            if (this.hso != null) {
                if (this.hso == this.hsl) {
                    this.hsl.j(dVar);
                } else if (this.hso == this.hsm) {
                    this.hsm.a(dVar, true);
                }
            }
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void m(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_request_fail));
        }
        if (this.hso != null) {
            if (this.hso == this.hsl) {
                this.hsl.ccy();
            } else if (this.hso == this.hsm) {
                this.hsm.ccy();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.hsi == null) {
            this.hsi = new c(this.mContext, this, this.fsc);
        }
        this.hsi.cI(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void l(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0165i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.hsl != null) {
            this.hsl.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0165i
    public void n(int i, String str) {
        if (this.hsl != null) {
            this.hsl.bi(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void z(List<com.baidu.live.challenge.d> list) {
        if (this.hsm != null) {
            this.hsm.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void p(int i, String str) {
        if (this.hsm != null) {
            this.hsm.bi(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(bc bcVar, bg bgVar, bg bgVar2) {
        if (this.ajf.getParent() != null) {
            removeView();
            if (this.hsq != null) {
                this.hsq.Ae();
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
    public void Af() {
        if (this.hsq != null) {
            this.hsq.Af();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bp(boolean z) {
        this.canUseChallenge = z;
        nR(z);
    }

    @Override // com.baidu.live.challenge.j
    public void cv(int i) {
        if (this.hsh == null) {
            this.hsh = new l(this.mContext, this);
        }
        this.hsh.cv(i);
        this.count = i;
        if (this.hsg == null) {
            this.hsg = new m(this.mContext, this);
        }
        this.hsg.cv(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ct(int i) {
        this.hsp.ct(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.hsq = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.hso == null) {
            return false;
        }
        return this.hso.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.ajf.getParent() != null;
    }
}
