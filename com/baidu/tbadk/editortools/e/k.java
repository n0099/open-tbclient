package com.baidu.tbadk.editortools.e;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ e awb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.awb = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.awb.b(0, true, null);
        aVar.dismiss();
    }
}
