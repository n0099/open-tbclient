package com.baidu.tieba.ala.liveroom.o;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public abstract class a extends Dialog {
    public InterfaceC0681a hjK;
    public String hjL;

    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0681a {
        void onConfirm();
    }

    public abstract void eu(String str, String str2);

    public abstract void initView();

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void init() {
        initView();
        Pe();
    }

    private void Pe() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        ccG();
    }

    public void ccG() {
        show();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = displayMetrics.widthPixels;
                attributes.height = displayMetrics.heightPixels;
                window.setAttributes(attributes);
            }
        }
    }

    public void a(InterfaceC0681a interfaceC0681a) {
        this.hjK = interfaceC0681a;
    }

    public String ccH() {
        return this.hjL;
    }
}
