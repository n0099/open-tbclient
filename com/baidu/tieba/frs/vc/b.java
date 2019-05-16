package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout fLL;
    private Animation fLN;
    private Animation fLO;
    private LinearLayout fLR;
    private EntelechyPullUpRefreshView fLS;
    private EntelechyPullUpRefreshView fLT;
    private FrsFragment fqI;
    private TbImageView fLM = null;
    private int mSkinType = 3;
    private boolean fLP = false;
    private float fLQ = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener fLU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fqI != null) {
                if (view == b.this.fLS) {
                    TiebaStatic.eventStat(b.this.fqI.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.fqI.bkk() && b.this.fqI.bjM() != null) {
                        TiebaStatic.log(new am("c11752").bT("fid", b.this.fqI.getFid()).bT("obj_locate", "3"));
                        b.this.fqI.bjM().startPullRefresh();
                    }
                } else if (view == b.this.fLT && b.this.fqI.bjM() != null && b.this.fqI.bjM().getListView() != null) {
                    b.this.fqI.bjM().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fLR = null;
        this.fLS = null;
        this.fLT = null;
        this.fqI = frsFragment;
        this.fLL = noPressedRelativeLayout;
        bpZ();
        this.fLR = (LinearLayout) this.fLL.findViewById(R.id.frs_stick_bottom_holder);
        this.fLT = (EntelechyPullUpRefreshView) this.fLL.findViewById(R.id.frs_stick_bottom_goto_top);
        this.fLS = (EntelechyPullUpRefreshView) this.fLL.findViewById(R.id.frs_stick_bottom_reload);
        this.fLT.setOnClickListener(this.fLU);
        this.fLS.setOnClickListener(this.fLU);
        onChangeSkinType(this.mSkinType);
    }

    private void bpZ() {
        this.fLM = new TbImageView(this.fqI.getPageContext().getPageActivity());
        int g = l.g(this.fqI.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.fLM.setLayoutParams(layoutParams);
        this.fLL.addView(this.fLM);
        this.fLM.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void E(boolean z, boolean z2) {
        if (!this.fLP) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bqc();
                } else {
                    this.fLR.setVisibility(0);
                }
            } else if (z2) {
                bqd();
            } else {
                this.fLR.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bnb() {
        if (this.fLS == null) {
            return false;
        }
        return this.isShow;
    }

    private void bqa() {
        if (this.fqI.isAdded()) {
            this.fLN = AnimationUtils.loadAnimation(this.fqI.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.fLN.setAnimationListener(new a(this.fLR));
        }
    }

    private void bqb() {
        if (this.fqI.isAdded()) {
            this.fLO = AnimationUtils.loadAnimation(this.fqI.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.fLO.setAnimationListener(new animation.Animation$AnimationListenerC0315b(this.fLR));
        }
    }

    private void bqc() {
        cancelAnimation();
        if (this.fLO == null) {
            bqb();
        }
        if (this.fLO != null) {
            this.fLR.setVisibility(0);
            this.fLR.startAnimation(this.fLO);
        }
    }

    private void cancelAnimation() {
        if (this.fLR != null) {
            this.fLR.clearAnimation();
        }
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bqd() {
        cancelAnimation();
        if (this.fLN == null) {
            bqa();
        }
        if (this.fLN != null) {
            this.fLR.startAnimation(this.fLN);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bnd() {
        if (this.fLS != null && !bO(this.fLS)) {
            this.fLS.bgT();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bnc() {
        if (this.fLS != null && !bO(this.fLS)) {
            this.fLS.bgS();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fLS != null) {
                this.fLS.onChangeSkinType(i);
            }
            if (this.fLT != null) {
                this.fLT.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void kp(boolean z) {
        this.fLP = z;
        if (this.fLS != null) {
            if (z) {
                if (this.fLR != null && this.fLR.getVisibility() == 0) {
                    bqd();
                    return;
                }
                return;
            }
            bqc();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bpD() {
        if (this.fLM != null) {
            this.fLM.clearAnimation();
            this.fLM.setImageDrawable(null);
            this.fLM.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0315b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0315b(View view) {
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
