package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/* loaded from: classes.dex */
class fp implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TabMenuPopView bmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(TabMenuPopView tabMenuPopView) {
        this.bmM = tabMenuPopView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.f.b bVar;
        if (view2 instanceof TextView) {
            bVar = this.bmM.aFP;
            bVar.k((TextView) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
