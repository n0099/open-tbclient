package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ String afX;
    final /* synthetic */ u awc;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a awg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.awc = uVar;
        this.awg = aVar;
        this.afX = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.awg.dismiss();
        this.awc.eL(this.afX);
    }
}
