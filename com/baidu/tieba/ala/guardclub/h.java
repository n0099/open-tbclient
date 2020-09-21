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
import com.baidu.live.data.ba;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class h implements com.baidu.live.guardclub.k {
    private Activity context;
    private LottieAnimationView fYL;
    private AlphaAnimation geg;
    private AnimatorSet geh;
    private AnimatorSet gei;
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
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.baidu.live.guardclub.a aVar, u uVar) {
        if (viewGroup != null && this.context != null && uVar != null && uVar.aFb != null) {
            String str = uVar.aFb.nickName;
            if (TextUtils.isEmpty(str)) {
                str = uVar.aFb.userName;
            }
            a(viewGroup, layoutParams, uVar.aFb.portrait, str);
        }
    }

    public void a(final ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str, String str2) {
        if (viewGroup != null && this.context != null) {
            onDestory();
            if (bLr()) {
                String str3 = null;
                ba IR = com.baidu.live.guardclub.g.IP().IR();
                if (IR != null && !TextUtils.isEmpty(IR.aKh)) {
                    str3 = IR.aKh;
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
            this.geg = new AlphaAnimation(0.0f, 1.0f);
            this.geg.setDuration(100L);
            this.fYL = (LottieAnimationView) inflate.findViewById(a.g.flowerAppear_lottieAnimationView);
            this.fYL.loop(false);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fYL.setAnimation("anim_shouhuhua.json");
            }
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.head_layout);
            TextView textView = (TextView) inflate.findViewById(a.g.name_textView);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.head_imageView);
            headImageView.setIsRound(true);
            headImageView.setAutoChangeStyle(false);
            headImageView.setDefaultBgResource(a.f.sdk_default_avatar);
            int screenHeight = ((int) (ScreenHelper.getScreenHeight(this.context) * 0.38200003f)) - this.context.getResources().getDimensionPixelSize(a.e.sdk_ds40);
            ViewGroup.LayoutParams layoutParams2 = this.fYL.getLayoutParams();
            layoutParams2.height = screenHeight;
            layoutParams2.width = (int) ((screenHeight / 50.0f) * 75.0f);
            this.fYL.setLayoutParams(layoutParams2);
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = screenHeight - this.context.getResources().getDimensionPixelSize(a.e.sdk_ds140);
            this.fYL.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.guardclub.h.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    h.this.fYL.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.h.1.1
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
            this.geh = new AnimatorSet();
            this.geh.playTogether(ofFloat, ofFloat2);
            this.geh.setDuration(170L);
            this.geh.setStartDelay(830L);
            new ObjectAnimator();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout, "translationY", dimensionPixelSize);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(linearLayout, "alpha", 1.0f, 0.0f);
            this.gei = new AnimatorSet();
            this.gei.playTogether(ofFloat3, ofFloat4);
            this.gei.setDuration(210L);
            this.gei.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            if (str2 == null) {
                str2 = "";
            }
            textView.setText(str2);
            headImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.guardclub.h.2
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str4, boolean z) {
                    if (viewGroup != null && !h.this.context.isFinishing()) {
                        viewGroup.addView(inflate);
                        findViewById.startAnimation(h.this.geg);
                        h.this.fYL.playAnimation();
                        h.this.geh.start();
                        h.this.gei.start();
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(a.g.desc_textView);
            ba IR2 = com.baidu.live.guardclub.g.IP().IR();
            if (IR2 != null && !TextUtils.isEmpty(IR2.aKh)) {
                textView2.setText(IR2.aKh);
            }
            headImageView.startLoad(str, 12, false);
        }
    }

    @Override // com.baidu.live.guardclub.k
    public void onDestory() {
        if (this.geg != null) {
            this.geg.cancel();
        }
        if (this.fYL != null) {
            this.fYL.cancelAnimation();
        }
        if (this.geh != null) {
            this.geh.cancel();
        }
        if (this.gei != null) {
            this.gei.cancel();
        }
    }

    private boolean bLr() {
        return this.context.getRequestedOrientation() == 0;
    }
}
