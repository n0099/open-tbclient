package com.baidu.tieba.frs.g;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class k implements a.b {
    final /* synthetic */ i cdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cdM = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
