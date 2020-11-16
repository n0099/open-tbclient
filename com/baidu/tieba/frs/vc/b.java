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
/* loaded from: classes21.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment iKx;
    private NoPressedRelativeLayout jiH;
    private Animation jiJ;
    private Animation jiK;
    private LinearLayout jiN;
    private EntelechyPullUpRefreshView jiO;
    private EntelechyPullUpRefreshView jiP;
    private TbImageView jiI = null;
    private int mSkinType = 3;
    private boolean jiL = false;
    private float jiM = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener jiQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iKx != null) {
                if (view == b.this.jiO) {
                    TiebaStatic.eventStat(b.this.iKx.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.iKx.cyt() && b.this.iKx.cxO() != null) {
                        TiebaStatic.log(new ar("c11752").dR("fid", b.this.iKx.getFid()).dR("obj_locate", "3"));
                        b.this.iKx.cxO().startPullRefresh();
                    }
                } else if (view == b.this.jiP && b.this.iKx.cxO() != null && b.this.iKx.cxO().getListView() != null) {
                    b.this.iKx.cxO().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jiN = null;
        this.jiO = null;
        this.jiP = null;
        this.iKx = frsFragment;
        this.jiH = noPressedRelativeLayout;
        cEU();
        this.jiN = (LinearLayout) this.jiH.findViewById(R.id.frs_stick_bottom_holder);
        this.jiP = (EntelechyPullUpRefreshView) this.jiH.findViewById(R.id.frs_stick_bottom_goto_top);
        this.jiO = (EntelechyPullUpRefreshView) this.jiH.findViewById(R.id.frs_stick_bottom_reload);
        this.jiP.setOnClickListener(this.jiQ);
        this.jiO.setOnClickListener(this.jiQ);
        onChangeSkinType(this.mSkinType);
    }

    private void cEU() {
        this.jiI = new TbImageView(this.iKx.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.iKx.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.jiI.setLayoutParams(layoutParams);
        this.jiH.addView(this.jiI);
        this.jiI.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Y(boolean z, boolean z2) {
        if (!this.jiL) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cEX();
                } else {
                    this.jiN.setVisibility(0);
                }
            } else if (z2) {
                cEY();
            } else {
                this.jiN.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cBM() {
        if (this.jiO == null) {
            return false;
        }
        return this.isShow;
    }

    private void cEV() {
        if (this.iKx.isAdded()) {
            this.jiJ = AnimationUtils.loadAnimation(this.iKx.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.jiJ.setAnimationListener(new a(this.jiN));
        }
    }

    private void cEW() {
        if (this.iKx.isAdded()) {
            this.jiK = AnimationUtils.loadAnimation(this.iKx.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.jiK.setAnimationListener(new animation.Animation$AnimationListenerC0735b(this.jiN));
        }
    }

    private void cEX() {
        cancelAnimation();
        if (this.jiK == null) {
            cEW();
        }
        if (this.jiK != null) {
            this.jiN.setVisibility(0);
            this.jiN.startAnimation(this.jiK);
        }
    }

    private void cancelAnimation() {
        if (this.jiN != null) {
            this.jiN.clearAnimation();
        }
    }

    private void cEY() {
        cancelAnimation();
        if (this.jiJ == null) {
            cEV();
        }
        if (this.jiJ != null) {
            this.jiN.startAnimation(this.jiJ);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jiO != null) {
                this.jiO.onChangeSkinType(i);
            }
            if (this.jiP != null) {
                this.jiP.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void qf(boolean z) {
        this.jiL = z;
        if (this.jiO != null) {
            if (z) {
                if (this.jiN != null && this.jiN.getVisibility() == 0) {
                    cEY();
                    return;
                }
                return;
            }
            cEX();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cEy() {
        if (this.jiI != null) {
            this.jiI.clearAnimation();
            this.jiI.setImageDrawable(null);
            this.jiI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
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
    /* loaded from: classes21.dex */
    public static class animation.Animation$AnimationListenerC0735b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0735b(View view) {
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
