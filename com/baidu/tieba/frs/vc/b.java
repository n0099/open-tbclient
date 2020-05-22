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
    private NoPressedRelativeLayout hLb;
    private Animation hLd;
    private Animation hLe;
    private LinearLayout hLh;
    private EntelechyPullUpRefreshView hLi;
    private EntelechyPullUpRefreshView hLj;
    private FrsFragment hpb;
    private TbImageView hLc = null;
    private int mSkinType = 3;
    private boolean hLf = false;
    private float hLg = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener hLk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hpb != null) {
                if (view == b.this.hLi) {
                    TiebaStatic.eventStat(b.this.hpb.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.hpb.bVt() && b.this.hpb.bUR() != null) {
                        TiebaStatic.log(new an("c11752").dh("fid", b.this.hpb.getFid()).dh("obj_locate", "3"));
                        b.this.hpb.bUR().startPullRefresh();
                    }
                } else if (view == b.this.hLj && b.this.hpb.bUR() != null && b.this.hpb.bUR().getListView() != null) {
                    b.this.hpb.bUR().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.hLh = null;
        this.hLi = null;
        this.hLj = null;
        this.hpb = frsFragment;
        this.hLb = noPressedRelativeLayout;
        cbo();
        this.hLh = (LinearLayout) this.hLb.findViewById(R.id.frs_stick_bottom_holder);
        this.hLj = (EntelechyPullUpRefreshView) this.hLb.findViewById(R.id.frs_stick_bottom_goto_top);
        this.hLi = (EntelechyPullUpRefreshView) this.hLb.findViewById(R.id.frs_stick_bottom_reload);
        this.hLj.setOnClickListener(this.hLk);
        this.hLi.setOnClickListener(this.hLk);
        onChangeSkinType(this.mSkinType);
    }

    private void cbo() {
        this.hLc = new TbImageView(this.hpb.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.hpb.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.hLc.setLayoutParams(layoutParams);
        this.hLb.addView(this.hLc);
        this.hLc.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void P(boolean z, boolean z2) {
        if (!this.hLf) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cbr();
                } else {
                    this.hLh.setVisibility(0);
                }
            } else if (z2) {
                cbs();
            } else {
                this.hLh.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bYv() {
        if (this.hLi == null) {
            return false;
        }
        return this.isShow;
    }

    private void cbp() {
        if (this.hpb.isAdded()) {
            this.hLd = AnimationUtils.loadAnimation(this.hpb.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.hLd.setAnimationListener(new a(this.hLh));
        }
    }

    private void cbq() {
        if (this.hpb.isAdded()) {
            this.hLe = AnimationUtils.loadAnimation(this.hpb.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.hLe.setAnimationListener(new animation.Animation$AnimationListenerC0619b(this.hLh));
        }
    }

    private void cbr() {
        cancelAnimation();
        if (this.hLe == null) {
            cbq();
        }
        if (this.hLe != null) {
            this.hLh.setVisibility(0);
            this.hLh.startAnimation(this.hLe);
        }
    }

    private void cancelAnimation() {
        if (this.hLh != null) {
            this.hLh.clearAnimation();
        }
    }

    private void cbs() {
        cancelAnimation();
        if (this.hLd == null) {
            cbp();
        }
        if (this.hLd != null) {
            this.hLh.startAnimation(this.hLd);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hLi != null) {
                this.hLi.onChangeSkinType(i);
            }
            if (this.hLj != null) {
                this.hLj.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void nt(boolean z) {
        this.hLf = z;
        if (this.hLi != null) {
            if (z) {
                if (this.hLh != null && this.hLh.getVisibility() == 0) {
                    cbs();
                    return;
                }
                return;
            }
            cbr();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void caU() {
        if (this.hLc != null) {
            this.hLc.clearAnimation();
            this.hLc.setImageDrawable(null);
            this.hLc.setVisibility(8);
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
