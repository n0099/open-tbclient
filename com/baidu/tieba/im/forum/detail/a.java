package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aRy;
    final /* synthetic */ ForumDetailActivity baB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumDetailActivity forumDetailActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.baB = forumDetailActivity;
        this.aRy = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aRy.dismiss();
    }
}
