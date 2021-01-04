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
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.a.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout jIG;
    private Animation jII;
    private Animation jIJ;
    private LinearLayout jIM;
    private EntelechyPullUpRefreshView jIN;
    private EntelechyPullUpRefreshView jIO;
    private FrsFragment jhE;
    private TbImageView jIH = null;
    private int mSkinType = 3;
    private boolean jIK = false;
    private float jIL = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener jIP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.jhE != null) {
                if (view == b.this.jIN) {
                    TiebaStatic.eventStat(b.this.jhE.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.jhE.cFF() && b.this.jhE.cEZ() != null) {
                        TiebaStatic.log(new aq("c11752").dX("fid", b.this.jhE.getFid()).dX("obj_locate", "3"));
                        b.this.jhE.cEZ().startPullRefresh();
                    }
                } else if (view == b.this.jIO && b.this.jhE.cEZ() != null && b.this.jhE.cEZ().getListView() != null) {
                    b.this.jhE.cEZ().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jIM = null;
        this.jIN = null;
        this.jIO = null;
        this.jhE = frsFragment;
        this.jIG = noPressedRelativeLayout;
        cNl();
        this.jIM = (LinearLayout) this.jIG.findViewById(R.id.frs_stick_bottom_holder);
        this.jIO = (EntelechyPullUpRefreshView) this.jIG.findViewById(R.id.frs_stick_bottom_goto_top);
        this.jIN = (EntelechyPullUpRefreshView) this.jIG.findViewById(R.id.frs_stick_bottom_reload);
        this.jIO.setOnClickListener(this.jIP);
        this.jIN.setOnClickListener(this.jIP);
        onChangeSkinType(this.mSkinType);
    }

    private void cNl() {
        this.jIH = new TbImageView(this.jhE.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jhE.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.jIH.setLayoutParams(layoutParams);
        this.jIG.addView(this.jIH);
        this.jIH.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void aa(boolean z, boolean z2) {
        if (!this.jIK) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cNo();
                } else {
                    this.jIM.setVisibility(0);
                }
            } else if (z2) {
                cNp();
            } else {
                this.jIM.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public boolean cJf() {
        if (this.jIN == null) {
            return false;
        }
        return this.isShow;
    }

    private void cNm() {
        if (this.jhE.isAdded()) {
            this.jII = AnimationUtils.loadAnimation(this.jhE.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.jII.setAnimationListener(new a(this.jIM));
        }
    }

    private void cNn() {
        if (this.jhE.isAdded()) {
            this.jIJ = AnimationUtils.loadAnimation(this.jhE.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.jIJ.setAnimationListener(new animation.Animation$AnimationListenerC0744b(this.jIM));
        }
    }

    private void cNo() {
        cancelAnimation();
        if (this.jIJ == null) {
            cNn();
        }
        if (this.jIJ != null) {
            this.jIM.setVisibility(0);
            this.jIM.startAnimation(this.jIJ);
        }
    }

    private void cancelAnimation() {
        if (this.jIM != null) {
            this.jIM.clearAnimation();
        }
    }

    private void cNp() {
        cancelAnimation();
        if (this.jII == null) {
            cNm();
        }
        if (this.jII != null) {
            this.jIM.startAnimation(this.jII);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jIN != null) {
                this.jIN.onChangeSkinType(i);
            }
            if (this.jIO != null) {
                this.jIO.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void ra(boolean z) {
        this.jIK = z;
        if (this.jIN != null) {
            if (z) {
                if (this.jIM != null && this.jIM.getVisibility() == 0) {
                    cNp();
                    return;
                }
                return;
            }
            cNo();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cMM() {
        if (this.jIH != null) {
            this.jIH.clearAnimation();
            this.jIH.setImageDrawable(null);
            this.jIH.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0744b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0744b(View view) {
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
