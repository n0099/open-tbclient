package com.baidu.tieba.forumfeed;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ ForumFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForumFeedActivity forumFeedActivity) {
        this.a = forumFeedActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.Q();
    }
}
