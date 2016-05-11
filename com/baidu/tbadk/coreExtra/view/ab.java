package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ab implements a.b {
    private final /* synthetic */ String Xp;
    final /* synthetic */ u amC;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.amC = uVar;
        this.amF = aVar;
        this.Xp = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.amF.dismiss();
        this.amC.eN(this.Xp);
    }
}
