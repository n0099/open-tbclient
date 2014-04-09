package com.baidu.tieba.faceshop;

import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ap implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ao a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.a = aoVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        GifView gifView;
        GifView gifView2;
        GifView gifView3;
        gifView = this.a.y;
        Object tag = gifView.getTag();
        if (tag != null && (tag instanceof String) && ((String) tag).equals(str)) {
            if (bVar != null) {
                gifView3 = this.a.y;
                gifView3.setGif(bVar);
                return;
            }
            gifView2 = this.a.y;
            gifView2.setGif(null);
        }
    }
}
