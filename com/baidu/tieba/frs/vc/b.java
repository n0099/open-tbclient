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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout dGa;
    private Animation dGc;
    private Animation dGd;
    private LinearLayout dGg;
    private EntelechyPullUpRefreshView dGh;
    private EntelechyPullUpRefreshView dGi;
    private FrsFragment dnR;
    private TbImageView dGb = null;
    private int mSkinType = 3;
    private boolean dGe = false;
    private float dGf = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener dGj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dnR != null) {
                if (view == b.this.dGh) {
                    TiebaStatic.eventStat(b.this.dnR.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dnR.auE() && b.this.dnR.aum() != null) {
                        TiebaStatic.log(new an("c11752").af(ImageViewerConfig.FORUM_ID, b.this.dnR.getFid()).af("obj_locate", "3"));
                        b.this.dnR.aum().startPullRefresh();
                    }
                } else if (view == b.this.dGi && b.this.dnR.aum() != null && b.this.dnR.aum().getListView() != null) {
                    b.this.dnR.aum().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dGg = null;
        this.dGh = null;
        this.dGi = null;
        this.dnR = frsFragment;
        this.dGa = noPressedRelativeLayout;
        aAo();
        this.dGg = (LinearLayout) this.dGa.findViewById(d.g.frs_stick_bottom_holder);
        this.dGi = (EntelechyPullUpRefreshView) this.dGa.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dGh = (EntelechyPullUpRefreshView) this.dGa.findViewById(d.g.frs_stick_bottom_reload);
        this.dGi.setOnClickListener(this.dGj);
        this.dGh.setOnClickListener(this.dGj);
        onChangeSkinType(this.mSkinType);
    }

    private void aAo() {
        this.dGb = new TbImageView(this.dnR.getPageContext().getPageActivity());
        int f = l.f(this.dnR.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = f;
        this.dGb.setLayoutParams(layoutParams);
        this.dGa.addView(this.dGb);
        this.dGb.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void w(boolean z, boolean z2) {
        if (!this.dGe) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    aAr();
                } else {
                    this.dGg.setVisibility(0);
                }
            } else if (z2) {
                aAs();
            } else {
                this.dGg.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean axk() {
        if (this.dGh == null) {
            return false;
        }
        return this.isShow;
    }

    private void aAp() {
        if (this.dnR.isAdded()) {
            this.dGc = AnimationUtils.loadAnimation(this.dnR.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dGc.setAnimationListener(new a(this.dGg));
        }
    }

    private void aAq() {
        if (this.dnR.isAdded()) {
            this.dGd = AnimationUtils.loadAnimation(this.dnR.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dGd.setAnimationListener(new animation.Animation$AnimationListenerC0158b(this.dGg));
        }
    }

    private void aAr() {
        aY();
        if (this.dGd == null) {
            aAq();
        }
        if (this.dGd != null) {
            this.dGg.setVisibility(0);
            this.dGg.startAnimation(this.dGd);
        }
    }

    private void aY() {
        if (this.dGg != null) {
            this.dGg.clearAnimation();
        }
    }

    private boolean av(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aAs() {
        aY();
        if (this.dGc == null) {
            aAp();
        }
        if (this.dGc != null) {
            this.dGg.startAnimation(this.dGc);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void axm() {
        if (this.dGh != null && !av(this.dGh)) {
            this.dGh.arx();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void axl() {
        if (this.dGh != null && !av(this.dGh)) {
            this.dGh.arw();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dGh != null) {
                this.dGh.onChangeSkinType(i);
            }
            if (this.dGi != null) {
                this.dGi.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ga(boolean z) {
        this.dGe = z;
        if (this.dGh != null) {
            if (z) {
                if (this.dGg != null && this.dGg.getVisibility() == 0) {
                    aAs();
                    return;
                }
                return;
            }
            aAr();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void M(float f) {
        if (this.dGb != null) {
            if (!this.dGb.isShown()) {
                this.dGb.setVisibility(0);
                am.c(this.dGb, d.f.icon_pop_refresh);
            }
            if (this.dGb.getAnimation() != null) {
                this.dGb.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dGf, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dGb.startAnimation(rotateAnimation);
            this.dGf = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aAh() {
        if (this.dGb != null) {
            this.dGb.clearAnimation();
            this.dGb.setImageDrawable(null);
            this.dGb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void nn() {
        if (this.dGb != null && this.dnR != null && this.dnR.getPageContext() != null) {
            if (!this.dGb.isShown()) {
                this.dGb.setVisibility(0);
                am.c(this.dGb, d.f.icon_pop_refresh);
            }
            if (this.dGb.getAnimation() != null) {
                this.dGb.clearAnimation();
            }
            this.dGb.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dnR.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
