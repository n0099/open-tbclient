package com.baidu.tieba;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ c aEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aEi = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        b bVar;
        LogoActivity logoActivity;
        LogoActivity.a aVar2;
        aVar.dismiss();
        com.baidu.adp.lib.g.h hf = com.baidu.adp.lib.g.h.hf();
        bVar = this.aEi.aEh;
        logoActivity = bVar.aEg;
        aVar2 = logoActivity.aEe;
        hf.post(aVar2);
    }
}
