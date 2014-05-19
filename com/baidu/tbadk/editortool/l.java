package com.baidu.tbadk.editortool;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        EmotionTabContentView emotionTabContentView;
        emotionTabContentView = this.a.a;
        View findViewWithTag = emotionTabContentView.findViewWithTag(str);
        if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && aVar != null) {
            TbImageView tbImageView = (TbImageView) findViewWithTag;
            aVar.a(tbImageView);
            tbImageView.setTag(null);
        }
    }
}
