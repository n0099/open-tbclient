package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ ForumRankActivity awP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ForumRankActivity forumRankActivity) {
        this.awP = forumRankActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        ac acVar;
        BdListView bdListView;
        acVar = this.awP.awI;
        if (!acVar.LoadData()) {
            bdListView = this.awP.vl;
            bdListView.hN();
        }
    }
}
