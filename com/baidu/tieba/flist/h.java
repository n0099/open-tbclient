package com.baidu.tieba.flist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.a(this.a, "forumlist_catalog", "catalogclick", 1, new Object[0]);
        this.a.c.u.dismiss();
        this.a.t = i;
        this.a.c.b();
        ArrayList<com.baidu.tieba.square.ab> arrayList = this.a.c.y.a().e;
        ForumListActivity.a(this.a, arrayList.get(i).b, arrayList.get(i).c, arrayList.get(i).a);
    }
}
