package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ag implements a.b {
    private final /* synthetic */ String abC;
    final /* synthetic */ z aob;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aoe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.aob = zVar;
        this.aoe = aVar;
        this.abC = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aoe.dismiss();
        this.aob.eH(this.abC);
    }
}
