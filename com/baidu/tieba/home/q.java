package com.baidu.tieba.home;
/* loaded from: classes.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumTopicActivity f1502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ForumTopicActivity forumTopicActivity) {
        this.f1502a = forumTopicActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1502a.b();
    }
}
