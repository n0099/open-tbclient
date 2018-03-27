package com.baidu.tieba.frs.g;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.a {
    private com.baidu.tieba.frs.i dFH;
    private NoPressedRelativeLayout dUK;
    private Animation dUM;
    private Animation dUN;
    private LinearLayout dUQ;
    private EntelechyPullUpRefreshView dUR;
    private EntelechyPullUpRefreshView dUS;
    private TbImageView dUL = null;
    private int mSkinType = 3;
    private boolean dUO = false;
    private float dUP = 360.0f;
    private boolean btQ = true;
    private View.OnClickListener dUT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dFH != null) {
                if (view == b.this.dUR) {
                    TiebaStatic.eventStat(b.this.dFH.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dFH.avm() && b.this.dFH.auT() != null) {
                        TiebaStatic.log(new ak("c11752").ab(ImageViewerConfig.FORUM_ID, b.this.dFH.getFid()).ab("obj_locate", "3"));
                        b.this.dFH.auT().startPullRefresh();
                    }
                } else if (view == b.this.dUS && b.this.dFH.auT() != null && b.this.dFH.auT().getListView() != null) {
                    b.this.dFH.auT().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dUQ = null;
        this.dUR = null;
        this.dUS = null;
        this.dFH = iVar;
        this.dUK = noPressedRelativeLayout;
        azZ();
        this.dUQ = (LinearLayout) this.dUK.findViewById(d.g.frs_stick_bottom_holder);
        this.dUS = (EntelechyPullUpRefreshView) this.dUK.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dUR = (EntelechyPullUpRefreshView) this.dUK.findViewById(d.g.frs_stick_bottom_reload);
        this.dUS.setOnClickListener(this.dUT);
        this.dUR.setOnClickListener(this.dUT);
        onChangeSkinType(this.mSkinType);
    }

    private void azZ() {
        this.dUL = new TbImageView(this.dFH.getPageContext().getPageActivity());
        int t = l.t(this.dFH.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t, t);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = t;
        this.dUL.setLayoutParams(layoutParams);
        this.dUK.addView(this.dUL);
        this.dUL.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void y(boolean z, boolean z2) {
        if (!this.dUO) {
            this.btQ = z;
            if (z) {
                if (z2) {
                    aAc();
                } else {
                    this.dUQ.setVisibility(0);
                }
            } else if (z2) {
                aAe();
            } else {
                this.dUQ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean axz() {
        if (this.dUR == null) {
            return false;
        }
        return this.btQ;
    }

    private void aAa() {
        if (this.dFH.isAdded()) {
            this.dUM = AnimationUtils.loadAnimation(this.dFH.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dUM.setAnimationListener(new a(this.dUQ));
        }
    }

    private void aAb() {
        if (this.dFH.isAdded()) {
            this.dUN = AnimationUtils.loadAnimation(this.dFH.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dUN.setAnimationListener(new animation.Animation$AnimationListenerC0153b(this.dUQ));
        }
    }

    private void aAc() {
        aAd();
        if (this.dUN == null) {
            aAb();
        }
        if (this.dUN != null) {
            this.dUQ.setVisibility(0);
            this.dUQ.startAnimation(this.dUN);
        }
    }

    private void aAd() {
        if (this.dUQ != null) {
            this.dUQ.clearAnimation();
        }
    }

    private boolean bL(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aAe() {
        aAd();
        if (this.dUM == null) {
            aAa();
        }
        if (this.dUM != null) {
            this.dUQ.startAnimation(this.dUM);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void axB() {
        if (this.dUR != null && !bL(this.dUR)) {
            this.dUR.atj();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void axA() {
        if (this.dUR != null && !bL(this.dUR)) {
            this.dUR.ati();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dUR != null) {
                this.dUR.onChangeSkinType(i);
            }
            if (this.dUS != null) {
                this.dUS.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ge(boolean z) {
        this.dUO = z;
        if (this.dUR != null) {
            if (z) {
                if (this.dUQ != null && this.dUQ.getVisibility() == 0) {
                    aAe();
                    return;
                }
                return;
            }
            aAc();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void O(float f) {
        if (this.dUL != null) {
            if (!this.dUL.isShown()) {
                this.dUL.setVisibility(0);
                aj.c(this.dUL, d.f.icon_pop_refresh);
            }
            if (this.dUL.getAnimation() != null) {
                this.dUL.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dUP, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dUL.startAnimation(rotateAnimation);
            this.dUP = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void azU() {
        if (this.dUL != null) {
            this.dUL.clearAnimation();
            this.dUL.setImageDrawable(null);
            this.dUL.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void sr() {
        if (this.dUL != null && this.dFH != null && this.dFH.getPageContext() != null) {
            if (!this.dUL.isShown()) {
                this.dUL.setVisibility(0);
                aj.c(this.dUL, d.f.icon_pop_refresh);
            }
            if (this.dUL.getAnimation() != null) {
                this.dUL.clearAnimation();
            }
            this.dUL.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dFH.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    /* renamed from: com.baidu.tieba.frs.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class animation.Animation$AnimationListenerC0153b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0153b(View view) {
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
