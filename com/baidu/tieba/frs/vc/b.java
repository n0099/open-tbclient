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
    private NoPressedRelativeLayout fLO;
    private Animation fLQ;
    private Animation fLR;
    private LinearLayout fLU;
    private EntelechyPullUpRefreshView fLV;
    private EntelechyPullUpRefreshView fLW;
    private FrsFragment fqJ;
    private TbImageView fLP = null;
    private int mSkinType = 3;
    private boolean fLS = false;
    private float fLT = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener fLX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fqJ != null) {
                if (view == b.this.fLV) {
                    TiebaStatic.eventStat(b.this.fqJ.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.fqJ.bkn() && b.this.fqJ.bjP() != null) {
                        TiebaStatic.log(new am("c11752").bT("fid", b.this.fqJ.getFid()).bT("obj_locate", "3"));
                        b.this.fqJ.bjP().startPullRefresh();
                    }
                } else if (view == b.this.fLW && b.this.fqJ.bjP() != null && b.this.fqJ.bjP().getListView() != null) {
                    b.this.fqJ.bjP().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fLU = null;
        this.fLV = null;
        this.fLW = null;
        this.fqJ = frsFragment;
        this.fLO = noPressedRelativeLayout;
        bqe();
        this.fLU = (LinearLayout) this.fLO.findViewById(R.id.frs_stick_bottom_holder);
        this.fLW = (EntelechyPullUpRefreshView) this.fLO.findViewById(R.id.frs_stick_bottom_goto_top);
        this.fLV = (EntelechyPullUpRefreshView) this.fLO.findViewById(R.id.frs_stick_bottom_reload);
        this.fLW.setOnClickListener(this.fLX);
        this.fLV.setOnClickListener(this.fLX);
        onChangeSkinType(this.mSkinType);
    }

    private void bqe() {
        this.fLP = new TbImageView(this.fqJ.getPageContext().getPageActivity());
        int g = l.g(this.fqJ.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.fLP.setLayoutParams(layoutParams);
        this.fLO.addView(this.fLP);
        this.fLP.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void E(boolean z, boolean z2) {
        if (!this.fLS) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bqh();
                } else {
                    this.fLU.setVisibility(0);
                }
            } else if (z2) {
                bqi();
            } else {
                this.fLU.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bne() {
        if (this.fLV == null) {
            return false;
        }
        return this.isShow;
    }

    private void bqf() {
        if (this.fqJ.isAdded()) {
            this.fLQ = AnimationUtils.loadAnimation(this.fqJ.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.fLQ.setAnimationListener(new a(this.fLU));
        }
    }

    private void bqg() {
        if (this.fqJ.isAdded()) {
            this.fLR = AnimationUtils.loadAnimation(this.fqJ.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.fLR.setAnimationListener(new animation.Animation$AnimationListenerC0315b(this.fLU));
        }
    }

    private void bqh() {
        cancelAnimation();
        if (this.fLR == null) {
            bqg();
        }
        if (this.fLR != null) {
            this.fLU.setVisibility(0);
            this.fLU.startAnimation(this.fLR);
        }
    }

    private void cancelAnimation() {
        if (this.fLU != null) {
            this.fLU.clearAnimation();
        }
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bqi() {
        cancelAnimation();
        if (this.fLQ == null) {
            bqf();
        }
        if (this.fLQ != null) {
            this.fLU.startAnimation(this.fLQ);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bng() {
        if (this.fLV != null && !bO(this.fLV)) {
            this.fLV.bgW();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bnf() {
        if (this.fLV != null && !bO(this.fLV)) {
            this.fLV.bgV();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fLV != null) {
                this.fLV.onChangeSkinType(i);
            }
            if (this.fLW != null) {
                this.fLW.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void kp(boolean z) {
        this.fLS = z;
        if (this.fLV != null) {
            if (z) {
                if (this.fLU != null && this.fLU.getVisibility() == 0) {
                    bqi();
                    return;
                }
                return;
            }
            bqh();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bpI() {
        if (this.fLP != null) {
            this.fLP.clearAnimation();
            this.fLP.setImageDrawable(null);
            this.fLP.setVisibility(8);
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
