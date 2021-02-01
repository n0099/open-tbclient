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
    private LottieAnimationView hbP;
    private AnimatorSet hbQ;
    private boolean hbR;

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
        this.hbR = z;
        if (z) {
            this.hbP.setVisibility(0);
            bWe();
            return;
        }
        bWf();
        this.hbP.setVisibility(8);
    }

    public void bWe() {
        if (this.hbR) {
            bWg();
            this.hbP.playAnimation();
            this.hbQ.start();
        }
    }

    public void bWf() {
        if (this.hbP != null) {
            this.hbP.cancelAnimation();
        }
        if (this.hbQ != null) {
            this.hbQ.cancel();
        }
    }

    public void release() {
        if (this.aDr != null) {
            this.aDr.stopLoad();
        }
        if (this.bSj != null) {
            this.bSj.stopLoad();
        }
        bWf();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bSj = (TbImageView) findViewById(a.f.iv_level);
        this.hbP = (LottieAnimationView) findViewById(a.f.lottie_live);
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setDrawBorder(false);
        this.aDr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aDr.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bSj.setDefaultBgResource(a.c.sdk_transparent);
        this.bSj.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void bWg() {
        this.hbP.setAnimation("live_anim_guard_join.json");
        this.hbP.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aDr, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aDr, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.hbQ = new AnimatorSet();
        this.hbQ.setDuration(1000L);
        this.hbQ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hbQ.play(ofFloat).with(ofFloat2);
    }
}
