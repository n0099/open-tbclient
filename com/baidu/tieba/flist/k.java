package com.baidu.tieba.flist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ ForumListActivity avY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ForumListActivity forumListActivity) {
        this.avY = forumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.avY.DP();
    }
}
