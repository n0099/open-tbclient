package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ BannerView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BannerView bannerView) {
        this.a = bannerView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        c cVar;
        c cVar2;
        super.a((b) aVar, str, i);
        if (aVar == null) {
            this.a.g = true;
            this.a.setVisibility(8);
            cVar = this.a.j;
            if (cVar != null) {
                cVar2 = this.a.j;
                cVar2.b();
                return;
            }
            return;
        }
        this.a.setImg(aVar);
        this.a.setVisibility(0);
    }
}
