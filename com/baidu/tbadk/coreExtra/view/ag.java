package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ag implements a.b {
    private final /* synthetic */ String aaP;
    final /* synthetic */ z amo;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.amo = zVar;
        this.amr = aVar;
        this.aaP = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.amr.dismiss();
        this.amo.ex(this.aaP);
    }
}
