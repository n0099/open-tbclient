package com.baidu.tieba.frs.f;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.h {
    private FrsActivity bHh;
    private NoPressedRelativeLayout bUK;
    private Animation bUM;
    private Animation bUN;
    private Animation bUO;
    private Animation bUP;
    private Animation bUQ;
    private Animation bUR;
    private Animation bUS;
    private Animation bUT;
    private LinearLayout bUW;
    private LinearLayout bUX;
    private EntelechyPullUpRefreshView bUY;
    private EntelechyPullUpRefreshView bUZ;
    private EntelechyPullUpRefreshView bVa;
    private TbImageView bUL = null;
    private int mSkinType = 3;
    private boolean bUU = false;
    private float bUV = 360.0f;
    private boolean bVb = false;
    private boolean auW = true;
    private View.OnClickListener bVc = new e(this);

    public d(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.bUW = null;
        this.bUX = null;
        this.bUY = null;
        this.bUZ = null;
        this.bVa = null;
        this.bHh = frsActivity;
        this.bUK = noPressedRelativeLayout;
        acG();
        this.bUW = (LinearLayout) this.bHh.findViewById(r.h.frs_stick_bottom_holder);
        this.bUX = (LinearLayout) this.bHh.findViewById(r.h.frs_no_stick_bottom_holder);
        this.bVa = (EntelechyPullUpRefreshView) this.bHh.findViewById(r.h.frs_stick_bottom_goto_top);
        this.bUY = (EntelechyPullUpRefreshView) this.bHh.findViewById(r.h.frs_stick_bottom_reload);
        this.bUZ = (EntelechyPullUpRefreshView) this.bHh.findViewById(r.h.frs_no_stick_bottom_reload);
        this.bVa.setOnClickListener(this.bVc);
        this.bUZ.setOnClickListener(this.bVc);
        this.bUY.setOnClickListener(this.bVc);
        onChangeSkinType(this.mSkinType);
        acH();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dV(boolean z) {
        if (this.bVb != z) {
            this.bVb = z;
            acE();
        }
    }

    private void acE() {
        if (!this.bUU && this.auW) {
            acL();
            if (this.bUT == null) {
                acH();
            }
            if (this.bVb) {
                this.bUW.startAnimation(this.bUQ);
                this.bUX.startAnimation(this.bUT);
                return;
            }
            this.bUW.startAnimation(this.bUR);
            this.bUX.startAnimation(this.bUS);
        }
    }

    private void acF() {
        if (this.bVb) {
            this.bUW.setVisibility(0);
            this.bUX.setVisibility(8);
            return;
        }
        this.bUW.setVisibility(8);
        this.bUX.setVisibility(0);
    }

    private void acG() {
        this.bUL = new TbImageView(this.bHh.getPageContext().getPageActivity());
        int e = com.baidu.adp.lib.util.k.e(this.bHh.getPageContext().getPageActivity(), r.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = e;
        this.bUL.setLayoutParams(layoutParams);
        this.bUK.addView(this.bUL);
        this.bUL.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void o(boolean z, boolean z2) {
        if (!this.bUU) {
            this.auW = z;
            if (z) {
                if (z2) {
                    acK();
                } else {
                    acF();
                }
            } else if (z2) {
                acM();
            } else {
                this.bUW.setVisibility(8);
                this.bUX.setVisibility(8);
            }
        }
    }

    private void acH() {
        this.bUS = AnimationUtils.loadAnimation(this.bHh.getPageContext().getPageActivity(), r.a.frs_bottom_fade_in);
        this.bUQ = AnimationUtils.loadAnimation(this.bHh.getPageContext().getPageActivity(), r.a.frs_bottom_fade_in);
        this.bUT = AnimationUtils.loadAnimation(this.bHh.getPageContext().getPageActivity(), r.a.frs_bottom_fade_out);
        this.bUR = AnimationUtils.loadAnimation(this.bHh.getPageContext().getPageActivity(), r.a.frs_bottom_fade_out);
        this.bUT.setAnimationListener(new a(this.bUX));
        this.bUS.setAnimationListener(new b(this.bUX));
        this.bUR.setAnimationListener(new a(this.bUW));
        this.bUQ.setAnimationListener(new b(this.bUW));
    }

    private void acI() {
        this.bUM = AnimationUtils.loadAnimation(this.bHh.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_out);
        this.bUO = AnimationUtils.loadAnimation(this.bHh.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_out);
        this.bUM.setAnimationListener(new a(this.bUW));
        this.bUO.setAnimationListener(new a(this.bUX));
    }

    private void acJ() {
        this.bUN = AnimationUtils.loadAnimation(this.bHh.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_in);
        this.bUP = AnimationUtils.loadAnimation(this.bHh.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_in);
        this.bUN.setAnimationListener(new b(this.bUW));
        this.bUP.setAnimationListener(new b(this.bUX));
    }

    private void acK() {
        acL();
        if (this.bUN == null) {
            acJ();
        }
        if (this.bVb) {
            this.bUW.clearAnimation();
            this.bUW.startAnimation(this.bUN);
            this.bUX.setVisibility(8);
            return;
        }
        this.bUX.clearAnimation();
        this.bUX.startAnimation(this.bUP);
        this.bUW.setVisibility(8);
    }

    private void acL() {
        if (this.bUW.getAnimation() == this.bUR) {
            this.bUR.cancel();
            this.bUW.clearAnimation();
            this.bUW.setVisibility(8);
        }
        if (this.bUW.getAnimation() == this.bUQ) {
            this.bUQ.cancel();
            this.bUW.clearAnimation();
            this.bUW.setVisibility(0);
        }
        if (this.bUX.getAnimation() == this.bUT) {
            this.bUT.cancel();
            this.bUX.clearAnimation();
            this.bUX.setVisibility(8);
        }
        if (this.bUX.getAnimation() == this.bUS) {
            this.bUS.cancel();
            this.bUX.clearAnimation();
            this.bUX.setVisibility(0);
        }
    }

    private void acM() {
        acL();
        if (this.bUM == null) {
            acI();
        }
        if (this.bVb) {
            this.bUW.clearAnimation();
            this.bUW.startAnimation(this.bUM);
            this.bUX.setVisibility(8);
            return;
        }
        this.bUX.clearAnimation();
        this.bUX.startAnimation(this.bUO);
        this.bUW.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aae() {
        if (this.bUY != null) {
            this.bUY.aaz();
        }
        if (this.bUZ != null) {
            this.bUZ.aaz();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aad() {
        if (this.bUY != null) {
            this.bUY.aay();
        }
        if (this.bUZ != null) {
            this.bUZ.aay();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bUY != null) {
                this.bUY.onChangeSkinType(i);
            }
            if (this.bUZ != null) {
                this.bUZ.onChangeSkinType(i);
            }
            if (this.bVa != null) {
                this.bVa.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dU(boolean z) {
        this.bUU = z;
        if (this.bUY != null) {
            if (z) {
                acM();
            } else {
                acK();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void F(float f) {
        if (this.bUL != null) {
            if (!this.bUL.isShown()) {
                this.bUL.setVisibility(0);
                com.baidu.tbadk.core.util.ap.c(this.bUL, r.g.icon_pop_refresh);
            }
            if (this.bUL.getAnimation() != null) {
                this.bUL.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.bUV, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.bUL.startAnimation(rotateAnimation);
            this.bUV = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void acA() {
        if (this.bUL != null) {
            this.bUL.clearAnimation();
            this.bUL.setImageDrawable(null);
            this.bUL.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void kd() {
        if (this.bUL != null) {
            if (!this.bUL.isShown()) {
                this.bUL.setVisibility(0);
                com.baidu.tbadk.core.util.ap.c(this.bUL, r.g.icon_pop_refresh);
            }
            if (this.bUL.getAnimation() != null) {
                this.bUL.clearAnimation();
            }
            this.bUL.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bHh.getPageContext().getPageActivity(), r.a.center_head_rotate));
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
