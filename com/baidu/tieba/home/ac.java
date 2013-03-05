package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements AdapterView.OnItemClickListener {
    final /* synthetic */ MarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MarkActivity markActivity) {
        this.a = markActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.a.ac acVar;
        this.a.h = (com.baidu.tieba.a.ac) ((ListView) adapterView).getAdapter().getItem(i);
        acVar = this.a.h;
        if (acVar == null) {
            return;
        }
        this.a.k();
    }
}
