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
/* loaded from: classes7.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private LinearLayout gJC;
    private EntelechyPullUpRefreshView gJD;
    private EntelechyPullUpRefreshView gJE;
    private NoPressedRelativeLayout gJw;
    private Animation gJy;
    private Animation gJz;
    private FrsFragment gnW;
    private TbImageView gJx = null;
    private int mSkinType = 3;
    private boolean gJA = false;
    private float gJB = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener gJF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gnW != null) {
                if (view == b.this.gJD) {
                    TiebaStatic.eventStat(b.this.gnW.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.gnW.bCL() && b.this.gnW.bCk() != null) {
                        TiebaStatic.log(new an("c11752").cp("fid", b.this.gnW.getFid()).cp("obj_locate", "3"));
                        b.this.gnW.bCk().startPullRefresh();
                    }
                } else if (view == b.this.gJE && b.this.gnW.bCk() != null && b.this.gnW.bCk().getListView() != null) {
                    b.this.gnW.bCk().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gJC = null;
        this.gJD = null;
        this.gJE = null;
        this.gnW = frsFragment;
        this.gJw = noPressedRelativeLayout;
        bID();
        this.gJC = (LinearLayout) this.gJw.findViewById(R.id.frs_stick_bottom_holder);
        this.gJE = (EntelechyPullUpRefreshView) this.gJw.findViewById(R.id.frs_stick_bottom_goto_top);
        this.gJD = (EntelechyPullUpRefreshView) this.gJw.findViewById(R.id.frs_stick_bottom_reload);
        this.gJE.setOnClickListener(this.gJF);
        this.gJD.setOnClickListener(this.gJF);
        onChangeSkinType(this.mSkinType);
    }

    private void bID() {
        this.gJx = new TbImageView(this.gnW.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.gnW.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.gJx.setLayoutParams(layoutParams);
        this.gJw.addView(this.gJx);
        this.gJx.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void K(boolean z, boolean z2) {
        if (!this.gJA) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bIG();
                } else {
                    this.gJC.setVisibility(0);
                }
            } else if (z2) {
                bIH();
            } else {
                this.gJC.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bFG() {
        if (this.gJD == null) {
            return false;
        }
        return this.isShow;
    }

    private void bIE() {
        if (this.gnW.isAdded()) {
            this.gJy = AnimationUtils.loadAnimation(this.gnW.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.gJy.setAnimationListener(new a(this.gJC));
        }
    }

    private void bIF() {
        if (this.gnW.isAdded()) {
            this.gJz = AnimationUtils.loadAnimation(this.gnW.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.gJz.setAnimationListener(new animation.Animation$AnimationListenerC0505b(this.gJC));
        }
    }

    private void bIG() {
        cancelAnimation();
        if (this.gJz == null) {
            bIF();
        }
        if (this.gJz != null) {
            this.gJC.setVisibility(0);
            this.gJC.startAnimation(this.gJz);
        }
    }

    private void cancelAnimation() {
        if (this.gJC != null) {
            this.gJC.clearAnimation();
        }
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bIH() {
        cancelAnimation();
        if (this.gJy == null) {
            bIE();
        }
        if (this.gJy != null) {
            this.gJC.startAnimation(this.gJy);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bFI() {
        if (this.gJD != null && !bO(this.gJD)) {
            this.gJD.bAf();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bFH() {
        if (this.gJD != null && !bO(this.gJD)) {
            this.gJD.bAe();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gJD != null) {
                this.gJD.onChangeSkinType(i);
            }
            if (this.gJE != null) {
                this.gJE.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void lM(boolean z) {
        this.gJA = z;
        if (this.gJD != null) {
            if (z) {
                if (this.gJC != null && this.gJC.getVisibility() == 0) {
                    bIH();
                    return;
                }
                return;
            }
            bIG();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bIj() {
        if (this.gJx != null) {
            this.gJx.clearAnimation();
            this.gJx.setImageDrawable(null);
            this.gJx.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
    /* loaded from: classes7.dex */
    public static class animation.Animation$AnimationListenerC0505b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0505b(View view) {
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
