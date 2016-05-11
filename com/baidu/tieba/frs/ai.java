package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        aVar.dismiss();
    }
}
