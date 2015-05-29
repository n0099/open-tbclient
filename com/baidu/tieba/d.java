package com.baidu.tieba;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ c avi;
    private final /* synthetic */ String avj;
    private final /* synthetic */ String avk;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, String str3) {
        this.avi = cVar;
        this.avj = str;
        this.val$url = str2;
        this.avk = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        b bVar;
        LogoActivity logoActivity;
        h hVar;
        aVar.dismiss();
        com.baidu.adp.lib.g.i hs = com.baidu.adp.lib.g.i.hs();
        bVar = this.avi.avh;
        logoActivity = bVar.avg;
        hVar = logoActivity.ave;
        hs.post(hVar);
        com.baidu.tbadk.download.b.ze().a(this.avj, this.val$url, this.avk, 0, 1111);
    }
}
