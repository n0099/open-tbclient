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
public class m implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ TbRichTextView aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbRichTextView tbRichTextView) {
        this.aOn = tbRichTextView;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
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
        com.baidu.adp.lib.e.b bVar13;
        com.baidu.adp.lib.e.b bVar14;
        com.baidu.adp.lib.e.b bVar15;
        com.baidu.adp.lib.e.b bVar16;
        com.baidu.adp.lib.e.b bVar17;
        com.baidu.adp.lib.e.b bVar18;
        com.baidu.adp.lib.e.b bVar19;
        com.baidu.adp.lib.e.b bVar20;
        if (view2 instanceof GifView) {
            bVar19 = this.aOn.aNx;
            if (bVar19 != null) {
                bVar20 = this.aOn.aNx;
                bVar20.n((GifView) view2);
                if (!(view2 instanceof LinearLayout)) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        bVar11 = this.aOn.aNw;
                        if (bVar11 != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if (childAt instanceof TextView) {
                                        bVar17 = this.aOn.aNt;
                                        if (bVar17 != null) {
                                            bVar18 = this.aOn.aNt;
                                            bVar18.n((TextView) childAt);
                                        }
                                    }
                                    if (childAt instanceof PlayVoiceBnt) {
                                        bVar15 = this.aOn.aNv;
                                        if (bVar15 != null) {
                                            bVar16 = this.aOn.aNv;
                                            bVar16.n(childAt);
                                        }
                                    }
                                    if (childAt instanceof PlayVoiceBntNew) {
                                        bVar13 = this.aOn.aNv;
                                        if (bVar13 != null) {
                                            bVar14 = this.aOn.aNv;
                                            bVar14.n(childAt);
                                        }
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            bVar12 = this.aOn.aNw;
                            bVar12.n((LinearLayout) view2);
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
            bVar9 = this.aOn.aNs;
            if (bVar9 != null) {
                bVar10 = this.aOn.aNs;
                bVar10.n((ImageView) view2);
                if (!(view2 instanceof LinearLayout)) {
                }
            }
        }
        if (view2 instanceof TextView) {
            bVar7 = this.aOn.aNt;
            if (bVar7 != null) {
                bVar8 = this.aOn.aNt;
                bVar8.n((TextView) view2);
                if (!(view2 instanceof LinearLayout)) {
                }
            }
        }
        if (view2 instanceof PlayVoiceBnt) {
            bVar5 = this.aOn.aNv;
            if (bVar5 != null) {
                bVar6 = this.aOn.aNv;
                bVar6.n(view2);
                if (!(view2 instanceof LinearLayout)) {
                }
            }
        }
        if (view2 instanceof com.baidu.tieba.graffiti.d) {
            bVar3 = this.aOn.aNu;
            if (bVar3 != null) {
                bVar4 = this.aOn.aNu;
                bVar4.n(view2);
                if (!(view2 instanceof LinearLayout)) {
                }
            }
        }
        if (view2 instanceof PlayVoiceBntNew) {
            bVar = this.aOn.aNv;
            if (bVar != null) {
                bVar2 = this.aOn.aNv;
                bVar2.n(view2);
            }
        }
        if (!(view2 instanceof LinearLayout)) {
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
