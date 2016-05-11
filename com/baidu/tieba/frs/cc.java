package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements a.b {
    final /* synthetic */ by biM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(by byVar) {
        this.biM = byVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        List list;
        List list2;
        list = this.biM.biJ;
        if (list != null) {
            list2 = this.biM.biJ;
            list2.clear();
        }
        this.biM.hide();
        aVar.dismiss();
    }
}
