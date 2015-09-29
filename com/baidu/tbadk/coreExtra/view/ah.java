package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ah implements a.b {
    final /* synthetic */ z ami;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(z zVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.ami = zVar;
        this.aml = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aml.dismiss();
    }
}
