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
    private NoPressedRelativeLayout fQM;
    private Animation fQO;
    private Animation fQP;
    private LinearLayout fQS;
    private EntelechyPullUpRefreshView fQT;
    private EntelechyPullUpRefreshView fQU;
    private FrsFragment fvH;
    private TbImageView fQN = null;
    private int mSkinType = 3;
    private boolean fQQ = false;
    private float fQR = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener fQV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fvH != null) {
                if (view == b.this.fQT) {
                    TiebaStatic.eventStat(b.this.fvH.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.fvH.bmp() && b.this.fvH.blR() != null) {
                        TiebaStatic.log(new an("c11752").bT("fid", b.this.fvH.getFid()).bT("obj_locate", "3"));
                        b.this.fvH.blR().startPullRefresh();
                    }
                } else if (view == b.this.fQU && b.this.fvH.blR() != null && b.this.fvH.blR().getListView() != null) {
                    b.this.fvH.blR().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fQS = null;
        this.fQT = null;
        this.fQU = null;
        this.fvH = frsFragment;
        this.fQM = noPressedRelativeLayout;
        bsf();
        this.fQS = (LinearLayout) this.fQM.findViewById(R.id.frs_stick_bottom_holder);
        this.fQU = (EntelechyPullUpRefreshView) this.fQM.findViewById(R.id.frs_stick_bottom_goto_top);
        this.fQT = (EntelechyPullUpRefreshView) this.fQM.findViewById(R.id.frs_stick_bottom_reload);
        this.fQU.setOnClickListener(this.fQV);
        this.fQT.setOnClickListener(this.fQV);
        onChangeSkinType(this.mSkinType);
    }

    private void bsf() {
        this.fQN = new TbImageView(this.fvH.getPageContext().getPageActivity());
        int g = l.g(this.fvH.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.fQN.setLayoutParams(layoutParams);
        this.fQM.addView(this.fQN);
        this.fQN.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void H(boolean z, boolean z2) {
        if (!this.fQQ) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bsi();
                } else {
                    this.fQS.setVisibility(0);
                }
            } else if (z2) {
                bsj();
            } else {
                this.fQS.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bpf() {
        if (this.fQT == null) {
            return false;
        }
        return this.isShow;
    }

    private void bsg() {
        if (this.fvH.isAdded()) {
            this.fQO = AnimationUtils.loadAnimation(this.fvH.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.fQO.setAnimationListener(new a(this.fQS));
        }
    }

    private void bsh() {
        if (this.fvH.isAdded()) {
            this.fQP = AnimationUtils.loadAnimation(this.fvH.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.fQP.setAnimationListener(new animation.Animation$AnimationListenerC0312b(this.fQS));
        }
    }

    private void bsi() {
        cancelAnimation();
        if (this.fQP == null) {
            bsh();
        }
        if (this.fQP != null) {
            this.fQS.setVisibility(0);
            this.fQS.startAnimation(this.fQP);
        }
    }

    private void cancelAnimation() {
        if (this.fQS != null) {
            this.fQS.clearAnimation();
        }
    }

    private boolean bQ(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bsj() {
        cancelAnimation();
        if (this.fQO == null) {
            bsg();
        }
        if (this.fQO != null) {
            this.fQS.startAnimation(this.fQO);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bph() {
        if (this.fQT != null && !bQ(this.fQT)) {
            this.fQT.biZ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bpg() {
        if (this.fQT != null && !bQ(this.fQT)) {
            this.fQT.biY();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fQT != null) {
                this.fQT.onChangeSkinType(i);
            }
            if (this.fQU != null) {
                this.fQU.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void kz(boolean z) {
        this.fQQ = z;
        if (this.fQT != null) {
            if (z) {
                if (this.fQS != null && this.fQS.getVisibility() == 0) {
                    bsj();
                    return;
                }
                return;
            }
            bsi();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void brJ() {
        if (this.fQN != null) {
            this.fQN.clearAnimation();
            this.fQN.setImageDrawable(null);
            this.fQN.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0312b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0312b(View view) {
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
