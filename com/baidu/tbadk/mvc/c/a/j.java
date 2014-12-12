package com.baidu.tbadk.mvc.c.a;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e adM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.adM = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.c.b s = com.baidu.tbadk.mvc.h.a.s(view);
        if (s != null) {
            s.setView(view);
            s.c(adapterView);
            s.dC(i);
            if (this.adM.dispatchMvcEvent(s)) {
                return true;
            }
        }
        return false;
    }
}
