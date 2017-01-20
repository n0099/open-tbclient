package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ad implements a.b {
    final /* synthetic */ u aqr;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(u uVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.aqr = uVar;
        this.aqv = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqv.dismiss();
    }
}
