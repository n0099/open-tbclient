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
import com.baidu.live.view.web.e;
import com.baidu.live.view.web.f;
/* loaded from: classes3.dex */
public class b extends Dialog {
    private CommonWebLayout aGf;
    private View aGg;
    private e aGx;
    private a eZF;
    private RoundRectRelativeLayout eZG;
    private Activity mContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(String str, JsResult jsResult);
    }

    public b(@NonNull Activity activity) {
        super(activity, a.j.sdk_Transparent);
        this.mContext = activity;
        init();
    }

    public void a(a aVar) {
        this.eZF = aVar;
    }

    public void b(e eVar) {
        this.aGx = eVar;
    }

    public CommonWebLayout bdF() {
        return this.aGf;
    }

    public void show(String str) {
        xG();
        show();
        this.aGf.loadUrl(str);
        ShowUtil.windowCount++;
    }

    private void init() {
        initWindow();
        initView();
        sf();
    }

    private void initWindow() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
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
        float dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        this.eZG = new RoundRectRelativeLayout(this.mContext);
        this.eZG.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        initWebView();
        blv();
        setContentView(this.eZG);
    }

    private void initWebView() {
        this.aGf = new CommonWebLayout(this.mContext);
        this.aGf.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.f.b.1
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void em(String str) {
                if (b.this.aGg != null) {
                    b.this.aGg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                if (b.this.aGg != null) {
                    b.this.aGg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void Bx() {
                if (b.this.aGg != null) {
                    b.this.aGg.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean a(String str, JsResult jsResult) {
                if (b.this.eZF != null) {
                    return b.this.eZF.a(str, jsResult);
                }
                return true;
            }
        });
        f fVar = new f();
        fVar.y(this.mContext).a(this.aGx).a(this.aGf.getSchemeCallback());
        com.baidu.live.view.web.a[] BA = fVar.BA();
        for (com.baidu.live.view.web.a aVar : BA) {
            this.aGf.addJavascriptInterface(aVar, aVar.getName());
        }
        this.eZG.addView(this.aGf, new ViewGroup.LayoutParams(-1, -1));
    }

    private void blv() {
        this.aGg = LayoutInflater.from(this.mContext).inflate(a.h.live_commerce_web_goods_progress, (ViewGroup) null);
        this.eZG.addView(this.aGg, new ViewGroup.LayoutParams(-1, -1));
    }

    private void sf() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.f.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.aGf != null) {
                    b.this.aGf.release();
                }
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void xG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        if (this.eZG != null) {
            this.eZG.startAnimation(translateAnimation);
        }
    }
}
