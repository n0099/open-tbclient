package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class ad implements Runnable {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        com.baidu.tbadk.editortool.aa aaVar;
        bdListView = this.a.a;
        aaVar = this.a.f;
        com.baidu.tbadk.core.util.ac.a(bdListView, aaVar, 0, -1);
    }
}
