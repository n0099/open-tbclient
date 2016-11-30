package com.baidu.tieba.frs.j;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b cjg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cjg = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.cjg.cjf;
        popupWindow = aVar.cjd;
        if (popupWindow != null) {
            aVar2 = this.cjg.cjf;
            aVar2.ahb();
        }
    }
}
