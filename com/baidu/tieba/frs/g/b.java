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
    private com.baidu.tieba.frs.g cIC;
    private EntelechyPullUpRefreshView daA;
    private NoPressedRelativeLayout daq;
    private Animation das;
    private Animation dau;
    private LinearLayout dax;
    private EntelechyPullUpRefreshView daz;
    private TbImageView dar = null;
    private int mSkinType = 3;
    private boolean dav = false;
    private float daw = 360.0f;
    private boolean aDA = true;
    private View.OnClickListener daB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cIC != null) {
                if (view == b.this.daz) {
                    TiebaStatic.eventStat(b.this.cIC.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.cIC.alF() && b.this.cIC.aln() != null) {
                        TiebaStatic.log(new ak("c11752").ac(ImageViewerConfig.FORUM_ID, b.this.cIC.getFid()).ac("obj_locate", "3"));
                        b.this.cIC.aln().startPullRefresh();
                    }
                } else if (view == b.this.daA && b.this.cIC.aln() != null && b.this.cIC.aln().getListView() != null) {
                    b.this.cIC.aln().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.g gVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dax = null;
        this.daz = null;
        this.daA = null;
        this.cIC = gVar;
        this.daq = noPressedRelativeLayout;
        aqH();
        this.dax = (LinearLayout) this.daq.findViewById(d.g.frs_stick_bottom_holder);
        this.daA = (EntelechyPullUpRefreshView) this.daq.findViewById(d.g.frs_stick_bottom_goto_top);
        this.daz = (EntelechyPullUpRefreshView) this.daq.findViewById(d.g.frs_stick_bottom_reload);
        this.daA.setOnClickListener(this.daB);
        this.daz.setOnClickListener(this.daB);
        onChangeSkinType(this.mSkinType);
    }

    private void aqH() {
        this.dar = new TbImageView(this.cIC.getPageContext().getPageActivity());
        int f = l.f(this.cIC.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = f;
        this.dar.setLayoutParams(layoutParams);
        this.daq.addView(this.dar);
        this.dar.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void v(boolean z, boolean z2) {
        if (!this.dav) {
            this.aDA = z;
            if (z) {
                if (z2) {
                    aqK();
                } else {
                    this.dax.setVisibility(0);
                }
            } else if (z2) {
                aqM();
            } else {
                this.dax.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean anO() {
        if (this.daz == null) {
            return false;
        }
        return this.aDA;
    }

    private void aqI() {
        if (this.cIC.isAdded()) {
            this.das = AnimationUtils.loadAnimation(this.cIC.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.das.setAnimationListener(new a(this.dax));
        }
    }

    private void aqJ() {
        if (this.cIC.isAdded()) {
            this.dau = AnimationUtils.loadAnimation(this.cIC.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dau.setAnimationListener(new animation.Animation$AnimationListenerC0102b(this.dax));
        }
    }

    private void aqK() {
        aqL();
        if (this.dau == null) {
            aqJ();
        }
        if (this.dau != null) {
            this.dax.setVisibility(0);
            this.dax.startAnimation(this.dau);
        }
    }

    private void aqL() {
        if (this.dax != null) {
            this.dax.clearAnimation();
        }
    }

    private boolean ax(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aqM() {
        aqL();
        if (this.das == null) {
            aqI();
        }
        if (this.das != null) {
            this.dax.startAnimation(this.das);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void anQ() {
        if (this.daz != null && !ax(this.daz)) {
            this.daz.ajL();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void anP() {
        if (this.daz != null && !ax(this.daz)) {
            this.daz.ajK();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.daz != null) {
                this.daz.onChangeSkinType(i);
            }
            if (this.daA != null) {
                this.daA.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fl(boolean z) {
        this.dav = z;
        if (this.daz != null) {
            if (z) {
                aqM();
            } else {
                aqK();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void u(float f) {
        if (this.dar != null) {
            if (!this.dar.isShown()) {
                this.dar.setVisibility(0);
                aj.c(this.dar, d.f.icon_pop_refresh);
            }
            if (this.dar.getAnimation() != null) {
                this.dar.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.daw, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dar.startAnimation(rotateAnimation);
            this.daw = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aqA() {
        if (this.dar != null) {
            this.dar.clearAnimation();
            this.dar.setImageDrawable(null);
            this.dar.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void kU() {
        if (this.dar != null && this.cIC != null && this.cIC.getPageContext() != null) {
            if (!this.dar.isShown()) {
                this.dar.setVisibility(0);
                aj.c(this.dar, d.f.icon_pop_refresh);
            }
            if (this.dar.getAnimation() != null) {
                this.dar.clearAnimation();
            }
            this.dar.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cIC.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    public static class animation.Animation$AnimationListenerC0102b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0102b(View view) {
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
