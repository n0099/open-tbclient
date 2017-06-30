package com.baidu.tbadk.gif;

import com.baidu.tbadk.gif.GiftGifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ GiftGifView aDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GiftGifView giftGifView) {
        this.aDI = giftGifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        GiftGifView.a aVar2;
        super.onLoaded((d) aVar, str, i);
        if (aVar == null) {
            aVar2 = this.aDI.aDF;
            aVar2.DZ();
        }
        this.aDI.stopLoading();
        this.aDI.setGif(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onCancelled(String str) {
        super.onCancelled(str);
    }
}
