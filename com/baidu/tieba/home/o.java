package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumFeedActivity f1191a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ForumFeedActivity forumFeedActivity) {
        this.f1191a = forumFeedActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1191a.q();
    }
}
