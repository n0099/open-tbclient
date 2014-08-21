package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ FrsHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsHeaderView frsHeaderView) {
        this.a = frsHeaderView;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        Activity activity;
        popupWindow = this.a.A;
        if (popupWindow != null) {
            popupWindow2 = this.a.A;
            if (popupWindow2.isShowing()) {
                z = this.a.ap;
                if (!z) {
                    popupWindow3 = this.a.A;
                    activity = this.a.E;
                    com.baidu.adp.lib.e.e.a(popupWindow3, activity);
                }
            }
        }
    }
}
