package com.baidu.tbadk.widget.layout;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class b implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ ConstrainImageGroup aMy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ConstrainImageGroup constrainImageGroup) {
        this.aMy = constrainImageGroup;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof c) {
            bVar = this.aMy.aMq;
            if (bVar != null) {
                bVar2 = this.aMy.aMq;
                bVar2.n((c) view2);
            }
        }
    }
}
