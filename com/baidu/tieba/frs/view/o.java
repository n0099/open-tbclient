package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        Activity activity;
        popupWindow = this.a.K;
        if (popupWindow != null) {
            popupWindow2 = this.a.K;
            if (popupWindow2.isShowing()) {
                z = this.a.aw;
                if (!z) {
                    popupWindow3 = this.a.K;
                    activity = this.a.B;
                    com.baidu.adp.lib.e.d.a(popupWindow3, activity);
                }
            }
        }
    }
}
