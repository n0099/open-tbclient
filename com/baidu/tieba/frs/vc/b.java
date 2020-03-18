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
    private NoPressedRelativeLayout gMO;
    private Animation gMQ;
    private Animation gMR;
    private LinearLayout gMU;
    private EntelechyPullUpRefreshView gMV;
    private EntelechyPullUpRefreshView gMW;
    private FrsFragment gqW;
    private TbImageView gMP = null;
    private int mSkinType = 3;
    private boolean gMS = false;
    private float gMT = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener gMX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gqW != null) {
                if (view == b.this.gMV) {
                    TiebaStatic.eventStat(b.this.gqW.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.gqW.bEA() && b.this.gqW.bDY() != null) {
                        TiebaStatic.log(new an("c11752").cx("fid", b.this.gqW.getFid()).cx("obj_locate", "3"));
                        b.this.gqW.bDY().startPullRefresh();
                    }
                } else if (view == b.this.gMW && b.this.gqW.bDY() != null && b.this.gqW.bDY().getListView() != null) {
                    b.this.gqW.bDY().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gMU = null;
        this.gMV = null;
        this.gMW = null;
        this.gqW = frsFragment;
        this.gMO = noPressedRelativeLayout;
        bKv();
        this.gMU = (LinearLayout) this.gMO.findViewById(R.id.frs_stick_bottom_holder);
        this.gMW = (EntelechyPullUpRefreshView) this.gMO.findViewById(R.id.frs_stick_bottom_goto_top);
        this.gMV = (EntelechyPullUpRefreshView) this.gMO.findViewById(R.id.frs_stick_bottom_reload);
        this.gMW.setOnClickListener(this.gMX);
        this.gMV.setOnClickListener(this.gMX);
        onChangeSkinType(this.mSkinType);
    }

    private void bKv() {
        this.gMP = new TbImageView(this.gqW.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.gqW.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.gMP.setLayoutParams(layoutParams);
        this.gMO.addView(this.gMP);
        this.gMP.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void M(boolean z, boolean z2) {
        if (!this.gMS) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bKy();
                } else {
                    this.gMU.setVisibility(0);
                }
            } else if (z2) {
                bKz();
            } else {
                this.gMU.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bHA() {
        if (this.gMV == null) {
            return false;
        }
        return this.isShow;
    }

    private void bKw() {
        if (this.gqW.isAdded()) {
            this.gMQ = AnimationUtils.loadAnimation(this.gqW.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.gMQ.setAnimationListener(new a(this.gMU));
        }
    }

    private void bKx() {
        if (this.gqW.isAdded()) {
            this.gMR = AnimationUtils.loadAnimation(this.gqW.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.gMR.setAnimationListener(new animation.Animation$AnimationListenerC0512b(this.gMU));
        }
    }

    private void bKy() {
        cancelAnimation();
        if (this.gMR == null) {
            bKx();
        }
        if (this.gMR != null) {
            this.gMU.setVisibility(0);
            this.gMU.startAnimation(this.gMR);
        }
    }

    private void cancelAnimation() {
        if (this.gMU != null) {
            this.gMU.clearAnimation();
        }
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bKz() {
        cancelAnimation();
        if (this.gMQ == null) {
            bKw();
        }
        if (this.gMQ != null) {
            this.gMU.startAnimation(this.gMQ);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bHC() {
        if (this.gMV != null && !bO(this.gMV)) {
            this.gMV.bBQ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bHB() {
        if (this.gMV != null && !bO(this.gMV)) {
            this.gMV.bBP();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gMV != null) {
                this.gMV.onChangeSkinType(i);
            }
            if (this.gMW != null) {
                this.gMW.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void lU(boolean z) {
        this.gMS = z;
        if (this.gMV != null) {
            if (z) {
                if (this.gMU != null && this.gMU.getVisibility() == 0) {
                    bKz();
                    return;
                }
                return;
            }
            bKy();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bKb() {
        if (this.gMP != null) {
            this.gMP.clearAnimation();
            this.gMP.setImageDrawable(null);
            this.gMP.setVisibility(8);
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
