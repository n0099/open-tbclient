package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.f.b;
/* loaded from: classes.dex */
class da implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TabMenuPopView bWs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(TabMenuPopView tabMenuPopView) {
        this.bWs = tabMenuPopView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        b bVar;
        if (view2 instanceof TextView) {
            bVar = this.bWs.aJE;
            bVar.n((TextView) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
