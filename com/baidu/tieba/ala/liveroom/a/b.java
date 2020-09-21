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
    private RoundRectRelativeLayout bjN;
    private CommonWebLayout bjO;
    private View bjP;
    private float bjQ;
    private int byW;
    private boolean goa;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout RG() {
        return this.bjO;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!RM()) {
            RH();
        }
    }

    public void aD(String str, int i) {
        View findViewById;
        int RK;
        int RL;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.byW = 80;
                    RK = RI();
                    RL = (int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.7f);
                    this.bjN.setCornerRadius(this.bjQ, this.bjQ, 0.0f, 0.0f);
                    break;
                case 1:
                    this.byW = 80;
                    RK = RI();
                    RL = bNT();
                    this.bjN.setCornerRadius(this.bjQ, this.bjQ, 0.0f, 0.0f);
                    break;
                case 2:
                    this.byW = 5;
                    RK = RK();
                    RL = RL();
                    this.bjN.setCornerRadius(this.bjQ, 0.0f, 0.0f, this.bjQ);
                    break;
                default:
                    RL = 0;
                    RK = 0;
                    break;
            }
            setWidth(RK);
            setHeight(RL);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                ac(this.bjN);
            }
            KS();
            this.bjO.loadUrl(str);
        }
    }

    public void dD(int i) {
        int RK;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.byW = 80;
                    RK = RI();
                    i2 = bNT();
                    this.bjN.setCornerRadius(this.bjQ, this.bjQ, 0.0f, 0.0f);
                    break;
                case 2:
                    this.byW = 5;
                    RK = RK();
                    i2 = RL();
                    this.bjN.setCornerRadius(this.bjQ, 0.0f, 0.0f, this.bjQ);
                    break;
                default:
                    RK = 0;
                    break;
            }
            update(RK, i2);
            if (i == 2) {
                ac(this.bjN);
            }
        }
    }

    public void RH() {
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
                if (b.this.bjO != null) {
                    b.this.bjO.release();
                }
            }
        });
    }

    private void initView() {
        this.bjQ = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.bjN = new RoundRectRelativeLayout(this.mActivity);
        q(this.bjN);
        r(this.bjN);
        setContentView(this.bjN);
    }

    private void q(ViewGroup viewGroup) {
        this.bjO = new CommonWebLayout(this.mActivity);
        this.bjO.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.bjO.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ho(String str) {
                super.ho(str);
                if (b.this.bjP != null) {
                    b.this.bjP.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eO(int i) {
                super.eO(i);
                if (i == 100 && b.this.bjP != null) {
                    b.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hp(String str) {
                super.hp(str);
                if (b.this.bjP != null) {
                    b.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.bjP != null) {
                    b.this.bjP.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bjO, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bjP = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bjP, layoutParams);
        this.bjP.setVisibility(8);
    }

    private int RI() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int RK() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bNT() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - o.v(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int RL() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void KS() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.byW) {
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

    private boolean RM() {
        if (getContentView() == null) {
            return false;
        }
        if (this.goa) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.byW) {
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
                    b.this.RH();
                    b.this.goa = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.goa = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eL(int i) {
        dismiss();
        if (this.bjO != null) {
            this.bjO.release();
        }
    }

    private void ac(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
