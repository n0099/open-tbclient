package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements r.a {
    final /* synthetic */ HotTopicActivity bKr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(HotTopicActivity hotTopicActivity) {
        this.bKr = hotTopicActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        com.baidu.tieba.hottopic.view.c cVar;
        if (com.baidu.adp.lib.util.i.iZ()) {
            this.bKr.Xy();
            return;
        }
        HotTopicActivity hotTopicActivity = this.bKr;
        cVar = this.bKr.bKf;
        hotTopicActivity.showNetRefreshView(cVar.Yb(), null, true);
    }
}
