package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aBt;
    final /* synthetic */ ForumDetailActivity bcT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumDetailActivity forumDetailActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.bcT = forumDetailActivity;
        this.aBt = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aBt.dismiss();
    }
}
