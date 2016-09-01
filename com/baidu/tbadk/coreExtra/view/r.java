package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.d {
    final /* synthetic */ MultiImageView apt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MultiImageView multiImageView) {
        this.apt = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.d
    public void a(com.baidu.tbadk.widget.a aVar) {
        h hVar;
        boolean z;
        h hVar2;
        h hVar3;
        hVar = this.apt.apl;
        if (aVar == hVar.getCurrentView()) {
            z = this.apt.apq;
            if (z) {
                hVar2 = this.apt.apl;
                int childCount = hVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    hVar3 = this.apt.apl;
                    View childAt = hVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != aVar) {
                        ((u) childAt).release();
                    }
                }
            }
            aVar.play();
        }
    }
}
