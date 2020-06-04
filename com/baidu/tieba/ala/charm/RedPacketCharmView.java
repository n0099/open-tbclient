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
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aFL;
    private View foQ;
    private TextView foR;
    private View foS;
    private TextView foT;
    private ImageView foU;
    private TextView foV;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void pX(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    this.aFL.setVisibility(0);
                    this.foS.setVisibility(8);
                    this.foV.setVisibility(0);
                    btg();
                    return;
                case 2:
                    this.aFL.setVisibility(8);
                    this.foS.setVisibility(0);
                    this.foT.setVisibility(0);
                    this.foU.setVisibility(8);
                    this.foV.setVisibility(4);
                    btg();
                    return;
                case 3:
                    this.aFL.setVisibility(8);
                    this.foS.setVisibility(0);
                    this.foT.setVisibility(8);
                    this.foU.setVisibility(0);
                    this.foV.setVisibility(4);
                    btf();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.foQ.setVisibility(0);
            if (TextUtils.isEmpty(this.foR.getText()) || !this.foR.getText().equals(str)) {
                this.foR.setText(str);
                Drawable background = this.foQ.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.foQ.setBackgroundDrawable(background);
                }
                Drawable background2 = this.foR.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.foR.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.foQ.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aFL.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.foT.setText(str);
        this.foV.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        btg();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.foQ = findViewById(a.g.layout_badge);
        this.foR = (TextView) findViewById(a.g.tv_badge);
        this.aFL = (HeadImageView) findViewById(a.g.iv_avatar);
        this.foS = findViewById(a.g.layout_action);
        this.foT = (TextView) findViewById(a.g.tv_countdown_action);
        this.foU = (ImageView) findViewById(a.g.iv_process);
        this.foV = (TextView) findViewById(a.g.tv_countdown_format);
        this.aFL.setIsRound(true);
        this.aFL.setAutoChangeStyle(false);
        this.aFL.setBorderColor(-4981);
        this.aFL.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aFL.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void btf() {
        if (this.foS != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.foS, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.foS, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.foS.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void btg() {
        if (this.foS != null && (this.foS.getTag() instanceof Animator)) {
            ((Animator) this.foS.getTag()).cancel();
        }
    }
}
