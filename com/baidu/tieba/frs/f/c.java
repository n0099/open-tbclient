package com.baidu.tieba.frs.f;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b ccb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ccb = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.ccb.cca;
        popupWindow = aVar.cbY;
        if (popupWindow != null) {
            aVar2 = this.ccb.cca;
            aVar2.adD();
        }
    }
}
