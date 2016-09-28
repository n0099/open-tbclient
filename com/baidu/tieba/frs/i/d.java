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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.h {
    private FrsActivity bRi;
    private NoPressedRelativeLayout ceI;
    private Animation ceL;
    private Animation ceM;
    private at ceJ = null;
    private TbImageView ceK = null;
    private int mSkinType = 3;
    private boolean ceN = false;
    private float ceO = 360.0f;

    public d(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.bRi = frsActivity;
        this.ceI = noPressedRelativeLayout;
        afs();
        aft();
    }

    private void afs() {
        this.ceJ = new at(this.bRi.getPageContext().getPageActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.bRi.getPageContext().getPageActivity(), r.e.ds80));
        layoutParams.addRule(12);
        this.ceJ.setLayoutParams(layoutParams);
        this.ceI.addView(this.ceJ);
        this.ceJ.setVisibility(8);
        UT();
    }

    private void aft() {
        this.ceK = new TbImageView(this.bRi.getPageContext().getPageActivity());
        int e = com.baidu.adp.lib.util.k.e(this.bRi.getPageContext().getPageActivity(), r.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = e;
        this.ceK.setLayoutParams(layoutParams);
        this.ceI.addView(this.ceK);
        this.ceK.setVisibility(8);
    }

    private void UT() {
        this.ceJ.setOnClickListener(new e(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void n(boolean z, boolean z2) {
        if (!this.ceN) {
            if (z) {
                if (z2) {
                    afw();
                } else {
                    this.ceJ.setVisibility(0);
                }
            } else if (z2) {
                afx();
            } else {
                this.ceJ.setVisibility(8);
            }
        }
    }

    private void afu() {
        this.ceL = AnimationUtils.loadAnimation(this.bRi.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_out);
        this.ceL.setAnimationListener(new f(this));
    }

    private void afv() {
        this.ceM = AnimationUtils.loadAnimation(this.bRi.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_in);
        this.ceM.setAnimationListener(new g(this));
    }

    private void afw() {
        if (!ai(this.ceJ) && !this.ceJ.isShown()) {
            if (this.ceM == null) {
                afv();
            }
            this.ceJ.startAnimation(this.ceM);
        }
    }

    private void afx() {
        if (!ai(this.ceJ) && this.ceJ.isShown()) {
            if (this.ceL == null) {
                afu();
            }
            this.ceJ.startAnimation(this.ceL);
        }
    }

    private boolean ai(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void adu() {
        if (this.ceJ != null) {
            this.ceJ.adI();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void adt() {
        if (this.ceJ != null) {
            this.ceJ.adH();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ceJ != null) {
                this.ceJ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dV(boolean z) {
        this.ceN = z;
        if (this.ceJ != null) {
            if (z) {
                afx();
            } else {
                afw();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void F(float f) {
        if (this.ceK != null) {
            if (!this.ceK.isShown()) {
                this.ceK.setVisibility(0);
                av.c(this.ceK, r.f.icon_pop_refresh);
            }
            if (this.ceK.getAnimation() != null) {
                this.ceK.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.ceO, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.ceK.startAnimation(rotateAnimation);
            this.ceO = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void afo() {
        if (this.ceK != null) {
            this.ceK.clearAnimation();
            this.ceK.setImageDrawable(null);
            this.ceK.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void kh() {
        if (this.ceK != null) {
            if (!this.ceK.isShown()) {
                this.ceK.setVisibility(0);
                av.c(this.ceK, r.f.icon_pop_refresh);
            }
            if (this.ceK.getAnimation() != null) {
                this.ceK.clearAnimation();
            }
            this.ceK.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bRi.getPageContext().getPageActivity(), r.a.center_head_rotate));
        }
    }
}
