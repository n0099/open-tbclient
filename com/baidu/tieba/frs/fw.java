package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.f.b;
/* loaded from: classes.dex */
class fw implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TabMenuPopView bny;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(TabMenuPopView tabMenuPopView) {
        this.bny = tabMenuPopView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        b bVar;
        if (view2 instanceof TextView) {
            bVar = this.bny.aEJ;
            bVar.k((TextView) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
