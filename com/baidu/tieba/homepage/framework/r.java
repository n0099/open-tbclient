package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.homepage.personalize.b.g;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements g.a {
    final /* synthetic */ q coJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.coJ = qVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.b.g.a
    public void b(long j, DataRes dataRes, boolean z) {
        q.a aVar;
        q.a aVar2;
        aVar = this.coJ.coa;
        if (aVar != null) {
            aVar2 = this.coJ.coa;
            aVar2.a(j, dataRes, z);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.b.g.a
    public void a(long j, int i, String str) {
        q.a aVar;
        q.a aVar2;
        aVar = this.coJ.coa;
        if (aVar != null) {
            aVar2 = this.coJ.coa;
            aVar2.a(j, "", str, i, false);
        }
    }
}
