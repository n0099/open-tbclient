package com.baidu.tieba.ala.liveroom.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.JsResult;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.u.a;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
/* loaded from: classes3.dex */
public class b extends Dialog {
    private f bcB;
    private CommonWebLayout bcf;
    private View bcg;
    private Activity caH;
    private a fEF;
    private RoundRectRelativeLayout fEG;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(String str, JsResult jsResult);
    }

    public b(@NonNull Activity activity) {
        super(activity, a.j.sdk_Transparent);
        this.caH = activity;
        init();
    }

    public void a(a aVar) {
        this.fEF = aVar;
    }

    public void b(f fVar) {
        this.bcB = fVar;
    }

    public CommonWebLayout bmE() {
        return this.bcf;
    }

    public void show(String str) {
        CB();
        show();
        this.bcf.loadUrl(str);
        ShowUtil.windowCount++;
    }

    private void init() {
        Di();
        initView();
        wD();
    }

    private void Di() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) this.caH.getSystemService("window");
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (Build.VERSION.SDK_INT >= 17) {
                    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                } else {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = displayMetrics.widthPixels;
                attributes.height = (int) (displayMetrics.heightPixels * 0.4f);
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        float dimensionPixelOffset = this.caH.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        this.fEG = new RoundRectRelativeLayout(this.caH);
        this.fEG.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        initWebView();
        buW();
        setContentView(this.fEG);
    }

    private void initWebView() {
        this.bcf = new CommonWebLayout(this.caH);
        this.bcf.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.f.b.1
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fe(String str) {
                if (b.this.bcg != null) {
                    b.this.bcg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                if (b.this.bcg != null) {
                    b.this.bcg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void HK() {
                if (b.this.bcg != null) {
                    b.this.bcg.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean a(String str, JsResult jsResult) {
                if (b.this.fEF != null) {
                    return b.this.fEF.a(str, jsResult);
                }
                return true;
            }
        });
        g gVar = new g();
        gVar.u(this.caH).a(this.bcB).a(this.bcf.getSchemeCallback());
        com.baidu.live.view.web.a[] HN = gVar.HN();
        for (com.baidu.live.view.web.a aVar : HN) {
            this.bcf.addJavascriptInterface(aVar, aVar.getName());
        }
        this.fEG.addView(this.bcf, new ViewGroup.LayoutParams(-1, -1));
    }

    private void buW() {
        this.bcg = LayoutInflater.from(this.caH).inflate(a.h.live_commerce_web_goods_progress, (ViewGroup) null);
        this.fEG.addView(this.bcg, new ViewGroup.LayoutParams(-1, -1));
    }

    private void wD() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.f.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bcf != null) {
                    b.this.bcf.release();
                }
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void CB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        if (this.fEG != null) {
            this.fEG.startAnimation(translateAnimation);
        }
    }
}
