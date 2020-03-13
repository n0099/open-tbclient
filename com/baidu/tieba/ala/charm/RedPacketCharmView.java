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
    private HeadImageView ahI;
    private TextView ewA;
    private View ewB;
    private TextView ewC;
    private ImageView ewD;
    private TextView ewE;
    private View ewz;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void oX(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    this.ahI.setVisibility(0);
                    this.ewB.setVisibility(8);
                    this.ewE.setVisibility(0);
                    bdX();
                    return;
                case 2:
                    this.ahI.setVisibility(8);
                    this.ewB.setVisibility(0);
                    this.ewC.setVisibility(0);
                    this.ewD.setVisibility(8);
                    this.ewE.setVisibility(4);
                    bdX();
                    return;
                case 3:
                    this.ahI.setVisibility(8);
                    this.ewB.setVisibility(0);
                    this.ewC.setVisibility(8);
                    this.ewD.setVisibility(0);
                    this.ewE.setVisibility(4);
                    bdW();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.ewz.setVisibility(0);
            if (TextUtils.isEmpty(this.ewA.getText()) || !this.ewA.getText().equals(str)) {
                this.ewA.setText(str);
                Drawable background = this.ewz.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.ewz.setBackgroundDrawable(background);
                }
                Drawable background2 = this.ewA.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.ewA.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.ewz.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.ahI.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.ewC.setText(str);
        this.ewE.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bdX();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.ewz = findViewById(a.g.layout_badge);
        this.ewA = (TextView) findViewById(a.g.tv_badge);
        this.ahI = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ewB = findViewById(a.g.layout_action);
        this.ewC = (TextView) findViewById(a.g.tv_countdown_action);
        this.ewD = (ImageView) findViewById(a.g.iv_process);
        this.ewE = (TextView) findViewById(a.g.tv_countdown_format);
        this.ahI.setIsRound(true);
        this.ahI.setAutoChangeStyle(false);
        this.ahI.setBorderColor(-4981);
        this.ahI.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.ahI.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bdW() {
        if (this.ewB != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ewB, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ewB, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.ewB.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bdX() {
        if (this.ewB != null && (this.ewB.getTag() instanceof Animator)) {
            ((Animator) this.ewB.getTag()).cancel();
        }
    }
}
