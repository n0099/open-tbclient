package com.baidu.tieba.ala.liveroom.turntable;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes2.dex */
public class d extends f implements com.baidu.live.view.web.e {
    private CommonWebLayout aBg;
    private View aBh;
    private int epA;
    private RoundRectRelativeLayout epy;
    private float epz;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout baV() {
        return this.aBg;
    }

    public void show(String str) {
        View findViewById;
        int baZ;
        int bba;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.epA = 80;
                    baZ = baX();
                    bba = baY();
                    this.epy.setCornerRadius(this.epz, this.epz, 0.0f, 0.0f);
                    break;
                case 2:
                    this.epA = 5;
                    baZ = baZ();
                    bba = bba();
                    this.epy.setCornerRadius(this.epz, 0.0f, 0.0f, this.epz);
                    break;
                default:
                    this.epA = 80;
                    baZ = baX();
                    bba = baY();
                    this.epy.setCornerRadius(this.epz, this.epz, 0.0f, 0.0f);
                    break;
            }
            setWidth(baZ);
            setHeight(bba);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                S(this.epy);
            }
            vr();
            this.aBg.loadUrl(str);
        }
    }

    public void bN(int i) {
        int bba;
        int i2 = 0;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.epA = 80;
                    i2 = baX();
                    bba = baY();
                    this.epy.setCornerRadius(this.epz, this.epz, 0.0f, 0.0f);
                    break;
                case 2:
                    this.epA = 5;
                    i2 = baZ();
                    bba = bba();
                    this.epy.setCornerRadius(this.epz, 0.0f, 0.0f, this.epz);
                    break;
                default:
                    bba = 0;
                    break;
            }
            update(i2, bba);
            if (i == 2) {
                S(this.epy);
            }
        }
    }

    public void baW() {
        super.dismiss();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!bbb()) {
            baW();
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
                if (d.this.aBg != null) {
                    d.this.aBg.release();
                }
            }
        });
    }

    private void initView() {
        this.epz = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.epy = new RoundRectRelativeLayout(this.mContext);
        l(this.epy);
        L(this.epy);
        setContentView(this.epy);
    }

    private void l(ViewGroup viewGroup) {
        this.aBg = new CommonWebLayout(this.mContext);
        this.aBg.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.aBg.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dU(String str) {
                super.dU(str);
                if (d.this.aBh != null) {
                    d.this.aBh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cG(int i) {
                super.cG(i);
                if (i == 100 && d.this.aBh != null) {
                    d.this.aBh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dV(String str) {
                super.dV(str);
                if (d.this.aBh != null) {
                    d.this.aBh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (d.this.aBh != null) {
                    d.this.aBh.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.aBg, new ViewGroup.LayoutParams(-1, -1));
    }

    private void L(ViewGroup viewGroup) {
        this.aBh = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.aBh, layoutParams);
        this.aBh.setVisibility(8);
    }

    private int baX() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int baY() {
        return (baX() * 470) / 375;
    }

    private int baZ() {
        return (bba() * 375) / 470;
    }

    private int bba() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.baW();
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
    }

    private void S(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
