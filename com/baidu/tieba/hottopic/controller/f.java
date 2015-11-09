package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements p.a {
    final /* synthetic */ HotTopicActivity bpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HotTopicActivity hotTopicActivity) {
        this.bpp = hotTopicActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.hottopic.view.a aVar;
        if (com.baidu.adp.lib.util.i.iN()) {
            this.bpp.Re();
            return;
        }
        HotTopicActivity hotTopicActivity = this.bpp;
        aVar = this.bpp.bpd;
        hotTopicActivity.showNetRefreshView(aVar.Rs(), null);
    }
}
