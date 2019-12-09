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
    private NoPressedRelativeLayout fRT;
    private Animation fRV;
    private Animation fRW;
    private LinearLayout fRZ;
    private EntelechyPullUpRefreshView fSa;
    private EntelechyPullUpRefreshView fSb;
    private FrsFragment fwq;
    private TbImageView fRU = null;
    private int mSkinType = 3;
    private boolean fRX = false;
    private float fRY = 360.0f;
    private boolean cFS = true;
    private View.OnClickListener fSc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fwq != null) {
                if (view == b.this.fSa) {
                    TiebaStatic.eventStat(b.this.fwq.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.fwq.bko() && b.this.fwq.bjN() != null) {
                        TiebaStatic.log(new an("c11752").bS("fid", b.this.fwq.getFid()).bS("obj_locate", "3"));
                        b.this.fwq.bjN().startPullRefresh();
                    }
                } else if (view == b.this.fSb && b.this.fwq.bjN() != null && b.this.fwq.bjN().getListView() != null) {
                    b.this.fwq.bjN().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fRZ = null;
        this.fSa = null;
        this.fSb = null;
        this.fwq = frsFragment;
        this.fRT = noPressedRelativeLayout;
        bqg();
        this.fRZ = (LinearLayout) this.fRT.findViewById(R.id.frs_stick_bottom_holder);
        this.fSb = (EntelechyPullUpRefreshView) this.fRT.findViewById(R.id.frs_stick_bottom_goto_top);
        this.fSa = (EntelechyPullUpRefreshView) this.fRT.findViewById(R.id.frs_stick_bottom_reload);
        this.fSb.setOnClickListener(this.fSc);
        this.fSa.setOnClickListener(this.fSc);
        onChangeSkinType(this.mSkinType);
    }

    private void bqg() {
        this.fRU = new TbImageView(this.fwq.getPageContext().getPageActivity());
        int dimens = l.getDimens(this.fwq.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.fRU.setLayoutParams(layoutParams);
        this.fRT.addView(this.fRU);
        this.fRU.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void K(boolean z, boolean z2) {
        if (!this.fRX) {
            this.cFS = z;
            if (z) {
                if (z2) {
                    bqj();
                } else {
                    this.fRZ.setVisibility(0);
                }
            } else if (z2) {
                bqk();
            } else {
                this.fRZ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bng() {
        if (this.fSa == null) {
            return false;
        }
        return this.cFS;
    }

    private void bqh() {
        if (this.fwq.isAdded()) {
            this.fRV = AnimationUtils.loadAnimation(this.fwq.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.fRV.setAnimationListener(new a(this.fRZ));
        }
    }

    private void bqi() {
        if (this.fwq.isAdded()) {
            this.fRW = AnimationUtils.loadAnimation(this.fwq.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.fRW.setAnimationListener(new animation.Animation$AnimationListenerC0413b(this.fRZ));
        }
    }

    private void bqj() {
        cancelAnimation();
        if (this.fRW == null) {
            bqi();
        }
        if (this.fRW != null) {
            this.fRZ.setVisibility(0);
            this.fRZ.startAnimation(this.fRW);
        }
    }

    private void cancelAnimation() {
        if (this.fRZ != null) {
            this.fRZ.clearAnimation();
        }
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bqk() {
        cancelAnimation();
        if (this.fRV == null) {
            bqh();
        }
        if (this.fRV != null) {
            this.fRZ.startAnimation(this.fRV);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bni() {
        if (this.fSa != null && !bO(this.fSa)) {
            this.fSa.bhI();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bnh() {
        if (this.fSa != null && !bO(this.fSa)) {
            this.fSa.bhH();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fSa != null) {
                this.fSa.onChangeSkinType(i);
            }
            if (this.fSb != null) {
                this.fSb.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void kp(boolean z) {
        this.fRX = z;
        if (this.fSa != null) {
            if (z) {
                if (this.fRZ != null && this.fRZ.getVisibility() == 0) {
                    bqk();
                    return;
                }
                return;
            }
            bqj();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bpL() {
        if (this.fRU != null) {
            this.fRU.clearAnimation();
            this.fRU.setImageDrawable(null);
            this.fRU.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0413b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0413b(View view) {
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
