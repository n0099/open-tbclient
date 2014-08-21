package com.baidu.tieba.im.group;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements r {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.tbadk.core.view.r
    public void a(boolean z) {
        BdListView bdListView;
        if (z) {
            bdListView = this.a.e;
            bdListView.e();
        }
    }
}
