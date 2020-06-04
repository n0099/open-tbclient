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
    private NoPressedRelativeLayout hLO;
    private Animation hLQ;
    private Animation hLR;
    private LinearLayout hLU;
    private EntelechyPullUpRefreshView hLV;
    private EntelechyPullUpRefreshView hLW;
    private FrsFragment hpm;
    private TbImageView hLP = null;
    private int mSkinType = 3;
    private boolean hLS = false;
    private float hLT = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener hLX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hpm != null) {
                if (view == b.this.hLV) {
                    TiebaStatic.eventStat(b.this.hpm.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.hpm.bVv() && b.this.hpm.bUT() != null) {
                        TiebaStatic.log(new an("c11752").dh("fid", b.this.hpm.getFid()).dh("obj_locate", "3"));
                        b.this.hpm.bUT().startPullRefresh();
                    }
                } else if (view == b.this.hLW && b.this.hpm.bUT() != null && b.this.hpm.bUT().getListView() != null) {
                    b.this.hpm.bUT().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.hLU = null;
        this.hLV = null;
        this.hLW = null;
        this.hpm = frsFragment;
        this.hLO = noPressedRelativeLayout;
        cbw();
        this.hLU = (LinearLayout) this.hLO.findViewById(R.id.frs_stick_bottom_holder);
        this.hLW = (EntelechyPullUpRefreshView) this.hLO.findViewById(R.id.frs_stick_bottom_goto_top);
        this.hLV = (EntelechyPullUpRefreshView) this.hLO.findViewById(R.id.frs_stick_bottom_reload);
        this.hLW.setOnClickListener(this.hLX);
        this.hLV.setOnClickListener(this.hLX);
        onChangeSkinType(this.mSkinType);
    }

    private void cbw() {
        this.hLP = new TbImageView(this.hpm.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.hpm.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.hLP.setLayoutParams(layoutParams);
        this.hLO.addView(this.hLP);
        this.hLP.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void P(boolean z, boolean z2) {
        if (!this.hLS) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cbz();
                } else {
                    this.hLU.setVisibility(0);
                }
            } else if (z2) {
                cbA();
            } else {
                this.hLU.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bYy() {
        if (this.hLV == null) {
            return false;
        }
        return this.isShow;
    }

    private void cbx() {
        if (this.hpm.isAdded()) {
            this.hLQ = AnimationUtils.loadAnimation(this.hpm.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.hLQ.setAnimationListener(new a(this.hLU));
        }
    }

    private void cby() {
        if (this.hpm.isAdded()) {
            this.hLR = AnimationUtils.loadAnimation(this.hpm.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.hLR.setAnimationListener(new animation.Animation$AnimationListenerC0619b(this.hLU));
        }
    }

    private void cbz() {
        cancelAnimation();
        if (this.hLR == null) {
            cby();
        }
        if (this.hLR != null) {
            this.hLU.setVisibility(0);
            this.hLU.startAnimation(this.hLR);
        }
    }

    private void cancelAnimation() {
        if (this.hLU != null) {
            this.hLU.clearAnimation();
        }
    }

    private void cbA() {
        cancelAnimation();
        if (this.hLQ == null) {
            cbx();
        }
        if (this.hLQ != null) {
            this.hLU.startAnimation(this.hLQ);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hLV != null) {
                this.hLV.onChangeSkinType(i);
            }
            if (this.hLW != null) {
                this.hLW.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void nt(boolean z) {
        this.hLS = z;
        if (this.hLV != null) {
            if (z) {
                if (this.hLU != null && this.hLU.getVisibility() == 0) {
                    cbA();
                    return;
                }
                return;
            }
            cbz();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cbc() {
        if (this.hLP != null) {
            this.hLP.clearAnimation();
            this.hLP.setImageDrawable(null);
            this.hLP.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0619b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0619b(View view) {
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
