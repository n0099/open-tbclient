package com.baidu.tieba.frs.h;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout cFU;
    private Animation cFW;
    private Animation cFX;
    private LinearLayout cGa;
    private EntelechyPullUpRefreshView cGb;
    private EntelechyPullUpRefreshView cGc;
    private com.baidu.tieba.frs.f cqt;
    private TbImageView cFV = null;
    private int mSkinType = 3;
    private boolean cFY = false;
    private float cFZ = 360.0f;
    private boolean aDf = true;
    private View.OnClickListener cGd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cqt != null) {
                if (view == b.this.cGb) {
                    TiebaStatic.eventStat(b.this.cqt.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.cqt.ahg() && b.this.cqt.agN() != null) {
                        TiebaStatic.log(new ak("c11752").ad("fid", b.this.cqt.getFid()).ad("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                        b.this.cqt.agN().startPullRefresh();
                    }
                } else if (view == b.this.cGc && b.this.cqt.agN() != null && b.this.cqt.agN().getListView() != null) {
                    b.this.cqt.agN().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cGa = null;
        this.cGb = null;
        this.cGc = null;
        this.cqt = fVar;
        this.cFU = noPressedRelativeLayout;
        alu();
        this.cGa = (LinearLayout) this.cFU.findViewById(d.h.frs_stick_bottom_holder);
        this.cGc = (EntelechyPullUpRefreshView) this.cFU.findViewById(d.h.frs_stick_bottom_goto_top);
        this.cGb = (EntelechyPullUpRefreshView) this.cFU.findViewById(d.h.frs_stick_bottom_reload);
        this.cGc.setOnClickListener(this.cGd);
        this.cGb.setOnClickListener(this.cGd);
        onChangeSkinType(this.mSkinType);
    }

    private void alu() {
        this.cFV = new TbImageView(this.cqt.getPageContext().getPageActivity());
        int g = k.g(this.cqt.getPageContext().getPageActivity(), d.f.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g;
        this.cFV.setLayoutParams(layoutParams);
        this.cFU.addView(this.cFV);
        this.cFV.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void u(boolean z, boolean z2) {
        if (!this.cFY) {
            this.aDf = z;
            if (z) {
                if (z2) {
                    alx();
                } else {
                    this.cGa.setVisibility(0);
                }
            } else if (z2) {
                alz();
            } else {
                this.cGa.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean aiY() {
        if (this.cGb == null) {
            return false;
        }
        return this.aDf;
    }

    private void alv() {
        if (this.cqt.isAdded()) {
            this.cFW = AnimationUtils.loadAnimation(this.cqt.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.cFW.setAnimationListener(new a(this.cGa));
        }
    }

    private void alw() {
        if (this.cqt.isAdded()) {
            this.cFX = AnimationUtils.loadAnimation(this.cqt.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.cFX.setAnimationListener(new animation.Animation$AnimationListenerC0088b(this.cGa));
        }
    }

    private void alx() {
        aly();
        if (this.cFX == null) {
            alw();
        }
        if (this.cFX != null) {
            this.cGa.setVisibility(0);
            this.cGa.startAnimation(this.cFX);
        }
    }

    private void aly() {
        if (this.cGa != null) {
            this.cGa.clearAnimation();
        }
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void alz() {
        aly();
        if (this.cFW == null) {
            alv();
        }
        if (this.cFW != null) {
            this.cGa.startAnimation(this.cFW);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aja() {
        if (this.cGb != null && !aq(this.cGb)) {
            this.cGb.afv();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void aiZ() {
        if (this.cGb != null && !aq(this.cGb)) {
            this.cGb.afu();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cGb != null) {
                this.cGb.onChangeSkinType(i);
            }
            if (this.cGc != null) {
                this.cGc.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fa(boolean z) {
        this.cFY = z;
        if (this.cGb != null) {
            if (z) {
                alz();
            } else {
                alx();
            }
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void u(float f) {
        if (this.cFV != null) {
            if (!this.cFV.isShown()) {
                this.cFV.setVisibility(0);
                aj.c(this.cFV, d.g.icon_pop_refresh);
            }
            if (this.cFV.getAnimation() != null) {
                this.cFV.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.cFZ, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.cFV.startAnimation(rotateAnimation);
            this.cFZ = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void aln() {
        if (this.cFV != null) {
            this.cFV.clearAnimation();
            this.cFV.setImageDrawable(null);
            this.cFV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void kY() {
        if (this.cFV != null && this.cqt != null && this.cqt.getPageContext() != null) {
            if (!this.cFV.isShown()) {
                this.cFV.setVisibility(0);
                aj.c(this.cFV, d.g.icon_pop_refresh);
            }
            if (this.cFV.getAnimation() != null) {
                this.cFV.clearAnimation();
            }
            this.cFV.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cqt.getPageContext().getPageActivity(), d.a.center_head_rotate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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
    /* renamed from: com.baidu.tieba.frs.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class animation.Animation$AnimationListenerC0088b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0088b(View view) {
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
