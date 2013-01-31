package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ MarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MarkActivity markActivity) {
        this.a = markActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.a.h = (com.baidu.tieba.a.af) ((ListView) adapterView).getAdapter().getItem(i);
        this.a.i = i;
        this.a.c.show();
        return true;
    }
}
