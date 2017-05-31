package com.baidu.tieba.frs.f;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.i {
    private com.baidu.tieba.frs.r bVm;
    private NoPressedRelativeLayout cgT;
    private Animation cgV;
    private Animation cgW;
    private Animation cgX;
    private Animation cgY;
    private Animation cgZ;
    private Animation cha;
    private Animation chb;
    private Animation chc;
    private LinearLayout che;
    private LinearLayout chf;
    private EntelechyPullUpRefreshView chg;
    private EntelechyPullUpRefreshView chh;
    private EntelechyPullUpRefreshView chi;
    private TbImageView cgU = null;
    private int mSkinType = 3;
    private boolean chd = false;
    private float bxw = 360.0f;
    private boolean chj = false;
    private boolean aAt = true;
    private View.OnClickListener chk = new e(this);

    public d(com.baidu.tieba.frs.r rVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.che = null;
        this.chf = null;
        this.chg = null;
        this.chh = null;
        this.chi = null;
        this.bVm = rVar;
        this.cgT = noPressedRelativeLayout;
        adH();
        this.che = (LinearLayout) this.cgT.findViewById(w.h.frs_stick_bottom_holder);
        this.chf = (LinearLayout) this.cgT.findViewById(w.h.frs_no_stick_bottom_holder);
        this.chf = (LinearLayout) this.cgT.findViewById(w.h.frs_no_stick_bottom_holder);
        this.chi = (EntelechyPullUpRefreshView) this.cgT.findViewById(w.h.frs_stick_bottom_goto_top);
        this.chg = (EntelechyPullUpRefreshView) this.cgT.findViewById(w.h.frs_stick_bottom_reload);
        this.chh = (EntelechyPullUpRefreshView) this.cgT.findViewById(w.h.frs_no_stick_bottom_reload);
        this.chi.setOnClickListener(this.chk);
        this.chh.setOnClickListener(this.chk);
        this.chg.setOnClickListener(this.chk);
        onChangeSkinType(this.mSkinType);
        adI();
    }

    private void adG() {
        if (this.chj) {
            this.che.setVisibility(0);
            this.chf.setVisibility(8);
            return;
        }
        this.che.setVisibility(8);
        this.chf.setVisibility(0);
    }

    private void adH() {
        this.cgU = new TbImageView(this.bVm.getPageContext().getPageActivity());
        int g = com.baidu.adp.lib.util.k.g(this.bVm.getPageContext().getPageActivity(), w.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.cgU.setLayoutParams(layoutParams);
        this.cgT.addView(this.cgU);
        this.cgU.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void q(boolean z, boolean z2) {
        if (!this.chd) {
            this.aAt = z;
            if (z) {
                if (z2) {
                    adL();
                } else {
                    adG();
                }
            } else if (z2) {
                adN();
            } else {
                this.che.setVisibility(8);
                this.chf.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean abO() {
        if (this.chg == null || this.chh == null) {
            return false;
        }
        return this.aAt;
    }

    private void adI() {
        this.chb = AnimationUtils.loadAnimation(this.bVm.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.cgZ = AnimationUtils.loadAnimation(this.bVm.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.chc = AnimationUtils.loadAnimation(this.bVm.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.cha = AnimationUtils.loadAnimation(this.bVm.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.chc.setAnimationListener(new a(this.chf));
        this.chb.setAnimationListener(new b(this.chf));
        this.cha.setAnimationListener(new a(this.che));
        this.cgZ.setAnimationListener(new b(this.che));
    }

    private void adJ() {
        this.cgV = AnimationUtils.loadAnimation(this.bVm.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.cgX = AnimationUtils.loadAnimation(this.bVm.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.cgV.setAnimationListener(new a(this.che));
        this.cgX.setAnimationListener(new a(this.chf));
    }

    private void adK() {
        this.cgW = AnimationUtils.loadAnimation(this.bVm.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.cgY = AnimationUtils.loadAnimation(this.bVm.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.cgW.setAnimationListener(new b(this.che));
        this.cgY.setAnimationListener(new b(this.chf));
    }

    private void adL() {
        adM();
        if (this.cgW == null) {
            adK();
        }
        if (this.chj) {
            this.che.clearAnimation();
            this.che.startAnimation(this.cgW);
            this.chf.setVisibility(8);
            return;
        }
        this.chf.clearAnimation();
        this.chf.startAnimation(this.cgY);
        this.che.setVisibility(8);
    }

    private void adM() {
        if (this.che.getAnimation() == this.cha) {
            this.cha.cancel();
            this.che.clearAnimation();
            this.che.setVisibility(8);
        }
        if (this.che.getAnimation() == this.cgZ) {
            this.cgZ.cancel();
            this.che.clearAnimation();
            this.che.setVisibility(0);
        }
        if (this.chf.getAnimation() == this.chc) {
            this.chc.cancel();
            this.chf.clearAnimation();
            this.chf.setVisibility(8);
        }
        if (this.chf.getAnimation() == this.chb) {
            this.chb.cancel();
            this.chf.clearAnimation();
            this.chf.setVisibility(0);
        }
    }

    private boolean ad(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void adN() {
        adM();
        if (this.cgV == null) {
            adJ();
        }
        if (this.chj) {
            this.che.clearAnimation();
            this.che.startAnimation(this.cgV);
            this.chf.setVisibility(8);
            return;
        }
        this.chf.clearAnimation();
        this.chf.startAnimation(this.cgX);
        this.che.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void abQ() {
        if (this.chg != null && !ad(this.chg)) {
            this.chg.ace();
        }
        if (this.chh != null && !ad(this.chh)) {
            this.chh.ace();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void abP() {
        if (this.chg != null && !ad(this.chg)) {
            this.chg.acd();
        }
        if (this.chh != null && !ad(this.chh)) {
            this.chh.acd();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.chg != null) {
                this.chg.onChangeSkinType(i);
            }
            if (this.chh != null) {
                this.chh.onChangeSkinType(i);
            }
            if (this.chi != null) {
                this.chi.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void en(boolean z) {
        this.chd = z;
        if (this.chg != null) {
            if (z) {
                adN();
            } else {
                adL();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.i
    public void F(float f) {
        if (this.cgU != null) {
            if (!this.cgU.isShown()) {
                this.cgU.setVisibility(0);
                aq.c(this.cgU, w.g.icon_pop_refresh);
            }
            if (this.cgU.getAnimation() != null) {
                this.cgU.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.bxw, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cgU.startAnimation(rotateAnimation);
            this.bxw = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.i
    public void Tx() {
        if (this.cgU != null) {
            this.cgU.clearAnimation();
            this.cgU.setImageDrawable(null);
            this.cgU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.i
    public void lb() {
        if (this.cgU != null) {
            if (!this.cgU.isShown()) {
                this.cgU.setVisibility(0);
                aq.c(this.cgU, w.g.icon_pop_refresh);
            }
            if (this.cgU.getAnimation() != null) {
                this.cgU.clearAnimation();
            }
            this.cgU.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bVm.getPageContext().getPageActivity(), w.a.center_head_rotate));
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
