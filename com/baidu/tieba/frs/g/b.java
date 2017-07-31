package com.baidu.tieba.frs.g;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private com.baidu.tieba.frs.f ckn;
    private Animation cxA;
    private Animation cxB;
    private Animation cxC;
    private Animation cxD;
    private Animation cxE;
    private LinearLayout cxH;
    private LinearLayout cxI;
    private EntelechyPullUpRefreshView cxJ;
    private EntelechyPullUpRefreshView cxK;
    private EntelechyPullUpRefreshView cxL;
    private NoPressedRelativeLayout cxv;
    private Animation cxx;
    private Animation cxy;
    private Animation cxz;
    private TbImageView cxw = null;
    private int mSkinType = 3;
    private boolean cxF = false;
    private float cxG = 360.0f;
    private boolean cxM = false;
    private boolean aDM = true;
    private View.OnClickListener cxN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ckn != null) {
                if (view == b.this.cxJ || view == b.this.cxK) {
                    TiebaStatic.eventStat(b.this.ckn.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.ckn.afs() && b.this.ckn.aeZ() != null) {
                        TiebaStatic.log(new aj("c11752").aa("fid", b.this.ckn.getFid()).aa("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                        b.this.ckn.aeZ().startPullRefresh();
                        return;
                    }
                    return;
                }
                if (view == b.this.cxL) {
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cxH = null;
        this.cxI = null;
        this.cxJ = null;
        this.cxK = null;
        this.cxL = null;
        this.ckn = fVar;
        this.cxv = noPressedRelativeLayout;
        ajk();
        this.cxH = (LinearLayout) this.cxv.findViewById(d.h.frs_stick_bottom_holder);
        this.cxI = (LinearLayout) this.cxv.findViewById(d.h.frs_no_stick_bottom_holder);
        this.cxL = (EntelechyPullUpRefreshView) this.cxv.findViewById(d.h.frs_stick_bottom_goto_top);
        this.cxJ = (EntelechyPullUpRefreshView) this.cxv.findViewById(d.h.frs_stick_bottom_reload);
        this.cxK = (EntelechyPullUpRefreshView) this.cxv.findViewById(d.h.frs_no_stick_bottom_reload);
        this.cxL.setOnClickListener(this.cxN);
        this.cxK.setOnClickListener(this.cxN);
        this.cxJ.setOnClickListener(this.cxN);
        onChangeSkinType(this.mSkinType);
        ajl();
    }

    private void ajj() {
        if (this.cxM) {
            this.cxH.setVisibility(0);
            this.cxI.setVisibility(8);
            return;
        }
        this.cxH.setVisibility(8);
        this.cxI.setVisibility(0);
    }

    private void ajk() {
        this.cxw = new TbImageView(this.ckn.getPageContext().getPageActivity());
        int g = k.g(this.ckn.getPageContext().getPageActivity(), d.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.cxw.setLayoutParams(layoutParams);
        this.cxv.addView(this.cxw);
        this.cxw.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void s(boolean z, boolean z2) {
        if (!this.cxF) {
            this.aDM = z;
            if (z) {
                if (z2) {
                    ajo();
                } else {
                    ajj();
                }
            } else if (z2) {
                ajq();
            } else {
                this.cxH.setVisibility(8);
                this.cxI.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean agW() {
        if (this.cxJ == null || this.cxK == null) {
            return false;
        }
        return this.aDM;
    }

    private void ajl() {
        this.cxD = AnimationUtils.loadAnimation(this.ckn.getPageContext().getPageActivity(), d.a.frs_bottom_fade_in);
        this.cxB = AnimationUtils.loadAnimation(this.ckn.getPageContext().getPageActivity(), d.a.frs_bottom_fade_in);
        this.cxE = AnimationUtils.loadAnimation(this.ckn.getPageContext().getPageActivity(), d.a.frs_bottom_fade_out);
        this.cxC = AnimationUtils.loadAnimation(this.ckn.getPageContext().getPageActivity(), d.a.frs_bottom_fade_out);
        this.cxE.setAnimationListener(new a(this.cxI));
        this.cxD.setAnimationListener(new animation.Animation$AnimationListenerC0085b(this.cxI));
        this.cxC.setAnimationListener(new a(this.cxH));
        this.cxB.setAnimationListener(new animation.Animation$AnimationListenerC0085b(this.cxH));
    }

    private void ajm() {
        if (this.ckn.isAdded()) {
            this.cxx = AnimationUtils.loadAnimation(this.ckn.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.cxz = AnimationUtils.loadAnimation(this.ckn.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.cxx.setAnimationListener(new a(this.cxH));
            this.cxz.setAnimationListener(new a(this.cxI));
        }
    }

    private void ajn() {
        if (this.ckn.isAdded()) {
            this.cxy = AnimationUtils.loadAnimation(this.ckn.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.cxA = AnimationUtils.loadAnimation(this.ckn.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.cxy.setAnimationListener(new animation.Animation$AnimationListenerC0085b(this.cxH));
            this.cxA.setAnimationListener(new animation.Animation$AnimationListenerC0085b(this.cxI));
        }
    }

    private void ajo() {
        ajp();
        if (this.cxy == null) {
            ajn();
        }
        if (this.cxy != null) {
            if (this.cxM) {
                this.cxH.clearAnimation();
                this.cxH.startAnimation(this.cxy);
                this.cxI.setVisibility(8);
                return;
            }
            this.cxI.clearAnimation();
            this.cxI.startAnimation(this.cxA);
            this.cxH.setVisibility(8);
        }
    }

    private void ajp() {
        if (this.cxH.getAnimation() == this.cxC) {
            this.cxC.cancel();
            this.cxH.clearAnimation();
            this.cxH.setVisibility(8);
        }
        if (this.cxH.getAnimation() == this.cxB) {
            this.cxB.cancel();
            this.cxH.clearAnimation();
            this.cxH.setVisibility(0);
        }
        if (this.cxI.getAnimation() == this.cxE) {
            this.cxE.cancel();
            this.cxI.clearAnimation();
            this.cxI.setVisibility(8);
        }
        if (this.cxI.getAnimation() == this.cxD) {
            this.cxD.cancel();
            this.cxI.clearAnimation();
            this.cxI.setVisibility(0);
        }
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void ajq() {
        ajp();
        if (this.cxx == null) {
            ajm();
        }
        if (this.cxx != null) {
            if (this.cxM) {
                this.cxH.clearAnimation();
                this.cxH.startAnimation(this.cxx);
                this.cxI.setVisibility(8);
                return;
            }
            this.cxI.clearAnimation();
            this.cxI.startAnimation(this.cxz);
            this.cxH.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void agY() {
        if (this.cxJ != null && !aj(this.cxJ)) {
            this.cxJ.ahn();
        }
        if (this.cxK != null && !aj(this.cxK)) {
            this.cxK.ahn();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void agX() {
        if (this.cxJ != null && !aj(this.cxJ)) {
            this.cxJ.ahm();
        }
        if (this.cxK != null && !aj(this.cxK)) {
            this.cxK.ahm();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cxJ != null) {
                this.cxJ.onChangeSkinType(i);
            }
            if (this.cxK != null) {
                this.cxK.onChangeSkinType(i);
            }
            if (this.cxL != null) {
                this.cxL.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eQ(boolean z) {
        this.cxF = z;
        if (this.cxJ != null) {
            if (z) {
                ajq();
            } else {
                ajo();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void F(float f) {
        if (this.cxw != null) {
            if (!this.cxw.isShown()) {
                this.cxw.setVisibility(0);
                ai.c(this.cxw, d.g.icon_pop_refresh);
            }
            if (this.cxw.getAnimation() != null) {
                this.cxw.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cxG, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cxw.startAnimation(rotateAnimation);
            this.cxG = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void ajc() {
        if (this.cxw != null) {
            this.cxw.clearAnimation();
            this.cxw.setImageDrawable(null);
            this.cxw.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void lh() {
        if (this.cxw != null) {
            if (!this.cxw.isShown()) {
                this.cxw.setVisibility(0);
                ai.c(this.cxw, d.g.icon_pop_refresh);
            }
            if (this.cxw.getAnimation() != null) {
                this.cxw.clearAnimation();
            }
            this.cxw.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.ckn.getPageContext().getPageActivity(), d.a.center_head_rotate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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
    /* loaded from: classes.dex */
    public static class animation.Animation$AnimationListenerC0085b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0085b(View view) {
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
