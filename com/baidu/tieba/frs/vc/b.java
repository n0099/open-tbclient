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
    private FrsFragment dDf;
    private NoPressedRelativeLayout dWf;
    private Animation dWh;
    private Animation dWi;
    private LinearLayout dWl;
    private EntelechyPullUpRefreshView dWm;
    private EntelechyPullUpRefreshView dWn;
    private TbImageView dWg = null;
    private int mSkinType = 3;
    private boolean dWj = false;
    private float dWk = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener dWo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dDf != null) {
                if (view == b.this.dWm) {
                    TiebaStatic.eventStat(b.this.dDf.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dDf.azq() && b.this.dDf.ayY() != null) {
                        TiebaStatic.log(new am("c11752").ax(ImageViewerConfig.FORUM_ID, b.this.dDf.getFid()).ax("obj_locate", "3"));
                        b.this.dDf.ayY().startPullRefresh();
                    }
                } else if (view == b.this.dWn && b.this.dDf.ayY() != null && b.this.dDf.ayY().getListView() != null) {
                    b.this.dDf.ayY().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dWl = null;
        this.dWm = null;
        this.dWn = null;
        this.dDf = frsFragment;
        this.dWf = noPressedRelativeLayout;
        aFi();
        this.dWl = (LinearLayout) this.dWf.findViewById(e.g.frs_stick_bottom_holder);
        this.dWn = (EntelechyPullUpRefreshView) this.dWf.findViewById(e.g.frs_stick_bottom_goto_top);
        this.dWm = (EntelechyPullUpRefreshView) this.dWf.findViewById(e.g.frs_stick_bottom_reload);
        this.dWn.setOnClickListener(this.dWo);
        this.dWm.setOnClickListener(this.dWo);
        onChangeSkinType(this.mSkinType);
    }

    private void aFi() {
        this.dWg = new TbImageView(this.dDf.getPageContext().getPageActivity());
        int h = l.h(this.dDf.getPageContext().getPageActivity(), e.C0200e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.dWg.setLayoutParams(layoutParams);
        this.dWf.addView(this.dWg);
        this.dWg.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void B(boolean z, boolean z2) {
        if (!this.dWj) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    aFl();
                } else {
                    this.dWl.setVisibility(0);
                }
            } else if (z2) {
                aFm();
            } else {
                this.dWl.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean aCk() {
        if (this.dWm == null) {
            return false;
        }
        return this.isShow;
    }

    private void aFj() {
        if (this.dDf.isAdded()) {
            this.dWh = AnimationUtils.loadAnimation(this.dDf.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_out);
            this.dWh.setAnimationListener(new a(this.dWl));
        }
    }

    private void aFk() {
        if (this.dDf.isAdded()) {
            this.dWi = AnimationUtils.loadAnimation(this.dDf.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_in);
            this.dWi.setAnimationListener(new animation.Animation$AnimationListenerC0218b(this.dWl));
        }
    }

    private void aFl() {
        cancelAnimation();
        if (this.dWi == null) {
            aFk();
        }
        if (this.dWi != null) {
            this.dWl.setVisibility(0);
            this.dWl.startAnimation(this.dWi);
        }
    }

    private void cancelAnimation() {
        if (this.dWl != null) {
            this.dWl.clearAnimation();
        }
    }

    private boolean aL(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aFm() {
        cancelAnimation();
        if (this.dWh == null) {
            aFj();
        }
        if (this.dWh != null) {
            this.dWl.startAnimation(this.dWh);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aCm() {
        if (this.dWm != null && !aL(this.dWm)) {
            this.dWm.awg();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aCl() {
        if (this.dWm != null && !aL(this.dWm)) {
            this.dWm.awf();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dWm != null) {
                this.dWm.onChangeSkinType(i);
            }
            if (this.dWn != null) {
                this.dWn.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void gZ(boolean z) {
        this.dWj = z;
        if (this.dWm != null) {
            if (z) {
                if (this.dWl != null && this.dWl.getVisibility() == 0) {
                    aFm();
                    return;
                }
                return;
            }
            aFl();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void M(float f) {
        if (this.dWg != null) {
            if (!this.dWg.isShown()) {
                this.dWg.setVisibility(0);
                al.c(this.dWg, e.f.icon_pop_refresh);
            }
            if (this.dWg.getAnimation() != null) {
                this.dWg.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dWk, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dWg.startAnimation(rotateAnimation);
            this.dWk = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aFc() {
        if (this.dWg != null) {
            this.dWg.clearAnimation();
            this.dWg.setImageDrawable(null);
            this.dWg.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void oC() {
        if (this.dWg != null && this.dDf != null && this.dDf.getPageContext() != null) {
            if (!this.dWg.isShown()) {
                this.dWg.setVisibility(0);
                al.c(this.dWg, e.f.icon_pop_refresh);
            }
            if (this.dWg.getAnimation() != null) {
                this.dWg.clearAnimation();
            }
            this.dWg.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dDf.getPageContext().getPageActivity(), e.a.center_head_rotate));
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
    public static class animation.Animation$AnimationListenerC0218b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0218b(View view) {
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
