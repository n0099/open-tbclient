package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
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
        com.baidu.tbadk.editortool.ab abVar;
        bdListView = this.a.a;
        abVar = this.a.f;
        com.baidu.tbadk.core.util.ag.a(bdListView, abVar, 0, -1);
    }
}
