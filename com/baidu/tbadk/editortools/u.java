package com.baidu.tbadk.editortools;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.a;
/* loaded from: classes.dex */
class u implements a.InterfaceC0049a {
    final /* synthetic */ t asQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.asQ = tVar;
    }

    @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0049a
    public View getView(int i, View view, ViewGroup viewGroup) {
        e ed;
        ed = this.asQ.ed(i);
        if (ed.getLayoutParams() == null) {
            ed.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        return ed;
    }
}
