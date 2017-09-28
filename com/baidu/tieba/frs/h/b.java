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
    private NoPressedRelativeLayout cHF;
    private Animation cHH;
    private Animation cHI;
    private LinearLayout cHL;
    private EntelechyPullUpRefreshView cHM;
    private EntelechyPullUpRefreshView cHN;
    private com.baidu.tieba.frs.f crI;
    private TbImageView cHG = null;
    private int mSkinType = 3;
    private boolean cHJ = false;
    private float cHK = 360.0f;
    private boolean aCt = true;
    private View.OnClickListener cHO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.crI != null) {
                if (view == b.this.cHM) {
                    TiebaStatic.eventStat(b.this.crI.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.crI.ahl() && b.this.crI.agU() != null) {
                        TiebaStatic.log(new ak("c11752").ad("fid", b.this.crI.getFid()).ad("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                        b.this.crI.agU().startPullRefresh();
                    }
                } else if (view == b.this.cHN && b.this.crI.agU() != null && b.this.crI.agU().getListView() != null) {
                    b.this.crI.agU().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cHL = null;
        this.cHM = null;
        this.cHN = null;
        this.crI = fVar;
        this.cHF = noPressedRelativeLayout;
        alJ();
        this.cHL = (LinearLayout) this.cHF.findViewById(d.h.frs_stick_bottom_holder);
        this.cHN = (EntelechyPullUpRefreshView) this.cHF.findViewById(d.h.frs_stick_bottom_goto_top);
        this.cHM = (EntelechyPullUpRefreshView) this.cHF.findViewById(d.h.frs_stick_bottom_reload);
        this.cHN.setOnClickListener(this.cHO);
        this.cHM.setOnClickListener(this.cHO);
        onChangeSkinType(this.mSkinType);
    }

    private void alJ() {
        this.cHG = new TbImageView(this.crI.getPageContext().getPageActivity());
        int f = l.f(this.crI.getPageContext().getPageActivity(), d.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = f;
        this.cHG.setLayoutParams(layoutParams);
        this.cHF.addView(this.cHG);
        this.cHG.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void u(boolean z, boolean z2) {
        if (!this.cHJ) {
            this.aCt = z;
            if (z) {
                if (z2) {
                    alM();
                } else {
                    this.cHL.setVisibility(0);
                }
            } else if (z2) {
                alO();
            } else {
                this.cHL.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean ajo() {
        if (this.cHM == null) {
            return false;
        }
        return this.aCt;
    }

    private void alK() {
        if (this.crI.isAdded()) {
            this.cHH = AnimationUtils.loadAnimation(this.crI.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.cHH.setAnimationListener(new a(this.cHL));
        }
    }

    private void alL() {
        if (this.crI.isAdded()) {
            this.cHI = AnimationUtils.loadAnimation(this.crI.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.cHI.setAnimationListener(new animation.Animation$AnimationListenerC0087b(this.cHL));
        }
    }

    private void alM() {
        alN();
        if (this.cHI == null) {
            alL();
        }
        if (this.cHI != null) {
            this.cHL.setVisibility(0);
            this.cHL.startAnimation(this.cHI);
        }
    }

    private void alN() {
        if (this.cHL != null) {
            this.cHL.clearAnimation();
        }
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void alO() {
        alN();
        if (this.cHH == null) {
            alK();
        }
        if (this.cHH != null) {
            this.cHL.startAnimation(this.cHH);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ajq() {
        if (this.cHM != null && !aq(this.cHM)) {
            this.cHM.afy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ajp() {
        if (this.cHM != null && !aq(this.cHM)) {
            this.cHM.afx();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cHM != null) {
                this.cHM.onChangeSkinType(i);
            }
            if (this.cHN != null) {
                this.cHN.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void eU(boolean z) {
        this.cHJ = z;
        if (this.cHM != null) {
            if (z) {
                alO();
            } else {
                alM();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void v(float f) {
        if (this.cHG != null) {
            if (!this.cHG.isShown()) {
                this.cHG.setVisibility(0);
                aj.c(this.cHG, d.g.icon_pop_refresh);
            }
            if (this.cHG.getAnimation() != null) {
                this.cHG.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cHK, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cHG.startAnimation(rotateAnimation);
            this.cHK = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void alC() {
        if (this.cHG != null) {
            this.cHG.clearAnimation();
            this.cHG.setImageDrawable(null);
            this.cHG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void la() {
        if (this.cHG != null && this.crI != null && this.crI.getPageContext() != null) {
            if (!this.cHG.isShown()) {
                this.cHG.setVisibility(0);
                aj.c(this.cHG, d.g.icon_pop_refresh);
            }
            if (this.cHG.getAnimation() != null) {
                this.cHG.clearAnimation();
            }
            this.cHG.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.crI.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
