package com.baidu.tbadk.editortools.pb;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ c aBW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.aBW = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aBW.b(0, true, null);
        aVar.dismiss();
    }
}
