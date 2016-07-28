package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TbRichTextView aGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbRichTextView tbRichTextView) {
        this.aGW = tbRichTextView;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
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
        com.baidu.adp.lib.f.b bVar19;
        com.baidu.adp.lib.f.b bVar20;
        com.baidu.adp.lib.f.b bVar21;
        com.baidu.adp.lib.f.b bVar22;
        if (view2 instanceof GifView) {
            bVar21 = this.aGW.aGf;
            if (bVar21 != null) {
                bVar22 = this.aGW.aGf;
                bVar22.n((GifView) view2);
                bVar11 = this.aGW.aGg;
                if (bVar11 != null && view2.getClass().getSimpleName().startsWith("TogetherHi")) {
                    bVar20 = this.aGW.aGg;
                    bVar20.n(view2);
                }
                if (!(view2 instanceof LinearLayout)) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        bVar12 = this.aGW.aGe;
                        if (bVar12 != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if (childAt instanceof TextView) {
                                        bVar18 = this.aGW.aGb;
                                        if (bVar18 != null) {
                                            bVar19 = this.aGW.aGb;
                                            bVar19.n((TextView) childAt);
                                        }
                                    }
                                    if (childAt instanceof PlayVoiceBnt) {
                                        bVar16 = this.aGW.aGd;
                                        if (bVar16 != null) {
                                            bVar17 = this.aGW.aGd;
                                            bVar17.n(childAt);
                                        }
                                    }
                                    if (childAt instanceof PlayVoiceBntNew) {
                                        bVar14 = this.aGW.aGd;
                                        if (bVar14 != null) {
                                            bVar15 = this.aGW.aGd;
                                            bVar15.n(childAt);
                                        }
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            bVar13 = this.aGW.aGe;
                            bVar13.n((LinearLayout) view2);
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
            bVar9 = this.aGW.aGa;
            if (bVar9 != null) {
                bVar10 = this.aGW.aGa;
                bVar10.n((ImageView) view2);
                bVar11 = this.aGW.aGg;
                if (bVar11 != null) {
                    bVar20 = this.aGW.aGg;
                    bVar20.n(view2);
                }
                if (!(view2 instanceof LinearLayout)) {
                }
            }
        }
        if (view2 instanceof TextView) {
            bVar7 = this.aGW.aGb;
            if (bVar7 != null) {
                bVar8 = this.aGW.aGb;
                bVar8.n((TextView) view2);
                bVar11 = this.aGW.aGg;
                if (bVar11 != null) {
                }
                if (!(view2 instanceof LinearLayout)) {
                }
            }
        }
        if (view2 instanceof PlayVoiceBnt) {
            bVar5 = this.aGW.aGd;
            if (bVar5 != null) {
                bVar6 = this.aGW.aGd;
                bVar6.n(view2);
                bVar11 = this.aGW.aGg;
                if (bVar11 != null) {
                }
                if (!(view2 instanceof LinearLayout)) {
                }
            }
        }
        if (view2 instanceof com.baidu.tieba.graffiti.e) {
            bVar3 = this.aGW.aGc;
            if (bVar3 != null) {
                bVar4 = this.aGW.aGc;
                bVar4.n(view2);
                bVar11 = this.aGW.aGg;
                if (bVar11 != null) {
                }
                if (!(view2 instanceof LinearLayout)) {
                }
            }
        }
        if (view2 instanceof PlayVoiceBntNew) {
            bVar = this.aGW.aGd;
            if (bVar != null) {
                bVar2 = this.aGW.aGd;
                bVar2.n(view2);
            }
        }
        bVar11 = this.aGW.aGg;
        if (bVar11 != null) {
        }
        if (!(view2 instanceof LinearLayout)) {
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
