package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ String afh;
    final /* synthetic */ u avS;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a avW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.avS = uVar;
        this.avW = aVar;
        this.afh = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.avW.dismiss();
        this.avS.eI(this.afh);
    }
}
