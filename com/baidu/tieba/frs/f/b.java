package com.baidu.tieba.frs.f;

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
    private NoPressedRelativeLayout dMI;
    private Animation dMK;
    private Animation dML;
    private LinearLayout dMO;
    private EntelechyPullUpRefreshView dMP;
    private EntelechyPullUpRefreshView dMQ;
    private com.baidu.tieba.frs.i dxW;
    private TbImageView dMJ = null;
    private int mSkinType = 3;
    private boolean dMM = false;
    private float dMN = 360.0f;
    private boolean bru = true;
    private View.OnClickListener dMR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dxW != null) {
                if (view == b.this.dMP) {
                    TiebaStatic.eventStat(b.this.dxW.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dxW.ato() && b.this.dxW.asV() != null) {
                        TiebaStatic.log(new ak("c11752").ab(ImageViewerConfig.FORUM_ID, b.this.dxW.getFid()).ab("obj_locate", "3"));
                        b.this.dxW.asV().startPullRefresh();
                    }
                } else if (view == b.this.dMQ && b.this.dxW.asV() != null && b.this.dxW.asV().getListView() != null) {
                    b.this.dxW.asV().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dMO = null;
        this.dMP = null;
        this.dMQ = null;
        this.dxW = iVar;
        this.dMI = noPressedRelativeLayout;
        axO();
        this.dMO = (LinearLayout) this.dMI.findViewById(d.g.frs_stick_bottom_holder);
        this.dMQ = (EntelechyPullUpRefreshView) this.dMI.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dMP = (EntelechyPullUpRefreshView) this.dMI.findViewById(d.g.frs_stick_bottom_reload);
        this.dMQ.setOnClickListener(this.dMR);
        this.dMP.setOnClickListener(this.dMR);
        onChangeSkinType(this.mSkinType);
    }

    private void axO() {
        this.dMJ = new TbImageView(this.dxW.getPageContext().getPageActivity());
        int s = l.s(this.dxW.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(s, s);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = s;
        this.dMJ.setLayoutParams(layoutParams);
        this.dMI.addView(this.dMJ);
        this.dMJ.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void x(boolean z, boolean z2) {
        if (!this.dMM) {
            this.bru = z;
            if (z) {
                if (z2) {
                    axR();
                } else {
                    this.dMO.setVisibility(0);
                }
            } else if (z2) {
                axT();
            } else {
                this.dMO.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean avr() {
        if (this.dMP == null) {
            return false;
        }
        return this.bru;
    }

    private void axP() {
        if (this.dxW.isAdded()) {
            this.dMK = AnimationUtils.loadAnimation(this.dxW.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dMK.setAnimationListener(new a(this.dMO));
        }
    }

    private void axQ() {
        if (this.dxW.isAdded()) {
            this.dML = AnimationUtils.loadAnimation(this.dxW.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dML.setAnimationListener(new animation.Animation$AnimationListenerC0114b(this.dMO));
        }
    }

    private void axR() {
        axS();
        if (this.dML == null) {
            axQ();
        }
        if (this.dML != null) {
            this.dMO.setVisibility(0);
            this.dMO.startAnimation(this.dML);
        }
    }

    private void axS() {
        if (this.dMO != null) {
            this.dMO.clearAnimation();
        }
    }

    private boolean bK(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void axT() {
        axS();
        if (this.dMK == null) {
            axP();
        }
        if (this.dMK != null) {
            this.dMO.startAnimation(this.dMK);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void avt() {
        if (this.dMP != null && !bK(this.dMP)) {
            this.dMP.arl();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void avs() {
        if (this.dMP != null && !bK(this.dMP)) {
            this.dMP.ark();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dMP != null) {
                this.dMP.onChangeSkinType(i);
            }
            if (this.dMQ != null) {
                this.dMQ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fQ(boolean z) {
        this.dMM = z;
        if (this.dMP != null) {
            if (z) {
                if (this.dMO != null && this.dMO.getVisibility() == 0) {
                    axT();
                    return;
                }
                return;
            }
            axR();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void K(float f) {
        if (this.dMJ != null) {
            if (!this.dMJ.isShown()) {
                this.dMJ.setVisibility(0);
                aj.c(this.dMJ, d.f.icon_pop_refresh);
            }
            if (this.dMJ.getAnimation() != null) {
                this.dMJ.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dMN, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dMJ.startAnimation(rotateAnimation);
            this.dMN = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void axJ() {
        if (this.dMJ != null) {
            this.dMJ.clearAnimation();
            this.dMJ.setImageDrawable(null);
            this.dMJ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void ss() {
        if (this.dMJ != null && this.dxW != null && this.dxW.getPageContext() != null) {
            if (!this.dMJ.isShown()) {
                this.dMJ.setVisibility(0);
                aj.c(this.dMJ, d.f.icon_pop_refresh);
            }
            if (this.dMJ.getAnimation() != null) {
                this.dMJ.clearAnimation();
            }
            this.dMJ.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dxW.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    /* renamed from: com.baidu.tieba.frs.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class animation.Animation$AnimationListenerC0114b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0114b(View view) {
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
