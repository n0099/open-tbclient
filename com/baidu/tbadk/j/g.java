package com.baidu.tbadk.j;

import com.baidu.tbadk.j.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0044a {
    final /* synthetic */ e aGb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aGb = eVar;
    }

    @Override // com.baidu.tbadk.j.a.InterfaceC0044a
    public void fb(int i) {
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        e eVar = this.aGb;
        i2 = eVar.aFY;
        eVar.aFY = i2 + 1;
        i3 = this.aGb.aFT;
        i4 = this.aGb.aFY;
        if (i3 == i4) {
            aVar = this.aGb.aFW;
            aVar.a((a.InterfaceC0044a) null);
            aVar2 = this.aGb.aFW;
            aVar2.stop();
            this.aGb.Gu();
        }
        this.aGb.fc(i);
    }
}
