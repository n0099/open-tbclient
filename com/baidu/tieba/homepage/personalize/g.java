package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a {
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.ctz = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.a
    public void jm(int i) {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.ctz.bqG;
        bdTypeListView.post(new h(this, i));
    }
}
