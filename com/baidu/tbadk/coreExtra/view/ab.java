package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ab implements a.b {
    private final /* synthetic */ String abe;
    final /* synthetic */ u are;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a arh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.are = uVar;
        this.arh = aVar;
        this.abe = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.arh.dismiss();
        this.are.eS(this.abe);
    }
}
