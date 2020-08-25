package com.baidu.tieba.ala.charm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes7.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aAu;
    private LottieAnimationView fQB;
    private ImageView fQC;
    private View fQD;
    private TextView fQE;
    private View fQF;
    private TextView fQG;
    private ImageView fQH;
    private TextView fQI;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void sX(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bIq();
            bIs();
            switch (i) {
                case 1:
                    this.fQC.setImageResource(a.f.icon_redpacket_charm_body_02);
                    this.aAu.setVisibility(0);
                    this.fQF.setVisibility(8);
                    this.fQI.setVisibility(0);
                    return;
                case 2:
                    this.fQC.setImageResource(a.f.icon_redpacket_charm_body_02);
                    bIo();
                    return;
                case 3:
                    this.fQC.setImageResource(a.f.icon_redpacket_charm_body_01);
                    bIo();
                    bIp();
                    return;
                case 4:
                    this.fQC.setImageResource(a.f.icon_redpacket_charm_body_01);
                    this.aAu.setVisibility(8);
                    this.fQF.setVisibility(0);
                    this.fQG.setVisibility(8);
                    this.fQH.setVisibility(0);
                    this.fQI.setVisibility(4);
                    bIp();
                    bIr();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.fQD.setVisibility(0);
            if (TextUtils.isEmpty(this.fQE.getText()) || !this.fQE.getText().equals(str)) {
                this.fQE.setText(str);
                Drawable background = this.fQD.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.fQD.setBackgroundDrawable(background);
                }
                Drawable background2 = this.fQE.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.fQE.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.fQD.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aAu.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.fQG.setText(str);
        this.fQI.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bIq();
        bIs();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.fQB = (LottieAnimationView) findViewById(a.g.lottie_redpacket_charm);
        this.fQC = (ImageView) findViewById(a.g.iv_redpacket_charm_body);
        this.fQD = findViewById(a.g.layout_badge);
        this.fQE = (TextView) findViewById(a.g.tv_badge);
        this.aAu = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fQF = findViewById(a.g.layout_action);
        this.fQG = (TextView) findViewById(a.g.tv_countdown_action);
        this.fQH = (ImageView) findViewById(a.g.iv_process);
        this.fQI = (TextView) findViewById(a.g.tv_countdown_format);
        this.fQB.loop(true);
        this.fQB.setAnimation("sdk_redpacket_charm_coin.json");
        this.aAu.setIsRound(true);
        this.aAu.setAutoChangeStyle(false);
        this.aAu.setBorderColor(-4981);
        this.aAu.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aAu.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bIo() {
        this.aAu.setVisibility(8);
        this.fQF.setVisibility(0);
        this.fQG.setVisibility(0);
        this.fQH.setVisibility(8);
        this.fQI.setVisibility(4);
    }

    private void bIp() {
        if (this.fQB != null) {
            this.fQB.setVisibility(0);
            this.fQB.playAnimation();
        }
    }

    private void bIq() {
        if (this.fQB != null) {
            this.fQB.cancelAnimation();
            this.fQB.setVisibility(4);
        }
    }

    private void bIr() {
        if (this.fQF != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fQF, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fQF, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.fQF.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bIs() {
        if (this.fQF != null && (this.fQF.getTag() instanceof Animator)) {
            ((Animator) this.fQF.getTag()).cancel();
        }
    }
}
