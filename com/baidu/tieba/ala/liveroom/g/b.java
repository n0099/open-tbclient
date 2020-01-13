package com.baidu.tieba.ala.liveroom.g;

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
import com.baidu.live.r.a;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.e;
import com.baidu.live.view.web.f;
/* loaded from: classes2.dex */
public class b extends Dialog {
    private CommonWebLayout aBY;
    private View aBZ;
    private e aCq;
    private a eVO;
    private RoundRectRelativeLayout eVP;
    private Activity mContext;

    /* loaded from: classes2.dex */
    public interface a {
        boolean a(String str, JsResult jsResult);
    }

    public b(@NonNull Activity activity) {
        super(activity, a.j.sdk_Transparent);
        this.mContext = activity;
        init();
    }

    public void a(a aVar) {
        this.eVO = aVar;
    }

    public void b(e eVar) {
        this.aCq = eVar;
    }

    public CommonWebLayout bbq() {
        return this.aBY;
    }

    public void show(String str) {
        vI();
        show();
        this.aBY.loadUrl(str);
        ShowUtil.windowCount++;
    }

    private void init() {
        initWindow();
        initView();
        re();
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
        this.eVP = new RoundRectRelativeLayout(this.mContext);
        this.eVP.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        initWebView();
        bjG();
        setContentView(this.eVP);
    }

    private void initWebView() {
        this.aBY = new CommonWebLayout(this.mContext);
        this.aBY.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dX(String str) {
                if (b.this.aBZ != null) {
                    b.this.aBZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                if (b.this.aBZ != null) {
                    b.this.aBZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void zh() {
                if (b.this.aBZ != null) {
                    b.this.aBZ.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean a(String str, JsResult jsResult) {
                if (b.this.eVO != null) {
                    return b.this.eVO.a(str, jsResult);
                }
                return true;
            }
        });
        f fVar = new f();
        fVar.x(this.mContext).a(this.aCq).a(this.aBY.getSchemeCallback());
        com.baidu.live.view.web.a[] zk = fVar.zk();
        for (com.baidu.live.view.web.a aVar : zk) {
            this.aBY.addJavascriptInterface(aVar, aVar.getName());
        }
        this.eVP.addView(this.aBY, new ViewGroup.LayoutParams(-1, -1));
    }

    private void bjG() {
        this.aBZ = LayoutInflater.from(this.mContext).inflate(a.h.live_commerce_web_goods_progress, (ViewGroup) null);
        this.eVP.addView(this.aBZ, new ViewGroup.LayoutParams(-1, -1));
    }

    private void re() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.g.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.aBY != null) {
                    b.this.aBY.release();
                }
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void vI() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        if (this.eVP != null) {
            this.eVP.startAnimation(translateAnimation);
        }
    }
}
