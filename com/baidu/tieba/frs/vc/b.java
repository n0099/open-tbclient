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
    private FrsFragment dJE;
    private NoPressedRelativeLayout ecJ;
    private Animation ecL;
    private Animation ecM;
    private LinearLayout ecP;
    private EntelechyPullUpRefreshView ecQ;
    private EntelechyPullUpRefreshView ecR;
    private TbImageView ecK = null;
    private int mSkinType = 3;
    private boolean ecN = false;
    private float ecO = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener ecS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dJE != null) {
                if (view == b.this.ecQ) {
                    TiebaStatic.eventStat(b.this.dJE.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dJE.aBa() && b.this.dJE.aAI() != null) {
                        TiebaStatic.log(new am("c11752").aA(ImageViewerConfig.FORUM_ID, b.this.dJE.getFid()).aA("obj_locate", "3"));
                        b.this.dJE.aAI().startPullRefresh();
                    }
                } else if (view == b.this.ecR && b.this.dJE.aAI() != null && b.this.dJE.aAI().getListView() != null) {
                    b.this.dJE.aAI().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.ecP = null;
        this.ecQ = null;
        this.ecR = null;
        this.dJE = frsFragment;
        this.ecJ = noPressedRelativeLayout;
        aGU();
        this.ecP = (LinearLayout) this.ecJ.findViewById(e.g.frs_stick_bottom_holder);
        this.ecR = (EntelechyPullUpRefreshView) this.ecJ.findViewById(e.g.frs_stick_bottom_goto_top);
        this.ecQ = (EntelechyPullUpRefreshView) this.ecJ.findViewById(e.g.frs_stick_bottom_reload);
        this.ecR.setOnClickListener(this.ecS);
        this.ecQ.setOnClickListener(this.ecS);
        onChangeSkinType(this.mSkinType);
    }

    private void aGU() {
        this.ecK = new TbImageView(this.dJE.getPageContext().getPageActivity());
        int h = l.h(this.dJE.getPageContext().getPageActivity(), e.C0210e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.ecK.setLayoutParams(layoutParams);
        this.ecJ.addView(this.ecK);
        this.ecK.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void B(boolean z, boolean z2) {
        if (!this.ecN) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    aGX();
                } else {
                    this.ecP.setVisibility(0);
                }
            } else if (z2) {
                aGY();
            } else {
                this.ecP.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean aDW() {
        if (this.ecQ == null) {
            return false;
        }
        return this.isShow;
    }

    private void aGV() {
        if (this.dJE.isAdded()) {
            this.ecL = AnimationUtils.loadAnimation(this.dJE.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_out);
            this.ecL.setAnimationListener(new a(this.ecP));
        }
    }

    private void aGW() {
        if (this.dJE.isAdded()) {
            this.ecM = AnimationUtils.loadAnimation(this.dJE.getPageContext().getPageActivity(), e.a.frs_pull_up_refresh_in);
            this.ecM.setAnimationListener(new animation.Animation$AnimationListenerC0229b(this.ecP));
        }
    }

    private void aGX() {
        cancelAnimation();
        if (this.ecM == null) {
            aGW();
        }
        if (this.ecM != null) {
            this.ecP.setVisibility(0);
            this.ecP.startAnimation(this.ecM);
        }
    }

    private void cancelAnimation() {
        if (this.ecP != null) {
            this.ecP.clearAnimation();
        }
    }

    private boolean aL(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aGY() {
        cancelAnimation();
        if (this.ecL == null) {
            aGV();
        }
        if (this.ecL != null) {
            this.ecP.startAnimation(this.ecL);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aDY() {
        if (this.ecQ != null && !aL(this.ecQ)) {
            this.ecQ.axR();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aDX() {
        if (this.ecQ != null && !aL(this.ecQ)) {
            this.ecQ.axQ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ecQ != null) {
                this.ecQ.onChangeSkinType(i);
            }
            if (this.ecR != null) {
                this.ecR.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void hb(boolean z) {
        this.ecN = z;
        if (this.ecQ != null) {
            if (z) {
                if (this.ecP != null && this.ecP.getVisibility() == 0) {
                    aGY();
                    return;
                }
                return;
            }
            aGX();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void M(float f) {
        if (this.ecK != null) {
            if (!this.ecK.isShown()) {
                this.ecK.setVisibility(0);
                al.c(this.ecK, e.f.icon_pop_refresh);
            }
            if (this.ecK.getAnimation() != null) {
                this.ecK.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.ecO, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.ecK.startAnimation(rotateAnimation);
            this.ecO = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aGO() {
        if (this.ecK != null) {
            this.ecK.clearAnimation();
            this.ecK.setImageDrawable(null);
            this.ecK.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void oB() {
        if (this.ecK != null && this.dJE != null && this.dJE.getPageContext() != null) {
            if (!this.ecK.isShown()) {
                this.ecK.setVisibility(0);
                al.c(this.ecK, e.f.icon_pop_refresh);
            }
            if (this.ecK.getAnimation() != null) {
                this.ecK.clearAnimation();
            }
            this.ecK.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dJE.getPageContext().getPageActivity(), e.a.center_head_rotate));
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
