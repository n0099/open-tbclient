package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements a.b {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        aVar.dismiss();
    }
}
