package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ String afJ;
    final /* synthetic */ u avM;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a avQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.avM = uVar;
        this.avQ = aVar;
        this.afJ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.avQ.dismiss();
        this.avM.eF(this.afJ);
    }
}
