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
/* loaded from: classes22.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment iVq;
    private NoPressedRelativeLayout jwj;
    private Animation jwl;
    private Animation jwm;
    private LinearLayout jwp;
    private EntelechyPullUpRefreshView jwq;
    private EntelechyPullUpRefreshView jwr;
    private TbImageView jwk = null;
    private int mSkinType = 3;
    private boolean jwn = false;
    private float jwo = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener jws = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iVq != null) {
                if (view == b.this.jwq) {
                    TiebaStatic.eventStat(b.this.iVq.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.iVq.cCK() && b.this.iVq.cCe() != null) {
                        TiebaStatic.log(new ar("c11752").dY("fid", b.this.iVq.getFid()).dY("obj_locate", "3"));
                        b.this.iVq.cCe().startPullRefresh();
                    }
                } else if (view == b.this.jwr && b.this.iVq.cCe() != null && b.this.iVq.cCe().getListView() != null) {
                    b.this.iVq.cCe().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jwp = null;
        this.jwq = null;
        this.jwr = null;
        this.iVq = frsFragment;
        this.jwj = noPressedRelativeLayout;
        cKj();
        this.jwp = (LinearLayout) this.jwj.findViewById(R.id.frs_stick_bottom_holder);
        this.jwr = (EntelechyPullUpRefreshView) this.jwj.findViewById(R.id.frs_stick_bottom_goto_top);
        this.jwq = (EntelechyPullUpRefreshView) this.jwj.findViewById(R.id.frs_stick_bottom_reload);
        this.jwr.setOnClickListener(this.jws);
        this.jwq.setOnClickListener(this.jws);
        onChangeSkinType(this.mSkinType);
    }

    private void cKj() {
        this.jwk = new TbImageView(this.iVq.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.iVq.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.jwk.setLayoutParams(layoutParams);
        this.jwj.addView(this.jwk);
        this.jwk.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Y(boolean z, boolean z2) {
        if (!this.jwn) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cKm();
                } else {
                    this.jwp.setVisibility(0);
                }
            } else if (z2) {
                cKn();
            } else {
                this.jwp.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cGf() {
        if (this.jwq == null) {
            return false;
        }
        return this.isShow;
    }

    private void cKk() {
        if (this.iVq.isAdded()) {
            this.jwl = AnimationUtils.loadAnimation(this.iVq.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.jwl.setAnimationListener(new a(this.jwp));
        }
    }

    private void cKl() {
        if (this.iVq.isAdded()) {
            this.jwm = AnimationUtils.loadAnimation(this.iVq.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.jwm.setAnimationListener(new animation.Animation$AnimationListenerC0751b(this.jwp));
        }
    }

    private void cKm() {
        cancelAnimation();
        if (this.jwm == null) {
            cKl();
        }
        if (this.jwm != null) {
            this.jwp.setVisibility(0);
            this.jwp.startAnimation(this.jwm);
        }
    }

    private void cancelAnimation() {
        if (this.jwp != null) {
            this.jwp.clearAnimation();
        }
    }

    private void cKn() {
        cancelAnimation();
        if (this.jwl == null) {
            cKk();
        }
        if (this.jwl != null) {
            this.jwp.startAnimation(this.jwl);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jwq != null) {
                this.jwq.onChangeSkinType(i);
            }
            if (this.jwr != null) {
                this.jwr.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void qC(boolean z) {
        this.jwn = z;
        if (this.jwq != null) {
            if (z) {
                if (this.jwp != null && this.jwp.getVisibility() == 0) {
                    cKn();
                    return;
                }
                return;
            }
            cKm();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cJL() {
        if (this.jwk != null) {
            this.jwk.clearAnimation();
            this.jwk.setImageDrawable(null);
            this.jwk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
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
    /* loaded from: classes22.dex */
    public static class animation.Animation$AnimationListenerC0751b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0751b(View view) {
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
