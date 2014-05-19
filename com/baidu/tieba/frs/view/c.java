package com.baidu.tieba.frs.view;

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
        popupWindow = this.a.x;
        if (popupWindow != null) {
            popupWindow2 = this.a.x;
            if (popupWindow2.isShowing()) {
                z = this.a.al;
                if (!z) {
                    popupWindow3 = this.a.x;
                    popupWindow3.dismiss();
                }
            }
        }
    }
}
