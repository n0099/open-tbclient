package com.baidu.tbadk.editortool;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class f extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ e ajC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ajC = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EmotionTabContentView emotionTabContentView;
        if (aVar != null) {
            emotionTabContentView = this.ajC.ajA;
            View findViewWithTag = emotionTabContentView.findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                TbImageView tbImageView = (TbImageView) findViewWithTag;
                aVar.a(tbImageView);
                tbImageView.setTag(null);
            }
        }
    }
}
