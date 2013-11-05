package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupListFragment f1562a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsGroupListFragment frsGroupListFragment) {
        this.f1562a = frsGroupListFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        GroupListAdapter groupListAdapter;
        bdListView = this.f1562a.d;
        groupListAdapter = this.f1562a.h;
        com.baidu.tieba.util.ab.a(bdListView, groupListAdapter.a(), 0, -1);
    }
}
