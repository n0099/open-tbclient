package com.baidu.tieba.im.forum.detail;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ m baN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.baN = mVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        ForumDetailActivity forumDetailActivity;
        aVar2 = this.baN.baM;
        aVar2.dismiss();
        forumDetailActivity = this.baN.baC;
        forumDetailActivity.clearHistory();
    }
}
