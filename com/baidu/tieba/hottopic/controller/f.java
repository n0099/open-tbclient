package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements p.a {
    final /* synthetic */ HotTopicActivity boA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HotTopicActivity hotTopicActivity) {
        this.boA = hotTopicActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.hottopic.view.a aVar;
        if (com.baidu.adp.lib.util.i.iM()) {
            this.boA.QM();
            return;
        }
        HotTopicActivity hotTopicActivity = this.boA;
        aVar = this.boA.boo;
        hotTopicActivity.showNetRefreshView(aVar.Ra(), null);
    }
}
