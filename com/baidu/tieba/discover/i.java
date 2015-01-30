package com.baidu.tieba.discover;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ a auc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.auc = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.j.c cVar;
        a aVar = this.auc;
        cVar = this.auc.atT;
        aVar.b((com.baidu.tieba.discover.data.c) cVar.getItem(i));
    }
}
