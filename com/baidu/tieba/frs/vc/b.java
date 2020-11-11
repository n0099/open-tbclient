package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes22.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment iJK;
    private NoPressedRelativeLayout jhV;
    private Animation jhX;
    private Animation jhY;
    private LinearLayout jib;
    private EntelechyPullUpRefreshView jic;
    private EntelechyPullUpRefreshView jie;
    private TbImageView jhW = null;
    private int mSkinType = 3;
    private boolean jhZ = false;
    private float jia = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener jif = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iJK != null) {
                if (view == b.this.jic) {
                    TiebaStatic.eventStat(b.this.iJK.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.iJK.cyQ() && b.this.iJK.cyl() != null) {
                        TiebaStatic.log(new aq("c11752").dR("fid", b.this.iJK.getFid()).dR("obj_locate", "3"));
                        b.this.iJK.cyl().startPullRefresh();
                    }
                } else if (view == b.this.jie && b.this.iJK.cyl() != null && b.this.iJK.cyl().getListView() != null) {
                    b.this.iJK.cyl().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jib = null;
        this.jic = null;
        this.jie = null;
        this.iJK = frsFragment;
        this.jhV = noPressedRelativeLayout;
        cFp();
        this.jib = (LinearLayout) this.jhV.findViewById(R.id.frs_stick_bottom_holder);
        this.jie = (EntelechyPullUpRefreshView) this.jhV.findViewById(R.id.frs_stick_bottom_goto_top);
        this.jic = (EntelechyPullUpRefreshView) this.jhV.findViewById(R.id.frs_stick_bottom_reload);
        this.jie.setOnClickListener(this.jif);
        this.jic.setOnClickListener(this.jif);
        onChangeSkinType(this.mSkinType);
    }

    private void cFp() {
        this.jhW = new TbImageView(this.iJK.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.iJK.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.jhW.setLayoutParams(layoutParams);
        this.jhV.addView(this.jhW);
        this.jhW.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Y(boolean z, boolean z2) {
        if (!this.jhZ) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cFs();
                } else {
                    this.jib.setVisibility(0);
                }
            } else if (z2) {
                cFt();
            } else {
                this.jib.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cCj() {
        if (this.jic == null) {
            return false;
        }
        return this.isShow;
    }

    private void cFq() {
        if (this.iJK.isAdded()) {
            this.jhX = AnimationUtils.loadAnimation(this.iJK.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.jhX.setAnimationListener(new a(this.jib));
        }
    }

    private void cFr() {
        if (this.iJK.isAdded()) {
            this.jhY = AnimationUtils.loadAnimation(this.iJK.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.jhY.setAnimationListener(new animation.Animation$AnimationListenerC0734b(this.jib));
        }
    }

    private void cFs() {
        cancelAnimation();
        if (this.jhY == null) {
            cFr();
        }
        if (this.jhY != null) {
            this.jib.setVisibility(0);
            this.jib.startAnimation(this.jhY);
        }
    }

    private void cancelAnimation() {
        if (this.jib != null) {
            this.jib.clearAnimation();
        }
    }

    private void cFt() {
        cancelAnimation();
        if (this.jhX == null) {
            cFq();
        }
        if (this.jhX != null) {
            this.jib.startAnimation(this.jhX);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jic != null) {
                this.jic.onChangeSkinType(i);
            }
            if (this.jie != null) {
                this.jie.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void qc(boolean z) {
        this.jhZ = z;
        if (this.jic != null) {
            if (z) {
                if (this.jib != null && this.jib.getVisibility() == 0) {
                    cFt();
                    return;
                }
                return;
            }
            cFs();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cET() {
        if (this.jhW != null) {
            this.jhW.clearAnimation();
            this.jhW.setImageDrawable(null);
            this.jhW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
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
    /* loaded from: classes22.dex */
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
