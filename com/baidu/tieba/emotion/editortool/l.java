package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ EmotionTabContentView.a bRt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.a aVar) {
        this.bRt = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EmotionTabContentView emotionTabContentView;
        if (aVar != null) {
            emotionTabContentView = EmotionTabContentView.this;
            View findViewWithTag = emotionTabContentView.findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                TbImageView tbImageView = (TbImageView) findViewWithTag;
                aVar.e(tbImageView);
                tbImageView.setTag(null);
            }
        }
    }
}
