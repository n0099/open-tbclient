package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0047a {
    final /* synthetic */ e axa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.axa = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0047a
    public void eJ(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.axa;
        i2 = eVar.awX;
        eVar.awX = i2 + 1;
        i3 = this.axa.awS;
        i4 = this.axa.awX;
        if (i3 == i4) {
            aVar = this.axa.awV;
            aVar.a((a.InterfaceC0047a) null);
            aVar2 = this.axa.awV;
            aVar2.stop();
            this.axa.EA();
        }
        this.axa.eK(i);
    }
}
