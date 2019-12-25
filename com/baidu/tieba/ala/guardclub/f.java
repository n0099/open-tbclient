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
import com.baidu.live.data.ac;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes2.dex */
public class f {
    private LottieAnimationView eve;
    private AlphaAnimation ezL;
    private AnimatorSet ezM;
    private AnimatorSet ezN;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(ViewGroup viewGroup, com.baidu.tieba.ala.guardclub.model.c cVar, com.baidu.live.data.k kVar) {
        if (viewGroup != null && this.mTbPageContext != null && kVar != null && kVar.Wc != null) {
            String str = kVar.Wc.nickName;
            if (TextUtils.isEmpty(str)) {
                str = kVar.Wc.userName;
            }
            a(viewGroup, kVar.Wc.portrait, str);
        }
    }

    public void a(final ViewGroup viewGroup, String str, String str2) {
        if (viewGroup != null && this.mTbPageContext != null) {
            onDestory();
            if (bcy()) {
                String str3 = null;
                ac bcG = l.bcE().bcG();
                if (bcG != null && !TextUtils.isEmpty(bcG.aaa)) {
                    str3 = bcG.aaa;
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
            this.ezL = new AlphaAnimation(0.0f, 1.0f);
            this.ezL.setDuration(100L);
            this.eve = (LottieAnimationView) inflate.findViewById(a.g.flowerAppear_lottieAnimationView);
            this.eve.loop(false);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eve.setAnimation("anim_shouhuhua.json");
            }
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.head_layout);
            TextView textView = (TextView) inflate.findViewById(a.g.name_textView);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.head_imageView);
            headImageView.setIsRound(true);
            headImageView.setAutoChangeStyle(false);
            headImageView.setDefaultBgResource(a.f.sdk_default_avatar);
            int screenHeight = ((int) (ScreenHelper.getScreenHeight(this.mTbPageContext.getPageActivity()) * 0.38200003f)) - this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
            ViewGroup.LayoutParams layoutParams2 = this.eve.getLayoutParams();
            layoutParams2.height = screenHeight;
            layoutParams2.width = (int) ((screenHeight / 50.0f) * 75.0f);
            this.eve.setLayoutParams(layoutParams2);
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = screenHeight - this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds140);
            this.eve.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    f.this.eve.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.f.1.1
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
            this.ezM = new AnimatorSet();
            this.ezM.playTogether(ofFloat, ofFloat2);
            this.ezM.setDuration(170L);
            this.ezM.setStartDelay(830L);
            new ObjectAnimator();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout, "translationY", dimensionPixelSize);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(linearLayout, "alpha", 1.0f, 0.0f);
            this.ezN = new AnimatorSet();
            this.ezN.playTogether(ofFloat3, ofFloat4);
            this.ezN.setDuration(210L);
            this.ezN.setStartDelay(3000L);
            if (str2 == null) {
                str2 = "";
            }
            textView.setText(str2);
            headImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str4, boolean z) {
                    if (viewGroup != null && !f.this.mTbPageContext.getPageActivity().isFinishing()) {
                        viewGroup.addView(inflate);
                        findViewById.startAnimation(f.this.ezL);
                        f.this.eve.playAnimation();
                        f.this.ezM.start();
                        f.this.ezN.start();
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(a.g.desc_textView);
            ac bcG2 = l.bcE().bcG();
            if (bcG2 != null && !TextUtils.isEmpty(bcG2.aaa)) {
                textView2.setText(bcG2.aaa);
            }
            headImageView.startLoad(str, 12, false);
        }
    }

    public void onDestory() {
        if (this.ezL != null) {
            this.ezL.cancel();
        }
        if (this.eve != null) {
            this.eve.cancelAnimation();
        }
        if (this.ezM != null) {
            this.ezM.cancel();
        }
        if (this.ezN != null) {
            this.ezN.cancel();
        }
    }

    private boolean bcy() {
        return this.mTbPageContext.getPageActivity().getRequestedOrientation() == 0;
    }
}
