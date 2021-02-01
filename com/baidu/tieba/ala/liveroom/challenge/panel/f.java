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
    private com.baidu.live.challenge.k hwA;
    private m hwq;
    private l hwr;
    private c hws;
    private h hwt;
    private b hwu;
    private j hwv;
    private e hww;
    private a hwx;
    private g hwy;
    private com.baidu.live.challenge.i hwz;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean hwB = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aiT = new FrameLayout(this.mContext);
        this.aiT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hwz == null || (f.this.hwz.AG() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.hwz.AG() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
        this.hwz = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.aiT.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                AC();
                return;
            }
            cdu();
            cdC();
        }
    }

    private void cdu() {
        if (this.aiT.getLayoutParams() == null) {
            this.mParentView.addView(this.aiT, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.aiT);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.hwB) {
            this.hwB = true;
            if (this.hwy != null) {
                this.hwy.cdE();
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
                                f.this.cdv();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.hwy.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdv() {
        this.hwB = false;
        if (this.hwy != null) {
            this.hwy.hide();
        }
        if (this.aiT.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.aiT.getParent()).removeView(this.aiT);
        }
        this.mParentView = null;
        this.hwy = null;
        if (this.hwA != null) {
            this.hwA.AQ();
        }
    }

    public void AC() {
        if (this.hwz != null) {
            this.hwz.AC();
        }
    }

    public void fp(String str) {
        if (this.hwz != null) {
            this.hwz.fp(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fD(long j) {
        if (this.hwz != null) {
            this.hwz.aL(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdw() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
            return;
        }
        if (this.hwt == null) {
            this.hwt = new h(this.mContext, this);
        }
        a(this.hwt);
        if (this.hwz != null) {
            this.hwz.AE();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdx() {
        if (this.hwz != null) {
            this.hwz.AF();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.hwu == null) {
                this.hwu = new b(this.mContext, this);
            }
            this.hwu.b(dVar);
            a(this.hwu);
            if (this.hwz != null) {
                this.hwz.aJ(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void aI(long j) {
        if (this.hwz != null) {
            this.hwz.aI(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fE(long j) {
        if (this.hwz != null) {
            this.hwz.aK(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bQ(int i, int i2) {
        if (this.hwz != null) {
            this.hwz.y(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void j(int i, int i2, String str) {
        if (this.hwz != null) {
            this.hwz.g(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fq(String str) {
        if (this.hwz != null) {
            this.hwz.fq(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdy() {
        if (this.hwv == null) {
            this.hwv = new j(this.mContext, this);
        }
        bQ(1, 30);
        a(this.hwv);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdz() {
        if (this.hww == null) {
            this.hww = new e(this.mPageContext, this);
        }
        this.hww.HE(this.mUserId);
        fq(this.mUserId);
        a(this.hww);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdA() {
        if (this.hws == null) {
            this.hws = new c(this.mContext, this, this.fuu);
        }
        this.hwz.AD();
        a(this.hws);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdB() {
        if (this.hwA != null) {
            this.hwA.AN();
        }
    }

    private void cdC() {
        if (this.hwr == null) {
            this.hwr = new l(this.mContext, this);
        }
        a(this.hwr);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.aiT.removeAllViews();
            if (this.hwy != null) {
                this.hwy.hide();
            }
            gVar.b(this.aiT, this.hwy == null ? 0 : this.hwy.cdm());
            this.hwy = gVar;
        }
    }

    public void cdD() {
        if (this.hwq == null) {
            this.hwq = new m(this.mContext, this);
        }
        a(this.hwq);
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
        if (this.hwt != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.hwt.f(aVar);
        }
        if (z && aVar != null && this.hwA != null) {
            this.hwA.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void r(int i, String str) {
        if (i == 1492002) {
            cdx();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.hwt != null) {
            this.hwt.f(aVar);
            if (this.hwA != null) {
                this.hwA.a(aVar);
            }
        } else if (i == 0) {
            cdA();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.hwu != null) {
                this.hwu.e(aVar);
            }
            if (this.hwA != null) {
                this.hwA.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void n(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.hwy instanceof b) {
                ((b) this.hwy).cdn();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.hwu != null) {
                this.hwu.e(aVar);
            }
            if (this.hwA != null) {
                this.hwA.a(aVar);
            }
        } else if (i == 100) {
            cdA();
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
            cdu();
            cy(this.count);
            cdD();
            oc(this.canUseChallenge);
            if (this.hwq != null) {
                if (j >= 0) {
                    this.hwq.fF(j);
                    this.hwq.cdK();
                    return;
                }
                this.hwq.tv();
            }
        } else if (this.canUseChallenge) {
            cdu();
            cdA();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_can_not_use_challenge));
        }
    }

    public void oc(boolean z) {
        if (this.hwq == null) {
            this.hwq = new m(this.mContext, this);
        }
        this.hwq.br(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.hwx == null) {
                this.hwx = new a(this.mContext, this);
            }
            this.hwx.d(aVar);
            a(this.hwx);
            if (this.hwA != null) {
                this.hwA.a(aVar);
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
            if (this.hwy != null) {
                if (this.hwy == this.hwv) {
                    this.hwv.j(dVar);
                } else if (this.hwy == this.hww) {
                    this.hww.a(dVar, true);
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
        if (this.hwy != null) {
            if (this.hwy == this.hwv) {
                this.hwv.cdt();
            } else if (this.hwy == this.hww) {
                this.hww.cdt();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.hws == null) {
            this.hws = new c(this.mContext, this, this.fuu);
        }
        this.hws.cD(list);
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
        if (this.hwv != null) {
            this.hwv.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0166i
    public void q(int i, String str) {
        if (this.hwv != null) {
            this.hwv.bn(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void z(List<com.baidu.live.challenge.d> list) {
        if (this.hww != null) {
            this.hww.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void s(int i, String str) {
        if (this.hww != null) {
            this.hww.bn(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(bg bgVar, bk bkVar, bk bkVar2) {
        if (this.aiT.getParent() != null) {
            removeView();
            if (this.hwA != null) {
                this.hwA.AO();
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
        if (this.hwA != null) {
            this.hwA.AP();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void br(boolean z) {
        this.canUseChallenge = z;
        oc(z);
    }

    @Override // com.baidu.live.challenge.j
    public void cy(int i) {
        if (this.hwr == null) {
            this.hwr = new l(this.mContext, this);
        }
        this.hwr.cy(i);
        this.count = i;
        if (this.hwq == null) {
            this.hwq = new m(this.mContext, this);
        }
        this.hwq.cy(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cw(int i) {
        this.hwz.cw(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.hwA = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.hwy == null) {
            return false;
        }
        return this.hwy.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.aiT.getParent() != null;
    }
}
