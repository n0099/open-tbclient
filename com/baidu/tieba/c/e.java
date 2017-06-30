package com.baidu.tieba.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class e implements a.b {
    private final /* synthetic */ a.InterfaceC0061a bxJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.InterfaceC0061a interfaceC0061a) {
        this.bxJ = interfaceC0061a;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.bxJ != null) {
            this.bxJ.Uz();
        }
        TiebaStatic.log("c11574");
    }
}
