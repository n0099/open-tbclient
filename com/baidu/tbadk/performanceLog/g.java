package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0055a {
    final /* synthetic */ e axN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.axN = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0055a
    public void eI(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.axN;
        i2 = eVar.axK;
        eVar.axK = i2 + 1;
        i3 = this.axN.axF;
        i4 = this.axN.axK;
        if (i3 == i4) {
            aVar = this.axN.axI;
            aVar.a((a.InterfaceC0055a) null);
            aVar2 = this.axN.axI;
            aVar2.stop();
            this.axN.EB();
        }
        this.axN.eJ(i);
    }
}
