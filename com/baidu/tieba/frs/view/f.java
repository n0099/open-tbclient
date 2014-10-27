package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ FrsHeaderView aFT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsHeaderView frsHeaderView) {
        this.aFT = frsHeaderView;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        boolean z;
        PopupWindow popupWindow3;
        Activity activity;
        popupWindow = this.aFT.aFl;
        if (popupWindow != null) {
            popupWindow2 = this.aFT.aFl;
            if (popupWindow2.isShowing()) {
                z = this.aFT.aFO;
                if (!z) {
                    popupWindow3 = this.aFT.aFl;
                    activity = this.aFT.aBF;
                    com.baidu.adp.lib.g.j.a(popupWindow3, activity);
                }
            }
        }
    }
}
