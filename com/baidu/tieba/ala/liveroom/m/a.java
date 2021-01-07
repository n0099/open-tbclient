package com.baidu.tieba.ala.liveroom.m;

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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
/* loaded from: classes11.dex */
public class a extends e implements f {
    private RoundRectRelativeLayout byQ;
    private CommonWebLayout byR;
    private View byS;
    private float byT;
    private boolean hpp;
    private Activity mActivity;

    public a(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        oh(false);
        if (!aam()) {
            aah();
        }
    }

    public void a(long j, String str, long j2, AlaLastLiveroomInfo alaLastLiveroomInfo, boolean z) {
        g gVar = new g();
        gVar.w(this.mActivity).a(this).a(this.byR.getSchemeCallback()).bA(j).jj(str).dD(z).bB(j2).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] aaf = gVar.aaf();
        for (com.baidu.live.view.web.a aVar : aaf) {
            this.byR.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void GA(String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            setWidth(ScreenHelper.getScreenWidth(this.mActivity));
            setHeight(-1);
            showAtLocation(findViewById, 80, 0, 0);
            ah(this.byQ);
            Oj();
            this.byR.loadUrl(str);
            oh(true);
        }
    }

    private void oh(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913224, Boolean.valueOf(z)));
    }

    public void dU(int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.byQ != null && this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            update(ScreenHelper.getScreenWidth(this.mActivity), -1);
        }
    }

    public void onResume() {
        if (this.byR != null) {
            this.byR.onResume();
        }
    }

    public void onPause() {
        if (this.byR != null) {
            this.byR.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aah() {
        super.dismiss();
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
                if (a.this.byR != null) {
                    a.this.byR.release();
                }
            }
        });
    }

    private void initView() {
        cin();
        initWebView();
        cio();
        setContentView(this.byQ);
    }

    private void cin() {
        if (this.byQ == null) {
            this.byT = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            this.byQ = new RoundRectRelativeLayout(this.mActivity);
            this.byQ.setCornerRadius(this.byT);
            if (Build.VERSION.SDK_INT >= 19) {
                setClippingEnabled(false);
                this.byQ.setSystemUiVisibility(5380);
            }
        }
    }

    private void initWebView() {
        this.byR = new CommonWebLayout(this.mActivity);
        this.byR.setBackgroundColor(0);
        this.byR.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.m.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            /* renamed from: if */
            public void mo20if(String str) {
                super.mo20if(str);
                if (a.this.byS != null) {
                    a.this.byS.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && a.this.byS != null) {
                    a.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ig(String str) {
                super.ig(str);
                if (a.this.byS != null) {
                    a.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (a.this.byS != null) {
                    a.this.byS.setVisibility(8);
                }
            }
        });
        this.byQ.addView(this.byR, new ViewGroup.LayoutParams(-1, -1));
    }

    private void cio() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.byS = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.byQ.addView(this.byS, layoutParams);
            this.byS.setVisibility(8);
        }
    }

    private void Oj() {
        TranslateAnimation translateAnimation;
        if (getContentView() != null && (translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f)) != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            getContentView().startAnimation(translateAnimation);
        }
    }

    private boolean aam() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hpp) {
            return true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(250L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.aah();
                a.this.hpp = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        getContentView().startAnimation(translateAnimation);
        this.hpp = true;
        return true;
    }

    public void release() {
        if (this.byR != null) {
            this.byR.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void fr(int i) {
        dismiss();
        if (this.byR != null) {
            this.byR.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
