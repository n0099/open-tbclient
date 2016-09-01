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
import com.baidu.tieba.frs.entelechy.view.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.h {
    private FrsActivity bRp;
    private NoPressedRelativeLayout ceJ;
    private Animation ceM;
    private Animation ceN;
    private at ceK = null;
    private TbImageView ceL = null;
    private int mSkinType = 3;
    private boolean ceO = false;
    private float ceP = 360.0f;

    public d(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.bRp = frsActivity;
        this.ceJ = noPressedRelativeLayout;
        afe();
        aff();
    }

    private void afe() {
        this.ceK = new at(this.bRp.getPageContext().getPageActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.bRp.getPageContext().getPageActivity(), t.e.ds80));
        layoutParams.addRule(12);
        this.ceK.setLayoutParams(layoutParams);
        this.ceJ.addView(this.ceK);
        this.ceK.setVisibility(8);
        UA();
    }

    private void aff() {
        this.ceL = new TbImageView(this.bRp.getPageContext().getPageActivity());
        int e = com.baidu.adp.lib.util.k.e(this.bRp.getPageContext().getPageActivity(), t.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = e;
        this.ceL.setLayoutParams(layoutParams);
        this.ceJ.addView(this.ceL);
        this.ceL.setVisibility(8);
    }

    private void UA() {
        this.ceK.setOnClickListener(new e(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void n(boolean z, boolean z2) {
        if (!this.ceO) {
            if (z) {
                if (z2) {
                    afi();
                } else {
                    this.ceK.setVisibility(0);
                }
            } else if (z2) {
                afj();
            } else {
                this.ceK.setVisibility(8);
            }
        }
    }

    private void afg() {
        this.ceM = AnimationUtils.loadAnimation(this.bRp.getPageContext().getPageActivity(), t.a.frs_pull_up_refresh_out);
        this.ceM.setAnimationListener(new f(this));
    }

    private void afh() {
        this.ceN = AnimationUtils.loadAnimation(this.bRp.getPageContext().getPageActivity(), t.a.frs_pull_up_refresh_in);
        this.ceN.setAnimationListener(new g(this));
    }

    private void afi() {
        if (!aj(this.ceK) && !this.ceK.isShown()) {
            if (this.ceN == null) {
                afh();
            }
            this.ceK.startAnimation(this.ceN);
        }
    }

    private void afj() {
        if (!aj(this.ceK) && this.ceK.isShown()) {
            if (this.ceM == null) {
                afg();
            }
            this.ceK.startAnimation(this.ceM);
        }
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void adg() {
        if (this.ceK != null) {
            this.ceK.adu();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void adf() {
        if (this.ceK != null) {
            this.ceK.adt();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ceK != null) {
                this.ceK.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dU(boolean z) {
        this.ceO = z;
        if (this.ceK != null) {
            if (z) {
                afj();
            } else {
                afi();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void F(float f) {
        if (this.ceL != null) {
            if (!this.ceL.isShown()) {
                this.ceL.setVisibility(0);
                av.c(this.ceL, t.f.icon_pop_refresh);
            }
            if (this.ceL.getAnimation() != null) {
                this.ceL.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.ceP, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.ceL.startAnimation(rotateAnimation);
            this.ceP = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void afa() {
        if (this.ceL != null) {
            this.ceL.clearAnimation();
            this.ceL.setImageDrawable(null);
            this.ceL.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void kh() {
        if (this.ceL != null) {
            if (!this.ceL.isShown()) {
                this.ceL.setVisibility(0);
                av.c(this.ceL, t.f.icon_pop_refresh);
            }
            if (this.ceL.getAnimation() != null) {
                this.ceL.clearAnimation();
            }
            this.ceL.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bRp.getPageContext().getPageActivity(), t.a.center_head_rotate));
        }
    }
}
