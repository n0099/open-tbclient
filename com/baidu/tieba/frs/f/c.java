package com.baidu.tieba.frs.f;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b bUJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bUJ = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.bUJ.bUI;
        popupWindow = aVar.bUG;
        if (popupWindow != null) {
            aVar2 = this.bUJ.bUI;
            aVar2.acD();
        }
    }
}
