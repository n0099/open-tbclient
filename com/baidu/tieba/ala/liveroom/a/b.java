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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.o;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.e;
/* loaded from: classes2.dex */
public class b extends f implements e {
    private CommonWebLayout aBg;
    private View aBh;
    private int epA;
    private RoundRectRelativeLayout epy;
    private float epz;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout baV() {
        return this.aBg;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!bbb()) {
            baW();
        }
    }

    public void ar(String str, int i) {
        View findViewById;
        int baZ;
        int bba;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.epA = 80;
                    baZ = baX();
                    bba = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.epy.setCornerRadius(this.epz, this.epz, 0.0f, 0.0f);
                    break;
                case 1:
                    this.epA = 80;
                    baZ = baX();
                    bba = bfe();
                    this.epy.setCornerRadius(this.epz, this.epz, 0.0f, 0.0f);
                    break;
                case 2:
                    this.epA = 5;
                    baZ = baZ();
                    bba = bba();
                    this.epy.setCornerRadius(this.epz, 0.0f, 0.0f, this.epz);
                    break;
                default:
                    bba = 0;
                    baZ = 0;
                    break;
            }
            setWidth(baZ);
            setHeight(bba);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                S(this.epy);
            }
            vr();
            this.aBg.loadUrl(str);
        }
    }

    public void bN(int i) {
        int baZ;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.epA = 80;
                    baZ = baX();
                    i2 = bfe();
                    this.epy.setCornerRadius(this.epz, this.epz, 0.0f, 0.0f);
                    break;
                case 2:
                    this.epA = 5;
                    baZ = baZ();
                    i2 = bba();
                    this.epy.setCornerRadius(this.epz, 0.0f, 0.0f, this.epz);
                    break;
                default:
                    baZ = 0;
                    break;
            }
            update(baZ, i2);
            if (i == 2) {
                S(this.epy);
            }
        }
    }

    public void baW() {
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
                if (b.this.aBg != null) {
                    b.this.aBg.release();
                }
            }
        });
    }

    private void initView() {
        this.epz = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.epy = new RoundRectRelativeLayout(this.mActivity);
        l(this.epy);
        L(this.epy);
        setContentView(this.epy);
    }

    private void l(ViewGroup viewGroup) {
        this.aBg = new CommonWebLayout(this.mActivity);
        this.aBg.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.aBg.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dU(String str) {
                super.dU(str);
                if (b.this.aBh != null) {
                    b.this.aBh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cG(int i) {
                super.cG(i);
                if (i == 100 && b.this.aBh != null) {
                    b.this.aBh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dV(String str) {
                super.dV(str);
                if (b.this.aBh != null) {
                    b.this.aBh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (b.this.aBh != null) {
                    b.this.aBh.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.aBg, new ViewGroup.LayoutParams(-1, -1));
    }

    private void L(ViewGroup viewGroup) {
        this.aBh = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.aBh, layoutParams);
        this.aBh.setVisibility(8);
    }

    private int baX() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int baZ() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bfe() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - o.w(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bba() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void vr() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.epA) {
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

    private boolean bbb() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.epA) {
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
                    b.this.baW();
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

    @Override // com.baidu.live.view.web.e
    public void cH(int i) {
        dismiss();
        if (this.aBg != null) {
            this.aBg.release();
        }
    }

    private void S(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
