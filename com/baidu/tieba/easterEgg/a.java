package com.baidu.tieba.easterEgg;

import android.animation.Animator;
import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private Runnable gdh;
    private Handler handler;
    private com.baidu.tieba.tbadkCore.e.c iFA;
    private PopupWindow iFx;
    private com.baidu.tieba.tbadkCore.e.a iFy;
    private ActivityLifeCycleListener iFz;
    private BaseWebView mWebView;

    private a() {
        this.handler = new Handler();
        this.iFA = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.a.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return a.this.iFy != null && a.this.iFy.a(a.this.mWebView, str, jsPromptResult);
            }
        };
        this.gdh = new Runnable() { // from class: com.baidu.tieba.easterEgg.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.handler.removeCallbacksAndMessages(null);
                a.this.cuy();
            }
        };
        this.iFy = new com.baidu.tieba.tbadkCore.e.a();
        this.iFy.a(new EasterEggBridge());
        this.iFz = new ActivityLifeCycleListener();
    }

    public static a cux() {
        return C0703a.iFC;
    }

    private void d(Activity activity, View view) {
        this.iFx = new PopupWindow(activity);
        this.iFx.setBackgroundDrawable(new ColorDrawable(0));
        this.iFx.setWidth(l.getEquipmentWidth(activity));
        this.iFx.setHeight(l.getEquipmentHeight(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iFx.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.gdh, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.iFz.isAdded()) {
            fragmentManager.beginTransaction().add(this.iFz, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.iFx.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.a.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                a.this.iFx = null;
            }
        });
        try {
            this.iFx.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new ar("c13126"));
        } catch (Throwable th) {
        }
    }

    public void Jc(final String str) {
        Activity currentActivity;
        if (!au.isEmpty(str) && (currentActivity = com.baidu.adp.base.b.kB().currentActivity()) != null && currentActivity.getWindow() != null && currentActivity.getWindow().getDecorView() != null) {
            if (al(currentActivity)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.this.Jc(str);
                        } catch (Throwable th) {
                            a.this.cuy();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.iFx != null && this.iFx.isShowing()) {
                if (this.iFx.getContentView() == null || this.iFx.getContentView().getContext() != currentActivity) {
                    cuy();
                } else {
                    return;
                }
            }
            View inflate = LayoutInflater.from(currentActivity).inflate(R.layout.easter_egg_dialog_h5_layout, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mWebView = (BaseWebView) inflate.findViewById(R.id.dialog_webview);
            this.mWebView.loadUrl(str);
            this.mWebView.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.easterEgg.a.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str2) {
                    a.this.handler.removeCallbacksAndMessages(null);
                }
            });
            this.mWebView.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.easterEgg.a.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str2, String str3) {
                    a.this.handler.removeCallbacksAndMessages(null);
                    a.this.cuy();
                }
            });
            this.mWebView.setBackgroundColor(0);
            this.mWebView.setOnJsPromptCallback(this.iFA);
            d(currentActivity, inflate);
        }
    }

    public void eO(final String str, final String str2) {
        Activity currentActivity;
        if (!au.isEmpty(str)) {
            if ((this.iFx == null || !this.iFx.isShowing()) && (currentActivity = com.baidu.adp.base.b.kB().currentActivity()) != null && ae.checkWriteExternalStorage(currentActivity)) {
                if (al(currentActivity)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a.this.eO(str, str2);
                            } catch (Throwable th) {
                                a.this.cuy();
                            }
                        }
                    }, 1000L);
                    return;
                }
                View inflate = LayoutInflater.from(currentActivity).inflate(R.layout.easter_egg_dialog_lottie_layout, (ViewGroup) null);
                inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(R.id.easter_egg_lottie_view);
                tBLottieAnimationView.setBackgroundResource(R.color.transparent);
                tBLottieAnimationView.setAnimationUrl(str);
                tBLottieAnimationView.useHardwareAcceleration(true);
                tBLottieAnimationView.enableMergePathsForKitKatAndAbove(true);
                tBLottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.easterEgg.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!au.isEmpty(str2) && (view.getContext() instanceof TbPageContextSupport)) {
                            TiebaStatic.log(new ar("c13451").ap("obj_type", 1));
                            bf.bsV().b(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                            return;
                        }
                        TiebaStatic.log(new ar("c13451").ap("obj_type", 2));
                        a.this.cuy();
                    }
                });
                tBLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.easterEgg.a.9
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        a.this.cuy();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                tBLottieAnimationView.playAnimation();
                d(currentActivity, inflate);
            }
        }
    }

    public void cuy() {
        if (this.iFx != null && this.iFx.isShowing()) {
            try {
                this.iFx.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.baidu.tieba.easterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0703a {
        private static a iFC = new a();
    }

    private boolean al(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
