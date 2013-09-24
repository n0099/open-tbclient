package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbRichTextView f847a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbRichTextView tbRichTextView) {
        this.f847a = tbRichTextView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.b.b bVar;
        com.baidu.adp.lib.b.b bVar2;
        com.baidu.adp.lib.b.b bVar3;
        com.baidu.adp.lib.b.b bVar4;
        com.baidu.adp.lib.b.b bVar5;
        com.baidu.adp.lib.f.d.c("pool return child");
        if (view2 instanceof ImageView) {
            bVar4 = this.f847a.f837a;
            if (bVar4 != null) {
                bVar5 = this.f847a.f837a;
                bVar5.a((com.baidu.adp.lib.b.b) ((ImageView) view2));
            }
        }
        if (view2 instanceof TextView) {
            bVar2 = this.f847a.b;
            if (bVar2 != null) {
                bVar3 = this.f847a.b;
                bVar3.a((com.baidu.adp.lib.b.b) ((TextView) view2));
            }
        }
        if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
            bVar = this.f847a.c;
            bVar.a((com.baidu.adp.lib.b.b) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
