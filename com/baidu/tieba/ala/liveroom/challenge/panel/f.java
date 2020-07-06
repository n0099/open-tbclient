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
import com.baidu.live.data.am;
import com.baidu.live.data.aq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements com.baidu.live.challenge.j, m {
    private final FrameLayout agu;
    private String enf;
    private j gaA;
    private e gaB;
    private a gaC;
    private g gaD;
    private com.baidu.live.challenge.i gaE;
    private com.baidu.live.challenge.k gaF;
    private l gaw;
    private c gax;
    private h gay;
    private b gaz;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean gaG = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.agu = new FrameLayout(this.mContext);
        this.agu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gaE == null || (f.this.gaE.vV() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.gaE.vV() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
    public void es(String str) {
        this.enf = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.gaE = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.agu.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                vR();
                return;
            }
            bDh();
            bDp();
        }
    }

    private void bDh() {
        if (this.agu.getLayoutParams() == null) {
            this.mParentView.addView(this.agu, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.agu);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void removeView() {
        if (!this.gaG) {
            this.gaG = true;
            if (this.gaD != null) {
                this.gaD.bDq();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0176a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.bDi();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.gaD.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDi() {
        this.gaG = false;
        if (this.gaD != null) {
            this.gaD.hide();
        }
        if (this.agu.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.agu.getParent()).removeView(this.agu);
        }
        this.mParentView = null;
        this.gaD = null;
        if (this.gaF != null) {
            this.gaF.wf();
        }
    }

    public void vR() {
        if (this.gaE != null) {
            this.gaE.vR();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void dF(long j) {
        if (this.gaE != null) {
            this.gaE.Y(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bDj() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.gay == null) {
            this.gay = new h(this.mContext, this);
        }
        a(this.gay);
        if (this.gaE != null) {
            this.gaE.vT();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bDk() {
        if (this.gaE != null) {
            this.gaE.vU();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.gaz == null) {
                this.gaz = new b(this.mContext, this);
            }
            this.gaz.b(dVar);
            a(this.gaz);
            if (this.gaE != null) {
                this.gaE.W(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void V(long j) {
        if (this.gaE != null) {
            this.gaE.V(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void dG(long j) {
        if (this.gaE != null) {
            this.gaE.X(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bB(int i, int i2) {
        if (this.gaE != null) {
            this.gaE.t(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void i(int i, int i2, String str) {
        if (this.gaE != null) {
            this.gaE.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void er(String str) {
        if (this.gaE != null) {
            this.gaE.er(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bDl() {
        if (this.gaA == null) {
            this.gaA = new j(this.mContext, this);
        }
        bB(1, 30);
        a(this.gaA);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bDm() {
        if (this.gaB == null) {
            this.gaB = new e(this.mPageContext, this);
        }
        this.gaB.CK(this.mUserId);
        er(this.mUserId);
        a(this.gaB);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bDn() {
        if (this.gax == null) {
            this.gax = new c(this.mContext, this, this.enf);
        }
        this.gaE.vS();
        a(this.gax);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bDo() {
        if (this.gaF != null) {
            this.gaF.wc();
        }
    }

    private void bDp() {
        if (this.gaw == null) {
            this.gaw = new l(this.mContext, this);
        }
        a(this.gaw);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.agu.removeAllViews();
            if (this.gaD != null) {
                this.gaD.hide();
            }
            gVar.b(this.agu, this.gaD == null ? 0 : this.gaD.bCZ());
            this.gaD = gVar;
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void wb() {
        bDh();
        bDn();
    }

    @Override // com.baidu.live.challenge.i.l
    public void n(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.gay != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.gay.f(aVar);
        }
        if (z && aVar != null && this.gaF != null) {
            this.gaF.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void l(int i, String str) {
        if (i == 1492002) {
            bDk();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.gay != null) {
            this.gay.f(aVar);
            if (this.gaF != null) {
                this.gaF.a(aVar);
            }
        } else if (i == 0) {
            bDn();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.gaz != null) {
                this.gaz.e(aVar);
            }
            if (this.gaF != null) {
                this.gaF.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void h(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.gaD instanceof b) {
                ((b) this.gaD).bDa();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.gaz != null) {
                this.gaz.e(aVar);
            }
            if (this.gaF != null) {
                this.gaF.a(aVar);
            }
        } else if (i == 100) {
            bDn();
        } else if (i == 102) {
            if (!StringUtils.isNull(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
            }
        }
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.gaC == null) {
                this.gaC = new a(this.mContext, this);
            }
            this.gaC.d(aVar);
            a(this.gaC);
            if (this.gaF != null) {
                this.gaF.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.awf)) {
            BdUtilHelper.showToast(this.mContext, aVar.awf);
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
            if (dVar.awp) {
                h(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(dVar.liveStatus == 1 ? a.i.ala_challenge_panel_host_challenging : a.i.ala_challenge_panel_host_offline));
            if (this.gaD != null) {
                if (this.gaD == this.gaA) {
                    this.gaA.j(dVar);
                } else if (this.gaD == this.gaB) {
                    if (!dVar.awp) {
                        dVar.awo = 2;
                    }
                    this.gaB.a(dVar, true);
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
        if (this.gaD != null) {
            if (this.gaD == this.gaA) {
                this.gaA.bDg();
            } else if (this.gaD == this.gaB) {
                this.gaB.bDg();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void s(List<com.baidu.live.challenge.d> list) {
        if (this.gax == null) {
            this.gax = new c(this.mContext, this, this.enf);
        }
        this.gax.bS(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void i(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0159i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.gaA != null) {
            this.gaA.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0159i
    public void k(int i, String str) {
        if (this.gaA != null) {
            this.gaA.aR(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void t(List<com.baidu.live.challenge.d> list) {
        if (this.gaB != null) {
            this.gaB.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void m(int i, String str) {
        if (this.gaB != null) {
            this.gaB.aR(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(am amVar, aq aqVar, aq aqVar2) {
        if (this.agu.getParent() != null) {
            removeView();
            if (this.gaF != null) {
                this.gaF.wd();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(am amVar, aq aqVar, aq aqVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(am amVar, aq aqVar, aq aqVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(am amVar, aq aqVar, aq aqVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void we() {
        if (this.gaF != null) {
            this.gaF.we();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bO(int i) {
        if (this.gaw == null) {
            this.gaw = new l(this.mContext, this);
        }
        this.gaw.bO(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bM(int i) {
        this.gaE.bM(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.gaF = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.gaD == null) {
            return false;
        }
        return this.gaD.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.agu.getParent() != null;
    }
}
