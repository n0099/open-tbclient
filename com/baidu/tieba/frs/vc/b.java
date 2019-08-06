package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout fRA;
    private Animation fRC;
    private Animation fRD;
    private LinearLayout fRG;
    private EntelechyPullUpRefreshView fRH;
    private EntelechyPullUpRefreshView fRI;
    private FrsFragment fwg;
    private TbImageView fRB = null;
    private int mSkinType = 3;
    private boolean fRE = false;
    private float fRF = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener fRJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fwg != null) {
                if (view == b.this.fRH) {
                    TiebaStatic.eventStat(b.this.fwg.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.fwg.bmz() && b.this.fwg.blY() != null) {
                        TiebaStatic.log(new an("c11752").bT("fid", b.this.fwg.getFid()).bT("obj_locate", "3"));
                        b.this.fwg.blY().startPullRefresh();
                    }
                } else if (view == b.this.fRI && b.this.fwg.blY() != null && b.this.fwg.blY().getListView() != null) {
                    b.this.fwg.blY().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fRG = null;
        this.fRH = null;
        this.fRI = null;
        this.fwg = frsFragment;
        this.fRA = noPressedRelativeLayout;
        bss();
        this.fRG = (LinearLayout) this.fRA.findViewById(R.id.frs_stick_bottom_holder);
        this.fRI = (EntelechyPullUpRefreshView) this.fRA.findViewById(R.id.frs_stick_bottom_goto_top);
        this.fRH = (EntelechyPullUpRefreshView) this.fRA.findViewById(R.id.frs_stick_bottom_reload);
        this.fRI.setOnClickListener(this.fRJ);
        this.fRH.setOnClickListener(this.fRJ);
        onChangeSkinType(this.mSkinType);
    }

    private void bss() {
        this.fRB = new TbImageView(this.fwg.getPageContext().getPageActivity());
        int g = l.g(this.fwg.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.fRB.setLayoutParams(layoutParams);
        this.fRA.addView(this.fRB);
        this.fRB.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void H(boolean z, boolean z2) {
        if (!this.fRE) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bsv();
                } else {
                    this.fRG.setVisibility(0);
                }
            } else if (z2) {
                bsw();
            } else {
                this.fRG.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bps() {
        if (this.fRH == null) {
            return false;
        }
        return this.isShow;
    }

    private void bst() {
        if (this.fwg.isAdded()) {
            this.fRC = AnimationUtils.loadAnimation(this.fwg.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.fRC.setAnimationListener(new a(this.fRG));
        }
    }

    private void bsu() {
        if (this.fwg.isAdded()) {
            this.fRD = AnimationUtils.loadAnimation(this.fwg.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.fRD.setAnimationListener(new animation.Animation$AnimationListenerC0318b(this.fRG));
        }
    }

    private void bsv() {
        cancelAnimation();
        if (this.fRD == null) {
            bsu();
        }
        if (this.fRD != null) {
            this.fRG.setVisibility(0);
            this.fRG.startAnimation(this.fRD);
        }
    }

    private void cancelAnimation() {
        if (this.fRG != null) {
            this.fRG.clearAnimation();
        }
    }

    private boolean bR(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bsw() {
        cancelAnimation();
        if (this.fRC == null) {
            bst();
        }
        if (this.fRC != null) {
            this.fRG.startAnimation(this.fRC);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bpu() {
        if (this.fRH != null && !bR(this.fRH)) {
            this.fRH.bjg();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bpt() {
        if (this.fRH != null && !bR(this.fRH)) {
            this.fRH.bjf();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fRH != null) {
                this.fRH.onChangeSkinType(i);
            }
            if (this.fRI != null) {
                this.fRI.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void kz(boolean z) {
        this.fRE = z;
        if (this.fRH != null) {
            if (z) {
                if (this.fRG != null && this.fRG.getVisibility() == 0) {
                    bsw();
                    return;
                }
                return;
            }
            bsv();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void brW() {
        if (this.fRB != null) {
            this.fRB.clearAnimation();
            this.fRB.setImageDrawable(null);
            this.fRB.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0318b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0318b(View view) {
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
