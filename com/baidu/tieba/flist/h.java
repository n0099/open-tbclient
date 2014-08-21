package com.baidu.tieba.flist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(this.a, "forumlist_catalog", "catalogclick", 1, new Object[0]);
        com.baidu.adp.lib.e.e.a(this.a.c.u, this.a);
        this.a.r = i;
        this.a.c.d();
        ArrayList<com.baidu.tieba.square.w> arrayList = this.a.c.y.a().e;
        this.a.a(arrayList.get(i).b, arrayList.get(i).c, arrayList.get(i).a);
    }
}
