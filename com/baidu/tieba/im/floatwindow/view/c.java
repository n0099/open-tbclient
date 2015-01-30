package com.baidu.tieba.im.floatwindow.view;

import android.graphics.Point;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.floatwindow.a.e {
    final /* synthetic */ a aZC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aZC = aVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.a.e
    public void NF() {
        e eVar;
        e eVar2;
        this.aZC.aZz = false;
        this.aZC.setTouchable(true);
        eVar = this.aZC.aYK;
        if (eVar != null) {
            eVar2 = this.aZC.aYK;
            eVar2.NF();
        }
    }

    @Override // com.baidu.tieba.im.floatwindow.a.e
    public void a(Point point) {
        int i;
        a aVar = this.aZC;
        i = this.aZC.aYS;
        aVar.V(i - point.x, point.y);
    }
}
