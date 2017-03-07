package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0046a {
    final /* synthetic */ e aFL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aFL = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0046a
    public void eY(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aFL;
        i2 = eVar.aFI;
        eVar.aFI = i2 + 1;
        i3 = this.aFL.aFD;
        i4 = this.aFL.aFI;
        if (i3 == i4) {
            aVar = this.aFL.aFG;
            aVar.a((a.InterfaceC0046a) null);
            aVar2 = this.aFL.aFG;
            aVar2.stop();
            this.aFL.FW();
        }
        this.aFL.eZ(i);
    }
}
