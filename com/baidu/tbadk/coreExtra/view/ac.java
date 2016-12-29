package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ String abh;
    final /* synthetic */ u arl;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a arp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.arl = uVar;
        this.arp = aVar;
        this.abh = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.arp.dismiss();
        this.arl.eT(this.abh);
    }
}
