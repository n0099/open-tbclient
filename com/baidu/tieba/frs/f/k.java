package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class k implements a.b {
    final /* synthetic */ i cpK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cpK = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
