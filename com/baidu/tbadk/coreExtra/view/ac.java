package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    private final /* synthetic */ String afY;
    final /* synthetic */ u awe;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a awi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.awe = uVar;
        this.awi = aVar;
        this.afY = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.awi.dismiss();
        this.awe.eL(this.afY);
    }
}
