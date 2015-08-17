package com.baidu.tieba;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ c aCA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aCA = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        b bVar;
        LogoActivity logoActivity;
        LogoActivity.a aVar2;
        aVar.dismiss();
        com.baidu.adp.lib.g.h hi = com.baidu.adp.lib.g.h.hi();
        bVar = this.aCA.aCz;
        logoActivity = bVar.aCy;
        aVar2 = logoActivity.aCw;
        hi.post(aVar2);
    }
}
