package com.baidu.tieba.frs.f;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.a {
    private com.baidu.tieba.frs.i dCS;
    private NoPressedRelativeLayout dRF;
    private Animation dRH;
    private Animation dRI;
    private LinearLayout dRL;
    private EntelechyPullUpRefreshView dRM;
    private EntelechyPullUpRefreshView dRN;
    private TbImageView dRG = null;
    private int mSkinType = 3;
    private boolean dRJ = false;
    private float dRK = 360.0f;
    private boolean brM = true;
    private View.OnClickListener dRO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dCS != null) {
                if (view == b.this.dRM) {
                    TiebaStatic.eventStat(b.this.dCS.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.dCS.auw() && b.this.dCS.aud() != null) {
                        TiebaStatic.log(new ak("c11752").aa(ImageViewerConfig.FORUM_ID, b.this.dCS.getFid()).aa("obj_locate", "3"));
                        b.this.dCS.aud().startPullRefresh();
                    }
                } else if (view == b.this.dRN && b.this.dCS.aud() != null && b.this.dCS.aud().getListView() != null) {
                    b.this.dCS.aud().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dRL = null;
        this.dRM = null;
        this.dRN = null;
        this.dCS = iVar;
        this.dRF = noPressedRelativeLayout;
        ayW();
        this.dRL = (LinearLayout) this.dRF.findViewById(d.g.frs_stick_bottom_holder);
        this.dRN = (EntelechyPullUpRefreshView) this.dRF.findViewById(d.g.frs_stick_bottom_goto_top);
        this.dRM = (EntelechyPullUpRefreshView) this.dRF.findViewById(d.g.frs_stick_bottom_reload);
        this.dRN.setOnClickListener(this.dRO);
        this.dRM.setOnClickListener(this.dRO);
        onChangeSkinType(this.mSkinType);
    }

    private void ayW() {
        this.dRG = new TbImageView(this.dCS.getPageContext().getPageActivity());
        int s = l.s(this.dCS.getPageContext().getPageActivity(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(s, s);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = s;
        this.dRG.setLayoutParams(layoutParams);
        this.dRF.addView(this.dRG);
        this.dRG.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void x(boolean z, boolean z2) {
        if (!this.dRJ) {
            this.brM = z;
            if (z) {
                if (z2) {
                    ayZ();
                } else {
                    this.dRL.setVisibility(0);
                }
            } else if (z2) {
                azb();
            } else {
                this.dRL.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean awz() {
        if (this.dRM == null) {
            return false;
        }
        return this.brM;
    }

    private void ayX() {
        if (this.dCS.isAdded()) {
            this.dRH = AnimationUtils.loadAnimation(this.dCS.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_out);
            this.dRH.setAnimationListener(new a(this.dRL));
        }
    }

    private void ayY() {
        if (this.dCS.isAdded()) {
            this.dRI = AnimationUtils.loadAnimation(this.dCS.getPageContext().getPageActivity(), d.a.frs_pull_up_refresh_in);
            this.dRI.setAnimationListener(new animation.Animation$AnimationListenerC0114b(this.dRL));
        }
    }

    private void ayZ() {
        aza();
        if (this.dRI == null) {
            ayY();
        }
        if (this.dRI != null) {
            this.dRL.setVisibility(0);
            this.dRL.startAnimation(this.dRI);
        }
    }

    private void aza() {
        if (this.dRL != null) {
            this.dRL.clearAnimation();
        }
    }

    private boolean bM(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void azb() {
        aza();
        if (this.dRH == null) {
            ayX();
        }
        if (this.dRH != null) {
            this.dRL.startAnimation(this.dRH);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void awB() {
        if (this.dRM != null && !bM(this.dRM)) {
            this.dRM.ast();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void awA() {
        if (this.dRM != null && !bM(this.dRM)) {
            this.dRM.ass();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dRM != null) {
                this.dRM.onChangeSkinType(i);
            }
            if (this.dRN != null) {
                this.dRN.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void fW(boolean z) {
        this.dRJ = z;
        if (this.dRM != null) {
            if (z) {
                if (this.dRL != null && this.dRL.getVisibility() == 0) {
                    azb();
                    return;
                }
                return;
            }
            ayZ();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void K(float f) {
        if (this.dRG != null) {
            if (!this.dRG.isShown()) {
                this.dRG.setVisibility(0);
                aj.c(this.dRG, d.f.icon_pop_refresh);
            }
            if (this.dRG.getAnimation() != null) {
                this.dRG.clearAnimation();
            }
            RotateAnimation rotateAnimation = new RotateAnimation(this.dRK, f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setFillBefore(true);
            rotateAnimation.setFillAfter(true);
            this.dRG.startAnimation(rotateAnimation);
            this.dRK = f;
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void ayR() {
        if (this.dRG != null) {
            this.dRG.clearAnimation();
            this.dRG.setImageDrawable(null);
            this.dRG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void st() {
        if (this.dRG != null && this.dCS != null && this.dCS.getPageContext() != null) {
            if (!this.dRG.isShown()) {
                this.dRG.setVisibility(0);
                aj.c(this.dRG, d.f.icon_pop_refresh);
            }
            if (this.dRG.getAnimation() != null) {
                this.dRG.clearAnimation();
            }
            this.dRG.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.dCS.getPageContext().getPageActivity(), d.a.center_head_rotate));
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
    /* renamed from: com.baidu.tieba.frs.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class animation.Animation$AnimationListenerC0114b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0114b(View view) {
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
