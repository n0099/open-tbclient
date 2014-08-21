package com.baidu.tieba.discover;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.view.r {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.core.view.r
    public void a(boolean z) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        if (z) {
            bdPullRefreshScrollView = this.a.q;
            bdPullRefreshScrollView.setRefreshing(1);
        }
    }
}
