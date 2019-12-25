package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes6.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout gGh;
    private Animation gGj;
    private Animation gGk;
    private LinearLayout gGn;
    private EntelechyPullUpRefreshView gGo;
    private EntelechyPullUpRefreshView gGp;
    private FrsFragment gkN;
    private TbImageView gGi = null;
    private int mSkinType = 3;
    private boolean gGl = false;
    private float gGm = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener gGq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gkN != null) {
                if (view == b.this.gGo) {
                    TiebaStatic.eventStat(b.this.gkN.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.gkN.bBJ() && b.this.gkN.bBi() != null) {
                        TiebaStatic.log(new an("c11752").cp("fid", b.this.gkN.getFid()).cp("obj_locate", "3"));
                        b.this.gkN.bBi().startPullRefresh();
                    }
                } else if (view == b.this.gGp && b.this.gkN.bBi() != null && b.this.gkN.bBi().getListView() != null) {
                    b.this.gkN.bBi().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gGn = null;
        this.gGo = null;
        this.gGp = null;
        this.gkN = frsFragment;
        this.gGh = noPressedRelativeLayout;
        bHB();
        this.gGn = (LinearLayout) this.gGh.findViewById(R.id.frs_stick_bottom_holder);
        this.gGp = (EntelechyPullUpRefreshView) this.gGh.findViewById(R.id.frs_stick_bottom_goto_top);
        this.gGo = (EntelechyPullUpRefreshView) this.gGh.findViewById(R.id.frs_stick_bottom_reload);
        this.gGp.setOnClickListener(this.gGq);
        this.gGo.setOnClickListener(this.gGq);
        onChangeSkinType(this.mSkinType);
    }

    private void bHB() {
        this.gGi = new TbImageView(this.gkN.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.gkN.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.gGi.setLayoutParams(layoutParams);
        this.gGh.addView(this.gGi);
        this.gGi.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void K(boolean z, boolean z2) {
        if (!this.gGl) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    bHE();
                } else {
                    this.gGn.setVisibility(0);
                }
            } else if (z2) {
                bHF();
            } else {
                this.gGn.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean bEE() {
        if (this.gGo == null) {
            return false;
        }
        return this.isShow;
    }

    private void bHC() {
        if (this.gkN.isAdded()) {
            this.gGj = AnimationUtils.loadAnimation(this.gkN.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.gGj.setAnimationListener(new a(this.gGn));
        }
    }

    private void bHD() {
        if (this.gkN.isAdded()) {
            this.gGk = AnimationUtils.loadAnimation(this.gkN.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.gGk.setAnimationListener(new animation.Animation$AnimationListenerC0501b(this.gGn));
        }
    }

    private void bHE() {
        cancelAnimation();
        if (this.gGk == null) {
            bHD();
        }
        if (this.gGk != null) {
            this.gGn.setVisibility(0);
            this.gGn.startAnimation(this.gGk);
        }
    }

    private void cancelAnimation() {
        if (this.gGn != null) {
            this.gGn.clearAnimation();
        }
    }

    private boolean bJ(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void bHF() {
        cancelAnimation();
        if (this.gGj == null) {
            bHC();
        }
        if (this.gGj != null) {
            this.gGn.startAnimation(this.gGj);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bEG() {
        if (this.gGo != null && !bJ(this.gGo)) {
            this.gGo.bzd();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void bEF() {
        if (this.gGo != null && !bJ(this.gGo)) {
            this.gGo.bzc();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gGo != null) {
                this.gGo.onChangeSkinType(i);
            }
            if (this.gGp != null) {
                this.gGp.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void lB(boolean z) {
        this.gGl = z;
        if (this.gGo != null) {
            if (z) {
                if (this.gGn != null && this.gGn.getVisibility() == 0) {
                    bHF();
                    return;
                }
                return;
            }
            bHE();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void bHh() {
        if (this.gGi != null) {
            this.gGi.clearAnimation();
            this.gGi.setImageDrawable(null);
            this.gGi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static class animation.Animation$AnimationListenerC0501b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0501b(View view) {
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
