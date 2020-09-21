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
import com.baidu.live.data.au;
import com.baidu.live.data.ay;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.challenge.j, n {
    private final FrameLayout ahP;
    private String eFZ;
    private m gvl;
    private l gvm;
    private c gvn;
    private h gvo;
    private b gvp;
    private j gvq;
    private e gvr;
    private a gvs;
    private g gvt;
    private com.baidu.live.challenge.i gvu;
    private com.baidu.live.challenge.k gvv;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean gvw = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ahP = new FrameLayout(this.mContext);
        this.ahP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gvu == null || (f.this.gvu.Ce() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.gvu.Ce() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
    public void fQ(String str) {
        this.eFZ = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.gvu = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.ahP.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                Ca();
                return;
            }
            bRq();
            bRy();
        }
    }

    private void bRq() {
        if (this.ahP.getLayoutParams() == null) {
            this.mParentView.addView(this.ahP, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.ahP);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.gvw) {
            this.gvw = true;
            if (this.gvt != null) {
                this.gvt.bRA();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0186a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.bRr();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.gvt.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRr() {
        this.gvw = false;
        if (this.gvt != null) {
            this.gvt.hide();
        }
        if (this.ahP.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ahP.getParent()).removeView(this.ahP);
        }
        this.mParentView = null;
        this.gvt = null;
        if (this.gvv != null) {
            this.gvv.Co();
        }
    }

    public void Ca() {
        if (this.gvu != null) {
            this.gvu.Ca();
        }
    }

    public void fO(String str) {
        if (this.gvu != null) {
            this.gvu.fO(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void eg(long j) {
        if (this.gvu != null) {
            this.gvu.Y(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bRs() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.gvo == null) {
            this.gvo = new h(this.mContext, this);
        }
        a(this.gvo);
        if (this.gvu != null) {
            this.gvu.Cc();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bRt() {
        if (this.gvu != null) {
            this.gvu.Cd();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.gvp == null) {
                this.gvp = new b(this.mContext, this);
            }
            this.gvp.b(dVar);
            a(this.gvp);
            if (this.gvu != null) {
                this.gvu.W(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void V(long j) {
        if (this.gvu != null) {
            this.gvu.V(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void eh(long j) {
        if (this.gvu != null) {
            this.gvu.X(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bM(int i, int i2) {
        if (this.gvu != null) {
            this.gvu.w(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void i(int i, int i2, String str) {
        if (this.gvu != null) {
            this.gvu.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fP(String str) {
        if (this.gvu != null) {
            this.gvu.fP(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bRu() {
        if (this.gvq == null) {
            this.gvq = new j(this.mContext, this);
        }
        bM(1, 30);
        a(this.gvq);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bRv() {
        if (this.gvr == null) {
            this.gvr = new e(this.mPageContext, this);
        }
        this.gvr.Gs(this.mUserId);
        fP(this.mUserId);
        a(this.gvr);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bRw() {
        if (this.gvn == null) {
            this.gvn = new c(this.mContext, this, this.eFZ);
        }
        this.gvu.Cb();
        a(this.gvn);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bRx() {
        if (this.gvv != null) {
            this.gvv.Cl();
        }
    }

    private void bRy() {
        if (this.gvm == null) {
            this.gvm = new l(this.mContext, this);
        }
        a(this.gvm);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.ahP.removeAllViews();
            if (this.gvt != null) {
                this.gvt.hide();
            }
            gVar.b(this.ahP, this.gvt == null ? 0 : this.gvt.bRi());
            this.gvt = gVar;
        }
    }

    public void bRz() {
        if (this.gvl == null) {
            this.gvl = new m(this.mContext, this);
        }
        a(this.gvl);
    }

    @Override // com.baidu.live.challenge.i.m
    public void Ck() {
        fO(this.mUserId);
    }

    @Override // com.baidu.live.challenge.i.m
    public void n(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.gvo != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.gvo.f(aVar);
        }
        if (z && aVar != null && this.gvv != null) {
            this.gvv.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void l(int i, String str) {
        if (i == 1492002) {
            bRt();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.gvo != null) {
            this.gvo.f(aVar);
            if (this.gvv != null) {
                this.gvv.a(aVar);
            }
        } else if (i == 0) {
            bRw();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.gvp != null) {
                this.gvp.e(aVar);
            }
            if (this.gvv != null) {
                this.gvv.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void h(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.gvt instanceof b) {
                ((b) this.gvt).bRj();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.gvp != null) {
                this.gvp.e(aVar);
            }
            if (this.gvv != null) {
                this.gvv.a(aVar);
            }
        } else if (i == 100) {
            bRw();
        } else if (i == 102) {
            if (!StringUtils.isNull(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
            }
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void b(boolean z, long j) {
        bRq();
        if (z) {
            dK(this.count);
            bRz();
            lY(this.canUseChallenge);
            if (this.gvl != null) {
                if (j >= 0) {
                    this.gvl.ei(j);
                    this.gvl.bRG();
                    return;
                }
                this.gvl.uh();
            }
        } else if (this.canUseChallenge) {
            bRw();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.sdk_can_not_use_challenge));
        }
    }

    public void lY(boolean z) {
        if (this.gvl == null) {
            this.gvl = new m(this.mContext, this);
        }
        this.gvl.bg(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.gvs == null) {
                this.gvs = new a(this.mContext, this);
            }
            this.gvs.d(aVar);
            a(this.gvs);
            if (this.gvv != null) {
                this.gvv.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aCX)) {
            BdUtilHelper.showToast(this.mContext, aVar.aCX);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.a
    public void g(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.aDi) {
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
            if (this.gvt != null) {
                if (this.gvt == this.gvq) {
                    this.gvq.j(dVar);
                } else if (this.gvt == this.gvr) {
                    this.gvr.a(dVar, true);
                }
            }
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void j(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
        if (this.gvt != null) {
            if (this.gvt == this.gvq) {
                this.gvq.bRp();
            } else if (this.gvt == this.gvr) {
                this.gvr.bRp();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void v(List<com.baidu.live.challenge.d> list) {
        if (this.gvn == null) {
            this.gvn = new c(this.mContext, this, this.eFZ);
        }
        this.gvn.cc(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void i(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0168i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.gvq != null) {
            this.gvq.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0168i
    public void k(int i, String str) {
        if (this.gvq != null) {
            this.gvq.aR(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void w(List<com.baidu.live.challenge.d> list) {
        if (this.gvr != null) {
            this.gvr.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void m(int i, String str) {
        if (this.gvr != null) {
            this.gvr.aR(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(au auVar, ay ayVar, ay ayVar2) {
        if (this.ahP.getParent() != null) {
            removeView();
            if (this.gvv != null) {
                this.gvv.Cm();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(au auVar, ay ayVar, ay ayVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(au auVar, ay ayVar, ay ayVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(au auVar, ay ayVar, ay ayVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void Cn() {
        if (this.gvv != null) {
            this.gvv.Cn();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bg(boolean z) {
        this.canUseChallenge = z;
        lY(z);
    }

    @Override // com.baidu.live.challenge.j
    public void dK(int i) {
        if (this.gvm == null) {
            this.gvm = new l(this.mContext, this);
        }
        this.gvm.dK(i);
        this.count = i;
        if (this.gvl == null) {
            this.gvl = new m(this.mContext, this);
        }
        this.gvl.dK(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void dI(int i) {
        this.gvu.dI(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.gvv = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.gvt == null) {
            return false;
        }
        return this.gvt.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.ahP.getParent() != null;
    }
}
