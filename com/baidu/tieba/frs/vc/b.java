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
    private FrsFragment hVk;
    private NoPressedRelativeLayout iti;
    private Animation itk;
    private Animation itl;
    private LinearLayout ito;
    private EntelechyPullUpRefreshView itp;
    private EntelechyPullUpRefreshView itq;
    private TbImageView itj = null;
    private int mSkinType = 3;
    private boolean itm = false;
    private float itn = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener itr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hVk != null) {
                if (view == b.this.itp) {
                    TiebaStatic.eventStat(b.this.hVk.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.hVk.cmx() && b.this.hVk.clS() != null) {
                        TiebaStatic.log(new aq("c11752").dD("fid", b.this.hVk.getFid()).dD("obj_locate", "3"));
                        b.this.hVk.clS().startPullRefresh();
                    }
                } else if (view == b.this.itq && b.this.hVk.clS() != null && b.this.hVk.clS().getListView() != null) {
                    b.this.hVk.clS().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.ito = null;
        this.itp = null;
        this.itq = null;
        this.hVk = frsFragment;
        this.iti = noPressedRelativeLayout;
        csS();
        this.ito = (LinearLayout) this.iti.findViewById(R.id.frs_stick_bottom_holder);
        this.itq = (EntelechyPullUpRefreshView) this.iti.findViewById(R.id.frs_stick_bottom_goto_top);
        this.itp = (EntelechyPullUpRefreshView) this.iti.findViewById(R.id.frs_stick_bottom_reload);
        this.itq.setOnClickListener(this.itr);
        this.itp.setOnClickListener(this.itr);
        onChangeSkinType(this.mSkinType);
    }

    private void csS() {
        this.itj = new TbImageView(this.hVk.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.hVk.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.itj.setLayoutParams(layoutParams);
        this.iti.addView(this.itj);
        this.itj.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void U(boolean z, boolean z2) {
        if (!this.itm) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    csV();
                } else {
                    this.ito.setVisibility(0);
                }
            } else if (z2) {
                csW();
            } else {
                this.ito.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cpQ() {
        if (this.itp == null) {
            return false;
        }
        return this.isShow;
    }

    private void csT() {
        if (this.hVk.isAdded()) {
            this.itk = AnimationUtils.loadAnimation(this.hVk.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.itk.setAnimationListener(new a(this.ito));
        }
    }

    private void csU() {
        if (this.hVk.isAdded()) {
            this.itl = AnimationUtils.loadAnimation(this.hVk.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.itl.setAnimationListener(new animation.Animation$AnimationListenerC0689b(this.ito));
        }
    }

    private void csV() {
        cancelAnimation();
        if (this.itl == null) {
            csU();
        }
        if (this.itl != null) {
            this.ito.setVisibility(0);
            this.ito.startAnimation(this.itl);
        }
    }

    private void cancelAnimation() {
        if (this.ito != null) {
            this.ito.clearAnimation();
        }
    }

    private void csW() {
        cancelAnimation();
        if (this.itk == null) {
            csT();
        }
        if (this.itk != null) {
            this.ito.startAnimation(this.itk);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.itp != null) {
                this.itp.onChangeSkinType(i);
            }
            if (this.itq != null) {
                this.itq.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void oO(boolean z) {
        this.itm = z;
        if (this.itp != null) {
            if (z) {
                if (this.ito != null && this.ito.getVisibility() == 0) {
                    csW();
                    return;
                }
                return;
            }
            csV();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void csy() {
        if (this.itj != null) {
            this.itj.clearAnimation();
            this.itj.setImageDrawable(null);
            this.itj.setVisibility(8);
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
