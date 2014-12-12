package com.baidu.tieba.im.floatwindow.view;

import android.graphics.Point;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.floatwindow.a.e {
    final /* synthetic */ a aYg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aYg = aVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.a.e
    public void Nj() {
        e eVar;
        e eVar2;
        this.aYg.aYd = false;
        this.aYg.setTouchable(true);
        eVar = this.aYg.aXo;
        if (eVar != null) {
            eVar2 = this.aYg.aXo;
            eVar2.Nj();
        }
    }

    @Override // com.baidu.tieba.im.floatwindow.a.e
    public void a(Point point) {
        int i;
        a aVar = this.aYg;
        i = this.aYg.aXw;
        aVar.U(i - point.x, point.y);
    }
}
