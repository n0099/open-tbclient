package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.widget.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements b.d {
    final /* synthetic */ MultiImageView avg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MultiImageView multiImageView) {
        this.avg = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.b.d
    public void a(com.baidu.tbadk.widget.b bVar) {
        h hVar;
        boolean z;
        h hVar2;
        h hVar3;
        hVar = this.avg.auZ;
        if (bVar == hVar.getCurrentView()) {
            z = this.avg.avd;
            if (z) {
                hVar2 = this.avg.auZ;
                int childCount = hVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    hVar3 = this.avg.auZ;
                    View childAt = hVar3.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != bVar) {
                        ((u) childAt).release();
                    }
                }
            }
            bVar.play();
        }
    }
}
