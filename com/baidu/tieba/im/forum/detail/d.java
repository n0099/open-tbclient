package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ ForumDetailActivity baB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForumDetailActivity forumDetailActivity) {
        this.baB = forumDetailActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        mVar = this.baB.bax;
        mVar.setSwitch(true);
    }
}
