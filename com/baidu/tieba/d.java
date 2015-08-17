package com.baidu.tieba;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ c aCA;
    private final /* synthetic */ String aCB;
    private final /* synthetic */ String aCC;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, String str3) {
        this.aCA = cVar;
        this.aCB = str;
        this.val$url = str2;
        this.aCC = str3;
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
        com.baidu.tbadk.download.b.Ap().a(this.aCB, this.val$url, this.aCC, 0, 1111);
    }
}
