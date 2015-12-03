package com.baidu.tbadk.editortools;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.a;
/* loaded from: classes.dex */
class u implements a.InterfaceC0049a {
    final /* synthetic */ t arm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.arm = tVar;
    }

    @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0049a
    public View getView(int i, View view, ViewGroup viewGroup) {
        e ej;
        ej = this.arm.ej(i);
        if (ej.getLayoutParams() == null) {
            ej.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        return ej;
    }
}
