package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        GroupListAdapter groupListAdapter;
        bdListView = this.a.e;
        groupListAdapter = this.a.i;
        aj.a(bdListView, groupListAdapter.b(), 0, -1);
    }
}
