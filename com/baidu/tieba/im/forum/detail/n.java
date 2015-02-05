package com.baidu.tieba.im.forum.detail;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ m baM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.baM = mVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        ForumDetailActivity forumDetailActivity;
        aVar2 = this.baM.baL;
        aVar2.dismiss();
        forumDetailActivity = this.baM.baB;
        forumDetailActivity.clearHistory();
    }
}
