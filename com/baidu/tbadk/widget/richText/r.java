package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TbRichTextView aFI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TbRichTextView tbRichTextView) {
        this.aFI = tbRichTextView;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.f.b bVar;
        com.baidu.adp.lib.f.b bVar2;
        com.baidu.adp.lib.f.b bVar3;
        com.baidu.adp.lib.f.b bVar4;
        com.baidu.adp.lib.f.b bVar5;
        com.baidu.adp.lib.f.b bVar6;
        com.baidu.adp.lib.f.b bVar7;
        com.baidu.adp.lib.f.b bVar8;
        com.baidu.adp.lib.f.b bVar9;
        com.baidu.adp.lib.f.b bVar10;
        com.baidu.adp.lib.f.b bVar11;
        com.baidu.adp.lib.f.b bVar12;
        if (view2 instanceof GifView) {
            bVar11 = this.aFI.aFa;
            if (bVar11 != null) {
                bVar12 = this.aFI.aFa;
                bVar12.k((GifView) view2);
                if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                    bVar10 = this.aFI.aEY;
                    bVar10.k(view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        bVar5 = this.aFI.aEZ;
                        if (bVar5 != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if (childAt instanceof TextView) {
                                        bVar8 = this.aFI.aEX;
                                        if (bVar8 != null) {
                                            bVar9 = this.aFI.aEX;
                                            bVar9.k((TextView) childAt);
                                        }
                                    }
                                    if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                                        bVar7 = this.aFI.aEY;
                                        bVar7.k(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            bVar6 = this.aFI.aEZ;
                            bVar6.k((LinearLayout) view2);
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
            bVar3 = this.aFI.aEW;
            if (bVar3 != null) {
                bVar4 = this.aFI.aEW;
                bVar4.k((ImageView) view2);
                if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                }
                if (view2 instanceof LinearLayout) {
                }
            }
        }
        if (view2 instanceof TextView) {
            bVar = this.aFI.aEX;
            if (bVar != null) {
                bVar2 = this.aFI.aEX;
                bVar2.k((TextView) view2);
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
