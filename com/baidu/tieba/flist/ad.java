package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ap;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        com.baidu.tieba.util.i iVar;
        bdListView = this.a.a;
        iVar = this.a.f;
        ap.a(bdListView, iVar, 0, -1);
    }
}
