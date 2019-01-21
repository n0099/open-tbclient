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
    private FrsFragment dNc;
    private NoPressedRelativeLayout egh;
    private Animation egj;
    private Animation egk;
    private LinearLayout egn;
    private EntelechyPullUpRefreshView ego;
    private EntelechyPullUpRefreshView egp;
    private TbImageView egi = null;
    private int mSkinType = 3;
    private boolean egl = false;
    private float egm = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener egq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dNc != null) {
                if (view == b.this.ego) {
                    TiebaStatic.eventStat(b.this.dNc.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dNc.aCm() && b.this.dNc.aBU() != null) {
                        TiebaStatic.log(new am("c11752").aB(ImageViewerConfig.FORUM_ID, b.this.dNc.getFid()).aB("obj_locate", "3"));
                        b.this.dNc.aBU().startPullRefresh();
                    }
                } else if (view == b.this.egp && b.this.dNc.aBU() != null && b.this.dNc.aBU().getListView() != null) {
                    b.this.dNc.aBU().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.egn = null;
        this.ego = null;
        this.egp = null;
        this.dNc = frsFragment;
        this.egh = noPressedRelativeLayout;
        aIg();
        this.egn = (LinearLayout) this.egh.findViewById(e.g.frs_stick_bottom_holder);
        this.egp = (EntelechyPullUpRefreshView) this.egh.findViewById(e.g.frs_stick_bottom_goto_top);
        this.ego = (EntelechyPullUpRefreshView) this.egh.findViewById(e.g.frs_stick_bottom_reload);
        this.egp.setOnClickListener(this.egq);
        this.ego.setOnClickListener(this.egq);
        onChangeSkinType(this.mSkinType);
    }

    private void aIg() {
        this.egi = new TbImageView(this.dNc.getPageContext().getPageActivity());
        int h = l.h(this.dNc.getPageContext().getPageActivity(), e.C0210e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.egi.setLayoutParams(layoutParams);
        this.egh.addView(this.egi);
        this.egi.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void B(boolean z, boolean z2) {
        if (!this.egl) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    aIj();
                } else {
                    this.egn.setVisibility(0);
                }
            } else if (z2) {
                aIk();
            } else {
                this.egn.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean aFi() {
        if (this.ego == null) {
            return false;
        }
        return this.isShow;
    }

    private void aIh() {
        if (this.dNc.isAdded()) {
            this.egj = AnimationUtils.loadAnimation(this.dNc.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_out);
            this.egj.setAnimationListener(new a(this.egn));
        }
    }

    private void aIi() {
        if (this.dNc.isAdded()) {
            this.egk = AnimationUtils.loadAnimation(this.dNc.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_in);
            this.egk.setAnimationListener(new animation.Animation$AnimationListenerC0229b(this.egn));
        }
    }

    private void aIj() {
        cancelAnimation();
        if (this.egk == null) {
            aIi();
        }
        if (this.egk != null) {
            this.egn.setVisibility(0);
            this.egn.startAnimation(this.egk);
        }
    }

    private void cancelAnimation() {
        if (this.egn != null) {
            this.egn.clearAnimation();
        }
    }

    private boolean aO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aIk() {
        cancelAnimation();
        if (this.egj == null) {
            aIh();
        }
        if (this.egj != null) {
            this.egn.startAnimation(this.egj);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aFk() {
        if (this.ego != null && !aO(this.ego)) {
            this.ego.azd();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aFj() {
        if (this.ego != null && !aO(this.ego)) {
            this.ego.azc();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ego != null) {
                this.ego.onChangeSkinType(i);
            }
            if (this.egp != null) {
                this.egp.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void hh(boolean z) {
        this.egl = z;
        if (this.ego != null) {
            if (z) {
                if (this.egn != null && this.egn.getVisibility() == 0) {
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
        if (this.egi != null) {
            if (!this.egi.isShown()) {
                this.egi.setVisibility(0);
                al.c(this.egi, e.f.icon_pop_refresh);
            }
            if (this.egi.getAnimation() != null) {
                this.egi.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.egm, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.egi.startAnimation(rotateAnimation);
            this.egm = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aIa() {
        if (this.egi != null) {
            this.egi.clearAnimation();
            this.egi.setImageDrawable(null);
            this.egi.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void oF() {
        if (this.egi != null && this.dNc != null && this.dNc.getPageContext() != null) {
            if (!this.egi.isShown()) {
                this.egi.setVisibility(0);
                al.c(this.egi, e.f.icon_pop_refresh);
            }
            if (this.egi.getAnimation() != null) {
                this.egi.clearAnimation();
            }
            this.egi.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dNc.getPageContext().getPageActivity(), e.a.center_head_rotate));
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
