package com.baidu.tieba.flist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.a, "forumlist_\tcatalog", "catalogclick", 1);
        }
        this.a.c.t.dismiss();
        this.a.t = i;
        this.a.c.d();
        ArrayList<com.baidu.tieba.square.z> arrayList = this.a.c.x.a().e;
        this.a.a(arrayList.get(i).b, arrayList.get(i).c, arrayList.get(i).a);
    }
}
