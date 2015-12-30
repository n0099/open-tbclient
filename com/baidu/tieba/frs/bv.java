package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements a.b {
    final /* synthetic */ br bfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(br brVar) {
        this.bfQ = brVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        List list;
        List list2;
        list = this.bfQ.bfO;
        if (list != null) {
            list2 = this.bfQ.bfO;
            list2.clear();
        }
        this.bfQ.hide();
        aVar.dismiss();
    }
}
