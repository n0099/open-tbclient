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
    private CommonWebLayout bjK;
    private View bjL;
    private f bkg;
    private Activity clq;
    private a fSP;
    private RoundRectRelativeLayout fSQ;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(String str, JsResult jsResult);
    }

    public b(@NonNull Activity activity) {
        super(activity, a.j.sdk_Transparent);
        this.clq = activity;
        init();
    }

    public void a(a aVar) {
        this.fSP = aVar;
    }

    public void b(f fVar) {
        this.bkg = fVar;
    }

    public CommonWebLayout bsc() {
        return this.bjK;
    }

    public void show(String str) {
        DX();
        show();
        this.bjK.loadUrl(str);
        ShowUtil.windowCount++;
    }

    private void init() {
        EF();
        initView();
        xT();
    }

    private void EF() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) this.clq.getSystemService("window");
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
        float dimensionPixelOffset = this.clq.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        this.fSQ = new RoundRectRelativeLayout(this.clq);
        this.fSQ.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        initWebView();
        bAV();
        setContentView(this.fSQ);
    }

    private void initWebView() {
        this.bjK = new CommonWebLayout(this.clq);
        this.bjK.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.f.b.1
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fQ(String str) {
                if (b.this.bjL != null) {
                    b.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                if (b.this.bjL != null) {
                    b.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void JC() {
                if (b.this.bjL != null) {
                    b.this.bjL.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean a(String str, JsResult jsResult) {
                if (b.this.fSP != null) {
                    return b.this.fSP.a(str, jsResult);
                }
                return true;
            }
        });
        g gVar = new g();
        gVar.u(this.clq).a(this.bkg).a(this.bjK.getSchemeCallback());
        com.baidu.live.view.web.a[] JF = gVar.JF();
        for (com.baidu.live.view.web.a aVar : JF) {
            this.bjK.addJavascriptInterface(aVar, aVar.getName());
        }
        this.fSQ.addView(this.bjK, new ViewGroup.LayoutParams(-1, -1));
    }

    private void bAV() {
        this.bjL = LayoutInflater.from(this.clq).inflate(a.h.live_commerce_web_goods_progress, (ViewGroup) null);
        this.fSQ.addView(this.bjL, new ViewGroup.LayoutParams(-1, -1));
    }

    private void xT() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.f.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bjK != null) {
                    b.this.bjK.release();
                }
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void DX() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        if (this.fSQ != null) {
            this.fSQ.startAnimation(translateAnimation);
        }
    }
}
