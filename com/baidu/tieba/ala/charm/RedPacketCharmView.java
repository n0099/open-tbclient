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
    private HeadImageView aDu;
    private a gvG;
    private LottieAnimationView gvH;
    private ImageView gvI;
    private View gvJ;
    private TextView gvK;
    private View gvL;
    private TextView gvM;
    private ImageView gvN;
    private TextView gvO;
    private String mAvatar;
    private int mStyle;

    /* loaded from: classes4.dex */
    interface a {
        void uO(int i);
    }

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gvG = aVar;
    }

    public int getStyle() {
        return this.mStyle;
    }

    public void uP(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bQE();
            bQG();
            switch (i) {
                case 1:
                    this.gvI.setImageResource(a.e.icon_redpacket_charm_body_02);
                    this.aDu.setVisibility(0);
                    this.gvL.setVisibility(8);
                    this.gvO.setVisibility(0);
                    break;
                case 2:
                    this.gvI.setImageResource(a.e.icon_redpacket_charm_body_02);
                    bQC();
                    break;
                case 3:
                    this.gvI.setImageResource(a.e.icon_redpacket_charm_body_01);
                    bQC();
                    bQD();
                    break;
                case 4:
                    this.gvI.setImageResource(a.e.icon_redpacket_charm_body_01);
                    this.aDu.setVisibility(8);
                    this.gvL.setVisibility(0);
                    this.gvM.setVisibility(8);
                    this.gvN.setVisibility(0);
                    this.gvO.setVisibility(4);
                    bQD();
                    bQF();
                    break;
            }
            if (this.gvG != null) {
                this.gvG.uO(this.mStyle);
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.gvJ.setVisibility(0);
            if (TextUtils.isEmpty(this.gvK.getText()) || !this.gvK.getText().equals(str)) {
                this.gvK.setText(str);
                Drawable background = this.gvJ.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.gvJ.setBackgroundDrawable(background);
                }
                Drawable background2 = this.gvK.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.gvK.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.gvJ.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aDu.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.gvM.setText(str);
        this.gvO.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bQE();
        bQG();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.red_packet_widget_charm, (ViewGroup) this, true);
        this.gvH = (LottieAnimationView) findViewById(a.f.lottie_redpacket_charm);
        this.gvI = (ImageView) findViewById(a.f.iv_redpacket_charm_body);
        this.gvJ = findViewById(a.f.layout_badge);
        this.gvK = (TextView) findViewById(a.f.tv_badge);
        this.aDu = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gvL = findViewById(a.f.layout_action);
        this.gvM = (TextView) findViewById(a.f.tv_countdown_action);
        this.gvN = (ImageView) findViewById(a.f.iv_process);
        this.gvO = (TextView) findViewById(a.f.tv_countdown_format);
        this.gvH.loop(true);
        this.gvH.setAnimation("sdk_redpacket_charm_coin.json");
        this.aDu.setIsRound(true);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setBorderColor(-4981);
        this.aDu.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aDu.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bQC() {
        this.aDu.setVisibility(8);
        this.gvL.setVisibility(0);
        this.gvM.setVisibility(0);
        this.gvN.setVisibility(8);
        this.gvO.setVisibility(4);
    }

    private void bQD() {
        if (this.gvH != null) {
            this.gvH.setVisibility(0);
            this.gvH.playAnimation();
        }
    }

    private void bQE() {
        if (this.gvH != null) {
            this.gvH.cancelAnimation();
            this.gvH.setVisibility(4);
        }
    }

    private void bQF() {
        if (this.gvL != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gvL, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gvL, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.gvL.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bQG() {
        if (this.gvL != null && (this.gvL.getTag() instanceof Animator)) {
            ((Animator) this.gvL.getTag()).cancel();
        }
    }
}
