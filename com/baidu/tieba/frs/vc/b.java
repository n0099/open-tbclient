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
    private NoPressedRelativeLayout gLJ;
    private Animation gLL;
    private Animation gLM;
    private LinearLayout gLP;
    private EntelechyPullUpRefreshView gLQ;
    private EntelechyPullUpRefreshView gLR;
    private FrsFragment gqm;
    private TbImageView gLK = null;
    private int mSkinType = 3;
    private boolean gLN = false;
    private float gLO = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener gLS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gqm != null) {
                if (view == b.this.gLQ) {
                    TiebaStatic.eventStat(b.this.gqm.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.gqm.bEr() && b.this.gqm.bDQ() != null) {
                        TiebaStatic.log(new an("c11752").cy("fid", b.this.gqm.getFid()).cy("obj_locate", "3"));
                        b.this.gqm.bDQ().startPullRefresh();
                    }
                } else if (view == b.this.gLR && b.this.gqm.bDQ() != null && b.this.gqm.bDQ().getListView() != null) {
                    b.this.gqm.bDQ().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gLP = null;
        this.gLQ = null;
        this.gLR = null;
        this.gqm = frsFragment;
        this.gLJ = noPressedRelativeLayout;
        bKi();
        this.gLP = (LinearLayout) this.gLJ.findViewById(R.id.frs_stick_bottom_holder);
        this.gLR = (EntelechyPullUpRefreshView) this.gLJ.findViewById(R.id.frs_stick_bottom_goto_top);
        this.gLQ = (EntelechyPullUpRefreshView) this.gLJ.findViewById(R.id.frs_stick_bottom_reload);
        this.gLR.setOnClickListener(this.gLS);
        this.gLQ.setOnClickListener(this.gLS);
        onChangeSkinType(this.mSkinType);
    }

    private void bKi() {
        this.gLK = new TbImageView(this.gqm.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.gqm.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.gLK.setLayoutParams(layoutParams);
        this.gLJ.addView(this.gLK);
        this.gLK.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void M(boolean z, boolean z2) {
        if (!this.gLN) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bKl();
                } else {
                    this.gLP.setVisibility(0);
                }
            } else if (z2) {
                bKm();
            } else {
                this.gLP.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bHl() {
        if (this.gLQ == null) {
            return false;
        }
        return this.isShow;
    }

    private void bKj() {
        if (this.gqm.isAdded()) {
            this.gLL = AnimationUtils.loadAnimation(this.gqm.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.gLL.setAnimationListener(new a(this.gLP));
        }
    }

    private void bKk() {
        if (this.gqm.isAdded()) {
            this.gLM = AnimationUtils.loadAnimation(this.gqm.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.gLM.setAnimationListener(new animation.Animation$AnimationListenerC0512b(this.gLP));
        }
    }

    private void bKl() {
        cancelAnimation();
        if (this.gLM == null) {
            bKk();
        }
        if (this.gLM != null) {
            this.gLP.setVisibility(0);
            this.gLP.startAnimation(this.gLM);
        }
    }

    private void cancelAnimation() {
        if (this.gLP != null) {
            this.gLP.clearAnimation();
        }
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bKm() {
        cancelAnimation();
        if (this.gLL == null) {
            bKj();
        }
        if (this.gLL != null) {
            this.gLP.startAnimation(this.gLL);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bHn() {
        if (this.gLQ != null && !bO(this.gLQ)) {
            this.gLQ.bBK();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bHm() {
        if (this.gLQ != null && !bO(this.gLQ)) {
            this.gLQ.bBJ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gLQ != null) {
                this.gLQ.onChangeSkinType(i);
            }
            if (this.gLR != null) {
                this.gLR.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void lP(boolean z) {
        this.gLN = z;
        if (this.gLQ != null) {
            if (z) {
                if (this.gLP != null && this.gLP.getVisibility() == 0) {
                    bKm();
                    return;
                }
                return;
            }
            bKl();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bJO() {
        if (this.gLK != null) {
            this.gLK.clearAnimation();
            this.gLK.setImageDrawable(null);
            this.gLK.setVisibility(8);
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
