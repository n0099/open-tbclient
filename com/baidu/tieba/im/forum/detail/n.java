package com.baidu.tieba.im.forum.detail;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ m bdf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bdf = mVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        ForumDetailActivity forumDetailActivity;
        aVar2 = this.bdf.bde;
        aVar2.dismiss();
        forumDetailActivity = this.bdf.bcU;
        forumDetailActivity.clearHistory();
    }
}
