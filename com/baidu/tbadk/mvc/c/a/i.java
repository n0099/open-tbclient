package com.baidu.tbadk.mvc.c.a;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ e amA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.amA = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.c.b r = com.baidu.tbadk.mvc.h.a.r(view);
        if (r != null) {
            r.setView(view);
            r.d(adapterView);
            r.dL(i);
            if (this.amA.dispatchMvcEvent(r)) {
            }
        }
    }
}
