package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        GroupListAdapter groupListAdapter;
        bdListView = this.a.d;
        groupListAdapter = this.a.h;
        com.baidu.tbadk.core.util.ac.a(bdListView, groupListAdapter.b(), 0, -1);
    }
}
