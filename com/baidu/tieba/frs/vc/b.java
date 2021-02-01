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
    private NoPressedRelativeLayout jJE;
    private Animation jJG;
    private Animation jJH;
    private LinearLayout jJK;
    private EntelechyPullUpRefreshView jJL;
    private EntelechyPullUpRefreshView jJM;
    private FrsFragment jiE;
    private TbImageView jJF = null;
    private int mSkinType = 3;
    private boolean jJI = false;
    private float jJJ = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener jJN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.jiE != null) {
                if (view == b.this.jJL) {
                    TiebaStatic.eventStat(b.this.jiE.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.jiE.cDa() && b.this.jiE.cCu() != null) {
                        TiebaStatic.log(new ar("c11752").dR("fid", b.this.jiE.getFid()).dR("obj_locate", "3"));
                        b.this.jiE.cCu().startPullRefresh();
                    }
                } else if (view == b.this.jJM && b.this.jiE.cCu() != null && b.this.jiE.cCu().getListView() != null) {
                    b.this.jiE.cCu().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jJK = null;
        this.jJL = null;
        this.jJM = null;
        this.jiE = frsFragment;
        this.jJE = noPressedRelativeLayout;
        cKH();
        this.jJK = (LinearLayout) this.jJE.findViewById(R.id.frs_stick_bottom_holder);
        this.jJM = (EntelechyPullUpRefreshView) this.jJE.findViewById(R.id.frs_stick_bottom_goto_top);
        this.jJL = (EntelechyPullUpRefreshView) this.jJE.findViewById(R.id.frs_stick_bottom_reload);
        this.jJM.setOnClickListener(this.jJN);
        this.jJL.setOnClickListener(this.jJN);
        onChangeSkinType(this.mSkinType);
    }

    private void cKH() {
        this.jJF = new TbImageView(this.jiE.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jiE.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.jJF.setLayoutParams(layoutParams);
        this.jJE.addView(this.jJF);
        this.jJF.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void aa(boolean z, boolean z2) {
        if (!this.jJI) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cKK();
                } else {
                    this.jJK.setVisibility(0);
                }
            } else if (z2) {
                cKL();
            } else {
                this.jJK.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public boolean cGB() {
        if (this.jJL == null) {
            return false;
        }
        return this.isShow;
    }

    private void cKI() {
        if (this.jiE.isAdded()) {
            this.jJG = AnimationUtils.loadAnimation(this.jiE.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.jJG.setAnimationListener(new a(this.jJK));
        }
    }

    private void cKJ() {
        if (this.jiE.isAdded()) {
            this.jJH = AnimationUtils.loadAnimation(this.jiE.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.jJH.setAnimationListener(new animation.Animation$AnimationListenerC0734b(this.jJK));
        }
    }

    private void cKK() {
        cancelAnimation();
        if (this.jJH == null) {
            cKJ();
        }
        if (this.jJH != null) {
            this.jJK.setVisibility(0);
            this.jJK.startAnimation(this.jJH);
        }
    }

    private void cancelAnimation() {
        if (this.jJK != null) {
            this.jJK.clearAnimation();
        }
    }

    private void cKL() {
        cancelAnimation();
        if (this.jJG == null) {
            cKI();
        }
        if (this.jJG != null) {
            this.jJK.startAnimation(this.jJG);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jJL != null) {
                this.jJL.onChangeSkinType(i);
            }
            if (this.jJM != null) {
                this.jJM.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void rg(boolean z) {
        this.jJI = z;
        if (this.jJL != null) {
            if (z) {
                if (this.jJK != null && this.jJK.getVisibility() == 0) {
                    cKL();
                    return;
                }
                return;
            }
            cKK();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cKi() {
        if (this.jJF != null) {
            this.jJF.clearAnimation();
            this.jJF.setImageDrawable(null);
            this.jJF.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0734b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0734b(View view) {
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
