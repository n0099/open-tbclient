package com.baidu.tbadk.widget.layout;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class b implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ ConstrainImageGroup aGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ConstrainImageGroup constrainImageGroup) {
        this.aGV = constrainImageGroup;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.f.b bVar;
        com.baidu.adp.lib.f.b bVar2;
        if (view2 instanceof c) {
            bVar = this.aGV.aGN;
            if (bVar != null) {
                bVar2 = this.aGV.aGN;
                bVar2.n((c) view2);
            }
        }
    }
}
