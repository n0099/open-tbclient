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
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a extends e implements f {
    private RoundRectRelativeLayout bqG;
    private CommonWebLayout bqH;
    private View bqI;
    private float bqJ;
    private boolean gUG;
    private Activity mActivity;

    public a(Activity activity) {
        super(activity);
        this.mActivity = activity;
        setClippingEnabled(false);
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        nl(false);
        if (!Xf()) {
            Xa();
        }
    }

    public void a(long j, String str, long j2, AlaLastLiveroomInfo alaLastLiveroomInfo, boolean z) {
        g gVar = new g();
        gVar.y(this.mActivity).a(this).a(this.bqH.getSchemeCallback()).bc(j).iS(str).dk(z).bd(j2).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] WX = gVar.WX();
        for (com.baidu.live.view.web.a aVar : WX) {
            this.bqH.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void Gn(String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            setWidth(ScreenHelper.getScreenWidth(this.mActivity));
            setHeight(-1);
            showAtLocation(findViewById, 80, 0, 0);
            ah(this.bqG);
            MR();
            this.bqH.loadUrl(str);
            nl(true);
        }
    }

    private void nl(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913224, Boolean.valueOf(z)));
    }

    public void dI(int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.bqG != null && this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            update(ScreenHelper.getScreenWidth(this.mActivity), -1);
        }
    }

    public void onResume() {
        if (this.bqH != null) {
            this.bqH.onResume();
        }
    }

    public void onPause() {
        if (this.bqH != null) {
            this.bqH.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
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
                if (a.this.bqH != null) {
                    a.this.bqH.release();
                }
            }
        });
    }

    private void initView() {
        cck();
        initWebView();
        ccl();
        setContentView(this.bqG);
    }

    private void cck() {
        if (this.bqG == null) {
            this.bqJ = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            this.bqG = new RoundRectRelativeLayout(this.mActivity);
            this.bqG.setCornerRadius(this.bqJ);
            if (Build.VERSION.SDK_INT >= 19) {
                this.bqG.setSystemUiVisibility(5380);
            }
        }
    }

    private void initWebView() {
        this.bqH = new CommonWebLayout(this.mActivity);
        this.bqH.setBackgroundColor(0);
        this.bqH.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
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
        this.bqG.addView(this.bqH, new ViewGroup.LayoutParams(-1, -1));
    }

    private void ccl() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.bqI = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.bqG.addView(this.bqI, layoutParams);
            this.bqI.setVisibility(8);
        }
    }

    private void MR() {
        TranslateAnimation translateAnimation;
        if (getContentView() != null && (translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f)) != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            getContentView().startAnimation(translateAnimation);
        }
    }

    private boolean Xf() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gUG) {
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
                a.this.Xa();
                a.this.gUG = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        getContentView().startAnimation(translateAnimation);
        this.gUG = true;
        return true;
    }

    public void release() {
        if (this.bqH != null) {
            this.bqH.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void eX(int i) {
        dismiss();
        if (this.bqH != null) {
            this.bqH.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
