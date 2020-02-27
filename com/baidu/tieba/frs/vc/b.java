package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes9.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private LinearLayout gLB;
    private EntelechyPullUpRefreshView gLC;
    private EntelechyPullUpRefreshView gLD;
    private NoPressedRelativeLayout gLv;
    private Animation gLx;
    private Animation gLy;
    private FrsFragment gpX;
    private TbImageView gLw = null;
    private int mSkinType = 3;
    private boolean gLz = false;
    private float gLA = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener gLE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gpX != null) {
                if (view == b.this.gLC) {
                    TiebaStatic.eventStat(b.this.gpX.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.gpX.bEo() && b.this.gpX.bDN() != null) {
                        TiebaStatic.log(new an("c11752").cy("fid", b.this.gpX.getFid()).cy("obj_locate", "3"));
                        b.this.gpX.bDN().startPullRefresh();
                    }
                } else if (view == b.this.gLD && b.this.gpX.bDN() != null && b.this.gpX.bDN().getListView() != null) {
                    b.this.gpX.bDN().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gLB = null;
        this.gLC = null;
        this.gLD = null;
        this.gpX = frsFragment;
        this.gLv = noPressedRelativeLayout;
        bKf();
        this.gLB = (LinearLayout) this.gLv.findViewById(R.id.frs_stick_bottom_holder);
        this.gLD = (EntelechyPullUpRefreshView) this.gLv.findViewById(R.id.frs_stick_bottom_goto_top);
        this.gLC = (EntelechyPullUpRefreshView) this.gLv.findViewById(R.id.frs_stick_bottom_reload);
        this.gLD.setOnClickListener(this.gLE);
        this.gLC.setOnClickListener(this.gLE);
        onChangeSkinType(this.mSkinType);
    }

    private void bKf() {
        this.gLw = new TbImageView(this.gpX.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.gpX.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.gLw.setLayoutParams(layoutParams);
        this.gLv.addView(this.gLw);
        this.gLw.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void M(boolean z, boolean z2) {
        if (!this.gLz) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bKi();
                } else {
                    this.gLB.setVisibility(0);
                }
            } else if (z2) {
                bKj();
            } else {
                this.gLB.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bHi() {
        if (this.gLC == null) {
            return false;
        }
        return this.isShow;
    }

    private void bKg() {
        if (this.gpX.isAdded()) {
            this.gLx = AnimationUtils.loadAnimation(this.gpX.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.gLx.setAnimationListener(new a(this.gLB));
        }
    }

    private void bKh() {
        if (this.gpX.isAdded()) {
            this.gLy = AnimationUtils.loadAnimation(this.gpX.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.gLy.setAnimationListener(new animation.Animation$AnimationListenerC0512b(this.gLB));
        }
    }

    private void bKi() {
        cancelAnimation();
        if (this.gLy == null) {
            bKh();
        }
        if (this.gLy != null) {
            this.gLB.setVisibility(0);
            this.gLB.startAnimation(this.gLy);
        }
    }

    private void cancelAnimation() {
        if (this.gLB != null) {
            this.gLB.clearAnimation();
        }
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bKj() {
        cancelAnimation();
        if (this.gLx == null) {
            bKg();
        }
        if (this.gLx != null) {
            this.gLB.startAnimation(this.gLx);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bHk() {
        if (this.gLC != null && !bO(this.gLC)) {
            this.gLC.bBH();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bHj() {
        if (this.gLC != null && !bO(this.gLC)) {
            this.gLC.bBG();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gLC != null) {
                this.gLC.onChangeSkinType(i);
            }
            if (this.gLD != null) {
                this.gLD.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void lP(boolean z) {
        this.gLz = z;
        if (this.gLC != null) {
            if (z) {
                if (this.gLB != null && this.gLB.getVisibility() == 0) {
                    bKj();
                    return;
                }
                return;
            }
            bKi();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bJL() {
        if (this.gLw != null) {
            this.gLw.clearAnimation();
            this.gLw.setImageDrawable(null);
            this.gLw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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
    /* loaded from: classes9.dex */
    public static class animation.Animation$AnimationListenerC0512b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0512b(View view) {
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
