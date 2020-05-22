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
/* loaded from: classes3.dex */
public class b extends f implements com.baidu.live.view.web.f {
    private CommonWebLayout bjK;
    private View bjL;
    private boolean fIf;
    private RoundRectRelativeLayout flP;
    private float flQ;
    private int flR;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout bsa() {
        return this.bjK;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bsg()) {
            bsb();
        }
    }

    public void aB(String str, int i) {
        View findViewById;
        int bse;
        int bsf;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.flR = 80;
                    bse = bsc();
                    bsf = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.flP.setCornerRadius(this.flQ, this.flQ, 0.0f, 0.0f);
                    break;
                case 1:
                    this.flR = 80;
                    bse = bsc();
                    bsf = bxd();
                    this.flP.setCornerRadius(this.flQ, this.flQ, 0.0f, 0.0f);
                    break;
                case 2:
                    this.flR = 5;
                    bse = bse();
                    bsf = bsf();
                    this.flP.setCornerRadius(this.flQ, 0.0f, 0.0f, this.flQ);
                    break;
                default:
                    bsf = 0;
                    bse = 0;
                    break;
            }
            setWidth(bse);
            setHeight(bsf);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                V(this.flP);
            }
            DX();
            this.bjK.loadUrl(str);
        }
    }

    public void cs(int i) {
        int bse;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.flR = 80;
                    bse = bsc();
                    i2 = bxd();
                    this.flP.setCornerRadius(this.flQ, this.flQ, 0.0f, 0.0f);
                    break;
                case 2:
                    this.flR = 5;
                    bse = bse();
                    i2 = bsf();
                    this.flP.setCornerRadius(this.flQ, 0.0f, 0.0f, this.flQ);
                    break;
                default:
                    bse = 0;
                    break;
            }
            update(bse, i2);
            if (i == 2) {
                V(this.flP);
            }
        }
    }

    public void bsb() {
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
                if (b.this.bjK != null) {
                    b.this.bjK.release();
                }
            }
        });
    }

    private void initView() {
        this.flQ = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.flP = new RoundRectRelativeLayout(this.mActivity);
        u(this.flP);
        W(this.flP);
        setContentView(this.flP);
    }

    private void u(ViewGroup viewGroup) {
        this.bjK = new CommonWebLayout(this.mActivity);
        this.bjK.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.bjK.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fP(String str) {
                super.fP(str);
                if (b.this.bjL != null) {
                    b.this.bjL.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dr(int i) {
                super.dr(i);
                if (i == 100 && b.this.bjL != null) {
                    b.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fQ(String str) {
                super.fQ(str);
                if (b.this.bjL != null) {
                    b.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.bjL != null) {
                    b.this.bjL.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bjK, new ViewGroup.LayoutParams(-1, -1));
    }

    private void W(ViewGroup viewGroup) {
        this.bjL = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bjL, layoutParams);
        this.bjL.setVisibility(8);
    }

    private int bsc() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int bse() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bxd() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - p.t(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bsf() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void DX() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.flR) {
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

    private boolean bsg() {
        if (getContentView() == null) {
            return false;
        }
        if (this.fIf) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.flR) {
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
                    b.this.bsb();
                    b.this.fIf = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.fIf = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void dt(int i) {
        dismiss();
        if (this.bjK != null) {
            this.bjK.release();
        }
    }

    private void V(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
