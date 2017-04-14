package com.baidu.tieba.frs.g;

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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.h {
    private FrsActivity bOf;
    private NoPressedRelativeLayout caD;
    private Animation caF;
    private Animation caG;
    private Animation caH;
    private Animation caI;
    private Animation caJ;
    private Animation caK;
    private Animation caL;
    private Animation caM;
    private LinearLayout caP;
    private LinearLayout caQ;
    private EntelechyPullUpRefreshView caR;
    private EntelechyPullUpRefreshView caS;
    private EntelechyPullUpRefreshView caT;
    private TbImageView caE = null;
    private int mSkinType = 3;
    private boolean caN = false;
    private float caO = 360.0f;
    private boolean caU = false;
    private boolean aAH = true;
    private View.OnClickListener caV = new e(this);

    public d(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.caP = null;
        this.caQ = null;
        this.caR = null;
        this.caS = null;
        this.caT = null;
        this.bOf = frsActivity;
        this.caD = noPressedRelativeLayout;
        adB();
        this.caP = (LinearLayout) this.bOf.findViewById(w.h.frs_stick_bottom_holder);
        this.caQ = (LinearLayout) this.bOf.findViewById(w.h.frs_no_stick_bottom_holder);
        this.caT = (EntelechyPullUpRefreshView) this.bOf.findViewById(w.h.frs_stick_bottom_goto_top);
        this.caR = (EntelechyPullUpRefreshView) this.bOf.findViewById(w.h.frs_stick_bottom_reload);
        this.caS = (EntelechyPullUpRefreshView) this.bOf.findViewById(w.h.frs_no_stick_bottom_reload);
        this.caT.setOnClickListener(this.caV);
        this.caS.setOnClickListener(this.caV);
        this.caR.setOnClickListener(this.caV);
        onChangeSkinType(this.mSkinType);
        adC();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dX(boolean z) {
        if (this.caU != z) {
            this.caU = z;
            adz();
        }
    }

    private void adz() {
        if (!this.caN && this.aAH) {
            adG();
            if (this.caM == null) {
                adC();
            }
            if (this.caU) {
                this.caP.startAnimation(this.caJ);
                this.caQ.startAnimation(this.caM);
                return;
            }
            this.caP.startAnimation(this.caK);
            this.caQ.startAnimation(this.caL);
        }
    }

    private void adA() {
        if (this.caU) {
            this.caP.setVisibility(0);
            this.caQ.setVisibility(8);
            return;
        }
        this.caP.setVisibility(8);
        this.caQ.setVisibility(0);
    }

    private void adB() {
        this.caE = new TbImageView(this.bOf.getPageContext().getPageActivity());
        int g = com.baidu.adp.lib.util.k.g(this.bOf.getPageContext().getPageActivity(), w.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.caE.setLayoutParams(layoutParams);
        this.caD.addView(this.caE);
        this.caE.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void n(boolean z, boolean z2) {
        if (!this.caN) {
            this.aAH = z;
            if (z) {
                if (z2) {
                    adF();
                } else {
                    adA();
                }
            } else if (z2) {
                adH();
            } else {
                this.caP.setVisibility(8);
                this.caQ.setVisibility(8);
            }
        }
    }

    private void adC() {
        this.caL = AnimationUtils.loadAnimation(this.bOf.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.caJ = AnimationUtils.loadAnimation(this.bOf.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.caM = AnimationUtils.loadAnimation(this.bOf.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.caK = AnimationUtils.loadAnimation(this.bOf.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.caM.setAnimationListener(new a(this.caQ));
        this.caL.setAnimationListener(new b(this.caQ));
        this.caK.setAnimationListener(new a(this.caP));
        this.caJ.setAnimationListener(new b(this.caP));
    }

    private void adD() {
        this.caF = AnimationUtils.loadAnimation(this.bOf.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.caH = AnimationUtils.loadAnimation(this.bOf.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.caF.setAnimationListener(new a(this.caP));
        this.caH.setAnimationListener(new a(this.caQ));
    }

    private void adE() {
        this.caG = AnimationUtils.loadAnimation(this.bOf.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.caI = AnimationUtils.loadAnimation(this.bOf.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.caG.setAnimationListener(new b(this.caP));
        this.caI.setAnimationListener(new b(this.caQ));
    }

    private void adF() {
        adG();
        if (this.caG == null) {
            adE();
        }
        if (this.caU) {
            this.caP.clearAnimation();
            this.caP.startAnimation(this.caG);
            this.caQ.setVisibility(8);
            return;
        }
        this.caQ.clearAnimation();
        this.caQ.startAnimation(this.caI);
        this.caP.setVisibility(8);
    }

    private void adG() {
        if (this.caP.getAnimation() == this.caK) {
            this.caK.cancel();
            this.caP.clearAnimation();
            this.caP.setVisibility(8);
        }
        if (this.caP.getAnimation() == this.caJ) {
            this.caJ.cancel();
            this.caP.clearAnimation();
            this.caP.setVisibility(0);
        }
        if (this.caQ.getAnimation() == this.caM) {
            this.caM.cancel();
            this.caQ.clearAnimation();
            this.caQ.setVisibility(8);
        }
        if (this.caQ.getAnimation() == this.caL) {
            this.caL.cancel();
            this.caQ.clearAnimation();
            this.caQ.setVisibility(0);
        }
    }

    private void adH() {
        adG();
        if (this.caF == null) {
            adD();
        }
        if (this.caU) {
            this.caP.clearAnimation();
            this.caP.startAnimation(this.caF);
            this.caQ.setVisibility(8);
            return;
        }
        this.caQ.clearAnimation();
        this.caQ.startAnimation(this.caH);
        this.caP.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aby() {
        if (this.caR != null) {
            this.caR.abS();
        }
        if (this.caS != null) {
            this.caS.abS();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void abx() {
        if (this.caR != null) {
            this.caR.abR();
        }
        if (this.caS != null) {
            this.caS.abR();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.caR != null) {
                this.caR.onChangeSkinType(i);
            }
            if (this.caS != null) {
                this.caS.onChangeSkinType(i);
            }
            if (this.caT != null) {
                this.caT.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dW(boolean z) {
        this.caN = z;
        if (this.caR != null) {
            if (z) {
                adH();
            } else {
                adF();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void F(float f) {
        if (this.caE != null) {
            if (!this.caE.isShown()) {
                this.caE.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(this.caE, w.g.icon_pop_refresh);
            }
            if (this.caE.getAnimation() != null) {
                this.caE.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.caO, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.caE.startAnimation(rotateAnimation);
            this.caO = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void ads() {
        if (this.caE != null) {
            this.caE.clearAnimation();
            this.caE.setImageDrawable(null);
            this.caE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void lb() {
        if (this.caE != null) {
            if (!this.caE.isShown()) {
                this.caE.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(this.caE, w.g.icon_pop_refresh);
            }
            if (this.caE.getAnimation() != null) {
                this.caE.clearAnimation();
            }
            this.caE.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bOf.getPageContext().getPageActivity(), w.a.center_head_rotate));
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
