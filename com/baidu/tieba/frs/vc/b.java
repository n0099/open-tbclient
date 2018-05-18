package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment cZJ;
    private NoPressedRelativeLayout dqP;
    private Animation dqR;
    private Animation dqS;
    private LinearLayout dqV;
    private EntelechyPullUpRefreshView dqW;
    private EntelechyPullUpRefreshView dqX;
    private TbImageView dqQ = null;
    private int mSkinType = 3;
    private boolean dqT = false;
    private float dqU = 360.0f;
    private boolean aEq = true;
    private View.OnClickListener dqY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (b.this.cZJ != null) {
                if (view2 == b.this.dqW) {
                    TiebaStatic.eventStat(b.this.cZJ.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.cZJ.apE() && b.this.cZJ.apm() != null) {
                        TiebaStatic.log(new al("c11752").ac(ImageViewerConfig.FORUM_ID, b.this.cZJ.getFid()).ac("obj_locate", "3"));
                        b.this.cZJ.apm().startPullRefresh();
                    }
                } else if (view2 == b.this.dqX && b.this.cZJ.apm() != null && b.this.cZJ.apm().getListView() != null) {
                    b.this.cZJ.apm().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dqV = null;
        this.dqW = null;
        this.dqX = null;
        this.cZJ = frsFragment;
        this.dqP = noPressedRelativeLayout;
        auR();
        this.dqV = (LinearLayout) this.dqP.findViewById(d.g.frs_stick_bottom_holder);
        this.dqX = (EntelechyPullUpRefreshView) this.dqP.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dqW = (EntelechyPullUpRefreshView) this.dqP.findViewById(d.g.frs_stick_bottom_reload);
        this.dqX.setOnClickListener(this.dqY);
        this.dqW.setOnClickListener(this.dqY);
        onChangeSkinType(this.mSkinType);
    }

    private void auR() {
        this.dqQ = new TbImageView(this.cZJ.getPageContext().getPageActivity());
        int e = l.e(this.cZJ.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = e;
        this.dqQ.setLayoutParams(layoutParams);
        this.dqP.addView(this.dqQ);
        this.dqQ.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void u(boolean z, boolean z2) {
        if (!this.dqT) {
            this.aEq = z;
            if (z) {
                if (z2) {
                    auU();
                } else {
                    this.dqV.setVisibility(0);
                }
            } else if (z2) {
                auW();
            } else {
                this.dqV.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean arW() {
        if (this.dqW == null) {
            return false;
        }
        return this.aEq;
    }

    private void auS() {
        if (this.cZJ.isAdded()) {
            this.dqR = AnimationUtils.loadAnimation(this.cZJ.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dqR.setAnimationListener(new a(this.dqV));
        }
    }

    private void auT() {
        if (this.cZJ.isAdded()) {
            this.dqS = AnimationUtils.loadAnimation(this.cZJ.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dqS.setAnimationListener(new animation.Animation$AnimationListenerC0143b(this.dqV));
        }
    }

    private void auU() {
        auV();
        if (this.dqS == null) {
            auT();
        }
        if (this.dqS != null) {
            this.dqV.setVisibility(0);
            this.dqV.startAnimation(this.dqS);
        }
    }

    private void auV() {
        if (this.dqV != null) {
            this.dqV.clearAnimation();
        }
    }

    private boolean aq(View view2) {
        Animation animation;
        return (view2 == null || (animation = view2.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void auW() {
        auV();
        if (this.dqR == null) {
            auS();
        }
        if (this.dqR != null) {
            this.dqV.startAnimation(this.dqR);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void arY() {
        if (this.dqW != null && !aq(this.dqW)) {
            this.dqW.anx();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void arX() {
        if (this.dqW != null && !aq(this.dqW)) {
            this.dqW.anw();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dqW != null) {
                this.dqW.onChangeSkinType(i);
            }
            if (this.dqX != null) {
                this.dqX.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fL(boolean z) {
        this.dqT = z;
        if (this.dqW != null) {
            if (z) {
                if (this.dqV != null && this.dqV.getVisibility() == 0) {
                    auW();
                    return;
                }
                return;
            }
            auU();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void C(float f) {
        if (this.dqQ != null) {
            if (!this.dqQ.isShown()) {
                this.dqQ.setVisibility(0);
                ak.c(this.dqQ, d.f.icon_pop_refresh);
            }
            if (this.dqQ.getAnimation() != null) {
                this.dqQ.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dqU, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dqQ.startAnimation(rotateAnimation);
            this.dqU = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void auK() {
        if (this.dqQ != null) {
            this.dqQ.clearAnimation();
            this.dqQ.setImageDrawable(null);
            this.dqQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void kx() {
        if (this.dqQ != null && this.cZJ != null && this.cZJ.getPageContext() != null) {
            if (!this.dqQ.isShown()) {
                this.dqQ.setVisibility(0);
                ak.c(this.dqQ, d.f.icon_pop_refresh);
            }
            if (this.dqQ.getAnimation() != null) {
                this.dqQ.clearAnimation();
            }
            this.dqQ.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cZJ.getPageContext().getPageActivity(), d.a.center_head_rotate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Animation.AnimationListener {

        /* renamed from: view  reason: collision with root package name */
        View f12view;

        public a(View view2) {
            this.f12view = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.f12view != null) {
                this.f12view.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f12view != null && this.f12view.getAnimation() == animation) {
                this.f12view.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.vc.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class animation.Animation$AnimationListenerC0143b implements Animation.AnimationListener {

        /* renamed from: view  reason: collision with root package name */
        View f13view;

        public animation.Animation$AnimationListenerC0143b(View view2) {
            this.f13view = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.f13view != null) {
                this.f13view.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f13view != null && this.f13view.getAnimation() == animation) {
                this.f13view.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
