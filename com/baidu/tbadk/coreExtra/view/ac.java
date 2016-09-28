package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ String abr;
    final /* synthetic */ u aqO;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.aqO = uVar;
        this.aqS = aVar;
        this.abr = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqS.dismiss();
        this.aqO.eV(this.abr);
    }
}
