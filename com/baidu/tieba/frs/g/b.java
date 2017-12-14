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
    private com.baidu.tieba.frs.g cIy;
    private NoPressedRelativeLayout dam;
    private Animation dao;
    private Animation dap;
    private LinearLayout das;
    private EntelechyPullUpRefreshView dau;
    private EntelechyPullUpRefreshView dav;
    private TbImageView dan = null;
    private int mSkinType = 3;
    private boolean daq = false;
    private float dar = 360.0f;
    private boolean aDx = true;
    private View.OnClickListener daw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cIy != null) {
                if (view == b.this.dau) {
                    TiebaStatic.eventStat(b.this.cIy.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.cIy.alG() && b.this.cIy.alo() != null) {
                        TiebaStatic.log(new ak("c11752").ac(ImageViewerConfig.FORUM_ID, b.this.cIy.getFid()).ac("obj_locate", "3"));
                        b.this.cIy.alo().startPullRefresh();
                    }
                } else if (view == b.this.dav && b.this.cIy.alo() != null && b.this.cIy.alo().getListView() != null) {
                    b.this.cIy.alo().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.g gVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.das = null;
        this.dau = null;
        this.dav = null;
        this.cIy = gVar;
        this.dam = noPressedRelativeLayout;
        aqH();
        this.das = (LinearLayout) this.dam.findViewById(d.g.frs_stick_bottom_holder);
        this.dav = (EntelechyPullUpRefreshView) this.dam.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dau = (EntelechyPullUpRefreshView) this.dam.findViewById(d.g.frs_stick_bottom_reload);
        this.dav.setOnClickListener(this.daw);
        this.dau.setOnClickListener(this.daw);
        onChangeSkinType(this.mSkinType);
    }

    private void aqH() {
        this.dan = new TbImageView(this.cIy.getPageContext().getPageActivity());
        int f = l.f(this.cIy.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = f;
        this.dan.setLayoutParams(layoutParams);
        this.dam.addView(this.dan);
        this.dan.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void v(boolean z, boolean z2) {
        if (!this.daq) {
            this.aDx = z;
            if (z) {
                if (z2) {
                    aqK();
                } else {
                    this.das.setVisibility(0);
                }
            } else if (z2) {
                aqM();
            } else {
                this.das.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean anO() {
        if (this.dau == null) {
            return false;
        }
        return this.aDx;
    }

    private void aqI() {
        if (this.cIy.isAdded()) {
            this.dao = AnimationUtils.loadAnimation(this.cIy.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dao.setAnimationListener(new a(this.das));
        }
    }

    private void aqJ() {
        if (this.cIy.isAdded()) {
            this.dap = AnimationUtils.loadAnimation(this.cIy.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dap.setAnimationListener(new animation.Animation$AnimationListenerC0103b(this.das));
        }
    }

    private void aqK() {
        aqL();
        if (this.dap == null) {
            aqJ();
        }
        if (this.dap != null) {
            this.das.setVisibility(0);
            this.das.startAnimation(this.dap);
        }
    }

    private void aqL() {
        if (this.das != null) {
            this.das.clearAnimation();
        }
    }

    private boolean aw(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aqM() {
        aqL();
        if (this.dao == null) {
            aqI();
        }
        if (this.dao != null) {
            this.das.startAnimation(this.dao);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void anQ() {
        if (this.dau != null && !aw(this.dau)) {
            this.dau.ajM();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void anP() {
        if (this.dau != null && !aw(this.dau)) {
            this.dau.ajL();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dau != null) {
                this.dau.onChangeSkinType(i);
            }
            if (this.dav != null) {
                this.dav.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fl(boolean z) {
        this.daq = z;
        if (this.dau != null) {
            if (z) {
                aqM();
            } else {
                aqK();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void u(float f) {
        if (this.dan != null) {
            if (!this.dan.isShown()) {
                this.dan.setVisibility(0);
                aj.c(this.dan, d.f.icon_pop_refresh);
            }
            if (this.dan.getAnimation() != null) {
                this.dan.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dar, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dan.startAnimation(rotateAnimation);
            this.dar = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aqA() {
        if (this.dan != null) {
            this.dan.clearAnimation();
            this.dan.setImageDrawable(null);
            this.dan.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void kU() {
        if (this.dan != null && this.cIy != null && this.cIy.getPageContext() != null) {
            if (!this.dan.isShown()) {
                this.dan.setVisibility(0);
                aj.c(this.dan, d.f.icon_pop_refresh);
            }
            if (this.dan.getAnimation() != null) {
                this.dan.clearAnimation();
            }
            this.dan.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cIy.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    public static class animation.Animation$AnimationListenerC0103b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0103b(View view) {
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
