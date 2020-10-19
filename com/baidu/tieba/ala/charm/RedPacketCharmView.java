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
/* loaded from: classes4.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aEh;
    private a ggi;
    private LottieAnimationView ggj;
    private ImageView ggk;
    private View ggl;
    private TextView ggm;
    private View ggn;
    private TextView ggo;
    private ImageView ggp;
    private TextView ggq;
    private String mAvatar;
    private int mStyle;

    /* loaded from: classes4.dex */
    interface a {
        void tN(int i);
    }

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.ggi = aVar;
    }

    public int getStyle() {
        return this.mStyle;
    }

    public void tO(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bMj();
            bMl();
            switch (i) {
                case 1:
                    this.ggk.setImageResource(a.f.icon_redpacket_charm_body_02);
                    this.aEh.setVisibility(0);
                    this.ggn.setVisibility(8);
                    this.ggq.setVisibility(0);
                    break;
                case 2:
                    this.ggk.setImageResource(a.f.icon_redpacket_charm_body_02);
                    bMh();
                    break;
                case 3:
                    this.ggk.setImageResource(a.f.icon_redpacket_charm_body_01);
                    bMh();
                    bMi();
                    break;
                case 4:
                    this.ggk.setImageResource(a.f.icon_redpacket_charm_body_01);
                    this.aEh.setVisibility(8);
                    this.ggn.setVisibility(0);
                    this.ggo.setVisibility(8);
                    this.ggp.setVisibility(0);
                    this.ggq.setVisibility(4);
                    bMi();
                    bMk();
                    break;
            }
            if (this.ggi != null) {
                this.ggi.tN(this.mStyle);
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.ggl.setVisibility(0);
            if (TextUtils.isEmpty(this.ggm.getText()) || !this.ggm.getText().equals(str)) {
                this.ggm.setText(str);
                Drawable background = this.ggl.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.ggl.setBackgroundDrawable(background);
                }
                Drawable background2 = this.ggm.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.ggm.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.ggl.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aEh.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.ggo.setText(str);
        this.ggq.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bMj();
        bMl();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.ggj = (LottieAnimationView) findViewById(a.g.lottie_redpacket_charm);
        this.ggk = (ImageView) findViewById(a.g.iv_redpacket_charm_body);
        this.ggl = findViewById(a.g.layout_badge);
        this.ggm = (TextView) findViewById(a.g.tv_badge);
        this.aEh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ggn = findViewById(a.g.layout_action);
        this.ggo = (TextView) findViewById(a.g.tv_countdown_action);
        this.ggp = (ImageView) findViewById(a.g.iv_process);
        this.ggq = (TextView) findViewById(a.g.tv_countdown_format);
        this.ggj.loop(true);
        this.ggj.setAnimation("sdk_redpacket_charm_coin.json");
        this.aEh.setIsRound(true);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setBorderColor(-4981);
        this.aEh.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aEh.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bMh() {
        this.aEh.setVisibility(8);
        this.ggn.setVisibility(0);
        this.ggo.setVisibility(0);
        this.ggp.setVisibility(8);
        this.ggq.setVisibility(4);
    }

    private void bMi() {
        if (this.ggj != null) {
            this.ggj.setVisibility(0);
            this.ggj.playAnimation();
        }
    }

    private void bMj() {
        if (this.ggj != null) {
            this.ggj.cancelAnimation();
            this.ggj.setVisibility(4);
        }
    }

    private void bMk() {
        if (this.ggn != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ggn, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ggn, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.ggn.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bMl() {
        if (this.ggn != null && (this.ggn.getTag() instanceof Animator)) {
            ((Animator) this.ggn.getTag()).cancel();
        }
    }
}
