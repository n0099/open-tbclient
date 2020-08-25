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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class b {
    private Runnable fle;
    private Handler handler;
    private PopupWindow hrF;
    private com.baidu.tieba.tbadkCore.e.a hrG;
    private ActivityLifeCycleListener hrH;
    private com.baidu.tieba.tbadkCore.e.c hrI;

    private b() {
        this.handler = new Handler();
        this.hrI = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.hrG != null && b.this.hrG.a(str, jsPromptResult);
            }
        };
        this.fle = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.cdT();
            }
        };
        this.hrG = new com.baidu.tieba.tbadkCore.e.a();
        this.hrG.a(new com.baidu.tieba.easterEgg.a());
        this.hrH = new ActivityLifeCycleListener();
    }

    public static b cdS() {
        return a.hrK;
    }

    private void d(Activity activity, View view) {
        this.hrF = new PopupWindow(activity);
        this.hrF.setBackgroundDrawable(new ColorDrawable(0));
        this.hrF.setWidth(l.getEquipmentWidth(activity));
        this.hrF.setHeight(l.getEquipmentHeight(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.hrF.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.fle, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.hrH.isAdded()) {
            fragmentManager.beginTransaction().add(this.hrH, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.hrF.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.hrF = null;
            }
        });
        try {
            this.hrF.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new aq("c13126"));
        } catch (Throwable th) {
        }
    }

    public void Hm(final String str) {
        Activity currentActivity;
        if (!at.isEmpty(str) && (currentActivity = com.baidu.adp.base.a.lb().currentActivity()) != null && currentActivity.getWindow() != null && currentActivity.getWindow().getDecorView() != null) {
            if (ak(currentActivity)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.Hm(str);
                        } catch (Throwable th) {
                            b.this.cdT();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.hrF != null && this.hrF.isShowing()) {
                if (this.hrF.getContentView() == null || this.hrF.getContentView().getContext() != currentActivity) {
                    cdT();
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
                    b.this.cdT();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.hrI);
            d(currentActivity, inflate);
        }
    }

    public void es(final String str, final String str2) {
        Activity currentActivity;
        if (!at.isEmpty(str)) {
            if ((this.hrF == null || !this.hrF.isShowing()) && (currentActivity = com.baidu.adp.base.a.lb().currentActivity()) != null && ae.checkWriteExternalStorage(currentActivity)) {
                if (ak(currentActivity)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.es(str, str2);
                            } catch (Throwable th) {
                                b.this.cdT();
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
                        if (!at.isEmpty(str2) && (view.getContext() instanceof TbPageContextSupport)) {
                            TiebaStatic.log(new aq("c13451").ai("obj_type", 1));
                            be.bju().b(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                            return;
                        }
                        TiebaStatic.log(new aq("c13451").ai("obj_type", 2));
                        b.this.cdT();
                    }
                });
                tBLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.easterEgg.b.9
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        b.this.handler.removeCallbacksAndMessages(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        b.this.cdT();
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

    public void cdT() {
        if (this.hrF != null && this.hrF.isShowing()) {
            try {
                this.hrF.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes18.dex */
    private static class a {
        private static b hrK = new b();
    }

    private boolean ak(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
