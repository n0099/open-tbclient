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
    private HeadImageView aAw;
    private LottieAnimationView fQF;
    private ImageView fQG;
    private View fQH;
    private TextView fQI;
    private View fQJ;
    private TextView fQK;
    private ImageView fQL;
    private TextView fQM;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void sX(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bIr();
            bIt();
            switch (i) {
                case 1:
                    this.fQG.setImageResource(a.f.icon_redpacket_charm_body_02);
                    this.aAw.setVisibility(0);
                    this.fQJ.setVisibility(8);
                    this.fQM.setVisibility(0);
                    return;
                case 2:
                    this.fQG.setImageResource(a.f.icon_redpacket_charm_body_02);
                    bIp();
                    return;
                case 3:
                    this.fQG.setImageResource(a.f.icon_redpacket_charm_body_01);
                    bIp();
                    bIq();
                    return;
                case 4:
                    this.fQG.setImageResource(a.f.icon_redpacket_charm_body_01);
                    this.aAw.setVisibility(8);
                    this.fQJ.setVisibility(0);
                    this.fQK.setVisibility(8);
                    this.fQL.setVisibility(0);
                    this.fQM.setVisibility(4);
                    bIq();
                    bIs();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.fQH.setVisibility(0);
            if (TextUtils.isEmpty(this.fQI.getText()) || !this.fQI.getText().equals(str)) {
                this.fQI.setText(str);
                Drawable background = this.fQH.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.fQH.setBackgroundDrawable(background);
                }
                Drawable background2 = this.fQI.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.fQI.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.fQH.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aAw.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.fQK.setText(str);
        this.fQM.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bIr();
        bIt();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.fQF = (LottieAnimationView) findViewById(a.g.lottie_redpacket_charm);
        this.fQG = (ImageView) findViewById(a.g.iv_redpacket_charm_body);
        this.fQH = findViewById(a.g.layout_badge);
        this.fQI = (TextView) findViewById(a.g.tv_badge);
        this.aAw = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fQJ = findViewById(a.g.layout_action);
        this.fQK = (TextView) findViewById(a.g.tv_countdown_action);
        this.fQL = (ImageView) findViewById(a.g.iv_process);
        this.fQM = (TextView) findViewById(a.g.tv_countdown_format);
        this.fQF.loop(true);
        this.fQF.setAnimation("sdk_redpacket_charm_coin.json");
        this.aAw.setIsRound(true);
        this.aAw.setAutoChangeStyle(false);
        this.aAw.setBorderColor(-4981);
        this.aAw.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aAw.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bIp() {
        this.aAw.setVisibility(8);
        this.fQJ.setVisibility(0);
        this.fQK.setVisibility(0);
        this.fQL.setVisibility(8);
        this.fQM.setVisibility(4);
    }

    private void bIq() {
        if (this.fQF != null) {
            this.fQF.setVisibility(0);
            this.fQF.playAnimation();
        }
    }

    private void bIr() {
        if (this.fQF != null) {
            this.fQF.cancelAnimation();
            this.fQF.setVisibility(4);
        }
    }

    private void bIs() {
        if (this.fQJ != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fQJ, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fQJ, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.fQJ.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bIt() {
        if (this.fQJ != null && (this.fQJ.getTag() instanceof Animator)) {
            ((Animator) this.fQJ.getTag()).cancel();
        }
    }
}
