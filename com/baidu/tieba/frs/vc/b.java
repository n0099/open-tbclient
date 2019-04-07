package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment fat;
    private NoPressedRelativeLayout fuU;
    private Animation fuW;
    private Animation fuX;
    private LinearLayout fva;
    private EntelechyPullUpRefreshView fvb;
    private EntelechyPullUpRefreshView fvc;
    private TbImageView fuV = null;
    private int mSkinType = 3;
    private boolean fuY = false;
    private float fuZ = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener fvd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fat != null) {
                if (view == b.this.fvb) {
                    TiebaStatic.eventStat(b.this.fat.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.fat.bcQ() && b.this.fat.bcs() != null) {
                        TiebaStatic.log(new am("c11752").bJ(ImageViewerConfig.FORUM_ID, b.this.fat.getFid()).bJ("obj_locate", "3"));
                        b.this.fat.bcs().startPullRefresh();
                    }
                } else if (view == b.this.fvc && b.this.fat.bcs() != null && b.this.fat.bcs().getListView() != null) {
                    b.this.fat.bcs().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fva = null;
        this.fvb = null;
        this.fvc = null;
        this.fat = frsFragment;
        this.fuU = noPressedRelativeLayout;
        biH();
        this.fva = (LinearLayout) this.fuU.findViewById(d.g.frs_stick_bottom_holder);
        this.fvc = (EntelechyPullUpRefreshView) this.fuU.findViewById(d.g.frs_stick_bottom_goto_top);
        this.fvb = (EntelechyPullUpRefreshView) this.fuU.findViewById(d.g.frs_stick_bottom_reload);
        this.fvc.setOnClickListener(this.fvd);
        this.fvb.setOnClickListener(this.fvd);
        onChangeSkinType(this.mSkinType);
    }

    private void biH() {
        this.fuV = new TbImageView(this.fat.getPageContext().getPageActivity());
        int h = l.h(this.fat.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.fuV.setLayoutParams(layoutParams);
        this.fuU.addView(this.fuV);
        this.fuV.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void D(boolean z, boolean z2) {
        if (!this.fuY) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    biK();
                } else {
                    this.fva.setVisibility(0);
                }
            } else if (z2) {
                biL();
            } else {
                this.fva.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bfI() {
        if (this.fvb == null) {
            return false;
        }
        return this.isShow;
    }

    private void biI() {
        if (this.fat.isAdded()) {
            this.fuW = AnimationUtils.loadAnimation(this.fat.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.fuW.setAnimationListener(new a(this.fva));
        }
    }

    private void biJ() {
        if (this.fat.isAdded()) {
            this.fuX = AnimationUtils.loadAnimation(this.fat.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.fuX.setAnimationListener(new animation.Animation$AnimationListenerC0297b(this.fva));
        }
    }

    private void biK() {
        cancelAnimation();
        if (this.fuX == null) {
            biJ();
        }
        if (this.fuX != null) {
            this.fva.setVisibility(0);
            this.fva.startAnimation(this.fuX);
        }
    }

    private void cancelAnimation() {
        if (this.fva != null) {
            this.fva.clearAnimation();
        }
    }

    private boolean bG(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void biL() {
        cancelAnimation();
        if (this.fuW == null) {
            biI();
        }
        if (this.fuW != null) {
            this.fva.startAnimation(this.fuW);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bfK() {
        if (this.fvb != null && !bG(this.fvb)) {
            this.fvb.aZA();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bfJ() {
        if (this.fvb != null && !bG(this.fvb)) {
            this.fvb.aZz();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fvb != null) {
                this.fvb.onChangeSkinType(i);
            }
            if (this.fvc != null) {
                this.fvc.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void jD(boolean z) {
        this.fuY = z;
        if (this.fvb != null) {
            if (z) {
                if (this.fva != null && this.fva.getVisibility() == 0) {
                    biL();
                    return;
                }
                return;
            }
            biK();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bin() {
        if (this.fuV != null) {
            this.fuV.clearAnimation();
            this.fuV.setImageDrawable(null);
            this.fuV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC0297b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0297b(View view) {
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
