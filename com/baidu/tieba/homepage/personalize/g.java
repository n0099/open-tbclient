package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a {
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.this$0 = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.a
    public void jO(int i) {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.this$0.bBT;
        bdTypeListView.post(new h(this, i));
    }
}
