package com.baidu.tieba.frs.f;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b cpi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cpi = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.cpi.cph;
        popupWindow = aVar.cpf;
        if (popupWindow != null) {
            aVar2 = this.cpi.cph;
            aVar2.ahy();
        }
    }
}
