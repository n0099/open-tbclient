package com.baidu.tieba.frs.g;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout cQE;
    private Animation cQG;
    private Animation cQH;
    private LinearLayout cQK;
    private EntelechyPullUpRefreshView cQL;
    private EntelechyPullUpRefreshView cQM;
    private com.baidu.tieba.frs.f cyR;
    private TbImageView cQF = null;
    private int mSkinType = 3;
    private boolean cQI = false;
    private float cQJ = 360.0f;
    private boolean aCP = true;
    private View.OnClickListener cQN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cyR != null) {
                if (view == b.this.cQL) {
                    TiebaStatic.eventStat(b.this.cyR.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.cyR.ajo() && b.this.cyR.aiW() != null) {
                        TiebaStatic.log(new ak("c11752").ac(ImageViewerConfig.FORUM_ID, b.this.cyR.getFid()).ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                        b.this.cyR.aiW().startPullRefresh();
                    }
                } else if (view == b.this.cQM && b.this.cyR.aiW() != null && b.this.cyR.aiW().getListView() != null) {
                    b.this.cyR.aiW().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cQK = null;
        this.cQL = null;
        this.cQM = null;
        this.cyR = fVar;
        this.cQE = noPressedRelativeLayout;
        aop();
        this.cQK = (LinearLayout) this.cQE.findViewById(d.g.frs_stick_bottom_holder);
        this.cQM = (EntelechyPullUpRefreshView) this.cQE.findViewById(d.g.frs_stick_bottom_goto_top);
        this.cQL = (EntelechyPullUpRefreshView) this.cQE.findViewById(d.g.frs_stick_bottom_reload);
        this.cQM.setOnClickListener(this.cQN);
        this.cQL.setOnClickListener(this.cQN);
        onChangeSkinType(this.mSkinType);
    }

    private void aop() {
        this.cQF = new TbImageView(this.cyR.getPageContext().getPageActivity());
        int f = l.f(this.cyR.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = f;
        this.cQF.setLayoutParams(layoutParams);
        this.cQE.addView(this.cQF);
        this.cQF.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void v(boolean z, boolean z2) {
        if (!this.cQI) {
            this.aCP = z;
            if (z) {
                if (z2) {
                    aos();
                } else {
                    this.cQK.setVisibility(0);
                }
            } else if (z2) {
                aou();
            } else {
                this.cQK.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean alw() {
        if (this.cQL == null) {
            return false;
        }
        return this.aCP;
    }

    private void aoq() {
        if (this.cyR.isAdded()) {
            this.cQG = AnimationUtils.loadAnimation(this.cyR.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.cQG.setAnimationListener(new a(this.cQK));
        }
    }

    private void aor() {
        if (this.cyR.isAdded()) {
            this.cQH = AnimationUtils.loadAnimation(this.cyR.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.cQH.setAnimationListener(new animation.Animation$AnimationListenerC0087b(this.cQK));
        }
    }

    private void aos() {
        aot();
        if (this.cQH == null) {
            aor();
        }
        if (this.cQH != null) {
            this.cQK.setVisibility(0);
            this.cQK.startAnimation(this.cQH);
        }
    }

    private void aot() {
        if (this.cQK != null) {
            this.cQK.clearAnimation();
        }
    }

    private boolean at(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aou() {
        aot();
        if (this.cQG == null) {
            aoq();
        }
        if (this.cQG != null) {
            this.cQK.startAnimation(this.cQG);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aly() {
        if (this.cQL != null && !at(this.cQL)) {
            this.cQL.ahB();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void alx() {
        if (this.cQL != null && !at(this.cQL)) {
            this.cQL.ahA();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cQL != null) {
                this.cQL.onChangeSkinType(i);
            }
            if (this.cQM != null) {
                this.cQM.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eO(boolean z) {
        this.cQI = z;
        if (this.cQL != null) {
            if (z) {
                aou();
            } else {
                aos();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void u(float f) {
        if (this.cQF != null) {
            if (!this.cQF.isShown()) {
                this.cQF.setVisibility(0);
                aj.c(this.cQF, d.f.icon_pop_refresh);
            }
            if (this.cQF.getAnimation() != null) {
                this.cQF.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cQJ, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cQF.startAnimation(rotateAnimation);
            this.cQJ = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aoi() {
        if (this.cQF != null) {
            this.cQF.clearAnimation();
            this.cQF.setImageDrawable(null);
            this.cQF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void kU() {
        if (this.cQF != null && this.cyR != null && this.cyR.getPageContext() != null) {
            if (!this.cQF.isShown()) {
                this.cQF.setVisibility(0);
                aj.c(this.cQF, d.f.icon_pop_refresh);
            }
            if (this.cQF.getAnimation() != null) {
                this.cQF.clearAnimation();
            }
            this.cQF.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cyR.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
