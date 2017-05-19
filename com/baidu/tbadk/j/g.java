package com.baidu.tbadk.j;

import com.baidu.tbadk.j.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0048a {
    final /* synthetic */ e aGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aGh = eVar;
    }

    @Override // com.baidu.tbadk.j.a.InterfaceC0048a
    public void eX(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aGh;
        i2 = eVar.aGe;
        eVar.aGe = i2 + 1;
        i3 = this.aGh.aFZ;
        i4 = this.aGh.aGe;
        if (i3 == i4) {
            aVar = this.aGh.aGc;
            aVar.a((a.InterfaceC0048a) null);
            aVar2 = this.aGh.aGc;
            aVar2.stop();
            this.aGh.Fy();
        }
        this.aGh.eY(i);
    }
}
