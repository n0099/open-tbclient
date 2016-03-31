package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    final /* synthetic */ u aqO;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.aqO = uVar;
        this.aqR = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqR.dismiss();
    }
}
