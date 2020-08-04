package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes16.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private FrsFragment hHU;
    private NoPressedRelativeLayout ife;
    private Animation ifg;
    private Animation ifh;
    private LinearLayout ifk;
    private EntelechyPullUpRefreshView ifl;
    private EntelechyPullUpRefreshView ifm;
    private TbImageView iff = null;
    private int mSkinType = 3;
    private boolean ifi = false;
    private float ifj = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener ifn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hHU != null) {
                if (view == b.this.ifl) {
                    TiebaStatic.eventStat(b.this.hHU.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.hHU.cca() && b.this.hHU.cbw() != null) {
                        TiebaStatic.log(new ap("c11752").dn("fid", b.this.hHU.getFid()).dn("obj_locate", "3"));
                        b.this.hHU.cbw().startPullRefresh();
                    }
                } else if (view == b.this.ifm && b.this.hHU.cbw() != null && b.this.hHU.cbw().getListView() != null) {
                    b.this.hHU.cbw().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.ifk = null;
        this.ifl = null;
        this.ifm = null;
        this.hHU = frsFragment;
        this.ife = noPressedRelativeLayout;
        cio();
        this.ifk = (LinearLayout) this.ife.findViewById(R.id.frs_stick_bottom_holder);
        this.ifm = (EntelechyPullUpRefreshView) this.ife.findViewById(R.id.frs_stick_bottom_goto_top);
        this.ifl = (EntelechyPullUpRefreshView) this.ife.findViewById(R.id.frs_stick_bottom_reload);
        this.ifm.setOnClickListener(this.ifn);
        this.ifl.setOnClickListener(this.ifn);
        onChangeSkinType(this.mSkinType);
    }

    private void cio() {
        this.iff = new TbImageView(this.hHU.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.hHU.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.iff.setLayoutParams(layoutParams);
        this.ife.addView(this.iff);
        this.iff.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Q(boolean z, boolean z2) {
        if (!this.ifi) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cir();
                } else {
                    this.ifk.setVisibility(0);
                }
            } else if (z2) {
                cis();
            } else {
                this.ifk.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cfl() {
        if (this.ifl == null) {
            return false;
        }
        return this.isShow;
    }

    private void cip() {
        if (this.hHU.isAdded()) {
            this.ifg = AnimationUtils.loadAnimation(this.hHU.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.ifg.setAnimationListener(new a(this.ifk));
        }
    }

    private void ciq() {
        if (this.hHU.isAdded()) {
            this.ifh = AnimationUtils.loadAnimation(this.hHU.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.ifh.setAnimationListener(new animation.Animation$AnimationListenerC0638b(this.ifk));
        }
    }

    private void cir() {
        cancelAnimation();
        if (this.ifh == null) {
            ciq();
        }
        if (this.ifh != null) {
            this.ifk.setVisibility(0);
            this.ifk.startAnimation(this.ifh);
        }
    }

    private void cancelAnimation() {
        if (this.ifk != null) {
            this.ifk.clearAnimation();
        }
    }

    private void cis() {
        cancelAnimation();
        if (this.ifg == null) {
            cip();
        }
        if (this.ifg != null) {
            this.ifk.startAnimation(this.ifg);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ifl != null) {
                this.ifl.onChangeSkinType(i);
            }
            if (this.ifm != null) {
                this.ifm.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ok(boolean z) {
        this.ifi = z;
        if (this.ifl != null) {
            if (z) {
                if (this.ifk != null && this.ifk.getVisibility() == 0) {
                    cis();
                    return;
                }
                return;
            }
            cir();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void chU() {
        if (this.iff != null) {
            this.iff.clearAnimation();
            this.iff.setImageDrawable(null);
            this.iff.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
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
    /* loaded from: classes16.dex */
    public static class animation.Animation$AnimationListenerC0638b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0638b(View view) {
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
