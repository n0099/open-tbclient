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
    final /* synthetic */ TbRichTextView aki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView) {
        this.aki = tbRichTextView;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        com.baidu.adp.lib.e.b bVar3;
        com.baidu.adp.lib.e.b bVar4;
        com.baidu.adp.lib.e.b bVar5;
        com.baidu.adp.lib.e.b bVar6;
        com.baidu.adp.lib.e.b bVar7;
        com.baidu.adp.lib.e.b bVar8;
        com.baidu.adp.lib.e.b bVar9;
        com.baidu.adp.lib.e.b bVar10;
        com.baidu.adp.lib.e.b bVar11;
        com.baidu.adp.lib.e.b bVar12;
        if (view2 instanceof GifView) {
            bVar11 = this.aki.ajH;
            if (bVar11 != null) {
                bVar12 = this.aki.ajH;
                bVar12.j((GifView) view2);
                if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                    bVar10 = this.aki.ajF;
                    bVar10.j(view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        bVar5 = this.aki.ajG;
                        if (bVar5 != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if (childAt instanceof TextView) {
                                        bVar8 = this.aki.ajE;
                                        if (bVar8 != null) {
                                            bVar9 = this.aki.ajE;
                                            bVar9.j((TextView) childAt);
                                        }
                                    }
                                    if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                                        bVar7 = this.aki.ajF;
                                        bVar7.j(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            bVar6 = this.aki.ajG;
                            bVar6.j((LinearLayout) view2);
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
            bVar3 = this.aki.ajD;
            if (bVar3 != null) {
                bVar4 = this.aki.ajD;
                bVar4.j((ImageView) view2);
                if (view2.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                }
                if (view2 instanceof LinearLayout) {
                }
            }
        }
        if (view2 instanceof TextView) {
            bVar = this.aki.ajE;
            if (bVar != null) {
                bVar2 = this.aki.ajE;
                bVar2.j((TextView) view2);
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
