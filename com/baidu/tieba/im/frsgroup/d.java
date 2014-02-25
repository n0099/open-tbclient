package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        GroupListAdapter groupListAdapter;
        bdListView = this.a.e;
        groupListAdapter = this.a.i;
        ap.a(bdListView, groupListAdapter.b(), 0, -1);
    }
}
