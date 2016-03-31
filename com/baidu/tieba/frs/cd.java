package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements a.b {
    final /* synthetic */ bz bnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bz bzVar) {
        this.bnj = bzVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        List list;
        List list2;
        list = this.bnj.bnh;
        if (list != null) {
            list2 = this.bnj.bnh;
            list2.clear();
        }
        this.bnj.hide();
        aVar.dismiss();
    }
}
