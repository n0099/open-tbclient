package com.baidu.tieba.home;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ ForumTopicActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ForumTopicActivity forumTopicActivity) {
        this.a = forumTopicActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
