package com.baidu.tieba.flist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ ForumListActivity avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ForumListActivity forumListActivity) {
        this.avP = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.avP.DN();
    }
}
