package com.baidu.tieba.ala.guardclub.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class GuardClubRankHeaderAvatarItemView extends FrameLayout {
    private HeadImageView aDr;
    private TbImageView bSj;
    private LottieAnimationView hcd;
    private AnimatorSet hce;
    private boolean hcf;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aDr != null) {
            this.aDr.startLoad(str, 12, false);
        }
        if (this.bSj != null) {
            this.bSj.startLoad(str2, 10, false);
        }
        this.hcf = z;
        if (z) {
            this.hcd.setVisibility(0);
            bWl();
            return;
        }
        bWm();
        this.hcd.setVisibility(8);
    }

    public void bWl() {
        if (this.hcf) {
            bWn();
            this.hcd.playAnimation();
            this.hce.start();
        }
    }

    public void bWm() {
        if (this.hcd != null) {
            this.hcd.cancelAnimation();
        }
        if (this.hce != null) {
            this.hce.cancel();
        }
    }

    public void release() {
        if (this.aDr != null) {
            this.aDr.stopLoad();
        }
        if (this.bSj != null) {
            this.bSj.stopLoad();
        }
        bWm();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bSj = (TbImageView) findViewById(a.f.iv_level);
        this.hcd = (LottieAnimationView) findViewById(a.f.lottie_live);
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setDrawBorder(false);
        this.aDr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aDr.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bSj.setDefaultBgResource(a.c.sdk_transparent);
        this.bSj.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void bWn() {
        this.hcd.setAnimation("live_anim_guard_join.json");
        this.hcd.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aDr, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aDr, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.hce = new AnimatorSet();
        this.hce.setDuration(1000L);
        this.hce.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hce.play(ofFloat).with(ofFloat2);
    }
}
