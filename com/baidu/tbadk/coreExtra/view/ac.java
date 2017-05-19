package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ String afq;
    final /* synthetic */ u awi;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a awm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.awi = uVar;
        this.awm = aVar;
        this.afq = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.awm.dismiss();
        this.awi.eK(this.afq);
    }
}
