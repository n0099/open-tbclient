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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.h {
    private FrsActivity bOq;
    private NoPressedRelativeLayout ccc;
    private Animation cce;
    private Animation ccf;
    private Animation ccg;
    private Animation cch;
    private Animation cci;
    private Animation ccj;
    private Animation cck;
    private Animation ccl;
    private LinearLayout cco;
    private LinearLayout ccp;
    private EntelechyPullUpRefreshView ccq;
    private EntelechyPullUpRefreshView ccr;
    private EntelechyPullUpRefreshView ccs;
    private TbImageView ccd = null;
    private int mSkinType = 3;
    private boolean ccm = false;
    private float ccn = 360.0f;
    private boolean cct = false;
    private boolean aAr = true;
    private View.OnClickListener ccu = new e(this);

    public d(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cco = null;
        this.ccp = null;
        this.ccq = null;
        this.ccr = null;
        this.ccs = null;
        this.bOq = frsActivity;
        this.ccc = noPressedRelativeLayout;
        adG();
        this.cco = (LinearLayout) this.bOq.findViewById(w.h.frs_stick_bottom_holder);
        this.ccp = (LinearLayout) this.bOq.findViewById(w.h.frs_no_stick_bottom_holder);
        this.ccs = (EntelechyPullUpRefreshView) this.bOq.findViewById(w.h.frs_stick_bottom_goto_top);
        this.ccq = (EntelechyPullUpRefreshView) this.bOq.findViewById(w.h.frs_stick_bottom_reload);
        this.ccr = (EntelechyPullUpRefreshView) this.bOq.findViewById(w.h.frs_no_stick_bottom_reload);
        this.ccs.setOnClickListener(this.ccu);
        this.ccr.setOnClickListener(this.ccu);
        this.ccq.setOnClickListener(this.ccu);
        onChangeSkinType(this.mSkinType);
        adH();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dV(boolean z) {
        if (this.cct != z) {
            this.cct = z;
            adE();
        }
    }

    private void adE() {
        if (!this.ccm && this.aAr) {
            adL();
            if (this.ccl == null) {
                adH();
            }
            if (this.cct) {
                this.cco.startAnimation(this.cci);
                this.ccp.startAnimation(this.ccl);
                return;
            }
            this.cco.startAnimation(this.ccj);
            this.ccp.startAnimation(this.cck);
        }
    }

    private void adF() {
        if (this.cct) {
            this.cco.setVisibility(0);
            this.ccp.setVisibility(8);
            return;
        }
        this.cco.setVisibility(8);
        this.ccp.setVisibility(0);
    }

    private void adG() {
        this.ccd = new TbImageView(this.bOq.getPageContext().getPageActivity());
        int g = com.baidu.adp.lib.util.k.g(this.bOq.getPageContext().getPageActivity(), w.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.ccd.setLayoutParams(layoutParams);
        this.ccc.addView(this.ccd);
        this.ccd.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void n(boolean z, boolean z2) {
        if (!this.ccm) {
            this.aAr = z;
            if (z) {
                if (z2) {
                    adK();
                } else {
                    adF();
                }
            } else if (z2) {
                adM();
            } else {
                this.cco.setVisibility(8);
                this.ccp.setVisibility(8);
            }
        }
    }

    private void adH() {
        this.cck = AnimationUtils.loadAnimation(this.bOq.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.cci = AnimationUtils.loadAnimation(this.bOq.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.ccl = AnimationUtils.loadAnimation(this.bOq.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.ccj = AnimationUtils.loadAnimation(this.bOq.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.ccl.setAnimationListener(new a(this.ccp));
        this.cck.setAnimationListener(new b(this.ccp));
        this.ccj.setAnimationListener(new a(this.cco));
        this.cci.setAnimationListener(new b(this.cco));
    }

    private void adI() {
        this.cce = AnimationUtils.loadAnimation(this.bOq.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.ccg = AnimationUtils.loadAnimation(this.bOq.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.cce.setAnimationListener(new a(this.cco));
        this.ccg.setAnimationListener(new a(this.ccp));
    }

    private void adJ() {
        this.ccf = AnimationUtils.loadAnimation(this.bOq.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.cch = AnimationUtils.loadAnimation(this.bOq.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.ccf.setAnimationListener(new b(this.cco));
        this.cch.setAnimationListener(new b(this.ccp));
    }

    private void adK() {
        adL();
        if (this.ccf == null) {
            adJ();
        }
        if (this.cct) {
            this.cco.clearAnimation();
            this.cco.startAnimation(this.ccf);
            this.ccp.setVisibility(8);
            return;
        }
        this.ccp.clearAnimation();
        this.ccp.startAnimation(this.cch);
        this.cco.setVisibility(8);
    }

    private void adL() {
        if (this.cco.getAnimation() == this.ccj) {
            this.ccj.cancel();
            this.cco.clearAnimation();
            this.cco.setVisibility(8);
        }
        if (this.cco.getAnimation() == this.cci) {
            this.cci.cancel();
            this.cco.clearAnimation();
            this.cco.setVisibility(0);
        }
        if (this.ccp.getAnimation() == this.ccl) {
            this.ccl.cancel();
            this.ccp.clearAnimation();
            this.ccp.setVisibility(8);
        }
        if (this.ccp.getAnimation() == this.cck) {
            this.cck.cancel();
            this.ccp.clearAnimation();
            this.ccp.setVisibility(0);
        }
    }

    private void adM() {
        adL();
        if (this.cce == null) {
            adI();
        }
        if (this.cct) {
            this.cco.clearAnimation();
            this.cco.startAnimation(this.cce);
            this.ccp.setVisibility(8);
            return;
        }
        this.ccp.clearAnimation();
        this.ccp.startAnimation(this.ccg);
        this.cco.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void abb() {
        if (this.ccq != null) {
            this.ccq.abw();
        }
        if (this.ccr != null) {
            this.ccr.abw();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aba() {
        if (this.ccq != null) {
            this.ccq.abv();
        }
        if (this.ccr != null) {
            this.ccr.abv();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ccq != null) {
                this.ccq.onChangeSkinType(i);
            }
            if (this.ccr != null) {
                this.ccr.onChangeSkinType(i);
            }
            if (this.ccs != null) {
                this.ccs.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dU(boolean z) {
        this.ccm = z;
        if (this.ccq != null) {
            if (z) {
                adM();
            } else {
                adK();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void F(float f) {
        if (this.ccd != null) {
            if (!this.ccd.isShown()) {
                this.ccd.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(this.ccd, w.g.icon_pop_refresh);
            }
            if (this.ccd.getAnimation() != null) {
                this.ccd.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.ccn, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.ccd.startAnimation(rotateAnimation);
            this.ccn = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void ady() {
        if (this.ccd != null) {
            this.ccd.clearAnimation();
            this.ccd.setImageDrawable(null);
            this.ccd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void kX() {
        if (this.ccd != null) {
            if (!this.ccd.isShown()) {
                this.ccd.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(this.ccd, w.g.icon_pop_refresh);
            }
            if (this.ccd.getAnimation() != null) {
                this.ccd.clearAnimation();
            }
            this.ccd.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bOq.getPageContext().getPageActivity(), w.a.center_head_rotate));
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
