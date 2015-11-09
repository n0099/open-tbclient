package com.baidu.tieba;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ c aCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aCs = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        b bVar;
        LogoActivity logoActivity;
        LogoActivity.a aVar2;
        aVar.dismiss();
        com.baidu.adp.lib.g.h hh = com.baidu.adp.lib.g.h.hh();
        bVar = this.aCs.aCr;
        logoActivity = bVar.aCq;
        aVar2 = logoActivity.aCo;
        hh.post(aVar2);
    }
}
