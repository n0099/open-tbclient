package com.baidu.tieba.homeExtra;

import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.lego.c.e;
import com.squareup.wire.Message;
/* loaded from: classes8.dex */
class b implements com.baidu.tieba.lego.model.b {
    private c.a jYN;

    public b(c.a aVar) {
        this.jYN = aVar;
    }

    @Override // com.baidu.tieba.lego.model.b
    public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
        com.baidu.tieba.homeExtra.a.a aVar = new com.baidu.tieba.homeExtra.a.a();
        e eVar = new e();
        eVar.lfE = j;
        eVar.itemId = str;
        com.baidu.tieba.lego.c.a a2 = com.baidu.tieba.lego.d.b.dcT().a(eVar);
        if (a2 != null) {
            a2.a(z, message, z2, i);
        }
        aVar.a(a2);
        if (this.jYN != null) {
            this.jYN.a(z, aVar, z2, "", str, true);
        }
    }

    @Override // com.baidu.tieba.lego.model.b
    public void a(long j, String str, String str2, int i) {
        if (this.jYN != null) {
            this.jYN.a(str, str2, i, true, 1);
        }
    }

    @Override // com.baidu.tieba.lego.model.b
    public void a(long j, String str, Message message, boolean z) {
    }
}
