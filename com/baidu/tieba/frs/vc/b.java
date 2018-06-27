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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout dDo;
    private Animation dDq;
    private Animation dDr;
    private LinearLayout dDu;
    private EntelechyPullUpRefreshView dDv;
    private EntelechyPullUpRefreshView dDw;
    private FrsFragment dla;
    private TbImageView dDp = null;
    private int mSkinType = 3;
    private boolean dDs = false;
    private float dDt = 360.0f;
    private boolean aNI = true;
    private View.OnClickListener dDx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dla != null) {
                if (view == b.this.dDv) {
                    TiebaStatic.eventStat(b.this.dla.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dla.aua() && b.this.dla.atI() != null) {
                        TiebaStatic.log(new an("c11752").ah(ImageViewerConfig.FORUM_ID, b.this.dla.getFid()).ah("obj_locate", "3"));
                        b.this.dla.atI().startPullRefresh();
                    }
                } else if (view == b.this.dDw && b.this.dla.atI() != null && b.this.dla.atI().getListView() != null) {
                    b.this.dla.atI().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dDu = null;
        this.dDv = null;
        this.dDw = null;
        this.dla = frsFragment;
        this.dDo = noPressedRelativeLayout;
        azH();
        this.dDu = (LinearLayout) this.dDo.findViewById(d.g.frs_stick_bottom_holder);
        this.dDw = (EntelechyPullUpRefreshView) this.dDo.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dDv = (EntelechyPullUpRefreshView) this.dDo.findViewById(d.g.frs_stick_bottom_reload);
        this.dDw.setOnClickListener(this.dDx);
        this.dDv.setOnClickListener(this.dDx);
        onChangeSkinType(this.mSkinType);
    }

    private void azH() {
        this.dDp = new TbImageView(this.dla.getPageContext().getPageActivity());
        int e = l.e(this.dla.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = e;
        this.dDp.setLayoutParams(layoutParams);
        this.dDo.addView(this.dDp);
        this.dDp.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void w(boolean z, boolean z2) {
        if (!this.dDs) {
            this.aNI = z;
            if (z) {
                if (z2) {
                    azK();
                } else {
                    this.dDu.setVisibility(0);
                }
            } else if (z2) {
                azL();
            } else {
                this.dDu.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean awF() {
        if (this.dDv == null) {
            return false;
        }
        return this.aNI;
    }

    private void azI() {
        if (this.dla.isAdded()) {
            this.dDq = AnimationUtils.loadAnimation(this.dla.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dDq.setAnimationListener(new a(this.dDu));
        }
    }

    private void azJ() {
        if (this.dla.isAdded()) {
            this.dDr = AnimationUtils.loadAnimation(this.dla.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dDr.setAnimationListener(new animation.Animation$AnimationListenerC0160b(this.dDu));
        }
    }

    private void azK() {
        bb();
        if (this.dDr == null) {
            azJ();
        }
        if (this.dDr != null) {
            this.dDu.setVisibility(0);
            this.dDu.startAnimation(this.dDr);
        }
    }

    private void bb() {
        if (this.dDu != null) {
            this.dDu.clearAnimation();
        }
    }

    private boolean as(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void azL() {
        bb();
        if (this.dDq == null) {
            azI();
        }
        if (this.dDq != null) {
            this.dDu.startAnimation(this.dDq);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void awH() {
        if (this.dDv != null && !as(this.dDv)) {
            this.dDv.aqX();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void awG() {
        if (this.dDv != null && !as(this.dDv)) {
            this.dDv.aqW();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dDv != null) {
                this.dDv.onChangeSkinType(i);
            }
            if (this.dDw != null) {
                this.dDw.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fY(boolean z) {
        this.dDs = z;
        if (this.dDv != null) {
            if (z) {
                if (this.dDu != null && this.dDu.getVisibility() == 0) {
                    azL();
                    return;
                }
                return;
            }
            azK();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void M(float f) {
        if (this.dDp != null) {
            if (!this.dDp.isShown()) {
                this.dDp.setVisibility(0);
                am.c(this.dDp, d.f.icon_pop_refresh);
            }
            if (this.dDp.getAnimation() != null) {
                this.dDp.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dDt, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dDp.startAnimation(rotateAnimation);
            this.dDt = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void azA() {
        if (this.dDp != null) {
            this.dDp.clearAnimation();
            this.dDp.setImageDrawable(null);
            this.dDp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void nl() {
        if (this.dDp != null && this.dla != null && this.dla.getPageContext() != null) {
            if (!this.dDp.isShown()) {
                this.dDp.setVisibility(0);
                am.c(this.dDp, d.f.icon_pop_refresh);
            }
            if (this.dDp.getAnimation() != null) {
                this.dDp.clearAnimation();
            }
            this.dDp.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dla.getPageContext().getPageActivity(), d.a.center_head_rotate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
    public static class animation.Animation$AnimationListenerC0160b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0160b(View view) {
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
