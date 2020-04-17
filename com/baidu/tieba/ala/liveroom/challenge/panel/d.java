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
import com.baidu.live.challenge.l;
import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements com.baidu.live.challenge.k, k {
    private final FrameLayout cSf;
    private String dPW;
    private j fAh;
    private c fAi;
    private f fAj;
    private b fAk;
    private h fAl;
    private a fAm;
    private e fAn;
    private com.baidu.live.challenge.j fAo;
    private l fAp;
    private Context mContext;
    private ViewGroup mParentView;
    private final Handler mHandler = new Handler();
    private boolean fAq = false;

    public d(Context context) {
        this.mContext = context;
        this.cSf = new FrameLayout(context);
        this.cSf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fAo == null || (d.this.fAo.uw() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.fAo.uw() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void dK(String str) {
        this.dPW = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.fAo = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.cSf.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                us();
                return;
            }
            bui();
            bup();
        }
    }

    private void bui() {
        if (this.cSf.getLayoutParams() == null) {
            this.mParentView.addView(this.cSf, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.cSf);
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.fAq) {
            this.fAq = true;
            if (this.fAn != null) {
                this.fAn.buq();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0128a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        d.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.buj();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.fAn.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buj() {
        this.fAq = false;
        if (this.fAn != null) {
            this.fAn.hide();
        }
        if (this.cSf.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cSf.getParent()).removeView(this.cSf);
        }
        this.mParentView = null;
        this.fAn = null;
        if (this.fAp != null) {
            this.fAp.uF();
        }
    }

    public void us() {
        if (this.fAo != null) {
            this.fAo.us();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void dB(long j) {
        if (this.fAo != null) {
            this.fAo.U(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void buk() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.fAj == null) {
            this.fAj = new f(this.mContext, this);
        }
        a(this.fAj);
        if (this.fAo != null) {
            this.fAo.uu();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bul() {
        if (this.fAo != null) {
            this.fAo.uv();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.fAk == null) {
                this.fAk = new b(this.mContext, this);
            }
            this.fAk.b(dVar);
            a(this.fAk);
            if (this.fAo != null) {
                this.fAo.S(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void R(long j) {
        if (this.fAo != null) {
            this.fAo.R(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void dC(long j) {
        if (this.fAo != null) {
            this.fAo.T(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bt(int i, int i2) {
        if (this.fAo != null) {
            this.fAo.r(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void i(int i, int i2, String str) {
        if (this.fAo != null) {
            this.fAo.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bum() {
        if (this.fAl == null) {
            this.fAl = new h(this.mContext, this);
        }
        bt(1, 30);
        a(this.fAl);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bun() {
        if (this.fAi == null) {
            this.fAi = new c(this.mContext, this, this.dPW);
        }
        this.fAo.ut();
        a(this.fAi);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void buo() {
        if (this.fAp != null) {
            this.fAp.uC();
        }
    }

    private void bup() {
        if (this.fAh == null) {
            this.fAh = new j(this.mContext, this);
        }
        a(this.fAh);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.cSf.removeAllViews();
            if (this.fAn != null) {
                this.fAn.hide();
            }
            eVar.b(this.cSf, this.fAn == null ? 0 : this.fAn.bue());
            this.fAn = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0105j
    public void uB() {
        bui();
        bun();
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0105j
    public void l(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.fAj != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.fAj.f(aVar);
        }
        if (z && aVar != null && this.fAp != null) {
            this.fAp.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void k(int i, String str) {
        if (i == 1492002) {
            bul();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.fAj != null) {
            this.fAj.f(aVar);
            if (this.fAp != null) {
                this.fAp.a(aVar);
            }
        } else if (i == 0) {
            bun();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.fAk != null) {
                this.fAk.e(aVar);
            }
            if (this.fAp != null) {
                this.fAp.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void g(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.fAn instanceof b) {
                ((b) this.fAn).buf();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.fAk != null) {
                this.fAk.e(aVar);
            }
            if (this.fAp != null) {
                this.fAp.a(aVar);
            }
        } else if (i == 100) {
            bun();
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
            if (this.fAm == null) {
                this.fAm = new a(this.mContext, this);
            }
            this.fAm.d(aVar);
            a(this.fAm);
            if (this.fAp != null) {
                this.fAp.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.apd)) {
            BdUtilHelper.showToast(this.mContext, aVar.apd);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.j.a
    public void f(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_random_fail_title));
        }
    }

    @Override // com.baidu.live.challenge.j.g
    public void a(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            if (dVar.apm) {
                d(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_challenging));
            if (this.fAl != null) {
                this.fAl.f(dVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.g
    public void i(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
        if (this.fAl != null) {
            this.fAl.buu();
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void p(List<com.baidu.live.challenge.d> list) {
        if (this.fAi == null) {
            this.fAi = new c(this.mContext, this, this.dPW);
        }
        this.fAi.bL(list);
    }

    @Override // com.baidu.live.challenge.j.f
    public void h(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_request_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (this.fAl != null) {
            this.fAl.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void j(int i, String str) {
        if (this.fAl != null) {
            this.fAl.aJ(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ag agVar, ah ahVar, ah ahVar2) {
        if (this.cSf.getParent() != null) {
            removeView();
            if (this.fAp != null) {
                this.fAp.uD();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ag agVar, ah ahVar, ah ahVar2) {
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ag agVar, ah ahVar, ah ahVar2) {
    }

    @Override // com.baidu.live.challenge.j.c
    public void e(ag agVar, ah ahVar, ah ahVar2) {
        removeView();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void uE() {
        if (this.fAp != null) {
            this.fAp.uE();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void bw(int i) {
        if (this.fAh == null) {
            this.fAh = new j(this.mContext, this);
        }
        this.fAh.bw(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void by(int i) {
        this.fAo.by(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.fAp = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.fAn == null) {
            return false;
        }
        return this.fAn.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.cSf.getParent() != null;
    }
}
