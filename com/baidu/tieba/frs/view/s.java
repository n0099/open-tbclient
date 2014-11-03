package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r aGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.aGu = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        Activity activity;
        popupWindow = this.aGu.aFv;
        if (popupWindow != null) {
            popupWindow2 = this.aGu.aFv;
            if (popupWindow2.isShowing()) {
                z = this.aGu.aFY;
                if (!z) {
                    popupWindow3 = this.aGu.aFv;
                    activity = this.aGu.aBP;
                    com.baidu.adp.lib.g.j.a(popupWindow3, activity);
                }
            }
        }
    }
}
