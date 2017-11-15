package com.baidu.tieba.frs.g;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
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
    private NoPressedRelativeLayout cQY;
    private Animation cRa;
    private Animation cRb;
    private LinearLayout cRe;
    private EntelechyPullUpRefreshView cRf;
    private EntelechyPullUpRefreshView cRg;
    private com.baidu.tieba.frs.f czk;
    private TbImageView cQZ = null;
    private int mSkinType = 3;
    private boolean cRc = false;
    private float cRd = 360.0f;
    private boolean aCX = true;
    private View.OnClickListener cRh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.czk != null) {
                if (view == b.this.cRf) {
                    TiebaStatic.eventStat(b.this.czk.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.czk.ajC() && b.this.czk.ajk() != null) {
                        TiebaStatic.log(new ak("c11752").ac(ImageViewerConfig.FORUM_ID, b.this.czk.getFid()).ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                        b.this.czk.ajk().startPullRefresh();
                    }
                } else if (view == b.this.cRg && b.this.czk.ajk() != null && b.this.czk.ajk().getListView() != null) {
                    b.this.czk.ajk().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cRe = null;
        this.cRf = null;
        this.cRg = null;
        this.czk = fVar;
        this.cQY = noPressedRelativeLayout;
        aoE();
        this.cRe = (LinearLayout) this.cQY.findViewById(d.g.frs_stick_bottom_holder);
        this.cRg = (EntelechyPullUpRefreshView) this.cQY.findViewById(d.g.frs_stick_bottom_goto_top);
        this.cRf = (EntelechyPullUpRefreshView) this.cQY.findViewById(d.g.frs_stick_bottom_reload);
        this.cRg.setOnClickListener(this.cRh);
        this.cRf.setOnClickListener(this.cRh);
        onChangeSkinType(this.mSkinType);
    }

    private void aoE() {
        this.cQZ = new TbImageView(this.czk.getPageContext().getPageActivity());
        int f = l.f(this.czk.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = f;
        this.cQZ.setLayoutParams(layoutParams);
        this.cQY.addView(this.cQZ);
        this.cQZ.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void v(boolean z, boolean z2) {
        if (!this.cRc) {
            this.aCX = z;
            if (z) {
                if (z2) {
                    aoH();
                } else {
                    this.cRe.setVisibility(0);
                }
            } else if (z2) {
                aoJ();
            } else {
                this.cRe.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean alK() {
        if (this.cRf == null) {
            return false;
        }
        return this.aCX;
    }

    private void aoF() {
        if (this.czk.isAdded()) {
            this.cRa = AnimationUtils.loadAnimation(this.czk.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.cRa.setAnimationListener(new a(this.cRe));
        }
    }

    private void aoG() {
        if (this.czk.isAdded()) {
            this.cRb = AnimationUtils.loadAnimation(this.czk.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.cRb.setAnimationListener(new animation.Animation$AnimationListenerC0087b(this.cRe));
        }
    }

    private void aoH() {
        aoI();
        if (this.cRb == null) {
            aoG();
        }
        if (this.cRb != null) {
            this.cRe.setVisibility(0);
            this.cRe.startAnimation(this.cRb);
        }
    }

    private void aoI() {
        if (this.cRe != null) {
            this.cRe.clearAnimation();
        }
    }

    private boolean au(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aoJ() {
        aoI();
        if (this.cRa == null) {
            aoF();
        }
        if (this.cRa != null) {
            this.cRe.startAnimation(this.cRa);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void alM() {
        if (this.cRf != null && !au(this.cRf)) {
            this.cRf.ahP();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void alL() {
        if (this.cRf != null && !au(this.cRf)) {
            this.cRf.ahO();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cRf != null) {
                this.cRf.onChangeSkinType(i);
            }
            if (this.cRg != null) {
                this.cRg.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eT(boolean z) {
        this.cRc = z;
        if (this.cRf != null) {
            if (z) {
                aoJ();
            } else {
                aoH();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void u(float f) {
        if (this.cQZ != null) {
            if (!this.cQZ.isShown()) {
                this.cQZ.setVisibility(0);
                aj.c(this.cQZ, d.f.icon_pop_refresh);
            }
            if (this.cQZ.getAnimation() != null) {
                this.cQZ.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cRd, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cQZ.startAnimation(rotateAnimation);
            this.cRd = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aox() {
        if (this.cQZ != null) {
            this.cQZ.clearAnimation();
            this.cQZ.setImageDrawable(null);
            this.cQZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void kU() {
        if (this.cQZ != null && this.czk != null && this.czk.getPageContext() != null) {
            if (!this.cQZ.isShown()) {
                this.cQZ.setVisibility(0);
                aj.c(this.cQZ, d.f.icon_pop_refresh);
            }
            if (this.cQZ.getAnimation() != null) {
                this.cQZ.clearAnimation();
            }
            this.cQZ.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.czk.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    public static class animation.Animation$AnimationListenerC0087b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0087b(View view) {
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
