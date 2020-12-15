package com.baidu.tieba.homeExtra;

import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.lego.c.e;
import com.squareup.wire.Message;
/* loaded from: classes24.dex */
class b implements com.baidu.tieba.lego.model.b {
    private c.a jIG;

    public b(c.a aVar) {
        this.jIG = aVar;
    }

    @Override // com.baidu.tieba.lego.model.b
    public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
        com.baidu.tieba.homeExtra.a.a aVar = new com.baidu.tieba.homeExtra.a.a();
        e eVar = new e();
        eVar.kWC = j;
        eVar.itemId = str;
        com.baidu.tieba.lego.c.a a2 = com.baidu.tieba.lego.d.b.dfb().a(eVar);
        if (a2 != null) {
            a2.a(z, message, z2, i);
        }
        aVar.a(a2);
        if (this.jIG != null) {
            this.jIG.a(z, aVar, z2, "", str, true);
        }
    }

    @Override // com.baidu.tieba.lego.model.b
    public void a(long j, String str, String str2, int i) {
        if (this.jIG != null) {
            this.jIG.a(str, str2, i, true, 1);
        }
    }

    @Override // com.baidu.tieba.lego.model.b
    public void a(long j, String str, Message message, boolean z) {
    }
}
