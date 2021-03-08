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
    private HeadImageView aER;
    private TbImageView bTJ;
    private LottieAnimationView hdM;
    private AnimatorSet hdN;
    private boolean hdO;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aER != null) {
            this.aER.startLoad(str, 12, false);
        }
        if (this.bTJ != null) {
            this.bTJ.startLoad(str2, 10, false);
        }
        this.hdO = z;
        if (z) {
            this.hdM.setVisibility(0);
            bWr();
            return;
        }
        bWs();
        this.hdM.setVisibility(8);
    }

    public void bWr() {
        if (this.hdO) {
            bWt();
            this.hdM.playAnimation();
            this.hdN.start();
        }
    }

    public void bWs() {
        if (this.hdM != null) {
            this.hdM.cancelAnimation();
        }
        if (this.hdN != null) {
            this.hdN.cancel();
        }
    }

    public void release() {
        if (this.aER != null) {
            this.aER.stopLoad();
        }
        if (this.bTJ != null) {
            this.bTJ.stopLoad();
        }
        bWs();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aER = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bTJ = (TbImageView) findViewById(a.f.iv_level);
        this.hdM = (LottieAnimationView) findViewById(a.f.lottie_live);
        this.aER.setIsRound(true);
        this.aER.setAutoChangeStyle(false);
        this.aER.setDrawBorder(false);
        this.aER.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aER.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bTJ.setDefaultBgResource(a.c.sdk_transparent);
        this.bTJ.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void bWt() {
        this.hdM.setAnimation("live_anim_guard_join.json");
        this.hdM.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aER, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aER, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.hdN = new AnimatorSet();
        this.hdN.setDuration(1000L);
        this.hdN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hdN.play(ofFloat).with(ofFloat2);
    }
}
