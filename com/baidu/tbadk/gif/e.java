package com.baidu.tbadk.gif;

import com.baidu.tbadk.gif.GiftGifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ GiftGifView auE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GiftGifView giftGifView) {
        this.auE = giftGifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        GiftGifView.a aVar2;
        super.a((e) aVar, str, i);
        if (aVar == null) {
            aVar2 = this.auE.auB;
            aVar2.CV();
        }
        this.auE.stopLoading();
        this.auE.setGif(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void an(String str) {
        super.an(str);
    }
}
