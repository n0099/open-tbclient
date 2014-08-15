package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        ac acVar;
        BdListView bdListView;
        acVar = this.a.b;
        if (!acVar.LoadData()) {
            bdListView = this.a.a;
            bdListView.d();
        }
    }
}
