package com.baidu.tieba.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class e implements a.b {
    private final /* synthetic */ a.InterfaceC0058a btg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.InterfaceC0058a interfaceC0058a) {
        this.btg = interfaceC0058a;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.btg != null) {
            this.btg.SL();
        }
        TiebaStatic.log("c11574");
    }
}
