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
    private NoPressedRelativeLayout iPC;
    private Animation iPE;
    private Animation iPF;
    private LinearLayout iPI;
    private EntelechyPullUpRefreshView iPJ;
    private EntelechyPullUpRefreshView iPK;
    private FrsFragment irr;
    private TbImageView iPD = null;
    private int mSkinType = 3;
    private boolean iPG = false;
    private float iPH = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener iPL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.irr != null) {
                if (view == b.this.iPJ) {
                    TiebaStatic.eventStat(b.this.irr.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.irr.cti() && b.this.irr.csD() != null) {
                        TiebaStatic.log(new aq("c11752").dK("fid", b.this.irr.getFid()).dK("obj_locate", "3"));
                        b.this.irr.csD().startPullRefresh();
                    }
                } else if (view == b.this.iPK && b.this.irr.csD() != null && b.this.irr.csD().getListView() != null) {
                    b.this.irr.csD().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.iPI = null;
        this.iPJ = null;
        this.iPK = null;
        this.irr = frsFragment;
        this.iPC = noPressedRelativeLayout;
        czH();
        this.iPI = (LinearLayout) this.iPC.findViewById(R.id.frs_stick_bottom_holder);
        this.iPK = (EntelechyPullUpRefreshView) this.iPC.findViewById(R.id.frs_stick_bottom_goto_top);
        this.iPJ = (EntelechyPullUpRefreshView) this.iPC.findViewById(R.id.frs_stick_bottom_reload);
        this.iPK.setOnClickListener(this.iPL);
        this.iPJ.setOnClickListener(this.iPL);
        onChangeSkinType(this.mSkinType);
    }

    private void czH() {
        this.iPD = new TbImageView(this.irr.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.irr.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.iPD.setLayoutParams(layoutParams);
        this.iPC.addView(this.iPD);
        this.iPD.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void V(boolean z, boolean z2) {
        if (!this.iPG) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    czK();
                } else {
                    this.iPI.setVisibility(0);
                }
            } else if (z2) {
                czL();
            } else {
                this.iPI.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cwB() {
        if (this.iPJ == null) {
            return false;
        }
        return this.isShow;
    }

    private void czI() {
        if (this.irr.isAdded()) {
            this.iPE = AnimationUtils.loadAnimation(this.irr.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.iPE.setAnimationListener(new a(this.iPI));
        }
    }

    private void czJ() {
        if (this.irr.isAdded()) {
            this.iPF = AnimationUtils.loadAnimation(this.irr.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.iPF.setAnimationListener(new animation.Animation$AnimationListenerC0704b(this.iPI));
        }
    }

    private void czK() {
        cancelAnimation();
        if (this.iPF == null) {
            czJ();
        }
        if (this.iPF != null) {
            this.iPI.setVisibility(0);
            this.iPI.startAnimation(this.iPF);
        }
    }

    private void cancelAnimation() {
        if (this.iPI != null) {
            this.iPI.clearAnimation();
        }
    }

    private void czL() {
        cancelAnimation();
        if (this.iPE == null) {
            czI();
        }
        if (this.iPE != null) {
            this.iPI.startAnimation(this.iPE);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iPJ != null) {
                this.iPJ.onChangeSkinType(i);
            }
            if (this.iPK != null) {
                this.iPK.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void pB(boolean z) {
        this.iPG = z;
        if (this.iPJ != null) {
            if (z) {
                if (this.iPI != null && this.iPI.getVisibility() == 0) {
                    czL();
                    return;
                }
                return;
            }
            czK();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void czl() {
        if (this.iPD != null) {
            this.iPD.clearAnimation();
            this.iPD.setImageDrawable(null);
            this.iPD.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0704b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0704b(View view) {
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
