package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MarkActivity markActivity) {
        this.a = markActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.a.g = (com.baidu.tieba.a.ae) ((ListView) adapterView).getAdapter().getItem(i);
        this.a.h = i;
        this.a.b.show();
        return true;
    }
}
