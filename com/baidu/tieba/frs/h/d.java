package com.baidu.tieba.frs.h;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.h {
    private LinearLayout bOA;
    private EntelechyPullUpRefreshView bOB;
    private EntelechyPullUpRefreshView bOC;
    private EntelechyPullUpRefreshView bOD;
    private NoPressedRelativeLayout bOn;
    private Animation bOp;
    private Animation bOq;
    private Animation bOr;
    private Animation bOs;
    private Animation bOt;
    private Animation bOu;
    private Animation bOv;
    private Animation bOw;
    private LinearLayout bOz;
    private FrsActivity bzH;
    private TbImageView bOo = null;
    private int mSkinType = 3;
    private boolean bOx = false;
    private float bOy = 360.0f;
    private boolean bOE = false;
    private boolean avR = true;
    private View.OnClickListener bOF = new e(this);

    public d(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.bOz = null;
        this.bOA = null;
        this.bOB = null;
        this.bOC = null;
        this.bOD = null;
        this.bzH = frsActivity;
        this.bOn = noPressedRelativeLayout;
        abz();
        this.bOz = (LinearLayout) this.bzH.findViewById(r.g.frs_stick_bottom_holder);
        this.bOA = (LinearLayout) this.bzH.findViewById(r.g.frs_no_stick_bottom_holder);
        this.bOD = (EntelechyPullUpRefreshView) this.bzH.findViewById(r.g.frs_stick_bottom_goto_top);
        this.bOB = (EntelechyPullUpRefreshView) this.bzH.findViewById(r.g.frs_stick_bottom_reload);
        this.bOC = (EntelechyPullUpRefreshView) this.bzH.findViewById(r.g.frs_no_stick_bottom_reload);
        this.bOD.setOnClickListener(this.bOF);
        this.bOC.setOnClickListener(this.bOF);
        this.bOB.setOnClickListener(this.bOF);
        onChangeSkinType(this.mSkinType);
        abA();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dQ(boolean z) {
        if (this.bOE != z) {
            this.bOE = z;
            abx();
        }
    }

    private void abx() {
        if (!this.bOx && this.avR) {
            abE();
            if (this.bOw == null) {
                abA();
            }
            if (this.bOE) {
                this.bOz.startAnimation(this.bOt);
                this.bOA.startAnimation(this.bOw);
                return;
            }
            this.bOz.startAnimation(this.bOu);
            this.bOA.startAnimation(this.bOv);
        }
    }

    private void aby() {
        if (this.bOE) {
            this.bOz.setVisibility(0);
            this.bOA.setVisibility(8);
            return;
        }
        this.bOz.setVisibility(8);
        this.bOA.setVisibility(0);
    }

    private void abz() {
        this.bOo = new TbImageView(this.bzH.getPageContext().getPageActivity());
        int e = com.baidu.adp.lib.util.k.e(this.bzH.getPageContext().getPageActivity(), r.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = e;
        this.bOo.setLayoutParams(layoutParams);
        this.bOn.addView(this.bOo);
        this.bOo.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void o(boolean z, boolean z2) {
        if (!this.bOx) {
            this.avR = z;
            if (z) {
                if (z2) {
                    abD();
                } else {
                    aby();
                }
            } else if (z2) {
                abF();
            } else {
                this.bOz.setVisibility(8);
                this.bOA.setVisibility(8);
            }
        }
    }

    private void abA() {
        this.bOv = AnimationUtils.loadAnimation(this.bzH.getPageContext().getPageActivity(), r.a.frs_bottom_fade_in);
        this.bOt = AnimationUtils.loadAnimation(this.bzH.getPageContext().getPageActivity(), r.a.frs_bottom_fade_in);
        this.bOw = AnimationUtils.loadAnimation(this.bzH.getPageContext().getPageActivity(), r.a.frs_bottom_fade_out);
        this.bOu = AnimationUtils.loadAnimation(this.bzH.getPageContext().getPageActivity(), r.a.frs_bottom_fade_out);
        this.bOw.setAnimationListener(new a(this.bOA));
        this.bOv.setAnimationListener(new b(this.bOA));
        this.bOu.setAnimationListener(new a(this.bOz));
        this.bOt.setAnimationListener(new b(this.bOz));
    }

    private void abB() {
        this.bOp = AnimationUtils.loadAnimation(this.bzH.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_out);
        this.bOr = AnimationUtils.loadAnimation(this.bzH.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_out);
        this.bOp.setAnimationListener(new a(this.bOz));
        this.bOr.setAnimationListener(new a(this.bOA));
    }

    private void abC() {
        this.bOq = AnimationUtils.loadAnimation(this.bzH.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_in);
        this.bOs = AnimationUtils.loadAnimation(this.bzH.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_in);
        this.bOq.setAnimationListener(new b(this.bOz));
        this.bOs.setAnimationListener(new b(this.bOA));
    }

    private void abD() {
        abE();
        if (this.bOq == null) {
            abC();
        }
        if (this.bOE) {
            this.bOz.clearAnimation();
            this.bOz.startAnimation(this.bOq);
            this.bOA.setVisibility(8);
            return;
        }
        this.bOA.clearAnimation();
        this.bOA.startAnimation(this.bOs);
        this.bOz.setVisibility(8);
    }

    private void abE() {
        if (this.bOz.getAnimation() == this.bOu) {
            this.bOu.cancel();
            this.bOz.clearAnimation();
            this.bOz.setVisibility(8);
        }
        if (this.bOz.getAnimation() == this.bOt) {
            this.bOt.cancel();
            this.bOz.clearAnimation();
            this.bOz.setVisibility(0);
        }
        if (this.bOA.getAnimation() == this.bOw) {
            this.bOw.cancel();
            this.bOA.clearAnimation();
            this.bOA.setVisibility(8);
        }
        if (this.bOA.getAnimation() == this.bOv) {
            this.bOv.cancel();
            this.bOA.clearAnimation();
            this.bOA.setVisibility(0);
        }
    }

    private void abF() {
        abE();
        if (this.bOp == null) {
            abB();
        }
        if (this.bOE) {
            this.bOz.clearAnimation();
            this.bOz.startAnimation(this.bOp);
            this.bOA.setVisibility(8);
            return;
        }
        this.bOA.clearAnimation();
        this.bOA.startAnimation(this.bOr);
        this.bOz.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Zc() {
        if (this.bOB != null) {
            this.bOB.Zw();
        }
        if (this.bOC != null) {
            this.bOC.Zw();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Zb() {
        if (this.bOB != null) {
            this.bOB.Zv();
        }
        if (this.bOC != null) {
            this.bOC.Zv();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bOB != null) {
                this.bOB.onChangeSkinType(i);
            }
            if (this.bOC != null) {
                this.bOC.onChangeSkinType(i);
            }
            if (this.bOD != null) {
                this.bOD.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void dP(boolean z) {
        this.bOx = z;
        if (this.bOB != null) {
            if (z) {
                abF();
            } else {
                abD();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void F(float f) {
        if (this.bOo != null) {
            if (!this.bOo.isShown()) {
                this.bOo.setVisibility(0);
                ar.c(this.bOo, r.f.icon_pop_refresh);
            }
            if (this.bOo.getAnimation() != null) {
                this.bOo.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.bOy, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.bOo.startAnimation(rotateAnimation);
            this.bOy = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void abt() {
        if (this.bOo != null) {
            this.bOo.clearAnimation();
            this.bOo.setImageDrawable(null);
            this.bOo.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void kh() {
        if (this.bOo != null) {
            if (!this.bOo.isShown()) {
                this.bOo.setVisibility(0);
                ar.c(this.bOo, r.f.icon_pop_refresh);
            }
            if (this.bOo.getAnimation() != null) {
                this.bOo.clearAnimation();
            }
            this.bOo.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bzH.getPageContext().getPageActivity(), r.a.center_head_rotate));
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
    /* loaded from: classes.dex */
    public static class b implements Animation.AnimationListener {
        View view;

        public b(View view) {
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
