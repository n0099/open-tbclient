package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ ForumDetailActivity bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForumDetailActivity forumDetailActivity) {
        this.bcD = forumDetailActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        mVar = this.bcD.bcy;
        mVar.setSwitch(false);
    }
}
