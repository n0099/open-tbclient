package com.baidu.tieba.im.floatwindow.view;

import android.graphics.Point;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.floatwindow.a.e {
    final /* synthetic */ a aZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aZB = aVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.a.e
    public void NA() {
        e eVar;
        e eVar2;
        this.aZB.aZy = false;
        this.aZB.setTouchable(true);
        eVar = this.aZB.aYJ;
        if (eVar != null) {
            eVar2 = this.aZB.aYJ;
            eVar2.NA();
        }
    }

    @Override // com.baidu.tieba.im.floatwindow.a.e
    public void a(Point point) {
        int i;
        a aVar = this.aZB;
        i = this.aZB.aYR;
        aVar.W(i - point.x, point.y);
    }
}
