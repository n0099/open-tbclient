package com.baidu.tbadk.editortools.d;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ e awy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.awy = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.awy.b(0, true, null);
        aVar.dismiss();
    }
}
