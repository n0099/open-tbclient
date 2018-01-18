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
    private com.baidu.tieba.frs.i dCx;
    private NoPressedRelativeLayout dRk;
    private Animation dRm;
    private Animation dRn;
    private LinearLayout dRq;
    private EntelechyPullUpRefreshView dRr;
    private EntelechyPullUpRefreshView dRs;
    private TbImageView dRl = null;
    private int mSkinType = 3;
    private boolean dRo = false;
    private float dRp = 360.0f;
    private boolean brD = true;
    private View.OnClickListener dRt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dCx != null) {
                if (view == b.this.dRr) {
                    TiebaStatic.eventStat(b.this.dCx.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dCx.aur() && b.this.dCx.atY() != null) {
                        TiebaStatic.log(new ak("c11752").ab(ImageViewerConfig.FORUM_ID, b.this.dCx.getFid()).ab("obj_locate", "3"));
                        b.this.dCx.atY().startPullRefresh();
                    }
                } else if (view == b.this.dRs && b.this.dCx.atY() != null && b.this.dCx.atY().getListView() != null) {
                    b.this.dCx.atY().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dRq = null;
        this.dRr = null;
        this.dRs = null;
        this.dCx = iVar;
        this.dRk = noPressedRelativeLayout;
        ayR();
        this.dRq = (LinearLayout) this.dRk.findViewById(d.g.frs_stick_bottom_holder);
        this.dRs = (EntelechyPullUpRefreshView) this.dRk.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dRr = (EntelechyPullUpRefreshView) this.dRk.findViewById(d.g.frs_stick_bottom_reload);
        this.dRs.setOnClickListener(this.dRt);
        this.dRr.setOnClickListener(this.dRt);
        onChangeSkinType(this.mSkinType);
    }

    private void ayR() {
        this.dRl = new TbImageView(this.dCx.getPageContext().getPageActivity());
        int s = l.s(this.dCx.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(s, s);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = s;
        this.dRl.setLayoutParams(layoutParams);
        this.dRk.addView(this.dRl);
        this.dRl.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void x(boolean z, boolean z2) {
        if (!this.dRo) {
            this.brD = z;
            if (z) {
                if (z2) {
                    ayU();
                } else {
                    this.dRq.setVisibility(0);
                }
            } else if (z2) {
                ayW();
            } else {
                this.dRq.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean awu() {
        if (this.dRr == null) {
            return false;
        }
        return this.brD;
    }

    private void ayS() {
        if (this.dCx.isAdded()) {
            this.dRm = AnimationUtils.loadAnimation(this.dCx.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dRm.setAnimationListener(new a(this.dRq));
        }
    }

    private void ayT() {
        if (this.dCx.isAdded()) {
            this.dRn = AnimationUtils.loadAnimation(this.dCx.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dRn.setAnimationListener(new animation.Animation$AnimationListenerC0113b(this.dRq));
        }
    }

    private void ayU() {
        ayV();
        if (this.dRn == null) {
            ayT();
        }
        if (this.dRn != null) {
            this.dRq.setVisibility(0);
            this.dRq.startAnimation(this.dRn);
        }
    }

    private void ayV() {
        if (this.dRq != null) {
            this.dRq.clearAnimation();
        }
    }

    private boolean bM(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void ayW() {
        ayV();
        if (this.dRm == null) {
            ayS();
        }
        if (this.dRm != null) {
            this.dRq.startAnimation(this.dRm);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aww() {
        if (this.dRr != null && !bM(this.dRr)) {
            this.dRr.aso();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void awv() {
        if (this.dRr != null && !bM(this.dRr)) {
            this.dRr.asn();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dRr != null) {
                this.dRr.onChangeSkinType(i);
            }
            if (this.dRs != null) {
                this.dRs.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fU(boolean z) {
        this.dRo = z;
        if (this.dRr != null) {
            if (z) {
                if (this.dRq != null && this.dRq.getVisibility() == 0) {
                    ayW();
                    return;
                }
                return;
            }
            ayU();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void K(float f) {
        if (this.dRl != null) {
            if (!this.dRl.isShown()) {
                this.dRl.setVisibility(0);
                aj.c(this.dRl, d.f.icon_pop_refresh);
            }
            if (this.dRl.getAnimation() != null) {
                this.dRl.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dRp, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dRl.startAnimation(rotateAnimation);
            this.dRp = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void ayM() {
        if (this.dRl != null) {
            this.dRl.clearAnimation();
            this.dRl.setImageDrawable(null);
            this.dRl.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void ss() {
        if (this.dRl != null && this.dCx != null && this.dCx.getPageContext() != null) {
            if (!this.dRl.isShown()) {
                this.dRl.setVisibility(0);
                aj.c(this.dRl, d.f.icon_pop_refresh);
            }
            if (this.dRl.getAnimation() != null) {
                this.dRl.clearAnimation();
            }
            this.dRl.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dCx.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    public static class animation.Animation$AnimationListenerC0113b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0113b(View view) {
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
