package com.baidu.tieba.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class b implements a.b {
    private final /* synthetic */ int bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        this.bab = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        a.Oe();
        String str = "";
        if (this.bab == 1) {
            str = "c11568";
        } else if (this.bab == 2) {
            str = "c11572";
        } else if (this.bab == 3) {
            str = "c11576";
        }
        TiebaStatic.log(str);
    }
}
