package com.baidu.tbadk.editortools;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
class s implements b.a {
    final /* synthetic */ r azy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.azy = rVar;
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eC;
        eC = this.azy.eC(i);
        if (eC.getLayoutParams() == null) {
            eC.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        return eC;
    }
}
