package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.widget.g {
    final /* synthetic */ MultiImageView agD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MultiImageView multiImageView) {
        this.agD = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.g
    public void a(com.baidu.tbadk.widget.a aVar) {
        p pVar;
        boolean z;
        p pVar2;
        p pVar3;
        pVar = this.agD.agx;
        if (aVar == pVar.getCurrentView()) {
            z = this.agD.agB;
            if (z) {
                pVar2 = this.agD.agx;
                int childCount = pVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    pVar3 = this.agD.agx;
                    View childAt = pVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof au) && ((au) childAt).getImageView() != aVar) {
                        ((au) childAt).release();
                    }
                }
            }
            aVar.play();
        }
    }
}
