package com.baidu.tieba.home;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumTopicActivity f934a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ForumTopicActivity forumTopicActivity) {
        this.f934a = forumTopicActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f934a.c();
    }
}
