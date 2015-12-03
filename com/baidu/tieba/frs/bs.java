package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements a.b {
    final /* synthetic */ bo bbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bo boVar) {
        this.bbR = boVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        List list;
        List list2;
        list = this.bbR.bbP;
        if (list != null) {
            list2 = this.bbR.bbP;
            list2.clear();
        }
        this.bbR.hide();
        aVar.dismiss();
    }
}
