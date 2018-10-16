package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes6.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment dBO;
    private NoPressedRelativeLayout dUY;
    private Animation dVa;
    private Animation dVb;
    private LinearLayout dVe;
    private EntelechyPullUpRefreshView dVf;
    private EntelechyPullUpRefreshView dVg;
    private TbImageView dUZ = null;
    private int mSkinType = 3;
    private boolean dVc = false;
    private float dVd = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener dVh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dBO != null) {
                if (view == b.this.dVf) {
                    TiebaStatic.eventStat(b.this.dBO.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dBO.azS() && b.this.dBO.azA() != null) {
                        TiebaStatic.log(new am("c11752").ax(ImageViewerConfig.FORUM_ID, b.this.dBO.getFid()).ax("obj_locate", "3"));
                        b.this.dBO.azA().startPullRefresh();
                    }
                } else if (view == b.this.dVg && b.this.dBO.azA() != null && b.this.dBO.azA().getListView() != null) {
                    b.this.dBO.azA().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dVe = null;
        this.dVf = null;
        this.dVg = null;
        this.dBO = frsFragment;
        this.dUY = noPressedRelativeLayout;
        aFM();
        this.dVe = (LinearLayout) this.dUY.findViewById(e.g.frs_stick_bottom_holder);
        this.dVg = (EntelechyPullUpRefreshView) this.dUY.findViewById(e.g.frs_stick_bottom_goto_top);
        this.dVf = (EntelechyPullUpRefreshView) this.dUY.findViewById(e.g.frs_stick_bottom_reload);
        this.dVg.setOnClickListener(this.dVh);
        this.dVf.setOnClickListener(this.dVh);
        onChangeSkinType(this.mSkinType);
    }

    private void aFM() {
        this.dUZ = new TbImageView(this.dBO.getPageContext().getPageActivity());
        int h = l.h(this.dBO.getPageContext().getPageActivity(), e.C0175e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.dUZ.setLayoutParams(layoutParams);
        this.dUY.addView(this.dUZ);
        this.dUZ.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void z(boolean z, boolean z2) {
        if (!this.dVc) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    aFP();
                } else {
                    this.dVe.setVisibility(0);
                }
            } else if (z2) {
                aFQ();
            } else {
                this.dVe.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean aCP() {
        if (this.dVf == null) {
            return false;
        }
        return this.isShow;
    }

    private void aFN() {
        if (this.dBO.isAdded()) {
            this.dVa = AnimationUtils.loadAnimation(this.dBO.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_out);
            this.dVa.setAnimationListener(new a(this.dVe));
        }
    }

    private void aFO() {
        if (this.dBO.isAdded()) {
            this.dVb = AnimationUtils.loadAnimation(this.dBO.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_in);
            this.dVb.setAnimationListener(new animation.Animation$AnimationListenerC0193b(this.dVe));
        }
    }

    private void aFP() {
        cx();
        if (this.dVb == null) {
            aFO();
        }
        if (this.dVb != null) {
            this.dVe.setVisibility(0);
            this.dVe.startAnimation(this.dVb);
        }
    }

    private void cx() {
        if (this.dVe != null) {
            this.dVe.clearAnimation();
        }
    }

    private boolean aJ(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aFQ() {
        cx();
        if (this.dVa == null) {
            aFN();
        }
        if (this.dVa != null) {
            this.dVe.startAnimation(this.dVa);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aCR() {
        if (this.dVf != null && !aJ(this.dVf)) {
            this.dVf.awH();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aCQ() {
        if (this.dVf != null && !aJ(this.dVf)) {
            this.dVf.awG();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dVf != null) {
                this.dVf.onChangeSkinType(i);
            }
            if (this.dVg != null) {
                this.dVg.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void gQ(boolean z) {
        this.dVc = z;
        if (this.dVf != null) {
            if (z) {
                if (this.dVe != null && this.dVe.getVisibility() == 0) {
                    aFQ();
                    return;
                }
                return;
            }
            aFP();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void M(float f) {
        if (this.dUZ != null) {
            if (!this.dUZ.isShown()) {
                this.dUZ.setVisibility(0);
                al.c(this.dUZ, e.f.icon_pop_refresh);
            }
            if (this.dUZ.getAnimation() != null) {
                this.dUZ.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dVd, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dUZ.startAnimation(rotateAnimation);
            this.dVd = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aFG() {
        if (this.dUZ != null) {
            this.dUZ.clearAnimation();
            this.dUZ.setImageDrawable(null);
            this.dUZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void oE() {
        if (this.dUZ != null && this.dBO != null && this.dBO.getPageContext() != null) {
            if (!this.dUZ.isShown()) {
                this.dUZ.setVisibility(0);
                al.c(this.dUZ, e.f.icon_pop_refresh);
            }
            if (this.dUZ.getAnimation() != null) {
                this.dUZ.clearAnimation();
            }
            this.dUZ.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dBO.getPageContext().getPageActivity(), e.a.center_head_rotate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
    /* renamed from: com.baidu.tieba.frs.vc.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class animation.Animation$AnimationListenerC0193b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0193b(View view) {
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
