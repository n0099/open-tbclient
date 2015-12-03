package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements q.a {
    final /* synthetic */ HotTopicActivity bDn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HotTopicActivity hotTopicActivity) {
        this.bDn = hotTopicActivity;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.hottopic.view.a aVar;
        if (com.baidu.adp.lib.util.i.iP()) {
            this.bDn.Uh();
            return;
        }
        HotTopicActivity hotTopicActivity = this.bDn;
        aVar = this.bDn.bDc;
        hotTopicActivity.showNetRefreshView(aVar.UC(), null);
    }
}
