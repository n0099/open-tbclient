package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0048a {
    final /* synthetic */ e ayG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.ayG = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0048a
    public void eN(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.ayG;
        i2 = eVar.ayD;
        eVar.ayD = i2 + 1;
        i3 = this.ayG.ayy;
        i4 = this.ayG.ayD;
        if (i3 == i4) {
            aVar = this.ayG.ayB;
            aVar.a((a.InterfaceC0048a) null);
            aVar2 = this.ayG.ayB;
            aVar2.stop();
            this.ayG.EJ();
        }
        this.ayG.eO(i);
    }
}
