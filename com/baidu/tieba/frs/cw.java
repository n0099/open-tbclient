package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.e.b;
/* loaded from: classes.dex */
class cw implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TabMenuPopView bQY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(TabMenuPopView tabMenuPopView) {
        this.bQY = tabMenuPopView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        b bVar;
        if (view2 instanceof TextView) {
            bVar = this.bQY.aNb;
            bVar.n((TextView) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
