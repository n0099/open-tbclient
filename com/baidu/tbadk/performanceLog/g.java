package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0048a {
    final /* synthetic */ e aBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aBB = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0048a
    public void fd(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aBB;
        i2 = eVar.aBy;
        eVar.aBy = i2 + 1;
        i3 = this.aBB.aBt;
        i4 = this.aBB.aBy;
        if (i3 == i4) {
            aVar = this.aBB.aBw;
            aVar.a((a.InterfaceC0048a) null);
            aVar2 = this.aBB.aBw;
            aVar2.stop();
            this.aBB.FI();
        }
        this.aBB.fe(i);
    }
}
