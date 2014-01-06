package com.baidu.tieba.editortool;

import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ EmotionTabContentView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabContentView emotionTabContentView) {
        this.a = emotionTabContentView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        GifView gifView;
        GifView gifView2;
        GifView gifView3;
        GifView gifView4;
        gifView = this.a.e;
        Object tag = gifView.getTag();
        if (dVar == null || tag == null || !(tag instanceof String)) {
            gifView2 = this.a.e;
            gifView2.setGif(null);
        } else if (((String) tag).equals(str)) {
            gifView4 = this.a.e;
            gifView4.setGif(dVar);
        } else {
            gifView3 = this.a.e;
            gifView3.setGif(null);
        }
    }
}
