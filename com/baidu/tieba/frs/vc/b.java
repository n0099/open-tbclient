package com.baidu.tieba.frs.vc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes21.dex */
public class b implements com.baidu.tieba.frs.entelechy.b.c, com.baidu.tieba.frs.tab.c {
    private NoPressedRelativeLayout iAK;
    private Animation iAM;
    private Animation iAN;
    private LinearLayout iAQ;
    private EntelechyPullUpRefreshView iAR;
    private EntelechyPullUpRefreshView iAS;
    private FrsFragment icq;
    private TbImageView iAL = null;
    private int mSkinType = 3;
    private boolean iAO = false;
    private float iAP = 360.0f;
    private boolean isShow = true;
    private View.OnClickListener iAT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.icq != null) {
                if (view == b.this.iAR) {
                    TiebaStatic.eventStat(b.this.icq.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                    if (!b.this.icq.cpK() && b.this.icq.cpf() != null) {
                        TiebaStatic.log(new aq("c11752").dF("fid", b.this.icq.getFid()).dF("obj_locate", "3"));
                        b.this.icq.cpf().startPullRefresh();
                    }
                } else if (view == b.this.iAS && b.this.icq.cpf() != null && b.this.icq.cpf().getListView() != null) {
                    b.this.icq.cpf().getListView().smoothScrollToPosition(0);
                }
            }
        }
    };

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.iAQ = null;
        this.iAR = null;
        this.iAS = null;
        this.icq = frsFragment;
        this.iAK = noPressedRelativeLayout;
        cwk();
        this.iAQ = (LinearLayout) this.iAK.findViewById(R.id.frs_stick_bottom_holder);
        this.iAS = (EntelechyPullUpRefreshView) this.iAK.findViewById(R.id.frs_stick_bottom_goto_top);
        this.iAR = (EntelechyPullUpRefreshView) this.iAK.findViewById(R.id.frs_stick_bottom_reload);
        this.iAS.setOnClickListener(this.iAT);
        this.iAR.setOnClickListener(this.iAT);
        onChangeSkinType(this.mSkinType);
    }

    private void cwk() {
        this.iAL = new TbImageView(this.icq.getPageContext().getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.icq.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = dimens;
        this.iAL.setLayoutParams(layoutParams);
        this.iAK.addView(this.iAL);
        this.iAL.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void W(boolean z, boolean z2) {
        if (!this.iAO) {
            this.isShow = z;
            if (z) {
                if (z2) {
                    cwn();
                } else {
                    this.iAQ.setVisibility(0);
                }
            } else if (z2) {
                cwo();
            } else {
                this.iAQ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public boolean cte() {
        if (this.iAR == null) {
            return false;
        }
        return this.isShow;
    }

    private void cwl() {
        if (this.icq.isAdded()) {
            this.iAM = AnimationUtils.loadAnimation(this.icq.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.iAM.setAnimationListener(new a(this.iAQ));
        }
    }

    private void cwm() {
        if (this.icq.isAdded()) {
            this.iAN = AnimationUtils.loadAnimation(this.icq.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.iAN.setAnimationListener(new animation.Animation$AnimationListenerC0686b(this.iAQ));
        }
    }

    private void cwn() {
        cancelAnimation();
        if (this.iAN == null) {
            cwm();
        }
        if (this.iAN != null) {
            this.iAQ.setVisibility(0);
            this.iAQ.startAnimation(this.iAN);
        }
    }

    private void cancelAnimation() {
        if (this.iAQ != null) {
            this.iAQ.clearAnimation();
        }
    }

    private void cwo() {
        cancelAnimation();
        if (this.iAM == null) {
            cwl();
        }
        if (this.iAM != null) {
            this.iAQ.startAnimation(this.iAM);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iAR != null) {
                this.iAR.onChangeSkinType(i);
            }
            if (this.iAS != null) {
                this.iAS.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.c
    public void oW(boolean z) {
        this.iAO = z;
        if (this.iAR != null) {
            if (z) {
                if (this.iAQ != null && this.iAQ.getVisibility() == 0) {
                    cwo();
                    return;
                }
                return;
            }
            cwn();
        }
    }

    @Override // com.baidu.tieba.frs.tab.c
    public void cvO() {
        if (this.iAL != null) {
            this.iAL.clearAnimation();
            this.iAL.setImageDrawable(null);
            this.iAL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
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
    /* loaded from: classes21.dex */
    public static class animation.Animation$AnimationListenerC0686b implements Animation.AnimationListener {
        View view;

        public animation.Animation$AnimationListenerC0686b(View view) {
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
