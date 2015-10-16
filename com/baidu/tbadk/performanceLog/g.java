package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0053a {
    final /* synthetic */ e awT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.awT = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0053a
    public void ew(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.awT;
        i2 = eVar.awR;
        eVar.awR = i2 + 1;
        i3 = this.awT.awM;
        i4 = this.awT.awR;
        if (i3 == i4) {
            aVar = this.awT.awP;
            aVar.a((a.InterfaceC0053a) null);
            aVar2 = this.awT.awP;
            aVar2.stop();
            this.awT.DK();
        }
        this.awT.ex(i);
    }
}
