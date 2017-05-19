package com.baidu.tieba.frs.e;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b caG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.caG = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.caG.caF;
        popupWindow = aVar.caD;
        if (popupWindow != null) {
            aVar2 = this.caG.caF;
            aVar2.acC();
        }
    }
}
