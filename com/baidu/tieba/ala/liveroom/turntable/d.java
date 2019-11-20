package com.baidu.tieba.ala.liveroom.turntable;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes6.dex */
public class d extends PopupWindow implements com.baidu.live.view.web.e {
    private CommonWebLayout atm;
    private View atn;
    private RoundRectRelativeLayout dUk;
    private float dUl;
    private int dUm;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout aNC() {
        return this.atm;
    }

    public void tD(String str) {
        View findViewById;
        int aNF;
        int aNH;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.dUm = 80;
                    aNF = aNE();
                    aNH = aWf();
                    this.dUk.setCornerRadius(this.dUl, this.dUl, 0.0f, 0.0f);
                    break;
                case 2:
                    this.dUm = 5;
                    aNF = aNF();
                    aNH = aNH();
                    this.dUk.setCornerRadius(this.dUl, 0.0f, 0.0f, this.dUl);
                    break;
                default:
                    this.dUm = 80;
                    aNF = aNE();
                    aNH = aWf();
                    this.dUk.setCornerRadius(this.dUl, this.dUl, 0.0f, 0.0f);
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
        int aNH;
        int i2 = 0;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.dUm = 80;
                    i2 = aNE();
                    aNH = aWf();
                    this.dUk.setCornerRadius(this.dUl, this.dUl, 0.0f, 0.0f);
                    break;
                case 2:
                    this.dUm = 5;
                    i2 = aNF();
                    aNH = aNH();
                    this.dUk.setCornerRadius(this.dUl, 0.0f, 0.0f, this.dUl);
                    break;
                default:
                    aNH = 0;
                    break;
            }
            update(i2, aNH);
        }
    }

    public void aND() {
        super.dismiss();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!aNI()) {
            aND();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (d.this.atm != null) {
                    d.this.atm.release();
                }
            }
        });
    }

    private void initView() {
        this.dUl = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.dUk = new RoundRectRelativeLayout(this.mContext);
        aa(this.dUk);
        ab(this.dUk);
        setContentView(this.dUk);
    }

    private void aa(ViewGroup viewGroup) {
        this.atm = new CommonWebLayout(this.mContext);
        this.atm.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.atm.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void da(String str) {
                super.da(str);
                if (d.this.atn != null) {
                    d.this.atn.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cr(int i) {
                super.cr(i);
                if (i == 100 && d.this.atn != null) {
                    d.this.atn.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void db(String str) {
                super.db(str);
                if (d.this.atn != null) {
                    d.this.atn.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (d.this.atn != null) {
                    d.this.atn.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.atm, new ViewGroup.LayoutParams(-1, -1));
    }

    private void ab(ViewGroup viewGroup) {
        this.atn = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.atn, layoutParams);
        this.atn.setVisibility(8);
    }

    private int aNE() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int aWf() {
        return (aNE() * 470) / 375;
    }

    private int aNF() {
        return (aNH() * 375) / 470;
    }

    private int aNH() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.aND();
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
    }
}
