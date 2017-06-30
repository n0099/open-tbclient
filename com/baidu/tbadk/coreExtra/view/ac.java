package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ String afP;
    final /* synthetic */ u awV;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a awZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.awV = uVar;
        this.awZ = aVar;
        this.afP = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.awZ.dismiss();
        this.awV.fc(this.afP);
    }
}
