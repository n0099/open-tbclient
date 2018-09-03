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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout dFW;
    private Animation dFY;
    private Animation dFZ;
    private LinearLayout dGc;
    private EntelechyPullUpRefreshView dGd;
    private EntelechyPullUpRefreshView dGe;
    private FrsFragment dnP;
    private TbImageView dFX = null;
    private int mSkinType = 3;
    private boolean dGa = false;
    private float dGb = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener dGf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dnP != null) {
                if (view == b.this.dGd) {
                    TiebaStatic.eventStat(b.this.dnP.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dnP.auD() && b.this.dnP.aul() != null) {
                        TiebaStatic.log(new an("c11752").ae(ImageViewerConfig.FORUM_ID, b.this.dnP.getFid()).ae("obj_locate", "3"));
                        b.this.dnP.aul().startPullRefresh();
                    }
                } else if (view == b.this.dGe && b.this.dnP.aul() != null && b.this.dnP.aul().getListView() != null) {
                    b.this.dnP.aul().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dGc = null;
        this.dGd = null;
        this.dGe = null;
        this.dnP = frsFragment;
        this.dFW = noPressedRelativeLayout;
        aAl();
        this.dGc = (LinearLayout) this.dFW.findViewById(f.g.frs_stick_bottom_holder);
        this.dGe = (EntelechyPullUpRefreshView) this.dFW.findViewById(f.g.frs_stick_bottom_goto_top);
        this.dGd = (EntelechyPullUpRefreshView) this.dFW.findViewById(f.g.frs_stick_bottom_reload);
        this.dGe.setOnClickListener(this.dGf);
        this.dGd.setOnClickListener(this.dGf);
        onChangeSkinType(this.mSkinType);
    }

    private void aAl() {
        this.dFX = new TbImageView(this.dnP.getPageContext().getPageActivity());
        int f = l.f(this.dnP.getPageContext().getPageActivity(), f.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = f;
        this.dFX.setLayoutParams(layoutParams);
        this.dFW.addView(this.dFX);
        this.dFX.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void w(boolean z, boolean z2) {
        if (!this.dGa) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    aAo();
                } else {
                    this.dGc.setVisibility(0);
                }
            } else if (z2) {
                aAp();
            } else {
                this.dGc.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean axj() {
        if (this.dGd == null) {
            return false;
        }
        return this.isShow;
    }

    private void aAm() {
        if (this.dnP.isAdded()) {
            this.dFY = AnimationUtils.loadAnimation(this.dnP.getPageContext().getPageActivity(), f.a.frs_pull_up_refresh_out);
            this.dFY.setAnimationListener(new a(this.dGc));
        }
    }

    private void aAn() {
        if (this.dnP.isAdded()) {
            this.dFZ = AnimationUtils.loadAnimation(this.dnP.getPageContext().getPageActivity(), f.a.frs_pull_up_refresh_in);
            this.dFZ.setAnimationListener(new animation.Animation$AnimationListenerC0158b(this.dGc));
        }
    }

    private void aAo() {
        aY();
        if (this.dFZ == null) {
            aAn();
        }
        if (this.dFZ != null) {
            this.dGc.setVisibility(0);
            this.dGc.startAnimation(this.dFZ);
        }
    }

    private void aY() {
        if (this.dGc != null) {
            this.dGc.clearAnimation();
        }
    }

    private boolean av(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aAp() {
        aY();
        if (this.dFY == null) {
            aAm();
        }
        if (this.dFY != null) {
            this.dGc.startAnimation(this.dFY);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void axl() {
        if (this.dGd != null && !av(this.dGd)) {
            this.dGd.arx();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void axk() {
        if (this.dGd != null && !av(this.dGd)) {
            this.dGd.arw();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dGd != null) {
                this.dGd.onChangeSkinType(i);
            }
            if (this.dGe != null) {
                this.dGe.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ga(boolean z) {
        this.dGa = z;
        if (this.dGd != null) {
            if (z) {
                if (this.dGc != null && this.dGc.getVisibility() == 0) {
                    aAp();
                    return;
                }
                return;
            }
            aAo();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void M(float f) {
        if (this.dFX != null) {
            if (!this.dFX.isShown()) {
                this.dFX.setVisibility(0);
                am.c(this.dFX, f.C0146f.icon_pop_refresh);
            }
            if (this.dFX.getAnimation() != null) {
                this.dFX.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dGb, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dFX.startAnimation(rotateAnimation);
            this.dGb = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aAe() {
        if (this.dFX != null) {
            this.dFX.clearAnimation();
            this.dFX.setImageDrawable(null);
            this.dFX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void nn() {
        if (this.dFX != null && this.dnP != null && this.dnP.getPageContext() != null) {
            if (!this.dFX.isShown()) {
                this.dFX.setVisibility(0);
                am.c(this.dFX, f.C0146f.icon_pop_refresh);
            }
            if (this.dFX.getAnimation() != null) {
                this.dFX.clearAnimation();
            }
            this.dFX.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dnP.getPageContext().getPageActivity(), f.a.center_head_rotate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
    /* renamed from: com.baidu.tieba.frs.vc.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class animation.Animation$AnimationListenerC0158b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0158b(View view) {
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
