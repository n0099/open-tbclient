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
    private FrsFragment han;
    private NoPressedRelativeLayout hwo;
    private Animation hwq;
    private Animation hwr;
    private LinearLayout hwu;
    private EntelechyPullUpRefreshView hwv;
    private EntelechyPullUpRefreshView hww;
    private TbImageView hwp = null;
    private int mSkinType = 3;
    private boolean hws = false;
    private float hwt = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener hwx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.han != null) {
                if (view == b.this.hwv) {
                    TiebaStatic.eventStat(b.this.han.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.han.bOX() && b.this.han.bOv() != null) {
                        TiebaStatic.log(new an("c11752").cI("fid", b.this.han.getFid()).cI("obj_locate", "3"));
                        b.this.han.bOv().startPullRefresh();
                    }
                } else if (view == b.this.hww && b.this.han.bOv() != null && b.this.han.bOv().getListView() != null) {
                    b.this.han.bOv().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.hwu = null;
        this.hwv = null;
        this.hww = null;
        this.han = frsFragment;
        this.hwo = noPressedRelativeLayout;
        bUQ();
        this.hwu = (LinearLayout) this.hwo.findViewById(R.id.frs_stick_bottom_holder);
        this.hww = (EntelechyPullUpRefreshView) this.hwo.findViewById(R.id.frs_stick_bottom_goto_top);
        this.hwv = (EntelechyPullUpRefreshView) this.hwo.findViewById(R.id.frs_stick_bottom_reload);
        this.hww.setOnClickListener(this.hwx);
        this.hwv.setOnClickListener(this.hwx);
        onChangeSkinType(this.mSkinType);
    }

    private void bUQ() {
        this.hwp = new TbImageView(this.han.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.han.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.hwp.setLayoutParams(layoutParams);
        this.hwo.addView(this.hwp);
        this.hwp.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void M(boolean z, boolean z2) {
        if (!this.hws) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bUT();
                } else {
                    this.hwu.setVisibility(0);
                }
            } else if (z2) {
                bUU();
            } else {
                this.hwu.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bRZ() {
        if (this.hwv == null) {
            return false;
        }
        return this.isShow;
    }

    private void bUR() {
        if (this.han.isAdded()) {
            this.hwq = AnimationUtils.loadAnimation(this.han.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.hwq.setAnimationListener(new a(this.hwu));
        }
    }

    private void bUS() {
        if (this.han.isAdded()) {
            this.hwr = AnimationUtils.loadAnimation(this.han.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.hwr.setAnimationListener(new animation.Animation$AnimationListenerC0569b(this.hwu));
        }
    }

    private void bUT() {
        cancelAnimation();
        if (this.hwr == null) {
            bUS();
        }
        if (this.hwr != null) {
            this.hwu.setVisibility(0);
            this.hwu.startAnimation(this.hwr);
        }
    }

    private void cancelAnimation() {
        if (this.hwu != null) {
            this.hwu.clearAnimation();
        }
    }

    private void bUU() {
        cancelAnimation();
        if (this.hwq == null) {
            bUR();
        }
        if (this.hwq != null) {
            this.hwu.startAnimation(this.hwq);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hwv != null) {
                this.hwv.onChangeSkinType(i);
            }
            if (this.hww != null) {
                this.hww.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void mY(boolean z) {
        this.hws = z;
        if (this.hwv != null) {
            if (z) {
                if (this.hwu != null && this.hwu.getVisibility() == 0) {
                    bUU();
                    return;
                }
                return;
            }
            bUT();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bUw() {
        if (this.hwp != null) {
            this.hwp.clearAnimation();
            this.hwp.setImageDrawable(null);
            this.hwp.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0569b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0569b(View view) {
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
