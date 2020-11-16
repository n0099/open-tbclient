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
    private final FrameLayout ail;
    private String ffB;
    private m hbg;
    private l hbh;
    private c hbi;
    private h hbj;
    private b hbk;
    private j hbl;
    private e hbm;
    private a hbn;
    private g hbo;
    private com.baidu.live.challenge.i hbp;
    private com.baidu.live.challenge.k hbq;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean hbr = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ail = new FrameLayout(this.mContext);
        this.ail.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hbp == null || (f.this.hbp.CS() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.hbp.CS() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
        this.ffB = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.hbp = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.ail.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                CO();
                return;
            }
            bZE();
            bZM();
        }
    }

    private void bZE() {
        if (this.ail.getLayoutParams() == null) {
            this.mParentView.addView(this.ail, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.ail);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.hbr) {
            this.hbr = true;
            if (this.hbo != null) {
                this.hbo.bZO();
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
                                f.this.bZF();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.hbo.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZF() {
        this.hbr = false;
        if (this.hbo != null) {
            this.hbo.hide();
        }
        if (this.ail.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ail.getParent()).removeView(this.ail);
        }
        this.mParentView = null;
        this.hbo = null;
        if (this.hbq != null) {
            this.hbq.Dc();
        }
    }

    public void CO() {
        if (this.hbp != null) {
            this.hbp.CO();
        }
    }

    public void gc(String str) {
        if (this.hbp != null) {
            this.hbp.gc(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void eU(long j) {
        if (this.hbp != null) {
            this.hbp.am(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bZG() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
            return;
        }
        if (this.hbj == null) {
            this.hbj = new h(this.mContext, this);
        }
        a(this.hbj);
        if (this.hbp != null) {
            this.hbp.CQ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bZH() {
        if (this.hbp != null) {
            this.hbp.CR();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.hbk == null) {
                this.hbk = new b(this.mContext, this);
            }
            this.hbk.b(dVar);
            a(this.hbk);
            if (this.hbp != null) {
                this.hbp.ak(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void aj(long j) {
        if (this.hbp != null) {
            this.hbp.aj(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void eV(long j) {
        if (this.hbp != null) {
            this.hbp.al(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bQ(int i, int i2) {
        if (this.hbp != null) {
            this.hbp.w(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void j(int i, int i2, String str) {
        if (this.hbp != null) {
            this.hbp.f(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void gd(String str) {
        if (this.hbp != null) {
            this.hbp.gd(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bZI() {
        if (this.hbl == null) {
            this.hbl = new j(this.mContext, this);
        }
        bQ(1, 30);
        a(this.hbl);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bZJ() {
        if (this.hbm == null) {
            this.hbm = new e(this.mPageContext, this);
        }
        this.hbm.Hv(this.mUserId);
        gd(this.mUserId);
        a(this.hbm);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bZK() {
        if (this.hbi == null) {
            this.hbi = new c(this.mContext, this, this.ffB);
        }
        this.hbp.CP();
        a(this.hbi);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bZL() {
        if (this.hbq != null) {
            this.hbq.CZ();
        }
    }

    private void bZM() {
        if (this.hbh == null) {
            this.hbh = new l(this.mContext, this);
        }
        a(this.hbh);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.ail.removeAllViews();
            if (this.hbo != null) {
                this.hbo.hide();
            }
            gVar.b(this.ail, this.hbo == null ? 0 : this.hbo.bZw());
            this.hbo = gVar;
        }
    }

    public void bZN() {
        if (this.hbg == null) {
            this.hbg = new m(this.mContext, this);
        }
        a(this.hbg);
    }

    @Override // com.baidu.live.challenge.i.m
    public void CY() {
        gc(this.mUserId);
    }

    @Override // com.baidu.live.challenge.i.m
    public void p(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.hbj != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.hbj.f(aVar);
        }
        if (z && aVar != null && this.hbq != null) {
            this.hbq.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void n(int i, String str) {
        if (i == 1492002) {
            bZH();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.hbj != null) {
            this.hbj.f(aVar);
            if (this.hbq != null) {
                this.hbq.a(aVar);
            }
        } else if (i == 0) {
            bZK();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.hbk != null) {
                this.hbk.e(aVar);
            }
            if (this.hbq != null) {
                this.hbq.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void j(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.hbo instanceof b) {
                ((b) this.hbo).bZx();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.hbk != null) {
                this.hbk.e(aVar);
            }
            if (this.hbq != null) {
                this.hbq.a(aVar);
            }
        } else if (i == 100) {
            bZK();
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
            bZE();
            dL(this.count);
            bZN();
            na(this.canUseChallenge);
            if (this.hbg != null) {
                if (j >= 0) {
                    this.hbg.eW(j);
                    this.hbg.bZU();
                    return;
                }
                this.hbg.uh();
            }
        } else if (this.canUseChallenge) {
            bZE();
            bZK();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_can_not_use_challenge));
        }
    }

    public void na(boolean z) {
        if (this.hbg == null) {
            this.hbg = new m(this.mContext, this);
        }
        this.hbg.bo(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.hbn == null) {
                this.hbn = new a(this.mContext, this);
            }
            this.hbn.d(aVar);
            a(this.hbn);
            if (this.hbq != null) {
                this.hbq.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aFp)) {
            BdUtilHelper.showToast(this.mContext, aVar.aFp);
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
            if (dVar.aFz) {
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
            if (this.hbo != null) {
                if (this.hbo == this.hbl) {
                    this.hbl.j(dVar);
                } else if (this.hbo == this.hbm) {
                    this.hbm.a(dVar, true);
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
        if (this.hbo != null) {
            if (this.hbo == this.hbl) {
                this.hbl.bZD();
            } else if (this.hbo == this.hbm) {
                this.hbm.bZD();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void x(List<com.baidu.live.challenge.d> list) {
        if (this.hbi == null) {
            this.hbi = new c(this.mContext, this, this.ffB);
        }
        this.hbi.cx(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void k(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0175i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.hbl != null) {
            this.hbl.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0175i
    public void m(int i, String str) {
        if (this.hbl != null) {
            this.hbl.bf(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.hbm != null) {
            this.hbm.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void o(int i, String str) {
        if (this.hbm != null) {
            this.hbm.bf(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(az azVar, bd bdVar, bd bdVar2) {
        if (this.ail.getParent() != null) {
            removeView();
            if (this.hbq != null) {
                this.hbq.Da();
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
    public void Db() {
        if (this.hbq != null) {
            this.hbq.Db();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bo(boolean z) {
        this.canUseChallenge = z;
        na(z);
    }

    @Override // com.baidu.live.challenge.j
    public void dL(int i) {
        if (this.hbh == null) {
            this.hbh = new l(this.mContext, this);
        }
        this.hbh.dL(i);
        this.count = i;
        if (this.hbg == null) {
            this.hbg = new m(this.mContext, this);
        }
        this.hbg.dL(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void dJ(int i) {
        this.hbp.dJ(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.hbq = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.hbo == null) {
            return false;
        }
        return this.hbo.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.ail.getParent() != null;
    }
}
