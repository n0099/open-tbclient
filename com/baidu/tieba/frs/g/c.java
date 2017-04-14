package com.baidu.tieba.frs.g;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b caC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.caC = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.caC.caB;
        popupWindow = aVar.caz;
        if (popupWindow != null) {
            aVar2 = this.caC.caB;
            aVar2.ady();
        }
    }
}
