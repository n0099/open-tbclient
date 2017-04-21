package com.baidu.tieba.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class b implements a.b {
    private final /* synthetic */ int bsI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        this.bsI = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        a.Tp();
        String str = "";
        if (this.bsI == 1) {
            str = "c11568";
        } else if (this.bsI == 2) {
            str = "c11572";
        } else if (this.bsI == 3) {
            str = "c11576";
        }
        TiebaStatic.log(str);
    }
}
