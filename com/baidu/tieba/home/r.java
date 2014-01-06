package com.baidu.tieba.home;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ ForumTopicActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ForumTopicActivity forumTopicActivity) {
        this.a = forumTopicActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
