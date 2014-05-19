package com.baidu.tieba.flist;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdListView bdListView;
        LinearLayout linearLayout;
        r rVar;
        bdListView = this.a.a;
        linearLayout = this.a.h;
        bdListView.removeFooterView(linearLayout);
        rVar = this.a.c;
        rVar.a(100);
    }
}
