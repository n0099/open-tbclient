package com.baidu.tbadk.j;

import com.baidu.tbadk.j.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0044a {
    final /* synthetic */ e aGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aGd = eVar;
    }

    @Override // com.baidu.tbadk.j.a.InterfaceC0044a
    public void fb(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aGd;
        i2 = eVar.aGa;
        eVar.aGa = i2 + 1;
        i3 = this.aGd.aFV;
        i4 = this.aGd.aGa;
        if (i3 == i4) {
            aVar = this.aGd.aFY;
            aVar.a((a.InterfaceC0044a) null);
            aVar2 = this.aGd.aFY;
            aVar2.stop();
            this.aGd.Gu();
        }
        this.aGd.fc(i);
    }
}
