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
    private final FrameLayout ahv;
    private String eDT;
    private l grQ;
    private c grR;
    private h grS;
    private b grT;
    private j grU;
    private e grV;
    private a grW;
    private g grX;
    private com.baidu.live.challenge.i grY;
    private com.baidu.live.challenge.k grZ;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean gsa = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ahv = new FrameLayout(this.mContext);
        this.ahv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.grY == null || (f.this.grY.BP() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.grY.BP() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
    public void fL(String str) {
        this.eDT = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.grY = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.ahv.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                BL();
                return;
            }
            bPY();
            bQg();
        }
    }

    private void bPY() {
        if (this.ahv.getLayoutParams() == null) {
            this.mParentView.addView(this.ahv, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.ahv);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void removeView() {
        if (!this.gsa) {
            this.gsa = true;
            if (this.grX != null) {
                this.grX.bQh();
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
                                f.this.bPZ();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.grX.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPZ() {
        this.gsa = false;
        if (this.grX != null) {
            this.grX.hide();
        }
        if (this.ahv.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ahv.getParent()).removeView(this.ahv);
        }
        this.mParentView = null;
        this.grX = null;
        if (this.grZ != null) {
            this.grZ.BZ();
        }
    }

    public void BL() {
        if (this.grY != null) {
            this.grY.BL();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void ee(long j) {
        if (this.grY != null) {
            this.grY.Z(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQa() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.grS == null) {
            this.grS = new h(this.mContext, this);
        }
        a(this.grS);
        if (this.grY != null) {
            this.grY.BN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQb() {
        if (this.grY != null) {
            this.grY.BO();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.grT == null) {
                this.grT = new b(this.mContext, this);
            }
            this.grT.b(dVar);
            a(this.grT);
            if (this.grY != null) {
                this.grY.X(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void W(long j) {
        if (this.grY != null) {
            this.grY.W(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void ef(long j) {
        if (this.grY != null) {
            this.grY.Y(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bM(int i, int i2) {
        if (this.grY != null) {
            this.grY.w(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void h(int i, int i2, String str) {
        if (this.grY != null) {
            this.grY.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void fK(String str) {
        if (this.grY != null) {
            this.grY.fK(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQc() {
        if (this.grU == null) {
            this.grU = new j(this.mContext, this);
        }
        bM(1, 30);
        a(this.grU);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQd() {
        if (this.grV == null) {
            this.grV = new e(this.mPageContext, this);
        }
        this.grV.FU(this.mUserId);
        fK(this.mUserId);
        a(this.grV);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQe() {
        if (this.grR == null) {
            this.grR = new c(this.mContext, this, this.eDT);
        }
        this.grY.BM();
        a(this.grR);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void bQf() {
        if (this.grZ != null) {
            this.grZ.BW();
        }
    }

    private void bQg() {
        if (this.grQ == null) {
            this.grQ = new l(this.mContext, this);
        }
        a(this.grQ);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.ahv.removeAllViews();
            if (this.grX != null) {
                this.grX.hide();
            }
            gVar.b(this.ahv, this.grX == null ? 0 : this.grX.bPQ());
            this.grX = gVar;
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void BV() {
        bPY();
        bQe();
    }

    @Override // com.baidu.live.challenge.i.l
    public void n(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.grS != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.grS.f(aVar);
        }
        if (z && aVar != null && this.grZ != null) {
            this.grZ.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void l(int i, String str) {
        if (i == 1492002) {
            bQb();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.grS != null) {
            this.grS.f(aVar);
            if (this.grZ != null) {
                this.grZ.a(aVar);
            }
        } else if (i == 0) {
            bQe();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.grT != null) {
                this.grT.e(aVar);
            }
            if (this.grZ != null) {
                this.grZ.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void h(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.grX instanceof b) {
                ((b) this.grX).bPR();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.grT != null) {
                this.grT.e(aVar);
            }
            if (this.grZ != null) {
                this.grZ.a(aVar);
            }
        } else if (i == 100) {
            bQe();
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
            if (this.grW == null) {
                this.grW = new a(this.mContext, this);
            }
            this.grW.d(aVar);
            a(this.grW);
            if (this.grZ != null) {
                this.grZ.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aCo)) {
            BdUtilHelper.showToast(this.mContext, aVar.aCo);
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
            if (dVar.aCy) {
                h(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(dVar.liveStatus == 1 ? a.i.ala_challenge_panel_host_challenging : a.i.ala_challenge_panel_host_offline));
            if (this.grX != null) {
                if (this.grX == this.grU) {
                    this.grU.j(dVar);
                } else if (this.grX == this.grV) {
                    if (!dVar.aCy) {
                        dVar.aCx = 2;
                    }
                    this.grV.a(dVar, true);
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
        if (this.grX != null) {
            if (this.grX == this.grU) {
                this.grU.bPX();
            } else if (this.grX == this.grV) {
                this.grV.bPX();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void v(List<com.baidu.live.challenge.d> list) {
        if (this.grR == null) {
            this.grR = new c(this.mContext, this, this.eDT);
        }
        this.grR.bX(list);
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
        if (this.grU != null) {
            this.grU.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0166i
    public void k(int i, String str) {
        if (this.grU != null) {
            this.grU.aQ(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void w(List<com.baidu.live.challenge.d> list) {
        if (this.grV != null) {
            this.grV.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void m(int i, String str) {
        if (this.grV != null) {
            this.grV.aQ(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(ap apVar, at atVar, at atVar2) {
        if (this.ahv.getParent() != null) {
            removeView();
            if (this.grZ != null) {
                this.grZ.BX();
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
        if (this.grZ != null) {
            this.grZ.BY();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void dG(int i) {
        if (this.grQ == null) {
            this.grQ = new l(this.mContext, this);
        }
        this.grQ.dG(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.m
    public void dE(int i) {
        this.grY.dE(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.grZ = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.grX == null) {
            return false;
        }
        return this.grX.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.ahv.getParent() != null;
    }
}
