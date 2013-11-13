package com.baidu.tieba.flist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1251a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumListActivity forumListActivity) {
        this.f1251a = forumListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1251a, "forumlist_\tcatalog", "catalogclick", 1);
        }
        this.f1251a.c.s.dismiss();
        this.f1251a.t = i;
        ArrayList<com.baidu.tieba.square.z> arrayList = this.f1251a.c.w.a().e;
        this.f1251a.a(arrayList.get(i).b, arrayList.get(i).c, arrayList.get(i).f2441a);
    }
}
