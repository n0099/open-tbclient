package com.baidu.tieba.forumfeed;

import com.baidu.tieba.model.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumFeedActivity f1098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumFeedActivity forumFeedActivity) {
        this.f1098a = forumFeedActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        if (!(obj instanceof u)) {
            if (obj != null) {
                this.f1098a.b(obj);
                return;
            } else {
                this.f1098a.o();
                return;
            }
        }
        this.f1098a.a(obj);
    }
}
