package com.baidu.tbadk.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ GifView atC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GifView gifView) {
        this.atC = gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((c) aVar, str, i);
        this.atC.stopLoading();
        this.atC.setGif(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void af(String str) {
        super.af(str);
    }
}
