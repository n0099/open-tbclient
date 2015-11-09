package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/* loaded from: classes.dex */
class en implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TabMenuPopView aZV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(TabMenuPopView tabMenuPopView) {
        this.aZV = tabMenuPopView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        if (view2 instanceof TextView) {
            bVar = this.aZV.aAM;
            bVar.k((TextView) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
