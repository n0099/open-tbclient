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
    private FrsFragment cYF;
    private NoPressedRelativeLayout dpK;
    private Animation dpM;
    private Animation dpN;
    private LinearLayout dpQ;
    private EntelechyPullUpRefreshView dpR;
    private EntelechyPullUpRefreshView dpS;
    private TbImageView dpL = null;
    private int mSkinType = 3;
    private boolean dpO = false;
    private float dpP = 360.0f;
    private boolean aEp = true;
    private View.OnClickListener dpT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (b.this.cYF != null) {
                if (view2 == b.this.dpR) {
                    TiebaStatic.eventStat(b.this.cYF.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.cYF.apF() && b.this.cYF.apn() != null) {
                        TiebaStatic.log(new al("c11752").ac(ImageViewerConfig.FORUM_ID, b.this.cYF.getFid()).ac("obj_locate", "3"));
                        b.this.cYF.apn().startPullRefresh();
                    }
                } else if (view2 == b.this.dpS && b.this.cYF.apn() != null && b.this.cYF.apn().getListView() != null) {
                    b.this.cYF.apn().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dpQ = null;
        this.dpR = null;
        this.dpS = null;
        this.cYF = frsFragment;
        this.dpK = noPressedRelativeLayout;
        auS();
        this.dpQ = (LinearLayout) this.dpK.findViewById(d.g.frs_stick_bottom_holder);
        this.dpS = (EntelechyPullUpRefreshView) this.dpK.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dpR = (EntelechyPullUpRefreshView) this.dpK.findViewById(d.g.frs_stick_bottom_reload);
        this.dpS.setOnClickListener(this.dpT);
        this.dpR.setOnClickListener(this.dpT);
        onChangeSkinType(this.mSkinType);
    }

    private void auS() {
        this.dpL = new TbImageView(this.cYF.getPageContext().getPageActivity());
        int e = l.e(this.cYF.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = e;
        this.dpL.setLayoutParams(layoutParams);
        this.dpK.addView(this.dpL);
        this.dpL.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void u(boolean z, boolean z2) {
        if (!this.dpO) {
            this.aEp = z;
            if (z) {
                if (z2) {
                    auV();
                } else {
                    this.dpQ.setVisibility(0);
                }
            } else if (z2) {
                auX();
            } else {
                this.dpQ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean arX() {
        if (this.dpR == null) {
            return false;
        }
        return this.aEp;
    }

    private void auT() {
        if (this.cYF.isAdded()) {
            this.dpM = AnimationUtils.loadAnimation(this.cYF.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dpM.setAnimationListener(new a(this.dpQ));
        }
    }

    private void auU() {
        if (this.cYF.isAdded()) {
            this.dpN = AnimationUtils.loadAnimation(this.cYF.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dpN.setAnimationListener(new animation.Animation$AnimationListenerC0143b(this.dpQ));
        }
    }

    private void auV() {
        auW();
        if (this.dpN == null) {
            auU();
        }
        if (this.dpN != null) {
            this.dpQ.setVisibility(0);
            this.dpQ.startAnimation(this.dpN);
        }
    }

    private void auW() {
        if (this.dpQ != null) {
            this.dpQ.clearAnimation();
        }
    }

    private boolean aq(View view2) {
        Animation animation;
        return (view2 == null || (animation = view2.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void auX() {
        auW();
        if (this.dpM == null) {
            auT();
        }
        if (this.dpM != null) {
            this.dpQ.startAnimation(this.dpM);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void arZ() {
        if (this.dpR != null && !aq(this.dpR)) {
            this.dpR.any();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void arY() {
        if (this.dpR != null && !aq(this.dpR)) {
            this.dpR.anx();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dpR != null) {
                this.dpR.onChangeSkinType(i);
            }
            if (this.dpS != null) {
                this.dpS.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fK(boolean z) {
        this.dpO = z;
        if (this.dpR != null) {
            if (z) {
                if (this.dpQ != null && this.dpQ.getVisibility() == 0) {
                    auX();
                    return;
                }
                return;
            }
            auV();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void C(float f) {
        if (this.dpL != null) {
            if (!this.dpL.isShown()) {
                this.dpL.setVisibility(0);
                ak.c(this.dpL, d.f.icon_pop_refresh);
            }
            if (this.dpL.getAnimation() != null) {
                this.dpL.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dpP, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dpL.startAnimation(rotateAnimation);
            this.dpP = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void auL() {
        if (this.dpL != null) {
            this.dpL.clearAnimation();
            this.dpL.setImageDrawable(null);
            this.dpL.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void ky() {
        if (this.dpL != null && this.cYF != null && this.cYF.getPageContext() != null) {
            if (!this.dpL.isShown()) {
                this.dpL.setVisibility(0);
                ak.c(this.dpL, d.f.icon_pop_refresh);
            }
            if (this.dpL.getAnimation() != null) {
                this.dpL.clearAnimation();
            }
            this.dpL.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cYF.getPageContext().getPageActivity(), d.a.center_head_rotate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Animation.AnimationListener {

        /* renamed from: view  reason: collision with root package name */
        View f15view;

        public a(View view2) {
            this.f15view = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.f15view != null) {
                this.f15view.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f15view != null && this.f15view.getAnimation() == animation) {
                this.f15view.clearAnimation();
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
        View f16view;

        public animation.Animation$AnimationListenerC0143b(View view2) {
            this.f16view = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.f16view != null) {
                this.f16view.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f16view != null && this.f16view.getAnimation() == animation) {
                this.f16view.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
