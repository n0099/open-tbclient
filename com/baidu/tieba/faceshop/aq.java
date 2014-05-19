package com.baidu.tieba.faceshop;

import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.a = apVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        GifView gifView;
        GifView gifView2;
        GifView gifView3;
        gifView = this.a.y;
        Object tag = gifView.getTag();
        if (tag != null && (tag instanceof String) && ((String) tag).equals(str)) {
            if (aVar != null) {
                gifView3 = this.a.y;
                gifView3.setGif(aVar);
                return;
            }
            gifView2 = this.a.y;
            gifView2.setGif(null);
        }
    }
}
