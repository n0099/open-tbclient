package com.baidu.tieba.ala.guardclub;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.data.bn;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class i implements com.baidu.live.guardclub.k {
    private Activity context;
    private LottieAnimationView gTH;
    private AlphaAnimation gZk;
    private AnimatorSet gZl;
    private AnimatorSet gZm;
    private String otherParams;

    public i(Activity activity) {
        this.context = activity;
    }

    @Override // com.baidu.live.guardclub.k
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    @Override // com.baidu.live.guardclub.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.baidu.live.guardclub.a aVar, ab abVar) {
        if (viewGroup != null && this.context != null && abVar != null && abVar.aIz != null) {
            String str = abVar.aIz.nickName;
            if (TextUtils.isEmpty(str)) {
                str = abVar.aIz.userName;
            }
            a(viewGroup, layoutParams, abVar.aIz.portrait, str);
        }
    }

    public void a(final ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str, String str2) {
        if (viewGroup != null && this.context != null) {
            onDestory();
            if (bVK()) {
                String str3 = null;
                bn IV = com.baidu.live.guardclub.g.IT().IV();
                if (IV != null && !TextUtils.isEmpty(IV.aPi)) {
                    str3 = IV.aPi;
                }
                if (str3 == null) {
                    str3 = this.context.getString(a.h.guard_club_add_suc);
                }
                BdUtilHelper.getCustomToast().showToast(str3, 1);
                return;
            }
            final View inflate = LayoutInflater.from(this.context).inflate(a.g.view_guardclub_join_result, (ViewGroup) null);
            inflate.setLayoutParams(layoutParams);
            final View findViewById = inflate.findViewById(a.f.shape_view);
            this.gZk = new AlphaAnimation(0.0f, 1.0f);
            this.gZk.setDuration(100L);
            this.gTH = (LottieAnimationView) inflate.findViewById(a.f.flowerAppear_lottieAnimationView);
            this.gTH.loop(false);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gTH.setAnimation("anim_shouhuhua.json");
            }
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.head_layout);
            TextView textView = (TextView) inflate.findViewById(a.f.name_textView);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.f.head_imageView);
            headImageView.setIsRound(true);
            headImageView.setAutoChangeStyle(false);
            headImageView.setDefaultBgResource(a.e.sdk_default_avatar);
            int screenHeight = ((int) (ScreenHelper.getScreenHeight(this.context) * 0.38200003f)) - this.context.getResources().getDimensionPixelSize(a.d.sdk_ds40);
            ViewGroup.LayoutParams layoutParams2 = this.gTH.getLayoutParams();
            layoutParams2.height = screenHeight;
            layoutParams2.width = (int) ((screenHeight / 50.0f) * 75.0f);
            this.gTH.setLayoutParams(layoutParams2);
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = this.context.getResources().getDimensionPixelSize(a.d.sdk_ds340);
            this.gTH.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.gTH.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.i.1.1
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
            int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(a.d.sdk_ds28);
            new ObjectAnimator();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", dimensionPixelSize * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout, "alpha", 0.0f, 1.0f);
            this.gZl = new AnimatorSet();
            this.gZl.playTogether(ofFloat, ofFloat2);
            this.gZl.setDuration(170L);
            this.gZl.setStartDelay(830L);
            new ObjectAnimator();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout, "translationY", dimensionPixelSize);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(linearLayout, "alpha", 1.0f, 0.0f);
            this.gZm = new AnimatorSet();
            this.gZm.playTogether(ofFloat3, ofFloat4);
            this.gZm.setDuration(210L);
            this.gZm.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            if (str2 == null) {
                str2 = "";
            }
            textView.setText(str2);
            headImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str4, boolean z) {
                    if (viewGroup != null && !i.this.context.isFinishing()) {
                        viewGroup.addView(inflate);
                        findViewById.startAnimation(i.this.gZk);
                        i.this.gTH.playAnimation();
                        i.this.gZl.start();
                        i.this.gZm.start();
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(a.f.desc_textView);
            bn IV2 = com.baidu.live.guardclub.g.IT().IV();
            if (IV2 != null && !TextUtils.isEmpty(IV2.aPi)) {
                textView2.setText(IV2.aPi);
            }
            headImageView.startLoad(str, 12, false);
        }
    }

    @Override // com.baidu.live.guardclub.k
    public void onDestory() {
        if (this.gZk != null) {
            this.gZk.cancel();
        }
        if (this.gTH != null) {
            this.gTH.cancelAnimation();
        }
        if (this.gZl != null) {
            this.gZl.cancel();
        }
        if (this.gZm != null) {
            this.gZm.cancel();
        }
    }

    private boolean bVK() {
        return this.context.getRequestedOrientation() == 0;
    }
}
