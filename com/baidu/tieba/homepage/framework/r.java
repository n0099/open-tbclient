package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.homepage.personalize.c.g;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements g.a {
    final /* synthetic */ q cCJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cCJ = qVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.c.g.a
    public void b(long j, DataRes dataRes, boolean z) {
        q.a aVar;
        q.a aVar2;
        aVar = this.cCJ.cCa;
        if (aVar != null) {
            aVar2 = this.cCJ.cCa;
            aVar2.a(j, dataRes, z);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.c.g.a
    public void a(long j, int i, String str) {
        q.a aVar;
        q.a aVar2;
        aVar = this.cCJ.cCa;
        if (aVar != null) {
            aVar2 = this.cCJ.cCa;
            aVar2.a(j, "", str, i, false);
        }
    }
}
