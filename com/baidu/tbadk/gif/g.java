package com.baidu.tbadk.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ GiftGifView ZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GiftGifView giftGifView) {
        this.ZW = giftGifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        h hVar;
        super.onLoaded((g) aVar, str, i);
        if (aVar == null) {
            hVar = this.ZW.ZT;
            hVar.onFail();
        }
        this.ZW.stopLoading();
        this.ZW.setGif(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onCancelled(String str) {
        super.onCancelled(str);
    }
}
