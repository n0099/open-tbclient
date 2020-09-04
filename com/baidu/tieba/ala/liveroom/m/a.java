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
    private float bjs;
    private CommonWebLayout buY;
    private View buZ;
    private RoundRectRelativeLayout fNQ;
    private boolean gkT;
    private Activity mActivity;

    public a(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        mh(false);
        if (!bHo()) {
            bHj();
        }
    }

    public void a(long j, String str, long j2, AlaLastLiveroomInfo alaLastLiveroomInfo, boolean z) {
        g gVar = new g();
        gVar.v(this.mActivity).a(this).a(this.buY.getSchemeCallback()).aC(j).hx(str).cM(z).aD(j2).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] QV = gVar.QV();
        for (com.baidu.live.view.web.a aVar : QV) {
            this.buY.addJavascriptInterface(aVar, aVar.getName());
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
            aa(this.fNQ);
            Kl();
            this.buY.loadUrl(str);
            mh(true);
        }
    }

    private void mh(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913224, Boolean.valueOf(z)));
    }

    public void dz(int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.fNQ != null && this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            update(ScreenHelper.getScreenWidth(this.mActivity), ScreenHelper.getScreenHeight(this.mActivity));
        }
    }

    public void onResume() {
        if (this.buY != null) {
            this.buY.onResume();
        }
    }

    public void onPause() {
        if (this.buY != null) {
            this.buY.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHj() {
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
                if (a.this.buY != null) {
                    a.this.buY.release();
                }
            }
        });
    }

    private void initView() {
        bRT();
        initWebView();
        bRU();
        setContentView(this.fNQ);
    }

    private void bRT() {
        if (this.fNQ == null) {
            this.bjs = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            this.fNQ = new RoundRectRelativeLayout(this.mActivity);
            this.fNQ.setCornerRadius(this.bjs);
            if (Build.VERSION.SDK_INT >= 19) {
                this.fNQ.setSystemUiVisibility(5380);
            }
        }
    }

    private void initWebView() {
        this.buY = new CommonWebLayout(this.mActivity);
        this.buY.setBackgroundColor(0);
        this.buY.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.m.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hs(String str) {
                super.hs(str);
                if (a.this.buZ != null) {
                    a.this.buZ.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fy(int i) {
                super.fy(i);
                if (i == 100 && a.this.buZ != null) {
                    a.this.buZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ht(String str) {
                super.ht(str);
                if (a.this.buZ != null) {
                    a.this.buZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (a.this.buZ != null) {
                    a.this.buZ.setVisibility(8);
                }
            }
        });
        this.fNQ.addView(this.buY, new ViewGroup.LayoutParams(-1, -1));
    }

    private void bRU() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.buZ = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.fNQ.addView(this.buZ, layoutParams);
            this.buZ.setVisibility(8);
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

    private boolean bHo() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gkT) {
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
                a.this.bHj();
                a.this.gkT = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        getContentView().startAnimation(translateAnimation);
        this.gkT = true;
        return true;
    }

    public void release() {
        if (this.buY != null) {
            this.buY.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void fA(int i) {
        dismiss();
        if (this.buY != null) {
            this.buY.release();
        }
    }

    private void aa(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
