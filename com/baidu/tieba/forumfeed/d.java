package com.baidu.tieba.forumfeed;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumFeedActivity f1290a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForumFeedActivity forumFeedActivity) {
        this.f1290a = forumFeedActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1290a.Q();
    }
}
