package com.baidu.tieba.discover;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ a anC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.anC = aVar;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        if (z) {
            bdPullRefreshScrollView = this.anC.anm;
            bdPullRefreshScrollView.setRefreshing(1);
        }
    }
}
