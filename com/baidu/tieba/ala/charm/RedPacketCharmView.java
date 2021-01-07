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
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aGr;
    private View bgg;
    private String eRJ;
    private a gQd;
    private LottieAnimationView gQe;
    private ImageView gQf;
    private View gQg;
    private TextView gQh;
    private TextView gQi;
    private ImageView gQj;
    private TextView gQk;
    private int mStyle;

    /* loaded from: classes11.dex */
    interface a {
        void vG(int i);
    }

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gQd = aVar;
    }

    public int getStyle() {
        return this.mStyle;
    }

    public void vH(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bWU();
            bWW();
            switch (i) {
                case 1:
                    this.gQf.setImageResource(a.e.icon_redpacket_charm_body_02);
                    this.aGr.setVisibility(0);
                    this.bgg.setVisibility(8);
                    this.gQk.setVisibility(0);
                    break;
                case 2:
                    this.gQf.setImageResource(a.e.icon_redpacket_charm_body_02);
                    bWS();
                    break;
                case 3:
                    this.gQf.setImageResource(a.e.icon_redpacket_charm_body_01);
                    bWS();
                    bWT();
                    break;
                case 4:
                    this.gQf.setImageResource(a.e.icon_redpacket_charm_body_01);
                    this.aGr.setVisibility(8);
                    this.bgg.setVisibility(0);
                    this.gQi.setVisibility(8);
                    this.gQj.setVisibility(0);
                    this.gQk.setVisibility(4);
                    bWT();
                    bWV();
                    break;
            }
            if (this.gQd != null) {
                this.gQd.vG(this.mStyle);
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.gQg.setVisibility(0);
            if (TextUtils.isEmpty(this.gQh.getText()) || !this.gQh.getText().equals(str)) {
                this.gQh.setText(str);
                Drawable background = this.gQg.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.gQg.setBackgroundDrawable(background);
                }
                Drawable background2 = this.gQh.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.gQh.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.gQg.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.eRJ) || !this.eRJ.equals(str)) {
            this.eRJ = str;
            this.aGr.startLoad(this.eRJ, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.gQi.setText(str);
        this.gQk.setText(str2);
    }

    public void release() {
        this.eRJ = "";
        bWU();
        bWW();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.red_packet_widget_charm, (ViewGroup) this, true);
        this.gQe = (LottieAnimationView) findViewById(a.f.lottie_redpacket_charm);
        this.gQf = (ImageView) findViewById(a.f.iv_redpacket_charm_body);
        this.gQg = findViewById(a.f.layout_badge);
        this.gQh = (TextView) findViewById(a.f.tv_badge);
        this.aGr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bgg = findViewById(a.f.layout_action);
        this.gQi = (TextView) findViewById(a.f.tv_countdown_action);
        this.gQj = (ImageView) findViewById(a.f.iv_process);
        this.gQk = (TextView) findViewById(a.f.tv_countdown_format);
        this.gQe.loop(true);
        this.gQe.setAnimation("sdk_redpacket_charm_coin.json");
        this.aGr.setIsRound(true);
        this.aGr.setAutoChangeStyle(false);
        this.aGr.setBorderColor(-4981);
        this.aGr.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aGr.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bWS() {
        this.aGr.setVisibility(8);
        this.bgg.setVisibility(0);
        this.gQi.setVisibility(0);
        this.gQj.setVisibility(8);
        this.gQk.setVisibility(4);
    }

    private void bWT() {
        if (this.gQe != null) {
            this.gQe.setVisibility(0);
            this.gQe.playAnimation();
        }
    }

    private void bWU() {
        if (this.gQe != null) {
            this.gQe.cancelAnimation();
            this.gQe.setVisibility(4);
        }
    }

    private void bWV() {
        if (this.bgg != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bgg, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bgg, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.bgg.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bWW() {
        if (this.bgg != null && (this.bgg.getTag() instanceof Animator)) {
            ((Animator) this.bgg.getTag()).cancel();
        }
    }
}
