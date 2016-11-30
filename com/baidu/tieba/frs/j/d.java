package com.baidu.tieba.frs.j;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.h {
    private FrsActivity bTA;
    private NoPressedRelativeLayout cjh;
    private Animation cjj;
    private Animation cjk;
    private Animation cjl;
    private Animation cjm;
    private Animation cjn;
    private Animation cjo;
    private Animation cjp;
    private Animation cjq;
    private LinearLayout cjt;
    private LinearLayout cju;
    private EntelechyPullUpRefreshView cjv;
    private EntelechyPullUpRefreshView cjw;
    private EntelechyPullUpRefreshView cjx;
    private TbImageView cji = null;
    private int mSkinType = 3;
    private boolean cjr = false;
    private float cjs = 360.0f;
    private boolean cjy = false;
    private boolean awu = true;
    private View.OnClickListener cjz = new e(this);

    public d(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cjt = null;
        this.cju = null;
        this.cjv = null;
        this.cjw = null;
        this.cjx = null;
        this.bTA = frsActivity;
        this.cjh = noPressedRelativeLayout;
        ahe();
        this.cjt = (LinearLayout) this.bTA.findViewById(r.g.frs_stick_bottom_holder);
        this.cju = (LinearLayout) this.bTA.findViewById(r.g.frs_no_stick_bottom_holder);
        this.cjx = (EntelechyPullUpRefreshView) this.bTA.findViewById(r.g.frs_stick_bottom_goto_top);
        this.cjv = (EntelechyPullUpRefreshView) this.bTA.findViewById(r.g.frs_stick_bottom_reload);
        this.cjw = (EntelechyPullUpRefreshView) this.bTA.findViewById(r.g.frs_no_stick_bottom_reload);
        this.cjx.setOnClickListener(this.cjz);
        this.cjw.setOnClickListener(this.cjz);
        this.cjv.setOnClickListener(this.cjz);
        onChangeSkinType(this.mSkinType);
        ahf();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eg(boolean z) {
        if (this.cjy != z) {
            this.cjy = z;
            ahc();
        }
    }

    private void ahc() {
        if (!this.cjr && this.awu) {
            ahj();
            if (this.cjq == null) {
                ahf();
            }
            if (this.cjy) {
                this.cjt.startAnimation(this.cjn);
                this.cju.startAnimation(this.cjq);
                return;
            }
            this.cjt.startAnimation(this.cjo);
            this.cju.startAnimation(this.cjp);
        }
    }

    private void ahd() {
        if (this.cjy) {
            this.cjt.setVisibility(0);
            this.cju.setVisibility(8);
            return;
        }
        this.cjt.setVisibility(8);
        this.cju.setVisibility(0);
    }

    private void ahe() {
        this.cji = new TbImageView(this.bTA.getPageContext().getPageActivity());
        int e = com.baidu.adp.lib.util.k.e(this.bTA.getPageContext().getPageActivity(), r.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = e;
        this.cji.setLayoutParams(layoutParams);
        this.cjh.addView(this.cji);
        this.cji.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void n(boolean z, boolean z2) {
        if (!this.cjr) {
            this.awu = z;
            if (z) {
                if (z2) {
                    ahi();
                } else {
                    ahd();
                }
            } else if (z2) {
                ahk();
            } else {
                this.cjt.setVisibility(8);
                this.cju.setVisibility(8);
            }
        }
    }

    private void ahf() {
        this.cjp = AnimationUtils.loadAnimation(this.bTA.getPageContext().getPageActivity(), r.a.frs_bottom_fade_in);
        this.cjn = AnimationUtils.loadAnimation(this.bTA.getPageContext().getPageActivity(), r.a.frs_bottom_fade_in);
        this.cjq = AnimationUtils.loadAnimation(this.bTA.getPageContext().getPageActivity(), r.a.frs_bottom_fade_out);
        this.cjo = AnimationUtils.loadAnimation(this.bTA.getPageContext().getPageActivity(), r.a.frs_bottom_fade_out);
        this.cjq.setAnimationListener(new a(this.cju));
        this.cjp.setAnimationListener(new b(this.cju));
        this.cjo.setAnimationListener(new a(this.cjt));
        this.cjn.setAnimationListener(new b(this.cjt));
    }

    private void ahg() {
        this.cjj = AnimationUtils.loadAnimation(this.bTA.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_out);
        this.cjl = AnimationUtils.loadAnimation(this.bTA.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_out);
        this.cjj.setAnimationListener(new a(this.cjt));
        this.cjl.setAnimationListener(new a(this.cju));
    }

    private void ahh() {
        this.cjk = AnimationUtils.loadAnimation(this.bTA.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_in);
        this.cjm = AnimationUtils.loadAnimation(this.bTA.getPageContext().getPageActivity(), r.a.frs_pull_up_refresh_in);
        this.cjk.setAnimationListener(new b(this.cjt));
        this.cjm.setAnimationListener(new b(this.cju));
    }

    private void ahi() {
        ahj();
        if (this.cjk == null) {
            ahh();
        }
        if (this.cjy) {
            this.cjt.clearAnimation();
            this.cjt.startAnimation(this.cjk);
            this.cju.setVisibility(8);
            return;
        }
        this.cju.clearAnimation();
        this.cju.startAnimation(this.cjm);
        this.cjt.setVisibility(8);
    }

    private void ahj() {
        if (this.cjt.getAnimation() == this.cjo) {
            this.cjo.cancel();
            this.cjt.clearAnimation();
            this.cjt.setVisibility(8);
        }
        if (this.cjt.getAnimation() == this.cjn) {
            this.cjn.cancel();
            this.cjt.clearAnimation();
            this.cjt.setVisibility(0);
        }
        if (this.cju.getAnimation() == this.cjq) {
            this.cjq.cancel();
            this.cju.clearAnimation();
            this.cju.setVisibility(8);
        }
        if (this.cju.getAnimation() == this.cjp) {
            this.cjp.cancel();
            this.cju.clearAnimation();
            this.cju.setVisibility(0);
        }
    }

    private void ahk() {
        ahj();
        if (this.cjj == null) {
            ahg();
        }
        if (this.cjy) {
            this.cjt.clearAnimation();
            this.cjt.startAnimation(this.cjj);
            this.cju.setVisibility(8);
            return;
        }
        this.cju.clearAnimation();
        this.cju.startAnimation(this.cjl);
        this.cjt.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aeH() {
        if (this.cjv != null) {
            this.cjv.afb();
        }
        if (this.cjw != null) {
            this.cjw.afb();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aeG() {
        if (this.cjv != null) {
            this.cjv.afa();
        }
        if (this.cjw != null) {
            this.cjw.afa();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cjv != null) {
                this.cjv.onChangeSkinType(i);
            }
            if (this.cjw != null) {
                this.cjw.onChangeSkinType(i);
            }
            if (this.cjx != null) {
                this.cjx.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ef(boolean z) {
        this.cjr = z;
        if (this.cjv != null) {
            if (z) {
                ahk();
            } else {
                ahi();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void F(float f) {
        if (this.cji != null) {
            if (!this.cji.isShown()) {
                this.cji.setVisibility(0);
                at.c(this.cji, r.f.icon_pop_refresh);
            }
            if (this.cji.getAnimation() != null) {
                this.cji.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cjs, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cji.startAnimation(rotateAnimation);
            this.cjs = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void agY() {
        if (this.cji != null) {
            this.cji.clearAnimation();
            this.cji.setImageDrawable(null);
            this.cji.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void kh() {
        if (this.cji != null) {
            if (!this.cji.isShown()) {
                this.cji.setVisibility(0);
                at.c(this.cji, r.f.icon_pop_refresh);
            }
            if (this.cji.getAnimation() != null) {
                this.cji.clearAnimation();
            }
            this.cji.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bTA.getPageContext().getPageActivity(), r.a.center_head_rotate));
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
