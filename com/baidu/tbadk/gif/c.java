package com.baidu.tbadk.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ GifView TN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GifView gifView) {
        this.TN = gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((c) aVar, str, i);
        this.TN.stopLoading();
        this.TN.setGif(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void aa(String str) {
        super.aa(str);
    }
}
