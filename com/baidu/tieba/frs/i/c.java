package com.baidu.tieba.frs.i;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b ceH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ceH = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.ceH.ceG;
        popupWindow = aVar.ceE;
        if (popupWindow != null) {
            aVar2 = this.ceH.ceG;
            aVar2.afr();
        }
    }
}
