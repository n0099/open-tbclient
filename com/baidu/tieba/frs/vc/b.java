package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.a.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout jLB;
    private Animation jLD;
    private Animation jLE;
    private LinearLayout jLH;
    private EntelechyPullUpRefreshView jLI;
    private EntelechyPullUpRefreshView jLJ;
    private FrsFragment jkB;
    private TbImageView jLC = null;
    private int mSkinType = 3;
    private boolean jLF = false;
    private float jLG = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener jLK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.jkB != null) {
                if (view == b.this.jLI) {
                    TiebaStatic.eventStat(b.this.jkB.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.jkB.cDn() && b.this.jkB.cCH() != null) {
                        TiebaStatic.log(new ar("c11752").dR("fid", b.this.jkB.getFid()).dR("obj_locate", "3"));
                        b.this.jkB.cCH().startPullRefresh();
                    }
                } else if (view == b.this.jLJ && b.this.jkB.cCH() != null && b.this.jkB.cCH().getListView() != null) {
                    b.this.jkB.cCH().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jLH = null;
        this.jLI = null;
        this.jLJ = null;
        this.jkB = frsFragment;
        this.jLB = noPressedRelativeLayout;
        cKU();
        this.jLH = (LinearLayout) this.jLB.findViewById(R.id.frs_stick_bottom_holder);
        this.jLJ = (EntelechyPullUpRefreshView) this.jLB.findViewById(R.id.frs_stick_bottom_goto_top);
        this.jLI = (EntelechyPullUpRefreshView) this.jLB.findViewById(R.id.frs_stick_bottom_reload);
        this.jLJ.setOnClickListener(this.jLK);
        this.jLI.setOnClickListener(this.jLK);
        onChangeSkinType(this.mSkinType);
    }

    private void cKU() {
        this.jLC = new TbImageView(this.jkB.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jkB.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.jLC.setLayoutParams(layoutParams);
        this.jLB.addView(this.jLC);
        this.jLC.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void aa(boolean z, boolean z2) {
        if (!this.jLF) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cKX();
                } else {
                    this.jLH.setVisibility(0);
                }
            } else if (z2) {
                cKY();
            } else {
                this.jLH.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public boolean cGO() {
        if (this.jLI == null) {
            return false;
        }
        return this.isShow;
    }

    private void cKV() {
        if (this.jkB.isAdded()) {
            this.jLD = AnimationUtils.loadAnimation(this.jkB.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.jLD.setAnimationListener(new a(this.jLH));
        }
    }

    private void cKW() {
        if (this.jkB.isAdded()) {
            this.jLE = AnimationUtils.loadAnimation(this.jkB.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.jLE.setAnimationListener(new animation.Animation$AnimationListenerC0741b(this.jLH));
        }
    }

    private void cKX() {
        cancelAnimation();
        if (this.jLE == null) {
            cKW();
        }
        if (this.jLE != null) {
            this.jLH.setVisibility(0);
            this.jLH.startAnimation(this.jLE);
        }
    }

    private void cancelAnimation() {
        if (this.jLH != null) {
            this.jLH.clearAnimation();
        }
    }

    private void cKY() {
        cancelAnimation();
        if (this.jLD == null) {
            cKV();
        }
        if (this.jLD != null) {
            this.jLH.startAnimation(this.jLD);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jLI != null) {
                this.jLI.onChangeSkinType(i);
            }
            if (this.jLJ != null) {
                this.jLJ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void rg(boolean z) {
        this.jLF = z;
        if (this.jLI != null) {
            if (z) {
                if (this.jLH != null && this.jLH.getVisibility() == 0) {
                    cKY();
                    return;
                }
                return;
            }
            cKX();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cKv() {
        if (this.jLC != null) {
            this.jLC.clearAnimation();
            this.jLC.setImageDrawable(null);
            this.jLC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
    public static class animation.Animation$AnimationListenerC0741b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0741b(View view) {
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
