package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.d {
    final /* synthetic */ MultiImageView aoL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MultiImageView multiImageView) {
        this.aoL = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.d
    public void a(com.baidu.tbadk.widget.a aVar) {
        h hVar;
        boolean z;
        h hVar2;
        h hVar3;
        hVar = this.aoL.aoE;
        if (aVar == hVar.getCurrentView()) {
            z = this.aoL.aoI;
            if (z) {
                hVar2 = this.aoL.aoE;
                int childCount = hVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    hVar3 = this.aoL.aoE;
                    View childAt = hVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != aVar) {
                        ((u) childAt).release();
                    }
                }
            }
            aVar.play();
        }
    }
}
