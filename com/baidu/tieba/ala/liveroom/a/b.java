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
    private CommonWebLayout atE;
    private View atF;
    private RoundRectRelativeLayout dVb;
    private float dVc;
    private int dVd;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout aNE() {
        return this.atE;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!aNK()) {
            aNF();
        }
    }

    public void ai(String str, int i) {
        View findViewById;
        int aNH;
        int aNJ;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.dVd = 80;
                    aNH = aNG();
                    aNJ = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.dVb.setCornerRadius(this.dVc, this.dVc, 0.0f, 0.0f);
                    break;
                case 1:
                    this.dVd = 80;
                    aNH = aNG();
                    aNJ = aNI();
                    this.dVb.setCornerRadius(this.dVc, this.dVc, 0.0f, 0.0f);
                    break;
                case 2:
                    this.dVd = 5;
                    aNH = aNH();
                    aNJ = aNJ();
                    this.dVb.setCornerRadius(this.dVc, 0.0f, 0.0f, this.dVc);
                    break;
                default:
                    aNJ = 0;
                    aNH = 0;
                    break;
            }
            setWidth(aNH);
            setHeight(aNJ);
            showAtLocation(findViewById, 85, 0, 0);
            tw();
            this.atE.loadUrl(str);
        }
    }

    public void bw(int i) {
        int aNH;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.dVd = 80;
                    aNH = aNG();
                    i2 = aNI();
                    this.dVb.setCornerRadius(this.dVc, this.dVc, 0.0f, 0.0f);
                    break;
                case 2:
                    this.dVd = 5;
                    aNH = aNH();
                    i2 = aNJ();
                    this.dVb.setCornerRadius(this.dVc, 0.0f, 0.0f, this.dVc);
                    break;
                default:
                    aNH = 0;
                    break;
            }
            update(aNH, i2);
        }
    }

    public void aNF() {
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
                if (b.this.atE != null) {
                    b.this.atE.release();
                }
            }
        });
    }

    private void initView() {
        this.dVc = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.dVb = new RoundRectRelativeLayout(this.mActivity);
        aa(this.dVb);
        ab(this.dVb);
        setContentView(this.dVb);
    }

    private void aa(ViewGroup viewGroup) {
        this.atE = new CommonWebLayout(this.mActivity);
        this.atE.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.atE.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void da(String str) {
                super.da(str);
                if (b.this.atF != null) {
                    b.this.atF.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cr(int i) {
                super.cr(i);
                if (i == 100 && b.this.atF != null) {
                    b.this.atF.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void db(String str) {
                super.db(str);
                if (b.this.atF != null) {
                    b.this.atF.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (b.this.atF != null) {
                    b.this.atF.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.atE, new ViewGroup.LayoutParams(-1, -1));
    }

    private void ab(ViewGroup viewGroup) {
        this.atF = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.atF, layoutParams);
        this.atF.setVisibility(8);
    }

    private int aNG() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int aNH() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int aNI() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - n.t(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int aNJ() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void tw() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.dVd) {
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

    private boolean aNK() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.dVd) {
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
                    b.this.aNF();
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
        if (this.atE != null) {
            this.atE.release();
        }
    }
}
