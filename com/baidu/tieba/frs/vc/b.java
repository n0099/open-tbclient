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
    private NoPressedRelativeLayout jEa;
    private Animation jEc;
    private Animation jEd;
    private LinearLayout jEg;
    private EntelechyPullUpRefreshView jEh;
    private EntelechyPullUpRefreshView jEi;
    private FrsFragment jcX;
    private TbImageView jEb = null;
    private int mSkinType = 3;
    private boolean jEe = false;
    private float jEf = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener jEj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.jcX != null) {
                if (view == b.this.jEh) {
                    TiebaStatic.eventStat(b.this.jcX.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.jcX.cBO() && b.this.jcX.cBi() != null) {
                        TiebaStatic.log(new aq("c11752").dW("fid", b.this.jcX.getFid()).dW("obj_locate", "3"));
                        b.this.jcX.cBi().startPullRefresh();
                    }
                } else if (view == b.this.jEi && b.this.jcX.cBi() != null && b.this.jcX.cBi().getListView() != null) {
                    b.this.jcX.cBi().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jEg = null;
        this.jEh = null;
        this.jEi = null;
        this.jcX = frsFragment;
        this.jEa = noPressedRelativeLayout;
        cJu();
        this.jEg = (LinearLayout) this.jEa.findViewById(R.id.frs_stick_bottom_holder);
        this.jEi = (EntelechyPullUpRefreshView) this.jEa.findViewById(R.id.frs_stick_bottom_goto_top);
        this.jEh = (EntelechyPullUpRefreshView) this.jEa.findViewById(R.id.frs_stick_bottom_reload);
        this.jEi.setOnClickListener(this.jEj);
        this.jEh.setOnClickListener(this.jEj);
        onChangeSkinType(this.mSkinType);
    }

    private void cJu() {
        this.jEb = new TbImageView(this.jcX.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jcX.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.jEb.setLayoutParams(layoutParams);
        this.jEa.addView(this.jEb);
        this.jEb.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void aa(boolean z, boolean z2) {
        if (!this.jEe) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cJx();
                } else {
                    this.jEg.setVisibility(0);
                }
            } else if (z2) {
                cJy();
            } else {
                this.jEg.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public boolean cFo() {
        if (this.jEh == null) {
            return false;
        }
        return this.isShow;
    }

    private void cJv() {
        if (this.jcX.isAdded()) {
            this.jEc = AnimationUtils.loadAnimation(this.jcX.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.jEc.setAnimationListener(new a(this.jEg));
        }
    }

    private void cJw() {
        if (this.jcX.isAdded()) {
            this.jEd = AnimationUtils.loadAnimation(this.jcX.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.jEd.setAnimationListener(new animation.Animation$AnimationListenerC0734b(this.jEg));
        }
    }

    private void cJx() {
        cancelAnimation();
        if (this.jEd == null) {
            cJw();
        }
        if (this.jEd != null) {
            this.jEg.setVisibility(0);
            this.jEg.startAnimation(this.jEd);
        }
    }

    private void cancelAnimation() {
        if (this.jEg != null) {
            this.jEg.clearAnimation();
        }
    }

    private void cJy() {
        cancelAnimation();
        if (this.jEc == null) {
            cJv();
        }
        if (this.jEc != null) {
            this.jEg.startAnimation(this.jEc);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jEh != null) {
                this.jEh.onChangeSkinType(i);
            }
            if (this.jEi != null) {
                this.jEi.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void qW(boolean z) {
        this.jEe = z;
        if (this.jEh != null) {
            if (z) {
                if (this.jEg != null && this.jEg.getVisibility() == 0) {
                    cJy();
                    return;
                }
                return;
            }
            cJx();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cIV() {
        if (this.jEb != null) {
            this.jEb.clearAnimation();
            this.jEb.setImageDrawable(null);
            this.jEb.setVisibility(8);
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
