package com.baidu.tieba.flist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.d();
    }
}
