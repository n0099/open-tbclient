package com.baidu.tieba.frs.h;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class q implements a.b {
    final /* synthetic */ i bPb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(i iVar) {
        this.bPb = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
