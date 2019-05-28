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
    private NoPressedRelativeLayout fLM;
    private Animation fLO;
    private Animation fLP;
    private LinearLayout fLS;
    private EntelechyPullUpRefreshView fLT;
    private EntelechyPullUpRefreshView fLU;
    private FrsFragment fqJ;
    private TbImageView fLN = null;
    private int mSkinType = 3;
    private boolean fLQ = false;
    private float fLR = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener fLV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fqJ != null) {
                if (view == b.this.fLT) {
                    TiebaStatic.eventStat(b.this.fqJ.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.fqJ.bkn() && b.this.fqJ.bjP() != null) {
                        TiebaStatic.log(new am("c11752").bT("fid", b.this.fqJ.getFid()).bT("obj_locate", "3"));
                        b.this.fqJ.bjP().startPullRefresh();
                    }
                } else if (view == b.this.fLU && b.this.fqJ.bjP() != null && b.this.fqJ.bjP().getListView() != null) {
                    b.this.fqJ.bjP().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fLS = null;
        this.fLT = null;
        this.fLU = null;
        this.fqJ = frsFragment;
        this.fLM = noPressedRelativeLayout;
        bqc();
        this.fLS = (LinearLayout) this.fLM.findViewById(R.id.frs_stick_bottom_holder);
        this.fLU = (EntelechyPullUpRefreshView) this.fLM.findViewById(R.id.frs_stick_bottom_goto_top);
        this.fLT = (EntelechyPullUpRefreshView) this.fLM.findViewById(R.id.frs_stick_bottom_reload);
        this.fLU.setOnClickListener(this.fLV);
        this.fLT.setOnClickListener(this.fLV);
        onChangeSkinType(this.mSkinType);
    }

    private void bqc() {
        this.fLN = new TbImageView(this.fqJ.getPageContext().getPageActivity());
        int g = l.g(this.fqJ.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.fLN.setLayoutParams(layoutParams);
        this.fLM.addView(this.fLN);
        this.fLN.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void E(boolean z, boolean z2) {
        if (!this.fLQ) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bqf();
                } else {
                    this.fLS.setVisibility(0);
                }
            } else if (z2) {
                bqg();
            } else {
                this.fLS.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bne() {
        if (this.fLT == null) {
            return false;
        }
        return this.isShow;
    }

    private void bqd() {
        if (this.fqJ.isAdded()) {
            this.fLO = AnimationUtils.loadAnimation(this.fqJ.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.fLO.setAnimationListener(new a(this.fLS));
        }
    }

    private void bqe() {
        if (this.fqJ.isAdded()) {
            this.fLP = AnimationUtils.loadAnimation(this.fqJ.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.fLP.setAnimationListener(new animation.Animation$AnimationListenerC0315b(this.fLS));
        }
    }

    private void bqf() {
        cancelAnimation();
        if (this.fLP == null) {
            bqe();
        }
        if (this.fLP != null) {
            this.fLS.setVisibility(0);
            this.fLS.startAnimation(this.fLP);
        }
    }

    private void cancelAnimation() {
        if (this.fLS != null) {
            this.fLS.clearAnimation();
        }
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bqg() {
        cancelAnimation();
        if (this.fLO == null) {
            bqd();
        }
        if (this.fLO != null) {
            this.fLS.startAnimation(this.fLO);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bng() {
        if (this.fLT != null && !bO(this.fLT)) {
            this.fLT.bgW();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bnf() {
        if (this.fLT != null && !bO(this.fLT)) {
            this.fLT.bgV();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fLT != null) {
                this.fLT.onChangeSkinType(i);
            }
            if (this.fLU != null) {
                this.fLU.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void kp(boolean z) {
        this.fLQ = z;
        if (this.fLT != null) {
            if (z) {
                if (this.fLS != null && this.fLS.getVisibility() == 0) {
                    bqg();
                    return;
                }
                return;
            }
            bqf();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bpG() {
        if (this.fLN != null) {
            this.fLN.clearAnimation();
            this.fLN.setImageDrawable(null);
            this.fLN.setVisibility(8);
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
