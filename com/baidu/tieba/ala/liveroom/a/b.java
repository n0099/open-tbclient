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
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.f;
/* loaded from: classes4.dex */
public class b extends e implements f {
    private int bRA;
    private RoundRectRelativeLayout bue;
    private CommonWebLayout bug;
    private View buh;
    private float bui;
    private boolean hdC;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bug;
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!YV()) {
            YQ();
        }
    }

    public void aH(String str, int i) {
        View findViewById;
        int YT;
        int YU;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.bRA = 80;
                    YT = YR();
                    YU = (int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.7f);
                    this.bue.setCornerRadius(this.bui, this.bui, 0.0f, 0.0f);
                    break;
                case 1:
                    this.bRA = 80;
                    YT = YR();
                    YU = bZS();
                    this.bue.setCornerRadius(this.bui, this.bui, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bRA = 5;
                    YT = YT();
                    YU = YU();
                    this.bue.setCornerRadius(this.bui, 0.0f, 0.0f, this.bui);
                    break;
                default:
                    YU = 0;
                    YT = 0;
                    break;
            }
            setWidth(YT);
            setHeight(YU);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                ah(this.bue);
            }
            OD();
            this.bug.loadUrl(str);
        }
    }

    public void dX(int i) {
        int YT;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.bRA = 80;
                    YT = YR();
                    i2 = bZS();
                    this.bue.setCornerRadius(this.bui, this.bui, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bRA = 5;
                    YT = YT();
                    i2 = YU();
                    this.bue.setCornerRadius(this.bui, 0.0f, 0.0f, this.bui);
                    break;
                default:
                    YT = 0;
                    break;
            }
            update(YT, i2);
            if (i == 2) {
                ah(this.bue);
            }
        }
    }

    public void YQ() {
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
                if (b.this.bug != null) {
                    b.this.bug.release();
                }
            }
        });
    }

    private void initView() {
        this.bui = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bue = new RoundRectRelativeLayout(this.mActivity);
        n(this.bue);
        o(this.bue);
        setContentView(this.bue);
    }

    private void n(ViewGroup viewGroup) {
        this.bug = new CommonWebLayout(this.mActivity);
        this.bug.setBackgroundColor(this.mActivity.getResources().getColor(a.c.sdk_black_alpha85));
        this.bug.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void is(String str) {
                super.is(str);
                if (b.this.buh != null) {
                    b.this.buh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && b.this.buh != null) {
                    b.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void it(String str) {
                super.it(str);
                if (b.this.buh != null) {
                    b.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.buh != null) {
                    b.this.buh.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bug, new ViewGroup.LayoutParams(-1, -1));
    }

    private void o(ViewGroup viewGroup) {
        this.buh = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.buh, layoutParams);
        this.buh.setVisibility(8);
    }

    private int YR() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int YT() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bZS() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - o.w(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.d.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int YU() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void OD() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bRA) {
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

    private boolean YV() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hdC) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bRA) {
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
                    b.this.YQ();
                    b.this.hdC = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.hdC = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fr(int i) {
        dismiss();
        if (this.bug != null) {
            this.bug.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
