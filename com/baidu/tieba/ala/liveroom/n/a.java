package com.baidu.tieba.ala.liveroom.n;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public abstract class a extends Dialog {
    public InterfaceC0694a hsO;
    public String hsP;

    /* renamed from: com.baidu.tieba.ala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0694a {
        void onConfirm();
    }

    public abstract void eA(String str, String str2);

    public abstract void initView();

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void init() {
        initView();
        Ki();
    }

    private void Ki() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        cfR();
    }

    public void cfR() {
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

    public void a(InterfaceC0694a interfaceC0694a) {
        this.hsO = interfaceC0694a;
    }

    public String cfS() {
        return this.hsP;
    }
}
