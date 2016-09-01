package com.baidu.tbadk.editortools;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
class v implements b.a {
    final /* synthetic */ u auO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.auO = uVar;
    }

    @Override // com.baidu.tbadk.editortools.view.b.a
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eA;
        eA = this.auO.eA(i);
        if (eA.getLayoutParams() == null) {
            eA.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        return eA;
    }
}
