package com.baidu.tieba.discover;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ a anL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.anL = aVar;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        if (z) {
            bdPullRefreshScrollView = this.anL.anv;
            bdPullRefreshScrollView.setRefreshing(1);
        }
    }
}
