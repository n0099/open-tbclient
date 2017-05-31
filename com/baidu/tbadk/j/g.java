package com.baidu.tbadk.j;

import com.baidu.tbadk.j.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0048a {
    final /* synthetic */ e aFU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aFU = eVar;
    }

    @Override // com.baidu.tbadk.j.a.InterfaceC0048a
    public void eY(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aFU;
        i2 = eVar.aFR;
        eVar.aFR = i2 + 1;
        i3 = this.aFU.aFM;
        i4 = this.aFU.aFR;
        if (i3 == i4) {
            aVar = this.aFU.aFP;
            aVar.a((a.InterfaceC0048a) null);
            aVar2 = this.aFU.aFP;
            aVar2.stop();
            this.aFU.Fs();
        }
        this.aFU.eZ(i);
    }
}
