package com.baidu.tbadk.editortools.d;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ e asC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.asC = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.asC.a(0, true, (String) null);
        aVar.dismiss();
    }
}
