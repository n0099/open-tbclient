package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.widget.g {
    final /* synthetic */ MultiImageView Vn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MultiImageView multiImageView) {
        this.Vn = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.g
    public void a(com.baidu.tbadk.widget.a aVar) {
        p pVar;
        boolean z;
        p pVar2;
        p pVar3;
        pVar = this.Vn.Vh;
        if (aVar == pVar.getCurrentView()) {
            z = this.Vn.Vl;
            if (z) {
                pVar2 = this.Vn.Vh;
                int childCount = pVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    pVar3 = this.Vn.Vh;
                    View childAt = pVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof ax) && ((ax) childAt).getImageView() != aVar) {
                        ((ax) childAt).release();
                    }
                }
            }
            aVar.play();
        }
    }
}
