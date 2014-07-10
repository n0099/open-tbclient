package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aj;
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
        com.baidu.tbadk.editortool.aa aaVar;
        bdListView = this.a.a;
        aaVar = this.a.f;
        aj.a(bdListView, aaVar, 0, -1);
    }
}
