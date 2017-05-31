package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdListView.e {
    final /* synthetic */ b cAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar) {
        this.cAU = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.cAU.LS();
    }
}
