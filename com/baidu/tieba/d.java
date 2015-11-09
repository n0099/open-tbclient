package com.baidu.tieba;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ c aCs;
    private final /* synthetic */ String aCt;
    private final /* synthetic */ String aCu;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, String str3) {
        this.aCs = cVar;
        this.aCt = str;
        this.val$url = str2;
        this.aCu = str3;
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
        com.baidu.tbadk.download.b.Ap().a(this.aCt, this.val$url, this.aCu, 0, 1111);
    }
}
