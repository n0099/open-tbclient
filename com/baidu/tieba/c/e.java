package com.baidu.tieba.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class e implements a.b {
    private final /* synthetic */ a.InterfaceC0055a bqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.InterfaceC0055a interfaceC0055a) {
        this.bqz = interfaceC0055a;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.bqz != null) {
            this.bqz.RQ();
        }
        TiebaStatic.log("c11574");
    }
}
