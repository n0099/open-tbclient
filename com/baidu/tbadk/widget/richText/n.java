package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TbRichTextView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView) {
        this.a = tbRichTextView;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
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
        if (view2 instanceof GifView) {
            bVar11 = this.a.f;
            if (bVar11 != null) {
                bVar12 = this.a.f;
                bVar12.a((com.baidu.adp.lib.d.b) ((GifView) view2));
                if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                    bVar10 = this.a.d;
                    bVar10.a((com.baidu.adp.lib.d.b) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        bVar5 = this.a.e;
                        if (bVar5 != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if (childAt instanceof TextView) {
                                        bVar8 = this.a.c;
                                        if (bVar8 != null) {
                                            bVar9 = this.a.c;
                                            bVar9.a((com.baidu.adp.lib.d.b) ((TextView) childAt));
                                        }
                                    }
                                    if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                                        bVar7 = this.a.d;
                                        bVar7.a((com.baidu.adp.lib.d.b) childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            bVar6 = this.a.e;
                            bVar6.a((com.baidu.adp.lib.d.b) ((LinearLayout) view2));
                            return;
                        }
                        return;
                    }
                    view2.setBackgroundDrawable(null);
                    return;
                }
                return;
            }
        }
        if (view2 instanceof ImageView) {
            bVar3 = this.a.b;
            if (bVar3 != null) {
                bVar4 = this.a.b;
                bVar4.a((com.baidu.adp.lib.d.b) ((ImageView) view2));
                if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                }
                if (view2 instanceof LinearLayout) {
                }
            }
        }
        if (view2 instanceof TextView) {
            bVar = this.a.c;
            if (bVar != null) {
                bVar2 = this.a.c;
                bVar2.a((com.baidu.adp.lib.d.b) ((TextView) view2));
            }
        }
        if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
        }
        if (view2 instanceof LinearLayout) {
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
