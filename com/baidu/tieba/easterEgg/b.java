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
/* loaded from: classes24.dex */
public class b {
    private Runnable fOA;
    private Handler handler;
    private PopupWindow igj;
    private com.baidu.tieba.tbadkCore.e.a igk;
    private ActivityLifeCycleListener igl;
    private com.baidu.tieba.tbadkCore.e.c igm;

    private b() {
        this.handler = new Handler();
        this.igm = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.igk != null && b.this.igk.a(str, jsPromptResult);
            }
        };
        this.fOA = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.cqn();
            }
        };
        this.igk = new com.baidu.tieba.tbadkCore.e.a();
        this.igk.a(new com.baidu.tieba.easterEgg.a());
        this.igl = new ActivityLifeCycleListener();
    }

    public static b cqm() {
        return a.igo;
    }

    private void d(Activity activity, View view) {
        this.igj = new PopupWindow(activity);
        this.igj.setBackgroundDrawable(new ColorDrawable(0));
        this.igj.setWidth(l.getEquipmentWidth(activity));
        this.igj.setHeight(l.getEquipmentHeight(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.igj.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.fOA, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.igl.isAdded()) {
            fragmentManager.beginTransaction().add(this.igl, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.igj.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.igj = null;
            }
        });
        try {
            this.igj.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new aq("c13126"));
        } catch (Throwable th) {
        }
    }

    public void Jn(final String str) {
        Activity currentActivity;
        if (!at.isEmpty(str) && (currentActivity = com.baidu.adp.base.a.lg().currentActivity()) != null && currentActivity.getWindow() != null && currentActivity.getWindow().getDecorView() != null) {
            if (ap(currentActivity)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.Jn(str);
                        } catch (Throwable th) {
                            b.this.cqn();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.igj != null && this.igj.isShowing()) {
                if (this.igj.getContentView() == null || this.igj.getContentView().getContext() != currentActivity) {
                    cqn();
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
                    b.this.cqn();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.igm);
            d(currentActivity, inflate);
        }
    }

    public void eJ(final String str, final String str2) {
        Activity currentActivity;
        if (!at.isEmpty(str)) {
            if ((this.igj == null || !this.igj.isShowing()) && (currentActivity = com.baidu.adp.base.a.lg().currentActivity()) != null && ae.checkWriteExternalStorage(currentActivity)) {
                if (ap(currentActivity)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.eJ(str, str2);
                            } catch (Throwable th) {
                                b.this.cqn();
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
                            TiebaStatic.log(new aq("c13451").al("obj_type", 1));
                            be.brr().b(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                            return;
                        }
                        TiebaStatic.log(new aq("c13451").al("obj_type", 2));
                        b.this.cqn();
                    }
                });
                tBLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.easterEgg.b.9
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        b.this.handler.removeCallbacksAndMessages(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        b.this.cqn();
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

    public void cqn() {
        if (this.igj != null && this.igj.isShowing()) {
            try {
                this.igj.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes24.dex */
    private static class a {
        private static b igo = new b();
    }

    private boolean ap(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
