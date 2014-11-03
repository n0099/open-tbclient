package com.baidu.tbadk.mvc.c.a;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ e XD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.XD = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.c.b t = com.baidu.tbadk.mvc.g.a.t(view);
        if (t != null) {
            t.setView(view);
            t.c(adapterView);
            t.di(i);
            if (this.XD.dispatchMvcEvent(t)) {
            }
        }
    }
}
