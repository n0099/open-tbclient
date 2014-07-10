package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.widget.e {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.e
    public void a(com.baidu.tbadk.widget.a aVar) {
        q qVar;
        boolean z;
        q qVar2;
        q qVar3;
        qVar = this.a.e;
        if (aVar == qVar.getCurrentView()) {
            z = this.a.l;
            if (z) {
                qVar2 = this.a.e;
                int childCount = qVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    qVar3 = this.a.e;
                    View childAt = qVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof av) && ((av) childAt).getImageView() != aVar) {
                        ((av) childAt).d();
                    }
                }
            }
            aVar.e();
        }
    }
}
