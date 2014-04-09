package com.baidu.tieba.faceshop;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
final class l implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ EmotionImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionImageActivity emotionImageActivity) {
        this.a = emotionImageActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        boolean z2;
        String str2;
        GifView gifView;
        z2 = this.a.q;
        if (!z2 && bVar != null) {
            str2 = this.a.k;
            if (str2.equals(str)) {
                gifView = this.a.b;
                gifView.setGif(bVar);
            }
        }
    }
}
