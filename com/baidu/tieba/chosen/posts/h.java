package com.baidu.tieba.chosen.posts;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ g aBk;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aBl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.aBk = gVar;
        this.aBl = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aBl.dismiss();
    }
}
