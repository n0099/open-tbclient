package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0056a {
    final /* synthetic */ e aAX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aAX = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0056a
    public void fe(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aAX;
        i2 = eVar.aAU;
        eVar.aAU = i2 + 1;
        i3 = this.aAX.aAP;
        i4 = this.aAX.aAU;
        if (i3 == i4) {
            aVar = this.aAX.aAS;
            aVar.a((a.InterfaceC0056a) null);
            aVar2 = this.aAX.aAS;
            aVar2.stop();
            this.aAX.GI();
        }
        this.aAX.ff(i);
    }
}
