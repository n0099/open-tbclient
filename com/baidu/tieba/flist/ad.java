package com.baidu.tieba.flist;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumRankActivity f1291a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ForumRankActivity forumRankActivity) {
        this.f1291a = forumRankActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        ai aiVar;
        BdListView bdListView;
        aiVar = this.f1291a.b;
        if (!aiVar.LoadData()) {
            bdListView = this.f1291a.f1286a;
            bdListView.a();
        }
    }
}
