package com.baidu.tieba.frs.h;

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
    private com.baidu.tieba.frs.f cjg;
    private NoPressedRelativeLayout cwb;
    private Animation cwd;
    private Animation cwe;
    private Animation cwf;
    private Animation cwg;
    private Animation cwh;
    private Animation cwi;
    private Animation cwj;
    private Animation cwk;
    private LinearLayout cwn;
    private LinearLayout cwo;
    private EntelechyPullUpRefreshView cwp;
    private EntelechyPullUpRefreshView cwq;
    private EntelechyPullUpRefreshView cwr;
    private TbImageView cwc = null;
    private int mSkinType = 3;
    private boolean cwl = false;
    private float cwm = 360.0f;
    private boolean cws = false;
    private boolean aCw = true;
    private View.OnClickListener cwt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cjg != null) {
                if (view == b.this.cwp || view == b.this.cwq) {
                    TiebaStatic.eventStat(b.this.cjg.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.cjg.afn() && b.this.cjg.aeU() != null) {
                        TiebaStatic.log(new aj("c11752").aa("fid", b.this.cjg.getFid()).aa("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                        b.this.cjg.aeU().startPullRefresh();
                        return;
                    }
                    return;
                }
                if (view == b.this.cwr) {
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cwn = null;
        this.cwo = null;
        this.cwp = null;
        this.cwq = null;
        this.cwr = null;
        this.cjg = fVar;
        this.cwb = noPressedRelativeLayout;
        aiY();
        this.cwn = (LinearLayout) this.cwb.findViewById(d.h.frs_stick_bottom_holder);
        this.cwo = (LinearLayout) this.cwb.findViewById(d.h.frs_no_stick_bottom_holder);
        this.cwr = (EntelechyPullUpRefreshView) this.cwb.findViewById(d.h.frs_stick_bottom_goto_top);
        this.cwp = (EntelechyPullUpRefreshView) this.cwb.findViewById(d.h.frs_stick_bottom_reload);
        this.cwq = (EntelechyPullUpRefreshView) this.cwb.findViewById(d.h.frs_no_stick_bottom_reload);
        this.cwr.setOnClickListener(this.cwt);
        this.cwq.setOnClickListener(this.cwt);
        this.cwp.setOnClickListener(this.cwt);
        onChangeSkinType(this.mSkinType);
        aiZ();
    }

    private void aiX() {
        if (this.cws) {
            this.cwn.setVisibility(0);
            this.cwo.setVisibility(8);
            return;
        }
        this.cwn.setVisibility(8);
        this.cwo.setVisibility(0);
    }

    private void aiY() {
        this.cwc = new TbImageView(this.cjg.getPageContext().getPageActivity());
        int g = k.g(this.cjg.getPageContext().getPageActivity(), d.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.cwc.setLayoutParams(layoutParams);
        this.cwb.addView(this.cwc);
        this.cwc.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void s(boolean z, boolean z2) {
        if (!this.cwl) {
            this.aCw = z;
            if (z) {
                if (z2) {
                    ajc();
                } else {
                    aiX();
                }
            } else if (z2) {
                aje();
            } else {
                this.cwn.setVisibility(8);
                this.cwo.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean agP() {
        if (this.cwp == null || this.cwq == null) {
            return false;
        }
        return this.aCw;
    }

    private void aiZ() {
        this.cwj = AnimationUtils.loadAnimation(this.cjg.getPageContext().getPageActivity(), d.a.frs_bottom_fade_in);
        this.cwh = AnimationUtils.loadAnimation(this.cjg.getPageContext().getPageActivity(), d.a.frs_bottom_fade_in);
        this.cwk = AnimationUtils.loadAnimation(this.cjg.getPageContext().getPageActivity(), d.a.frs_bottom_fade_out);
        this.cwi = AnimationUtils.loadAnimation(this.cjg.getPageContext().getPageActivity(), d.a.frs_bottom_fade_out);
        this.cwk.setAnimationListener(new a(this.cwo));
        this.cwj.setAnimationListener(new animation.Animation$AnimationListenerC0086b(this.cwo));
        this.cwi.setAnimationListener(new a(this.cwn));
        this.cwh.setAnimationListener(new animation.Animation$AnimationListenerC0086b(this.cwn));
    }

    private void aja() {
        if (this.cjg.isAdded()) {
            this.cwd = AnimationUtils.loadAnimation(this.cjg.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.cwf = AnimationUtils.loadAnimation(this.cjg.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.cwd.setAnimationListener(new a(this.cwn));
            this.cwf.setAnimationListener(new a(this.cwo));
        }
    }

    private void ajb() {
        if (this.cjg.isAdded()) {
            this.cwe = AnimationUtils.loadAnimation(this.cjg.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.cwg = AnimationUtils.loadAnimation(this.cjg.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.cwe.setAnimationListener(new animation.Animation$AnimationListenerC0086b(this.cwn));
            this.cwg.setAnimationListener(new animation.Animation$AnimationListenerC0086b(this.cwo));
        }
    }

    private void ajc() {
        ajd();
        if (this.cwe == null) {
            ajb();
        }
        if (this.cwe != null) {
            if (this.cws) {
                this.cwn.clearAnimation();
                this.cwn.startAnimation(this.cwe);
                this.cwo.setVisibility(8);
                return;
            }
            this.cwo.clearAnimation();
            this.cwo.startAnimation(this.cwg);
            this.cwn.setVisibility(8);
        }
    }

    private void ajd() {
        if (this.cwn.getAnimation() == this.cwi) {
            this.cwi.cancel();
            this.cwn.clearAnimation();
            this.cwn.setVisibility(8);
        }
        if (this.cwn.getAnimation() == this.cwh) {
            this.cwh.cancel();
            this.cwn.clearAnimation();
            this.cwn.setVisibility(0);
        }
        if (this.cwo.getAnimation() == this.cwk) {
            this.cwk.cancel();
            this.cwo.clearAnimation();
            this.cwo.setVisibility(8);
        }
        if (this.cwo.getAnimation() == this.cwj) {
            this.cwj.cancel();
            this.cwo.clearAnimation();
            this.cwo.setVisibility(0);
        }
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aje() {
        ajd();
        if (this.cwd == null) {
            aja();
        }
        if (this.cwd != null) {
            if (this.cws) {
                this.cwn.clearAnimation();
                this.cwn.startAnimation(this.cwd);
                this.cwo.setVisibility(8);
                return;
            }
            this.cwo.clearAnimation();
            this.cwo.startAnimation(this.cwf);
            this.cwn.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void agR() {
        if (this.cwp != null && !aj(this.cwp)) {
            this.cwp.ahg();
        }
        if (this.cwq != null && !aj(this.cwq)) {
            this.cwq.ahg();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void agQ() {
        if (this.cwp != null && !aj(this.cwp)) {
            this.cwp.ahf();
        }
        if (this.cwq != null && !aj(this.cwq)) {
            this.cwq.ahf();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cwp != null) {
                this.cwp.onChangeSkinType(i);
            }
            if (this.cwq != null) {
                this.cwq.onChangeSkinType(i);
            }
            if (this.cwr != null) {
                this.cwr.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eQ(boolean z) {
        this.cwl = z;
        if (this.cwp != null) {
            if (z) {
                aje();
            } else {
                ajc();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void F(float f) {
        if (this.cwc != null) {
            if (!this.cwc.isShown()) {
                this.cwc.setVisibility(0);
                ai.c(this.cwc, d.g.icon_pop_refresh);
            }
            if (this.cwc.getAnimation() != null) {
                this.cwc.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cwm, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cwc.startAnimation(rotateAnimation);
            this.cwm = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aiQ() {
        if (this.cwc != null) {
            this.cwc.clearAnimation();
            this.cwc.setImageDrawable(null);
            this.cwc.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void kX() {
        if (this.cwc != null && this.cjg != null && this.cjg.getPageContext() != null) {
            if (!this.cwc.isShown()) {
                this.cwc.setVisibility(0);
                ai.c(this.cwc, d.g.icon_pop_refresh);
            }
            if (this.cwc.getAnimation() != null) {
                this.cwc.clearAnimation();
            }
            this.cwc.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cjg.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    /* renamed from: com.baidu.tieba.frs.h.b$b  reason: collision with other inner class name */
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
