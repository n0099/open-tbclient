package com.baidu.tieba.home;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumTopicActivity f1222a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ForumTopicActivity forumTopicActivity) {
        this.f1222a = forumTopicActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1222a.c();
    }
}
