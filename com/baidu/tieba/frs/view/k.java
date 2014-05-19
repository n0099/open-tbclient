package com.baidu.tieba.frs.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        popupWindow = this.a.I;
        if (popupWindow != null) {
            popupWindow2 = this.a.I;
            if (popupWindow2.isShowing()) {
                z = this.a.aq;
                if (!z) {
                    popupWindow3 = this.a.I;
                    popupWindow3.dismiss();
                }
            }
        }
    }
}
