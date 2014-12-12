package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.widget.g {
    final /* synthetic */ MultiImageView UK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MultiImageView multiImageView) {
        this.UK = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.g
    public void a(com.baidu.tbadk.widget.a aVar) {
        p pVar;
        boolean z;
        p pVar2;
        p pVar3;
        pVar = this.UK.UE;
        if (aVar == pVar.getCurrentView()) {
            z = this.UK.UI;
            if (z) {
                pVar2 = this.UK.UE;
                int childCount = pVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    pVar3 = this.UK.UE;
                    View childAt = pVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof ay) && ((ay) childAt).getImageView() != aVar) {
                        ((ay) childAt).release();
                    }
                }
            }
            aVar.play();
        }
    }
}
