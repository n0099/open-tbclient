package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment faH;
    private NoPressedRelativeLayout fvj;
    private Animation fvl;
    private Animation fvm;
    private LinearLayout fvp;
    private EntelechyPullUpRefreshView fvq;
    private EntelechyPullUpRefreshView fvr;
    private TbImageView fvk = null;
    private int mSkinType = 3;
    private boolean fvn = false;
    private float fvo = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener fvs = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.faH != null) {
                if (view == b.this.fvq) {
                    TiebaStatic.eventStat(b.this.faH.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.faH.bcT() && b.this.faH.bcv() != null) {
                        TiebaStatic.log(new am("c11752").bJ(ImageViewerConfig.FORUM_ID, b.this.faH.getFid()).bJ("obj_locate", "3"));
                        b.this.faH.bcv().startPullRefresh();
                    }
                } else if (view == b.this.fvr && b.this.faH.bcv() != null && b.this.faH.bcv().getListView() != null) {
                    b.this.faH.bcv().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fvp = null;
        this.fvq = null;
        this.fvr = null;
        this.faH = frsFragment;
        this.fvj = noPressedRelativeLayout;
        biK();
        this.fvp = (LinearLayout) this.fvj.findViewById(d.g.frs_stick_bottom_holder);
        this.fvr = (EntelechyPullUpRefreshView) this.fvj.findViewById(d.g.frs_stick_bottom_goto_top);
        this.fvq = (EntelechyPullUpRefreshView) this.fvj.findViewById(d.g.frs_stick_bottom_reload);
        this.fvr.setOnClickListener(this.fvs);
        this.fvq.setOnClickListener(this.fvs);
        onChangeSkinType(this.mSkinType);
    }

    private void biK() {
        this.fvk = new TbImageView(this.faH.getPageContext().getPageActivity());
        int h = l.h(this.faH.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.fvk.setLayoutParams(layoutParams);
        this.fvj.addView(this.fvk);
        this.fvk.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void F(boolean z, boolean z2) {
        if (!this.fvn) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    biN();
                } else {
                    this.fvp.setVisibility(0);
                }
            } else if (z2) {
                biO();
            } else {
                this.fvp.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bfL() {
        if (this.fvq == null) {
            return false;
        }
        return this.isShow;
    }

    private void biL() {
        if (this.faH.isAdded()) {
            this.fvl = AnimationUtils.loadAnimation(this.faH.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.fvl.setAnimationListener(new a(this.fvp));
        }
    }

    private void biM() {
        if (this.faH.isAdded()) {
            this.fvm = AnimationUtils.loadAnimation(this.faH.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.fvm.setAnimationListener(new animation.Animation$AnimationListenerC0248b(this.fvp));
        }
    }

    private void biN() {
        cancelAnimation();
        if (this.fvm == null) {
            biM();
        }
        if (this.fvm != null) {
            this.fvp.setVisibility(0);
            this.fvp.startAnimation(this.fvm);
        }
    }

    private void cancelAnimation() {
        if (this.fvp != null) {
            this.fvp.clearAnimation();
        }
    }

    private boolean bG(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void biO() {
        cancelAnimation();
        if (this.fvl == null) {
            biL();
        }
        if (this.fvl != null) {
            this.fvp.startAnimation(this.fvl);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bfN() {
        if (this.fvq != null && !bG(this.fvq)) {
            this.fvq.aZE();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bfM() {
        if (this.fvq != null && !bG(this.fvq)) {
            this.fvq.aZD();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fvq != null) {
                this.fvq.onChangeSkinType(i);
            }
            if (this.fvr != null) {
                this.fvr.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void jD(boolean z) {
        this.fvn = z;
        if (this.fvq != null) {
            if (z) {
                if (this.fvp != null && this.fvp.getVisibility() == 0) {
                    biO();
                    return;
                }
                return;
            }
            biN();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void biq() {
        if (this.fvk != null) {
            this.fvk.clearAnimation();
            this.fvk.setImageDrawable(null);
            this.fvk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC0248b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0248b(View view) {
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
