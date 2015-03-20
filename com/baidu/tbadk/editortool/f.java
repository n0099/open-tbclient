package com.baidu.tbadk.editortool;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class f extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ e aiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aiu = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EmotionTabContentView emotionTabContentView;
        if (aVar != null) {
            emotionTabContentView = this.aiu.ais;
            View findViewWithTag = emotionTabContentView.findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                TbImageView tbImageView = (TbImageView) findViewWithTag;
                aVar.a(tbImageView);
                tbImageView.setTag(null);
            }
        }
    }
}
