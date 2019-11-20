package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.n;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.e;
/* loaded from: classes6.dex */
public class b extends PopupWindow implements e {
    private CommonWebLayout atm;
    private View atn;
    private RoundRectRelativeLayout dUk;
    private float dUl;
    private int dUm;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout aNC() {
        return this.atm;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!aNI()) {
            aND();
        }
    }

    public void ai(String str, int i) {
        View findViewById;
        int aNF;
        int aNH;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.dUm = 80;
                    aNF = aNE();
                    aNH = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.dUk.setCornerRadius(this.dUl, this.dUl, 0.0f, 0.0f);
                    break;
                case 1:
                    this.dUm = 80;
                    aNF = aNE();
                    aNH = aNG();
                    this.dUk.setCornerRadius(this.dUl, this.dUl, 0.0f, 0.0f);
                    break;
                case 2:
                    this.dUm = 5;
                    aNF = aNF();
                    aNH = aNH();
                    this.dUk.setCornerRadius(this.dUl, 0.0f, 0.0f, this.dUl);
                    break;
                default:
                    aNH = 0;
                    aNF = 0;
                    break;
            }
            setWidth(aNF);
            setHeight(aNH);
            showAtLocation(findViewById, 85, 0, 0);
            tx();
            this.atm.loadUrl(str);
        }
    }

    public void bw(int i) {
        int aNF;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.dUm = 80;
                    aNF = aNE();
                    i2 = aNG();
                    this.dUk.setCornerRadius(this.dUl, this.dUl, 0.0f, 0.0f);
                    break;
                case 2:
                    this.dUm = 5;
                    aNF = aNF();
                    i2 = aNH();
                    this.dUk.setCornerRadius(this.dUl, 0.0f, 0.0f, this.dUl);
                    break;
                default:
                    aNF = 0;
                    break;
            }
            update(aNF, i2);
        }
    }

    public void aND() {
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
                if (b.this.atm != null) {
                    b.this.atm.release();
                }
            }
        });
    }

    private void initView() {
        this.dUl = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.dUk = new RoundRectRelativeLayout(this.mActivity);
        aa(this.dUk);
        ab(this.dUk);
        setContentView(this.dUk);
    }

    private void aa(ViewGroup viewGroup) {
        this.atm = new CommonWebLayout(this.mActivity);
        this.atm.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.atm.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void da(String str) {
                super.da(str);
                if (b.this.atn != null) {
                    b.this.atn.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cr(int i) {
                super.cr(i);
                if (i == 100 && b.this.atn != null) {
                    b.this.atn.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void db(String str) {
                super.db(str);
                if (b.this.atn != null) {
                    b.this.atn.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (b.this.atn != null) {
                    b.this.atn.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.atm, new ViewGroup.LayoutParams(-1, -1));
    }

    private void ab(ViewGroup viewGroup) {
        this.atn = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.atn, layoutParams);
        this.atn.setVisibility(8);
    }

    private int aNE() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int aNF() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int aNG() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - n.t(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int aNH() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void tx() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.dUm) {
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

    private boolean aNI() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.dUm) {
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
                    b.this.aND();
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
    public void cs(int i) {
        dismiss();
        if (this.atm != null) {
            this.atm.release();
        }
    }
}
