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
    private FrsFragment hah;
    private NoPressedRelativeLayout hwi;
    private Animation hwk;
    private Animation hwl;
    private LinearLayout hwo;
    private EntelechyPullUpRefreshView hwp;
    private EntelechyPullUpRefreshView hwq;
    private TbImageView hwj = null;
    private int mSkinType = 3;
    private boolean hwm = false;
    private float hwn = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener hwr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hah != null) {
                if (view == b.this.hwp) {
                    TiebaStatic.eventStat(b.this.hah.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.hah.bOZ() && b.this.hah.bOx() != null) {
                        TiebaStatic.log(new an("c11752").cI("fid", b.this.hah.getFid()).cI("obj_locate", "3"));
                        b.this.hah.bOx().startPullRefresh();
                    }
                } else if (view == b.this.hwq && b.this.hah.bOx() != null && b.this.hah.bOx().getListView() != null) {
                    b.this.hah.bOx().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.hwo = null;
        this.hwp = null;
        this.hwq = null;
        this.hah = frsFragment;
        this.hwi = noPressedRelativeLayout;
        bUS();
        this.hwo = (LinearLayout) this.hwi.findViewById(R.id.frs_stick_bottom_holder);
        this.hwq = (EntelechyPullUpRefreshView) this.hwi.findViewById(R.id.frs_stick_bottom_goto_top);
        this.hwp = (EntelechyPullUpRefreshView) this.hwi.findViewById(R.id.frs_stick_bottom_reload);
        this.hwq.setOnClickListener(this.hwr);
        this.hwp.setOnClickListener(this.hwr);
        onChangeSkinType(this.mSkinType);
    }

    private void bUS() {
        this.hwj = new TbImageView(this.hah.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.hah.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.hwj.setLayoutParams(layoutParams);
        this.hwi.addView(this.hwj);
        this.hwj.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void M(boolean z, boolean z2) {
        if (!this.hwm) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bUV();
                } else {
                    this.hwo.setVisibility(0);
                }
            } else if (z2) {
                bUW();
            } else {
                this.hwo.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bSb() {
        if (this.hwp == null) {
            return false;
        }
        return this.isShow;
    }

    private void bUT() {
        if (this.hah.isAdded()) {
            this.hwk = AnimationUtils.loadAnimation(this.hah.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.hwk.setAnimationListener(new a(this.hwo));
        }
    }

    private void bUU() {
        if (this.hah.isAdded()) {
            this.hwl = AnimationUtils.loadAnimation(this.hah.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.hwl.setAnimationListener(new animation.Animation$AnimationListenerC0548b(this.hwo));
        }
    }

    private void bUV() {
        cancelAnimation();
        if (this.hwl == null) {
            bUU();
        }
        if (this.hwl != null) {
            this.hwo.setVisibility(0);
            this.hwo.startAnimation(this.hwl);
        }
    }

    private void cancelAnimation() {
        if (this.hwo != null) {
            this.hwo.clearAnimation();
        }
    }

    private void bUW() {
        cancelAnimation();
        if (this.hwk == null) {
            bUT();
        }
        if (this.hwk != null) {
            this.hwo.startAnimation(this.hwk);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hwp != null) {
                this.hwp.onChangeSkinType(i);
            }
            if (this.hwq != null) {
                this.hwq.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void mY(boolean z) {
        this.hwm = z;
        if (this.hwp != null) {
            if (z) {
                if (this.hwo != null && this.hwo.getVisibility() == 0) {
                    bUW();
                    return;
                }
                return;
            }
            bUV();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bUy() {
        if (this.hwj != null) {
            this.hwj.clearAnimation();
            this.hwj.setImageDrawable(null);
            this.hwj.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0548b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0548b(View view) {
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
