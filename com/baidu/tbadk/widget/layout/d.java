package com.baidu.tbadk.widget.layout;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ c aFB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aFB = cVar;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof TbImageView) {
            bVar = this.aFB.aFu;
            if (bVar != null) {
                bVar2 = this.aFB.aFu;
                bVar2.n((TbImageView) view2);
            }
        }
    }
}
