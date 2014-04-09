package com.baidu.tieba.discover;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* loaded from: classes.dex */
final class e implements com.baidu.tbadk.core.view.m {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.core.view.m
    public final void a(boolean z) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        if (z) {
            bdPullRefreshScrollView = this.a.o;
            bdPullRefreshScrollView.setRefreshing(1);
        }
    }
}
