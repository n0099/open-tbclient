package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0053a {
    final /* synthetic */ e awL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.awL = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0053a
    public void en(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.awL;
        i2 = eVar.awJ;
        eVar.awJ = i2 + 1;
        i3 = this.awL.awE;
        i4 = this.awL.awJ;
        if (i3 == i4) {
            aVar = this.awL.awH;
            aVar.a((a.InterfaceC0053a) null);
            aVar2 = this.awL.awH;
            aVar2.stop();
            this.awL.DN();
        }
        this.awL.eo(i);
    }
}
