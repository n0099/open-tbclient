package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ab implements a.b {
    private final /* synthetic */ String acC;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqA;
    final /* synthetic */ u aqx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.aqx = uVar;
        this.aqA = aVar;
        this.acC = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqA.dismiss();
        this.aqx.eJ(this.acC);
    }
}
