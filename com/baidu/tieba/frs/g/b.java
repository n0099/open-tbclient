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
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.a {
    private com.baidu.tieba.frs.i dFD;
    private NoPressedRelativeLayout dUF;
    private Animation dUH;
    private Animation dUI;
    private LinearLayout dUL;
    private EntelechyPullUpRefreshView dUM;
    private EntelechyPullUpRefreshView dUN;
    private TbImageView dUG = null;
    private int mSkinType = 3;
    private boolean dUJ = false;
    private float dUK = 360.0f;
    private boolean btN = true;
    private View.OnClickListener dUO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dFD != null) {
                if (view == b.this.dUM) {
                    TiebaStatic.eventStat(b.this.dFD.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dFD.avl() && b.this.dFD.auS() != null) {
                        TiebaStatic.log(new ak("c11752").ab(ImageViewerConfig.FORUM_ID, b.this.dFD.getFid()).ab("obj_locate", "3"));
                        b.this.dFD.auS().startPullRefresh();
                    }
                } else if (view == b.this.dUN && b.this.dFD.auS() != null && b.this.dFD.auS().getListView() != null) {
                    b.this.dFD.auS().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dUL = null;
        this.dUM = null;
        this.dUN = null;
        this.dFD = iVar;
        this.dUF = noPressedRelativeLayout;
        azX();
        this.dUL = (LinearLayout) this.dUF.findViewById(d.g.frs_stick_bottom_holder);
        this.dUN = (EntelechyPullUpRefreshView) this.dUF.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dUM = (EntelechyPullUpRefreshView) this.dUF.findViewById(d.g.frs_stick_bottom_reload);
        this.dUN.setOnClickListener(this.dUO);
        this.dUM.setOnClickListener(this.dUO);
        onChangeSkinType(this.mSkinType);
    }

    private void azX() {
        this.dUG = new TbImageView(this.dFD.getPageContext().getPageActivity());
        int t = l.t(this.dFD.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t, t);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = t;
        this.dUG.setLayoutParams(layoutParams);
        this.dUF.addView(this.dUG);
        this.dUG.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void y(boolean z, boolean z2) {
        if (!this.dUJ) {
            this.btN = z;
            if (z) {
                if (z2) {
                    aAa();
                } else {
                    this.dUL.setVisibility(0);
                }
            } else if (z2) {
                aAc();
            } else {
                this.dUL.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean axx() {
        if (this.dUM == null) {
            return false;
        }
        return this.btN;
    }

    private void azY() {
        if (this.dFD.isAdded()) {
            this.dUH = AnimationUtils.loadAnimation(this.dFD.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dUH.setAnimationListener(new a(this.dUL));
        }
    }

    private void azZ() {
        if (this.dFD.isAdded()) {
            this.dUI = AnimationUtils.loadAnimation(this.dFD.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dUI.setAnimationListener(new animation.Animation$AnimationListenerC0153b(this.dUL));
        }
    }

    private void aAa() {
        aAb();
        if (this.dUI == null) {
            azZ();
        }
        if (this.dUI != null) {
            this.dUL.setVisibility(0);
            this.dUL.startAnimation(this.dUI);
        }
    }

    private void aAb() {
        if (this.dUL != null) {
            this.dUL.clearAnimation();
        }
    }

    private boolean bL(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aAc() {
        aAb();
        if (this.dUH == null) {
            azY();
        }
        if (this.dUH != null) {
            this.dUL.startAnimation(this.dUH);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void axz() {
        if (this.dUM != null && !bL(this.dUM)) {
            this.dUM.ati();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void axy() {
        if (this.dUM != null && !bL(this.dUM)) {
            this.dUM.ath();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dUM != null) {
                this.dUM.onChangeSkinType(i);
            }
            if (this.dUN != null) {
                this.dUN.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ge(boolean z) {
        this.dUJ = z;
        if (this.dUM != null) {
            if (z) {
                if (this.dUL != null && this.dUL.getVisibility() == 0) {
                    aAc();
                    return;
                }
                return;
            }
            aAa();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void O(float f) {
        if (this.dUG != null) {
            if (!this.dUG.isShown()) {
                this.dUG.setVisibility(0);
                aj.c(this.dUG, d.f.icon_pop_refresh);
            }
            if (this.dUG.getAnimation() != null) {
                this.dUG.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dUK, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dUG.startAnimation(rotateAnimation);
            this.dUK = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void azS() {
        if (this.dUG != null) {
            this.dUG.clearAnimation();
            this.dUG.setImageDrawable(null);
            this.dUG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void sr() {
        if (this.dUG != null && this.dFD != null && this.dFD.getPageContext() != null) {
            if (!this.dUG.isShown()) {
                this.dUG.setVisibility(0);
                aj.c(this.dUG, d.f.icon_pop_refresh);
            }
            if (this.dUG.getAnimation() != null) {
                this.dUG.clearAnimation();
            }
            this.dUG.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dFD.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    /* renamed from: com.baidu.tieba.frs.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class animation.Animation$AnimationListenerC0153b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0153b(View view) {
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
