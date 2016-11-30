package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ String abQ;
    final /* synthetic */ u arI;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a arM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.arI = uVar;
        this.arM = aVar;
        this.abQ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.arM.dismiss();
        this.arI.eX(this.abQ);
    }
}
