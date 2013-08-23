package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumFeedActivity f1188a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumFeedActivity forumFeedActivity) {
        this.f1188a = forumFeedActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        if (!(obj instanceof com.baidu.tieba.model.s)) {
            if (obj != null) {
                this.f1188a.b(obj);
                return;
            } else {
                this.f1188a.m();
                return;
            }
        }
        this.f1188a.a(obj);
    }
}
