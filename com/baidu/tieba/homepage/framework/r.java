package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements RecPersonalizePageModel.a {
    final /* synthetic */ q ctu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.ctu = qVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
    public void b(DataRes dataRes, boolean z, boolean z2) {
        q.a aVar;
        q.a aVar2;
        aVar = this.ctu.csv;
        if (aVar != null) {
            aVar2 = this.ctu.csv;
            aVar2.a(dataRes, z, z2);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
    public void z(int i, String str) {
        q.a aVar;
        q.a aVar2;
        aVar = this.ctu.csv;
        if (aVar != null) {
            aVar2 = this.ctu.csv;
            aVar2.a("", str, i, false);
        }
    }
}
