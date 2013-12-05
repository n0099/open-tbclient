package com.baidu.tieba.flist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1303a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumListActivity forumListActivity) {
        this.f1303a = forumListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.f1303a, "forumlist_\tcatalog", "catalogclick", 1);
        }
        this.f1303a.c.t.dismiss();
        this.f1303a.t = i;
        this.f1303a.c.d();
        ArrayList<com.baidu.tieba.square.z> arrayList = this.f1303a.c.x.a().e;
        this.f1303a.a(arrayList.get(i).b, arrayList.get(i).c, arrayList.get(i).f2541a);
    }
}
