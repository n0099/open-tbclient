package com.baidu.tieba.ala.liveroom.n;

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
/* loaded from: classes4.dex */
public class a extends f implements com.baidu.live.view.web.f {
    private RoundRectRelativeLayout bjN;
    private CommonWebLayout bjO;
    private View bjP;
    private float bjQ;
    private boolean goa;
    private Activity mActivity;

    public a(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        mk(false);
        if (!RM()) {
            RH();
        }
    }

    public void a(long j, String str, long j2, AlaLastLiveroomInfo alaLastLiveroomInfo, boolean z) {
        g gVar = new g();
        gVar.w(this.mActivity).a(this).a(this.bjO.getSchemeCallback()).aC(j).hT(str).cN(z).aD(j2).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] RE = gVar.RE();
        for (com.baidu.live.view.web.a aVar : RE) {
            this.bjO.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void EO(String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            int screenWidth = ScreenHelper.getScreenWidth(this.mActivity);
            int screenHeight = ScreenHelper.getScreenHeight(this.mActivity);
            setWidth(screenWidth);
            setHeight(screenHeight);
            showAtLocation(findViewById, 80, 0, 0);
            ac(this.bjN);
            KS();
            this.bjO.loadUrl(str);
            mk(true);
        }
    }

    private void mk(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913224, Boolean.valueOf(z)));
    }

    public void dD(int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.bjN != null && this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            update(ScreenHelper.getScreenWidth(this.mActivity), ScreenHelper.getScreenHeight(this.mActivity));
        }
    }

    public void onResume() {
        if (this.bjO != null) {
            this.bjO.onResume();
        }
    }

    public void onPause() {
        if (this.bjO != null) {
            this.bjO.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RH() {
        super.dismiss();
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (a.this.bjO != null) {
                    a.this.bjO.release();
                }
            }
        });
    }

    private void initView() {
        bTq();
        initWebView();
        bTr();
        setContentView(this.bjN);
    }

    private void bTq() {
        if (this.bjN == null) {
            this.bjQ = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            this.bjN = new RoundRectRelativeLayout(this.mActivity);
            this.bjN.setCornerRadius(this.bjQ);
            if (Build.VERSION.SDK_INT >= 19) {
                this.bjN.setSystemUiVisibility(5380);
            }
        }
    }

    private void initWebView() {
        this.bjO = new CommonWebLayout(this.mActivity);
        this.bjO.setBackgroundColor(0);
        this.bjO.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
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
        this.bjN.addView(this.bjO, new ViewGroup.LayoutParams(-1, -1));
    }

    private void bTr() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.bjP = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.bjN.addView(this.bjP, layoutParams);
            this.bjP.setVisibility(8);
        }
    }

    private void KS() {
        TranslateAnimation translateAnimation;
        if (getContentView() != null && (translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f)) != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            getContentView().startAnimation(translateAnimation);
        }
    }

    private boolean RM() {
        if (getContentView() == null) {
            return false;
        }
        if (this.goa) {
            return true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(250L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.RH();
                a.this.goa = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        getContentView().startAnimation(translateAnimation);
        this.goa = true;
        return true;
    }

    public void release() {
        if (this.bjO != null) {
            this.bjO.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void eL(int i) {
        dismiss();
        if (this.bjO != null) {
            this.bjO.release();
        }
    }

    private void ac(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
