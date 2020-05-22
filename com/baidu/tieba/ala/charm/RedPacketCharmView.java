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
    private View foF;
    private TextView foG;
    private View foH;
    private TextView foI;
    private ImageView foJ;
    private TextView foK;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void pV(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    this.aFL.setVisibility(0);
                    this.foH.setVisibility(8);
                    this.foK.setVisibility(0);
                    bte();
                    return;
                case 2:
                    this.aFL.setVisibility(8);
                    this.foH.setVisibility(0);
                    this.foI.setVisibility(0);
                    this.foJ.setVisibility(8);
                    this.foK.setVisibility(4);
                    bte();
                    return;
                case 3:
                    this.aFL.setVisibility(8);
                    this.foH.setVisibility(0);
                    this.foI.setVisibility(8);
                    this.foJ.setVisibility(0);
                    this.foK.setVisibility(4);
                    btd();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.foF.setVisibility(0);
            if (TextUtils.isEmpty(this.foG.getText()) || !this.foG.getText().equals(str)) {
                this.foG.setText(str);
                Drawable background = this.foF.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.foF.setBackgroundDrawable(background);
                }
                Drawable background2 = this.foG.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.foG.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.foF.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aFL.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.foI.setText(str);
        this.foK.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bte();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.foF = findViewById(a.g.layout_badge);
        this.foG = (TextView) findViewById(a.g.tv_badge);
        this.aFL = (HeadImageView) findViewById(a.g.iv_avatar);
        this.foH = findViewById(a.g.layout_action);
        this.foI = (TextView) findViewById(a.g.tv_countdown_action);
        this.foJ = (ImageView) findViewById(a.g.iv_process);
        this.foK = (TextView) findViewById(a.g.tv_countdown_format);
        this.aFL.setIsRound(true);
        this.aFL.setAutoChangeStyle(false);
        this.aFL.setBorderColor(-4981);
        this.aFL.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aFL.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void btd() {
        if (this.foH != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.foH, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.foH, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.foH.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bte() {
        if (this.foH != null && (this.foH.getTag() instanceof Animator)) {
            ((Animator) this.foH.getTag()).cancel();
        }
    }
}
