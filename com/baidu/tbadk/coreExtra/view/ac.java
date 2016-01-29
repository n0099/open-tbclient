package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqA;
    final /* synthetic */ u aqx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.aqx = uVar;
        this.aqA = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqA.dismiss();
    }
}
