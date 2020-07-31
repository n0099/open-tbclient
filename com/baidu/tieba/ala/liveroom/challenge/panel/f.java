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
import com.baidu.live.data.an;
import com.baidu.live.data.ar;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.challenge.j, m {
    private final FrameLayout agl;
    private String ets;
    private l gfE;
    private c gfF;
    private h gfG;
    private b gfH;
    private j gfI;
    private e gfJ;
    private a gfK;
    private g gfL;
    private com.baidu.live.challenge.i gfM;
    private com.baidu.live.challenge.k gfN;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean gfO = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.agl = new FrameLayout(this.mContext);
        this.agl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gfM == null || (f.this.gfM.wr() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.gfM.wr() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
        this.ets = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.gfM = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.agl.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                wn();
                return;
            }
            bGs();
            bGA();
        }
    }

    private void bGs() {
        if (this.agl.getLayoutParams() == null) {
            this.mParentView.addView(this.agl, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.agl);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void removeView() {
        if (!this.gfO) {
            this.gfO = true;
            if (this.gfL != null) {
                this.gfL.bGB();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0178a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.bGt();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.gfL.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGt() {
        this.gfO = false;
        if (this.gfL != null) {
            this.gfL.hide();
        }
        if (this.agl.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.agl.getParent()).removeView(this.agl);
        }
        this.mParentView = null;
        this.gfL = null;
        if (this.gfN != null) {
            this.gfN.wB();
        }
    }

    public void wn() {
        if (this.gfM != null) {
            this.gfM.wn();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void dT(long j) {
        if (this.gfM != null) {
            this.gfM.Y(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bGu() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.gfG == null) {
            this.gfG = new h(this.mContext, this);
        }
        a(this.gfG);
        if (this.gfM != null) {
            this.gfM.wp();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bGv() {
        if (this.gfM != null) {
            this.gfM.wq();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.gfH == null) {
                this.gfH = new b(this.mContext, this);
            }
            this.gfH.b(dVar);
            a(this.gfH);
            if (this.gfM != null) {
                this.gfM.W(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void V(long j) {
        if (this.gfM != null) {
            this.gfM.V(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void dU(long j) {
        if (this.gfM != null) {
            this.gfM.X(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bE(int i, int i2) {
        if (this.gfM != null) {
            this.gfM.t(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void i(int i, int i2, String str) {
        if (this.gfM != null) {
            this.gfM.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void er(String str) {
        if (this.gfM != null) {
            this.gfM.er(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bGw() {
        if (this.gfI == null) {
            this.gfI = new j(this.mContext, this);
        }
        bE(1, 30);
        a(this.gfI);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bGx() {
        if (this.gfJ == null) {
            this.gfJ = new e(this.mPageContext, this);
        }
        this.gfJ.Dw(this.mUserId);
        er(this.mUserId);
        a(this.gfJ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bGy() {
        if (this.gfF == null) {
            this.gfF = new c(this.mContext, this, this.ets);
        }
        this.gfM.wo();
        a(this.gfF);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bGz() {
        if (this.gfN != null) {
            this.gfN.wy();
        }
    }

    private void bGA() {
        if (this.gfE == null) {
            this.gfE = new l(this.mContext, this);
        }
        a(this.gfE);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.agl.removeAllViews();
            if (this.gfL != null) {
                this.gfL.hide();
            }
            gVar.b(this.agl, this.gfL == null ? 0 : this.gfL.bGk());
            this.gfL = gVar;
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void wx() {
        bGs();
        bGy();
    }

    @Override // com.baidu.live.challenge.i.l
    public void o(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.gfG != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.gfG.f(aVar);
        }
        if (z && aVar != null && this.gfN != null) {
            this.gfN.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void m(int i, String str) {
        if (i == 1492002) {
            bGv();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.gfG != null) {
            this.gfG.f(aVar);
            if (this.gfN != null) {
                this.gfN.a(aVar);
            }
        } else if (i == 0) {
            bGy();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.gfH != null) {
                this.gfH.e(aVar);
            }
            if (this.gfN != null) {
                this.gfN.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void i(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.gfL instanceof b) {
                ((b) this.gfL).bGl();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.gfH != null) {
                this.gfH.e(aVar);
            }
            if (this.gfN != null) {
                this.gfN.a(aVar);
            }
        } else if (i == 100) {
            bGy();
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
            if (this.gfK == null) {
                this.gfK = new a(this.mContext, this);
            }
            this.gfK.d(aVar);
            a(this.gfK);
            if (this.gfN != null) {
                this.gfN.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.axk)) {
            BdUtilHelper.showToast(this.mContext, aVar.axk);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.a
    public void h(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.axu) {
                h(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(dVar.liveStatus == 1 ? a.i.ala_challenge_panel_host_challenging : a.i.ala_challenge_panel_host_offline));
            if (this.gfL != null) {
                if (this.gfL == this.gfI) {
                    this.gfI.j(dVar);
                } else if (this.gfL == this.gfJ) {
                    if (!dVar.axu) {
                        dVar.axt = 2;
                    }
                    this.gfJ.a(dVar, true);
                }
            }
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void k(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
        if (this.gfL != null) {
            if (this.gfL == this.gfI) {
                this.gfI.bGr();
            } else if (this.gfL == this.gfJ) {
                this.gfJ.bGr();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void u(List<com.baidu.live.challenge.d> list) {
        if (this.gfF == null) {
            this.gfF = new c(this.mContext, this, this.ets);
        }
        this.gfF.bW(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void j(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0158i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.gfI != null) {
            this.gfI.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0158i
    public void l(int i, String str) {
        if (this.gfI != null) {
            this.gfI.aT(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void v(List<com.baidu.live.challenge.d> list) {
        if (this.gfJ != null) {
            this.gfJ.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void n(int i, String str) {
        if (this.gfJ != null) {
            this.gfJ.aT(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(an anVar, ar arVar, ar arVar2) {
        if (this.agl.getParent() != null) {
            removeView();
            if (this.gfN != null) {
                this.gfN.wz();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(an anVar, ar arVar, ar arVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(an anVar, ar arVar, ar arVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(an anVar, ar arVar, ar arVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void wA() {
        if (this.gfN != null) {
            this.gfN.wA();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bU(int i) {
        if (this.gfE == null) {
            this.gfE = new l(this.mContext, this);
        }
        this.gfE.bU(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bS(int i) {
        this.gfM.bS(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.gfN = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.gfL == null) {
            return false;
        }
        return this.gfL.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.agl.getParent() != null;
    }
}
