package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbRichTextView f998a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbRichTextView tbRichTextView) {
        this.f998a = tbRichTextView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.d.b bVar;
        com.baidu.adp.lib.d.b bVar2;
        com.baidu.adp.lib.d.b bVar3;
        com.baidu.adp.lib.d.b bVar4;
        com.baidu.adp.lib.d.b bVar5;
        com.baidu.adp.lib.d.b bVar6;
        com.baidu.adp.lib.d.b bVar7;
        com.baidu.adp.lib.d.b bVar8;
        com.baidu.adp.lib.d.b bVar9;
        com.baidu.adp.lib.d.b bVar10;
        com.baidu.adp.lib.h.e.d("pool return child");
        if (view2 instanceof ImageView) {
            bVar9 = this.f998a.b;
            if (bVar9 != null) {
                bVar10 = this.f998a.b;
                bVar10.a((com.baidu.adp.lib.d.b) ((ImageView) view2));
            }
        }
        if (view2 instanceof TextView) {
            bVar7 = this.f998a.c;
            if (bVar7 != null) {
                bVar8 = this.f998a.c;
                bVar8.a((com.baidu.adp.lib.d.b) ((TextView) view2));
            }
        }
        if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
            bVar6 = this.f998a.d;
            bVar6.a((com.baidu.adp.lib.d.b) view2);
        }
        if (view2 instanceof LinearLayout) {
            bVar = this.f998a.e;
            if (bVar != null) {
                int childCount = ((LinearLayout) view2).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = ((LinearLayout) view2).getChildAt(i);
                    if (childAt != null) {
                        if (childAt instanceof TextView) {
                            bVar4 = this.f998a.c;
                            if (bVar4 != null) {
                                bVar5 = this.f998a.c;
                                bVar5.a((com.baidu.adp.lib.d.b) ((TextView) childAt));
                            }
                        }
                        if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                            bVar3 = this.f998a.d;
                            bVar3.a((com.baidu.adp.lib.d.b) childAt);
                        }
                    }
                }
                ((LinearLayout) view2).removeAllViews();
                bVar2 = this.f998a.e;
                bVar2.a((com.baidu.adp.lib.d.b) ((LinearLayout) view2));
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
