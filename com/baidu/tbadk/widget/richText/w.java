package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TbRichTextView aFD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbRichTextView tbRichTextView) {
        this.aFD = tbRichTextView;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
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
        com.baidu.adp.lib.f.b bVar15;
        com.baidu.adp.lib.f.b bVar16;
        com.baidu.adp.lib.f.b bVar17;
        com.baidu.adp.lib.f.b bVar18;
        if (view2 instanceof GifView) {
            bVar17 = this.aFD.aEN;
            if (bVar17 != null) {
                bVar18 = this.aFD.aEN;
                bVar18.k((GifView) view2);
                bVar9 = this.aFD.aEO;
                if (bVar9 != null && view2.getClass().getSimpleName().startsWith("TogetherHi")) {
                    bVar16 = this.aFD.aEO;
                    bVar16.k(view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        bVar10 = this.aFD.aEM;
                        if (bVar10 != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if (childAt instanceof TextView) {
                                        bVar14 = this.aFD.aEJ;
                                        if (bVar14 != null) {
                                            bVar15 = this.aFD.aEJ;
                                            bVar15.k((TextView) childAt);
                                        }
                                    }
                                    if (childAt instanceof PlayVoiceBnt) {
                                        bVar12 = this.aFD.aEL;
                                        if (bVar12 != null) {
                                            bVar13 = this.aFD.aEL;
                                            bVar13.k(childAt);
                                        }
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            bVar11 = this.aFD.aEM;
                            bVar11.k((LinearLayout) view2);
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
            bVar7 = this.aFD.aEI;
            if (bVar7 != null) {
                bVar8 = this.aFD.aEI;
                bVar8.k((ImageView) view2);
                bVar9 = this.aFD.aEO;
                if (bVar9 != null) {
                    bVar16 = this.aFD.aEO;
                    bVar16.k(view2);
                }
                if (view2 instanceof LinearLayout) {
                }
            }
        }
        if (view2 instanceof TextView) {
            bVar5 = this.aFD.aEJ;
            if (bVar5 != null) {
                bVar6 = this.aFD.aEJ;
                bVar6.k((TextView) view2);
                bVar9 = this.aFD.aEO;
                if (bVar9 != null) {
                }
                if (view2 instanceof LinearLayout) {
                }
            }
        }
        if (view2 instanceof PlayVoiceBnt) {
            bVar3 = this.aFD.aEL;
            if (bVar3 != null) {
                bVar4 = this.aFD.aEL;
                bVar4.k(view2);
                bVar9 = this.aFD.aEO;
                if (bVar9 != null) {
                }
                if (view2 instanceof LinearLayout) {
                }
            }
        }
        if (view2 instanceof com.baidu.tieba.graffiti.e) {
            bVar = this.aFD.aEK;
            if (bVar != null) {
                bVar2 = this.aFD.aEK;
                bVar2.k(view2);
            }
        }
        bVar9 = this.aFD.aEO;
        if (bVar9 != null) {
        }
        if (view2 instanceof LinearLayout) {
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
