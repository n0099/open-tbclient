package com.baidu.tieba.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class e implements a.b {
    private final /* synthetic */ a.InterfaceC0054a bsJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.InterfaceC0054a interfaceC0054a) {
        this.bsJ = interfaceC0054a;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.bsJ != null) {
            this.bsJ.Tq();
        }
        TiebaStatic.log("c11574");
    }
}
