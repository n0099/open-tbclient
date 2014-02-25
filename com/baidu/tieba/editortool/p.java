package com.baidu.tieba.editortool;

import android.view.View;
import com.baidu.adp.widget.ImageView.BDImageView;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        EmotionTabContentView emotionTabContentView;
        emotionTabContentView = this.a.a;
        View findViewWithTag = emotionTabContentView.findViewWithTag(str);
        if (findViewWithTag != null && (findViewWithTag instanceof BDImageView) && bVar != null) {
            BDImageView bDImageView = (BDImageView) findViewWithTag;
            bVar.a(bDImageView);
            bDImageView.setTag(null);
        }
    }
}
