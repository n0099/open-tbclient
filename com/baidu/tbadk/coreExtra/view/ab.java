package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ab implements a.b {
    private final /* synthetic */ String abP;
    final /* synthetic */ u aqO;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.aqO = uVar;
        this.aqR = aVar;
        this.abP = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqR.dismiss();
        this.aqO.eQ(this.abP);
    }
}
