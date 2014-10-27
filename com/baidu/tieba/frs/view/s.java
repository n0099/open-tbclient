package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r aGk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.aGk = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        Activity activity;
        popupWindow = this.aGk.aFl;
        if (popupWindow != null) {
            popupWindow2 = this.aGk.aFl;
            if (popupWindow2.isShowing()) {
                z = this.aGk.aFO;
                if (!z) {
                    popupWindow3 = this.aGk.aFl;
                    activity = this.aGk.aBF;
                    com.baidu.adp.lib.g.j.a(popupWindow3, activity);
                }
            }
        }
    }
}
