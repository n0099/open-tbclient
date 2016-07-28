package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ab implements a.b {
    private final /* synthetic */ String Yq;
    final /* synthetic */ u anX;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aoa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.anX = uVar;
        this.aoa = aVar;
        this.Yq = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.aoa.dismiss();
        this.anX.eP(this.Yq);
    }
}
