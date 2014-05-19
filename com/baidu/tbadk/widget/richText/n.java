package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TbRichTextView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView) {
        this.a = tbRichTextView;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        com.baidu.adp.lib.d.b bVar11;
        com.baidu.adp.lib.d.b bVar12;
        BdLog.d("pool return child");
        if (view2 instanceof GifView) {
            bVar11 = this.a.f;
            if (bVar11 != null) {
                bVar12 = this.a.f;
                bVar12.a((com.baidu.adp.lib.d.b) ((GifView) view2));
                if (view2 instanceof TextView) {
                    bVar9 = this.a.c;
                    if (bVar9 != null) {
                        bVar10 = this.a.c;
                        bVar10.a((com.baidu.adp.lib.d.b) ((TextView) view2));
                    }
                }
                if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                    bVar8 = this.a.d;
                    bVar8.a((com.baidu.adp.lib.d.b) view2);
                }
                if (!(view2 instanceof LinearLayout)) {
                    bVar3 = this.a.e;
                    if (bVar3 != null) {
                        int childCount = ((LinearLayout) view2).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = ((LinearLayout) view2).getChildAt(i);
                            if (childAt != null) {
                                if (childAt instanceof TextView) {
                                    bVar6 = this.a.c;
                                    if (bVar6 != null) {
                                        bVar7 = this.a.c;
                                        bVar7.a((com.baidu.adp.lib.d.b) ((TextView) childAt));
                                    }
                                }
                                if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                                    bVar5 = this.a.d;
                                    bVar5.a((com.baidu.adp.lib.d.b) childAt);
                                }
                            }
                        }
                        ((LinearLayout) view2).removeAllViews();
                        bVar4 = this.a.e;
                        bVar4.a((com.baidu.adp.lib.d.b) ((LinearLayout) view2));
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (view2 instanceof ImageView) {
            bVar = this.a.b;
            if (bVar != null) {
                bVar2 = this.a.b;
                bVar2.a((com.baidu.adp.lib.d.b) ((ImageView) view2));
            }
        }
        if (view2 instanceof TextView) {
        }
        if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
        }
        if (!(view2 instanceof LinearLayout)) {
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
