package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ac implements a.b {
    final /* synthetic */ u ani;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a anl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.ani = uVar;
        this.anl = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.anl.dismiss();
    }
}
