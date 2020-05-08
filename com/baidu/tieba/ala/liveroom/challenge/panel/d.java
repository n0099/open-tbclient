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
    private final FrameLayout cSk;
    private String dQb;
    private j fAm;
    private c fAn;
    private f fAo;
    private b fAp;
    private h fAq;
    private a fAr;
    private e fAs;
    private com.baidu.live.challenge.j fAt;
    private l fAu;
    private Context mContext;
    private ViewGroup mParentView;
    private final Handler mHandler = new Handler();
    private boolean fAv = false;

    public d(Context context) {
        this.mContext = context;
        this.cSk = new FrameLayout(context);
        this.cSk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fAt == null || (d.this.fAt.uv() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.fAt.uv() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void dK(String str) {
        this.dQb = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.fAt = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.cSk.getParent() == null) {
            this.mParentView = viewGroup;
            if (z) {
                ur();
                return;
            }
            bug();
            bun();
        }
    }

    private void bug() {
        if (this.cSk.getLayoutParams() == null) {
            this.mParentView.addView(this.cSk, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.mParentView.addView(this.cSk);
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.fAv) {
            this.fAv = true;
            if (this.fAs != null) {
                this.fAs.buo();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0149a.sdk_push_up_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        d.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.buh();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.fAs.b(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buh() {
        this.fAv = false;
        if (this.fAs != null) {
            this.fAs.hide();
        }
        if (this.cSk.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cSk.getParent()).removeView(this.cSk);
        }
        this.mParentView = null;
        this.fAs = null;
        if (this.fAu != null) {
            this.fAu.uE();
        }
    }

    public void ur() {
        if (this.fAt != null) {
            this.fAt.ur();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void dB(long j) {
        if (this.fAt != null) {
            this.fAt.U(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bui() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.fAo == null) {
            this.fAo = new f(this.mContext, this);
        }
        a(this.fAo);
        if (this.fAt != null) {
            this.fAt.ut();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void buj() {
        if (this.fAt != null) {
            this.fAt.uu();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.fAp == null) {
                this.fAp = new b(this.mContext, this);
            }
            this.fAp.b(dVar);
            a(this.fAp);
            if (this.fAt != null) {
                this.fAt.S(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void R(long j) {
        if (this.fAt != null) {
            this.fAt.R(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void dC(long j) {
        if (this.fAt != null) {
            this.fAt.T(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bt(int i, int i2) {
        if (this.fAt != null) {
            this.fAt.r(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void i(int i, int i2, String str) {
        if (this.fAt != null) {
            this.fAt.e(i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void buk() {
        if (this.fAq == null) {
            this.fAq = new h(this.mContext, this);
        }
        bt(1, 30);
        a(this.fAq);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bul() {
        if (this.fAn == null) {
            this.fAn = new c(this.mContext, this, this.dQb);
        }
        this.fAt.us();
        a(this.fAn);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void bum() {
        if (this.fAu != null) {
            this.fAu.uB();
        }
    }

    private void bun() {
        if (this.fAm == null) {
            this.fAm = new j(this.mContext, this);
        }
        a(this.fAm);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.cSk.removeAllViews();
            if (this.fAs != null) {
                this.fAs.hide();
            }
            eVar.b(this.cSk, this.fAs == null ? 0 : this.fAs.buc());
            this.fAs = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0126j
    public void uA() {
        bug();
        bul();
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0126j
    public void l(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.fAo != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.fAo.f(aVar);
        }
        if (z && aVar != null && this.fAu != null) {
            this.fAu.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void k(int i, String str) {
        if (i == 1492002) {
            buj();
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.i
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.fAo != null) {
            this.fAo.f(aVar);
            if (this.fAu != null) {
                this.fAu.a(aVar);
            }
        } else if (i == 0) {
            bul();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.fAp != null) {
                this.fAp.e(aVar);
            }
            if (this.fAu != null) {
                this.fAu.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void g(int i, String str) {
        if (i == 1492002) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext, str);
            }
            if (this.fAs instanceof b) {
                ((b) this.fAs).bud();
            }
        }
    }

    @Override // com.baidu.live.challenge.j.d
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.fAp != null) {
                this.fAp.e(aVar);
            }
            if (this.fAu != null) {
                this.fAu.a(aVar);
            }
        } else if (i == 100) {
            bul();
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
            if (this.fAr == null) {
                this.fAr = new a(this.mContext, this);
            }
            this.fAr.d(aVar);
            a(this.fAr);
            if (this.fAu != null) {
                this.fAu.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.apj)) {
            BdUtilHelper.showToast(this.mContext, aVar.apj);
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
            if (dVar.apt) {
                d(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_challenging));
            if (this.fAq != null) {
                this.fAq.f(dVar);
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
        if (this.fAq != null) {
            this.fAq.bus();
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void p(List<com.baidu.live.challenge.d> list) {
        if (this.fAn == null) {
            this.fAn = new c(this.mContext, this, this.dQb);
        }
        this.fAn.bL(list);
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
        if (this.fAq != null) {
            this.fAq.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.h
    public void j(int i, String str) {
        if (this.fAq != null) {
            this.fAq.aJ(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ag agVar, ah ahVar, ah ahVar2) {
        if (this.cSk.getParent() != null) {
            removeView();
            if (this.fAu != null) {
                this.fAu.uC();
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
    public void uD() {
        if (this.fAu != null) {
            this.fAu.uD();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void bw(int i) {
        if (this.fAm == null) {
            this.fAm = new j(this.mContext, this);
        }
        this.fAm.bw(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void by(int i) {
        this.fAt.by(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.fAu = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.fAs == null) {
            return false;
        }
        return this.fAs.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.cSk.getParent() != null;
    }
}
