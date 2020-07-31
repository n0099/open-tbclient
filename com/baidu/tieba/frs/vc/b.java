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
    private NoPressedRelativeLayout ifc;
    private Animation ife;
    private Animation iff;
    private LinearLayout ifi;
    private EntelechyPullUpRefreshView ifj;
    private EntelechyPullUpRefreshView ifk;
    private TbImageView ifd = null;
    private int mSkinType = 3;
    private boolean ifg = false;
    private float ifh = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener ifl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hHU != null) {
                if (view == b.this.ifj) {
                    TiebaStatic.eventStat(b.this.hHU.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.hHU.cca() && b.this.hHU.cbw() != null) {
                        TiebaStatic.log(new ap("c11752").dn("fid", b.this.hHU.getFid()).dn("obj_locate", "3"));
                        b.this.hHU.cbw().startPullRefresh();
                    }
                } else if (view == b.this.ifk && b.this.hHU.cbw() != null && b.this.hHU.cbw().getListView() != null) {
                    b.this.hHU.cbw().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.ifi = null;
        this.ifj = null;
        this.ifk = null;
        this.hHU = frsFragment;
        this.ifc = noPressedRelativeLayout;
        cio();
        this.ifi = (LinearLayout) this.ifc.findViewById(R.id.frs_stick_bottom_holder);
        this.ifk = (EntelechyPullUpRefreshView) this.ifc.findViewById(R.id.frs_stick_bottom_goto_top);
        this.ifj = (EntelechyPullUpRefreshView) this.ifc.findViewById(R.id.frs_stick_bottom_reload);
        this.ifk.setOnClickListener(this.ifl);
        this.ifj.setOnClickListener(this.ifl);
        onChangeSkinType(this.mSkinType);
    }

    private void cio() {
        this.ifd = new TbImageView(this.hHU.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.hHU.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.ifd.setLayoutParams(layoutParams);
        this.ifc.addView(this.ifd);
        this.ifd.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void Q(boolean z, boolean z2) {
        if (!this.ifg) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cir();
                } else {
                    this.ifi.setVisibility(0);
                }
            } else if (z2) {
                cis();
            } else {
                this.ifi.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cfl() {
        if (this.ifj == null) {
            return false;
        }
        return this.isShow;
    }

    private void cip() {
        if (this.hHU.isAdded()) {
            this.ife = AnimationUtils.loadAnimation(this.hHU.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.ife.setAnimationListener(new a(this.ifi));
        }
    }

    private void ciq() {
        if (this.hHU.isAdded()) {
            this.iff = AnimationUtils.loadAnimation(this.hHU.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.iff.setAnimationListener(new animation.Animation$AnimationListenerC0638b(this.ifi));
        }
    }

    private void cir() {
        cancelAnimation();
        if (this.iff == null) {
            ciq();
        }
        if (this.iff != null) {
            this.ifi.setVisibility(0);
            this.ifi.startAnimation(this.iff);
        }
    }

    private void cancelAnimation() {
        if (this.ifi != null) {
            this.ifi.clearAnimation();
        }
    }

    private void cis() {
        cancelAnimation();
        if (this.ife == null) {
            cip();
        }
        if (this.ife != null) {
            this.ifi.startAnimation(this.ife);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ifj != null) {
                this.ifj.onChangeSkinType(i);
            }
            if (this.ifk != null) {
                this.ifk.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void ok(boolean z) {
        this.ifg = z;
        if (this.ifj != null) {
            if (z) {
                if (this.ifi != null && this.ifi.getVisibility() == 0) {
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
        if (this.ifd != null) {
            this.ifd.clearAnimation();
            this.ifd.setImageDrawable(null);
            this.ifd.setVisibility(8);
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
