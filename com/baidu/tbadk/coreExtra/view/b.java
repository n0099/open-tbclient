package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ BannerView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BannerView bannerView) {
        this.a = bannerView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        this.a.setImg(bVar);
        this.a.setVisibility(0);
    }
}
