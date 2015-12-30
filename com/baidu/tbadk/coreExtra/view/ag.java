package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ag implements a.b {
    private final /* synthetic */ String acg;
    final /* synthetic */ z apF;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a apI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.apF = zVar;
        this.apI = aVar;
        this.acg = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.apI.dismiss();
        this.apF.eK(this.acg);
    }
}
