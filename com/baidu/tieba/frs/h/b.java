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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout cGM;
    private Animation cGO;
    private Animation cGP;
    private LinearLayout cGS;
    private EntelechyPullUpRefreshView cGT;
    private EntelechyPullUpRefreshView cGU;
    private com.baidu.tieba.frs.f crm;
    private TbImageView cGN = null;
    private int mSkinType = 3;
    private boolean cGQ = false;
    private float cGR = 360.0f;
    private boolean aDc = true;
    private View.OnClickListener cGV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.crm != null) {
                if (view == b.this.cGT) {
                    TiebaStatic.eventStat(b.this.crm.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.crm.ahr() && b.this.crm.agY() != null) {
                        TiebaStatic.log(new ak("c11752").ad("fid", b.this.crm.getFid()).ad("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                        b.this.crm.agY().startPullRefresh();
                    }
                } else if (view == b.this.cGU && b.this.crm.agY() != null && b.this.crm.agY().getListView() != null) {
                    b.this.crm.agY().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cGS = null;
        this.cGT = null;
        this.cGU = null;
        this.crm = fVar;
        this.cGM = noPressedRelativeLayout;
        alF();
        this.cGS = (LinearLayout) this.cGM.findViewById(d.h.frs_stick_bottom_holder);
        this.cGU = (EntelechyPullUpRefreshView) this.cGM.findViewById(d.h.frs_stick_bottom_goto_top);
        this.cGT = (EntelechyPullUpRefreshView) this.cGM.findViewById(d.h.frs_stick_bottom_reload);
        this.cGU.setOnClickListener(this.cGV);
        this.cGT.setOnClickListener(this.cGV);
        onChangeSkinType(this.mSkinType);
    }

    private void alF() {
        this.cGN = new TbImageView(this.crm.getPageContext().getPageActivity());
        int f = k.f(this.crm.getPageContext().getPageActivity(), d.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = f;
        this.cGN.setLayoutParams(layoutParams);
        this.cGM.addView(this.cGN);
        this.cGN.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void u(boolean z, boolean z2) {
        if (!this.cGQ) {
            this.aDc = z;
            if (z) {
                if (z2) {
                    alI();
                } else {
                    this.cGS.setVisibility(0);
                }
            } else if (z2) {
                alK();
            } else {
                this.cGS.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean ajj() {
        if (this.cGT == null) {
            return false;
        }
        return this.aDc;
    }

    private void alG() {
        if (this.crm.isAdded()) {
            this.cGO = AnimationUtils.loadAnimation(this.crm.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.cGO.setAnimationListener(new a(this.cGS));
        }
    }

    private void alH() {
        if (this.crm.isAdded()) {
            this.cGP = AnimationUtils.loadAnimation(this.crm.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.cGP.setAnimationListener(new animation.Animation$AnimationListenerC0087b(this.cGS));
        }
    }

    private void alI() {
        alJ();
        if (this.cGP == null) {
            alH();
        }
        if (this.cGP != null) {
            this.cGS.setVisibility(0);
            this.cGS.startAnimation(this.cGP);
        }
    }

    private void alJ() {
        if (this.cGS != null) {
            this.cGS.clearAnimation();
        }
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void alK() {
        alJ();
        if (this.cGO == null) {
            alG();
        }
        if (this.cGO != null) {
            this.cGS.startAnimation(this.cGO);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ajl() {
        if (this.cGT != null && !aq(this.cGT)) {
            this.cGT.afG();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ajk() {
        if (this.cGT != null && !aq(this.cGT)) {
            this.cGT.afF();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cGT != null) {
                this.cGT.onChangeSkinType(i);
            }
            if (this.cGU != null) {
                this.cGU.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fb(boolean z) {
        this.cGQ = z;
        if (this.cGT != null) {
            if (z) {
                alK();
            } else {
                alI();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void u(float f) {
        if (this.cGN != null) {
            if (!this.cGN.isShown()) {
                this.cGN.setVisibility(0);
                aj.c(this.cGN, d.g.icon_pop_refresh);
            }
            if (this.cGN.getAnimation() != null) {
                this.cGN.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cGR, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cGN.startAnimation(rotateAnimation);
            this.cGR = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aly() {
        if (this.cGN != null) {
            this.cGN.clearAnimation();
            this.cGN.setImageDrawable(null);
            this.cGN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void kY() {
        if (this.cGN != null && this.crm != null && this.crm.getPageContext() != null) {
            if (!this.cGN.isShown()) {
                this.cGN.setVisibility(0);
                aj.c(this.cGN, d.g.icon_pop_refresh);
            }
            if (this.cGN.getAnimation() != null) {
                this.cGN.clearAnimation();
            }
            this.cGN.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.crm.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
