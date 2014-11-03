package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ MultiContentView aRc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MultiContentView multiContentView) {
        this.aRc = multiContentView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        com.baidu.adp.lib.e.b bVar3;
        if (view2 instanceof f) {
            bVar3 = this.aRc.aQX;
            bVar3.h((f) view2);
        } else if (view2 instanceof c) {
            bVar2 = this.aRc.aQY;
            bVar2.h((c) view2);
        } else if (view2 instanceof ba) {
            bVar = this.aRc.aQZ;
            bVar.h((ba) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
