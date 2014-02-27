package com.baidu.tieba.flist;

import android.view.View;
/* loaded from: classes.dex */
final class m implements View.OnClickListener {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ForumListActivity.w(this.a);
    }
}
