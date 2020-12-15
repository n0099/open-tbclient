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
    private FrsFragment iVs;
    private NoPressedRelativeLayout jwl;
    private Animation jwn;
    private Animation jwo;
    private LinearLayout jwr;
    private EntelechyPullUpRefreshView jws;
    private EntelechyPullUpRefreshView jwt;
    private TbImageView jwm = null;
    private int mSkinType = 3;
    private boolean jwp = false;
    private float jwq = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener jwu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iVs != null) {
                if (view == b.this.jws) {
                    TiebaStatic.eventStat(b.this.iVs.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.iVs.cCL() && b.this.iVs.cCf() != null) {
                        TiebaStatic.log(new ar("c11752").dY("fid", b.this.iVs.getFid()).dY("obj_locate", "3"));
                        b.this.iVs.cCf().startPullRefresh();
                    }
                } else if (view == b.this.jwt && b.this.iVs.cCf() != null && b.this.iVs.cCf().getListView() != null) {
                    b.this.iVs.cCf().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jwr = null;
        this.jws = null;
        this.jwt = null;
        this.iVs = frsFragment;
        this.jwl = noPressedRelativeLayout;
        cKk();
        this.jwr = (LinearLayout) this.jwl.findViewById(R.id.frs_stick_bottom_holder);
        this.jwt = (EntelechyPullUpRefreshView) this.jwl.findViewById(R.id.frs_stick_bottom_goto_top);
        this.jws = (EntelechyPullUpRefreshView) this.jwl.findViewById(R.id.frs_stick_bottom_reload);
        this.jwt.setOnClickListener(this.jwu);
        this.jws.setOnClickListener(this.jwu);
        onChangeSkinType(this.mSkinType);
    }

    private void cKk() {
        this.jwm = new TbImageView(this.iVs.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.iVs.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.jwm.setLayoutParams(layoutParams);
        this.jwl.addView(this.jwm);
        this.jwm.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Y(boolean z, boolean z2) {
        if (!this.jwp) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cKn();
                } else {
                    this.jwr.setVisibility(0);
                }
            } else if (z2) {
                cKo();
            } else {
                this.jwr.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cGg() {
        if (this.jws == null) {
            return false;
        }
        return this.isShow;
    }

    private void cKl() {
        if (this.iVs.isAdded()) {
            this.jwn = AnimationUtils.loadAnimation(this.iVs.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.jwn.setAnimationListener(new a(this.jwr));
        }
    }

    private void cKm() {
        if (this.iVs.isAdded()) {
            this.jwo = AnimationUtils.loadAnimation(this.iVs.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.jwo.setAnimationListener(new animation.Animation$AnimationListenerC0751b(this.jwr));
        }
    }

    private void cKn() {
        cancelAnimation();
        if (this.jwo == null) {
            cKm();
        }
        if (this.jwo != null) {
            this.jwr.setVisibility(0);
            this.jwr.startAnimation(this.jwo);
        }
    }

    private void cancelAnimation() {
        if (this.jwr != null) {
            this.jwr.clearAnimation();
        }
    }

    private void cKo() {
        cancelAnimation();
        if (this.jwn == null) {
            cKl();
        }
        if (this.jwn != null) {
            this.jwr.startAnimation(this.jwn);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jws != null) {
                this.jws.onChangeSkinType(i);
            }
            if (this.jwt != null) {
                this.jwt.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void qC(boolean z) {
        this.jwp = z;
        if (this.jws != null) {
            if (z) {
                if (this.jwr != null && this.jwr.getVisibility() == 0) {
                    cKo();
                    return;
                }
                return;
            }
            cKn();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cJM() {
        if (this.jwm != null) {
            this.jwm.clearAnimation();
            this.jwm.setImageDrawable(null);
            this.jwm.setVisibility(8);
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
