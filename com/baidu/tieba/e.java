package com.baidu.tieba;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ c avi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.avi = cVar;
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
    }
}
