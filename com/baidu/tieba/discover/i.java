package com.baidu.tieba.discover;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ a aBK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.aBK = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.j.d dVar;
        a aVar = this.aBK;
        dVar = this.aBK.aBB;
        aVar.b((com.baidu.tieba.discover.data.c) dVar.getItem(i));
    }
}
