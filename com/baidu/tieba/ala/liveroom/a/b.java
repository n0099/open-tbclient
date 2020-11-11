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
    private int bOe;
    private RoundRectRelativeLayout bqG;
    private CommonWebLayout bqH;
    private View bqI;
    private float bqJ;
    private boolean gUG;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout WZ() {
        return this.bqH;
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Xf()) {
            Xa();
        }
    }

    public void aH(String str, int i) {
        View findViewById;
        int Xd;
        int Xe;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.bOe = 80;
                    Xd = Xb();
                    Xe = (int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.7f);
                    this.bqG.setCornerRadius(this.bqJ, this.bqJ, 0.0f, 0.0f);
                    break;
                case 1:
                    this.bOe = 80;
                    Xd = Xb();
                    Xe = bWO();
                    this.bqG.setCornerRadius(this.bqJ, this.bqJ, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bOe = 5;
                    Xd = Xd();
                    Xe = Xe();
                    this.bqG.setCornerRadius(this.bqJ, 0.0f, 0.0f, this.bqJ);
                    break;
                default:
                    Xe = 0;
                    Xd = 0;
                    break;
            }
            setWidth(Xd);
            setHeight(Xe);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                ah(this.bqG);
            }
            MR();
            this.bqH.loadUrl(str);
        }
    }

    public void dI(int i) {
        int Xd;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.bOe = 80;
                    Xd = Xb();
                    i2 = bWO();
                    this.bqG.setCornerRadius(this.bqJ, this.bqJ, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bOe = 5;
                    Xd = Xd();
                    i2 = Xe();
                    this.bqG.setCornerRadius(this.bqJ, 0.0f, 0.0f, this.bqJ);
                    break;
                default:
                    Xd = 0;
                    break;
            }
            update(Xd, i2);
            if (i == 2) {
                ah(this.bqG);
            }
        }
    }

    public void Xa() {
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
                if (b.this.bqH != null) {
                    b.this.bqH.release();
                }
            }
        });
    }

    private void initView() {
        this.bqJ = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bqG = new RoundRectRelativeLayout(this.mActivity);
        r(this.bqG);
        s(this.bqG);
        setContentView(this.bqG);
    }

    private void r(ViewGroup viewGroup) {
        this.bqH = new CommonWebLayout(this.mActivity);
        this.bqH.setBackgroundColor(this.mActivity.getResources().getColor(a.c.sdk_black_alpha85));
        this.bqH.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hU(String str) {
                super.hU(str);
                if (b.this.bqI != null) {
                    b.this.bqI.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fa(int i) {
                super.fa(i);
                if (i == 100 && b.this.bqI != null) {
                    b.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hV(String str) {
                super.hV(str);
                if (b.this.bqI != null) {
                    b.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.bqI != null) {
                    b.this.bqI.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bqH, new ViewGroup.LayoutParams(-1, -1));
    }

    private void s(ViewGroup viewGroup) {
        this.bqI = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bqI, layoutParams);
        this.bqI.setVisibility(8);
    }

    private int Xb() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int Xd() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bWO() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - o.x(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.d.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int Xe() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void MR() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bOe) {
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

    private boolean Xf() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gUG) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bOe) {
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
                    b.this.Xa();
                    b.this.gUG = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gUG = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eX(int i) {
        dismiss();
        if (this.bqH != null) {
            this.bqH.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
