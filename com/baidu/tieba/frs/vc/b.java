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
    private NoPressedRelativeLayout dUZ;
    private Animation dVb;
    private Animation dVc;
    private LinearLayout dVf;
    private EntelechyPullUpRefreshView dVg;
    private EntelechyPullUpRefreshView dVh;
    private TbImageView dVa = null;
    private int mSkinType = 3;
    private boolean dVd = false;
    private float dVe = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener dVi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dBO != null) {
                if (view == b.this.dVg) {
                    TiebaStatic.eventStat(b.this.dBO.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dBO.azT() && b.this.dBO.azB() != null) {
                        TiebaStatic.log(new am("c11752").ax(ImageViewerConfig.FORUM_ID, b.this.dBO.getFid()).ax("obj_locate", "3"));
                        b.this.dBO.azB().startPullRefresh();
                    }
                } else if (view == b.this.dVh && b.this.dBO.azB() != null && b.this.dBO.azB().getListView() != null) {
                    b.this.dBO.azB().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dVf = null;
        this.dVg = null;
        this.dVh = null;
        this.dBO = frsFragment;
        this.dUZ = noPressedRelativeLayout;
        aFM();
        this.dVf = (LinearLayout) this.dUZ.findViewById(e.g.frs_stick_bottom_holder);
        this.dVh = (EntelechyPullUpRefreshView) this.dUZ.findViewById(e.g.frs_stick_bottom_goto_top);
        this.dVg = (EntelechyPullUpRefreshView) this.dUZ.findViewById(e.g.frs_stick_bottom_reload);
        this.dVh.setOnClickListener(this.dVi);
        this.dVg.setOnClickListener(this.dVi);
        onChangeSkinType(this.mSkinType);
    }

    private void aFM() {
        this.dVa = new TbImageView(this.dBO.getPageContext().getPageActivity());
        int h = l.h(this.dBO.getPageContext().getPageActivity(), e.C0175e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.dVa.setLayoutParams(layoutParams);
        this.dUZ.addView(this.dVa);
        this.dVa.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void z(boolean z, boolean z2) {
        if (!this.dVd) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    aFP();
                } else {
                    this.dVf.setVisibility(0);
                }
            } else if (z2) {
                aFQ();
            } else {
                this.dVf.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean aCQ() {
        if (this.dVg == null) {
            return false;
        }
        return this.isShow;
    }

    private void aFN() {
        if (this.dBO.isAdded()) {
            this.dVb = AnimationUtils.loadAnimation(this.dBO.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_out);
            this.dVb.setAnimationListener(new a(this.dVf));
        }
    }

    private void aFO() {
        if (this.dBO.isAdded()) {
            this.dVc = AnimationUtils.loadAnimation(this.dBO.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_in);
            this.dVc.setAnimationListener(new animation.Animation$AnimationListenerC0193b(this.dVf));
        }
    }

    private void aFP() {
        cx();
        if (this.dVc == null) {
            aFO();
        }
        if (this.dVc != null) {
            this.dVf.setVisibility(0);
            this.dVf.startAnimation(this.dVc);
        }
    }

    private void cx() {
        if (this.dVf != null) {
            this.dVf.clearAnimation();
        }
    }

    private boolean aJ(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aFQ() {
        cx();
        if (this.dVb == null) {
            aFN();
        }
        if (this.dVb != null) {
            this.dVf.startAnimation(this.dVb);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aCS() {
        if (this.dVg != null && !aJ(this.dVg)) {
            this.dVg.awI();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aCR() {
        if (this.dVg != null && !aJ(this.dVg)) {
            this.dVg.awH();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dVg != null) {
                this.dVg.onChangeSkinType(i);
            }
            if (this.dVh != null) {
                this.dVh.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void gQ(boolean z) {
        this.dVd = z;
        if (this.dVg != null) {
            if (z) {
                if (this.dVf != null && this.dVf.getVisibility() == 0) {
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
        if (this.dVa != null) {
            if (!this.dVa.isShown()) {
                this.dVa.setVisibility(0);
                al.c(this.dVa, e.f.icon_pop_refresh);
            }
            if (this.dVa.getAnimation() != null) {
                this.dVa.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dVe, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dVa.startAnimation(rotateAnimation);
            this.dVe = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aFG() {
        if (this.dVa != null) {
            this.dVa.clearAnimation();
            this.dVa.setImageDrawable(null);
            this.dVa.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void oE() {
        if (this.dVa != null && this.dBO != null && this.dBO.getPageContext() != null) {
            if (!this.dVa.isShown()) {
                this.dVa.setVisibility(0);
                al.c(this.dVa, e.f.icon_pop_refresh);
            }
            if (this.dVa.getAnimation() != null) {
                this.dVa.clearAnimation();
            }
            this.dVa.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dBO.getPageContext().getPageActivity(), e.a.center_head_rotate));
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
