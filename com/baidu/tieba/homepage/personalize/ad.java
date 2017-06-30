package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements w {
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar) {
        this.this$0 = xVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.w
    public void ko(int i) {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.this$0.mListView;
        bdTypeListView.post(new ae(this, i));
    }
}
