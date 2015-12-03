package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ n bCM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bCM = nVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        if (uVar != null && (uVar instanceof com.baidu.tieba.hottopic.data.i)) {
            this.bCM.a((com.baidu.tieba.hottopic.data.i) uVar);
        }
    }
}
