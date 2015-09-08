package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0053a {
    final /* synthetic */ e ayt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.ayt = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0053a
    public void ev(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.ayt;
        i2 = eVar.ayr;
        eVar.ayr = i2 + 1;
        i3 = this.ayt.aym;
        i4 = this.ayt.ayr;
        if (i3 == i4) {
            aVar = this.ayt.ayp;
            aVar.a((a.InterfaceC0053a) null);
            aVar2 = this.ayt.ayp;
            aVar2.stop();
            this.ayt.DX();
        }
        this.ayt.ew(i);
    }
}
