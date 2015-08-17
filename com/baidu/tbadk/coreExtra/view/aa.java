package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements a.d {
    final /* synthetic */ MultiImageView alK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MultiImageView multiImageView) {
        this.alK = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.d
    public void a(com.baidu.tbadk.widget.a aVar) {
        i iVar;
        boolean z;
        i iVar2;
        i iVar3;
        iVar = this.alK.alE;
        if (aVar == iVar.getCurrentView()) {
            z = this.alK.alI;
            if (z) {
                iVar2 = this.alK.alE;
                int childCount = iVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    iVar3 = this.alK.alE;
                    View childAt = iVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof ae) && ((ae) childAt).getImageView() != aVar) {
                        ((ae) childAt).release();
                    }
                }
            }
            aVar.play();
        }
    }
}
