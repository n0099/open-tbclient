package com.baidu.tbadk.mvc.c.a;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ e anL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.anL = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.c.b u = com.baidu.tbadk.mvc.h.a.u(view);
        if (u != null) {
            u.setView(view);
            u.d(adapterView);
            u.dV(i);
            if (this.anL.dispatchMvcEvent(u)) {
            }
        }
    }
}
