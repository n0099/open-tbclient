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
        com.baidu.tieba.a.af afVar;
        this.a.h = (com.baidu.tieba.a.af) ((ListView) adapterView).getAdapter().getItem(i);
        afVar = this.a.h;
        if (afVar == null) {
            return;
        }
        this.a.k();
    }
}
