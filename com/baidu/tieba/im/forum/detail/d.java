package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ ForumDetailActivity baA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForumDetailActivity forumDetailActivity) {
        this.baA = forumDetailActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        mVar = this.baA.baw;
        mVar.setSwitch(true);
    }
}
