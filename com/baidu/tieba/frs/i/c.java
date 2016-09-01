package com.baidu.tieba.frs.i;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b ceI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ceI = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.ceI.ceH;
        popupWindow = aVar.ceF;
        if (popupWindow != null) {
            aVar2 = this.ceI.ceH;
            aVar2.afd();
        }
    }
}
