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
/* loaded from: classes7.dex */
public class b extends f implements com.baidu.live.view.web.f {
    private float bjs;
    private CommonWebLayout buY;
    private View buZ;
    private RoundRectRelativeLayout fNQ;
    private int fNR;
    private boolean gkT;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout bHi() {
        return this.buY;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bHo()) {
            bHj();
        }
    }

    public void aD(String str, int i) {
        View findViewById;
        int bHm;
        int bHn;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.fNR = 80;
                    bHm = bHk();
                    bHn = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.fNQ.setCornerRadius(this.bjs, this.bjs, 0.0f, 0.0f);
                    break;
                case 1:
                    this.fNR = 80;
                    bHm = bHk();
                    bHn = bMJ();
                    this.fNQ.setCornerRadius(this.bjs, this.bjs, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fNR = 5;
                    bHm = bHm();
                    bHn = bHn();
                    this.fNQ.setCornerRadius(this.bjs, 0.0f, 0.0f, this.bjs);
                    break;
                default:
                    bHn = 0;
                    bHm = 0;
                    break;
            }
            setWidth(bHm);
            setHeight(bHn);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                aa((View) this.fNQ);
            }
            Kl();
            this.buY.loadUrl(str);
        }
    }

    public void dz(int i) {
        int bHm;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.fNR = 80;
                    bHm = bHk();
                    i2 = bMJ();
                    this.fNQ.setCornerRadius(this.bjs, this.bjs, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fNR = 5;
                    bHm = bHm();
                    i2 = bHn();
                    this.fNQ.setCornerRadius(this.bjs, 0.0f, 0.0f, this.bjs);
                    break;
                default:
                    bHm = 0;
                    break;
            }
            update(bHm, i2);
            if (i == 2) {
                aa((View) this.fNQ);
            }
        }
    }

    public void bHj() {
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
                if (b.this.buY != null) {
                    b.this.buY.release();
                }
            }
        });
    }

    private void initView() {
        this.bjs = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.fNQ = new RoundRectRelativeLayout(this.mActivity);
        y(this.fNQ);
        aa((ViewGroup) this.fNQ);
        setContentView(this.fNQ);
    }

    private void y(ViewGroup viewGroup) {
        this.buY = new CommonWebLayout(this.mActivity);
        this.buY.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.buY.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hs(String str) {
                super.hs(str);
                if (b.this.buZ != null) {
                    b.this.buZ.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fy(int i) {
                super.fy(i);
                if (i == 100 && b.this.buZ != null) {
                    b.this.buZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ht(String str) {
                super.ht(str);
                if (b.this.buZ != null) {
                    b.this.buZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.buZ != null) {
                    b.this.buZ.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.buY, new ViewGroup.LayoutParams(-1, -1));
    }

    private void aa(ViewGroup viewGroup) {
        this.buZ = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.buZ, layoutParams);
        this.buZ.setVisibility(8);
    }

    private int bHk() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int bHm() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bMJ() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - o.u(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bHn() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void Kl() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.fNR) {
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

    private boolean bHo() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gkT) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.fNR) {
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
                    b.this.bHj();
                    b.this.gkT = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gkT = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fA(int i) {
        dismiss();
        if (this.buY != null) {
            this.buY.release();
        }
    }

    private void aa(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
