package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.widget.e {
    final /* synthetic */ MultiImageView OZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(MultiImageView multiImageView) {
        this.OZ = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.e
    public void a(com.baidu.tbadk.widget.a aVar) {
        p pVar;
        boolean z;
        p pVar2;
        p pVar3;
        pVar = this.OZ.OT;
        if (aVar == pVar.getCurrentView()) {
            z = this.OZ.OX;
            if (z) {
                pVar2 = this.OZ.OT;
                int childCount = pVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    pVar3 = this.OZ.OT;
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
