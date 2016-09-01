package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0048a {
    final /* synthetic */ e aBN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aBN = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0048a
    public void fb(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aBN;
        i2 = eVar.aBK;
        eVar.aBK = i2 + 1;
        i3 = this.aBN.aBF;
        i4 = this.aBN.aBK;
        if (i3 == i4) {
            aVar = this.aBN.aBI;
            aVar.a((a.InterfaceC0048a) null);
            aVar2 = this.aBN.aBI;
            aVar2.stop();
            this.aBN.Gd();
        }
        this.aBN.fc(i);
    }
}
