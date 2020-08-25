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
import com.baidu.live.data.ap;
import com.baidu.live.data.at;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes7.dex */
public class f implements com.baidu.live.challenge.j, m {
    private final FrameLayout aht;
    private String eDP;
    private l grM;
    private c grN;
    private h grO;
    private b grP;
    private j grQ;
    private e grR;
    private a grS;
    private g grT;
    private com.baidu.live.challenge.i grU;
    private com.baidu.live.challenge.k grV;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean grW = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aht = new FrameLayout(this.mContext);
        this.aht.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.grU == null || (f.this.grU.BP() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.grU.BP() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
    public void fK(String str) {
        this.eDP = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.grU = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.aht.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                BL();
                return;
            }
            bPX();
            bQf();
        }
    }

    private void bPX() {
        if (this.aht.getLayoutParams() == null) {
            this.mParentView.addView(this.aht, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.aht);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void removeView() {
        if (!this.grW) {
            this.grW = true;
            if (this.grT != null) {
                this.grT.bQg();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0185a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.bPY();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.grT.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPY() {
        this.grW = false;
        if (this.grT != null) {
            this.grT.hide();
        }
        if (this.aht.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.aht.getParent()).removeView(this.aht);
        }
        this.mParentView = null;
        this.grT = null;
        if (this.grV != null) {
            this.grV.BZ();
        }
    }

    public void BL() {
        if (this.grU != null) {
            this.grU.BL();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void ee(long j) {
        if (this.grU != null) {
            this.grU.Z(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bPZ() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.grO == null) {
            this.grO = new h(this.mContext, this);
        }
        a(this.grO);
        if (this.grU != null) {
            this.grU.BN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQa() {
        if (this.grU != null) {
            this.grU.BO();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.grP == null) {
                this.grP = new b(this.mContext, this);
            }
            this.grP.b(dVar);
            a(this.grP);
            if (this.grU != null) {
                this.grU.X(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void W(long j) {
        if (this.grU != null) {
            this.grU.W(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void ef(long j) {
        if (this.grU != null) {
            this.grU.Y(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bM(int i, int i2) {
        if (this.grU != null) {
            this.grU.w(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void h(int i, int i2, String str) {
        if (this.grU != null) {
            this.grU.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void fJ(String str) {
        if (this.grU != null) {
            this.grU.fJ(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQb() {
        if (this.grQ == null) {
            this.grQ = new j(this.mContext, this);
        }
        bM(1, 30);
        a(this.grQ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQc() {
        if (this.grR == null) {
            this.grR = new e(this.mPageContext, this);
        }
        this.grR.FT(this.mUserId);
        fJ(this.mUserId);
        a(this.grR);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQd() {
        if (this.grN == null) {
            this.grN = new c(this.mContext, this, this.eDP);
        }
        this.grU.BM();
        a(this.grN);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQe() {
        if (this.grV != null) {
            this.grV.BW();
        }
    }

    private void bQf() {
        if (this.grM == null) {
            this.grM = new l(this.mContext, this);
        }
        a(this.grM);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.aht.removeAllViews();
            if (this.grT != null) {
                this.grT.hide();
            }
            gVar.b(this.aht, this.grT == null ? 0 : this.grT.bPP());
            this.grT = gVar;
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void BV() {
        bPX();
        bQd();
    }

    @Override // com.baidu.live.challenge.i.l
    public void n(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.grO != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.grO.f(aVar);
        }
        if (z && aVar != null && this.grV != null) {
            this.grV.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void l(int i, String str) {
        if (i == 1492002) {
            bQa();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.grO != null) {
            this.grO.f(aVar);
            if (this.grV != null) {
                this.grV.a(aVar);
            }
        } else if (i == 0) {
            bQd();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.grP != null) {
                this.grP.e(aVar);
            }
            if (this.grV != null) {
                this.grV.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void h(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.grT instanceof b) {
                ((b) this.grT).bPQ();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.grP != null) {
                this.grP.e(aVar);
            }
            if (this.grV != null) {
                this.grV.a(aVar);
            }
        } else if (i == 100) {
            bQd();
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
            if (this.grS == null) {
                this.grS = new a(this.mContext, this);
            }
            this.grS.d(aVar);
            a(this.grS);
            if (this.grV != null) {
                this.grV.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aCm)) {
            BdUtilHelper.showToast(this.mContext, aVar.aCm);
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
            if (dVar.aCw) {
                h(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(dVar.liveStatus == 1 ? a.i.ala_challenge_panel_host_challenging : a.i.ala_challenge_panel_host_offline));
            if (this.grT != null) {
                if (this.grT == this.grQ) {
                    this.grQ.j(dVar);
                } else if (this.grT == this.grR) {
                    if (!dVar.aCw) {
                        dVar.aCv = 2;
                    }
                    this.grR.a(dVar, true);
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
        if (this.grT != null) {
            if (this.grT == this.grQ) {
                this.grQ.bPW();
            } else if (this.grT == this.grR) {
                this.grR.bPW();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void v(List<com.baidu.live.challenge.d> list) {
        if (this.grN == null) {
            this.grN = new c(this.mContext, this, this.eDP);
        }
        this.grN.bX(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void i(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0166i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.grQ != null) {
            this.grQ.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0166i
    public void k(int i, String str) {
        if (this.grQ != null) {
            this.grQ.aR(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void w(List<com.baidu.live.challenge.d> list) {
        if (this.grR != null) {
            this.grR.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void m(int i, String str) {
        if (this.grR != null) {
            this.grR.aR(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(ap apVar, at atVar, at atVar2) {
        if (this.aht.getParent() != null) {
            removeView();
            if (this.grV != null) {
                this.grV.BX();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(ap apVar, at atVar, at atVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(ap apVar, at atVar, at atVar2) {
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(ap apVar, at atVar, at atVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void BY() {
        if (this.grV != null) {
            this.grV.BY();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void dG(int i) {
        if (this.grM == null) {
            this.grM = new l(this.mContext, this);
        }
        this.grM.dG(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void dE(int i) {
        this.grU.dE(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.grV = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.grT == null) {
            return false;
        }
        return this.grT.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.aht.getParent() != null;
    }
}
