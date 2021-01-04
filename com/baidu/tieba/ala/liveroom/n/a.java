package com.baidu.tieba.ala.liveroom.n;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public abstract class a extends Dialog {
    public InterfaceC0686a hEL;
    public String hEM;

    /* renamed from: com.baidu.tieba.ala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0686a {
        void onConfirm();
    }

    public abstract void ez(String str, String str2);

    public abstract void initView();

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void init() {
        initView();
        JK();
    }

    private void JK() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        ciI();
    }

    public void ciI() {
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

    public void a(InterfaceC0686a interfaceC0686a) {
        this.hEL = interfaceC0686a;
    }

    public String ciJ() {
        return this.hEM;
    }
}
