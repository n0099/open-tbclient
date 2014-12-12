package com.baidu.tieba.im.forum.detail;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ k aZq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aZq = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        ForumDetailActivity forumDetailActivity;
        aVar2 = this.aZq.aZp;
        aVar2.dismiss();
        forumDetailActivity = this.aZq.aZf;
        forumDetailActivity.clearHistory();
    }
}
