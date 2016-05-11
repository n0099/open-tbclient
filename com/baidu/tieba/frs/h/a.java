package com.baidu.tieba.frs.h;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.c.aq;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.h {
    private FrsActivity bjB;
    private NoPressedRelativeLayout btR;
    private Animation btU;
    private Animation btV;
    private aq btS = null;
    private TbImageView btT = null;
    private int mSkinType = 3;
    private boolean btW = false;
    private float btX = 360.0f;

    public a(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.bjB = frsActivity;
        this.btR = noPressedRelativeLayout;
        Tz();
        TA();
    }

    private void Tz() {
        this.btS = new aq(this.bjB.getPageContext().getPageActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.bjB.getPageContext().getPageActivity(), t.e.ds80));
        layoutParams.addRule(12);
        this.btS.setLayoutParams(layoutParams);
        this.btR.addView(this.btS);
        this.btS.setVisibility(8);
        lr();
    }

    private void TA() {
        this.btT = new TbImageView(this.bjB.getPageContext().getPageActivity());
        int c = com.baidu.adp.lib.util.k.c(this.bjB.getPageContext().getPageActivity(), t.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c, c);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = c;
        this.btT.setLayoutParams(layoutParams);
        this.btR.addView(this.btT);
        this.btT.setVisibility(8);
    }

    private void lr() {
        this.btS.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void i(boolean z, boolean z2) {
        if (!this.btW) {
            if (z) {
                if (z2) {
                    TD();
                } else {
                    this.btS.setVisibility(0);
                }
            } else if (z2) {
                TE();
            } else {
                this.btS.setVisibility(8);
            }
        }
    }

    private void TB() {
        this.btU = AnimationUtils.loadAnimation(this.bjB.getPageContext().getPageActivity(), t.a.frs_pull_up_refresh_out);
        this.btU.setAnimationListener(new c(this));
    }

    private void TC() {
        this.btV = AnimationUtils.loadAnimation(this.bjB.getPageContext().getPageActivity(), t.a.frs_pull_up_refresh_in);
        this.btV.setAnimationListener(new d(this));
    }

    private void TD() {
        if (!af(this.btS) && !this.btS.isShown()) {
            if (this.btV == null) {
                TC();
            }
            this.btS.startAnimation(this.btV);
        }
    }

    private void TE() {
        if (!af(this.btS) && this.btS.isShown()) {
            if (this.btU == null) {
                TB();
            }
            this.btS.startAnimation(this.btU);
        }
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void SC() {
        if (this.btS != null) {
            this.btS.SO();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void SB() {
        if (this.btS != null) {
            this.btS.SN();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.btS != null) {
                this.btS.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dd(boolean z) {
        this.btW = z;
        if (this.btS != null) {
            if (z) {
                TE();
            } else {
                TD();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void j(float f) {
        if (this.btT != null) {
            if (!this.btT.isShown()) {
                this.btT.setVisibility(0);
                at.c(this.btT, t.f.icon_pop_refresh);
            }
            if (this.btT.getAnimation() != null) {
                this.btT.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.btX, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.btT.startAnimation(rotateAnimation);
            this.btX = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void Pl() {
        if (this.btT != null) {
            this.btT.clearAnimation();
            this.btT.setImageDrawable(null);
            this.btT.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void jk() {
        if (this.btT != null) {
            if (!this.btT.isShown()) {
                this.btT.setVisibility(0);
                at.c(this.btT, t.f.icon_pop_refresh);
            }
            if (this.btT.getAnimation() != null) {
                this.btT.clearAnimation();
            }
            this.btT.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bjB.getPageContext().getPageActivity(), t.a.center_head_rotate));
        }
    }
}
