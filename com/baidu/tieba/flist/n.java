package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1308a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ForumListActivity forumListActivity) {
        this.f1308a = forumListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        com.baidu.tieba.util.i iVar;
        com.baidu.tieba.util.i iVar2;
        i = this.f1308a.z;
        if (i == 0) {
            BdListView bdListView = this.f1308a.c.h;
            iVar2 = this.f1308a.r;
            com.baidu.tieba.util.ah.a(bdListView, iVar2, 1, -1);
            return;
        }
        BdListView bdListView2 = this.f1308a.c.i;
        iVar = this.f1308a.r;
        com.baidu.tieba.util.ah.a(bdListView2, iVar, 1, -1);
    }
}
