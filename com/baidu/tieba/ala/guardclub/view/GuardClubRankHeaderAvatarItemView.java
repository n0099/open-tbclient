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
/* loaded from: classes10.dex */
public class GuardClubRankHeaderAvatarItemView extends FrameLayout {
    private HeadImageView aBE;
    private TbImageView bOt;
    private LottieAnimationView gZf;
    private AnimatorSet gZg;
    private boolean gZh;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aBE != null) {
            this.aBE.startLoad(str, 12, false);
        }
        if (this.bOt != null) {
            this.bOt.startLoad(str2, 10, false);
        }
        this.gZh = z;
        if (z) {
            this.gZf.setVisibility(0);
            bVA();
            return;
        }
        bVB();
        this.gZf.setVisibility(8);
    }

    public void bVA() {
        if (this.gZh) {
            bVC();
            this.gZf.playAnimation();
            this.gZg.start();
        }
    }

    public void bVB() {
        if (this.gZf != null) {
            this.gZf.cancelAnimation();
        }
        if (this.gZg != null) {
            this.gZg.cancel();
        }
    }

    public void release() {
        if (this.aBE != null) {
            this.aBE.stopLoad();
        }
        if (this.bOt != null) {
            this.bOt.stopLoad();
        }
        bVB();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aBE = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bOt = (TbImageView) findViewById(a.f.iv_level);
        this.gZf = (LottieAnimationView) findViewById(a.f.lottie_live);
        this.aBE.setIsRound(true);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setDrawBorder(false);
        this.aBE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aBE.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bOt.setDefaultBgResource(a.c.sdk_transparent);
        this.bOt.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void bVC() {
        this.gZf.setAnimation("live_anim_guard_join.json");
        this.gZf.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aBE, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aBE, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.gZg = new AnimatorSet();
        this.gZg.setDuration(1000L);
        this.gZg.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gZg.play(ofFloat).with(ofFloat2);
    }
}
