package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        ai aiVar;
        BdListView bdListView;
        aiVar = this.a.b;
        if (!aiVar.LoadData()) {
            bdListView = this.a.a;
            bdListView.a();
        }
    }
}
