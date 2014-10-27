package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements AdapterView.OnItemClickListener {
    final /* synthetic */ am atV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.atV = amVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GridView gridView;
        gridView = this.atV.atL;
        gridView.setSelection(-1);
    }
}
