package com.baidu.tieba.ala.liveroom.r;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes4.dex */
public class d extends f implements com.baidu.live.view.web.f {
    private int bFz;
    private RoundRectRelativeLayout bnA;
    private CommonWebLayout bnB;
    private View bnC;
    private float bnD;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout Tz() {
        return this.bnB;
    }

    public void Fz(String str) {
        View findViewById;
        int TD;
        int TE;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.bFz = 80;
                    TD = TB();
                    TE = TC();
                    this.bnA.setCornerRadius(this.bnD, this.bnD, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bFz = 5;
                    TD = TD();
                    TE = TE();
                    this.bnA.setCornerRadius(this.bnD, 0.0f, 0.0f, this.bnD);
                    break;
                default:
                    this.bFz = 80;
                    TD = TB();
                    TE = TC();
                    this.bnA.setCornerRadius(this.bnD, this.bnD, 0.0f, 0.0f);
                    break;
            }
            setWidth(TD);
            setHeight(TE);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                ad(this.bnA);
            }
            LX();
            this.bnB.loadUrl(str);
        }
    }

    public void dI(int i) {
        int TE;
        int i2 = 0;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.bFz = 80;
                    i2 = TB();
                    TE = TC();
                    this.bnA.setCornerRadius(this.bnD, this.bnD, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bFz = 5;
                    i2 = TD();
                    TE = TE();
                    this.bnA.setCornerRadius(this.bnD, 0.0f, 0.0f, this.bnD);
                    break;
                default:
                    TE = 0;
                    break;
            }
            update(i2, TE);
            if (i == 2) {
                ad(this.bnA);
            }
        }
    }

    public void TA() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!TF()) {
            TA();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.r.d.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (d.this.bnB != null) {
                    d.this.bnB.release();
                }
            }
        });
    }

    private void initView() {
        this.bnD = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.bnA = new RoundRectRelativeLayout(this.mContext);
        q(this.bnA);
        r(this.bnA);
        setContentView(this.bnA);
    }

    private void q(ViewGroup viewGroup) {
        this.bnB = new CommonWebLayout(this.mContext);
        this.bnB.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.bnB.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.r.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hF(String str) {
                super.hF(str);
                if (d.this.bnC != null) {
                    d.this.bnC.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eX(int i) {
                super.eX(i);
                if (i == 100 && d.this.bnC != null) {
                    d.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hG(String str) {
                super.hG(str);
                if (d.this.bnC != null) {
                    d.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.bnC != null) {
                    d.this.bnC.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bnB, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bnC = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bnC, layoutParams);
        this.bnC.setVisibility(8);
    }

    private int TB() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int TC() {
        return (TB() * 470) / 375;
    }

    private int TD() {
        return (TE() * 375) / 470;
    }

    private int TE() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void LX() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bFz) {
                case 5:
                    translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    break;
                case 80:
                    translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                    break;
            }
            if (translateAnimation != null) {
                translateAnimation.setDuration(250L);
                translateAnimation.setInterpolator(new LinearInterpolator());
                getContentView().startAnimation(translateAnimation);
            }
        }
    }

    private boolean TF() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bFz) {
            case 5:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                break;
            case 80:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
                break;
        }
        if (translateAnimation != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.r.d.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.TA();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eU(int i) {
        dismiss();
    }

    private void ad(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
