package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ MultiContentView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MultiContentView multiContentView) {
        this.a = multiContentView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.d.b bVar;
        com.baidu.adp.lib.d.b bVar2;
        com.baidu.adp.lib.d.b bVar3;
        if (view2 instanceof h) {
            bVar3 = this.a.d;
            bVar3.a((com.baidu.adp.lib.d.b) ((h) view2));
        } else if (view2 instanceof c) {
            bVar2 = this.a.e;
            bVar2.a((com.baidu.adp.lib.d.b) ((c) view2));
        } else if (view2 instanceof bb) {
            bVar = this.a.f;
            bVar.a((com.baidu.adp.lib.d.b) ((bb) view2));
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
