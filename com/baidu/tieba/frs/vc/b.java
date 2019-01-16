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
    private FrsFragment dNb;
    private NoPressedRelativeLayout egg;
    private Animation egi;
    private Animation egj;
    private LinearLayout egm;
    private EntelechyPullUpRefreshView egn;
    private EntelechyPullUpRefreshView ego;
    private TbImageView egh = null;
    private int mSkinType = 3;
    private boolean egk = false;
    private float egl = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener egp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dNb != null) {
                if (view == b.this.egn) {
                    TiebaStatic.eventStat(b.this.dNb.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dNb.aCm() && b.this.dNb.aBU() != null) {
                        TiebaStatic.log(new am("c11752").aB(ImageViewerConfig.FORUM_ID, b.this.dNb.getFid()).aB("obj_locate", "3"));
                        b.this.dNb.aBU().startPullRefresh();
                    }
                } else if (view == b.this.ego && b.this.dNb.aBU() != null && b.this.dNb.aBU().getListView() != null) {
                    b.this.dNb.aBU().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.egm = null;
        this.egn = null;
        this.ego = null;
        this.dNb = frsFragment;
        this.egg = noPressedRelativeLayout;
        aIg();
        this.egm = (LinearLayout) this.egg.findViewById(e.g.frs_stick_bottom_holder);
        this.ego = (EntelechyPullUpRefreshView) this.egg.findViewById(e.g.frs_stick_bottom_goto_top);
        this.egn = (EntelechyPullUpRefreshView) this.egg.findViewById(e.g.frs_stick_bottom_reload);
        this.ego.setOnClickListener(this.egp);
        this.egn.setOnClickListener(this.egp);
        onChangeSkinType(this.mSkinType);
    }

    private void aIg() {
        this.egh = new TbImageView(this.dNb.getPageContext().getPageActivity());
        int h = l.h(this.dNb.getPageContext().getPageActivity(), e.C0210e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.egh.setLayoutParams(layoutParams);
        this.egg.addView(this.egh);
        this.egh.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void B(boolean z, boolean z2) {
        if (!this.egk) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    aIj();
                } else {
                    this.egm.setVisibility(0);
                }
            } else if (z2) {
                aIk();
            } else {
                this.egm.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean aFi() {
        if (this.egn == null) {
            return false;
        }
        return this.isShow;
    }

    private void aIh() {
        if (this.dNb.isAdded()) {
            this.egi = AnimationUtils.loadAnimation(this.dNb.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_out);
            this.egi.setAnimationListener(new a(this.egm));
        }
    }

    private void aIi() {
        if (this.dNb.isAdded()) {
            this.egj = AnimationUtils.loadAnimation(this.dNb.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_in);
            this.egj.setAnimationListener(new animation.Animation$AnimationListenerC0229b(this.egm));
        }
    }

    private void aIj() {
        cancelAnimation();
        if (this.egj == null) {
            aIi();
        }
        if (this.egj != null) {
            this.egm.setVisibility(0);
            this.egm.startAnimation(this.egj);
        }
    }

    private void cancelAnimation() {
        if (this.egm != null) {
            this.egm.clearAnimation();
        }
    }

    private boolean aO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aIk() {
        cancelAnimation();
        if (this.egi == null) {
            aIh();
        }
        if (this.egi != null) {
            this.egm.startAnimation(this.egi);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aFk() {
        if (this.egn != null && !aO(this.egn)) {
            this.egn.azd();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aFj() {
        if (this.egn != null && !aO(this.egn)) {
            this.egn.azc();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.egn != null) {
                this.egn.onChangeSkinType(i);
            }
            if (this.ego != null) {
                this.ego.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void hh(boolean z) {
        this.egk = z;
        if (this.egn != null) {
            if (z) {
                if (this.egm != null && this.egm.getVisibility() == 0) {
                    aIk();
                    return;
                }
                return;
            }
            aIj();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void M(float f) {
        if (this.egh != null) {
            if (!this.egh.isShown()) {
                this.egh.setVisibility(0);
                al.c(this.egh, e.f.icon_pop_refresh);
            }
            if (this.egh.getAnimation() != null) {
                this.egh.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.egl, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.egh.startAnimation(rotateAnimation);
            this.egl = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aIa() {
        if (this.egh != null) {
            this.egh.clearAnimation();
            this.egh.setImageDrawable(null);
            this.egh.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void oF() {
        if (this.egh != null && this.dNb != null && this.dNb.getPageContext() != null) {
            if (!this.egh.isShown()) {
                this.egh.setVisibility(0);
                al.c(this.egh, e.f.icon_pop_refresh);
            }
            if (this.egh.getAnimation() != null) {
                this.egh.clearAnimation();
            }
            this.egh.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dNb.getPageContext().getPageActivity(), e.a.center_head_rotate));
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
    public static class animation.Animation$AnimationListenerC0229b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0229b(View view) {
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
