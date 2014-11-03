package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ FrsHeaderView aGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsHeaderView frsHeaderView) {
        this.aGd = frsHeaderView;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        Activity activity;
        popupWindow = this.aGd.aFv;
        if (popupWindow != null) {
            popupWindow2 = this.aGd.aFv;
            if (popupWindow2.isShowing()) {
                z = this.aGd.aFY;
                if (!z) {
                    popupWindow3 = this.aGd.aFv;
                    activity = this.aGd.aBP;
                    com.baidu.adp.lib.g.j.a(popupWindow3, activity);
                }
            }
        }
    }
}
