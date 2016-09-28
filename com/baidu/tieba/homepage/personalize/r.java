package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements l {
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar) {
        this.this$0 = mVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.l
    public void jU(int i) {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.this$0.bCe;
        bdTypeListView.post(new s(this, i));
    }
}
