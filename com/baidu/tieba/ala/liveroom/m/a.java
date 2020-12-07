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
/* loaded from: classes4.dex */
public class a extends e implements f {
    private RoundRectRelativeLayout bue;
    private CommonWebLayout bug;
    private View buh;
    private float bui;
    private boolean hdA;
    private Activity mActivity;

    public a(Activity activity) {
        super(activity);
        this.mActivity = activity;
        setClippingEnabled(false);
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        nH(false);
        if (!YV()) {
            YQ();
        }
    }

    public void a(long j, String str, long j2, AlaLastLiveroomInfo alaLastLiveroomInfo, boolean z) {
        g gVar = new g();
        gVar.x(this.mActivity).a(this).a(this.bug.getSchemeCallback()).bA(j).jq(str).dA(z).bB(j2).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] YO = gVar.YO();
        for (com.baidu.live.view.web.a aVar : YO) {
            this.bug.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void GD(String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            setWidth(ScreenHelper.getScreenWidth(this.mActivity));
            setHeight(-1);
            showAtLocation(findViewById, 80, 0, 0);
            ah(this.bue);
            OD();
            this.bug.loadUrl(str);
            nH(true);
        }
    }

    private void nH(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913224, Boolean.valueOf(z)));
    }

    public void dX(int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.bue != null && this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            update(ScreenHelper.getScreenWidth(this.mActivity), -1);
        }
    }

    public void onResume() {
        if (this.bug != null) {
            this.bug.onResume();
        }
    }

    public void onPause() {
        if (this.bug != null) {
            this.bug.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YQ() {
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
                if (a.this.bug != null) {
                    a.this.bug.release();
                }
            }
        });
    }

    private void initView() {
        cfv();
        initWebView();
        cfw();
        setContentView(this.bue);
    }

    private void cfv() {
        if (this.bue == null) {
            this.bui = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            this.bue = new RoundRectRelativeLayout(this.mActivity);
            this.bue.setCornerRadius(this.bui);
            if (Build.VERSION.SDK_INT >= 19) {
                this.bue.setSystemUiVisibility(5380);
            }
        }
    }

    private void initWebView() {
        this.bug = new CommonWebLayout(this.mActivity);
        this.bug.setBackgroundColor(0);
        this.bug.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.m.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void is(String str) {
                super.is(str);
                if (a.this.buh != null) {
                    a.this.buh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && a.this.buh != null) {
                    a.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void it(String str) {
                super.it(str);
                if (a.this.buh != null) {
                    a.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (a.this.buh != null) {
                    a.this.buh.setVisibility(8);
                }
            }
        });
        this.bue.addView(this.bug, new ViewGroup.LayoutParams(-1, -1));
    }

    private void cfw() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.buh = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.bue.addView(this.buh, layoutParams);
            this.buh.setVisibility(8);
        }
    }

    private void OD() {
        TranslateAnimation translateAnimation;
        if (getContentView() != null && (translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f)) != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            getContentView().startAnimation(translateAnimation);
        }
    }

    private boolean YV() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hdA) {
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
                a.this.YQ();
                a.this.hdA = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        getContentView().startAnimation(translateAnimation);
        this.hdA = true;
        return true;
    }

    public void release() {
        if (this.bug != null) {
            this.bug.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void fr(int i) {
        dismiss();
        if (this.bug != null) {
            this.bug.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
