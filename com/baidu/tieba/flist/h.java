package com.baidu.tieba.flist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.util.cb;
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
        cb.a(this.a, "forumlist_catalog", "catalogclick", 1, new Object[0]);
        this.a.c.t.dismiss();
        this.a.t = i;
        this.a.c.d();
        ArrayList<com.baidu.tieba.square.ab> arrayList = this.a.c.x.a().e;
        this.a.a(arrayList.get(i).b, arrayList.get(i).c, arrayList.get(i).a);
    }
}
