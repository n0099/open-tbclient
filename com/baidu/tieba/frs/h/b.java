package com.baidu.tieba.frs.h;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private EntelechyPullUpRefreshView cHA;
    private EntelechyPullUpRefreshView cHB;
    private NoPressedRelativeLayout cHt;
    private Animation cHv;
    private Animation cHw;
    private LinearLayout cHz;
    private com.baidu.tieba.frs.f crw;
    private TbImageView cHu = null;
    private int mSkinType = 3;
    private boolean cHx = false;
    private float cHy = 360.0f;
    private boolean aCg = true;
    private View.OnClickListener cHC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.crw != null) {
                if (view == b.this.cHA) {
                    TiebaStatic.eventStat(b.this.crw.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.crw.ahg() && b.this.crw.agP() != null) {
                        TiebaStatic.log(new ak("c11752").ac("fid", b.this.crw.getFid()).ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                        b.this.crw.agP().startPullRefresh();
                    }
                } else if (view == b.this.cHB && b.this.crw.agP() != null && b.this.crw.agP().getListView() != null) {
                    b.this.crw.agP().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cHz = null;
        this.cHA = null;
        this.cHB = null;
        this.crw = fVar;
        this.cHt = noPressedRelativeLayout;
        alE();
        this.cHz = (LinearLayout) this.cHt.findViewById(d.h.frs_stick_bottom_holder);
        this.cHB = (EntelechyPullUpRefreshView) this.cHt.findViewById(d.h.frs_stick_bottom_goto_top);
        this.cHA = (EntelechyPullUpRefreshView) this.cHt.findViewById(d.h.frs_stick_bottom_reload);
        this.cHB.setOnClickListener(this.cHC);
        this.cHA.setOnClickListener(this.cHC);
        onChangeSkinType(this.mSkinType);
    }

    private void alE() {
        this.cHu = new TbImageView(this.crw.getPageContext().getPageActivity());
        int f = l.f(this.crw.getPageContext().getPageActivity(), d.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = f;
        this.cHu.setLayoutParams(layoutParams);
        this.cHt.addView(this.cHu);
        this.cHu.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void u(boolean z, boolean z2) {
        if (!this.cHx) {
            this.aCg = z;
            if (z) {
                if (z2) {
                    alH();
                } else {
                    this.cHz.setVisibility(0);
                }
            } else if (z2) {
                alJ();
            } else {
                this.cHz.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean ajj() {
        if (this.cHA == null) {
            return false;
        }
        return this.aCg;
    }

    private void alF() {
        if (this.crw.isAdded()) {
            this.cHv = AnimationUtils.loadAnimation(this.crw.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.cHv.setAnimationListener(new a(this.cHz));
        }
    }

    private void alG() {
        if (this.crw.isAdded()) {
            this.cHw = AnimationUtils.loadAnimation(this.crw.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.cHw.setAnimationListener(new animation.Animation$AnimationListenerC0087b(this.cHz));
        }
    }

    private void alH() {
        alI();
        if (this.cHw == null) {
            alG();
        }
        if (this.cHw != null) {
            this.cHz.setVisibility(0);
            this.cHz.startAnimation(this.cHw);
        }
    }

    private void alI() {
        if (this.cHz != null) {
            this.cHz.clearAnimation();
        }
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void alJ() {
        alI();
        if (this.cHv == null) {
            alF();
        }
        if (this.cHv != null) {
            this.cHz.startAnimation(this.cHv);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ajl() {
        if (this.cHA != null && !aq(this.cHA)) {
            this.cHA.aft();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ajk() {
        if (this.cHA != null && !aq(this.cHA)) {
            this.cHA.afs();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cHA != null) {
                this.cHA.onChangeSkinType(i);
            }
            if (this.cHB != null) {
                this.cHB.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eT(boolean z) {
        this.cHx = z;
        if (this.cHA != null) {
            if (z) {
                alJ();
            } else {
                alH();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void v(float f) {
        if (this.cHu != null) {
            if (!this.cHu.isShown()) {
                this.cHu.setVisibility(0);
                aj.c(this.cHu, d.g.icon_pop_refresh);
            }
            if (this.cHu.getAnimation() != null) {
                this.cHu.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cHy, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cHu.startAnimation(rotateAnimation);
            this.cHy = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void alx() {
        if (this.cHu != null) {
            this.cHu.clearAnimation();
            this.cHu.setImageDrawable(null);
            this.cHu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void la() {
        if (this.cHu != null && this.crw != null && this.crw.getPageContext() != null) {
            if (!this.cHu.isShown()) {
                this.cHu.setVisibility(0);
                aj.c(this.cHu, d.g.icon_pop_refresh);
            }
            if (this.cHu.getAnimation() != null) {
                this.cHu.clearAnimation();
            }
            this.cHu.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.crw.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    public static class animation.Animation$AnimationListenerC0087b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0087b(View view) {
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
