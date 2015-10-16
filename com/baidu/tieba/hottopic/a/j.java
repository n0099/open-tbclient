package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.adp.widget.ListView.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements v {
    final /* synthetic */ i bom;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bom = iVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        if (uVar != null && (uVar instanceof com.baidu.tieba.hottopic.data.e)) {
            this.bom.a((com.baidu.tieba.hottopic.data.e) uVar);
        }
    }
}
