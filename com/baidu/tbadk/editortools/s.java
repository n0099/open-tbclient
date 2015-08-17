package com.baidu.tbadk.editortools;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.a;
/* loaded from: classes.dex */
class s implements a.InterfaceC0048a {
    final /* synthetic */ r aoW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.aoW = rVar;
    }

    @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0048a
    public View getView(int i, View view, ViewGroup viewGroup) {
        e dM;
        dM = this.aoW.dM(i);
        if (dM.getLayoutParams() == null) {
            dM.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        return dM;
    }
}
