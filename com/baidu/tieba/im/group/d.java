package com.baidu.tieba.im.group;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements m {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tbadk.core.view.m
    public void a(boolean z) {
        BdListView bdListView;
        if (z) {
            bdListView = this.a.e;
            bdListView.e();
        }
    }
}
