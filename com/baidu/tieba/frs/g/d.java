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
    private FrsActivity bQw;
    private NoPressedRelativeLayout ccU;
    private Animation ccW;
    private Animation ccX;
    private Animation ccY;
    private Animation ccZ;
    private Animation cda;
    private Animation cdb;
    private Animation cdc;
    private Animation cdd;
    private LinearLayout cdg;
    private LinearLayout cdh;
    private EntelechyPullUpRefreshView cdi;
    private EntelechyPullUpRefreshView cdj;
    private EntelechyPullUpRefreshView cdk;
    private TbImageView ccV = null;
    private int mSkinType = 3;
    private boolean cde = false;
    private float cdf = 360.0f;
    private boolean cdl = false;
    private boolean aAJ = true;
    private View.OnClickListener cdm = new e(this);

    public d(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cdg = null;
        this.cdh = null;
        this.cdi = null;
        this.cdj = null;
        this.cdk = null;
        this.bQw = frsActivity;
        this.ccU = noPressedRelativeLayout;
        aeC();
        this.cdg = (LinearLayout) this.bQw.findViewById(w.h.frs_stick_bottom_holder);
        this.cdh = (LinearLayout) this.bQw.findViewById(w.h.frs_no_stick_bottom_holder);
        this.cdk = (EntelechyPullUpRefreshView) this.bQw.findViewById(w.h.frs_stick_bottom_goto_top);
        this.cdi = (EntelechyPullUpRefreshView) this.bQw.findViewById(w.h.frs_stick_bottom_reload);
        this.cdj = (EntelechyPullUpRefreshView) this.bQw.findViewById(w.h.frs_no_stick_bottom_reload);
        this.cdk.setOnClickListener(this.cdm);
        this.cdj.setOnClickListener(this.cdm);
        this.cdi.setOnClickListener(this.cdm);
        onChangeSkinType(this.mSkinType);
        aeD();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eh(boolean z) {
        if (this.cdl != z) {
            this.cdl = z;
            aeA();
        }
    }

    private void aeA() {
        if (!this.cde && this.aAJ) {
            aeH();
            if (this.cdd == null) {
                aeD();
            }
            if (this.cdl) {
                this.cdg.startAnimation(this.cda);
                this.cdh.startAnimation(this.cdd);
                return;
            }
            this.cdg.startAnimation(this.cdb);
            this.cdh.startAnimation(this.cdc);
        }
    }

    private void aeB() {
        if (this.cdl) {
            this.cdg.setVisibility(0);
            this.cdh.setVisibility(8);
            return;
        }
        this.cdg.setVisibility(8);
        this.cdh.setVisibility(0);
    }

    private void aeC() {
        this.ccV = new TbImageView(this.bQw.getPageContext().getPageActivity());
        int g = com.baidu.adp.lib.util.k.g(this.bQw.getPageContext().getPageActivity(), w.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.ccV.setLayoutParams(layoutParams);
        this.ccU.addView(this.ccV);
        this.ccV.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void n(boolean z, boolean z2) {
        if (!this.cde) {
            this.aAJ = z;
            if (z) {
                if (z2) {
                    aeG();
                } else {
                    aeB();
                }
            } else if (z2) {
                aeI();
            } else {
                this.cdg.setVisibility(8);
                this.cdh.setVisibility(8);
            }
        }
    }

    private void aeD() {
        this.cdc = AnimationUtils.loadAnimation(this.bQw.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.cda = AnimationUtils.loadAnimation(this.bQw.getPageContext().getPageActivity(), w.a.frs_bottom_fade_in);
        this.cdd = AnimationUtils.loadAnimation(this.bQw.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.cdb = AnimationUtils.loadAnimation(this.bQw.getPageContext().getPageActivity(), w.a.frs_bottom_fade_out);
        this.cdd.setAnimationListener(new a(this.cdh));
        this.cdc.setAnimationListener(new b(this.cdh));
        this.cdb.setAnimationListener(new a(this.cdg));
        this.cda.setAnimationListener(new b(this.cdg));
    }

    private void aeE() {
        this.ccW = AnimationUtils.loadAnimation(this.bQw.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.ccY = AnimationUtils.loadAnimation(this.bQw.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_out);
        this.ccW.setAnimationListener(new a(this.cdg));
        this.ccY.setAnimationListener(new a(this.cdh));
    }

    private void aeF() {
        this.ccX = AnimationUtils.loadAnimation(this.bQw.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.ccZ = AnimationUtils.loadAnimation(this.bQw.getPageContext().getPageActivity(), w.a.frs_pull_up_refresh_in);
        this.ccX.setAnimationListener(new b(this.cdg));
        this.ccZ.setAnimationListener(new b(this.cdh));
    }

    private void aeG() {
        aeH();
        if (this.ccX == null) {
            aeF();
        }
        if (this.cdl) {
            this.cdg.clearAnimation();
            this.cdg.startAnimation(this.ccX);
            this.cdh.setVisibility(8);
            return;
        }
        this.cdh.clearAnimation();
        this.cdh.startAnimation(this.ccZ);
        this.cdg.setVisibility(8);
    }

    private void aeH() {
        if (this.cdg.getAnimation() == this.cdb) {
            this.cdb.cancel();
            this.cdg.clearAnimation();
            this.cdg.setVisibility(8);
        }
        if (this.cdg.getAnimation() == this.cda) {
            this.cda.cancel();
            this.cdg.clearAnimation();
            this.cdg.setVisibility(0);
        }
        if (this.cdh.getAnimation() == this.cdd) {
            this.cdd.cancel();
            this.cdh.clearAnimation();
            this.cdh.setVisibility(8);
        }
        if (this.cdh.getAnimation() == this.cdc) {
            this.cdc.cancel();
            this.cdh.clearAnimation();
            this.cdh.setVisibility(0);
        }
    }

    private void aeI() {
        aeH();
        if (this.ccW == null) {
            aeE();
        }
        if (this.cdl) {
            this.cdg.clearAnimation();
            this.cdg.startAnimation(this.ccW);
            this.cdh.setVisibility(8);
            return;
        }
        this.cdh.clearAnimation();
        this.cdh.startAnimation(this.ccY);
        this.cdg.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void acz() {
        if (this.cdi != null) {
            this.cdi.acT();
        }
        if (this.cdj != null) {
            this.cdj.acT();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void acy() {
        if (this.cdi != null) {
            this.cdi.acS();
        }
        if (this.cdj != null) {
            this.cdj.acS();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cdi != null) {
                this.cdi.onChangeSkinType(i);
            }
            if (this.cdj != null) {
                this.cdj.onChangeSkinType(i);
            }
            if (this.cdk != null) {
                this.cdk.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eg(boolean z) {
        this.cde = z;
        if (this.cdi != null) {
            if (z) {
                aeI();
            } else {
                aeG();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void F(float f) {
        if (this.ccV != null) {
            if (!this.ccV.isShown()) {
                this.ccV.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(this.ccV, w.g.icon_pop_refresh);
            }
            if (this.ccV.getAnimation() != null) {
                this.ccV.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cdf, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.ccV.startAnimation(rotateAnimation);
            this.cdf = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void aet() {
        if (this.ccV != null) {
            this.ccV.clearAnimation();
            this.ccV.setImageDrawable(null);
            this.ccV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void lc() {
        if (this.ccV != null) {
            if (!this.ccV.isShown()) {
                this.ccV.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(this.ccV, w.g.icon_pop_refresh);
            }
            if (this.ccV.getAnimation() != null) {
                this.ccV.clearAnimation();
            }
            this.ccV.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bQw.getPageContext().getPageActivity(), w.a.center_head_rotate));
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
