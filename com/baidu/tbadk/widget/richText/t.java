package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TbRichTextView aJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TbRichTextView tbRichTextView) {
        this.aJw = tbRichTextView;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
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
        com.baidu.adp.lib.f.b bVar13;
        com.baidu.adp.lib.f.b bVar14;
        if (view2 instanceof GifView) {
            bVar13 = this.aJw.aIM;
            if (bVar13 != null) {
                bVar14 = this.aJw.aIM;
                bVar14.k((GifView) view2);
                if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                    bVar12 = this.aJw.aIK;
                    bVar12.k(view2);
                }
                bVar5 = this.aJw.aIJ;
                if (bVar5 != null && view2.getClass().getSimpleName().equals("GraffitiImageView")) {
                    bVar11 = this.aJw.aIJ;
                    bVar11.k(view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        bVar6 = this.aJw.aIL;
                        if (bVar6 != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if (childAt instanceof TextView) {
                                        bVar9 = this.aJw.aII;
                                        if (bVar9 != null) {
                                            bVar10 = this.aJw.aII;
                                            bVar10.k((TextView) childAt);
                                        }
                                    }
                                    if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                                        bVar8 = this.aJw.aIK;
                                        bVar8.k(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            bVar7 = this.aJw.aIL;
                            bVar7.k((LinearLayout) view2);
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
            bVar3 = this.aJw.aIH;
            if (bVar3 != null) {
                bVar4 = this.aJw.aIH;
                bVar4.k((ImageView) view2);
                if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                }
                bVar5 = this.aJw.aIJ;
                if (bVar5 != null) {
                    bVar11 = this.aJw.aIJ;
                    bVar11.k(view2);
                }
                if (view2 instanceof LinearLayout) {
                }
            }
        }
        if (view2 instanceof TextView) {
            bVar = this.aJw.aII;
            if (bVar != null) {
                bVar2 = this.aJw.aII;
                bVar2.k((TextView) view2);
            }
        }
        if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
        }
        bVar5 = this.aJw.aIJ;
        if (bVar5 != null) {
        }
        if (view2 instanceof LinearLayout) {
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
