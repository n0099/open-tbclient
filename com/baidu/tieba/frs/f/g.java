package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.frs.f.f;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ f.a bVg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f.a aVar) {
        this.bVg = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
