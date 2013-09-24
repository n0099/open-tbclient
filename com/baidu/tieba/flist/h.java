package com.baidu.tieba.flist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForumListActivity forumListActivity) {
        this.f1060a = forumListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1060a, "forumlist_\tcatalog", "catalogclick", 1);
        }
        this.f1060a.c.t.dismiss();
        this.f1060a.t = i;
        ArrayList<com.baidu.tieba.square.s> arrayList = this.f1060a.c.x.a().e;
        this.f1060a.a(arrayList.get(i).b, arrayList.get(i).c, arrayList.get(i).f1853a);
    }
}
