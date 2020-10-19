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
    private final FrameLayout aih;
    private String eSg;
    private m gJG;
    private l gJH;
    private c gJI;
    private h gJJ;
    private b gJK;
    private j gJL;
    private e gJM;
    private a gJN;
    private g gJO;
    private com.baidu.live.challenge.i gJP;
    private com.baidu.live.challenge.k gJQ;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private String mUserId;
    private final Handler mHandler = new Handler();
    private boolean canUseChallenge = false;
    private int count = 0;
    private boolean gJR = false;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aih = new FrameLayout(this.mContext);
        this.aih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gJP == null || (f.this.gJP.Db() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && f.this.gJP.Db() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
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
    public void ge(String str) {
        this.eSg = str;
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.i iVar) {
        this.gJP = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.aih.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                CX();
                return;
            }
            bUK();
            bUS();
        }
    }

    private void bUK() {
        if (this.aih.getLayoutParams() == null) {
            this.mParentView.addView(this.aih, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.aih);
        }
    }

    @Override // com.baidu.live.challenge.j, com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void removeView() {
        if (!this.gJR) {
            this.gJR = true;
            if (this.gJO != null) {
                this.gJO.bUU();
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
                                f.this.bUL();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.gJO.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUL() {
        this.gJR = false;
        if (this.gJO != null) {
            this.gJO.hide();
        }
        if (this.aih.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.aih.getParent()).removeView(this.aih);
        }
        this.mParentView = null;
        this.gJO = null;
        if (this.gJQ != null) {
            this.gJQ.Dl();
        }
    }

    public void CX() {
        if (this.gJP != null) {
            this.gJP.CX();
        }
    }

    public void gc(String str) {
        if (this.gJP != null) {
            this.gJP.gc(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ew(long j) {
        if (this.gJP != null) {
            this.gJP.aa(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bUM() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.gJJ == null) {
            this.gJJ = new h(this.mContext, this);
        }
        a(this.gJJ);
        if (this.gJP != null) {
            this.gJP.CZ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bUN() {
        if (this.gJP != null) {
            this.gJP.Da();
        }
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.gJK == null) {
                this.gJK = new b(this.mContext, this);
            }
            this.gJK.b(dVar);
            a(this.gJK);
            if (this.gJP != null) {
                this.gJP.Y(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void X(long j) {
        if (this.gJP != null) {
            this.gJP.X(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void ex(long j) {
        if (this.gJP != null) {
            this.gJP.Z(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bM(int i, int i2) {
        if (this.gJP != null) {
            this.gJP.w(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void j(int i, int i2, String str) {
        if (this.gJP != null) {
            this.gJP.f(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void gd(String str) {
        if (this.gJP != null) {
            this.gJP.gd(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bUO() {
        if (this.gJL == null) {
            this.gJL = new j(this.mContext, this);
        }
        bM(1, 30);
        a(this.gJL);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bUP() {
        if (this.gJM == null) {
            this.gJM = new e(this.mPageContext, this);
        }
        this.gJM.He(this.mUserId);
        gd(this.mUserId);
        a(this.gJM);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bUQ() {
        if (this.gJI == null) {
            this.gJI = new c(this.mContext, this, this.eSg);
        }
        this.gJP.CY();
        a(this.gJI);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void bUR() {
        if (this.gJQ != null) {
            this.gJQ.Di();
        }
    }

    private void bUS() {
        if (this.gJH == null) {
            this.gJH = new l(this.mContext, this);
        }
        a(this.gJH);
    }

    private void a(g gVar) {
        if (gVar != null) {
            this.aih.removeAllViews();
            if (this.gJO != null) {
                this.gJO.hide();
            }
            gVar.b(this.aih, this.gJO == null ? 0 : this.gJO.bUC());
            this.gJO = gVar;
        }
    }

    public void bUT() {
        if (this.gJG == null) {
            this.gJG = new m(this.mContext, this);
        }
        a(this.gJG);
    }

    @Override // com.baidu.live.challenge.i.m
    public void Dh() {
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
        if (this.gJJ != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.gJJ.f(aVar);
        }
        if (z && aVar != null && this.gJQ != null) {
            this.gJQ.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void n(int i, String str) {
        if (i == 1492002) {
            bUN();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.gJJ != null) {
            this.gJJ.f(aVar);
            if (this.gJQ != null) {
                this.gJQ.a(aVar);
            }
        } else if (i == 0) {
            bUQ();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.gJK != null) {
                this.gJK.e(aVar);
            }
            if (this.gJQ != null) {
                this.gJQ.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void j(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.gJO instanceof b) {
                ((b) this.gJO).bUD();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.e
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.gJK != null) {
                this.gJK.e(aVar);
            }
            if (this.gJQ != null) {
                this.gJQ.a(aVar);
            }
        } else if (i == 100) {
            bUQ();
        } else if (i == 102) {
            if (!StringUtils.isNull(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
            }
        }
    }

    @Override // com.baidu.live.challenge.i.j
    public void d(boolean z, long j) {
        if (z) {
            bUK();
            dP(this.count);
            bUT();
            mA(this.canUseChallenge);
            if (this.gJG != null) {
                if (j >= 0) {
                    this.gJG.ey(j);
                    this.gJG.bVa();
                    return;
                }
                this.gJG.uh();
            }
        } else if (this.canUseChallenge) {
            bUK();
            bUQ();
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.sdk_can_not_use_challenge));
        }
    }

    public void mA(boolean z) {
        if (this.gJG == null) {
            this.gJG = new m(this.mContext, this);
        }
        this.gJG.bk(z);
    }

    @Override // com.baidu.live.challenge.i.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.gJN == null) {
                this.gJN = new a(this.mContext, this);
            }
            this.gJN.d(aVar);
            a(this.gJN);
            if (this.gJQ != null) {
                this.gJQ.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.aGc)) {
            BdUtilHelper.showToast(this.mContext, aVar.aGc);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.a
    public void i(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.aGm) {
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
            if (this.gJO != null) {
                if (this.gJO == this.gJL) {
                    this.gJL.j(dVar);
                } else if (this.gJO == this.gJM) {
                    this.gJM.a(dVar, true);
                }
            }
        }
    }

    @Override // com.baidu.live.challenge.i.h
    public void l(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
        if (this.gJO != null) {
            if (this.gJO == this.gJL) {
                this.gJL.bUJ();
            } else if (this.gJO == this.gJM) {
                this.gJM.bUJ();
            }
        }
    }

    @Override // com.baidu.live.challenge.i.g
    public void x(List<com.baidu.live.challenge.d> list) {
        if (this.gJI == null) {
            this.gJI = new c(this.mContext, this, this.eSg);
        }
        this.gJI.cf(list);
    }

    @Override // com.baidu.live.challenge.i.g
    public void k(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0174i
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.gJL != null) {
            this.gJL.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.i.InterfaceC0174i
    public void m(int i, String str) {
        if (this.gJL != null) {
            this.gJL.bb(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void y(List<com.baidu.live.challenge.d> list) {
        if (this.gJM != null) {
            this.gJM.setData(list);
        }
    }

    @Override // com.baidu.live.challenge.i.l
    public void o(int i, String str) {
        if (this.gJM != null) {
            this.gJM.bb(i, str);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(au auVar, ay ayVar, ay ayVar2) {
        if (this.aih.getParent() != null) {
            removeView();
            if (this.gJQ != null) {
                this.gJQ.Dj();
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
    public void Dk() {
        if (this.gJQ != null) {
            this.gJQ.Dk();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bk(boolean z) {
        this.canUseChallenge = z;
        mA(z);
    }

    @Override // com.baidu.live.challenge.j
    public void dP(int i) {
        if (this.gJH == null) {
            this.gJH = new l(this.mContext, this);
        }
        this.gJH.dP(i);
        this.count = i;
        if (this.gJG == null) {
            this.gJG = new m(this.mContext, this);
        }
        this.gJG.dP(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.n
    public void dN(int i) {
        this.gJP.dN(i);
    }

    @Override // com.baidu.live.challenge.j
    public void a(com.baidu.live.challenge.k kVar) {
        this.gJQ = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public boolean onBackKeyDown() {
        if (this.gJO == null) {
            return false;
        }
        return this.gJO.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.j
    public boolean isActive() {
        return this.aih.getParent() != null;
    }
}
