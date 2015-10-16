package com.baidu.tieba;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ c aDy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aDy = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        b bVar;
        LogoActivity logoActivity;
        LogoActivity.a aVar2;
        aVar.dismiss();
        com.baidu.adp.lib.g.h hg = com.baidu.adp.lib.g.h.hg();
        bVar = this.aDy.aDx;
        logoActivity = bVar.aDw;
        aVar2 = logoActivity.aDu;
        hg.post(aVar2);
    }
}
