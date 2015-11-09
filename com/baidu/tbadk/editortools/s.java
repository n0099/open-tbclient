package com.baidu.tbadk.editortools;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.a;
/* loaded from: classes.dex */
class s implements a.InterfaceC0047a {
    final /* synthetic */ r apo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.apo = rVar;
    }

    @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0047a
    public View getView(int i, View view, ViewGroup viewGroup) {
        e dV;
        dV = this.apo.dV(i);
        if (dV.getLayoutParams() == null) {
            dV.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        return dV;
    }
}
