package com.baidu.tieba.frs.f;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.i {
    private com.baidu.tieba.frs.r cdv;
    private NoPressedRelativeLayout cpj;
    private Animation cpl;
    private Animation cpm;
    private Animation cpn;
    private Animation cpo;
    private Animation cpp;
    private Animation cpq;
    private Animation cpr;
    private Animation cps;
    private LinearLayout cpv;
    private LinearLayout cpw;
    private EntelechyPullUpRefreshView cpx;
    private EntelechyPullUpRefreshView cpy;
    private EntelechyPullUpRefreshView cpz;
    private TbImageView cpk = null;
    private int mSkinType = 3;
    private boolean cpt = false;
    private float cpu = 360.0f;
    private boolean cpA = false;
    private boolean aBw = true;
    private View.OnClickListener cpB = new e(this);

    public d(com.baidu.tieba.frs.r rVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cpv = null;
        this.cpw = null;
        this.cpx = null;
        this.cpy = null;
        this.cpz = null;
        this.cdv = rVar;
        this.cpj = noPressedRelativeLayout;
        ahA();
        this.cpv = (LinearLayout) this.cpj.findViewById(w.h.frs_stick_bottom_holder);
        this.cpw = (LinearLayout) this.cpj.findViewById(w.h.frs_no_stick_bottom_holder);
        this.cpz = (EntelechyPullUpRefreshView) this.cpj.findViewById(w.h.frs_stick_bottom_goto_top);
        this.cpx = (EntelechyPullUpRefreshView) this.cpj.findViewById(w.h.frs_stick_bottom_reload);
        this.cpy = (EntelechyPullUpRefreshView) this.cpj.findViewById(w.h.frs_no_stick_bottom_reload);
        this.cpz.setOnClickListener(this.cpB);
        this.cpy.setOnClickListener(this.cpB);
        this.cpx.setOnClickListener(this.cpB);
        onChangeSkinType(this.mSkinType);
        ahB();
    }

    private void ahz() {
        if (this.cpA) {
            this.cpv.setVisibility(0);
            this.cpw.setVisibility(8);
            return;
        }
        this.cpv.setVisibility(8);
        this.cpw.setVisibility(0);
    }

    private void ahA() {
        this.cpk = new TbImageView(this.cdv.getPageContext().getPageActivity());
        int g = com.baidu.adp.lib.util.k.g(this.cdv.getPageContext().getPageActivity(), w.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.cpk.setLayoutParams(layoutParams);
        this.cpj.addView(this.cpk);
        this.cpk.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void r(boolean z, boolean z2) {
        if (!this.cpt) {
            this.aBw = z;
            if (z) {
                if (z2) {
                    ahE();
                } else {
                    ahz();
                }
            } else if (z2) {
                ahG();
            } else {
                this.cpv.setVisibility(8);
                this.cpw.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean afF() {
        if (this.cpx == null || this.cpy == null) {
            return false;
        }
        return this.aBw;
    }

    private void ahB() {
        this.cpr = AnimationUtils.loadAnimation(this.cdv.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.cpp = AnimationUtils.loadAnimation(this.cdv.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.cps = AnimationUtils.loadAnimation(this.cdv.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.cpq = AnimationUtils.loadAnimation(this.cdv.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.cps.setAnimationListener(new a(this.cpw));
        this.cpr.setAnimationListener(new b(this.cpw));
        this.cpq.setAnimationListener(new a(this.cpv));
        this.cpp.setAnimationListener(new b(this.cpv));
    }

    private void ahC() {
        this.cpl = AnimationUtils.loadAnimation(this.cdv.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.cpn = AnimationUtils.loadAnimation(this.cdv.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.cpl.setAnimationListener(new a(this.cpv));
        this.cpn.setAnimationListener(new a(this.cpw));
    }

    private void ahD() {
        this.cpm = AnimationUtils.loadAnimation(this.cdv.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.cpo = AnimationUtils.loadAnimation(this.cdv.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.cpm.setAnimationListener(new b(this.cpv));
        this.cpo.setAnimationListener(new b(this.cpw));
    }

    private void ahE() {
        ahF();
        if (this.cpm == null) {
            ahD();
        }
        if (this.cpA) {
            this.cpv.clearAnimation();
            this.cpv.startAnimation(this.cpm);
            this.cpw.setVisibility(8);
            return;
        }
        this.cpw.clearAnimation();
        this.cpw.startAnimation(this.cpo);
        this.cpv.setVisibility(8);
    }

    private void ahF() {
        if (this.cpv.getAnimation() == this.cpq) {
            this.cpq.cancel();
            this.cpv.clearAnimation();
            this.cpv.setVisibility(8);
        }
        if (this.cpv.getAnimation() == this.cpp) {
            this.cpp.cancel();
            this.cpv.clearAnimation();
            this.cpv.setVisibility(0);
        }
        if (this.cpw.getAnimation() == this.cps) {
            this.cps.cancel();
            this.cpw.clearAnimation();
            this.cpw.setVisibility(8);
        }
        if (this.cpw.getAnimation() == this.cpr) {
            this.cpr.cancel();
            this.cpw.clearAnimation();
            this.cpw.setVisibility(0);
        }
    }

    private boolean ae(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void ahG() {
        ahF();
        if (this.cpl == null) {
            ahC();
        }
        if (this.cpA) {
            this.cpv.clearAnimation();
            this.cpv.startAnimation(this.cpl);
            this.cpw.setVisibility(8);
            return;
        }
        this.cpw.clearAnimation();
        this.cpw.startAnimation(this.cpn);
        this.cpv.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void afH() {
        if (this.cpx != null && !ae(this.cpx)) {
            this.cpx.afW();
        }
        if (this.cpy != null && !ae(this.cpy)) {
            this.cpy.afW();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void afG() {
        if (this.cpx != null && !ae(this.cpx)) {
            this.cpx.afV();
        }
        if (this.cpy != null && !ae(this.cpy)) {
            this.cpy.afV();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cpx != null) {
                this.cpx.onChangeSkinType(i);
            }
            if (this.cpy != null) {
                this.cpy.onChangeSkinType(i);
            }
            if (this.cpz != null) {
                this.cpz.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eF(boolean z) {
        this.cpt = z;
        if (this.cpx != null) {
            if (z) {
                ahG();
            } else {
                ahE();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.i
    public void F(float f) {
        if (this.cpk != null) {
            if (!this.cpk.isShown()) {
                this.cpk.setVisibility(0);
                as.c(this.cpk, w.g.icon_pop_refresh);
            }
            if (this.cpk.getAnimation() != null) {
                this.cpk.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cpu, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cpk.startAnimation(rotateAnimation);
            this.cpu = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.i
    public void ahs() {
        if (this.cpk != null) {
            this.cpk.clearAnimation();
            this.cpk.setImageDrawable(null);
            this.cpk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.i
    public void kZ() {
        if (this.cpk != null) {
            if (!this.cpk.isShown()) {
                this.cpk.setVisibility(0);
                as.c(this.cpk, w.g.icon_pop_refresh);
            }
            if (this.cpk.getAnimation() != null) {
                this.cpk.clearAnimation();
            }
            this.cpk.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cdv.getPageContext().getPageActivity(), w.a.center_head_rotate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Animation.AnimationListener {
        View view;

        public a(View view) {
            this.view = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.view != null) {
                this.view.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.view != null && this.view.getAnimation() == animation) {
                this.view.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Animation.AnimationListener {
        View view;

        public b(View view) {
            this.view = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.view != null) {
                this.view.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.view != null && this.view.getAnimation() == animation) {
                this.view.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
