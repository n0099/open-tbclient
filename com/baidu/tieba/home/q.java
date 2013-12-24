package com.baidu.tieba.home;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ ForumTopicActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ForumTopicActivity forumTopicActivity) {
        this.a = forumTopicActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
