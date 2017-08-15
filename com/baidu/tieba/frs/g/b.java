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
    private com.baidu.tieba.frs.f ckZ;
    private Animation czA;
    private Animation czB;
    private Animation czC;
    private LinearLayout czF;
    private LinearLayout czG;
    private EntelechyPullUpRefreshView czH;
    private EntelechyPullUpRefreshView czI;
    private EntelechyPullUpRefreshView czJ;
    private NoPressedRelativeLayout czt;
    private Animation czv;
    private Animation czw;
    private Animation czx;
    private Animation czy;
    private Animation czz;
    private TbImageView czu = null;
    private int mSkinType = 3;
    private boolean czD = false;
    private float czE = 360.0f;
    private boolean czK = false;
    private boolean aDN = true;
    private View.OnClickListener czL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ckZ != null) {
                if (view == b.this.czH || view == b.this.czI) {
                    TiebaStatic.eventStat(b.this.ckZ.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.ckZ.afO() && b.this.ckZ.afv() != null) {
                        TiebaStatic.log(new aj("c11752").aa("fid", b.this.ckZ.getFid()).aa("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                        b.this.ckZ.afv().startPullRefresh();
                        return;
                    }
                    return;
                }
                if (view == b.this.czJ) {
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.czF = null;
        this.czG = null;
        this.czH = null;
        this.czI = null;
        this.czJ = null;
        this.ckZ = fVar;
        this.czt = noPressedRelativeLayout;
        ajR();
        this.czF = (LinearLayout) this.czt.findViewById(d.h.frs_stick_bottom_holder);
        this.czG = (LinearLayout) this.czt.findViewById(d.h.frs_no_stick_bottom_holder);
        this.czJ = (EntelechyPullUpRefreshView) this.czt.findViewById(d.h.frs_stick_bottom_goto_top);
        this.czH = (EntelechyPullUpRefreshView) this.czt.findViewById(d.h.frs_stick_bottom_reload);
        this.czI = (EntelechyPullUpRefreshView) this.czt.findViewById(d.h.frs_no_stick_bottom_reload);
        this.czJ.setOnClickListener(this.czL);
        this.czI.setOnClickListener(this.czL);
        this.czH.setOnClickListener(this.czL);
        onChangeSkinType(this.mSkinType);
        ajS();
    }

    private void ajQ() {
        if (this.czK) {
            this.czF.setVisibility(0);
            this.czG.setVisibility(8);
            return;
        }
        this.czF.setVisibility(8);
        this.czG.setVisibility(0);
    }

    private void ajR() {
        this.czu = new TbImageView(this.ckZ.getPageContext().getPageActivity());
        int g = k.g(this.ckZ.getPageContext().getPageActivity(), d.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.czu.setLayoutParams(layoutParams);
        this.czt.addView(this.czu);
        this.czu.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void t(boolean z, boolean z2) {
        if (!this.czD) {
            this.aDN = z;
            if (z) {
                if (z2) {
                    ajV();
                } else {
                    ajQ();
                }
            } else if (z2) {
                ajX();
            } else {
                this.czF.setVisibility(8);
                this.czG.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean ahr() {
        if (this.czH == null || this.czI == null) {
            return false;
        }
        return this.aDN;
    }

    private void ajS() {
        this.czB = AnimationUtils.loadAnimation(this.ckZ.getPageContext().getPageActivity(), d.a.frs_bottom_fade_in);
        this.czz = AnimationUtils.loadAnimation(this.ckZ.getPageContext().getPageActivity(), d.a.frs_bottom_fade_in);
        this.czC = AnimationUtils.loadAnimation(this.ckZ.getPageContext().getPageActivity(), d.a.frs_bottom_fade_out);
        this.czA = AnimationUtils.loadAnimation(this.ckZ.getPageContext().getPageActivity(), d.a.frs_bottom_fade_out);
        this.czC.setAnimationListener(new a(this.czG));
        this.czB.setAnimationListener(new animation.Animation$AnimationListenerC0086b(this.czG));
        this.czA.setAnimationListener(new a(this.czF));
        this.czz.setAnimationListener(new animation.Animation$AnimationListenerC0086b(this.czF));
    }

    private void ajT() {
        if (this.ckZ.isAdded()) {
            this.czv = AnimationUtils.loadAnimation(this.ckZ.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.czx = AnimationUtils.loadAnimation(this.ckZ.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.czv.setAnimationListener(new a(this.czF));
            this.czx.setAnimationListener(new a(this.czG));
        }
    }

    private void ajU() {
        if (this.ckZ.isAdded()) {
            this.czw = AnimationUtils.loadAnimation(this.ckZ.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.czy = AnimationUtils.loadAnimation(this.ckZ.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.czw.setAnimationListener(new animation.Animation$AnimationListenerC0086b(this.czF));
            this.czy.setAnimationListener(new animation.Animation$AnimationListenerC0086b(this.czG));
        }
    }

    private void ajV() {
        ajW();
        if (this.czw == null) {
            ajU();
        }
        if (this.czw != null) {
            if (this.czK) {
                this.czF.clearAnimation();
                this.czF.startAnimation(this.czw);
                this.czG.setVisibility(8);
                return;
            }
            this.czG.clearAnimation();
            this.czG.startAnimation(this.czy);
            this.czF.setVisibility(8);
        }
    }

    private void ajW() {
        if (this.czF.getAnimation() == this.czA) {
            this.czA.cancel();
            this.czF.clearAnimation();
            this.czF.setVisibility(8);
        }
        if (this.czF.getAnimation() == this.czz) {
            this.czz.cancel();
            this.czF.clearAnimation();
            this.czF.setVisibility(0);
        }
        if (this.czG.getAnimation() == this.czC) {
            this.czC.cancel();
            this.czG.clearAnimation();
            this.czG.setVisibility(8);
        }
        if (this.czG.getAnimation() == this.czB) {
            this.czB.cancel();
            this.czG.clearAnimation();
            this.czG.setVisibility(0);
        }
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void ajX() {
        ajW();
        if (this.czv == null) {
            ajT();
        }
        if (this.czv != null) {
            if (this.czK) {
                this.czF.clearAnimation();
                this.czF.startAnimation(this.czv);
                this.czG.setVisibility(8);
                return;
            }
            this.czG.clearAnimation();
            this.czG.startAnimation(this.czx);
            this.czF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aht() {
        if (this.czH != null && !aj(this.czH)) {
            this.czH.ahI();
        }
        if (this.czI != null && !aj(this.czI)) {
            this.czI.ahI();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ahs() {
        if (this.czH != null && !aj(this.czH)) {
            this.czH.ahH();
        }
        if (this.czI != null && !aj(this.czI)) {
            this.czI.ahH();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.czH != null) {
                this.czH.onChangeSkinType(i);
            }
            if (this.czI != null) {
                this.czI.onChangeSkinType(i);
            }
            if (this.czJ != null) {
                this.czJ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eS(boolean z) {
        this.czD = z;
        if (this.czH != null) {
            if (z) {
                ajX();
            } else {
                ajV();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void F(float f) {
        if (this.czu != null) {
            if (!this.czu.isShown()) {
                this.czu.setVisibility(0);
                ai.c(this.czu, d.g.icon_pop_refresh);
            }
            if (this.czu.getAnimation() != null) {
                this.czu.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.czE, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.czu.startAnimation(rotateAnimation);
            this.czE = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void ajJ() {
        if (this.czu != null) {
            this.czu.clearAnimation();
            this.czu.setImageDrawable(null);
            this.czu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void lh() {
        if (this.czu != null && this.ckZ != null && this.ckZ.getPageContext() != null) {
            if (!this.czu.isShown()) {
                this.czu.setVisibility(0);
                ai.c(this.czu, d.g.icon_pop_refresh);
            }
            if (this.czu.getAnimation() != null) {
                this.czu.clearAnimation();
            }
            this.czu.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.ckZ.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    public static class animation.Animation$AnimationListenerC0086b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0086b(View view) {
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
