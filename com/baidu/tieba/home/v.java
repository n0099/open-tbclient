package com.baidu.tieba.home;
/* loaded from: classes.dex */
class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumTopicActivity f1466a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ForumTopicActivity forumTopicActivity) {
        this.f1466a = forumTopicActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1466a.b();
    }
}
