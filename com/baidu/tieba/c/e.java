package com.baidu.tieba.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class e implements a.b {
    private final /* synthetic */ a.InterfaceC0058a buo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.InterfaceC0058a interfaceC0058a) {
        this.buo = interfaceC0058a;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.buo != null) {
            this.buo.SX();
        }
        TiebaStatic.log("c11574");
    }
}
