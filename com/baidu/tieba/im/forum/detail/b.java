package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ ForumDetailActivity aZe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumDetailActivity forumDetailActivity) {
        this.aZe = forumDetailActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar;
        kVar = this.aZe.aZa;
        kVar.setSwitch(true);
    }
}
