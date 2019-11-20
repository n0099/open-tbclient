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
import com.baidu.live.data.z;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes6.dex */
public class f {
    private LottieAnimationView dGS;
    private AnimatorSet dLA;
    private AnimatorSet dLB;
    private AlphaAnimation dLz;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(ViewGroup viewGroup, com.baidu.tieba.ala.guardclub.model.c cVar, com.baidu.live.data.i iVar) {
        if (viewGroup != null && this.mTbPageContext != null && iVar != null && iVar.Pj != null) {
            String str = iVar.Pj.nickName;
            if (TextUtils.isEmpty(str)) {
                str = iVar.Pj.userName;
            }
            a(viewGroup, iVar.Pj.portrait, str);
        }
    }

    public void a(final ViewGroup viewGroup, String str, String str2) {
        if (viewGroup != null && this.mTbPageContext != null) {
            onDestory();
            final View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.view_guardclub_join_result, (ViewGroup) null);
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = iArr[1] * (-1);
            inflate.setLayoutParams(layoutParams);
            final View findViewById = inflate.findViewById(a.g.shape_view);
            this.dLz = new AlphaAnimation(0.0f, 1.0f);
            this.dLz.setDuration(100L);
            this.dGS = (LottieAnimationView) inflate.findViewById(a.g.flowerAppear_lottieAnimationView);
            this.dGS.loop(false);
            this.dGS.setAnimation("anim_shouhuhua.json");
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.head_layout);
            TextView textView = (TextView) inflate.findViewById(a.g.name_textView);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.head_imageView);
            headImageView.setIsRound(true);
            headImageView.setAutoChangeStyle(false);
            headImageView.setDefaultBgResource(a.f.sdk_default_avatar);
            int screenHeight = ((int) (ScreenHelper.getScreenHeight(this.mTbPageContext.getPageActivity()) * 0.38200003f)) - this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
            ViewGroup.LayoutParams layoutParams2 = this.dGS.getLayoutParams();
            layoutParams2.height = screenHeight;
            layoutParams2.width = (int) ((screenHeight / 50.0f) * 75.0f);
            this.dGS.setLayoutParams(layoutParams2);
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = screenHeight - this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds140);
            this.dGS.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    f.this.dGS.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.f.1.1
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
            this.dLA = new AnimatorSet();
            this.dLA.playTogether(ofFloat, ofFloat2);
            this.dLA.setDuration(170L);
            this.dLA.setStartDelay(830L);
            new ObjectAnimator();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout, "translationY", dimensionPixelSize);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(linearLayout, "alpha", 1.0f, 0.0f);
            this.dLB = new AnimatorSet();
            this.dLB.playTogether(ofFloat3, ofFloat4);
            this.dLB.setDuration(210L);
            this.dLB.setStartDelay(3000L);
            if (str2 == null) {
                str2 = "";
            }
            textView.setText(str2);
            headImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str3, boolean z) {
                    if (viewGroup != null && !f.this.mTbPageContext.getPageActivity().isFinishing()) {
                        viewGroup.addView(inflate);
                        findViewById.startAnimation(f.this.dLz);
                        f.this.dGS.playAnimation();
                        f.this.dLA.start();
                        f.this.dLB.start();
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(a.g.desc_textView);
            z aLx = m.aLv().aLx();
            if (aLx != null && !TextUtils.isEmpty(aLx.Tk)) {
                textView2.setText(aLx.Tk);
            }
            headImageView.startLoad(str, 12, false);
        }
    }

    public void onDestory() {
        if (this.dLz != null) {
            this.dLz.cancel();
        }
        if (this.dGS != null) {
            this.dGS.cancelAnimation();
        }
        if (this.dLA != null) {
            this.dLA.cancel();
        }
        if (this.dLB != null) {
            this.dLB.cancel();
        }
    }
}
