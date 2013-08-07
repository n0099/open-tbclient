package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbRichTextView f812a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbRichTextView tbRichTextView) {
        this.f812a = tbRichTextView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.a.b bVar;
        com.baidu.adp.lib.a.b bVar2;
        com.baidu.adp.lib.a.b bVar3;
        com.baidu.adp.lib.a.b bVar4;
        com.baidu.adp.lib.e.d.c("pool return child");
        if (view2 instanceof ImageView) {
            bVar3 = this.f812a.f802a;
            if (bVar3 != null) {
                bVar4 = this.f812a.f802a;
                bVar4.a((ImageView) view2);
            }
        }
        if (view2 instanceof TextView) {
            bVar = this.f812a.b;
            if (bVar != null) {
                bVar2 = this.f812a.b;
                bVar2.a((TextView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
