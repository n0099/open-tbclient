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
    private CommonWebLayout aGh;
    private View aGi;
    private boolean ePl;
    private RoundRectRelativeLayout evj;
    private float evk;
    private int evl;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout bdI() {
        return this.aGh;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bdO()) {
            bdJ();
        }
    }

    public void aq(String str, int i) {
        View findViewById;
        int bdM;
        int bdN;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.evl = 80;
                    bdM = bdK();
                    bdN = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.evj.setCornerRadius(this.evk, this.evk, 0.0f, 0.0f);
                    break;
                case 1:
                    this.evl = 80;
                    bdM = bdK();
                    bdN = bhO();
                    this.evj.setCornerRadius(this.evk, this.evk, 0.0f, 0.0f);
                    break;
                case 2:
                    this.evl = 5;
                    bdM = bdM();
                    bdN = bdN();
                    this.evj.setCornerRadius(this.evk, 0.0f, 0.0f, this.evk);
                    break;
                default:
                    bdN = 0;
                    bdM = 0;
                    break;
            }
            setWidth(bdM);
            setHeight(bdN);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                U(this.evj);
            }
            xG();
            this.aGh.loadUrl(str);
        }
    }

    public void bW(int i) {
        int bdM;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.evl = 80;
                    bdM = bdK();
                    i2 = bhO();
                    this.evj.setCornerRadius(this.evk, this.evk, 0.0f, 0.0f);
                    break;
                case 2:
                    this.evl = 5;
                    bdM = bdM();
                    i2 = bdN();
                    this.evj.setCornerRadius(this.evk, 0.0f, 0.0f, this.evk);
                    break;
                default:
                    bdM = 0;
                    break;
            }
            update(bdM, i2);
            if (i == 2) {
                U(this.evj);
            }
        }
    }

    public void bdJ() {
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
                if (b.this.aGh != null) {
                    b.this.aGh.release();
                }
            }
        });
    }

    private void initView() {
        this.evk = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.evj = new RoundRectRelativeLayout(this.mActivity);
        p(this.evj);
        Q(this.evj);
        setContentView(this.evj);
    }

    private void p(ViewGroup viewGroup) {
        this.aGh = new CommonWebLayout(this.mActivity);
        this.aGh.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.aGh.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void el(String str) {
                super.el(str);
                if (b.this.aGi != null) {
                    b.this.aGi.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cX(int i) {
                super.cX(i);
                if (i == 100 && b.this.aGi != null) {
                    b.this.aGi.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void em(String str) {
                super.em(str);
                if (b.this.aGi != null) {
                    b.this.aGi.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.aGi != null) {
                    b.this.aGi.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.aGh, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Q(ViewGroup viewGroup) {
        this.aGi = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.aGi, layoutParams);
        this.aGi.setVisibility(8);
    }

    private int bdK() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int bdM() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bhO() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - p.x(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bdN() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void xG() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.evl) {
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

    private boolean bdO() {
        if (getContentView() == null) {
            return false;
        }
        if (this.ePl) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.evl) {
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
                    b.this.bdJ();
                    b.this.ePl = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.ePl = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.e
    public void cY(int i) {
        dismiss();
        if (this.aGh != null) {
            this.aGh.release();
        }
    }

    private void U(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
