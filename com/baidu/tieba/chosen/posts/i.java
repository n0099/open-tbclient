package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class i implements a.b {
    final /* synthetic */ h aJV;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.aJV = hVar;
        this.amm = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.amm.dismiss();
    }
}
