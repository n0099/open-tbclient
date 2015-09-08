package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements a.d {
    final /* synthetic */ MultiImageView amq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MultiImageView multiImageView) {
        this.amq = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.d
    public void a(com.baidu.tbadk.widget.a aVar) {
        i iVar;
        boolean z;
        i iVar2;
        i iVar3;
        iVar = this.amq.amk;
        if (aVar == iVar.getCurrentView()) {
            z = this.amq.amo;
            if (z) {
                iVar2 = this.amq.amk;
                int childCount = iVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    iVar3 = this.amq.amk;
                    View childAt = iVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof ab) && ((ab) childAt).getImageView() != aVar) {
                        ((ab) childAt).release();
                    }
                }
            }
            aVar.play();
        }
    }
}
