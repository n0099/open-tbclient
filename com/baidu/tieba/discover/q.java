package com.baidu.tieba.discover;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ a aRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(a aVar) {
        this.aRT = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.g.d dVar;
        a aVar = this.aRT;
        dVar = this.aRT.aRG;
        aVar.b((com.baidu.tieba.discover.data.c) dVar.getItem(i));
    }
}
