package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0053a {
    final /* synthetic */ e awS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.awS = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0053a
    public void ew(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.awS;
        i2 = eVar.awQ;
        eVar.awQ = i2 + 1;
        i3 = this.awS.awL;
        i4 = this.awS.awQ;
        if (i3 == i4) {
            aVar = this.awS.awO;
            aVar.a((a.InterfaceC0053a) null);
            aVar2 = this.awS.awO;
            aVar2.stop();
            this.awS.DK();
        }
        this.awS.ex(i);
    }
}
