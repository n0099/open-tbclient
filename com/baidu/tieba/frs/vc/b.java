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
/* loaded from: classes16.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment hVq;
    private NoPressedRelativeLayout ito;
    private Animation itq;
    private Animation itr;
    private LinearLayout itu;
    private EntelechyPullUpRefreshView itv;
    private EntelechyPullUpRefreshView itw;
    private TbImageView itp = null;
    private int mSkinType = 3;
    private boolean its = false;
    private float itt = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener itx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hVq != null) {
                if (view == b.this.itv) {
                    TiebaStatic.eventStat(b.this.hVq.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.hVq.cmy() && b.this.hVq.clT() != null) {
                        TiebaStatic.log(new aq("c11752").dD("fid", b.this.hVq.getFid()).dD("obj_locate", "3"));
                        b.this.hVq.clT().startPullRefresh();
                    }
                } else if (view == b.this.itw && b.this.hVq.clT() != null && b.this.hVq.clT().getListView() != null) {
                    b.this.hVq.clT().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.itu = null;
        this.itv = null;
        this.itw = null;
        this.hVq = frsFragment;
        this.ito = noPressedRelativeLayout;
        csT();
        this.itu = (LinearLayout) this.ito.findViewById(R.id.frs_stick_bottom_holder);
        this.itw = (EntelechyPullUpRefreshView) this.ito.findViewById(R.id.frs_stick_bottom_goto_top);
        this.itv = (EntelechyPullUpRefreshView) this.ito.findViewById(R.id.frs_stick_bottom_reload);
        this.itw.setOnClickListener(this.itx);
        this.itv.setOnClickListener(this.itx);
        onChangeSkinType(this.mSkinType);
    }

    private void csT() {
        this.itp = new TbImageView(this.hVq.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.hVq.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.itp.setLayoutParams(layoutParams);
        this.ito.addView(this.itp);
        this.itp.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void U(boolean z, boolean z2) {
        if (!this.its) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    csW();
                } else {
                    this.itu.setVisibility(0);
                }
            } else if (z2) {
                csX();
            } else {
                this.itu.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cpR() {
        if (this.itv == null) {
            return false;
        }
        return this.isShow;
    }

    private void csU() {
        if (this.hVq.isAdded()) {
            this.itq = AnimationUtils.loadAnimation(this.hVq.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.itq.setAnimationListener(new a(this.itu));
        }
    }

    private void csV() {
        if (this.hVq.isAdded()) {
            this.itr = AnimationUtils.loadAnimation(this.hVq.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.itr.setAnimationListener(new animation.Animation$AnimationListenerC0689b(this.itu));
        }
    }

    private void csW() {
        cancelAnimation();
        if (this.itr == null) {
            csV();
        }
        if (this.itr != null) {
            this.itu.setVisibility(0);
            this.itu.startAnimation(this.itr);
        }
    }

    private void cancelAnimation() {
        if (this.itu != null) {
            this.itu.clearAnimation();
        }
    }

    private void csX() {
        cancelAnimation();
        if (this.itq == null) {
            csU();
        }
        if (this.itq != null) {
            this.itu.startAnimation(this.itq);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.itv != null) {
                this.itv.onChangeSkinType(i);
            }
            if (this.itw != null) {
                this.itw.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void oQ(boolean z) {
        this.its = z;
        if (this.itv != null) {
            if (z) {
                if (this.itu != null && this.itu.getVisibility() == 0) {
                    csX();
                    return;
                }
                return;
            }
            csW();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void csz() {
        if (this.itp != null) {
            this.itp.clearAnimation();
            this.itp.setImageDrawable(null);
            this.itp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
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
    /* loaded from: classes16.dex */
    public static class animation.Animation$AnimationListenerC0689b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0689b(View view) {
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
