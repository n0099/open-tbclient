package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements AdapterView.OnItemClickListener {
    final /* synthetic */ MarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MarkActivity markActivity) {
        this.a = markActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.a.ae aeVar;
        this.a.g = (com.baidu.tieba.a.ae) ((ListView) adapterView).getAdapter().getItem(i);
        aeVar = this.a.g;
        if (aeVar != null) {
            this.a.i();
        }
    }
}
