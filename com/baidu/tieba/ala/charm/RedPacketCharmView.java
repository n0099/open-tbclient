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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView afA;
    private View esb;
    private TextView esc;
    private View esd;
    private TextView ese;
    private ImageView esf;
    private TextView esg;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void oG(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    this.afA.setVisibility(0);
                    this.esd.setVisibility(8);
                    this.esg.setVisibility(0);
                    bbF();
                    return;
                case 2:
                    this.afA.setVisibility(8);
                    this.esd.setVisibility(0);
                    this.ese.setVisibility(0);
                    this.esf.setVisibility(8);
                    this.esg.setVisibility(4);
                    bbF();
                    return;
                case 3:
                    this.afA.setVisibility(8);
                    this.esd.setVisibility(0);
                    this.ese.setVisibility(8);
                    this.esf.setVisibility(0);
                    this.esg.setVisibility(4);
                    bbE();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.esb.setVisibility(0);
            if (TextUtils.isEmpty(this.esc.getText()) || !this.esc.getText().equals(str)) {
                this.esc.setText(str);
                Drawable background = this.esb.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.esb.setBackgroundDrawable(background);
                }
                Drawable background2 = this.esc.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.esc.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.esb.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.afA.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.ese.setText(str);
        this.esg.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bbF();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.esb = findViewById(a.g.layout_badge);
        this.esc = (TextView) findViewById(a.g.tv_badge);
        this.afA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.esd = findViewById(a.g.layout_action);
        this.ese = (TextView) findViewById(a.g.tv_countdown_action);
        this.esf = (ImageView) findViewById(a.g.iv_process);
        this.esg = (TextView) findViewById(a.g.tv_countdown_format);
        this.afA.setIsRound(true);
        this.afA.setAutoChangeStyle(false);
        this.afA.setBorderColor(-4981);
        this.afA.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.afA.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bbE() {
        if (this.esd != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.esd, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.esd, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.esd.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bbF() {
        if (this.esd != null && (this.esd.getTag() instanceof Animator)) {
            ((Animator) this.esd.getTag()).cancel();
        }
    }
}
