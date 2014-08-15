package com.baidu.tieba.flist;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdListView bdListView;
        LinearLayout linearLayout;
        p pVar;
        bdListView = this.a.a;
        linearLayout = this.a.g;
        bdListView.removeFooterView(linearLayout);
        pVar = this.a.c;
        pVar.a(100);
    }
}
