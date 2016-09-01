package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.f.b;
/* loaded from: classes.dex */
class dw implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TabMenuPopView bUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(TabMenuPopView tabMenuPopView) {
        this.bUj = tabMenuPopView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        b bVar;
        if (view2 instanceof TextView) {
            bVar = this.bUj.aJn;
            bVar.n((TextView) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
