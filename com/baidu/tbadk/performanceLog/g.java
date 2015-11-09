package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0053a {
    final /* synthetic */ e avI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.avI = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0053a
    public void eu(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.avI;
        i2 = eVar.avF;
        eVar.avF = i2 + 1;
        i3 = this.avI.avA;
        i4 = this.avI.avF;
        if (i3 == i4) {
            aVar = this.avI.avD;
            aVar.a((a.InterfaceC0053a) null);
            aVar2 = this.avI.avD;
            aVar2.stop();
            this.avI.DA();
        }
        this.avI.ev(i);
    }
}
