package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.widget.g {
    final /* synthetic */ MultiImageView afC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(MultiImageView multiImageView) {
        this.afC = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.g
    public void a(com.baidu.tbadk.widget.a aVar) {
        p pVar;
        boolean z;
        p pVar2;
        p pVar3;
        pVar = this.afC.afw;
        if (aVar == pVar.getCurrentView()) {
            z = this.afC.afA;
            if (z) {
                pVar2 = this.afC.afw;
                int childCount = pVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    pVar3 = this.afC.afw;
                    View childAt = pVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof at) && ((at) childAt).getImageView() != aVar) {
                        ((at) childAt).release();
                    }
                }
            }
            aVar.play();
        }
    }
}
