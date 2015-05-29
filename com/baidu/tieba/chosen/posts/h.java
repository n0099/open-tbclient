package com.baidu.tieba.chosen.posts;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ g aDg;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.aDg = gVar;
        this.aDh = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aDh.dismiss();
    }
}
