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
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes7.dex */
public class d extends f implements com.baidu.live.view.web.f {
    private float bjs;
    private CommonWebLayout buY;
    private View buZ;
    private RoundRectRelativeLayout fNQ;
    private int fNR;
    private a gJE;
    private Context mContext;

    /* loaded from: classes7.dex */
    public interface a {
        void onDismiss();
    }

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout bHi() {
        return this.buY;
    }

    public void a(a aVar) {
        this.gJE = aVar;
    }

    public void show(String str) {
        View findViewById;
        int bHm;
        int bHn;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.fNR = 80;
                    bHm = bHk();
                    bHn = bHl();
                    this.fNQ.setCornerRadius(this.bjs, this.bjs, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fNR = 5;
                    bHm = bHm();
                    bHn = bHn();
                    this.fNQ.setCornerRadius(this.bjs, 0.0f, 0.0f, this.bjs);
                    break;
                default:
                    this.fNR = 80;
                    bHm = bHk();
                    bHn = bHl();
                    this.fNQ.setCornerRadius(this.bjs, this.bjs, 0.0f, 0.0f);
                    break;
            }
            setWidth(bHm);
            setHeight(bHn);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                aa((View) this.fNQ);
            }
            Kl();
            this.buY.loadUrl(str);
        }
    }

    public void dz(int i) {
        int bHn;
        int i2 = 0;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.fNR = 80;
                    i2 = bHk();
                    bHn = bHl();
                    this.fNQ.setCornerRadius(this.bjs, this.bjs, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fNR = 5;
                    i2 = bHm();
                    bHn = bHn();
                    this.fNQ.setCornerRadius(this.bjs, 0.0f, 0.0f, this.bjs);
                    break;
                default:
                    bHn = 0;
                    break;
            }
            update(i2, bHn);
            if (i == 2) {
                aa((View) this.fNQ);
            }
        }
    }

    public void bHj() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bHo()) {
            bHj();
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
                if (d.this.buY != null) {
                    d.this.buY.release();
                }
                if (d.this.gJE != null) {
                    d.this.gJE.onDismiss();
                }
            }
        });
    }

    private void initView() {
        this.bjs = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.fNQ = new RoundRectRelativeLayout(this.mContext);
        y(this.fNQ);
        aa((ViewGroup) this.fNQ);
        setContentView(this.fNQ);
    }

    private void y(ViewGroup viewGroup) {
        this.buY = new CommonWebLayout(this.mContext);
        this.buY.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.buY.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hs(String str) {
                super.hs(str);
                if (d.this.buZ != null) {
                    d.this.buZ.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fy(int i) {
                super.fy(i);
                if (i == 100 && d.this.buZ != null) {
                    d.this.buZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ht(String str) {
                super.ht(str);
                if (d.this.buZ != null) {
                    d.this.buZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.buZ != null) {
                    d.this.buZ.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.buY, new ViewGroup.LayoutParams(-1, -1));
    }

    private void aa(ViewGroup viewGroup) {
        this.buZ = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.buZ, layoutParams);
        this.buZ.setVisibility(8);
    }

    private int bHk() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int bHl() {
        return (bHk() * 470) / 375;
    }

    private int bHm() {
        return (bHn() * 375) / 470;
    }

    private int bHn() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.bHj();
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
    public void fA(int i) {
        dismiss();
    }

    private void aa(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
