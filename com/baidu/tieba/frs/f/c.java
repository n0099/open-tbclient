package com.baidu.tieba.frs.f;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cgS = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PopupWindow popupWindow;
        a aVar2;
        aVar = this.cgS.cgR;
        popupWindow = aVar.cgP;
        if (popupWindow != null) {
            aVar2 = this.cgS.cgR;
            aVar2.adF();
        }
    }
}
