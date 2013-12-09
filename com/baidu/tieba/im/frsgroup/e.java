package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupListFragment f1707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsGroupListFragment frsGroupListFragment) {
        this.f1707a = frsGroupListFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        GroupListAdapter groupListAdapter;
        bdListView = this.f1707a.d;
        groupListAdapter = this.f1707a.h;
        ah.a(bdListView, groupListAdapter.b(), 0, -1);
    }
}
