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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ak;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes3.dex */
public class h implements com.baidu.live.guardclub.k {
    private Activity context;
    private LottieAnimationView ffH;
    private AlphaAnimation fku;
    private AnimatorSet fkv;
    private AnimatorSet fkw;
    private String otherParams;

    public h(Activity activity) {
        this.context = activity;
    }

    @Override // com.baidu.live.guardclub.k
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    @Override // com.baidu.live.guardclub.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.baidu.live.guardclub.a aVar, n nVar) {
        if (viewGroup != null && this.context != null && nVar != null && nVar.aqD != null) {
            String str = nVar.aqD.nickName;
            if (TextUtils.isEmpty(str)) {
                str = nVar.aqD.userName;
            }
            a(viewGroup, layoutParams, nVar.aqD.portrait, str);
        }
    }

    public void a(final ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str, String str2) {
        if (viewGroup != null && this.context != null) {
            onDestory();
            if (boF()) {
                String str3 = null;
                ak At = com.baidu.live.guardclub.g.Ar().At();
                if (At != null && !TextUtils.isEmpty(At.auV)) {
                    str3 = At.auV;
                }
                if (str3 == null) {
                    str3 = this.context.getString(a.i.guard_club_add_suc);
                }
                BdUtilHelper.getCustomToast().showToast(str3, 1);
                return;
            }
            final View inflate = LayoutInflater.from(this.context).inflate(a.h.view_guardclub_join_result, (ViewGroup) null);
            inflate.setLayoutParams(layoutParams);
            final View findViewById = inflate.findViewById(a.g.shape_view);
            this.fku = new AlphaAnimation(0.0f, 1.0f);
            this.fku.setDuration(100L);
            this.ffH = (LottieAnimationView) inflate.findViewById(a.g.flowerAppear_lottieAnimationView);
            this.ffH.loop(false);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ffH.setAnimation("anim_shouhuhua.json");
            }
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.head_layout);
            TextView textView = (TextView) inflate.findViewById(a.g.name_textView);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.head_imageView);
            headImageView.setIsRound(true);
            headImageView.setAutoChangeStyle(false);
            headImageView.setDefaultBgResource(a.f.sdk_default_avatar);
            int screenHeight = ((int) (ScreenHelper.getScreenHeight(this.context) * 0.38200003f)) - this.context.getResources().getDimensionPixelSize(a.e.sdk_ds40);
            ViewGroup.LayoutParams layoutParams2 = this.ffH.getLayoutParams();
            layoutParams2.height = screenHeight;
            layoutParams2.width = (int) ((screenHeight / 50.0f) * 75.0f);
            this.ffH.setLayoutParams(layoutParams2);
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = screenHeight - this.context.getResources().getDimensionPixelSize(a.e.sdk_ds140);
            this.ffH.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.guardclub.h.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    h.this.ffH.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.h.1.1
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
            int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            new ObjectAnimator();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", dimensionPixelSize * (-1));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout, "alpha", 0.0f, 1.0f);
            this.fkv = new AnimatorSet();
            this.fkv.playTogether(ofFloat, ofFloat2);
            this.fkv.setDuration(170L);
            this.fkv.setStartDelay(830L);
            new ObjectAnimator();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout, "translationY", dimensionPixelSize);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(linearLayout, "alpha", 1.0f, 0.0f);
            this.fkw = new AnimatorSet();
            this.fkw.playTogether(ofFloat3, ofFloat4);
            this.fkw.setDuration(210L);
            this.fkw.setStartDelay(3000L);
            if (str2 == null) {
                str2 = "";
            }
            textView.setText(str2);
            headImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.guardclub.h.2
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str4, boolean z) {
                    if (viewGroup != null && !h.this.context.isFinishing()) {
                        viewGroup.addView(inflate);
                        findViewById.startAnimation(h.this.fku);
                        h.this.ffH.playAnimation();
                        h.this.fkv.start();
                        h.this.fkw.start();
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(a.g.desc_textView);
            ak At2 = com.baidu.live.guardclub.g.Ar().At();
            if (At2 != null && !TextUtils.isEmpty(At2.auV)) {
                textView2.setText(At2.auV);
            }
            headImageView.startLoad(str, 12, false);
        }
    }

    @Override // com.baidu.live.guardclub.k
    public void onDestory() {
        if (this.fku != null) {
            this.fku.cancel();
        }
        if (this.ffH != null) {
            this.ffH.cancelAnimation();
        }
        if (this.fkv != null) {
            this.fkv.cancel();
        }
        if (this.fkw != null) {
            this.fkw.cancel();
        }
    }

    private boolean boF() {
        return this.context.getRequestedOrientation() == 0;
    }
}
