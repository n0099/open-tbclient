package com.baidu.tieba.frs.i;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b bRA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bRA = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.bRA.bRz;
        popupWindow = aVar.bRx;
        if (popupWindow != null) {
            aVar2 = this.bRA.bRz;
            aVar2.ZQ();
        }
    }
}
