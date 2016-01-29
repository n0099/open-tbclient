package com.baidu.tbadk.editortools;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.editortools.view.a;
/* loaded from: classes.dex */
class u implements a.InterfaceC0050a {
    final /* synthetic */ t atJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.atJ = tVar;
    }

    @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0050a
    public View getView(int i, View view, ViewGroup viewGroup) {
        e ey;
        ey = this.atJ.ey(i);
        if (ey.getLayoutParams() == null) {
            ey.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        return ey;
    }
}
