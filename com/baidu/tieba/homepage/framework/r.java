package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements RecPersonalizePageModel.a {
    final /* synthetic */ q cwJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cwJ = qVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
    public void b(long j, DataRes dataRes, boolean z) {
        q.a aVar;
        q.a aVar2;
        aVar = this.cwJ.cvv;
        if (aVar != null) {
            aVar2 = this.cwJ.cvv;
            aVar2.a(j, dataRes, z);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
    public void a(long j, int i, String str) {
        q.a aVar;
        q.a aVar2;
        aVar = this.cwJ.cvv;
        if (aVar != null) {
            aVar2 = this.cwJ.cvv;
            aVar2.a(j, "", str, i, false);
        }
    }
}
