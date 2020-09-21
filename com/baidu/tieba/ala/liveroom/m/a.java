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
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
/* loaded from: classes4.dex */
public class a extends f implements com.baidu.live.view.web.f {
    private RoundRectRelativeLayout bjN;
    private CommonWebLayout bjO;
    private View bjP;
    private float bjQ;
    private int byW;
    private InterfaceC0631a gCU;
    private Context mContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0631a {
        void onDismiss();
    }

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout RG() {
        return this.bjO;
    }

    public void a(InterfaceC0631a interfaceC0631a) {
        this.gCU = interfaceC0631a;
    }

    public void eg(String str, String str2) {
        View findViewById;
        int RK;
        int RL;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.byW = 80;
                    RK = RI();
                    RL = RJ();
                    this.bjN.setCornerRadius(this.bjQ, this.bjQ, 0.0f, 0.0f);
                    break;
                case 2:
                    this.byW = 5;
                    RK = RK();
                    RL = RL();
                    this.bjN.setCornerRadius(this.bjQ, 0.0f, 0.0f, this.bjQ);
                    break;
                default:
                    this.byW = 80;
                    RK = RI();
                    RL = RJ();
                    this.bjN.setCornerRadius(this.bjQ, this.bjQ, 0.0f, 0.0f);
                    break;
            }
            setWidth(RK);
            if (str2.equals("half") && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
                setHeight(RL / 2);
            } else {
                setHeight(RL);
                ac(this.bjN);
            }
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                ac(this.bjN);
            }
            KS();
            this.bjO.loadUrl(str);
        }
    }

    public void dD(int i) {
        int RL;
        int i2 = 0;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.byW = 80;
                    i2 = RI();
                    RL = RJ();
                    this.bjN.setCornerRadius(this.bjQ, this.bjQ, 0.0f, 0.0f);
                    break;
                case 2:
                    this.byW = 5;
                    i2 = RK();
                    RL = RL();
                    this.bjN.setCornerRadius(this.bjQ, 0.0f, 0.0f, this.bjQ);
                    break;
                default:
                    RL = 0;
                    break;
            }
            update(i2, RL);
            if (i == 2) {
                ac(this.bjN);
            }
        }
    }

    public void RH() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!RM()) {
            RH();
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
                if (a.this.bjO != null) {
                    a.this.bjO.release();
                }
                if (a.this.gCU != null) {
                    a.this.gCU.onDismiss();
                }
            }
        });
    }

    private void initView() {
        this.bjQ = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.bjN = new RoundRectRelativeLayout(this.mContext);
        q(this.bjN);
        r(this.bjN);
        setContentView(this.bjN);
    }

    private void q(ViewGroup viewGroup) {
        this.bjO = new CommonWebLayout(this.mContext);
        this.bjO.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.bjO.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.m.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ho(String str) {
                super.ho(str);
                if (a.this.bjP != null) {
                    a.this.bjP.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eO(int i) {
                super.eO(i);
                if (i == 100 && a.this.bjP != null) {
                    a.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hp(String str) {
                super.hp(str);
                if (a.this.bjP != null) {
                    a.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (a.this.bjP != null) {
                    a.this.bjP.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bjO, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bjP = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bjP, layoutParams);
        this.bjP.setVisibility(8);
    }

    private int RI() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int RJ() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private int RK() {
        return (RL() * 375) / 470;
    }

    private int RL() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void KS() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.byW) {
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

    private boolean RM() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.byW) {
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
                    a.this.RH();
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
    public void eL(int i) {
        dismiss();
    }

    private void ac(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
