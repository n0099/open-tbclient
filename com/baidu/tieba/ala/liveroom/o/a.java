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
    public InterfaceC0667a hdO;
    public String hdP;

    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0667a {
        void onConfirm();
    }

    public abstract void eu(String str, String str2);

    public abstract void initView();

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void init() {
        initView();
        OE();
    }

    private void OE() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        cae();
    }

    public void cae() {
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

    public void a(InterfaceC0667a interfaceC0667a) {
        this.hdO = interfaceC0667a;
    }

    public String caf() {
        return this.hdP;
    }
}
