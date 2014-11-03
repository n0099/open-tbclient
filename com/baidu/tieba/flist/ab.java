package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ ForumRankActivity awY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ForumRankActivity forumRankActivity) {
        this.awY = forumRankActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        ac acVar;
        BdListView bdListView;
        acVar = this.awY.awR;
        if (!acVar.LoadData()) {
            bdListView = this.awY.vl;
            bdListView.hN();
        }
    }
}
