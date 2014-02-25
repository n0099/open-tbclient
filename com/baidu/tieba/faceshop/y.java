package com.baidu.tieba.faceshop;

import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.a = xVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        GifView gifView;
        GifView gifView2;
        GifView gifView3;
        gifView = this.a.x;
        Object tag = gifView.getTag();
        if (tag != null && (tag instanceof String) && ((String) tag).equals(str)) {
            if (bVar != null) {
                gifView3 = this.a.x;
                gifView3.setGif(bVar);
                return;
            }
            gifView2 = this.a.x;
            gifView2.setGif(null);
        }
    }
}
