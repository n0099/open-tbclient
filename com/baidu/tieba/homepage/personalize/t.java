package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements n {
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.this$0 = oVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.n
    public void kd(int i) {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.this$0.mListView;
        bdTypeListView.post(new u(this, i));
    }
}
