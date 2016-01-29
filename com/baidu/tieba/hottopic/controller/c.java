package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements NoNetworkView.a {
    final /* synthetic */ HotRanklistActivity bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HotRanklistActivity hotRanklistActivity) {
        this.bJY = hotRanklistActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        d dVar;
        com.baidu.tieba.hottopic.view.b bVar;
        com.baidu.tieba.hottopic.view.b bVar2;
        if (z) {
            dVar = this.bJY.bJU;
            if (dVar != null) {
                HotRanklistActivity hotRanklistActivity = this.bJY;
                bVar = this.bJY.bJT;
                hotRanklistActivity.hideNetRefreshView(bVar.Yb());
                bVar2 = this.bJY.bJT;
                bVar2.XZ();
            }
        }
    }
}
