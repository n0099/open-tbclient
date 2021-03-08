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
/* loaded from: classes10.dex */
public class f implements com.baidu.live.challenge.j, n {
    private final FrameLayout akl;
    private String fvT;
    private m hyn;
    private l hyo;
    private c hyp;
    private h hyq;
    private b hyr;
    private j hys;
    private e hyt;
    private a hyu;
    private g hyv;
    private com.baidu.live.challenge.i hyw;
    private com.baidu.live.challenge.k hyx;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean hyy = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.akl = new FrameLayout(this.mContext);
        this.akl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hyw == null || (f.this.hyw.AJ() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.hyw.AJ() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
        this.fvT = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.hyw = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.akl.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                AF();
                return;
            }
            cdH();
            cdP();
        }
    }

    private void cdH() {
        if (this.akl.getLayoutParams() == null) {
            this.mParentView.addView(this.akl, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.akl);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.hyy) {
            this.hyy = true;
            if (this.hyv != null) {
                this.hyv.cdR();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0201a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.cdI();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.hyv.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdI() {
        this.hyy = false;
        if (this.hyv != null) {
            this.hyv.hide();
        }
        if (this.akl.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.akl.getParent()).removeView(this.akl);
        }
        this.mParentView = null;
        this.hyv = null;
        if (this.hyx != null) {
            this.hyx.AT();
        }
    }

    public void AF() {
        if (this.hyw != null) {
            this.hyw.AF();
        }
    }

    public void fv(String str) {
        if (this.hyw != null) {
            this.hyw.fv(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fD(long j) {
        if (this.hyw != null) {
            this.hyw.aL(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdJ() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
            return;
        }
        if (this.hyq == null) {
            this.hyq = new h(this.mContext, this);
        }
        a(this.hyq);
        if (this.hyw != null) {
            this.hyw.AH();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdK() {
        if (this.hyw != null) {
            this.hyw.AI();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.hyr == null) {
                this.hyr = new b(this.mContext, this);
            }
            this.hyr.b(dVar);
            a(this.hyr);
            if (this.hyw != null) {
                this.hyw.aJ(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void aI(long j) {
        if (this.hyw != null) {
            this.hyw.aI(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fE(long j) {
        if (this.hyw != null) {
            this.hyw.aK(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bR(int i, int i2) {
        if (this.hyw != null) {
            this.hyw.y(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void j(int i, int i2, String str) {
        if (this.hyw != null) {
            this.hyw.g(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void fw(String str) {
        if (this.hyw != null) {
            this.hyw.fw(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdL() {
        if (this.hys == null) {
            this.hys = new j(this.mContext, this);
        }
        bR(1, 30);
        a(this.hys);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdM() {
        if (this.hyt == null) {
            this.hyt = new e(this.mPageContext, this);
        }
        this.hyt.HO(this.mUserId);
        fw(this.mUserId);
        a(this.hyt);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdN() {
        if (this.hyp == null) {
            this.hyp = new c(this.mContext, this, this.fvT);
        }
        this.hyw.AG();
        a(this.hyp);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cdO() {
        if (this.hyx != null) {
            this.hyx.AQ();
        }
    }

    private void cdP() {
        if (this.hyo == null) {
            this.hyo = new l(this.mContext, this);
        }
        a(this.hyo);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.akl.removeAllViews();
            if (this.hyv != null) {
                this.hyv.hide();
            }
            gVar.b(this.akl, this.hyv == null ? 0 : this.hyv.cdz());
            this.hyv = gVar;
        }
    }

    public void cdQ() {
        if (this.hyn == null) {
            this.hyn = new m(this.mContext, this);
        }
        a(this.hyn);
    }

    @Override // com.baidu.live.challenge.i.m
    public void AP() {
        fv(this.mUserId);
    }

    @Override // com.baidu.live.challenge.i.m
    public void t(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.hyq != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.hyq.f(aVar);
        }
        if (z && aVar != null && this.hyx != null) {
            this.hyx.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void r(int i, String str) {
        if (i == 1492002) {
            cdK();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.hyq != null) {
            this.hyq.f(aVar);
            if (this.hyx != null) {
                this.hyx.a(aVar);
            }
        } else if (i == 0) {
            cdN();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.hyr != null) {
                this.hyr.e(aVar);
            }
            if (this.hyx != null) {
                this.hyx.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void n(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.hyv instanceof b) {
                ((b) this.hyv).cdA();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.hyr != null) {
                this.hyr.e(aVar);
            }
            if (this.hyx != null) {
                this.hyx.a(aVar);
            }
        } else if (i == 100) {
            cdN();
        } else if (i == 102) {
            if (!StringUtils.isNull(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
            }
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void l(boolean z, long j) {
        if (z) {
            cdH();
            cz(this.count);
            cdQ();
            oc(this.canUseChallenge);
            if (this.hyn != null) {
                if (j >= 0) {
                    this.hyn.fF(j);
                    this.hyn.cdX();
                    return;
                }
                this.hyn.tv();
            }
        } else if (this.canUseChallenge) {
            cdH();
            cdN();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_can_not_use_challenge));
        }
    }

    public void oc(boolean z) {
        if (this.hyn == null) {
            this.hyn = new m(this.mContext, this);
        }
        this.hyn.br(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.hyu == null) {
                this.hyu = new a(this.mContext, this);
            }
            this.hyu.d(aVar);
            a(this.hyu);
            if (this.hyx != null) {
                this.hyx.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aGT)) {
            BdUtilHelper.showToast(this.mContext, aVar.aGT);
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
            if (dVar.aHd) {
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
            if (this.hyv != null) {
                if (this.hyv == this.hys) {
                    this.hys.j(dVar);
                } else if (this.hyv == this.hyt) {
                    this.hyt.a(dVar, true);
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
        if (this.hyv != null) {
            if (this.hyv == this.hys) {
                this.hys.cdG();
            } else if (this.hyv == this.hyt) {
                this.hyt.cdG();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.hyp == null) {
            this.hyp = new c(this.mContext, this, this.fvT);
        }
        this.hyp.cD(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void o(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0172i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.hys != null) {
            this.hys.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0172i
    public void q(int i, String str) {
        if (this.hys != null) {
            this.hys.bn(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void z(List<com.baidu.live.challenge.d> list) {
        if (this.hyt != null) {
            this.hyt.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void s(int i, String str) {
        if (this.hyt != null) {
            this.hyt.bn(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(bg bgVar, bk bkVar, bk bkVar2) {
        if (this.akl.getParent() != null) {
            removeView();
            if (this.hyx != null) {
                this.hyx.AR();
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
    public void AS() {
        if (this.hyx != null) {
            this.hyx.AS();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void br(boolean z) {
        this.canUseChallenge = z;
        oc(z);
    }

    @Override // com.baidu.live.challenge.j
    public void cz(int i) {
        if (this.hyo == null) {
            this.hyo = new l(this.mContext, this);
        }
        this.hyo.cz(i);
        this.count = i;
        if (this.hyn == null) {
            this.hyn = new m(this.mContext, this);
        }
        this.hyn.cz(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void cx(int i) {
        this.hyw.cx(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.hyx = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.hyv == null) {
            return false;
        }
        return this.hyv.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.akl.getParent() != null;
    }
}
