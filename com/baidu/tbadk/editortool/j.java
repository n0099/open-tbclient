package com.baidu.tbadk.editortool;

import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ EmotionTabContentView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(EmotionTabContentView emotionTabContentView) {
        this.a = emotionTabContentView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        GifView gifView;
        GifView gifView2;
        GifView gifView3;
        gifView = this.a.e;
        Object tag = gifView.getTag();
        if (tag != null && (tag instanceof String) && ((String) tag).equals(str)) {
            if (aVar != null) {
                gifView3 = this.a.e;
                gifView3.setGif(aVar);
                return;
            }
            gifView2 = this.a.e;
            gifView2.setGif(null);
        }
    }
}
