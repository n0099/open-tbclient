package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1256a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ForumListActivity forumListActivity) {
        this.f1256a = forumListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        com.baidu.tieba.util.i iVar;
        com.baidu.tieba.util.i iVar2;
        i = this.f1256a.z;
        if (i == 0) {
            BdListView bdListView = this.f1256a.c.g;
            iVar2 = this.f1256a.r;
            com.baidu.tieba.util.ak.a(bdListView, iVar2, 1, -1);
            return;
        }
        BdListView bdListView2 = this.f1256a.c.h;
        iVar = this.f1256a.r;
        com.baidu.tieba.util.ak.a(bdListView2, iVar, 1, -1);
    }
}
