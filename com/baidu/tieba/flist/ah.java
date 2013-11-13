package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumRankActivity f1243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ForumRankActivity forumRankActivity) {
        this.f1243a = forumRankActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        com.baidu.tieba.util.i iVar;
        bdListView = this.f1243a.f1234a;
        iVar = this.f1243a.f;
        com.baidu.tieba.util.ak.a(bdListView, iVar, 1, -1);
    }
}
