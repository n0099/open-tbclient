package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumRankActivity f1295a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ForumRankActivity forumRankActivity) {
        this.f1295a = forumRankActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        com.baidu.tieba.util.i iVar;
        bdListView = this.f1295a.f1286a;
        iVar = this.f1295a.f;
        com.baidu.tieba.util.ah.a(bdListView, iVar, 0, -1);
    }
}
