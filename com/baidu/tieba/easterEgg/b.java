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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b {
    private Runnable dcr;
    private PopupWindow eYh;
    private com.baidu.tieba.tbadkCore.e.a eYi;
    private ActivityLifeCycleListener eYj;
    private com.baidu.tieba.tbadkCore.e.c eYk;
    private Handler handler;

    private b() {
        this.handler = new Handler();
        this.eYk = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.eYi != null && b.this.eYi.a(str, jsPromptResult);
            }
        };
        this.dcr = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.bdb();
            }
        };
        this.eYi = new com.baidu.tieba.tbadkCore.e.a();
        this.eYi.a(new com.baidu.tieba.easterEgg.a());
        this.eYj = new ActivityLifeCycleListener();
    }

    public static b bda() {
        return a.eYn;
    }

    private void g(Activity activity, View view) {
        this.eYh = new PopupWindow(activity);
        this.eYh.setBackgroundDrawable(new ColorDrawable(0));
        this.eYh.setWidth(l.getEquipmentWidth(activity));
        this.eYh.setHeight(l.getEquipmentHeight(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eYh.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.dcr, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null) {
            fragmentManager.beginTransaction().add(this.eYj, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.eYh.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.eYh = null;
            }
        });
        try {
            this.eYh.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new an("c13126"));
        } catch (Throwable th) {
        }
    }

    public void uO(final String str) {
        Activity currentActivity;
        if (!aq.isEmpty(str) && (currentActivity = com.baidu.adp.base.a.em().currentActivity()) != null && currentActivity.getWindow() != null && currentActivity.getWindow().getDecorView() != null) {
            if (ad(currentActivity)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.uO(str);
                        } catch (Throwable th) {
                            b.this.bdb();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.eYh != null && this.eYh.isShowing()) {
                if (this.eYh.getContentView() == null || this.eYh.getContentView().getContext() != currentActivity) {
                    bdb();
                } else {
                    return;
                }
            }
            View inflate = LayoutInflater.from(currentActivity).inflate(R.layout.easter_egg_dialog_h5_layout, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            BaseWebView baseWebView = (BaseWebView) inflate.findViewById(R.id.dialog_webview);
            baseWebView.loadUrl(str);
            baseWebView.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.easterEgg.b.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str2) {
                    b.this.handler.removeCallbacksAndMessages(null);
                }
            });
            baseWebView.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.easterEgg.b.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str2, String str3) {
                    b.this.handler.removeCallbacksAndMessages(null);
                    b.this.bdb();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.eYk);
            g(currentActivity, inflate);
        }
    }

    public void cB(final String str, final String str2) {
        Activity currentActivity;
        if (!aq.isEmpty(str)) {
            if ((this.eYh == null || !this.eYh.isShowing()) && (currentActivity = com.baidu.adp.base.a.em().currentActivity()) != null && ab.checkWriteExternalStorage(currentActivity)) {
                if (ad(currentActivity)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.cB(str, str2);
                            } catch (Throwable th) {
                                b.this.bdb();
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
                tBLottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.easterEgg.b.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!aq.isEmpty(str2) && (view.getContext() instanceof TbPageContextSupport)) {
                            TiebaStatic.log(new an("c13451").O("obj_type", 1));
                            ba.amQ().b(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                            return;
                        }
                        TiebaStatic.log(new an("c13451").O("obj_type", 2));
                        b.this.bdb();
                    }
                });
                tBLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.easterEgg.b.9
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        b.this.handler.removeCallbacksAndMessages(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        b.this.bdb();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        b.this.bdb();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                tBLottieAnimationView.playAnimation();
                g(currentActivity, inflate);
            }
        }
    }

    public void bdb() {
        if (this.eYh != null && this.eYh.isShowing()) {
            try {
                this.eYh.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b eYn = new b();
    }

    private boolean ad(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
