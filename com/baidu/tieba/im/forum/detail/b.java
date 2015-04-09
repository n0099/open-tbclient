package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ ForumDetailActivity bcT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumDetailActivity forumDetailActivity) {
        this.bcT = forumDetailActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        mVar = this.bcT.bcO;
        mVar.setSwitch(false);
    }
}
