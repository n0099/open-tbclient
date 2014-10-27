package com.baidu.tieba.flist;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ ForumRankActivity awP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ForumRankActivity forumRankActivity) {
        this.awP = forumRankActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdListView bdListView;
        LinearLayout linearLayout;
        p pVar;
        bdListView = this.awP.vl;
        linearLayout = this.awP.awr;
        bdListView.removeFooterView(linearLayout);
        pVar = this.awP.awJ;
        pVar.eA(100);
    }
}
