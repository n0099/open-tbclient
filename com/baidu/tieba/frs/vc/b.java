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
    private Animation gLA;
    private LinearLayout gLD;
    private EntelechyPullUpRefreshView gLE;
    private EntelechyPullUpRefreshView gLF;
    private NoPressedRelativeLayout gLx;
    private Animation gLz;
    private FrsFragment gpZ;
    private TbImageView gLy = null;
    private int mSkinType = 3;
    private boolean gLB = false;
    private float gLC = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener gLG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gpZ != null) {
                if (view == b.this.gLE) {
                    TiebaStatic.eventStat(b.this.gpZ.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.gpZ.bEq() && b.this.gpZ.bDP() != null) {
                        TiebaStatic.log(new an("c11752").cy("fid", b.this.gpZ.getFid()).cy("obj_locate", "3"));
                        b.this.gpZ.bDP().startPullRefresh();
                    }
                } else if (view == b.this.gLF && b.this.gpZ.bDP() != null && b.this.gpZ.bDP().getListView() != null) {
                    b.this.gpZ.bDP().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gLD = null;
        this.gLE = null;
        this.gLF = null;
        this.gpZ = frsFragment;
        this.gLx = noPressedRelativeLayout;
        bKh();
        this.gLD = (LinearLayout) this.gLx.findViewById(R.id.frs_stick_bottom_holder);
        this.gLF = (EntelechyPullUpRefreshView) this.gLx.findViewById(R.id.frs_stick_bottom_goto_top);
        this.gLE = (EntelechyPullUpRefreshView) this.gLx.findViewById(R.id.frs_stick_bottom_reload);
        this.gLF.setOnClickListener(this.gLG);
        this.gLE.setOnClickListener(this.gLG);
        onChangeSkinType(this.mSkinType);
    }

    private void bKh() {
        this.gLy = new TbImageView(this.gpZ.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.gpZ.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.gLy.setLayoutParams(layoutParams);
        this.gLx.addView(this.gLy);
        this.gLy.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void M(boolean z, boolean z2) {
        if (!this.gLB) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bKk();
                } else {
                    this.gLD.setVisibility(0);
                }
            } else if (z2) {
                bKl();
            } else {
                this.gLD.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bHk() {
        if (this.gLE == null) {
            return false;
        }
        return this.isShow;
    }

    private void bKi() {
        if (this.gpZ.isAdded()) {
            this.gLz = AnimationUtils.loadAnimation(this.gpZ.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.gLz.setAnimationListener(new a(this.gLD));
        }
    }

    private void bKj() {
        if (this.gpZ.isAdded()) {
            this.gLA = AnimationUtils.loadAnimation(this.gpZ.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.gLA.setAnimationListener(new animation.Animation$AnimationListenerC0512b(this.gLD));
        }
    }

    private void bKk() {
        cancelAnimation();
        if (this.gLA == null) {
            bKj();
        }
        if (this.gLA != null) {
            this.gLD.setVisibility(0);
            this.gLD.startAnimation(this.gLA);
        }
    }

    private void cancelAnimation() {
        if (this.gLD != null) {
            this.gLD.clearAnimation();
        }
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bKl() {
        cancelAnimation();
        if (this.gLz == null) {
            bKi();
        }
        if (this.gLz != null) {
            this.gLD.startAnimation(this.gLz);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bHm() {
        if (this.gLE != null && !bO(this.gLE)) {
            this.gLE.bBJ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bHl() {
        if (this.gLE != null && !bO(this.gLE)) {
            this.gLE.bBI();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gLE != null) {
                this.gLE.onChangeSkinType(i);
            }
            if (this.gLF != null) {
                this.gLF.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void lP(boolean z) {
        this.gLB = z;
        if (this.gLE != null) {
            if (z) {
                if (this.gLD != null && this.gLD.getVisibility() == 0) {
                    bKl();
                    return;
                }
                return;
            }
            bKk();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bJN() {
        if (this.gLy != null) {
            this.gLy.clearAnimation();
            this.gLy.setImageDrawable(null);
            this.gLy.setVisibility(8);
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
