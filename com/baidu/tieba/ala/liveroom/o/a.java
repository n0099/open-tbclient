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
    public InterfaceC0651a gSb;
    public String gSc;

    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0651a {
        void onConfirm();
    }

    public abstract void en(String str, String str2);

    public abstract void initView();

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void init() {
        initView();
        Og();
    }

    private void Og() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        bXf();
    }

    public void bXf() {
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

    public void a(InterfaceC0651a interfaceC0651a) {
        this.gSb = interfaceC0651a;
    }

    public String bXg() {
        return this.gSc;
    }
}
