package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ab implements a.b {
    private final /* synthetic */ String XH;
    final /* synthetic */ u ani;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a anl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar, com.baidu.tbadk.core.dialog.a aVar, String str) {
        this.ani = uVar;
        this.anl = aVar;
        this.XH = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.anl.dismiss();
        this.ani.eR(this.XH);
    }
}
