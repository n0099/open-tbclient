package com.baidu.tieba.editortool;

import android.view.View;
import com.baidu.adp.widget.ImageView.BDImageView;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        View findViewWithTag = this.a.a.findViewWithTag(str);
        if (findViewWithTag != null && (findViewWithTag instanceof BDImageView) && dVar != null) {
            BDImageView bDImageView = (BDImageView) findViewWithTag;
            dVar.a(bDImageView);
            bDImageView.setTag(null);
        }
    }
}
