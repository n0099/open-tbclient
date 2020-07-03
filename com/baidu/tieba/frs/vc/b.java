package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes9.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment hBW;
    private NoPressedRelativeLayout hZa;
    private Animation hZc;
    private Animation hZd;
    private LinearLayout hZg;
    private EntelechyPullUpRefreshView hZh;
    private EntelechyPullUpRefreshView hZi;
    private TbImageView hZb = null;
    private int mSkinType = 3;
    private boolean hZe = false;
    private float hZf = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener hZj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hBW != null) {
                if (view == b.this.hZh) {
                    TiebaStatic.eventStat(b.this.hBW.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.hBW.bYC() && b.this.hBW.bXZ() != null) {
                        TiebaStatic.log(new ao("c11752").dk("fid", b.this.hBW.getFid()).dk("obj_locate", "3"));
                        b.this.hBW.bXZ().startPullRefresh();
                    }
                } else if (view == b.this.hZi && b.this.hBW.bXZ() != null && b.this.hBW.bXZ().getListView() != null) {
                    b.this.hBW.bXZ().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.hZg = null;
        this.hZh = null;
        this.hZi = null;
        this.hBW = frsFragment;
        this.hZa = noPressedRelativeLayout;
        ceO();
        this.hZg = (LinearLayout) this.hZa.findViewById(R.id.frs_stick_bottom_holder);
        this.hZi = (EntelechyPullUpRefreshView) this.hZa.findViewById(R.id.frs_stick_bottom_goto_top);
        this.hZh = (EntelechyPullUpRefreshView) this.hZa.findViewById(R.id.frs_stick_bottom_reload);
        this.hZi.setOnClickListener(this.hZj);
        this.hZh.setOnClickListener(this.hZj);
        onChangeSkinType(this.mSkinType);
    }

    private void ceO() {
        this.hZb = new TbImageView(this.hBW.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.hBW.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.hZb.setLayoutParams(layoutParams);
        this.hZa.addView(this.hZb);
        this.hZb.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void P(boolean z, boolean z2) {
        if (!this.hZe) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    ceR();
                } else {
                    this.hZg.setVisibility(0);
                }
            } else if (z2) {
                ceS();
            } else {
                this.hZg.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cbM() {
        if (this.hZh == null) {
            return false;
        }
        return this.isShow;
    }

    private void ceP() {
        if (this.hBW.isAdded()) {
            this.hZc = AnimationUtils.loadAnimation(this.hBW.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.hZc.setAnimationListener(new a(this.hZg));
        }
    }

    private void ceQ() {
        if (this.hBW.isAdded()) {
            this.hZd = AnimationUtils.loadAnimation(this.hBW.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.hZd.setAnimationListener(new animation.Animation$AnimationListenerC0628b(this.hZg));
        }
    }

    private void ceR() {
        cancelAnimation();
        if (this.hZd == null) {
            ceQ();
        }
        if (this.hZd != null) {
            this.hZg.setVisibility(0);
            this.hZg.startAnimation(this.hZd);
        }
    }

    private void cancelAnimation() {
        if (this.hZg != null) {
            this.hZg.clearAnimation();
        }
    }

    private void ceS() {
        cancelAnimation();
        if (this.hZc == null) {
            ceP();
        }
        if (this.hZc != null) {
            this.hZg.startAnimation(this.hZc);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hZh != null) {
                this.hZh.onChangeSkinType(i);
            }
            if (this.hZi != null) {
                this.hZi.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void nF(boolean z) {
        this.hZe = z;
        if (this.hZh != null) {
            if (z) {
                if (this.hZg != null && this.hZg.getVisibility() == 0) {
                    ceS();
                    return;
                }
                return;
            }
            ceR();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void ceu() {
        if (this.hZb != null) {
            this.hZb.clearAnimation();
            this.hZb.setImageDrawable(null);
            this.hZb.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0628b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0628b(View view) {
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
