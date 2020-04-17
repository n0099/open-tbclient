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
    private CommonWebLayout bcf;
    private View bcg;
    private RoundRectRelativeLayout eZa;
    private float eZb;
    private int eZc;
    private boolean fue;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout bmE() {
        return this.bcf;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bmK()) {
            bmF();
        }
    }

    public void aA(String str, int i) {
        View findViewById;
        int bmI;
        int bmJ;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.eZc = 80;
                    bmI = bmG();
                    bmJ = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.eZa.setCornerRadius(this.eZb, this.eZb, 0.0f, 0.0f);
                    break;
                case 1:
                    this.eZc = 80;
                    bmI = bmG();
                    bmJ = brm();
                    this.eZa.setCornerRadius(this.eZb, this.eZb, 0.0f, 0.0f);
                    break;
                case 2:
                    this.eZc = 5;
                    bmI = bmI();
                    bmJ = bmJ();
                    this.eZa.setCornerRadius(this.eZb, 0.0f, 0.0f, this.eZb);
                    break;
                default:
                    bmJ = 0;
                    bmI = 0;
                    break;
            }
            setWidth(bmI);
            setHeight(bmJ);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                W(this.eZa);
            }
            CB();
            this.bcf.loadUrl(str);
        }
    }

    public void cl(int i) {
        int bmI;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.eZc = 80;
                    bmI = bmG();
                    i2 = brm();
                    this.eZa.setCornerRadius(this.eZb, this.eZb, 0.0f, 0.0f);
                    break;
                case 2:
                    this.eZc = 5;
                    bmI = bmI();
                    i2 = bmJ();
                    this.eZa.setCornerRadius(this.eZb, 0.0f, 0.0f, this.eZb);
                    break;
                default:
                    bmI = 0;
                    break;
            }
            update(bmI, i2);
            if (i == 2) {
                W(this.eZa);
            }
        }
    }

    public void bmF() {
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
                if (b.this.bcf != null) {
                    b.this.bcf.release();
                }
            }
        });
    }

    private void initView() {
        this.eZb = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.eZa = new RoundRectRelativeLayout(this.mActivity);
        q(this.eZa);
        R(this.eZa);
        setContentView(this.eZa);
    }

    private void q(ViewGroup viewGroup) {
        this.bcf = new CommonWebLayout(this.mActivity);
        this.bcf.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.bcf.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fd(String str) {
                super.fd(str);
                if (b.this.bcg != null) {
                    b.this.bcg.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dm(int i) {
                super.dm(i);
                if (i == 100 && b.this.bcg != null) {
                    b.this.bcg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fe(String str) {
                super.fe(str);
                if (b.this.bcg != null) {
                    b.this.bcg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.bcg != null) {
                    b.this.bcg.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bcf, new ViewGroup.LayoutParams(-1, -1));
    }

    private void R(ViewGroup viewGroup) {
        this.bcg = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bcg, layoutParams);
        this.bcg.setVisibility(8);
    }

    private int bmG() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int bmI() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int brm() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - p.t(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bmJ() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void CB() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.eZc) {
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

    private boolean bmK() {
        if (getContentView() == null) {
            return false;
        }
        if (this.fue) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.eZc) {
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
                    b.this.bmF();
                    b.this.fue = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.fue = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    /* renamed from: do */
    public void mo22do(int i) {
        dismiss();
        if (this.bcf != null) {
            this.bcf.release();
        }
    }

    private void W(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
