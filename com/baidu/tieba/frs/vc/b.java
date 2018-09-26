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
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout dNd;
    private Animation dNf;
    private Animation dNg;
    private LinearLayout dNj;
    private EntelechyPullUpRefreshView dNk;
    private EntelechyPullUpRefreshView dNl;
    private FrsFragment dtN;
    private TbImageView dNe = null;
    private int mSkinType = 3;
    private boolean dNh = false;
    private float dNi = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener dNm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dtN != null) {
                if (view == b.this.dNk) {
                    TiebaStatic.eventStat(b.this.dtN.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dtN.aww() && b.this.dtN.awe() != null) {
                        TiebaStatic.log(new am("c11752").al(ImageViewerConfig.FORUM_ID, b.this.dtN.getFid()).al("obj_locate", "3"));
                        b.this.dtN.awe().startPullRefresh();
                    }
                } else if (view == b.this.dNl && b.this.dtN.awe() != null && b.this.dtN.awe().getListView() != null) {
                    b.this.dtN.awe().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dNj = null;
        this.dNk = null;
        this.dNl = null;
        this.dtN = frsFragment;
        this.dNd = noPressedRelativeLayout;
        aCu();
        this.dNj = (LinearLayout) this.dNd.findViewById(e.g.frs_stick_bottom_holder);
        this.dNl = (EntelechyPullUpRefreshView) this.dNd.findViewById(e.g.frs_stick_bottom_goto_top);
        this.dNk = (EntelechyPullUpRefreshView) this.dNd.findViewById(e.g.frs_stick_bottom_reload);
        this.dNl.setOnClickListener(this.dNm);
        this.dNk.setOnClickListener(this.dNm);
        onChangeSkinType(this.mSkinType);
    }

    private void aCu() {
        this.dNe = new TbImageView(this.dtN.getPageContext().getPageActivity());
        int h = l.h(this.dtN.getPageContext().getPageActivity(), e.C0141e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.dNe.setLayoutParams(layoutParams);
        this.dNd.addView(this.dNe);
        this.dNe.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void y(boolean z, boolean z2) {
        if (!this.dNh) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    aCx();
                } else {
                    this.dNj.setVisibility(0);
                }
            } else if (z2) {
                aCy();
            } else {
                this.dNj.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean azw() {
        if (this.dNk == null) {
            return false;
        }
        return this.isShow;
    }

    private void aCv() {
        if (this.dtN.isAdded()) {
            this.dNf = AnimationUtils.loadAnimation(this.dtN.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_out);
            this.dNf.setAnimationListener(new a(this.dNj));
        }
    }

    private void aCw() {
        if (this.dtN.isAdded()) {
            this.dNg = AnimationUtils.loadAnimation(this.dtN.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_in);
            this.dNg.setAnimationListener(new animation.Animation$AnimationListenerC0159b(this.dNj));
        }
    }

    private void aCx() {
        cf();
        if (this.dNg == null) {
            aCw();
        }
        if (this.dNg != null) {
            this.dNj.setVisibility(0);
            this.dNj.startAnimation(this.dNg);
        }
    }

    private void cf() {
        if (this.dNj != null) {
            this.dNj.clearAnimation();
        }
    }

    private boolean aJ(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aCy() {
        cf();
        if (this.dNf == null) {
            aCv();
        }
        if (this.dNf != null) {
            this.dNj.startAnimation(this.dNf);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void azy() {
        if (this.dNk != null && !aJ(this.dNk)) {
            this.dNk.atl();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void azx() {
        if (this.dNk != null && !aJ(this.dNk)) {
            this.dNk.atk();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dNk != null) {
                this.dNk.onChangeSkinType(i);
            }
            if (this.dNl != null) {
                this.dNl.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void gy(boolean z) {
        this.dNh = z;
        if (this.dNk != null) {
            if (z) {
                if (this.dNj != null && this.dNj.getVisibility() == 0) {
                    aCy();
                    return;
                }
                return;
            }
            aCx();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void M(float f) {
        if (this.dNe != null) {
            if (!this.dNe.isShown()) {
                this.dNe.setVisibility(0);
                al.c(this.dNe, e.f.icon_pop_refresh);
            }
            if (this.dNe.getAnimation() != null) {
                this.dNe.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dNi, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dNe.startAnimation(rotateAnimation);
            this.dNi = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aCn() {
        if (this.dNe != null) {
            this.dNe.clearAnimation();
            this.dNe.setImageDrawable(null);
            this.dNe.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void ot() {
        if (this.dNe != null && this.dtN != null && this.dtN.getPageContext() != null) {
            if (!this.dNe.isShown()) {
                this.dNe.setVisibility(0);
                al.c(this.dNe, e.f.icon_pop_refresh);
            }
            if (this.dNe.getAnimation() != null) {
                this.dNe.clearAnimation();
            }
            this.dNe.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dtN.getPageContext().getPageActivity(), e.a.center_head_rotate));
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
    public static class animation.Animation$AnimationListenerC0159b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0159b(View view) {
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
