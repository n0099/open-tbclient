package com.baidu.tieba.frs.j;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.view.aq;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.h {
    private FrsActivity bGh;
    private NoPressedRelativeLayout bTB;
    private Animation bTE;
    private Animation bTF;
    private aq bTC = null;
    private TbImageView bTD = null;
    private int mSkinType = 3;
    private boolean bTG = false;
    private float bTH = 360.0f;

    public d(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.bGh = frsActivity;
        this.bTB = noPressedRelativeLayout;
        aat();
        aau();
    }

    private void aat() {
        this.bTC = new aq(this.bGh.getPageContext().getPageActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.bGh.getPageContext().getPageActivity(), u.e.ds80));
        layoutParams.addRule(12);
        this.bTC.setLayoutParams(layoutParams);
        this.bTB.addView(this.bTC);
        this.bTC.setVisibility(8);
        PO();
    }

    private void aau() {
        this.bTD = new TbImageView(this.bGh.getPageContext().getPageActivity());
        int c = com.baidu.adp.lib.util.k.c(this.bGh.getPageContext().getPageActivity(), u.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c, c);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = c;
        this.bTD.setLayoutParams(layoutParams);
        this.bTB.addView(this.bTD);
        this.bTD.setVisibility(8);
    }

    private void PO() {
        this.bTC.setOnClickListener(new e(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void j(boolean z, boolean z2) {
        if (!this.bTG) {
            if (z) {
                if (z2) {
                    aax();
                } else {
                    this.bTC.setVisibility(0);
                }
            } else if (z2) {
                aay();
            } else {
                this.bTC.setVisibility(8);
            }
        }
    }

    private void aav() {
        this.bTE = AnimationUtils.loadAnimation(this.bGh.getPageContext().getPageActivity(), u.a.frs_pull_up_refresh_out);
        this.bTE.setAnimationListener(new f(this));
    }

    private void aaw() {
        this.bTF = AnimationUtils.loadAnimation(this.bGh.getPageContext().getPageActivity(), u.a.frs_pull_up_refresh_in);
        this.bTF.setAnimationListener(new g(this));
    }

    private void aax() {
        if (!aj(this.bTC) && !this.bTC.isShown()) {
            if (this.bTF == null) {
                aaw();
            }
            this.bTC.startAnimation(this.bTF);
        }
    }

    private void aay() {
        if (!aj(this.bTC) && this.bTC.isShown()) {
            if (this.bTE == null) {
                aav();
            }
            this.bTC.startAnimation(this.bTE);
        }
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Yu() {
        if (this.bTC != null) {
            this.bTC.YI();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Yt() {
        if (this.bTC != null) {
            this.bTC.YH();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bTC != null) {
                this.bTC.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dy(boolean z) {
        this.bTG = z;
        if (this.bTC != null) {
            if (z) {
                aay();
            } else {
                aax();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void t(float f) {
        if (this.bTD != null) {
            if (!this.bTD.isShown()) {
                this.bTD.setVisibility(0);
                av.c(this.bTD, u.f.icon_pop_refresh);
            }
            if (this.bTD.getAnimation() != null) {
                this.bTD.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.bTH, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.bTD.startAnimation(rotateAnimation);
            this.bTH = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void aap() {
        if (this.bTD != null) {
            this.bTD.clearAnimation();
            this.bTD.setImageDrawable(null);
            this.bTD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void jm() {
        if (this.bTD != null) {
            if (!this.bTD.isShown()) {
                this.bTD.setVisibility(0);
                av.c(this.bTD, u.f.icon_pop_refresh);
            }
            if (this.bTD.getAnimation() != null) {
                this.bTD.clearAnimation();
            }
            this.bTD.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bGh.getPageContext().getPageActivity(), u.a.center_head_rotate));
        }
    }
}
