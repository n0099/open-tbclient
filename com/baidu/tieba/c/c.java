package com.baidu.tieba.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class c implements a.b {
    private final /* synthetic */ int bsI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        this.bsI = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String str = "";
        if (this.bsI == 1) {
            str = "c11569";
        } else if (this.bsI == 2) {
            str = "c11573";
        } else if (this.bsI == 3) {
            str = "c11575";
        }
        TiebaStatic.log(str);
    }
}
