package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout fSK;
    private Animation fSM;
    private Animation fSN;
    private LinearLayout fSQ;
    private EntelechyPullUpRefreshView fSR;
    private EntelechyPullUpRefreshView fSS;
    private FrsFragment fxh;
    private TbImageView fSL = null;
    private int mSkinType = 3;
    private boolean fSO = false;
    private float fSP = 360.0f;
    private boolean cGJ = true;
    private View.OnClickListener fST = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fxh != null) {
                if (view == b.this.fSR) {
                    TiebaStatic.eventStat(b.this.fxh.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.fxh.bkq() && b.this.fxh.bjP() != null) {
                        TiebaStatic.log(new an("c11752").bS("fid", b.this.fxh.getFid()).bS("obj_locate", "3"));
                        b.this.fxh.bjP().startPullRefresh();
                    }
                } else if (view == b.this.fSS && b.this.fxh.bjP() != null && b.this.fxh.bjP().getListView() != null) {
                    b.this.fxh.bjP().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fSQ = null;
        this.fSR = null;
        this.fSS = null;
        this.fxh = frsFragment;
        this.fSK = noPressedRelativeLayout;
        bqi();
        this.fSQ = (LinearLayout) this.fSK.findViewById(R.id.frs_stick_bottom_holder);
        this.fSS = (EntelechyPullUpRefreshView) this.fSK.findViewById(R.id.frs_stick_bottom_goto_top);
        this.fSR = (EntelechyPullUpRefreshView) this.fSK.findViewById(R.id.frs_stick_bottom_reload);
        this.fSS.setOnClickListener(this.fST);
        this.fSR.setOnClickListener(this.fST);
        onChangeSkinType(this.mSkinType);
    }

    private void bqi() {
        this.fSL = new TbImageView(this.fxh.getPageContext().getPageActivity());
        int dimens = l.getDimens(this.fxh.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.fSL.setLayoutParams(layoutParams);
        this.fSK.addView(this.fSL);
        this.fSL.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void K(boolean z, boolean z2) {
        if (!this.fSO) {
            this.cGJ = z;
            if (z) {
                if (z2) {
                    bql();
                } else {
                    this.fSQ.setVisibility(0);
                }
            } else if (z2) {
                bqm();
            } else {
                this.fSQ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bni() {
        if (this.fSR == null) {
            return false;
        }
        return this.cGJ;
    }

    private void bqj() {
        if (this.fxh.isAdded()) {
            this.fSM = AnimationUtils.loadAnimation(this.fxh.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.fSM.setAnimationListener(new a(this.fSQ));
        }
    }

    private void bqk() {
        if (this.fxh.isAdded()) {
            this.fSN = AnimationUtils.loadAnimation(this.fxh.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.fSN.setAnimationListener(new animation.Animation$AnimationListenerC0418b(this.fSQ));
        }
    }

    private void bql() {
        cancelAnimation();
        if (this.fSN == null) {
            bqk();
        }
        if (this.fSN != null) {
            this.fSQ.setVisibility(0);
            this.fSQ.startAnimation(this.fSN);
        }
    }

    private void cancelAnimation() {
        if (this.fSQ != null) {
            this.fSQ.clearAnimation();
        }
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bqm() {
        cancelAnimation();
        if (this.fSM == null) {
            bqj();
        }
        if (this.fSM != null) {
            this.fSQ.startAnimation(this.fSM);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bnk() {
        if (this.fSR != null && !bO(this.fSR)) {
            this.fSR.bhK();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bnj() {
        if (this.fSR != null && !bO(this.fSR)) {
            this.fSR.bhJ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fSR != null) {
                this.fSR.onChangeSkinType(i);
            }
            if (this.fSS != null) {
                this.fSS.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void kp(boolean z) {
        this.fSO = z;
        if (this.fSR != null) {
            if (z) {
                if (this.fSQ != null && this.fSQ.getVisibility() == 0) {
                    bqm();
                    return;
                }
                return;
            }
            bql();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bpN() {
        if (this.fSL != null) {
            this.fSL.clearAnimation();
            this.fSL.setImageDrawable(null);
            this.fSL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC0418b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0418b(View view) {
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
