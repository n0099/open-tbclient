package com.baidu.tbadk.editortools;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
class s implements b.a {
    final /* synthetic */ r auI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.auI = rVar;
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eD;
        eD = this.auI.eD(i);
        if (eD.getLayoutParams() == null) {
            eD.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        return eD;
    }
}
