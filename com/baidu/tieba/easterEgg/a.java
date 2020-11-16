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
/* loaded from: classes23.dex */
public class a {
    private Runnable fOd;
    private Handler handler;
    private PopupWindow igX;
    private com.baidu.tieba.tbadkCore.e.a igY;
    private ActivityLifeCycleListener igZ;
    private com.baidu.tieba.tbadkCore.e.c iha;
    private BaseWebView mWebView;

    private a() {
        this.handler = new Handler();
        this.iha = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.a.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return a.this.igY != null && a.this.igY.a(a.this.mWebView, str, jsPromptResult);
            }
        };
        this.fOd = new Runnable() { // from class: com.baidu.tieba.easterEgg.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.handler.removeCallbacksAndMessages(null);
                a.this.cpQ();
            }
        };
        this.igY = new com.baidu.tieba.tbadkCore.e.a();
        this.igY.a(new EasterEggBridge());
        this.igZ = new ActivityLifeCycleListener();
    }

    public static a cpP() {
        return C0713a.ihc;
    }

    private void d(Activity activity, View view) {
        this.igX = new PopupWindow(activity);
        this.igX.setBackgroundDrawable(new ColorDrawable(0));
        this.igX.setWidth(l.getEquipmentWidth(activity));
        this.igX.setHeight(l.getEquipmentHeight(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.igX.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.fOd, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.igZ.isAdded()) {
            fragmentManager.beginTransaction().add(this.igZ, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.igX.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.a.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                a.this.igX = null;
            }
        });
        try {
            this.igX.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new ar("c13126"));
        } catch (Throwable th) {
        }
    }

    public void IO(final String str) {
        Activity currentActivity;
        if (!au.isEmpty(str) && (currentActivity = com.baidu.adp.base.a.lg().currentActivity()) != null && currentActivity.getWindow() != null && currentActivity.getWindow().getDecorView() != null) {
            if (ao(currentActivity)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.this.IO(str);
                        } catch (Throwable th) {
                            a.this.cpQ();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.igX != null && this.igX.isShowing()) {
                if (this.igX.getContentView() == null || this.igX.getContentView().getContext() != currentActivity) {
                    cpQ();
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
                    a.this.cpQ();
                }
            });
            this.mWebView.setBackgroundColor(0);
            this.mWebView.setOnJsPromptCallback(this.iha);
            d(currentActivity, inflate);
        }
    }

    public void eJ(final String str, final String str2) {
        Activity currentActivity;
        if (!au.isEmpty(str)) {
            if ((this.igX == null || !this.igX.isShowing()) && (currentActivity = com.baidu.adp.base.a.lg().currentActivity()) != null && ae.checkWriteExternalStorage(currentActivity)) {
                if (ao(currentActivity)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a.this.eJ(str, str2);
                            } catch (Throwable th) {
                                a.this.cpQ();
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
                            TiebaStatic.log(new ar("c13451").ak("obj_type", 1));
                            bf.bqF().b(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                            return;
                        }
                        TiebaStatic.log(new ar("c13451").ak("obj_type", 2));
                        a.this.cpQ();
                    }
                });
                tBLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.easterEgg.a.9
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        a.this.cpQ();
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

    public void cpQ() {
        if (this.igX != null && this.igX.isShowing()) {
            try {
                this.igX.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.baidu.tieba.easterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private static class C0713a {
        private static a ihc = new a();
    }

    private boolean ao(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
