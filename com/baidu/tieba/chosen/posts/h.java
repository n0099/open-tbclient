package com.baidu.tieba.chosen.posts;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ g aBs;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.aBs = gVar;
        this.aBt = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aBt.dismiss();
    }
}
