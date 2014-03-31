package com.baidu.tieba.frs.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Runnable {
    final /* synthetic */ FrsHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsHeaderView frsHeaderView) {
        this.a = frsHeaderView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PopupWindow popupWindow;
        popupWindow = this.a.x;
        popupWindow.dismiss();
    }
}
