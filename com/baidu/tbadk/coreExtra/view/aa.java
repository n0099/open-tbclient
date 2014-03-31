package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements com.baidu.tbadk.widget.e {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.e
    public final void a(com.baidu.tbadk.widget.a aVar) {
        n nVar;
        boolean z;
        n nVar2;
        n nVar3;
        nVar = this.a.e;
        if (aVar == nVar.getCurrentView()) {
            z = this.a.l;
            if (z) {
                nVar2 = this.a.e;
                int childCount = nVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    nVar3 = this.a.e;
                    View childAt = nVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof ah) && ((ah) childAt).getImageView() != aVar) {
                        ((ah) childAt).b();
                    }
                }
            }
            aVar.d();
        }
    }
}
