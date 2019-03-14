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
    private FrsFragment faG;
    private NoPressedRelativeLayout fvi;
    private Animation fvk;
    private Animation fvl;
    private LinearLayout fvo;
    private EntelechyPullUpRefreshView fvp;
    private EntelechyPullUpRefreshView fvq;
    private TbImageView fvj = null;
    private int mSkinType = 3;
    private boolean fvm = false;
    private float fvn = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener fvr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.faG != null) {
                if (view == b.this.fvp) {
                    TiebaStatic.eventStat(b.this.faG.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.faG.bcS() && b.this.faG.bcu() != null) {
                        TiebaStatic.log(new am("c11752").bJ(ImageViewerConfig.FORUM_ID, b.this.faG.getFid()).bJ("obj_locate", "3"));
                        b.this.faG.bcu().startPullRefresh();
                    }
                } else if (view == b.this.fvq && b.this.faG.bcu() != null && b.this.faG.bcu().getListView() != null) {
                    b.this.faG.bcu().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fvo = null;
        this.fvp = null;
        this.fvq = null;
        this.faG = frsFragment;
        this.fvi = noPressedRelativeLayout;
        biJ();
        this.fvo = (LinearLayout) this.fvi.findViewById(d.g.frs_stick_bottom_holder);
        this.fvq = (EntelechyPullUpRefreshView) this.fvi.findViewById(d.g.frs_stick_bottom_goto_top);
        this.fvp = (EntelechyPullUpRefreshView) this.fvi.findViewById(d.g.frs_stick_bottom_reload);
        this.fvq.setOnClickListener(this.fvr);
        this.fvp.setOnClickListener(this.fvr);
        onChangeSkinType(this.mSkinType);
    }

    private void biJ() {
        this.fvj = new TbImageView(this.faG.getPageContext().getPageActivity());
        int h = l.h(this.faG.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h, h);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = h;
        this.fvj.setLayoutParams(layoutParams);
        this.fvi.addView(this.fvj);
        this.fvj.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void F(boolean z, boolean z2) {
        if (!this.fvm) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    biM();
                } else {
                    this.fvo.setVisibility(0);
                }
            } else if (z2) {
                biN();
            } else {
                this.fvo.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bfK() {
        if (this.fvp == null) {
            return false;
        }
        return this.isShow;
    }

    private void biK() {
        if (this.faG.isAdded()) {
            this.fvk = AnimationUtils.loadAnimation(this.faG.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.fvk.setAnimationListener(new a(this.fvo));
        }
    }

    private void biL() {
        if (this.faG.isAdded()) {
            this.fvl = AnimationUtils.loadAnimation(this.faG.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.fvl.setAnimationListener(new animation.Animation$AnimationListenerC0297b(this.fvo));
        }
    }

    private void biM() {
        cancelAnimation();
        if (this.fvl == null) {
            biL();
        }
        if (this.fvl != null) {
            this.fvo.setVisibility(0);
            this.fvo.startAnimation(this.fvl);
        }
    }

    private void cancelAnimation() {
        if (this.fvo != null) {
            this.fvo.clearAnimation();
        }
    }

    private boolean bG(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void biN() {
        cancelAnimation();
        if (this.fvk == null) {
            biK();
        }
        if (this.fvk != null) {
            this.fvo.startAnimation(this.fvk);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bfM() {
        if (this.fvp != null && !bG(this.fvp)) {
            this.fvp.aZD();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bfL() {
        if (this.fvp != null && !bG(this.fvp)) {
            this.fvp.aZC();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fvp != null) {
                this.fvp.onChangeSkinType(i);
            }
            if (this.fvq != null) {
                this.fvq.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void jD(boolean z) {
        this.fvm = z;
        if (this.fvp != null) {
            if (z) {
                if (this.fvo != null && this.fvo.getVisibility() == 0) {
                    biN();
                    return;
                }
                return;
            }
            biM();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bip() {
        if (this.fvj != null) {
            this.fvj.clearAnimation();
            this.fvj.setImageDrawable(null);
            this.fvj.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0297b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0297b(View view) {
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
