package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0056a {
    final /* synthetic */ e aAi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aAi = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0056a
    public void eW(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aAi;
        i2 = eVar.aAf;
        eVar.aAf = i2 + 1;
        i3 = this.aAi.aAa;
        i4 = this.aAi.aAf;
        if (i3 == i4) {
            aVar = this.aAi.aAd;
            aVar.a((a.InterfaceC0056a) null);
            aVar2 = this.aAi.aAd;
            aVar2.stop();
            this.aAi.FL();
        }
        this.aAi.eX(i);
    }
}
