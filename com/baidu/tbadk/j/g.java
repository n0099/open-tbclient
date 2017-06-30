package com.baidu.tbadk.j;

import com.baidu.tbadk.j.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0050a {
    final /* synthetic */ e aHi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aHi = eVar;
    }

    @Override // com.baidu.tbadk.j.a.InterfaceC0050a
    public void fa(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aHi;
        i2 = eVar.aHf;
        eVar.aHf = i2 + 1;
        i3 = this.aHi.aHa;
        i4 = this.aHi.aHf;
        if (i3 == i4) {
            aVar = this.aHi.aHd;
            aVar.a((a.InterfaceC0050a) null);
            aVar2 = this.aHi.aHd;
            aVar2.stop();
            this.aHi.FP();
        }
        this.aHi.fb(i);
    }
}
