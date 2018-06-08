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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout dAc;
    private Animation dAe;
    private Animation dAf;
    private LinearLayout dAi;
    private EntelechyPullUpRefreshView dAj;
    private EntelechyPullUpRefreshView dAk;
    private FrsFragment diZ;
    private TbImageView dAd = null;
    private int mSkinType = 3;
    private boolean dAg = false;
    private float dAh = 360.0f;
    private boolean aMM = true;
    private View.OnClickListener dAl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.diZ != null) {
                if (view == b.this.dAj) {
                    TiebaStatic.eventStat(b.this.diZ.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.diZ.atJ() && b.this.diZ.atr() != null) {
                        TiebaStatic.log(new am("c11752").ah(ImageViewerConfig.FORUM_ID, b.this.diZ.getFid()).ah("obj_locate", "3"));
                        b.this.diZ.atr().startPullRefresh();
                    }
                } else if (view == b.this.dAk && b.this.diZ.atr() != null && b.this.diZ.atr().getListView() != null) {
                    b.this.diZ.atr().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dAi = null;
        this.dAj = null;
        this.dAk = null;
        this.diZ = frsFragment;
        this.dAc = noPressedRelativeLayout;
        azb();
        this.dAi = (LinearLayout) this.dAc.findViewById(d.g.frs_stick_bottom_holder);
        this.dAk = (EntelechyPullUpRefreshView) this.dAc.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dAj = (EntelechyPullUpRefreshView) this.dAc.findViewById(d.g.frs_stick_bottom_reload);
        this.dAk.setOnClickListener(this.dAl);
        this.dAj.setOnClickListener(this.dAl);
        onChangeSkinType(this.mSkinType);
    }

    private void azb() {
        this.dAd = new TbImageView(this.diZ.getPageContext().getPageActivity());
        int e = l.e(this.diZ.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = e;
        this.dAd.setLayoutParams(layoutParams);
        this.dAc.addView(this.dAd);
        this.dAd.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void u(boolean z, boolean z2) {
        if (!this.dAg) {
            this.aMM = z;
            if (z) {
                if (z2) {
                    aze();
                } else {
                    this.dAi.setVisibility(0);
                }
            } else if (z2) {
                azf();
            } else {
                this.dAi.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean awb() {
        if (this.dAj == null) {
            return false;
        }
        return this.aMM;
    }

    private void azc() {
        if (this.diZ.isAdded()) {
            this.dAe = AnimationUtils.loadAnimation(this.diZ.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dAe.setAnimationListener(new a(this.dAi));
        }
    }

    private void azd() {
        if (this.diZ.isAdded()) {
            this.dAf = AnimationUtils.loadAnimation(this.diZ.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dAf.setAnimationListener(new animation.Animation$AnimationListenerC0158b(this.dAi));
        }
    }

    private void aze() {
        bb();
        if (this.dAf == null) {
            azd();
        }
        if (this.dAf != null) {
            this.dAi.setVisibility(0);
            this.dAi.startAnimation(this.dAf);
        }
    }

    private void bb() {
        if (this.dAi != null) {
            this.dAi.clearAnimation();
        }
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void azf() {
        bb();
        if (this.dAe == null) {
            azc();
        }
        if (this.dAe != null) {
            this.dAi.startAnimation(this.dAe);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void awd() {
        if (this.dAj != null && !aq(this.dAj)) {
            this.dAj.arC();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void awc() {
        if (this.dAj != null && !aq(this.dAj)) {
            this.dAj.arB();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dAj != null) {
                this.dAj.onChangeSkinType(i);
            }
            if (this.dAk != null) {
                this.dAk.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fQ(boolean z) {
        this.dAg = z;
        if (this.dAj != null) {
            if (z) {
                if (this.dAi != null && this.dAi.getVisibility() == 0) {
                    azf();
                    return;
                }
                return;
            }
            aze();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void M(float f) {
        if (this.dAd != null) {
            if (!this.dAd.isShown()) {
                this.dAd.setVisibility(0);
                al.c(this.dAd, d.f.icon_pop_refresh);
            }
            if (this.dAd.getAnimation() != null) {
                this.dAd.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dAh, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dAd.startAnimation(rotateAnimation);
            this.dAh = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void ayU() {
        if (this.dAd != null) {
            this.dAd.clearAnimation();
            this.dAd.setImageDrawable(null);
            this.dAd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void nl() {
        if (this.dAd != null && this.diZ != null && this.diZ.getPageContext() != null) {
            if (!this.dAd.isShown()) {
                this.dAd.setVisibility(0);
                al.c(this.dAd, d.f.icon_pop_refresh);
            }
            if (this.dAd.getAnimation() != null) {
                this.dAd.clearAnimation();
            }
            this.dAd.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.diZ.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
