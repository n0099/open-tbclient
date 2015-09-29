package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class i implements a.b {
    final /* synthetic */ h aJK;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.aJK = hVar;
        this.aml = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aml.dismiss();
    }
}
