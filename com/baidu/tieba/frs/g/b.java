package com.baidu.tieba.frs.g;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private com.baidu.tieba.frs.f cIp;
    private NoPressedRelativeLayout daa;
    private Animation dac;
    private Animation dad;
    private LinearLayout dag;
    private EntelechyPullUpRefreshView dah;
    private EntelechyPullUpRefreshView dai;
    private TbImageView dab = null;
    private int mSkinType = 3;
    private boolean dae = false;
    private float daf = 360.0f;
    private boolean aDs = true;
    private View.OnClickListener daj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cIp != null) {
                if (view == b.this.dah) {
                    TiebaStatic.eventStat(b.this.cIp.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.cIp.alw() && b.this.cIp.ale() != null) {
                        TiebaStatic.log(new ak("c11752").ac(ImageViewerConfig.FORUM_ID, b.this.cIp.getFid()).ac("obj_locate", "3"));
                        b.this.cIp.ale().startPullRefresh();
                    }
                } else if (view == b.this.dai && b.this.cIp.ale() != null && b.this.cIp.ale().getListView() != null) {
                    b.this.cIp.ale().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dag = null;
        this.dah = null;
        this.dai = null;
        this.cIp = fVar;
        this.daa = noPressedRelativeLayout;
        aqy();
        this.dag = (LinearLayout) this.daa.findViewById(d.g.frs_stick_bottom_holder);
        this.dai = (EntelechyPullUpRefreshView) this.daa.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dah = (EntelechyPullUpRefreshView) this.daa.findViewById(d.g.frs_stick_bottom_reload);
        this.dai.setOnClickListener(this.daj);
        this.dah.setOnClickListener(this.daj);
        onChangeSkinType(this.mSkinType);
    }

    private void aqy() {
        this.dab = new TbImageView(this.cIp.getPageContext().getPageActivity());
        int f = l.f(this.cIp.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = f;
        this.dab.setLayoutParams(layoutParams);
        this.daa.addView(this.dab);
        this.dab.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void v(boolean z, boolean z2) {
        if (!this.dae) {
            this.aDs = z;
            if (z) {
                if (z2) {
                    aqB();
                } else {
                    this.dag.setVisibility(0);
                }
            } else if (z2) {
                aqD();
            } else {
                this.dag.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean anF() {
        if (this.dah == null) {
            return false;
        }
        return this.aDs;
    }

    private void aqz() {
        if (this.cIp.isAdded()) {
            this.dac = AnimationUtils.loadAnimation(this.cIp.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dac.setAnimationListener(new a(this.dag));
        }
    }

    private void aqA() {
        if (this.cIp.isAdded()) {
            this.dad = AnimationUtils.loadAnimation(this.cIp.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dad.setAnimationListener(new animation.Animation$AnimationListenerC0089b(this.dag));
        }
    }

    private void aqB() {
        aqC();
        if (this.dad == null) {
            aqA();
        }
        if (this.dad != null) {
            this.dag.setVisibility(0);
            this.dag.startAnimation(this.dad);
        }
    }

    private void aqC() {
        if (this.dag != null) {
            this.dag.clearAnimation();
        }
    }

    private boolean av(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aqD() {
        aqC();
        if (this.dac == null) {
            aqz();
        }
        if (this.dac != null) {
            this.dag.startAnimation(this.dac);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void anH() {
        if (this.dah != null && !av(this.dah)) {
            this.dah.ajE();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void anG() {
        if (this.dah != null && !av(this.dah)) {
            this.dah.ajD();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dah != null) {
                this.dah.onChangeSkinType(i);
            }
            if (this.dai != null) {
                this.dai.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fk(boolean z) {
        this.dae = z;
        if (this.dah != null) {
            if (z) {
                aqD();
            } else {
                aqB();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void u(float f) {
        if (this.dab != null) {
            if (!this.dab.isShown()) {
                this.dab.setVisibility(0);
                aj.c(this.dab, d.f.icon_pop_refresh);
            }
            if (this.dab.getAnimation() != null) {
                this.dab.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.daf, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dab.startAnimation(rotateAnimation);
            this.daf = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aqr() {
        if (this.dab != null) {
            this.dab.clearAnimation();
            this.dab.setImageDrawable(null);
            this.dab.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void kU() {
        if (this.dab != null && this.cIp != null && this.cIp.getPageContext() != null) {
            if (!this.dab.isShown()) {
                this.dab.setVisibility(0);
                aj.c(this.dab, d.f.icon_pop_refresh);
            }
            if (this.dab.getAnimation() != null) {
                this.dab.clearAnimation();
            }
            this.dab.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cIp.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    /* renamed from: com.baidu.tieba.frs.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class animation.Animation$AnimationListenerC0089b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0089b(View view) {
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
