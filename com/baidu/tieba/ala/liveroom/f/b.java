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
    private e aGN;
    private CommonWebLayout aGv;
    private View aGw;
    private a far;
    private RoundRectRelativeLayout fas;
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
        this.far = aVar;
    }

    public void b(e eVar) {
        this.aGN = eVar;
    }

    public CommonWebLayout bdN() {
        return this.aGv;
    }

    public void show(String str) {
        xL();
        show();
        this.aGv.loadUrl(str);
        ShowUtil.windowCount++;
    }

    private void init() {
        initWindow();
        initView();
        sk();
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
        this.fas = new RoundRectRelativeLayout(this.mContext);
        this.fas.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        initWebView();
        blD();
        setContentView(this.fas);
    }

    private void initWebView() {
        this.aGv = new CommonWebLayout(this.mContext);
        this.aGv.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.f.b.1
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void el(String str) {
                if (b.this.aGw != null) {
                    b.this.aGw.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                if (b.this.aGw != null) {
                    b.this.aGw.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void BG() {
                if (b.this.aGw != null) {
                    b.this.aGw.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean a(String str, JsResult jsResult) {
                if (b.this.far != null) {
                    return b.this.far.a(str, jsResult);
                }
                return true;
            }
        });
        f fVar = new f();
        fVar.y(this.mContext).a(this.aGN).a(this.aGv.getSchemeCallback());
        com.baidu.live.view.web.a[] BJ = fVar.BJ();
        for (com.baidu.live.view.web.a aVar : BJ) {
            this.aGv.addJavascriptInterface(aVar, aVar.getName());
        }
        this.fas.addView(this.aGv, new ViewGroup.LayoutParams(-1, -1));
    }

    private void blD() {
        this.aGw = LayoutInflater.from(this.mContext).inflate(a.h.live_commerce_web_goods_progress, (ViewGroup) null);
        this.fas.addView(this.aGw, new ViewGroup.LayoutParams(-1, -1));
    }

    private void sk() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.f.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.aGv != null) {
                    b.this.aGv.release();
                }
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void xL() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        if (this.fas != null) {
            this.fas.startAnimation(translateAnimation);
        }
    }
}
