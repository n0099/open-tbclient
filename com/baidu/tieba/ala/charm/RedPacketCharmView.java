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
    private HeadImageView ahS;
    private View ewV;
    private TextView ewW;
    private View ewX;
    private TextView ewY;
    private ImageView ewZ;
    private TextView exa;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void oZ(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    this.ahS.setVisibility(0);
                    this.ewX.setVisibility(8);
                    this.exa.setVisibility(0);
                    bec();
                    return;
                case 2:
                    this.ahS.setVisibility(8);
                    this.ewX.setVisibility(0);
                    this.ewY.setVisibility(0);
                    this.ewZ.setVisibility(8);
                    this.exa.setVisibility(4);
                    bec();
                    return;
                case 3:
                    this.ahS.setVisibility(8);
                    this.ewX.setVisibility(0);
                    this.ewY.setVisibility(8);
                    this.ewZ.setVisibility(0);
                    this.exa.setVisibility(4);
                    beb();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.ewV.setVisibility(0);
            if (TextUtils.isEmpty(this.ewW.getText()) || !this.ewW.getText().equals(str)) {
                this.ewW.setText(str);
                Drawable background = this.ewV.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.ewV.setBackgroundDrawable(background);
                }
                Drawable background2 = this.ewW.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.ewW.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.ewV.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.ahS.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.ewY.setText(str);
        this.exa.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bec();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.ewV = findViewById(a.g.layout_badge);
        this.ewW = (TextView) findViewById(a.g.tv_badge);
        this.ahS = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ewX = findViewById(a.g.layout_action);
        this.ewY = (TextView) findViewById(a.g.tv_countdown_action);
        this.ewZ = (ImageView) findViewById(a.g.iv_process);
        this.exa = (TextView) findViewById(a.g.tv_countdown_format);
        this.ahS.setIsRound(true);
        this.ahS.setAutoChangeStyle(false);
        this.ahS.setBorderColor(-4981);
        this.ahS.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.ahS.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void beb() {
        if (this.ewX != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ewX, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ewX, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.ewX.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bec() {
        if (this.ewX != null && (this.ewX.getTag() instanceof Animator)) {
            ((Animator) this.ewX.getTag()).cancel();
        }
    }
}
