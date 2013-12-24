package com.baidu.tieba.im.a;

import com.baidu.tieba.im.message.bp;
import com.baidu.tieba.im.message.n;
import com.baidu.tieba.im.messageCenter.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements g {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(n nVar) {
        e eVar;
        e eVar2;
        int i;
        int i2;
        if (nVar instanceof bp) {
            bp bpVar = (bp) nVar;
            if (!bpVar.i()) {
                this.a.c = bpVar.a();
                this.a.d = bpVar.b();
                if (nVar.t() == 103011) {
                    a.a = false;
                } else if (nVar.t() == -114) {
                    this.a.a();
                }
                eVar = this.a.e;
                if (eVar != null) {
                    eVar2 = this.a.e;
                    i = this.a.c;
                    i2 = this.a.d;
                    eVar2.a(i, i2);
                }
            }
        }
    }
}
