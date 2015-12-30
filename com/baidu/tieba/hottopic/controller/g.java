package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements r.a {
    final /* synthetic */ HotTopicActivity bGR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HotTopicActivity hotTopicActivity) {
        this.bGR = hotTopicActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.hottopic.view.a aVar;
        if (com.baidu.adp.lib.util.i.iQ()) {
            this.bGR.Vj();
            return;
        }
        HotTopicActivity hotTopicActivity = this.bGR;
        aVar = this.bGR.bGG;
        hotTopicActivity.showNetRefreshView(aVar.VF(), null);
    }
}
