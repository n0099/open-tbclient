package com.baidu.tbadk.mvc.c.a;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e aej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.aej = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.c.b s = com.baidu.tbadk.mvc.h.a.s(view);
        if (s != null) {
            s.setView(view);
            s.c(adapterView);
            s.dI(i);
            if (this.aej.dispatchMvcEvent(s)) {
                return true;
            }
        }
        return false;
    }
}
