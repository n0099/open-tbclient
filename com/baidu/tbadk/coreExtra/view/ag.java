package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ag implements a.b {
    private final /* synthetic */ String aaJ;
    final /* synthetic */ z ami;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.ami = zVar;
        this.aml = aVar;
        this.aaJ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aml.dismiss();
        this.ami.ex(this.aaJ);
    }
}
