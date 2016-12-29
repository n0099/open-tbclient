package com.baidu.tieba.frs.h;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b bOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bOm = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.bOm.bOl;
        popupWindow = aVar.bOj;
        if (popupWindow != null) {
            aVar2 = this.bOm.bOl;
            aVar2.abw();
        }
    }
}
