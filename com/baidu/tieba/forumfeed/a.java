package com.baidu.tieba.forumfeed;

import com.baidu.tieba.model.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumFeedActivity f1230a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumFeedActivity forumFeedActivity) {
        this.f1230a = forumFeedActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        if (obj instanceof ac) {
            this.f1230a.a(obj);
        } else if (obj != null) {
            this.f1230a.b(obj);
        } else {
            this.f1230a.o();
        }
    }
}
