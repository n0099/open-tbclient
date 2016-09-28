package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0048a {
    final /* synthetic */ e aBq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aBq = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0048a
    public void fa(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aBq;
        i2 = eVar.aBn;
        eVar.aBn = i2 + 1;
        i3 = this.aBq.aBi;
        i4 = this.aBq.aBn;
        if (i3 == i4) {
            aVar = this.aBq.aBl;
            aVar.a((a.InterfaceC0048a) null);
            aVar2 = this.aBq.aBl;
            aVar2.stop();
            this.aBq.Gc();
        }
        this.aBq.fb(i);
    }
}
