package com.baidu.tieba.ala.guardclub;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ag;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes2.dex */
public class f {
    private AlphaAnimation eAW;
    private AnimatorSet eAX;
    private AnimatorSet eAY;
    private LottieAnimationView ewp;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(ViewGroup viewGroup, com.baidu.tieba.ala.guardclub.model.c cVar, com.baidu.live.data.l lVar) {
        if (viewGroup != null && this.mTbPageContext != null && lVar != null && lVar.Wt != null) {
            String str = lVar.Wt.nickName;
            if (TextUtils.isEmpty(str)) {
                str = lVar.Wt.userName;
            }
            a(viewGroup, lVar.Wt.portrait, str);
        }
    }

    public void a(final ViewGroup viewGroup, String str, String str2) {
        if (viewGroup != null && this.mTbPageContext != null) {
            onDestory();
            if (bcT()) {
                String str3 = null;
                ag bdb = l.bcZ().bdb();
                if (bdb != null && !TextUtils.isEmpty(bdb.aao)) {
                    str3 = bdb.aao;
                }
                if (str3 == null) {
                    str3 = this.mTbPageContext.getString(a.i.guard_club_add_suc);
                }
                BdUtilHelper.getCustomToast().showToast(str3, 1);
                return;
            }
            final View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.view_guardclub_join_result, (ViewGroup) null);
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = iArr[1] * (-1);
            inflate.setLayoutParams(layoutParams);
            final View findViewById = inflate.findViewById(a.g.shape_view);
            this.eAW = new AlphaAnimation(0.0f, 1.0f);
            this.eAW.setDuration(100L);
            this.ewp = (LottieAnimationView) inflate.findViewById(a.g.flowerAppear_lottieAnimationView);
            this.ewp.loop(false);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ewp.setAnimation("anim_shouhuhua.json");
            }
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.head_layout);
            TextView textView = (TextView) inflate.findViewById(a.g.name_textView);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.head_imageView);
            headImageView.setIsRound(true);
            headImageView.setAutoChangeStyle(false);
            headImageView.setDefaultBgResource(a.f.sdk_default_avatar);
            int screenHeight = ((int) (ScreenHelper.getScreenHeight(this.mTbPageContext.getPageActivity()) * 0.38200003f)) - this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
            ViewGroup.LayoutParams layoutParams2 = this.ewp.getLayoutParams();
            layoutParams2.height = screenHeight;
            layoutParams2.width = (int) ((screenHeight / 50.0f) * 75.0f);
            this.ewp.setLayoutParams(layoutParams2);
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = screenHeight - this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds140);
            this.ewp.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    f.this.ewp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.f.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (viewGroup != null) {
                                viewGroup.removeView(inflate);
                            }
                        }
                    }, 100L);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    onAnimationEnd(animator);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            int dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
            new ObjectAnimator();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", dimensionPixelSize * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout, "alpha", 0.0f, 1.0f);
            this.eAX = new AnimatorSet();
            this.eAX.playTogether(ofFloat, ofFloat2);
            this.eAX.setDuration(170L);
            this.eAX.setStartDelay(830L);
            new ObjectAnimator();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout, "translationY", dimensionPixelSize);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(linearLayout, "alpha", 1.0f, 0.0f);
            this.eAY = new AnimatorSet();
            this.eAY.playTogether(ofFloat3, ofFloat4);
            this.eAY.setDuration(210L);
            this.eAY.setStartDelay(3000L);
            if (str2 == null) {
                str2 = "";
            }
            textView.setText(str2);
            headImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str4, boolean z) {
                    if (viewGroup != null && !f.this.mTbPageContext.getPageActivity().isFinishing()) {
                        viewGroup.addView(inflate);
                        findViewById.startAnimation(f.this.eAW);
                        f.this.ewp.playAnimation();
                        f.this.eAX.start();
                        f.this.eAY.start();
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(a.g.desc_textView);
            ag bdb2 = l.bcZ().bdb();
            if (bdb2 != null && !TextUtils.isEmpty(bdb2.aao)) {
                textView2.setText(bdb2.aao);
            }
            headImageView.startLoad(str, 12, false);
        }
    }

    public void onDestory() {
        if (this.eAW != null) {
            this.eAW.cancel();
        }
        if (this.ewp != null) {
            this.ewp.cancelAnimation();
        }
        if (this.eAX != null) {
            this.eAX.cancel();
        }
        if (this.eAY != null) {
            this.eAY.cancel();
        }
    }

    private boolean bcT() {
        return this.mTbPageContext.getPageActivity().getRequestedOrientation() == 0;
    }
}
