package com.baidu.tbadk.editortools.emotiontool;

import android.view.View;
import com.baidu.tbadk.editortools.emotiontool.EmotionTabContentView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ EmotionTabContentView.a apL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EmotionTabContentView.a aVar) {
        this.apL = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EmotionTabContentView emotionTabContentView;
        if (aVar != null) {
            emotionTabContentView = EmotionTabContentView.this;
            View findViewWithTag = emotionTabContentView.findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                TbImageView tbImageView = (TbImageView) findViewWithTag;
                aVar.a(tbImageView);
                tbImageView.setTag(null);
            }
        }
    }
}
