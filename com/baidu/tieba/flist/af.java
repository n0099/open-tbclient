package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        ag agVar;
        BdListView bdListView;
        agVar = this.a.b;
        if (!agVar.LoadData()) {
            bdListView = this.a.a;
            bdListView.a();
        }
    }
}
