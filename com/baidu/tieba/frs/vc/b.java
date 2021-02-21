package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.a.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout jJS;
    private Animation jJU;
    private Animation jJV;
    private LinearLayout jJY;
    private EntelechyPullUpRefreshView jJZ;
    private EntelechyPullUpRefreshView jKa;
    private FrsFragment jiS;
    private TbImageView jJT = null;
    private int mSkinType = 3;
    private boolean jJW = false;
    private float jJX = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener jKb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.jiS != null) {
                if (view == b.this.jJZ) {
                    TiebaStatic.eventStat(b.this.jiS.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.jiS.cDh() && b.this.jiS.cCB() != null) {
                        TiebaStatic.log(new ar("c11752").dR("fid", b.this.jiS.getFid()).dR("obj_locate", "3"));
                        b.this.jiS.cCB().startPullRefresh();
                    }
                } else if (view == b.this.jKa && b.this.jiS.cCB() != null && b.this.jiS.cCB().getListView() != null) {
                    b.this.jiS.cCB().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jJY = null;
        this.jJZ = null;
        this.jKa = null;
        this.jiS = frsFragment;
        this.jJS = noPressedRelativeLayout;
        cKO();
        this.jJY = (LinearLayout) this.jJS.findViewById(R.id.frs_stick_bottom_holder);
        this.jKa = (EntelechyPullUpRefreshView) this.jJS.findViewById(R.id.frs_stick_bottom_goto_top);
        this.jJZ = (EntelechyPullUpRefreshView) this.jJS.findViewById(R.id.frs_stick_bottom_reload);
        this.jKa.setOnClickListener(this.jKb);
        this.jJZ.setOnClickListener(this.jKb);
        onChangeSkinType(this.mSkinType);
    }

    private void cKO() {
        this.jJT = new TbImageView(this.jiS.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jiS.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.jJT.setLayoutParams(layoutParams);
        this.jJS.addView(this.jJT);
        this.jJT.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void aa(boolean z, boolean z2) {
        if (!this.jJW) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cKR();
                } else {
                    this.jJY.setVisibility(0);
                }
            } else if (z2) {
                cKS();
            } else {
                this.jJY.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public boolean cGI() {
        if (this.jJZ == null) {
            return false;
        }
        return this.isShow;
    }

    private void cKP() {
        if (this.jiS.isAdded()) {
            this.jJU = AnimationUtils.loadAnimation(this.jiS.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.jJU.setAnimationListener(new a(this.jJY));
        }
    }

    private void cKQ() {
        if (this.jiS.isAdded()) {
            this.jJV = AnimationUtils.loadAnimation(this.jiS.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.jJV.setAnimationListener(new animation.Animation$AnimationListenerC0735b(this.jJY));
        }
    }

    private void cKR() {
        cancelAnimation();
        if (this.jJV == null) {
            cKQ();
        }
        if (this.jJV != null) {
            this.jJY.setVisibility(0);
            this.jJY.startAnimation(this.jJV);
        }
    }

    private void cancelAnimation() {
        if (this.jJY != null) {
            this.jJY.clearAnimation();
        }
    }

    private void cKS() {
        cancelAnimation();
        if (this.jJU == null) {
            cKP();
        }
        if (this.jJU != null) {
            this.jJY.startAnimation(this.jJU);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jJZ != null) {
                this.jJZ.onChangeSkinType(i);
            }
            if (this.jKa != null) {
                this.jKa.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.c
    public void rg(boolean z) {
        this.jJW = z;
        if (this.jJZ != null) {
            if (z) {
                if (this.jJY != null && this.jJY.getVisibility() == 0) {
                    cKS();
                    return;
                }
                return;
            }
            cKR();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cKp() {
        if (this.jJT != null) {
            this.jJT.clearAnimation();
            this.jJT.setImageDrawable(null);
            this.jJT.setVisibility(8);
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
    public static class animation.Animation$AnimationListenerC0735b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0735b(View view) {
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
