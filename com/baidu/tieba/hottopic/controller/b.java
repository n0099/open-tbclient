package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements r.a {
    final /* synthetic */ HotRanklistActivity bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HotRanklistActivity hotRanklistActivity) {
        this.bJY = hotRanklistActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        com.baidu.tieba.hottopic.view.b bVar;
        if (!com.baidu.adp.lib.util.i.iZ()) {
            HotRanklistActivity hotRanklistActivity = this.bJY;
            bVar = this.bJY.bJT;
            hotRanklistActivity.showNetRefreshView(bVar.Yb(), null);
            return;
        }
        this.bJY.Xs();
    }
}
