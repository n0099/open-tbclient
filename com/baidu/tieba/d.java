package com.baidu.tieba;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ c aDn;
    private final /* synthetic */ String aDo;
    private final /* synthetic */ String aDp;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, String str3) {
        this.aDn = cVar;
        this.aDo = str;
        this.val$url = str2;
        this.aDp = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        b bVar;
        LogoActivity logoActivity;
        LogoActivity.a aVar2;
        aVar.dismiss();
        com.baidu.adp.lib.g.h hg = com.baidu.adp.lib.g.h.hg();
        bVar = this.aDn.aDm;
        logoActivity = bVar.aDl;
        aVar2 = logoActivity.aDj;
        hg.post(aVar2);
        com.baidu.tbadk.download.b.An().a(this.aDo, this.val$url, this.aDp, 0, 1111);
    }
}
