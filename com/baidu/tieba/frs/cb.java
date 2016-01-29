package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements a.b {
    final /* synthetic */ bx biy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bx bxVar) {
        this.biy = bxVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        List list;
        List list2;
        list = this.biy.biw;
        if (list != null) {
            list2 = this.biy.biw;
            list2.clear();
        }
        this.biy.hide();
        aVar.dismiss();
    }
}
