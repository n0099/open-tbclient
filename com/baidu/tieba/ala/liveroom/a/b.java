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
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.p;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.e;
/* loaded from: classes3.dex */
public class b extends f implements e {
    private CommonWebLayout aGv;
    private View aGw;
    private boolean ePJ;
    private RoundRectRelativeLayout evF;
    private float evG;
    private int evH;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout bdN() {
        return this.aGv;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bdT()) {
            bdO();
        }
    }

    public void aq(String str, int i) {
        View findViewById;
        int bdR;
        int bdS;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.evH = 80;
                    bdR = bdP();
                    bdS = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.evF.setCornerRadius(this.evG, this.evG, 0.0f, 0.0f);
                    break;
                case 1:
                    this.evH = 80;
                    bdR = bdP();
                    bdS = bhT();
                    this.evF.setCornerRadius(this.evG, this.evG, 0.0f, 0.0f);
                    break;
                case 2:
                    this.evH = 5;
                    bdR = bdR();
                    bdS = bdS();
                    this.evF.setCornerRadius(this.evG, 0.0f, 0.0f, this.evG);
                    break;
                default:
                    bdS = 0;
                    bdR = 0;
                    break;
            }
            setWidth(bdR);
            setHeight(bdS);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                U(this.evF);
            }
            xL();
            this.aGv.loadUrl(str);
        }
    }

    public void bW(int i) {
        int bdR;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.evH = 80;
                    bdR = bdP();
                    i2 = bhT();
                    this.evF.setCornerRadius(this.evG, this.evG, 0.0f, 0.0f);
                    break;
                case 2:
                    this.evH = 5;
                    bdR = bdR();
                    i2 = bdS();
                    this.evF.setCornerRadius(this.evG, 0.0f, 0.0f, this.evG);
                    break;
                default:
                    bdR = 0;
                    break;
            }
            update(bdR, i2);
            if (i == 2) {
                U(this.evF);
            }
        }
    }

    public void bdO() {
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
                if (b.this.aGv != null) {
                    b.this.aGv.release();
                }
            }
        });
    }

    private void initView() {
        this.evG = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.evF = new RoundRectRelativeLayout(this.mActivity);
        p(this.evF);
        Q(this.evF);
        setContentView(this.evF);
    }

    private void p(ViewGroup viewGroup) {
        this.aGv = new CommonWebLayout(this.mActivity);
        this.aGv.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.aGv.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ek(String str) {
                super.ek(str);
                if (b.this.aGw != null) {
                    b.this.aGw.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cX(int i) {
                super.cX(i);
                if (i == 100 && b.this.aGw != null) {
                    b.this.aGw.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void el(String str) {
                super.el(str);
                if (b.this.aGw != null) {
                    b.this.aGw.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.aGw != null) {
                    b.this.aGw.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.aGv, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Q(ViewGroup viewGroup) {
        this.aGw = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.aGw, layoutParams);
        this.aGw.setVisibility(8);
    }

    private int bdP() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int bdR() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bhT() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - p.x(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bdS() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void xL() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.evH) {
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

    private boolean bdT() {
        if (getContentView() == null) {
            return false;
        }
        if (this.ePJ) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.evH) {
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
                    b.this.bdO();
                    b.this.ePJ = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.ePJ = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.e
    public void cY(int i) {
        dismiss();
        if (this.aGv != null) {
            this.aGv.release();
        }
    }

    private void U(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
