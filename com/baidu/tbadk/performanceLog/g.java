package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0047a {
    final /* synthetic */ e aAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aAt = eVar;
    }

    @Override // com.baidu.tbadk.performanceLog.a.InterfaceC0047a
    public void fe(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aAt;
        i2 = eVar.aAq;
        eVar.aAq = i2 + 1;
        i3 = this.aAt.aAl;
        i4 = this.aAt.aAq;
        if (i3 == i4) {
            aVar = this.aAt.aAo;
            aVar.a((a.InterfaceC0047a) null);
            aVar2 = this.aAt.aAo;
            aVar2.stop();
            this.aAt.FC();
        }
        this.aAt.ff(i);
    }
}
