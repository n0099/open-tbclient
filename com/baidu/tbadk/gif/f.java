package com.baidu.tbadk.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ GiftGifView amb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GiftGifView giftGifView) {
        this.amb = giftGifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        g gVar;
        super.a((f) aVar, str, i);
        if (aVar == null) {
            gVar = this.amb.alY;
            gVar.onFail();
        }
        this.amb.stopLoading();
        this.amb.setGif(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void am(String str) {
        super.am(str);
    }
}
