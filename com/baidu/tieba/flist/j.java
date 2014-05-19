package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        com.baidu.tbadk.editortool.ab abVar;
        com.baidu.tbadk.editortool.ab abVar2;
        i = this.a.z;
        if (i == 0) {
            BdListView bdListView = this.a.c.i;
            abVar2 = this.a.r;
            com.baidu.tbadk.core.util.ae.a(bdListView, abVar2, 1, -1);
            return;
        }
        BdListView bdListView2 = this.a.c.j;
        abVar = this.a.r;
        com.baidu.tbadk.core.util.ae.a(bdListView2, abVar, 1, -1);
    }
}
