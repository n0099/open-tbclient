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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.f;
/* loaded from: classes11.dex */
public class d extends com.baidu.live.view.e implements f {
    private int bXh;
    private RoundRectRelativeLayout byQ;
    private CommonWebLayout byR;
    private View byS;
    private float byT;
    private a hOT;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void onDismiss();
    }

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout getWebView() {
        return this.byR;
    }

    public void a(a aVar) {
        this.hOT = aVar;
    }

    public void GB(String str) {
        View findViewById;
        int aaj;
        int aak;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.bXh = 80;
                    aaj = aah();
                    aak = aai();
                    this.byQ.setCornerRadius(this.byT, this.byT, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bXh = 5;
                    aaj = aaj();
                    aak = aak();
                    this.byQ.setCornerRadius(this.byT, 0.0f, 0.0f, this.byT);
                    break;
                default:
                    this.bXh = 80;
                    aaj = aah();
                    aak = aai();
                    this.byQ.setCornerRadius(this.byT, this.byT, 0.0f, 0.0f);
                    break;
            }
            setWidth(aaj);
            setHeight(aak);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                ah(this.byQ);
            }
            Oj();
            this.byR.loadUrl(str);
        }
    }

    public void dU(int i) {
        int aak;
        int i2;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.bXh = 80;
                    int aah = aah();
                    aak = aai();
                    this.byQ.setCornerRadius(this.byT, this.byT, 0.0f, 0.0f);
                    i2 = aah;
                    break;
                case 2:
                    this.bXh = 5;
                    int aaj = aaj();
                    aak = aak();
                    this.byQ.setCornerRadius(this.byT, 0.0f, 0.0f, this.byT);
                    i2 = aaj;
                    break;
                default:
                    aak = 0;
                    i2 = 0;
                    break;
            }
            update(i2, aak);
            if (i == 2) {
                ah(this.byQ);
            }
        }
    }

    public void aag() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!aal()) {
            aag();
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
                if (d.this.byR != null) {
                    d.this.byR.release();
                }
                if (d.this.hOT != null) {
                    d.this.hOT.onDismiss();
                }
            }
        });
    }

    private void initView() {
        this.byT = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.byQ = new RoundRectRelativeLayout(this.mContext);
        q(this.byQ);
        r(this.byQ);
        setContentView(this.byQ);
    }

    private void q(ViewGroup viewGroup) {
        this.byR = new CommonWebLayout(this.mContext);
        this.byR.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.byR.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            /* renamed from: if */
            public void mo20if(String str) {
                super.mo20if(str);
                if (d.this.byS != null) {
                    d.this.byS.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && d.this.byS != null) {
                    d.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ig(String str) {
                super.ig(str);
                if (d.this.byS != null) {
                    d.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.byS != null) {
                    d.this.byS.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.byR, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.byS = LayoutInflater.from(this.mContext).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.byS, layoutParams);
        this.byS.setVisibility(8);
    }

    private int aah() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int aai() {
        return (aah() * 470) / 375;
    }

    private int aaj() {
        return (aak() * 375) / 470;
    }

    private int aak() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void Oj() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bXh) {
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

    private boolean aal() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bXh) {
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
                    d.this.aag();
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
    public void fr(int i) {
        dismiss();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
