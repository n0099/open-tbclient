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
    private final FrameLayout bEf;
    private String cxs;
    private j dZV;
    private c dZW;
    private f dZX;
    private b dZY;
    private h dZZ;
    private a eaa;
    private e eab;
    private com.baidu.live.challenge.j eac;
    private l ead;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean eae = false;

    public d(Context context) {
        this.mContext = context;
        this.bEf = new FrameLayout(context);
        this.bEf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eac == null || (d.this.eac.nP() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING && d.this.eac.nP() != ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING)) {
                    d.this.removeView();
                }
            }
        });
    }

    @Override // com.baidu.live.challenge.k
    public void bU(String str) {
        this.cxs = str;
    }

    @Override // com.baidu.live.challenge.k
    public void a(com.baidu.live.challenge.j jVar) {
        this.eac = jVar;
    }

    @Override // com.baidu.live.challenge.k
    public void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null && this.bEf.getParent() == null) {
            if (this.bEf.getLayoutParams() == null) {
                viewGroup.addView(this.bEf, new ViewGroup.LayoutParams(-1, -1));
            } else {
                viewGroup.addView(this.bEf);
            }
            if (z) {
                aQG();
            } else {
                aQI();
            }
        }
    }

    @Override // com.baidu.live.challenge.k, com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void removeView() {
        if (!this.eae) {
            this.eae = true;
            if (this.eab != null) {
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
                                d.this.aQC();
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.eab.startAnimation(loadAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQC() {
        this.eae = false;
        if (this.eab != null) {
            this.eab.hide();
        }
        if (this.bEf.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.bEf.getParent()).removeView(this.bEf);
        }
        this.eab = null;
        if (this.ead != null) {
            this.ead.oc();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void cg(long j) {
        if (this.eac != null) {
            this.eac.t(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aQD() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
            return;
        }
        if (this.dZX == null) {
            this.dZX = new f(this.mContext, this);
        }
        a(this.dZX);
        if (this.eac != null) {
            this.eac.nN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aQE() {
        if (this.eac != null) {
            this.eac.nO();
        }
    }

    public void d(com.baidu.live.challenge.d dVar) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (dVar != null) {
            if (this.dZY == null) {
                this.dZY = new b(this.mContext, this);
            }
            this.dZY.b(dVar);
            a(this.dZY);
            if (this.eac != null) {
                this.eac.r(dVar.userId);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void q(long j) {
        if (this.eac != null) {
            this.eac.q(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void ch(long j) {
        if (this.eac != null) {
            this.eac.s(j);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aT(int i, int i2) {
        if (this.eac != null) {
            this.eac.m(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aQF() {
        if (this.dZZ == null) {
            this.dZZ = new h(this.mContext, this);
        }
        aT(1, 30);
        a(this.dZZ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aQG() {
        if (this.dZW == null) {
            this.dZW = new c(this.mContext, this, this.cxs);
        }
        this.eac.nM();
        a(this.dZW);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aQH() {
        if (this.ead != null) {
            this.ead.nZ();
        }
    }

    private void aQI() {
        if (this.dZV == null) {
            this.dZV = new j(this.mContext, this);
        }
        a(this.dZV);
    }

    private void a(e eVar) {
        if (eVar != null) {
            this.bEf.removeAllViews();
            if (this.eab != null) {
                this.eab.hide();
            }
            eVar.b(this.bEf, this.eab == null ? 0 : this.eab.aQz());
            this.eab = eVar;
        }
    }

    @Override // com.baidu.live.challenge.j.k
    public void a(boolean z, String str, com.baidu.live.challenge.a aVar) {
        if (this.dZX != null && (!StringUtils.isNull(str) || (z && aVar != null))) {
            this.dZX.f(aVar);
        }
        if (z && aVar != null && this.ead != null) {
            this.ead.a(aVar);
        }
    }

    @Override // com.baidu.live.challenge.j.k
    public void c(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 1 && aVar != null && this.dZX != null) {
            this.dZX.f(aVar);
            if (this.ead != null) {
                this.ead.a(aVar);
            }
        } else if (i == 0) {
            aQG();
        } else if (!StringUtils.isNull(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        } else {
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_cancle_fail));
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void a(int i, String str, com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (this.dZY != null) {
                this.dZY.e(aVar);
            }
            if (this.ead != null) {
                this.ead.a(aVar);
            }
        }
    }

    @Override // com.baidu.live.challenge.j.f
    public void b(int i, String str, com.baidu.live.challenge.a aVar) {
        if (i == 101) {
            if (this.dZY != null) {
                this.dZY.e(aVar);
            }
            if (this.ead != null) {
                this.ead.a(aVar);
            }
        } else if (i == 100) {
            aQG();
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
            if (this.eaa == null) {
                this.eaa = new a(this.mContext, this);
            }
            this.eaa.d(aVar);
            a(this.eaa);
            if (this.ead != null) {
                this.ead.a(aVar);
            }
        } else if (!StringUtils.isNull(aVar.NX)) {
            BdUtilHelper.showToast(this.mContext, aVar.NX);
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
            if (dVar.Og) {
                d(dVar);
                return;
            }
            BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.i.ala_challenge_panel_host_challenging));
            if (this.dZZ != null) {
                this.dZZ.f(dVar);
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
        if (this.dZW == null) {
            this.dZW = new c(this.mContext, this, this.cxs);
        }
        this.dZW.bD(list);
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
        if (this.dZZ != null) {
            this.dZZ.b(bVar, list);
        }
    }

    @Override // com.baidu.live.challenge.j.InterfaceC0058j
    public void j(int i, String str) {
        if (this.dZZ != null) {
            this.dZZ.Z(i, str);
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void b(v vVar, w wVar, w wVar2) {
        if (this.bEf.getParent() != null) {
            removeView();
            if (this.ead != null) {
                this.ead.oa();
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
        if (this.ead != null) {
            this.ead.ob();
        }
    }

    @Override // com.baidu.live.challenge.k
    public void aR(int i) {
        if (this.dZV == null) {
            this.dZV = new j(this.mContext, this);
        }
        this.dZV.aR(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k
    public void aT(int i) {
        this.eac.aT(i);
    }

    @Override // com.baidu.live.challenge.k
    public void a(l lVar) {
        this.ead = lVar;
    }

    @Override // com.baidu.live.challenge.k
    public boolean onBackKeyDown() {
        if (this.eab == null) {
            return false;
        }
        return this.eab.onBackKeyDown();
    }

    @Override // com.baidu.live.challenge.k
    public boolean isActive() {
        return this.bEf.getParent() != null;
    }
}
