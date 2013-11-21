package com.baidu.tieba.flist;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumRankActivity f1243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ForumRankActivity forumRankActivity) {
        this.f1243a = forumRankActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdListView bdListView;
        LinearLayout linearLayout;
        s sVar;
        bdListView = this.f1243a.f1239a;
        linearLayout = this.f1243a.h;
        bdListView.removeFooterView(linearLayout);
        sVar = this.f1243a.c;
        sVar.a(100);
    }
}
