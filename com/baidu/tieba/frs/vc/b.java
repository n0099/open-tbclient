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
    private FrsFragment iDN;
    private NoPressedRelativeLayout jbY;
    private Animation jca;
    private Animation jcb;
    private LinearLayout jce;
    private EntelechyPullUpRefreshView jcf;
    private EntelechyPullUpRefreshView jcg;
    private TbImageView jbZ = null;
    private int mSkinType = 3;
    private boolean jcc = false;
    private float jcd = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener jch = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iDN != null) {
                if (view == b.this.jcf) {
                    TiebaStatic.eventStat(b.this.iDN.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.iDN.cwp() && b.this.iDN.cvK() != null) {
                        TiebaStatic.log(new aq("c11752").dR("fid", b.this.iDN.getFid()).dR("obj_locate", "3"));
                        b.this.iDN.cvK().startPullRefresh();
                    }
                } else if (view == b.this.jcg && b.this.iDN.cvK() != null && b.this.iDN.cvK().getListView() != null) {
                    b.this.iDN.cvK().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jce = null;
        this.jcf = null;
        this.jcg = null;
        this.iDN = frsFragment;
        this.jbY = noPressedRelativeLayout;
        cCO();
        this.jce = (LinearLayout) this.jbY.findViewById(R.id.frs_stick_bottom_holder);
        this.jcg = (EntelechyPullUpRefreshView) this.jbY.findViewById(R.id.frs_stick_bottom_goto_top);
        this.jcf = (EntelechyPullUpRefreshView) this.jbY.findViewById(R.id.frs_stick_bottom_reload);
        this.jcg.setOnClickListener(this.jch);
        this.jcf.setOnClickListener(this.jch);
        onChangeSkinType(this.mSkinType);
    }

    private void cCO() {
        this.jbZ = new TbImageView(this.iDN.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.iDN.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.jbZ.setLayoutParams(layoutParams);
        this.jbY.addView(this.jbZ);
        this.jbZ.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Y(boolean z, boolean z2) {
        if (!this.jcc) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cCR();
                } else {
                    this.jce.setVisibility(0);
                }
            } else if (z2) {
                cCS();
            } else {
                this.jce.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean czI() {
        if (this.jcf == null) {
            return false;
        }
        return this.isShow;
    }

    private void cCP() {
        if (this.iDN.isAdded()) {
            this.jca = AnimationUtils.loadAnimation(this.iDN.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.jca.setAnimationListener(new a(this.jce));
        }
    }

    private void cCQ() {
        if (this.iDN.isAdded()) {
            this.jcb = AnimationUtils.loadAnimation(this.iDN.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.jcb.setAnimationListener(new animation.Animation$AnimationListenerC0720b(this.jce));
        }
    }

    private void cCR() {
        cancelAnimation();
        if (this.jcb == null) {
            cCQ();
        }
        if (this.jcb != null) {
            this.jce.setVisibility(0);
            this.jce.startAnimation(this.jcb);
        }
    }

    private void cancelAnimation() {
        if (this.jce != null) {
            this.jce.clearAnimation();
        }
    }

    private void cCS() {
        cancelAnimation();
        if (this.jca == null) {
            cCP();
        }
        if (this.jca != null) {
            this.jce.startAnimation(this.jca);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jcf != null) {
                this.jcf.onChangeSkinType(i);
            }
            if (this.jcg != null) {
                this.jcg.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void pT(boolean z) {
        this.jcc = z;
        if (this.jcf != null) {
            if (z) {
                if (this.jce != null && this.jce.getVisibility() == 0) {
                    cCS();
                    return;
                }
                return;
            }
            cCR();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cCs() {
        if (this.jbZ != null) {
            this.jbZ.clearAnimation();
            this.jbZ.setImageDrawable(null);
            this.jbZ.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0720b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0720b(View view) {
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
