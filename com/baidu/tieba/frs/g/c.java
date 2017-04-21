package com.baidu.tieba.frs.g;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b ccT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ccT = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.ccT.ccS;
        popupWindow = aVar.ccQ;
        if (popupWindow != null) {
            aVar2 = this.ccT.ccS;
            aVar2.aez();
        }
    }
}
