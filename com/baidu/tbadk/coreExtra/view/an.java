package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.widget.e {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.e
    public void a(com.baidu.tbadk.widget.a aVar) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        oVar = this.a.e;
        if (aVar == oVar.getCurrentView()) {
            z = this.a.l;
            if (z) {
                oVar2 = this.a.e;
                int childCount = oVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    oVar3 = this.a.e;
                    View childAt = oVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof au) && ((au) childAt).getImageView() != aVar) {
                        ((au) childAt).d();
                    }
                }
            }
            aVar.e();
        }
    }
}
