package com.baidu.tieba;

import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class h implements j.a {
    final /* synthetic */ g aFm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aFm = gVar;
    }

    @Override // com.baidu.tieba.j.a
    public void GJ() {
        LogoActivity logoActivity;
        LogoActivity.a aVar;
        com.baidu.adp.lib.h.h hj = com.baidu.adp.lib.h.h.hj();
        logoActivity = this.aFm.aFj;
        aVar = logoActivity.aFf;
        hj.post(aVar);
    }
}
