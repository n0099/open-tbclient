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
    private com.baidu.tieba.frs.i dFP;
    private NoPressedRelativeLayout dUR;
    private Animation dUT;
    private Animation dUU;
    private LinearLayout dUX;
    private EntelechyPullUpRefreshView dUY;
    private EntelechyPullUpRefreshView dUZ;
    private TbImageView dUS = null;
    private int mSkinType = 3;
    private boolean dUV = false;
    private float dUW = 360.0f;
    private boolean bua = true;
    private View.OnClickListener dVa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dFP != null) {
                if (view == b.this.dUY) {
                    TiebaStatic.eventStat(b.this.dFP.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dFP.avm() && b.this.dFP.auT() != null) {
                        TiebaStatic.log(new ak("c11752").ab(ImageViewerConfig.FORUM_ID, b.this.dFP.getFid()).ab("obj_locate", "3"));
                        b.this.dFP.auT().startPullRefresh();
                    }
                } else if (view == b.this.dUZ && b.this.dFP.auT() != null && b.this.dFP.auT().getListView() != null) {
                    b.this.dFP.auT().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dUX = null;
        this.dUY = null;
        this.dUZ = null;
        this.dFP = iVar;
        this.dUR = noPressedRelativeLayout;
        azY();
        this.dUX = (LinearLayout) this.dUR.findViewById(d.g.frs_stick_bottom_holder);
        this.dUZ = (EntelechyPullUpRefreshView) this.dUR.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dUY = (EntelechyPullUpRefreshView) this.dUR.findViewById(d.g.frs_stick_bottom_reload);
        this.dUZ.setOnClickListener(this.dVa);
        this.dUY.setOnClickListener(this.dVa);
        onChangeSkinType(this.mSkinType);
    }

    private void azY() {
        this.dUS = new TbImageView(this.dFP.getPageContext().getPageActivity());
        int t = l.t(this.dFP.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t, t);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = t;
        this.dUS.setLayoutParams(layoutParams);
        this.dUR.addView(this.dUS);
        this.dUS.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void y(boolean z, boolean z2) {
        if (!this.dUV) {
            this.bua = z;
            if (z) {
                if (z2) {
                    aAb();
                } else {
                    this.dUX.setVisibility(0);
                }
            } else if (z2) {
                aAd();
            } else {
                this.dUX.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean axy() {
        if (this.dUY == null) {
            return false;
        }
        return this.bua;
    }

    private void azZ() {
        if (this.dFP.isAdded()) {
            this.dUT = AnimationUtils.loadAnimation(this.dFP.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dUT.setAnimationListener(new a(this.dUX));
        }
    }

    private void aAa() {
        if (this.dFP.isAdded()) {
            this.dUU = AnimationUtils.loadAnimation(this.dFP.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dUU.setAnimationListener(new animation.Animation$AnimationListenerC0152b(this.dUX));
        }
    }

    private void aAb() {
        aAc();
        if (this.dUU == null) {
            aAa();
        }
        if (this.dUU != null) {
            this.dUX.setVisibility(0);
            this.dUX.startAnimation(this.dUU);
        }
    }

    private void aAc() {
        if (this.dUX != null) {
            this.dUX.clearAnimation();
        }
    }

    private boolean bL(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aAd() {
        aAc();
        if (this.dUT == null) {
            azZ();
        }
        if (this.dUT != null) {
            this.dUX.startAnimation(this.dUT);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void axA() {
        if (this.dUY != null && !bL(this.dUY)) {
            this.dUY.atj();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void axz() {
        if (this.dUY != null && !bL(this.dUY)) {
            this.dUY.ati();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dUY != null) {
                this.dUY.onChangeSkinType(i);
            }
            if (this.dUZ != null) {
                this.dUZ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ge(boolean z) {
        this.dUV = z;
        if (this.dUY != null) {
            if (z) {
                if (this.dUX != null && this.dUX.getVisibility() == 0) {
                    aAd();
                    return;
                }
                return;
            }
            aAb();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void O(float f) {
        if (this.dUS != null) {
            if (!this.dUS.isShown()) {
                this.dUS.setVisibility(0);
                aj.c(this.dUS, d.f.icon_pop_refresh);
            }
            if (this.dUS.getAnimation() != null) {
                this.dUS.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dUW, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dUS.startAnimation(rotateAnimation);
            this.dUW = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void azT() {
        if (this.dUS != null) {
            this.dUS.clearAnimation();
            this.dUS.setImageDrawable(null);
            this.dUS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void sr() {
        if (this.dUS != null && this.dFP != null && this.dFP.getPageContext() != null) {
            if (!this.dUS.isShown()) {
                this.dUS.setVisibility(0);
                aj.c(this.dUS, d.f.icon_pop_refresh);
            }
            if (this.dUS.getAnimation() != null) {
                this.dUS.clearAnimation();
            }
            this.dUS.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dFP.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    public static class animation.Animation$AnimationListenerC0152b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0152b(View view) {
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
