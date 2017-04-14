package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.e.b;
/* loaded from: classes.dex */
class cy implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TabMenuPopView bQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(TabMenuPopView tabMenuPopView) {
        this.bQN = tabMenuPopView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        b bVar;
        if (view2 instanceof TextView) {
            bVar = this.bQN.aNr;
            bVar.n((TextView) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
