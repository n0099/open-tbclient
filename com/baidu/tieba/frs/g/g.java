package com.baidu.tieba.frs.g;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.frs.g.f;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ f.a cdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f.a aVar) {
        this.cdq = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
