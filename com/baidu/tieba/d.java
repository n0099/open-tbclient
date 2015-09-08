package com.baidu.tieba;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ c aEi;
    private final /* synthetic */ String aEj;
    private final /* synthetic */ String aEk;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, String str3) {
        this.aEi = cVar;
        this.aEj = str;
        this.val$url = str2;
        this.aEk = str3;
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
        com.baidu.tbadk.download.b.AC().a(this.aEj, this.val$url, this.aEk, 0, 1111);
    }
}
