package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements m {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.this$0 = nVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.m
    public void kb(int i) {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.this$0.aML;
        bdTypeListView.post(new s(this, i));
    }
}
