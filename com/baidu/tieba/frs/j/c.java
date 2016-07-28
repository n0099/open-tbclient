package com.baidu.tieba.frs.j;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b bTA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bTA = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.bTA.bTz;
        popupWindow = aVar.bTx;
        if (popupWindow != null) {
            aVar2 = this.bTA.bTz;
            aVar2.aas();
        }
    }
}
