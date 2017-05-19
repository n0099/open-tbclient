package com.baidu.tieba.frs.e;

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
    private com.baidu.tieba.frs.r bPw;
    private NoPressedRelativeLayout caH;
    private Animation caJ;
    private Animation caK;
    private Animation caL;
    private Animation caM;
    private Animation caN;
    private Animation caO;
    private Animation caP;
    private Animation caQ;
    private LinearLayout caT;
    private LinearLayout caU;
    private EntelechyPullUpRefreshView caV;
    private EntelechyPullUpRefreshView caW;
    private EntelechyPullUpRefreshView caX;
    private TbImageView caI = null;
    private int mSkinType = 3;
    private boolean caR = false;
    private float caS = 360.0f;
    private boolean caY = false;
    private boolean aAH = true;
    private View.OnClickListener caZ = new e(this);

    public d(com.baidu.tieba.frs.r rVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.caT = null;
        this.caU = null;
        this.caV = null;
        this.caW = null;
        this.caX = null;
        this.bPw = rVar;
        this.caH = noPressedRelativeLayout;
        acE();
        this.caT = (LinearLayout) this.caH.findViewById(w.h.frs_stick_bottom_holder);
        this.caU = (LinearLayout) this.caH.findViewById(w.h.frs_no_stick_bottom_holder);
        this.caU = (LinearLayout) this.caH.findViewById(w.h.frs_no_stick_bottom_holder);
        this.caX = (EntelechyPullUpRefreshView) this.caH.findViewById(w.h.frs_stick_bottom_goto_top);
        this.caV = (EntelechyPullUpRefreshView) this.caH.findViewById(w.h.frs_stick_bottom_reload);
        this.caW = (EntelechyPullUpRefreshView) this.caH.findViewById(w.h.frs_no_stick_bottom_reload);
        this.caX.setOnClickListener(this.caZ);
        this.caW.setOnClickListener(this.caZ);
        this.caV.setOnClickListener(this.caZ);
        onChangeSkinType(this.mSkinType);
        acF();
    }

    private void acD() {
        if (this.caY) {
            this.caT.setVisibility(0);
            this.caU.setVisibility(8);
            return;
        }
        this.caT.setVisibility(8);
        this.caU.setVisibility(0);
    }

    private void acE() {
        this.caI = new TbImageView(this.bPw.getPageContext().getPageActivity());
        int g = com.baidu.adp.lib.util.k.g(this.bPw.getPageContext().getPageActivity(), w.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.caI.setLayoutParams(layoutParams);
        this.caH.addView(this.caI);
        this.caI.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void n(boolean z, boolean z2) {
        if (!this.caR) {
            this.aAH = z;
            if (z) {
                if (z2) {
                    acI();
                } else {
                    acD();
                }
            } else if (z2) {
                acK();
            } else {
                this.caT.setVisibility(8);
                this.caU.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean aaK() {
        if (this.caV == null || this.caW == null) {
            return false;
        }
        return this.aAH;
    }

    private void acF() {
        this.caP = AnimationUtils.loadAnimation(this.bPw.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.caN = AnimationUtils.loadAnimation(this.bPw.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.caQ = AnimationUtils.loadAnimation(this.bPw.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.caO = AnimationUtils.loadAnimation(this.bPw.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.caQ.setAnimationListener(new a(this.caU));
        this.caP.setAnimationListener(new b(this.caU));
        this.caO.setAnimationListener(new a(this.caT));
        this.caN.setAnimationListener(new b(this.caT));
    }

    private void acG() {
        this.caJ = AnimationUtils.loadAnimation(this.bPw.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.caL = AnimationUtils.loadAnimation(this.bPw.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.caJ.setAnimationListener(new a(this.caT));
        this.caL.setAnimationListener(new a(this.caU));
    }

    private void acH() {
        this.caK = AnimationUtils.loadAnimation(this.bPw.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.caM = AnimationUtils.loadAnimation(this.bPw.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.caK.setAnimationListener(new b(this.caT));
        this.caM.setAnimationListener(new b(this.caU));
    }

    private void acI() {
        acJ();
        if (this.caK == null) {
            acH();
        }
        if (this.caY) {
            this.caT.clearAnimation();
            this.caT.startAnimation(this.caK);
            this.caU.setVisibility(8);
            return;
        }
        this.caU.clearAnimation();
        this.caU.startAnimation(this.caM);
        this.caT.setVisibility(8);
    }

    private void acJ() {
        if (this.caT.getAnimation() == this.caO) {
            this.caO.cancel();
            this.caT.clearAnimation();
            this.caT.setVisibility(8);
        }
        if (this.caT.getAnimation() == this.caN) {
            this.caN.cancel();
            this.caT.clearAnimation();
            this.caT.setVisibility(0);
        }
        if (this.caU.getAnimation() == this.caQ) {
            this.caQ.cancel();
            this.caU.clearAnimation();
            this.caU.setVisibility(8);
        }
        if (this.caU.getAnimation() == this.caP) {
            this.caP.cancel();
            this.caU.clearAnimation();
            this.caU.setVisibility(0);
        }
    }

    private boolean ad(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void acK() {
        acJ();
        if (this.caJ == null) {
            acG();
        }
        if (this.caY) {
            this.caT.clearAnimation();
            this.caT.startAnimation(this.caJ);
            this.caU.setVisibility(8);
            return;
        }
        this.caU.clearAnimation();
        this.caU.startAnimation(this.caL);
        this.caT.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aaM() {
        if (this.caV != null && !ad(this.caV)) {
            this.caV.aba();
        }
        if (this.caW != null && !ad(this.caW)) {
            this.caW.aba();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aaL() {
        if (this.caV != null && !ad(this.caV)) {
            this.caV.aaZ();
        }
        if (this.caW != null && !ad(this.caW)) {
            this.caW.aaZ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.caV != null) {
                this.caV.onChangeSkinType(i);
            }
            if (this.caW != null) {
                this.caW.onChangeSkinType(i);
            }
            if (this.caX != null) {
                this.caX.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dX(boolean z) {
        this.caR = z;
        if (this.caV != null) {
            if (z) {
                acK();
            } else {
                acI();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.i
    public void F(float f) {
        if (this.caI != null) {
            if (!this.caI.isShown()) {
                this.caI.setVisibility(0);
                aq.c(this.caI, w.g.icon_pop_refresh);
            }
            if (this.caI.getAnimation() != null) {
                this.caI.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.caS, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.caI.startAnimation(rotateAnimation);
            this.caS = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.i
    public void acw() {
        if (this.caI != null) {
            this.caI.clearAnimation();
            this.caI.setImageDrawable(null);
            this.caI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.i
    public void lb() {
        if (this.caI != null) {
            if (!this.caI.isShown()) {
                this.caI.setVisibility(0);
                aq.c(this.caI, w.g.icon_pop_refresh);
            }
            if (this.caI.getAnimation() != null) {
                this.caI.clearAnimation();
            }
            this.caI.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bPw.getPageContext().getPageActivity(), w.a.center_head_rotate));
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
