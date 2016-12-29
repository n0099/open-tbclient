package com.baidu.tieba.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class e implements a.b {
    private final /* synthetic */ a.InterfaceC0056a bac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.InterfaceC0056a interfaceC0056a) {
        this.bac = interfaceC0056a;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.bac != null) {
            this.bac.Of();
        }
        TiebaStatic.log("c11574");
    }
}
