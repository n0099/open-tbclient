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
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.g;
/* loaded from: classes7.dex */
public class a extends f implements com.baidu.live.view.web.f {
    private float bjp;
    private CommonWebLayout buV;
    private View buW;
    private RoundRectRelativeLayout fNM;
    private boolean gkP;
    private Activity mActivity;

    public a(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        mf(false);
        if (!bHn()) {
            bHi();
        }
    }

    public void a(long j, String str, long j2, AlaLastLiveroomInfo alaLastLiveroomInfo, boolean z) {
        g gVar = new g();
        gVar.v(this.mActivity).a(this).a(this.buV.getSchemeCallback()).aC(j).hw(str).cL(z).aD(j2).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] QV = gVar.QV();
        for (com.baidu.live.view.web.a aVar : QV) {
            this.buV.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void show(String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            int screenWidth = ScreenHelper.getScreenWidth(this.mActivity);
            int screenHeight = ScreenHelper.getScreenHeight(this.mActivity);
            setWidth(screenWidth);
            setHeight(screenHeight);
            showAtLocation(findViewById, 80, 0, 0);
            aa(this.fNM);
            Kl();
            this.buV.loadUrl(str);
            mf(true);
        }
    }

    private void mf(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913224, Boolean.valueOf(z)));
    }

    public void dz(int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.fNM != null && this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            update(ScreenHelper.getScreenWidth(this.mActivity), ScreenHelper.getScreenHeight(this.mActivity));
        }
    }

    public void onResume() {
        if (this.buV != null) {
            this.buV.onResume();
        }
    }

    public void onPause() {
        if (this.buV != null) {
            this.buV.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHi() {
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
                if (a.this.buV != null) {
                    a.this.buV.release();
                }
            }
        });
    }

    private void initView() {
        bRS();
        initWebView();
        bRT();
        setContentView(this.fNM);
    }

    private void bRS() {
        if (this.fNM == null) {
            this.bjp = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            this.fNM = new RoundRectRelativeLayout(this.mActivity);
            this.fNM.setCornerRadius(this.bjp);
            if (Build.VERSION.SDK_INT >= 19) {
                this.fNM.setSystemUiVisibility(5380);
            }
        }
    }

    private void initWebView() {
        this.buV = new CommonWebLayout(this.mActivity);
        this.buV.setBackgroundColor(0);
        this.buV.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.m.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hr(String str) {
                super.hr(str);
                if (a.this.buW != null) {
                    a.this.buW.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fy(int i) {
                super.fy(i);
                if (i == 100 && a.this.buW != null) {
                    a.this.buW.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hs(String str) {
                super.hs(str);
                if (a.this.buW != null) {
                    a.this.buW.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (a.this.buW != null) {
                    a.this.buW.setVisibility(8);
                }
            }
        });
        this.fNM.addView(this.buV, new ViewGroup.LayoutParams(-1, -1));
    }

    private void bRT() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.buW = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.fNM.addView(this.buW, layoutParams);
            this.buW.setVisibility(8);
        }
    }

    private void Kl() {
        TranslateAnimation translateAnimation;
        if (getContentView() != null && (translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f)) != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            getContentView().startAnimation(translateAnimation);
        }
    }

    private boolean bHn() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gkP) {
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
                a.this.bHi();
                a.this.gkP = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        getContentView().startAnimation(translateAnimation);
        this.gkP = true;
        return true;
    }

    public void release() {
        if (this.buV != null) {
            this.buV.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void fA(int i) {
        dismiss();
        if (this.buV != null) {
            this.buV.release();
        }
    }

    private void aa(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
