package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0055a {
    final /* synthetic */ e azr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.azr = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0055a
    public void eC(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.azr;
        i2 = eVar.azo;
        eVar.azo = i2 + 1;
        i3 = this.azr.azj;
        i4 = this.azr.azo;
        if (i3 == i4) {
            aVar = this.azr.azm;
            aVar.a((a.InterfaceC0055a) null);
            aVar2 = this.azr.azm;
            aVar2.stop();
            this.azr.Eq();
        }
        this.azr.eD(i);
    }
}
