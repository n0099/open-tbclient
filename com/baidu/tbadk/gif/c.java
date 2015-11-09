package com.baidu.tbadk.gif;
/* loaded from: classes.dex */
class c extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ GifView asx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GifView gifView) {
        this.asx = gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((c) aVar, str, i);
        this.asx.stopLoading();
        this.asx.setGif(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void aj(String str) {
        super.aj(str);
    }
}
