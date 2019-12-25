package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.l;
import com.baidu.live.data.y;
import com.baidu.live.data.z;
import com.baidu.live.q.a;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements com.baidu.live.challenge.k, k {
    private final FrameLayout coJ;
    private String dle;
    private j ePR;
    private c ePS;
    private f ePT;
    private b ePU;
    private h ePV;
    private a ePW;
    private e ePX;
    private com.baidu.live.challenge.j ePY;
    private l ePZ;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean eQa = false;

    public d(Context context) {
        this.mContext = context;
        this.coJ = new FrameLayout(context);
        this.coJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ePY == null || (d.this.ePY.ph() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.ePY.ph() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void cL(String str) {
        this.dle = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.ePY = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.coJ.getParent() == null) {
            if (this.coJ.getLayoutParams() == null) {
                viewGroup.addView(this.coJ, new ViewGroup.LayoutParams(-1, -1));
            } else {
                viewGroup.addView(this.coJ);
            }
            if (z) {
                bik();
            } else {
                bim();
            }
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.eQa) {
            this.eQa = true;
            if (this.ePX != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0086a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        d.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.big();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.ePX.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void big() {
        this.eQa = false;
        if (this.ePX != null) {
            this.ePX.hide();
        }
        if (this.coJ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.coJ.getParent()).removeView(this.coJ);
        }
        this.ePX = null;
        if (this.ePZ != null) {
            this.ePZ.pu();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cM(long j) {
        if (this.ePY != null) {
            this.ePY.v(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bih() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.ePT == null) {
            this.ePT = new f(this.mContext, this);
        }
        a(this.ePT);
        if (this.ePY != null) {
            this.ePY.pf();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bii() {
        if (this.ePY != null) {
            this.ePY.pg();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.ePU == null) {
                this.ePU = new b(this.mContext, this);
            }
            this.ePU.b(dVar);
            a(this.ePU);
            if (this.ePY != null) {
                this.ePY.t(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void s(long j) {
        if (this.ePY != null) {
            this.ePY.s(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cN(long j) {
        if (this.ePY != null) {
            this.ePY.u(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bj(int i, int i2) {
        if (this.ePY != null) {
            this.ePY.n(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bij() {
        if (this.ePV == null) {
            this.ePV = new h(this.mContext, this);
        }
        bj(1, 30);
        a(this.ePV);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bik() {
        if (this.ePS == null) {
            this.ePS = new c(this.mContext, this, this.dle);
        }
        this.ePY.pe();
        a(this.ePS);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bil() {
        if (this.ePZ != null) {
            this.ePZ.pr();
        }
    }

    private void bim() {
        if (this.ePR == null) {
            this.ePR = new j(this.mContext, this);
        }
        a(this.ePR);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.coJ.removeAllViews();
            if (this.ePX != null) {
                this.ePX.hide();
            }
            eVar.b(this.coJ, this.ePX == null ? 0 : this.ePX.bic());
            this.ePX = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.ePT != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.ePT.f(aVar);
        }
        if (z && aVar != null && this.ePZ != null) {
            this.ePZ.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.ePT != null) {
            this.ePT.f(aVar);
            if (this.ePZ != null) {
                this.ePZ.a(aVar);
            }
        } else if (i == 0) {
            bik();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.ePU != null) {
                this.ePU.e(aVar);
            }
            if (this.ePZ != null) {
                this.ePZ.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.ePU != null) {
                this.ePU.e(aVar);
            }
            if (this.ePZ != null) {
                this.ePZ.a(aVar);
            }
        } else if (i == 100) {
            bik();
        } else if (i == 102) {
            if (!StringUtils.isNull(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            } else {
                BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
            }
        }
    }

    @Override // com.baidu.live.challenge.j.a
    public void a(boolean z, com.baidu.live.challenge.a aVar) {
        if (aVar == null) {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        } else if (z) {
            if (this.ePW == null) {
                this.ePW = new a(this.mContext, this);
            }
            this.ePW.d(aVar);
            a(this.ePW);
            if (this.ePZ != null) {
                this.ePZ.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.UU)) {
            BdUtilHelper.showToast(this.mContext, aVar.UU);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.j.a
    public void g(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.Ve) {
                d(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_challenging));
            if (this.ePV != null) {
                this.ePV.f(dVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void i(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void m(List<com.baidu.live.challenge.d> list) {
        if (this.ePS == null) {
            this.ePS = new c(this.mContext, this, this.dle);
        }
        this.ePS.bC(list);
    }

    @Override // com.baidu.live.challenge.j.h
    public void h(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0074j
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.ePV != null) {
            this.ePV.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0074j
    public void j(int i, String str) {
        if (this.ePV != null) {
            this.ePV.ao(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void b(y yVar, z zVar, z zVar2) {
        if (this.coJ.getParent() != null) {
            removeView();
            if (this.ePZ != null) {
                this.ePZ.ps();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void c(y yVar, z zVar, z zVar2) {
    }

    @Override // com.baidu.live.challenge.j.e
    public void d(y yVar, z zVar, z zVar2) {
    }

    @Override // com.baidu.live.challenge.j.e
    public void e(y yVar, z zVar, z zVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void pt() {
        if (this.ePZ != null) {
            this.ePZ.pt();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void bc(int i) {
        if (this.ePR == null) {
            this.ePR = new j(this.mContext, this);
        }
        this.ePR.bc(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void be(int i) {
        this.ePY.be(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.ePZ = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.ePX == null) {
            return false;
        }
        return this.ePX.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.coJ.getParent() != null;
    }
}
