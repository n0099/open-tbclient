package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0047a {
    final /* synthetic */ e axQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.axQ = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0047a
    public void eN(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.axQ;
        i2 = eVar.axN;
        eVar.axN = i2 + 1;
        i3 = this.axQ.axI;
        i4 = this.axQ.axN;
        if (i3 == i4) {
            aVar = this.axQ.axL;
            aVar.a((a.InterfaceC0047a) null);
            aVar2 = this.axQ.axL;
            aVar2.stop();
            this.axQ.EK();
        }
        this.axQ.eO(i);
    }
}
