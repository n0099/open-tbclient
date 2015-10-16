package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements a.d {
    final /* synthetic */ MultiImageView akU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MultiImageView multiImageView) {
        this.akU = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.d
    public void a(com.baidu.tbadk.widget.a aVar) {
        i iVar;
        boolean z;
        i iVar2;
        i iVar3;
        iVar = this.akU.akO;
        if (aVar == iVar.getCurrentView()) {
            z = this.akU.akS;
            if (z) {
                iVar2 = this.akU.akO;
                int childCount = iVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    iVar3 = this.akU.akO;
                    View childAt = iVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof z) && ((z) childAt).getImageView() != aVar) {
                        ((z) childAt).release();
                    }
                }
            }
            aVar.play();
        }
    }
}
