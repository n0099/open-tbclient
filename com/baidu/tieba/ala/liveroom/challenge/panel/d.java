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
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.k.a;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements com.baidu.live.challenge.k, k {
    private final FrameLayout bEW;
    private String cyj;
    private j eaM;
    private c eaN;
    private f eaO;
    private b eaP;
    private h eaQ;
    private a eaR;
    private e eaS;
    private com.baidu.live.challenge.j eaT;
    private l eaU;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean eaV = false;

    public d(Context context) {
        this.mContext = context;
        this.bEW = new FrameLayout(context);
        this.bEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eaT == null || (d.this.eaT.nP() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.eaT.nP() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void bU(String str) {
        this.cyj = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.eaT = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.bEW.getParent() == null) {
            if (this.bEW.getLayoutParams() == null) {
                viewGroup.addView(this.bEW, new ViewGroup.LayoutParams(-1, -1));
            } else {
                viewGroup.addView(this.bEW);
            }
            if (z) {
                aQI();
            } else {
                aQK();
            }
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.eaV) {
            this.eaV = true;
            if (this.eaS != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0068a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        d.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.aQE();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.eaS.startAnimation(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQE() {
        this.eaV = false;
        if (this.eaS != null) {
            this.eaS.hide();
        }
        if (this.bEW.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.bEW.getParent()).removeView(this.bEW);
        }
        this.eaS = null;
        if (this.eaU != null) {
            this.eaU.oc();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void ch(long j) {
        if (this.eaT != null) {
            this.eaT.u(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aQF() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.eaO == null) {
            this.eaO = new f(this.mContext, this);
        }
        a(this.eaO);
        if (this.eaT != null) {
            this.eaT.nN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aQG() {
        if (this.eaT != null) {
            this.eaT.nO();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.eaP == null) {
                this.eaP = new b(this.mContext, this);
            }
            this.eaP.b(dVar);
            a(this.eaP);
            if (this.eaT != null) {
                this.eaT.s(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void r(long j) {
        if (this.eaT != null) {
            this.eaT.r(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void ci(long j) {
        if (this.eaT != null) {
            this.eaT.t(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aV(int i, int i2) {
        if (this.eaT != null) {
            this.eaT.o(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aQH() {
        if (this.eaQ == null) {
            this.eaQ = new h(this.mContext, this);
        }
        aV(1, 30);
        a(this.eaQ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aQI() {
        if (this.eaN == null) {
            this.eaN = new c(this.mContext, this, this.cyj);
        }
        this.eaT.nM();
        a(this.eaN);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aQJ() {
        if (this.eaU != null) {
            this.eaU.nZ();
        }
    }

    private void aQK() {
        if (this.eaM == null) {
            this.eaM = new j(this.mContext, this);
        }
        a(this.eaM);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.bEW.removeAllViews();
            if (this.eaS != null) {
                this.eaS.hide();
            }
            eVar.b(this.bEW, this.eaS == null ? 0 : this.eaS.aQB());
            this.eaS = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.eaO != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.eaO.f(aVar);
        }
        if (z && aVar != null && this.eaU != null) {
            this.eaU.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.eaO != null) {
            this.eaO.f(aVar);
            if (this.eaU != null) {
                this.eaU.a(aVar);
            }
        } else if (i == 0) {
            aQI();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.eaP != null) {
                this.eaP.e(aVar);
            }
            if (this.eaU != null) {
                this.eaU.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.eaP != null) {
                this.eaP.e(aVar);
            }
            if (this.eaU != null) {
                this.eaU.a(aVar);
            }
        } else if (i == 100) {
            aQI();
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
            if (this.eaR == null) {
                this.eaR = new a(this.mContext, this);
            }
            this.eaR.d(aVar);
            a(this.eaR);
            if (this.eaU != null) {
                this.eaU.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.Ox)) {
            BdUtilHelper.showToast(this.mContext, aVar.Ox);
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
            if (dVar.OG) {
                d(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_challenging));
            if (this.eaQ != null) {
                this.eaQ.f(dVar);
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
    public void n(List<com.baidu.live.challenge.d> list) {
        if (this.eaN == null) {
            this.eaN = new c(this.mContext, this, this.cyj);
        }
        this.eaN.bD(list);
    }

    @Override // com.baidu.live.challenge.j.h
    public void h(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0058j
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.eaQ != null) {
            this.eaQ.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0058j
    public void j(int i, String str) {
        if (this.eaQ != null) {
            this.eaQ.aa(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void b(v vVar, w wVar, w wVar2) {
        if (this.bEW.getParent() != null) {
            removeView();
            if (this.eaU != null) {
                this.eaU.oa();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void c(v vVar, w wVar, w wVar2) {
    }

    @Override // com.baidu.live.challenge.j.e
    public void d(v vVar, w wVar, w wVar2) {
    }

    @Override // com.baidu.live.challenge.j.e
    public void e(v vVar, w wVar, w wVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void ob() {
        if (this.eaU != null) {
            this.eaU.ob();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void aR(int i) {
        if (this.eaM == null) {
            this.eaM = new j(this.mContext, this);
        }
        this.eaM.aR(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aT(int i) {
        this.eaT.aT(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.eaU = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.eaS == null) {
            return false;
        }
        return this.eaS.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.bEW.getParent() != null;
    }
}
