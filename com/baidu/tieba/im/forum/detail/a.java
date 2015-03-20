package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aBl;
    final /* synthetic */ ForumDetailActivity bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumDetailActivity forumDetailActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.bcD = forumDetailActivity;
        this.aBl = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aBl.dismiss();
    }
}
