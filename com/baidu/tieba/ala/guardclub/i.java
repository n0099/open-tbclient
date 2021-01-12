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
import com.baidu.live.data.bi;
import com.baidu.live.data.x;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class i implements com.baidu.live.guardclub.k {
    private Activity context;
    private LottieAnimationView gQJ;
    private AlphaAnimation gWm;
    private AnimatorSet gWn;
    private AnimatorSet gWo;
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
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.baidu.live.guardclub.a aVar, x xVar) {
        if (viewGroup != null && this.context != null && xVar != null && xVar.aGd != null) {
            String str = xVar.aGd.nickName;
            if (TextUtils.isEmpty(str)) {
                str = xVar.aGd.userName;
            }
            a(viewGroup, layoutParams, xVar.aGd.portrait, str);
        }
    }

    public void a(final ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str, String str2) {
        if (viewGroup != null && this.context != null) {
            onDestory();
            if (bUY()) {
                String str3 = null;
                bi HF = com.baidu.live.guardclub.g.HD().HF();
                if (HF != null && !TextUtils.isEmpty(HF.aMk)) {
                    str3 = HF.aMk;
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
            this.gWm = new AlphaAnimation(0.0f, 1.0f);
            this.gWm.setDuration(100L);
            this.gQJ = (LottieAnimationView) inflate.findViewById(a.f.flowerAppear_lottieAnimationView);
            this.gQJ.loop(false);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gQJ.setAnimation("anim_shouhuhua.json");
            }
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.head_layout);
            TextView textView = (TextView) inflate.findViewById(a.f.name_textView);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.f.head_imageView);
            headImageView.setIsRound(true);
            headImageView.setAutoChangeStyle(false);
            headImageView.setDefaultBgResource(a.e.sdk_default_avatar);
            int screenHeight = ((int) (ScreenHelper.getScreenHeight(this.context) * 0.38200003f)) - this.context.getResources().getDimensionPixelSize(a.d.sdk_ds40);
            ViewGroup.LayoutParams layoutParams2 = this.gQJ.getLayoutParams();
            layoutParams2.height = screenHeight;
            layoutParams2.width = (int) ((screenHeight / 50.0f) * 75.0f);
            this.gQJ.setLayoutParams(layoutParams2);
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = screenHeight - this.context.getResources().getDimensionPixelSize(a.d.sdk_ds140);
            this.gQJ.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.gQJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.i.1.1
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
            this.gWn = new AnimatorSet();
            this.gWn.playTogether(ofFloat, ofFloat2);
            this.gWn.setDuration(170L);
            this.gWn.setStartDelay(830L);
            new ObjectAnimator();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout, "translationY", dimensionPixelSize);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(linearLayout, "alpha", 1.0f, 0.0f);
            this.gWo = new AnimatorSet();
            this.gWo.playTogether(ofFloat3, ofFloat4);
            this.gWo.setDuration(210L);
            this.gWo.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            if (str2 == null) {
                str2 = "";
            }
            textView.setText(str2);
            headImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str4, boolean z) {
                    if (viewGroup != null && !i.this.context.isFinishing()) {
                        viewGroup.addView(inflate);
                        findViewById.startAnimation(i.this.gWm);
                        i.this.gQJ.playAnimation();
                        i.this.gWn.start();
                        i.this.gWo.start();
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(a.f.desc_textView);
            bi HF2 = com.baidu.live.guardclub.g.HD().HF();
            if (HF2 != null && !TextUtils.isEmpty(HF2.aMk)) {
                textView2.setText(HF2.aMk);
            }
            headImageView.startLoad(str, 12, false);
        }
    }

    @Override // com.baidu.live.guardclub.k
    public void onDestory() {
        if (this.gWm != null) {
            this.gWm.cancel();
        }
        if (this.gQJ != null) {
            this.gQJ.cancelAnimation();
        }
        if (this.gWn != null) {
            this.gWn.cancel();
        }
        if (this.gWo != null) {
            this.gWo.cancel();
        }
    }

    private boolean bUY() {
        return this.context.getRequestedOrientation() == 0;
    }
}
