package com.baidu.tieba.ala.liveroom.m;

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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.f;
/* loaded from: classes4.dex */
public class a extends e implements f {
    private int bOe;
    private RoundRectRelativeLayout bqG;
    private CommonWebLayout bqH;
    private View bqI;
    private float bqJ;
    private InterfaceC0679a hiW;
    private Context mContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0679a {
        void onDismiss();
    }

    public a(Context context) {
        super(context);
        this.mContext = context;
        setClippingEnabled(false);
        init();
    }

    public CommonWebLayout WZ() {
        return this.bqH;
    }

    public void a(InterfaceC0679a interfaceC0679a) {
        this.hiW = interfaceC0679a;
    }

    public void eu(String str, String str2) {
        View findViewById;
        int Xd;
        int Xe;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 2:
                    this.bOe = 5;
                    Xd = Xd();
                    Xe = Xe();
                    ah(this.bqG);
                    this.bqG.setCornerRadius(this.bqJ, 0.0f, 0.0f, this.bqJ);
                    break;
                default:
                    this.bOe = 80;
                    Xd = Xb();
                    if (str2.equals("half")) {
                        Xe = (int) (Xc() * 0.7f);
                    } else {
                        Xe = -1;
                        ah(this.bqG);
                    }
                    this.bqG.setCornerRadius(this.bqJ, this.bqJ, 0.0f, 0.0f);
                    break;
            }
            setWidth(Xd);
            setHeight(Xe);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                ah(this.bqG);
            }
            MR();
            this.bqH.loadUrl(str);
        }
    }

    public void dI(int i) {
        int Xe;
        int i2 = 0;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.bOe = 80;
                    i2 = Xb();
                    Xe = Xc();
                    this.bqG.setCornerRadius(this.bqJ, this.bqJ, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bOe = 5;
                    i2 = Xd();
                    Xe = Xe();
                    this.bqG.setCornerRadius(this.bqJ, 0.0f, 0.0f, this.bqJ);
                    break;
                default:
                    Xe = 0;
                    break;
            }
            update(i2, Xe);
            if (i == 2) {
                ah(this.bqG);
            }
        }
    }

    public void Xa() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Xf()) {
            Xa();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (a.this.bqH != null) {
                    a.this.bqH.release();
                }
                if (a.this.hiW != null) {
                    a.this.hiW.onDismiss();
                }
            }
        });
    }

    private void initView() {
        this.bqJ = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bqG = new RoundRectRelativeLayout(this.mContext);
        r(this.bqG);
        s(this.bqG);
        setContentView(this.bqG);
    }

    private void r(ViewGroup viewGroup) {
        this.bqH = new CommonWebLayout(this.mContext);
        this.bqH.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.bqH.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.m.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hU(String str) {
                super.hU(str);
                if (a.this.bqI != null) {
                    a.this.bqI.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fa(int i) {
                super.fa(i);
                if (i == 100 && a.this.bqI != null) {
                    a.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hV(String str) {
                super.hV(str);
                if (a.this.bqI != null) {
                    a.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (a.this.bqI != null) {
                    a.this.bqI.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bqH, new ViewGroup.LayoutParams(-1, -1));
    }

    private void s(ViewGroup viewGroup) {
        this.bqI = LayoutInflater.from(this.mContext).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bqI, layoutParams);
        this.bqI.setVisibility(8);
    }

    private int Xb() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int Xc() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private int Xd() {
        return (Xe() * 375) / 470;
    }

    private int Xe() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.Xa();
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

    @Override // com.baidu.live.view.web.f
    public void eX(int i) {
        dismiss();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
