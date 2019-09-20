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
    private NoPressedRelativeLayout fTr;
    private Animation fTt;
    private Animation fTu;
    private LinearLayout fTx;
    private EntelechyPullUpRefreshView fTy;
    private EntelechyPullUpRefreshView fTz;
    private FrsFragment fxT;
    private TbImageView fTs = null;
    private int mSkinType = 3;
    private boolean fTv = false;
    private float fTw = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener fTA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fxT != null) {
                if (view == b.this.fTy) {
                    TiebaStatic.eventStat(b.this.fxT.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.fxT.bnk() && b.this.fxT.bmJ() != null) {
                        TiebaStatic.log(new an("c11752").bT("fid", b.this.fxT.getFid()).bT("obj_locate", "3"));
                        b.this.fxT.bmJ().startPullRefresh();
                    }
                } else if (view == b.this.fTz && b.this.fxT.bmJ() != null && b.this.fxT.bmJ().getListView() != null) {
                    b.this.fxT.bmJ().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fTx = null;
        this.fTy = null;
        this.fTz = null;
        this.fxT = frsFragment;
        this.fTr = noPressedRelativeLayout;
        btf();
        this.fTx = (LinearLayout) this.fTr.findViewById(R.id.frs_stick_bottom_holder);
        this.fTz = (EntelechyPullUpRefreshView) this.fTr.findViewById(R.id.frs_stick_bottom_goto_top);
        this.fTy = (EntelechyPullUpRefreshView) this.fTr.findViewById(R.id.frs_stick_bottom_reload);
        this.fTz.setOnClickListener(this.fTA);
        this.fTy.setOnClickListener(this.fTA);
        onChangeSkinType(this.mSkinType);
    }

    private void btf() {
        this.fTs = new TbImageView(this.fxT.getPageContext().getPageActivity());
        int g = l.g(this.fxT.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.fTs.setLayoutParams(layoutParams);
        this.fTr.addView(this.fTs);
        this.fTs.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void H(boolean z, boolean z2) {
        if (!this.fTv) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bti();
                } else {
                    this.fTx.setVisibility(0);
                }
            } else if (z2) {
                btj();
            } else {
                this.fTx.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bqd() {
        if (this.fTy == null) {
            return false;
        }
        return this.isShow;
    }

    private void btg() {
        if (this.fxT.isAdded()) {
            this.fTt = AnimationUtils.loadAnimation(this.fxT.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.fTt.setAnimationListener(new a(this.fTx));
        }
    }

    private void bth() {
        if (this.fxT.isAdded()) {
            this.fTu = AnimationUtils.loadAnimation(this.fxT.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.fTu.setAnimationListener(new animation.Animation$AnimationListenerC0329b(this.fTx));
        }
    }

    private void bti() {
        cancelAnimation();
        if (this.fTu == null) {
            bth();
        }
        if (this.fTu != null) {
            this.fTx.setVisibility(0);
            this.fTx.startAnimation(this.fTu);
        }
    }

    private void cancelAnimation() {
        if (this.fTx != null) {
            this.fTx.clearAnimation();
        }
    }

    private boolean bR(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void btj() {
        cancelAnimation();
        if (this.fTt == null) {
            btg();
        }
        if (this.fTt != null) {
            this.fTx.startAnimation(this.fTt);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bqf() {
        if (this.fTy != null && !bR(this.fTy)) {
            this.fTy.bjR();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bqe() {
        if (this.fTy != null && !bR(this.fTy)) {
            this.fTy.bjQ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fTy != null) {
                this.fTy.onChangeSkinType(i);
            }
            if (this.fTz != null) {
                this.fTz.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void kC(boolean z) {
        this.fTv = z;
        if (this.fTy != null) {
            if (z) {
                if (this.fTx != null && this.fTx.getVisibility() == 0) {
                    btj();
                    return;
                }
                return;
            }
            bti();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bsJ() {
        if (this.fTs != null) {
            this.fTs.clearAnimation();
            this.fTs.setImageDrawable(null);
            this.fTs.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0329b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0329b(View view) {
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
