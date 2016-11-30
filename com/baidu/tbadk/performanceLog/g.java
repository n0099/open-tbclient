package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0048a {
    final /* synthetic */ e aCh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aCh = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0048a
    public void fd(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aCh;
        i2 = eVar.aCe;
        eVar.aCe = i2 + 1;
        i3 = this.aCh.aBZ;
        i4 = this.aCh.aCe;
        if (i3 == i4) {
            aVar = this.aCh.aCc;
            aVar.a((a.InterfaceC0048a) null);
            aVar2 = this.aCh.aCc;
            aVar2.stop();
            this.aCh.Gi();
        }
        this.aCh.fe(i);
    }
}
