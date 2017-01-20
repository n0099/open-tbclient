package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ String aat;
    final /* synthetic */ u aqr;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.aqr = uVar;
        this.aqv = aVar;
        this.aat = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqv.dismiss();
        this.aqr.eQ(this.aat);
    }
}
