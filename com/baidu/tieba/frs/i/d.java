package com.baidu.tieba.frs.i;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.view.ao;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.h {
    private FrsActivity bET;
    private NoPressedRelativeLayout bRB;
    private Animation bRE;
    private Animation bRF;
    private ao bRC = null;
    private TbImageView bRD = null;
    private int mSkinType = 3;
    private boolean bRG = false;
    private float bRH = 360.0f;

    public d(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.bET = frsActivity;
        this.bRB = noPressedRelativeLayout;
        ZR();
        ZS();
    }

    private void ZR() {
        this.bRC = new ao(this.bET.getPageContext().getPageActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.bET.getPageContext().getPageActivity(), u.e.ds80));
        layoutParams.addRule(12);
        this.bRC.setLayoutParams(layoutParams);
        this.bRB.addView(this.bRC);
        this.bRC.setVisibility(8);
        Pk();
    }

    private void ZS() {
        this.bRD = new TbImageView(this.bET.getPageContext().getPageActivity());
        int c = com.baidu.adp.lib.util.k.c(this.bET.getPageContext().getPageActivity(), u.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c, c);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = c;
        this.bRD.setLayoutParams(layoutParams);
        this.bRB.addView(this.bRD);
        this.bRD.setVisibility(8);
    }

    private void Pk() {
        this.bRC.setOnClickListener(new e(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void j(boolean z, boolean z2) {
        if (!this.bRG) {
            if (z) {
                if (z2) {
                    ZV();
                } else {
                    this.bRC.setVisibility(0);
                }
            } else if (z2) {
                ZW();
            } else {
                this.bRC.setVisibility(8);
            }
        }
    }

    private void ZT() {
        this.bRE = AnimationUtils.loadAnimation(this.bET.getPageContext().getPageActivity(), u.a.frs_pull_up_refresh_out);
        this.bRE.setAnimationListener(new f(this));
    }

    private void ZU() {
        this.bRF = AnimationUtils.loadAnimation(this.bET.getPageContext().getPageActivity(), u.a.frs_pull_up_refresh_in);
        this.bRF.setAnimationListener(new g(this));
    }

    private void ZV() {
        if (!al(this.bRC) && !this.bRC.isShown()) {
            if (this.bRF == null) {
                ZU();
            }
            this.bRC.startAnimation(this.bRF);
        }
    }

    private void ZW() {
        if (!al(this.bRC) && this.bRC.isShown()) {
            if (this.bRE == null) {
                ZT();
            }
            this.bRC.startAnimation(this.bRE);
        }
    }

    private boolean al(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Ya() {
        if (this.bRC != null) {
            this.bRC.Yo();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void XZ() {
        if (this.bRC != null) {
            this.bRC.Yn();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bRC != null) {
                this.bRC.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dA(boolean z) {
        this.bRG = z;
        if (this.bRC != null) {
            if (z) {
                ZW();
            } else {
                ZV();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void j(float f) {
        if (this.bRD != null) {
            if (!this.bRD.isShown()) {
                this.bRD.setVisibility(0);
                av.c(this.bRD, u.f.icon_pop_refresh);
            }
            if (this.bRD.getAnimation() != null) {
                this.bRD.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.bRH, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.bRD.startAnimation(rotateAnimation);
            this.bRH = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void US() {
        if (this.bRD != null) {
            this.bRD.clearAnimation();
            this.bRD.setImageDrawable(null);
            this.bRD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void jn() {
        if (this.bRD != null) {
            if (!this.bRD.isShown()) {
                this.bRD.setVisibility(0);
                av.c(this.bRD, u.f.icon_pop_refresh);
            }
            if (this.bRD.getAnimation() != null) {
                this.bRD.clearAnimation();
            }
            this.bRD.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bET.getPageContext().getPageActivity(), u.a.center_head_rotate));
        }
    }
}
