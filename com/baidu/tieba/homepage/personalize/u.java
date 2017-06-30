package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements BdListView.e {
    final /* synthetic */ i cIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(i iVar) {
        this.cIQ = iVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.cIQ.MG();
    }
}
