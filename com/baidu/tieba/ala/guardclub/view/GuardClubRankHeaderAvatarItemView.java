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
    private HeadImageView aGr;
    private TbImageView bTf;
    private LottieAnimationView hdL;
    private AnimatorSet hdM;
    private boolean hdN;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aGr != null) {
            this.aGr.startLoad(str, 12, false);
        }
        if (this.bTf != null) {
            this.bTf.startLoad(str2, 10, false);
        }
        this.hdN = z;
        if (z) {
            this.hdL.setVisibility(0);
            bZs();
            return;
        }
        bZt();
        this.hdL.setVisibility(8);
    }

    public void bZs() {
        if (this.hdN) {
            bZu();
            this.hdL.playAnimation();
            this.hdM.start();
        }
    }

    public void bZt() {
        if (this.hdL != null) {
            this.hdL.cancelAnimation();
        }
        if (this.hdM != null) {
            this.hdM.cancel();
        }
    }

    public void release() {
        if (this.aGr != null) {
            this.aGr.stopLoad();
        }
        if (this.bTf != null) {
            this.bTf.stopLoad();
        }
        bZt();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aGr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bTf = (TbImageView) findViewById(a.f.iv_level);
        this.hdL = (LottieAnimationView) findViewById(a.f.lottie_live);
        this.aGr.setIsRound(true);
        this.aGr.setAutoChangeStyle(false);
        this.aGr.setDrawBorder(false);
        this.aGr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aGr.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bTf.setDefaultBgResource(a.c.sdk_transparent);
        this.bTf.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void bZu() {
        this.hdL.setAnimation("live_anim_guard_join.json");
        this.hdL.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aGr, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aGr, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.hdM = new AnimatorSet();
        this.hdM.setDuration(1000L);
        this.hdM.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hdM.play(ofFloat).with(ofFloat2);
    }
}
