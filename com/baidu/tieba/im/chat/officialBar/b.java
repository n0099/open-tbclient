package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ MultiContentView aTP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MultiContentView multiContentView) {
        this.aTP = multiContentView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        com.baidu.adp.lib.e.b bVar3;
        if (view2 instanceof f) {
            bVar3 = this.aTP.aTK;
            bVar3.j((f) view2);
        } else if (view2 instanceof c) {
            bVar2 = this.aTP.aTL;
            bVar2.j((c) view2);
        } else if (view2 instanceof ar) {
            bVar = this.aTP.aTM;
            bVar.j((ar) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
