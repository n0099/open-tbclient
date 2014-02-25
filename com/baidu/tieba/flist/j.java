package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ap;
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
        com.baidu.tieba.util.i iVar;
        com.baidu.tieba.util.i iVar2;
        i = this.a.z;
        if (i == 0) {
            BdListView bdListView = this.a.c.h;
            iVar2 = this.a.r;
            ap.a(bdListView, iVar2, 1, -1);
            return;
        }
        BdListView bdListView2 = this.a.c.i;
        iVar = this.a.r;
        ap.a(bdListView2, iVar, 1, -1);
    }
}
