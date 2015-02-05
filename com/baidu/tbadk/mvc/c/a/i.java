package com.baidu.tbadk.mvc.c.a;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ e aeg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.aeg = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.c.b s = com.baidu.tbadk.mvc.h.a.s(view);
        if (s != null) {
            s.setView(view);
            s.c(adapterView);
            s.dI(i);
            if (this.aeg.dispatchMvcEvent(s)) {
            }
        }
    }
}
