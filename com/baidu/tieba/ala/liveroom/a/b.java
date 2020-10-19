package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
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
import com.baidu.live.utils.o;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes4.dex */
public class b extends f implements com.baidu.live.view.web.f {
    private int bFz;
    private RoundRectRelativeLayout bnA;
    private CommonWebLayout bnB;
    private View bnC;
    private float bnD;
    private boolean gCt;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout Tz() {
        return this.bnB;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!TF()) {
            TA();
        }
    }

    public void aE(String str, int i) {
        View findViewById;
        int TD;
        int TE;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.bFz = 80;
                    TD = TB();
                    TE = (int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.7f);
                    this.bnA.setCornerRadius(this.bnD, this.bnD, 0.0f, 0.0f);
                    break;
                case 1:
                    this.bFz = 80;
                    TD = TB();
                    TE = bRk();
                    this.bnA.setCornerRadius(this.bnD, this.bnD, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bFz = 5;
                    TD = TD();
                    TE = TE();
                    this.bnA.setCornerRadius(this.bnD, 0.0f, 0.0f, this.bnD);
                    break;
                default:
                    TE = 0;
                    TD = 0;
                    break;
            }
            setWidth(TD);
            setHeight(TE);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                ad(this.bnA);
            }
            LX();
            this.bnB.loadUrl(str);
        }
    }

    public void dI(int i) {
        int TD;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.bFz = 80;
                    TD = TB();
                    i2 = bRk();
                    this.bnA.setCornerRadius(this.bnD, this.bnD, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bFz = 5;
                    TD = TD();
                    i2 = TE();
                    this.bnA.setCornerRadius(this.bnD, 0.0f, 0.0f, this.bnD);
                    break;
                default:
                    TD = 0;
                    break;
            }
            update(TD, i2);
            if (i == 2) {
                ad(this.bnA);
            }
        }
    }

    public void TA() {
        super.dismiss();
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.a.b.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (b.this.bnB != null) {
                    b.this.bnB.release();
                }
            }
        });
    }

    private void initView() {
        this.bnD = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.bnA = new RoundRectRelativeLayout(this.mActivity);
        q(this.bnA);
        r(this.bnA);
        setContentView(this.bnA);
    }

    private void q(ViewGroup viewGroup) {
        this.bnB = new CommonWebLayout(this.mActivity);
        this.bnB.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.bnB.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hF(String str) {
                super.hF(str);
                if (b.this.bnC != null) {
                    b.this.bnC.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eX(int i) {
                super.eX(i);
                if (i == 100 && b.this.bnC != null) {
                    b.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hG(String str) {
                super.hG(str);
                if (b.this.bnC != null) {
                    b.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.bnC != null) {
                    b.this.bnC.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bnB, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bnC = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bnC, layoutParams);
        this.bnC.setVisibility(8);
    }

    private int TB() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int TD() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bRk() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - o.w(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int TE() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
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
        if (this.gCt) {
            return true;
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.a.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.TA();
                    b.this.gCt = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gCt = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eU(int i) {
        dismiss();
        if (this.bnB != null) {
            this.bnB.release();
        }
    }

    private void ad(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
