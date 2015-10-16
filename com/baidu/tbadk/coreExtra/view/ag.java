package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ag implements a.b {
    private final /* synthetic */ String aaL;
    final /* synthetic */ z amj;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.amj = zVar;
        this.amm = aVar;
        this.aaL = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.amm.dismiss();
        this.amj.ex(this.aaL);
    }
}
