package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class i implements a.b {
    final /* synthetic */ h aRj;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a apI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.aRj = hVar;
        this.apI = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.apI.dismiss();
    }
}
