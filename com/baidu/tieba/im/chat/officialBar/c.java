package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ MultiContentView aYw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MultiContentView multiContentView) {
        this.aYw = multiContentView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        com.baidu.adp.lib.e.b bVar3;
        if (view2 instanceof g) {
            bVar3 = this.aYw.aYr;
            bVar3.j((g) view2);
        } else if (view2 instanceof d) {
            bVar2 = this.aYw.aYs;
            bVar2.j((d) view2);
        } else if (view2 instanceof av) {
            bVar = this.aYw.aYt;
            bVar.j((av) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
