package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class j implements Runnable {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        com.baidu.tbadk.editortool.aa aaVar;
        com.baidu.tbadk.editortool.aa aaVar2;
        i = this.a.z;
        if (i == 0) {
            BdListView bdListView = this.a.c.i;
            aaVar2 = this.a.r;
            com.baidu.tbadk.core.util.ac.a(bdListView, aaVar2, 1, -1);
            return;
        }
        BdListView bdListView2 = this.a.c.j;
        aaVar = this.a.r;
        com.baidu.tbadk.core.util.ac.a(bdListView2, aaVar, 1, -1);
    }
}
