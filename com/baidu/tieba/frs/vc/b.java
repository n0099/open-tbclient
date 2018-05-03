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
    private FrsFragment cYC;
    private NoPressedRelativeLayout dpH;
    private Animation dpJ;
    private Animation dpK;
    private LinearLayout dpN;
    private EntelechyPullUpRefreshView dpO;
    private EntelechyPullUpRefreshView dpP;
    private TbImageView dpI = null;
    private int mSkinType = 3;
    private boolean dpL = false;
    private float dpM = 360.0f;
    private boolean aEp = true;
    private View.OnClickListener dpQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (b.this.cYC != null) {
                if (view2 == b.this.dpO) {
                    TiebaStatic.eventStat(b.this.cYC.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.cYC.apF() && b.this.cYC.apn() != null) {
                        TiebaStatic.log(new al("c11752").ac(ImageViewerConfig.FORUM_ID, b.this.cYC.getFid()).ac("obj_locate", "3"));
                        b.this.cYC.apn().startPullRefresh();
                    }
                } else if (view2 == b.this.dpP && b.this.cYC.apn() != null && b.this.cYC.apn().getListView() != null) {
                    b.this.cYC.apn().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dpN = null;
        this.dpO = null;
        this.dpP = null;
        this.cYC = frsFragment;
        this.dpH = noPressedRelativeLayout;
        auS();
        this.dpN = (LinearLayout) this.dpH.findViewById(d.g.frs_stick_bottom_holder);
        this.dpP = (EntelechyPullUpRefreshView) this.dpH.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dpO = (EntelechyPullUpRefreshView) this.dpH.findViewById(d.g.frs_stick_bottom_reload);
        this.dpP.setOnClickListener(this.dpQ);
        this.dpO.setOnClickListener(this.dpQ);
        onChangeSkinType(this.mSkinType);
    }

    private void auS() {
        this.dpI = new TbImageView(this.cYC.getPageContext().getPageActivity());
        int e = l.e(this.cYC.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = e;
        this.dpI.setLayoutParams(layoutParams);
        this.dpH.addView(this.dpI);
        this.dpI.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void u(boolean z, boolean z2) {
        if (!this.dpL) {
            this.aEp = z;
            if (z) {
                if (z2) {
                    auV();
                } else {
                    this.dpN.setVisibility(0);
                }
            } else if (z2) {
                auX();
            } else {
                this.dpN.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean arX() {
        if (this.dpO == null) {
            return false;
        }
        return this.aEp;
    }

    private void auT() {
        if (this.cYC.isAdded()) {
            this.dpJ = AnimationUtils.loadAnimation(this.cYC.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dpJ.setAnimationListener(new a(this.dpN));
        }
    }

    private void auU() {
        if (this.cYC.isAdded()) {
            this.dpK = AnimationUtils.loadAnimation(this.cYC.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dpK.setAnimationListener(new animation.Animation$AnimationListenerC0143b(this.dpN));
        }
    }

    private void auV() {
        auW();
        if (this.dpK == null) {
            auU();
        }
        if (this.dpK != null) {
            this.dpN.setVisibility(0);
            this.dpN.startAnimation(this.dpK);
        }
    }

    private void auW() {
        if (this.dpN != null) {
            this.dpN.clearAnimation();
        }
    }

    private boolean aq(View view2) {
        Animation animation;
        return (view2 == null || (animation = view2.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void auX() {
        auW();
        if (this.dpJ == null) {
            auT();
        }
        if (this.dpJ != null) {
            this.dpN.startAnimation(this.dpJ);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void arZ() {
        if (this.dpO != null && !aq(this.dpO)) {
            this.dpO.any();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void arY() {
        if (this.dpO != null && !aq(this.dpO)) {
            this.dpO.anx();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dpO != null) {
                this.dpO.onChangeSkinType(i);
            }
            if (this.dpP != null) {
                this.dpP.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fK(boolean z) {
        this.dpL = z;
        if (this.dpO != null) {
            if (z) {
                if (this.dpN != null && this.dpN.getVisibility() == 0) {
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
        if (this.dpI != null) {
            if (!this.dpI.isShown()) {
                this.dpI.setVisibility(0);
                ak.c(this.dpI, d.f.icon_pop_refresh);
            }
            if (this.dpI.getAnimation() != null) {
                this.dpI.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dpM, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dpI.startAnimation(rotateAnimation);
            this.dpM = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void auL() {
        if (this.dpI != null) {
            this.dpI.clearAnimation();
            this.dpI.setImageDrawable(null);
            this.dpI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void ky() {
        if (this.dpI != null && this.cYC != null && this.cYC.getPageContext() != null) {
            if (!this.dpI.isShown()) {
                this.dpI.setVisibility(0);
                ak.c(this.dpI, d.f.icon_pop_refresh);
            }
            if (this.dpI.getAnimation() != null) {
                this.dpI.clearAnimation();
            }
            this.dpI.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cYC.getPageContext().getPageActivity(), d.a.center_head_rotate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Animation.AnimationListener {

        /* renamed from: view  reason: collision with root package name */
        View f13view;

        public a(View view2) {
            this.f13view = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.f13view != null) {
                this.f13view.setVisibility(8);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.vc.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class animation.Animation$AnimationListenerC0143b implements Animation.AnimationListener {

        /* renamed from: view  reason: collision with root package name */
        View f14view;

        public animation.Animation$AnimationListenerC0143b(View view2) {
            this.f14view = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.f14view != null) {
                this.f14view.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f14view != null && this.f14view.getAnimation() == animation) {
                this.f14view.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
