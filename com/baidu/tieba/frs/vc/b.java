package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes6.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment dMs;
    private NoPressedRelativeLayout efA;
    private Animation efC;
    private Animation efD;
    private LinearLayout efG;
    private EntelechyPullUpRefreshView efH;
    private EntelechyPullUpRefreshView efI;
    private TbImageView efB = null;
    private int mSkinType = 3;
    private boolean efE = false;
    private float efF = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener efJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dMs != null) {
                if (view == b.this.efH) {
                    TiebaStatic.eventStat(b.this.dMs.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dMs.aBP() && b.this.dMs.aBx() != null) {
                        TiebaStatic.log(new am("c11752").aA(ImageViewerConfig.FORUM_ID, b.this.dMs.getFid()).aA("obj_locate", "3"));
                        b.this.dMs.aBx().startPullRefresh();
                    }
                } else if (view == b.this.efI && b.this.dMs.aBx() != null && b.this.dMs.aBx().getListView() != null) {
                    b.this.dMs.aBx().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.efG = null;
        this.efH = null;
        this.efI = null;
        this.dMs = frsFragment;
        this.efA = noPressedRelativeLayout;
        aHJ();
        this.efG = (LinearLayout) this.efA.findViewById(e.g.frs_stick_bottom_holder);
        this.efI = (EntelechyPullUpRefreshView) this.efA.findViewById(e.g.frs_stick_bottom_goto_top);
        this.efH = (EntelechyPullUpRefreshView) this.efA.findViewById(e.g.frs_stick_bottom_reload);
        this.efI.setOnClickListener(this.efJ);
        this.efH.setOnClickListener(this.efJ);
        onChangeSkinType(this.mSkinType);
    }

    private void aHJ() {
        this.efB = new TbImageView(this.dMs.getPageContext().getPageActivity());
        int h = l.h(this.dMs.getPageContext().getPageActivity(), e.C0210e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.efB.setLayoutParams(layoutParams);
        this.efA.addView(this.efB);
        this.efB.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void B(boolean z, boolean z2) {
        if (!this.efE) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    aHM();
                } else {
                    this.efG.setVisibility(0);
                }
            } else if (z2) {
                aHN();
            } else {
                this.efG.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean aEL() {
        if (this.efH == null) {
            return false;
        }
        return this.isShow;
    }

    private void aHK() {
        if (this.dMs.isAdded()) {
            this.efC = AnimationUtils.loadAnimation(this.dMs.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_out);
            this.efC.setAnimationListener(new a(this.efG));
        }
    }

    private void aHL() {
        if (this.dMs.isAdded()) {
            this.efD = AnimationUtils.loadAnimation(this.dMs.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_in);
            this.efD.setAnimationListener(new animation.Animation$AnimationListenerC0229b(this.efG));
        }
    }

    private void aHM() {
        cancelAnimation();
        if (this.efD == null) {
            aHL();
        }
        if (this.efD != null) {
            this.efG.setVisibility(0);
            this.efG.startAnimation(this.efD);
        }
    }

    private void cancelAnimation() {
        if (this.efG != null) {
            this.efG.clearAnimation();
        }
    }

    private boolean aO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aHN() {
        cancelAnimation();
        if (this.efC == null) {
            aHK();
        }
        if (this.efC != null) {
            this.efG.startAnimation(this.efC);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aEN() {
        if (this.efH != null && !aO(this.efH)) {
            this.efH.ayG();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aEM() {
        if (this.efH != null && !aO(this.efH)) {
            this.efH.ayF();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.efH != null) {
                this.efH.onChangeSkinType(i);
            }
            if (this.efI != null) {
                this.efI.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void he(boolean z) {
        this.efE = z;
        if (this.efH != null) {
            if (z) {
                if (this.efG != null && this.efG.getVisibility() == 0) {
                    aHN();
                    return;
                }
                return;
            }
            aHM();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void M(float f) {
        if (this.efB != null) {
            if (!this.efB.isShown()) {
                this.efB.setVisibility(0);
                al.c(this.efB, e.f.icon_pop_refresh);
            }
            if (this.efB.getAnimation() != null) {
                this.efB.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.efF, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.efB.startAnimation(rotateAnimation);
            this.efF = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aHD() {
        if (this.efB != null) {
            this.efB.clearAnimation();
            this.efB.setImageDrawable(null);
            this.efB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void oB() {
        if (this.efB != null && this.dMs != null && this.dMs.getPageContext() != null) {
            if (!this.efB.isShown()) {
                this.efB.setVisibility(0);
                al.c(this.efB, e.f.icon_pop_refresh);
            }
            if (this.efB.getAnimation() != null) {
                this.efB.clearAnimation();
            }
            this.efB.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dMs.getPageContext().getPageActivity(), e.a.center_head_rotate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static class animation.Animation$AnimationListenerC0229b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0229b(View view) {
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
